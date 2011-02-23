package com.eatrightapp.android;

import java.text.DecimalFormat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.util.Linkify;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.eatrightapp.android.lazylist.ImageLoader;
import com.eatrightapp.external.yelp.v2.BusinessDetail;
import com.eatrightapp.external.yelp.v2.YelpService;

public class RestaurantActivity extends Activity {

	private EatRightApp app;

	private ImageLoader imageLoader;
		
	private TextView restaurantNameTV;
	private TextView addressTV;
	private TextView mapTV;
	private ImageView ratingImageIV;
	private TextView reviewsQtyTV;
	private ImageView restaurantImageIV;
	private TextView snippetTextTV;
	private ImageView snippetImageIV;
	private TextView phoneTV;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		app = (EatRightApp) getApplication();

		imageLoader = app.getImageLoader();
		
		setContentView(R.layout.restaurant);
		
		restaurantNameTV = (TextView) findViewById(R.id.Restaurant_RestaurantName);
		addressTV = (TextView) findViewById(R.id.Restaurant_Address);
		mapTV = (TextView) findViewById(R.id.Restaurant_Map);
		ratingImageIV = (ImageView) findViewById(R.id.Restaurant_RatingImage);
		reviewsQtyTV = (TextView) findViewById(R.id.Restaurant_ReviewsQty);
		restaurantImageIV = (ImageView) findViewById(R.id.Restaurant_Image);
		phoneTV = (TextView) findViewById(R.id.Restaurant_Phone);
		
		// TODO: This may need to be done in an asynctask with a progress dialog.
		BusinessDetail biz = YelpService.findBusiness(getIntent().getExtras().getString("com.eatrightapp.android.PlacesSearchActivity.YelpId"));
		
		restaurantNameTV.setText(biz.getName());
		
		if (biz.getLocation() != null && biz.getLocation().getDisplayAddress() != null) {
			StringBuilder address = new StringBuilder();
			final StringBuilder mapAddress = new StringBuilder();
			for (String addrLine : biz.getLocation().getDisplayAddress()) {
				address.append(addrLine).append("<br />");
				mapAddress.append(addrLine).append(", ");
			}
			addressTV.setText(Html.fromHtml(address.toString()));
			mapTV.setText(Html.fromHtml(" (<a href=#>Map</a>) "));
			mapTV.setClickable(true);
			mapTV.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					try {
						Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + Uri.encode(mapAddress.toString())));
						startActivity(intent);
					} catch(ActivityNotFoundException ex) {
						AlertDialog.Builder builder = new AlertDialog.Builder(RestaurantActivity.this);
						builder.setMessage("Unable to launch a map.")
					       .setCancelable(true)
					       .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
					           public void onClick(DialogInterface dialog, int id) {
					        	   RestaurantActivity.this.finish();
					           }
					       });
						builder.show();
					}
				}
				
			});
		} else {
			addressTV.setText("");
			mapTV.setText("");
		}

		if(biz.getRatingImgUrl() != null) {
			ratingImageIV.setTag(biz.getRatingImgUrl().toExternalForm());
			imageLoader.DisplayImage(biz.getRatingImgUrl().toExternalForm(), RestaurantActivity.this, ratingImageIV);			
		}

		reviewsQtyTV.setAutoLinkMask(Linkify.WEB_URLS);
		reviewsQtyTV.setText(Html.fromHtml("<a href=" + biz.getMobileUrl() + ">" + biz.getReviewCount() + " Yelp user reviews...</a>"));
		final String bizMobileLink = biz.getMobileUrl().toExternalForm();
		reviewsQtyTV.setOnClickListener(new OnClickListener() {
	
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(bizMobileLink));
				startActivity(intent);				
			}
			
		});
		
		
		if(biz.getImageUrl() != null) {
			restaurantImageIV.setTag(biz.getImageUrl().toExternalForm());
			imageLoader.DisplayImage(biz.getImageUrl().toExternalForm(), RestaurantActivity.this, restaurantImageIV);			
		}
		
		if(biz.getDisplayPhone() == null) {
			phoneTV.setText("");
		} else {
			phoneTV.setText(biz.getDisplayPhone());
		}
				
	}
}
