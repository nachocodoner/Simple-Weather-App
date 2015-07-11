/*
 * Project 1 - OOPT
 * Ignacio José Codoñer Gil - st number : 0416040
 * */

package oopt.model;

import java.sql.Date;

/* Represents the forecast information of a concrete date */
public class Forecast {
	private long dt;
	
	private Temperature temp;
	private Weather[] weather;
	private float pressure;
	private float speed;
	private float deg;
	private float clouds;
	private float humidity;
	private float rain;
	
	class Weather {
		private float id;
		private String main;
		private String description;
		private String icon;
		public float getId() {
			return id;
		}
		public void setId(float id) {
			this.id = id;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public String getMain() {
			return main;
		}
		public void setMain(String main) {
			this.main = main;
		}
	}
	
	class Temperature {
		private float day;
		private float min;
		private float max;
		private float night;
		private float eve;
		private float morn;
		
		public float getDay() {
			return day;
		}
		public void setDay(float day) {
			this.day = day;
		}
		public float getMin() {
			return min;
		}
		public void setMin(float min) {
			this.min = min;
		}
		public float getMax() {
			return max;
		}
		public void setMax(float max) {
			this.max = max;
		}
		public float getNight() {
			return night;
		}
		public void setNight(float night) {
			this.night = night;
		}
		public float getEve() {
			return eve;
		}
		public void setEve(float eve) {
			this.eve = eve;
		}
		public float getMorn() {
			return morn;
		}
		public void setMorn(float morn) {
			this.morn = morn;
		}
	}
	
	public long getDt() {
		return dt;
	}
	public void setDt(int dt) {
		this.dt = dt;
	}
	public Date getFormatedDate() {
		return new Date(getDt()*1000);
	}
	public Temperature getTemp() {
		return temp;
	}
	public void setTemp(Temperature temp) {
		this.temp = temp;
	}
	public float getPressure() {
		return pressure;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public float getDeg() {
		return deg;
	}
	public void setDeg(float deg) {
		this.deg = deg;
	}
	public float getClouds() {
		return clouds;
	}
	public void setClouds(float clouds) {
		this.clouds = clouds;
	}
	public float getRain() {
		return rain;
	}
	public void setRain(float rain) {
		this.rain = rain;
	}
	public Weather[] getWeather() {
		return weather;
	}
	public void setWeather(Weather[] weather) {
		this.weather = weather;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	
	
}
