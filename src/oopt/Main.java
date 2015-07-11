package oopt;
/*
 * Project 1 - OOPT
 * Ignacio José Codoñer Gil - st number : 0416040
 * */

import java.util.Scanner;

import oopt.model.WeatherData;
import oopt.service.WeatherService;


public class Main {	
	public static void main(String[] args) {
		// Weather service provide the feature to look for the weather by city name
		WeatherService weatherService = WeatherService.getInstance();
		@SuppressWarnings("resource")
		Scanner userInputScanner = new Scanner(System.in);

		// Firstly we get the weather info from Lappeenranta
		WeatherData wData = weatherService.getWeatherDataByCity("Lappeenranta");
		// and show it
		if(wData != null) wData.display();
		
		String city;
		// Extra : Provide the weather from the city you type
		while(true) {
			System.out.print("From which city else do you want to know the weather? :");
			city = userInputScanner.nextLine();
			
			wData = weatherService.getWeatherDataByCity(city);
					
			if(wData != null) {
				wData.display();
			} else {
				System.out.println("The city does not exist. Try it again.");
			}
		}		
	}

}
