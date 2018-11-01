package com.example.restingcities.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class City {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int population;

	@JsonIgnore
	@ManyToOne
	private State state;

	public City() {
	}

	public City(String name, int population, State state) {
		this.name = name;
		this.population = population;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
	}

}