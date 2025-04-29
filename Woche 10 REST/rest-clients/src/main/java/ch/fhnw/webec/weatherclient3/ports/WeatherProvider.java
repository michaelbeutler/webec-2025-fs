package ch.fhnw.webec.weatherclient3.ports;

import ch.fhnw.webec.weatherclient3.core.model.Location;
import ch.fhnw.webec.weatherclient3.core.model.Weather;

public interface WeatherProvider {
	Weather getWeatherForLocation(Location location);
}
