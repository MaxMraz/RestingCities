package com.example.restingcities.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.restingcities.model.State;

public interface ApiRepository extends CrudRepository<State, Long> {

	State findByAbbreviationIgnoreCase(String abbreviation);

}
