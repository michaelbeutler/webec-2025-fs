package ch.fhnw.webec.weatherclient3.core.model;

public class Weather {

	double temperature; // in °C
	double precipitationProbability; // as fraction (e.g. 0.01 for 1%)

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getPrecipitationProbability() {
		return precipitationProbability;
	}

	public void setPrecipitationProbability(double precipitationProbability) {
		this.precipitationProbability = precipitationProbability;
	}
}
