package com.eatrightapp.external.era.v1;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class ERAService {

	private static Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

	//public final static String server = "http://10.0.2.2:8888";
	public final static String server = "http://homeweb.org:8888";

	public static Restaurant findRestaurant(String id) {
		String service = server + "/api/v1/restaurants/";

		try {
			HttpClient httpclient = new DefaultHttpClient();
			
			Log.d(ERAService.class.getName(), "calling " + service + id);
			HttpGet httpget = new HttpGet(service + id);
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();

			String result = EntityUtils.toString(entity);		
			Log.d(ERAService.class.getName(), "json result = " + result);
			
			Restaurant restaurant = gson.fromJson(result, Restaurant.class);
			Log.d(ERAService.class.getName(), "restaurant: " + restaurant);
			return restaurant;
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public static void updateRestaurant(Restaurant restaurant) {
		
	}
	

}
