package com.example.restingcities.model;

import java.util.Collection;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class State {
	@Id
	@GeneratedValue
	private Long id;

	String abbreviation;
	String name;
	String motto;
	@Embedded
	private Fish fish;
	String url;

	@OneToMany(mappedBy = "state")
	private Collection<City> cities;

	public State() {

	}

	public State(String abbreviation, String name, String motto, Fish fish, String url) {
		this.abbreviation = abbreviation;
		this.name = name;
		this.motto = motto;
		this.fish = fish;
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public Collection<City> getCities() {
		return cities;
	}

	public String getName() {
		return name;
	}

	public String getMotto() {
		return motto;
	}

	public Fish getFish() {
		return fish;
	}

	public String getUrl() {
		return url;
	}
}
