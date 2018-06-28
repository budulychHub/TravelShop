package ua.com.travel.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ua.com.travel.service.UserService;

@Controller
public class CookieController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/buyBackpack/{id}")
	public String buyBackpack(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {

		userService.intoBasket(Integer.parseInt(id), request, response);

		return "redirect:/shopBackpack";
	}

	@GetMapping(value = "/basket")
	public String basket(Model model, HttpServletRequest request) {
		model.addAttribute("backpacks", userService.userBackpacksCookie(request));

		return "views-shop-basket";
	}

	@GetMapping("/deleteFromOrder/{id}")
	public String deleteCookie(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
		userService.deleteCookieFromOrder(id, request, response);
		return "redirect:/basket";
	}

	@GetMapping("/getOrder/{id}")
	public String getOrder(Principal principal, @PathVariable String id, HttpServletRequest request,
			HttpServletResponse response) {

		userService.getOrder(principal, id, request, response);

		return "redirect:/profile";
	}

}
