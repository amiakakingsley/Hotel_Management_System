package com.amiaka;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.amiaka.AccountService.AccountService;
import com.amiaka.FoodDto.AccountDto;
import com.amiaka.FoodDto.FoodDto;
import com.amiaka.FoodService.FoodService;
import com.amiaka.InitialDepoService.InitialDepoService;
import com.amiaka.Models.Food;
import com.amiaka.Models.InitialDeposite;
import com.amiaka.Models.Room;
import com.amiaka.Reposiroty.AccountRepo;
import com.amiaka.UserDto.RoomDto;



@Controller
public class HomeController {
	
	private final FoodService foodService;
	private final AccountService accountService;
	private final AccountRepo accountRepo;
	private final InitialDepoService depoService;
	

	public HomeController(FoodService foodService, 
			                    AccountService accountService, 
			                          AccountRepo accountRepo,
			                              InitialDepoService depoService) {
		super();
		this.foodService = foodService;
		this.accountService = accountService;
		this.accountRepo = accountRepo;
		this.depoService = depoService;
	}

	@PostMapping("/user/addFood")
	public String AddFood(Model model, FoodDto foodDto, Principal principal ) {
		String name = principal.getName();
		if(foodDto.getAmount() <= accountRepo.findByUsername(name).getBalance()) { 
			foodDto.setName(name);
		    accountService.MakeOrder(foodDto);
    	    return "redirect:/user/home?success";
		}	    	
		
		 return "redirect:/user/home?error";
	  }
	
	@GetMapping("/user/deposite")
	public String RegistrationPage(Model model, Principal principal) {
		List<InitialDeposite> pendingDeposites =
				 depoService.findByDeositorsName(principal.getName());
		model.addAttribute("pendingDeposites", pendingDeposites);
		return "deposite";
	}
	
	@PostMapping("/user/initial/deposite")
	public String InitialDeposite(AccountDto accountDto, Principal principal) {
		accountDto.setName(principal.getName());
		depoService.SaveIntialDepoSite(accountDto);
		return "redirect:/user/home?success";
	}
	
	
	@PostMapping("/admin/Approve/deposite")
	public String Deposite(long id) {	
		accountService.DepositeAmount(id);
		depoService.DeleteIntialDeposite(id);
		return "redirect:/admin/adminView";
	}
	
	@PostMapping("/admin/delete/deposite")
	public String DeleteDeposite(long id) {
		depoService.DeleteIntialDeposite(id);
		return "redirect:/admin/adminView";
	}
	
	
	@GetMapping("/user/dashboard")
	public String deshboard(Model model, Principal principal) {
		model.addAttribute("message", "welcome to my Food APP");
		model.addAttribute("message2", "Only for Admin User");
		
		List<Food> foods = foodService.findByName(principal.getName());
		model.addAttribute("foods", foods);
		model.addAttribute("balance", accountService.ShowBalance(principal.getName()));
		return "dashboard";
	}
	
	@GetMapping("/user/home")
	public String Home(Model model, Principal principal){
		model.addAttribute("name", principal.getName());
		return "home";
	}
	
	@GetMapping("/home/contact")
	public String conntact(Model model, Principal principal){
		model.addAttribute("name", principal.getName());
		return "contact";
	}
	
	

	@GetMapping("/home")
	public String Home2(){
		return "home";
	}
	
	
	@GetMapping("/user/transaction")
	public String Transactions(Model model, Principal principal){
		model.addAttribute("name", principal.getName());
		return "profile";
	}
	
	@GetMapping("/user/services")
	public String Service(Model model){
		return "services";
	}
	
	@GetMapping("/error")
	public String ErrorPAge() {
		return "redirect:/user/home?message2";
	}
}
