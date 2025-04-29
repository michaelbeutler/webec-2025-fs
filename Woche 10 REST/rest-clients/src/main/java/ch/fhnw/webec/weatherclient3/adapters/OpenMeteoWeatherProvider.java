package ch.fhnw.webec.weatherclient3.adapters;

import ch.fhnw.webec.weatherclient3.core.model.Location;
import ch.fhnw.webec.weatherclient3.core.model.Weather;
import ch.fhnw.webec.weatherclient3.ports.WeatherProvider;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OpenMeteoWeatherProvider implements WeatherProvider {

	private static final String BASE_URI = "https://api.open-meteo.com/v1/";

	@Override
	public Weather getWeatherForLocation(Location location) {

		try (var client = HttpClient.newHttpClient()) {
			var uri = URI.create(BASE_URI + "forecast" +
				"?latitude=" + location.latitude() +
				"&longitude=" + location.longitude() +
				"&current=temperature_2m,precipitation_probability");
			var request = HttpRequest.newBuilder()
				.uri(uri)
				.header("Accept", "application/json")
				.build();
			System.out.println(request + "\n");

			var response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("Response from REST API:");
			System.out.println(response.statusCode());
			System.out.println(response.body() + "\n");

			if (response.statusCode() == 200) {
				var mapper = new ObjectMapper();
				var weather = mapper.readValue(response.body(), WeatherResponse.class);
				return MapResult(weather);
			}
		} catch (Exception e) {
			throw new RuntimeException("Could not retrieve weather information", e);
		}

		throw new RuntimeException("Could not retrieve weather information");
	}

	private static Weather MapResult(WeatherResponse weather) {
		var result = new Weather();

		switch (weather.units().temperature()) {
			case "°C" -> result.setTemperature(weather.current().temperature());
			case null, default -> throw new IllegalArgumentException("Unknown temperature unit: " + weather.units().temperature());
		}

		switch (weather.units().precipitation()) {
			case "%" -> {
				result.setPrecipitationProbability(weather.current().precipitation() / 100);
			}
			case null, default -> throw new IllegalArgumentException("Unknown precipitation unit: " + weather.units().precipitation());
		}
		return result;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	record WeatherResponse(
		@JsonProperty("current_units") Units units,
		CurrentWeather current) {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	record Units(
		@JsonProperty("temperature_2m") String temperature,
		@JsonProperty("precipitation_probability") String precipitation) {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	record CurrentWeather(
		@JsonProperty("temperature_2m") double temperature,
		@JsonProperty("precipitation_probability") double precipitation) {
	}
}
