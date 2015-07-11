/*
 * Project 1 - OOPT
 * Ignacio José Codoñer Gil - st number : 0416040
 * */
package oopt.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.lang.reflect.Type;

import oopt.model.Forecast;
import oopt.model.WeatherData;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

/*
 * Layer that provides the access to the API to get the weather data
 * */
public class WeatherDataDAO {
	private static WeatherDataDAO uniqueInstance;
	
	private WeatherDataDAO() {
	}
	
	public static WeatherDataDAO getInstance(){
		if(uniqueInstance == null) {
			uniqueInstance = new WeatherDataDAO();
		}
		
		return uniqueInstance;
	}
	
	public WeatherData getWeatherDataByCity(String city){
		// Performing the API call and retieving the data in JSON format
		String data = getJSON("http://api.openweathermap.org/data/2.5/forecast/daily?q="+city+"&mode=json&units=metric&cnt=2", 0);
		
		WeatherData obj2Create;
		List<Forecast> listToCreate;
		Type fooType = new TypeToken<List<Forecast>>() {}.getType();
		
	    Gson gson = new Gson();
		
		JsonObject result = (JsonObject) new JsonParser().parse(data);
		
		// Checking if a city has been found
		if(result != null && result.get("cod").getAsString().toString().equals("200")) {
			String cityData = result.get("city").getAsJsonObject().toString();
			String weatherData = result.get("list").getAsJsonArray().toString();
			
			obj2Create = gson.fromJson(cityData, WeatherData.class);
			
			listToCreate = gson.fromJson(weatherData, fooType);
			
			obj2Create.setList(listToCreate);
					
			return obj2Create;
		} else {
			return null;
		}
	}
	
	// used from : http://stackoverflow.com/questions/10500775/parse-json-from-httpurlconnection-object
	public String getJSON(String url, int timeout) {
	    try {
	        URL u = new URL(url);
	        HttpURLConnection c = (HttpURLConnection) u.openConnection();
	        c.setRequestMethod("GET");
	        c.setRequestProperty("Content-length", "0");
	        c.setUseCaches(false);
	        c.setAllowUserInteraction(false);
	        c.setConnectTimeout(timeout);
	        c.setReadTimeout(timeout);
	        c.connect();
	        int status = c.getResponseCode();

	        switch (status) {
	            case 200:
	            case 201:
	                BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
	                StringBuilder sb = new StringBuilder();
	                String line;
	                while ((line = br.readLine()) != null) {
	                    sb.append(line+"\n");
	                }
	                br.close();
	                return sb.toString();
	        }

	    } catch (MalformedURLException ex) {
			ex.printStackTrace();
	    } catch (IOException ex) {
	    	ex.printStackTrace();
	    }
	    return null;
	}
	
}
