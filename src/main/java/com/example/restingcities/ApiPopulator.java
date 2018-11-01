package com.example.restingcities;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.example.restingcities.model.City;
import com.example.restingcities.model.Fish;
import com.example.restingcities.model.State;
import com.example.restingcities.repository.ApiRepository;
import com.example.restingcities.repository.CityRepository;

@Service
public class ApiPopulator implements CommandLineRunner {
	@Resource
	CityRepository cityRepo;

	@Resource
	ApiRepository stateRepo;

	@Override
	public void run(String... args) throws Exception {
		Fish happyFish = new Fish("Happy Fish", "Icthius mays", "IMGURL");
		State ohio = new State("OH", "Ohio", "Birthplace of Aviation", happyFish, "/api/states/oh/cities");
		ohio = stateRepo.save(ohio);
		City columbus = new City("Columbus", 100, ohio);
		columbus = cityRepo.save(columbus);

		Fish cornfish = new Fish("Cornfish", "Icthius mays", "IMGURL");
		State indiana = new State("IN", "Indiana", "Land of Lincoln-Adjancent", cornfish, "/api/states/in/cities");
		indiana = stateRepo.save(indiana);
		City muncie = new City("Muncie", 12, indiana);
		muncie = cityRepo.save(muncie);

	}

}
