package com.eatrightapp.external.era;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class ERAService {

	private static Gson gson = new GsonBuilder().create();

	//public final static String server = "http://10.0.2.2:8888";
	public final static String server = "http://homeweb.org:8888";

	public static RestaurantInfo findRestaurantInfo(String id) {
		String service = server + "/api/restaurant_info/";

		try {
			HttpClient httpclient = new DefaultHttpClient();
			
			HttpGet httpget = new HttpGet(service + id);
			httpget.setHeader("Accept", "application/json");
			HttpResponse response = httpclient.execute(httpget);
			
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND) {
				return null;
			}
			
			switch(response.getStatusLine().getStatusCode()) {
				case HttpStatus.SC_OK: 	
					HttpEntity entity = response.getEntity();	
					String result = EntityUtils.toString(entity);
					Log.d(ERAService.class.getName() + " .findRestaurantInfo()", result);
					RestaurantInfo restaurantInfo = gson.fromJson(result, RestaurantInfo.class);
					return restaurantInfo;
				default:
					return null;
			}

			
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
	
	public static RestaurantInfo updateRestaurantFranchise(String id, boolean franchise, String franchiseId) {
		String service = server + "/api/restaurant_info/update";
	    
		HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost(service);

	    try {
	    	httppost.setHeader("Accept", "application/json");
	        // Add your data
	        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
	        nameValuePairs.add(new BasicNameValuePair("id", id));
	        nameValuePairs.add(new BasicNameValuePair("franchise", Boolean.toString(franchise)));
	        nameValuePairs.add(new BasicNameValuePair("franchiseId", franchiseId));
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

	        // Execute HTTP Post Request
	        HttpResponse response = httpclient.execute(httppost);
	        HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);	
			Log.d(ERAService.class.getName() + ".updateRestaurantFranchise()", result);
			RestaurantInfo restaurantInfo = gson.fromJson(result, RestaurantInfo.class);
			return restaurantInfo;

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
	
	public static void flagRestaurantFranchise(String id) {
		
	}
	
	public static List<Dish> findDishes(boolean franchise, String id) {
		String service = server + "/api/dishes";

		try {
			HttpClient httpClient = new DefaultHttpClient();
			
			HttpGet httpGet = new HttpGet(service + "?franchise=" + franchise + "&id=" + id);
			httpGet.setHeader("Accept", "application/json");
			HttpResponse response = httpClient.execute(httpGet);
			
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_NOT_FOUND) {
				return null;
			}
			
			switch(response.getStatusLine().getStatusCode()) {
				case HttpStatus.SC_OK: 	
					HttpEntity entity = response.getEntity();	
					String result = EntityUtils.toString(entity);	
					Log.d(ERAService.class.getName() + ".findDishes()", result);

					DishSearchResult dishes = gson.fromJson(result, DishSearchResult.class);

					return dishes.getDish();
				default:
					return null;
			}

			
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
	


}
