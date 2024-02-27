package com.amiaka;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.amiaka.UserDto.ChangePasswordDto;
import com.amiaka.UserDto.UserDto;
import com.amiaka.UserService.UserService;



@Controller
public class RegistrationController {
   
	private final UserService userService;
	
	
	
	public RegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}


	@GetMapping("/register")
	public String RegistrationPage() {
		return "registrationForm";
	}
	
	@GetMapping("/login")
	public String Login() {
		return "login";
	}

	@GetMapping("/login/forgottenPassword")
	public String ForgottenPassword(Model model) {
		model.addAttribute("error", "error");
		return "forgottenPassword";
	}
	
	@PostMapping("/existingUser")
	public String ExistingUser(String email, Model model) {
		UserDto user = userService.findByEmail(email);
		if(user.getEmail().isEmpty()) {
			model.addAttribute("error", "User 404");
			return "redirect:/login/forgottenPassword?error";
		}	
		
		model.addAttribute("user", user);
		return "newPasswordPage";
	}
	
	@PostMapping("/changeNewPassword")
	public String ChangePassword(ChangePasswordDto newPassword, Model model) {
		if(newPassword.getPassword().equals(newPassword.getPassword2())) {
			userService.ChangePassword(newPassword);
			return "login";
		}
		else
		return "redirect:/login/forgottenPassword?error";
	}
	
	
	@PostMapping("/register")
	public String RegisterUser(UserDto userdto) {
		userService.SaveUser(userdto);
		return "login";
	}
	
}
