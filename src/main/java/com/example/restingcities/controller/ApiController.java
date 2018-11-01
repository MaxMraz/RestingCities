package com.example.restingcities.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.restingcities.model.City;
import com.example.restingcities.model.State;
import com.example.restingcities.repository.ApiRepository;

@RestController
public class ApiController {

	@Autowired
	ApiRepository stateRepo;

	@GetMapping("/api/states")
	public Iterable<State> showStates() {
		return stateRepo.findAll();
	}

	@GetMapping("/api/states/{abbreviation}")
	public State showStates(@PathVariable(value = "abbreviation") String abbreviation) {
		System.out.println(stateRepo.findByAbbreviationIgnoreCase(abbreviation));
		return stateRepo.findByAbbreviationIgnoreCase(abbreviation);
	}

	@GetMapping("/api/states/{abbreviation}/cities")
	public Collection<City> showCities(@PathVariable(value = "abbreviation") String abbreviation) {
		return stateRepo.findByAbbreviationIgnoreCase(abbreviation).getCities();
	}

}
