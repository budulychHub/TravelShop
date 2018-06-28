package ua.com.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.travel.dto.DtoUtilMapper;
import ua.com.travel.editor.ProviderEditor;
import ua.com.travel.entity.Provider;
import ua.com.travel.entity.SleepingBag;
import ua.com.travel.service.ProviderService;
import ua.com.travel.service.SleepingBagService;

@Controller
public class SleepingController {

	@Autowired
	private SleepingBagService sleepingBagService;
		
	@Autowired
	private ProviderService providerService;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder){
		binder.registerCustomEditor(Provider.class, new ProviderEditor(providerService));
	}
	
	@RequestMapping(value="/addSleepingBag", method=RequestMethod.GET)
	public String newSleepingBag (Model model){
		model.addAttribute("sleepingBag", new SleepingBag());
		model.addAttribute("providers", providerService.findAll());
		return "views-base-addSleepingBag";
	}
	
	@RequestMapping(value="/addSleepingBag", method=RequestMethod.POST)
	public String addSleepingBag(@ModelAttribute SleepingBag sleepingBag, Model model){
		try {
			sleepingBagService.save(sleepingBag);
		} catch (Exception e) {
			model.addAttribute("exception", e.getMessage()+" !!!! ");
			return "views-base-addSleepingBag";
		}
		return "redirect:/addSleepingBag";
	}
	
	
	@RequestMapping(value="/shopSleepingBag", method=RequestMethod.GET)
	public String shopSleep(Model model){
		model.addAttribute("sleepingBags", 
				DtoUtilMapper.sleepingBagToSleepingBagDtos(sleepingBagService.findAll()));
		return "views-shop-shopSleepingBag";
	}
	
	
	@RequestMapping(value="/showSleepingBag", method=RequestMethod.GET)
	public String showSleepingBag(Model model){
		model.addAttribute("sleepingBags", 
				sleepingBagService.findSleepingBagWithProvider());
		return "views-base-showSleepingBag";
	}
	
	
	@RequestMapping(value="deleteSleepingBag/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable int id){
		sleepingBagService.delete(id);
		return "redirect:/showSleepingBag";
	}
	
	@GetMapping("saveImgBag/{id}")
	public String saveImgBag(@PathVariable String idBag, @RequestParam MultipartFile multipartFile){
		
		sleepingBagService.saveImg(Integer.parseInt(idBag), multipartFile);
		
		return "redirect:/showSleepingBag";
	}
	
	
	
	
}
