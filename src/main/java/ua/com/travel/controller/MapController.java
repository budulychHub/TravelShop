package ua.com.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.travel.dto.DtoUtilMapper;
import ua.com.travel.editor.ProviderEditor;
import ua.com.travel.entity.Map;
import ua.com.travel.entity.Provider;
import ua.com.travel.service.MapService;
import ua.com.travel.service.ProviderService;

@Controller
public class MapController {

	@Autowired
	private MapService mapService;

	@Autowired
	private ProviderService providerService;

	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Provider.class, new ProviderEditor(providerService));
	}

	@RequestMapping(value = "/addMap", method = RequestMethod.GET)
	public String newMap(Model model) {
		model.addAttribute("map", new Map());
		model.addAttribute("providers", providerService.findAll());
		return "views-base-addMap";
	}

	@RequestMapping(value = "/addMap", method = RequestMethod.POST)
	public String addMap(@ModelAttribute Map map, Model model) {

		try {
			mapService.save(map);
		} catch (Exception e) {
			model.addAttribute("exception", e.getMessage() + " !!!! ");
			return "views-base-addMap";
		}
		return "redirect:/addMap";
	}

	@RequestMapping(value = "/shopMap", method = RequestMethod.GET)
	public String shopMap(Model model) {
		model.addAttribute("maps", DtoUtilMapper.mapToMapDtos(mapService.findAll()));
		return "views-shop-shopMap";
	}

	@RequestMapping(value = "/showMap", method = RequestMethod.GET)
	public String showMap(Model model) {
		model.addAttribute("maps", mapService.findMapWithProvider());
		return "views-base-showMap";
	}

	@RequestMapping(value = "deleteMap/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		mapService.delete(id);
		return "redirect:/showMap";
	}
}
