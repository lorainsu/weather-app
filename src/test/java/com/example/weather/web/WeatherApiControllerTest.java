package com.example.weather.web;

import com.example.weather.integration.ows.Weather;
import com.example.weather.integration.ows.WeatherEntry;
import com.example.weather.integration.ows.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherApiController.class)
public class WeatherApiControllerTest {

	@MockBean
	private WeatherService weatherService;

	@Autowired
	private MockMvc mvc;

	@Test
	public void weather() throws Exception {
		Weather weather = new Weather();
		weather.setName("London");
		setWeatherEntry(weather, 286.72, 800, "01d", 1553675407L);
		given(this.weatherService.getWeather("uk", "london")).willReturn(weather);
		this.mvc.perform(get("/api/weather/now/uk/london"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name", is("London")))
			.andExpect(jsonPath("$.temperature", is(286.72)))
			.andExpect(jsonPath("$.weatherId", is(800)))
			.andExpect(jsonPath("$.weatherIcon", is("01d")));
		verify(this.weatherService).getWeather("uk", "london");
	}

	private static void setWeatherEntry(WeatherEntry entry, double temperature, int id, String icon, long timestamp) {
		entry.setTemperature(temperature);
		entry.setWeatherId(id);
		entry.setWeatherIcon(icon);
		entry.setDate(timestamp);
	}

}
