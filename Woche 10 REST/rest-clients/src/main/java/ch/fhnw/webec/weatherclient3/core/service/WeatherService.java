package ch.fhnw.webec.weatherclient3.core.service;

import ch.fhnw.webec.weatherclient3.core.model.Location;
import ch.fhnw.webec.weatherclient3.core.model.Weather;
import ch.fhnw.webec.weatherclient3.ports.WeatherProvider;

public class WeatherService {

	private final WeatherProvider weatherProvider;

	public WeatherService(WeatherProvider weatherProvider) {
		this.weatherProvider = weatherProvider;
	}

	public void getAndPrintWeather(Location location) {

		// The application core only interacts using the interface, it does not know anything about the actual implementation.
		Weather weather = weatherProvider.getWeatherForLocation(location);

		System.out.println("Data from WeatherProvider:");
		System.out.println("Temperature: " + weather.getTemperature() + " °C");
		System.out.println("Precipitation probability: " + (weather.getPrecipitationProbability() * 100) + " %");
	}

}
