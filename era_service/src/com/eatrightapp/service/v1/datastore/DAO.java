//package com.eatrightapp.service.v1.datastore;
//
//import com.google.gson.FieldNamingPolicy;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.googlecode.objectify.ObjectifyService;
//import com.googlecode.objectify.helper.DAOBase;
//
//public class DAO extends DAOBase {
//	
//	// Please see http://code.google.com/p/objectify-appengine/wiki/IntroductionToObjectify
//	
//	static {
//		ObjectifyService.register(RestaurantDSO.class);
//		// TODO register all data objects here... 
//	}
//	
//	private Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
//
//	public Gson gson() {
//		return gson;
//	}
//	
// }
