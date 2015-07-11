/*
 * Project 1 - OOPT
 * Ignacio José Codoñer Gil - st number : 0416040
 * */

package oopt.model;

import java.text.SimpleDateFormat;
import java.util.List;

/* Represents the object for the weather data in one city. It has the form of the JSON call output. */
public class WeatherData {
	public int id;
	public String name;
	public String country;
	public Coordinate coord;
	public int population;
	
	class Coordinate {			
		public float lon;
		public float lat;
	}
	
	private int cnt;
	
	private List<Forecast> list;

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public List<Forecast> getList() {
		return list;
	}

	public void setList(List<Forecast> list) {
		this.list = list;
	}
	
	public void display(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String[] when = new String[] {"Today", "Tomorrow"};
		String n1 = "\t";
		String n2 = n1 + "\t";
		
		System.out.println("Weather information in "+name+" ("+country+")");
		
		System.out.println("Location information");
		System.out.println("-------------------------------");
		System.out.println(n1+"Latitude : "+coord.lat);
		System.out.println(n1+"Longitude : "+coord.lon);
		
		System.out.println("Forecast information");
		System.out.println("-------------------------------");
		for(int i = 0; i < list.size(); ++i) {
			
			System.out.println(n1+when[i%when.length]+" ("+simpleDateFormat.format(list.get(i).getFormatedDate())+")");
			System.out.println(n1+"-------------------------------");
			
			System.out.println(n2+"Weather : "+list.get(i).getWeather()[0].getDescription());
			System.out.println(n2+"Temperature (min|max) : "+
				list.get(i).getTemp().getMin()+"º"+" | " +
				list.get(i).getTemp().getMax()+"º"
			);
			System.out.println(n2+"Temperature (morning|day|evening|night) : "+
				list.get(i).getTemp().getMorn()+"º"+" | " +
				list.get(i).getTemp().getDay()+"º"+" | "  +
				list.get(i).getTemp().getEve()+"º"+" | "  +
				list.get(i).getTemp().getNight()+"º"
			);
			System.out.println(n2+"Humidity : "+ list.get(i).getHumidity()+"%");
			System.out.println(n2+"Clouds : "+ list.get(i).getClouds()+"%");
			System.out.println(n2+"Rain : "+ list.get(i).getRain()+"%");
			System.out.println(n2+"Wind speed : "+ list.get(i).getSpeed()+" m/s");		
			
		}
	}
}
