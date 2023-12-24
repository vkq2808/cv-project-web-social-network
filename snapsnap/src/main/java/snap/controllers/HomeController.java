package snap.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import snap.entities.Post;
import snap.entities.User;
import snap.service.*;
import snap.serviceImp.PostServiceImp;
import snap.serviceImp.UserServiceImp;
import snap.security.CheckValidiation;

@Controller
public class HomeController {
	@Autowired
	IPostService postService = new PostServiceImp();
	CheckValidiation CV = new CheckValidiation();
	@Autowired
	IUserService userService = new UserServiceImp();
	
	
	@GetMapping("/home")
	public String home(Model model) {
		System.out.println("test");
		// Xử lý logic và thêm các attribute vào model
		List<Post> posts = postService.getAllPosts();

		model.addAttribute("posts", posts);
		return "home";
	}

	@PostMapping("/home")
	public String login_home(Model model, HttpServletRequest req) {

		HttpSession ses = req.getSession();
		// Lấy giá trị user_id và user_pass từ request parameters (hoặc những nguồn khác
		// tùy vào cách bạn xử lý form)
		String user_id = req.getParameter("user_id");
		String user_pass = req.getParameter("user_pass");

		// Kiểm tra user_id hoặc user_pass có null hoặc rỗng không
		if (CV.isEmptyOrNull(user_id) || CV.isEmptyOrNull(user_pass)) {
			model.addAttribute("login_msg", "User ID hoặc Password không được để trống.");
			return home(model);
		}
		// Tiếp tục kiểm tra password bằng hàm findById (giả sử bạn có một
		// UserRepository)
		User user = userService.getUserById(user_id).orElse(null);

		if (user == null || !user.getPassword().equals(user_pass)) {
			model.addAttribute("login_msg", "User ID hoặc Password không đúng.");
			return home(model);
		}
		
		ses.setAttribute("user", user);
		
		return home(model);
	}
}