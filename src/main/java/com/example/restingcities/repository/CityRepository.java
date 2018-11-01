package com.example.restingcities.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.restingcities.model.City;

public interface CityRepository extends CrudRepository<City, Long> {

}