package cz.vsb.service;

import cz.vsb.City;
import cz.vsb.connector.WeatherApiConnector;
import cz.vsb.dto.WeatherApiDto;
import cz.vsb.dto.WeatherDto;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    public WeatherDto getWeatherForCity(City cityEnum) {
        WeatherApiConnector connector = new WeatherApiConnector();
//        WeatherApiDto currentWeather = connector.getWeatherForCity(cityEnum);
//        return transformDto(currentWeather);
        return transformDto(connector.getWeatherForCity(cityEnum));
    }

    private WeatherDto transformDto(WeatherApiDto weatherApiDto) {
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setWeather_description(weatherApiDto.getCurrent().getCondition().getText());
        weatherDto.setLocation(weatherApiDto.getLocation().getName());
        weatherDto.setTimestamp(weatherApiDto.getCurrent().getLast_updated());
        weatherDto.setTemp_celsius(weatherApiDto.getCurrent().getTemp_c());
        weatherDto.setWind_direction(weatherApiDto.getCurrent().getWind_dir());
        weatherDto.setRelative_humidity(weatherApiDto.getCurrent().getHumidity());
        weatherDto.setWind_speed_m_per_sec(weatherApiDto.getCurrent().getWind_kph() / 3.6);
        return weatherDto;
    }
}
