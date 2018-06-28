package ua.com.travel.controller;

import java.security.Principal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.travel.entity.User;
import ua.com.travel.service.MailSenderService;
import ua.com.travel.service.UserService;

@Controller
public class UserController {

	@Autowired
	private MailSenderService mailSenderService;
	
	@Autowired
	private UserService userService;
	
	
	
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Principal principal, Model model) {

		User user = userService.fetchUserWithBackpack(Integer.parseInt(principal.getName()));
		model.addAttribute("user", user);

		return "views-login-profile";
	}
	
	@GetMapping(value="/updateProfile")
	public String updatapro(Principal principal,
			Model model){
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		model.addAttribute("user", user);
		
		return "views-login-updateProfile";
	}
	
	
	@PostMapping(value="/updateProfile")
	public String updateProfile(Principal principal,
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String password){
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		userService.updateProfile(user);
		
		return "redirect:/profile";
	}
	
	
	@RequestMapping("/loginpage")
	public String login(){
		
		return "views-login-loginpage";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public String logout(){
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/registration")
    public String registration(Model model) {
		model.addAttribute("users", userService.findAll());
        model.addAttribute("user", new User());
 
        return "views-login-registration";
    }
	
	
	@RequestMapping(value = "/registration", method=RequestMethod.POST)
    public String registrationUser(@ModelAttribute User user, Model model) {
		
		String uuid = UUID.randomUUID().toString();
		
		user.setUUID(uuid);
		
		
		try{
        userService.save(user);
		}catch(Exception e){
			model.addAttribute("exception", e.getMessage()+" !!!! ");
		return "views-login-registration";
		}
		
		
		String theme = "thank`s for registration";
		String messege = "ql & hf http://localhost:8080/TravelShop/confirm/"+uuid;
		
		mailSenderService.sendMail(theme, messege, user.getEmail());
		
        return "redirect:/registration";
    }
	
	@RequestMapping(value="/confirm/{uuid}", method=RequestMethod.GET)
	public String saveSave (@PathVariable String uuid){
		
		User user = userService.findByUuid(uuid);
		user.setEnabled(true);
		
		userService.update(user);
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String loginprocesing(){
		
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public String saveImage(Principal principal,
							@RequestParam MultipartFile image, Model model){

		try {
			userService.saveImage(principal, image);
		} catch (Exception e) {
			model.addAttribute("exception", e.getMessage()+" !!!! ");
			return "views-login-updateProfile";
		}

		return "redirect:/profile";
	}
	
	
}
