package snap.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import snap.entities.Post;
import snap.service.*;
import snap.serviceImp.PostServiceImp;

@Controller
public class HomeController {
	@Autowired
	IPostService postService = new PostServiceImp();

	@GetMapping("/home")
	public String home(Model model) {
		System.out.println("test");
		// Xử lý logic và thêm các attribute vào model
		List<Post> posts = postService.getAllPosts();

		model.addAttribute("posts", posts);
		return "home";
	}
}