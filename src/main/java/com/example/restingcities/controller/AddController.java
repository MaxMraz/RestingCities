package com.example.restingcities.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.restingcities.model.City;
import com.example.restingcities.model.Fish;
import com.example.restingcities.model.State;
import com.example.restingcities.repository.ApiRepository;
import com.example.restingcities.repository.CityRepository;

@Controller
public class AddController {

	@Resource
	ApiRepository stateRepo;
	@Resource
	CityRepository cityRepo;

	@RequestMapping("/")
	public String showHome() {
		return "redirect:/states";
	}

	@RequestMapping("/states")
	public String showStates(Model model) {
		model.addAttribute("states", stateRepo.findAll());
		return "states";
	}

	@RequestMapping("/states/{id}")
	public String showAState(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("state", stateRepo.findById(id).get());
		return "state";
	}

	@RequestMapping("/states/add")
	public String showAddCity(Model model) {
		return "add";
	}

	@RequestMapping("/states/add-state")
	public String showAddState(Model model) {
		return "add-state";
	}

	@PostMapping("/states/{abbreviation}/cities/add")
	public String addCity(Model model, String cityName, int population, String abbreviation) {
		cityRepo.save(new City(cityName, population, stateRepo.findByAbbreviationIgnoreCase(abbreviation)));
		System.out.println(stateRepo.findByAbbreviationIgnoreCase(abbreviation));
		return "redirect:/states";
	}

	@PostMapping("/states")
	public String addState(Model model, String abbreviation, String name, String motto, String url, String fishName,
			String binomialNomencluture, String fishURL) {
		Fish fish = new Fish(fishName, binomialNomencluture, fishURL);
		stateRepo.save(new State(abbreviation, name, motto, fish, url));
		return "redirect:/states";
	}

}