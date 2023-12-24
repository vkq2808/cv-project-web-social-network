package snap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import snap.entities.User;
import snap.service.IUserService;

public class LoginController {

	@Autowired
	IUserService userService;

	@PostMapping("/register")
	public String register(HttpServletRequest req)
	{
		String user_id = (String) req.getAttribute("user_id");
		String user_pass = (String) req.getAttribute("user_pass");
		String user_phone = (String) req.getAttribute("user_phone");
		String user_email = (String) req.getAttribute("user_email");
		String user_name = (String) req.getAttribute("user_name");
		User user = new User()
				.setId(user_id)
				.setPhone(user_phone)
				.setEmail(user_email)
				.setName(user_name)
				.setPassword(user_pass);
		
		user = userService.addUser(user);
		
		return "home";
	}

}
