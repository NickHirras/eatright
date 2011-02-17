package com.eatrightapp.android;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.eatrightapp.android.lazylist.ImageLoader;
import com.eatrightapp.external.yelp.v2.BusinessDetail;
import com.eatrightapp.external.yelp.v2.Coordinate;
import com.eatrightapp.external.yelp.v2.YelpService;
import com.eatrightapp.util.Convert;

public class RestaurantActivity extends Activity {

	private EatRightApp app;

	private ImageLoader imageLoader;
	
	private DecimalFormat distanceFormat = new DecimalFormat("#,##0.0");
	
	private TextView restaurantNameTV;
	private TextView addressTV;
	private ImageView ratingImageIV;
	private TextView reviewsQtyTV;
	private TextView distanceTV;
	private ImageView restaurantImageIV;
	private TextView snippetTextTV;
	private ImageView snippetImageIV;
	private ImageButton mapButton;
	private ImageButton directionsButton;
	private ImageButton callButton;
	private ImageButton walkingButton;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		app = (EatRightApp) getApplication();

		imageLoader = app.getImageLoader();
		
		setContentView(R.layout.restaurant);
		
		restaurantNameTV = (TextView) findViewById(R.id.Restaurant_RestaurantName);
		addressTV = (TextView) findViewById(R.id.Restaurant_Address);
		ratingImageIV = (ImageView) findViewById(R.id.Restaurant_RatingImage);
		reviewsQtyTV = (TextView) findViewById(R.id.Restaurant_ReviewsQty);
		distanceTV = (TextView) findViewById(R.id.Restaurant_Distance);		
		restaurantImageIV = (ImageView) findViewById(R.id.Restaurant_Image);
		mapButton = (ImageButton) findViewById(R.id.Restaurant_MapButton);
		directionsButton = (ImageButton) findViewById(R.id.Restaurant_DrivingDirectionsButton);
		callButton = (ImageButton) findViewById(R.id.Restaurant_CallButton);
		walkingButton = (ImageButton) findViewById(R.id.Restaurant_WalkingDirectionsButton);
		
		// TODO: This may need to be done in an asynctask with a progress dialog.
		BusinessDetail biz = YelpService.findBusiness(getIntent().getExtras().getString("com.eatrightapp.android.PlacesSearchActivity.YelpId"));
		
		restaurantNameTV.setText(biz.getName());
		
		if (biz.getLocation() != null && biz.getLocation().getDisplayAddress() != null) {
			StringBuilder address = new StringBuilder();
			for (String addrLine : biz.getLocation().getDisplayAddress()) {
				address.append(addrLine).append("\n");
			}
			addressTV.setText(address.toString());
		} else {
			addressTV.setText("");
		}

		if(biz.getRatingImgUrl() != null) {
			ratingImageIV.setTag(biz.getRatingImgUrl().toExternalForm());
			imageLoader.DisplayImage(biz.getRatingImgUrl().toExternalForm(), RestaurantActivity.this, ratingImageIV);			
		}

		reviewsQtyTV.setText(biz.getReviewCount() + " reviews");

		distanceTV.setText(distanceFormat.format(Convert.metersToMiles(biz.getDistance())) + " mi");
		
		if(biz.getImageUrl() != null) {
			restaurantImageIV.setTag(biz.getImageUrl().toExternalForm());
			imageLoader.DisplayImage(biz.getImageUrl().toExternalForm(), RestaurantActivity.this, restaurantImageIV);			
		}
		
		if(biz.getPhone() == null) {
			callButton.setEnabled(false);
		} else {
			final String phoneNumber = biz.getPhone();
			callButton.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					Intent dialer = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
					startActivity(dialer);
				}
			});
		}
		
		final String bizName = biz.getName();
		final Coordinate coordinate = biz.getLocation().getCoordinate();
		mapButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(android.content.Intent.ACTION_VIEW, 
					Uri.parse("geo:0,0?q=" + coordinate.getLatitude() + "," + coordinate.getLongitude() + " (" + bizName + ")" ));
				startActivity(intent);
			}
		});
	}
}
