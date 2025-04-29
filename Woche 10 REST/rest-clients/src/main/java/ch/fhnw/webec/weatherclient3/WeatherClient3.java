package ch.fhnw.webec.weatherclient3;

import ch.fhnw.webec.weatherclient3.adapters.OpenMeteoWeatherProvider;
import ch.fhnw.webec.weatherclient3.core.model.Location;
import ch.fhnw.webec.weatherclient3.core.service.WeatherService;

import java.io.IOException;
import java.util.Map;

/**
 * This version of the weather client has a clear separation of the core application and the REST Client by
 * using an interface defined from the application core perspective.
 *
 * Note how the mapping from the REST response format (WeatherResponse, etc.) to the Weather object required
 * by the application core happens in the WeatherProvider implementation, so that it's isolated from the application
 * core.
 */
public class WeatherClient3 {

	private static final Map<String, Location> CITY_LOCATIONS = Map.of(
		"Basel", new Location(47.56013141204476, 7.58970186827881),
		"Windisch", new Location(47.48101988584374, 8.21202947270268),
		"Locarno", new Location(46.16960630520142, 8.79593817784890),
		"St. Moritz", new Location(46.49237775748978, 9.83773353873480));

	public static void main(String[] args) throws IOException, InterruptedException {
		// dependency injection
		var service = new WeatherService(new OpenMeteoWeatherProvider());

		// use the service
		service.getAndPrintWeather(CITY_LOCATIONS.get("Windisch"));
	}

}
