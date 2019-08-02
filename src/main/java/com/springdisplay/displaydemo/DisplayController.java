package com.springdisplay.displaydemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DisplayController {

	@Value("${pets.list.uri}")
	private String petsListUri;

	@RequestMapping(value="/getPetsList", method=RequestMethod.GET)
	private String getPets(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(petsListUri, String.class);
		model.addAttribute("result", result);
//		System.out.println(result);
		return result;
	}
}
