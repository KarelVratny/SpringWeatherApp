package cz.vsb.connector;

import cz.vsb.City;
import cz.vsb.dto.WeatherApiDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class WeatherApiConnector {
//    https://api.weatherapi.com/v1/current.json?key=92655378ce574a39b6b75031241906&q=Ostrava&aqi=no

    private static String baseUrl = "https://api.weatherapi.com/";
    private static String urlParameters = "v1/current.json?key=";
    private static String apiKey = "92655378ce574a39b6b75031241906";
    private static String url = baseUrl + urlParameters + apiKey + "&q=";

    public WeatherApiDto getWeatherForCity(City city) {
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url + city);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<WeatherApiDto> response = template.getForEntity(uri, WeatherApiDto.class);
        return response.getBody();
    }
}
