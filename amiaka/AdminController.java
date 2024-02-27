package com.amiaka;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.amiaka.AccountService.AccountService;
import com.amiaka.InitialDepoService.InitialDepoService;
import com.amiaka.Models.InitialDeposite;

@Controller
public class AdminController {

	private final InitialDepoService depoService;
	public AdminController(InitialDepoService depoService,  AccountService accountService) {
		super();
		this.depoService = depoService;
	}

	@GetMapping("/admin/adminView")
	public String AdminPage(Model model) {
		model.addAttribute("message", "welcome Admin");
		InitialDeposite [] deposited = depoService.ReturnArraysDeposited();
		model.addAttribute("deposited", deposited);
		return "adminView";
	}
	
}
