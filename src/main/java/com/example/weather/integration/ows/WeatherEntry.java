package com.example.weather.integration.ows;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class WeatherEntry implements Serializable {

	private static final long serialVersionUID = -2812136805013178938L;

	private Date date;

	private double temperature;

	private Integer weatherId;

	private String weatherIcon;

	@JsonProperty("date")
	public Date getDate() {
		return this.date;
	}

	@JsonSetter("dt")
	public void setDate(long unixTime) {
		this.date = new Date(unixTime);
	}

	/**
	 * Return the temperature in Kelvin (K).
	 */
	public double getTemperature() {
		return this.temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	@JsonProperty("main")
	public void setMain(Map<String, Object> main) {
		setTemperature(Double.parseDouble(main.get("temp").toString()));
	}

	public Integer getWeatherId() {
		return this.weatherId;
	}

	public void setWeatherId(Integer weatherId) {
		this.weatherId = weatherId;
	}

	public String getWeatherIcon() {
		return this.weatherIcon;
	}

	public void setWeatherIcon(String weatherIcon) {
		this.weatherIcon = weatherIcon;
	}

	@JsonProperty("weather")
	public void setWeather(List<Map<String, Object>> weatherEntries) {
		Map<String, Object> weather = weatherEntries.get(0);
		setWeatherId((Integer) weather.get("id"));
		setWeatherIcon((String) weather.get("icon"));
	}

}
