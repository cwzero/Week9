package edu.nwtc;

public class State {
	protected String state = "";
	protected int population = 0;
	protected int relevant = 0;
	protected int estimate = 0;

	public State(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getRelevant() {
		return relevant;
	}

	public void setRelevant(int relevant) {
		this.relevant = relevant;
	}

	public int getEstimate() {
		return estimate;
	}

	public void setEstimate(int estimate) {
		this.estimate = estimate;
	}
}
