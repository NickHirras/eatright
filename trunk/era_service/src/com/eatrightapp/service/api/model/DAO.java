package com.eatrightapp.service.api.model;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.helper.DAOBase;

public class DAO extends DAOBase {

	// Please see
	// http://code.google.com/p/objectify-appengine/wiki/IntroductionToObjectify

	static {
		ObjectifyService.register(RestaurantInfo.class);
		// TODO register all data objects here...
	}

}
