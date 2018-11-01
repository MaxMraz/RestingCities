package com.example.restingcities.model;

import javax.persistence.Embeddable;

@Embeddable
public class Fish {
	private String fishName;
	private String binomialNomencluture;
	private String fishURL;

	public Fish() {
	}

	public Fish(String fishName, String binomialNomencluture, String fishURL) {
		this.fishName = fishName;
		this.binomialNomencluture = binomialNomencluture;
		this.fishURL = fishURL;
	}

	public String getFishName() {
		return fishName;
	}

	public String getBinomialNomencluture() {
		return binomialNomencluture;
	}

	public String getFishURL() {
		return fishURL;
	}

}
