/*
 * Project 1 - OOPT
 * Ignacio José Codoñer Gil - st number : 0416040
 * */

package oopt.service;

import oopt.dao.WeatherDataDAO;
import oopt.model.WeatherData;

public class WeatherService {
	private static WeatherService uniqueInstance;
	private WeatherDataDAO weatherDao;
	
	private WeatherService() {
		weatherDao = WeatherDataDAO.getInstance();
	}
	
	public static WeatherService getInstance(){
		if(uniqueInstance == null) {
			uniqueInstance = new WeatherService();
		}
		
		return uniqueInstance;
	}
	
	public WeatherData getWeatherDataByCity(String city){
		return weatherDao.getWeatherDataByCity(city);	
	}	
}
