package com.eatrightapp.util;

public class Convert {
	public static final double METERS_IN_ONE_MILE = 0.000621371192;

	public static double metersToMiles(double distance) {			
		return distance * METERS_IN_ONE_MILE;
	}
}
