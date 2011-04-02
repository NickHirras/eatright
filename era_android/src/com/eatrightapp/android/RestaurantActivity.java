package com.eatrightapp.android;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.eatrightapp.android.lazylist.ImageLoader;
import com.eatrightapp.external.era.Dish;
import com.eatrightapp.external.era.ERAService;
import com.eatrightapp.external.era.RestaurantInfo;
import com.eatrightapp.external.yelp.v2.BusinessDetail;
import com.eatrightapp.external.yelp.v2.YelpService;

public class RestaurantActivity extends Activity {

	private EatRightApp app;
 
	private ImageLoader imageLoader;
		
	private TextView restaurantNameTV;
	private TextView addressTV;
	private ImageView ratingImageIV;
	private TextView reviewsQtyTV;
	private ImageView restaurantImageIV;
	private TextView snippetTextTV;
	private ImageView snippetImageIV;
	private TextView phoneTV; 
	private ImageButton mapBtn;
	private ImageButton dialBtn;
	private LinearLayout noChainDataExistsPanel;
	private Spinner chainSpinner;
	private LinearLayout chainDataExistsPanel;
	private TextView chainDataWrongLabelTV;
	private TextView chainDataWrongLinkTV;
	private LinearLayout dishesLayout;
	
	private LinearLayout dishRow(Dish dish, ViewGroup parent) {
		LayoutInflater myInflater = getLayoutInflater(); 
		View myView = myInflater.inflate(R.layout.dish, parent, false); 

		LinearLayout dishLayout;
		TextView dishTitleTV;

		dishLayout = (LinearLayout) myView.findViewById(R.id.Dish_Layout);
		dishTitleTV = (TextView) myView.findViewById(R.id.Dish_Title);

		dishTitleTV.setText(dish.getTitle());
		
		return dishLayout;
	}
	
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
		restaurantImageIV = (ImageView) findViewById(R.id.Restaurant_Image);
		phoneTV = (TextView) findViewById(R.id.Restaurant_Phone);
		mapBtn = (ImageButton) findViewById(R.id.Restaurant_MapButton);
		dialBtn = (ImageButton) findViewById(R.id.Restaurant_DialButton);
		noChainDataExistsPanel = (LinearLayout) findViewById(R.id.Restaurant_NoChainDataExistsPannel);
		chainSpinner = (Spinner) findViewById(R.id.Restaurant_ChainSpinner);
		chainDataExistsPanel = (LinearLayout) findViewById(R.id.Restaurant_ChainDataExistsPannel);
		chainDataWrongLabelTV = (TextView) findViewById(R.id.Restaurant_ChainDataLabel);
		chainDataWrongLinkTV = (TextView) findViewById(R.id.Restaurant_ChainDataWrongLink);
		dishesLayout = (LinearLayout) findViewById(R.id.Restaurant_DishesLayout);

		// TODO: This may need to be done in an asynctask with a progress dialog.
		String restaurantId = getIntent().getExtras().getString("com.eatrightapp.android.PlacesSearchActivity.YelpId");
		final BusinessDetail biz = YelpService.findBusiness(restaurantId);
		RestaurantInfo restaurantInfo = ERAService.findRestaurantInfo(restaurantId);
		List<Dish> dishes = null;
		if(restaurantInfo != null) {
			dishes = ERAService.findDishes(restaurantInfo.isFranchise(), restaurantInfo.isFranchise() ? restaurantInfo.getFranchiseId() : restaurantInfo.getId());
		}
		
		restaurantNameTV.setText(biz.getName());
		
		if (biz.getLocation() != null && biz.getLocation().getDisplayAddress() != null) {
			StringBuilder address = new StringBuilder();
			final StringBuilder mapAddress = new StringBuilder();
			for (String addrLine : biz.getLocation().getDisplayAddress()) {
				address.append(addrLine).append("<br />");
				mapAddress.append(addrLine).append(", ");
			}
			addressTV.setText(Html.fromHtml(address.toString()));
//			mapTV.setText(Html.fromHtml(" (<a href=#>Map</a>) "));
//			mapTV.setClickable(true);
			mapBtn.setEnabled(true);
			mapBtn.setOnClickListener(new OnClickListener() {

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
			mapBtn.setEnabled(false);
//			mapTV.setText("");
		}

		if(biz.getRatingImgUrl() != null) {
			ratingImageIV.setTag(biz.getRatingImgUrl().toExternalForm());
			imageLoader.DisplayImage(biz.getRatingImgUrl().toExternalForm(), RestaurantActivity.this, ratingImageIV);			
		}

		reviewsQtyTV.setAutoLinkMask(Linkify.WEB_URLS);
		reviewsQtyTV.setText(Html.fromHtml("<a href=" + biz.getMobileUrl() + ">Read " + biz.getReviewCount() + " Yelp user reviews...</a>"));
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
		
		if(biz.getPhone() == null) {
			dialBtn.setEnabled(false);
		} else {
			dialBtn.setEnabled(true);
			final String phone = biz.getPhone();
			dialBtn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					try {
						Intent intent = new Intent(android.content.Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
						startActivity(intent);
					} catch(ActivityNotFoundException ex) {
						AlertDialog.Builder builder = new AlertDialog.Builder(RestaurantActivity.this);
						builder.setMessage("Unable to launch dialer.")
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
		}
		
		if(restaurantInfo == null) {
			noChainDataExistsPanel.setVisibility(LinearLayout.VISIBLE);
			chainDataExistsPanel.setVisibility(LinearLayout.INVISIBLE);
			ArrayAdapter<CharSequence> chainSpinnerOptions = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item); 
			chainSpinnerOptions.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			chainSpinner.setAdapter(chainSpinnerOptions);
			chainSpinnerOptions.add("I don't know");
			chainSpinnerOptions.add("Yes");
			chainSpinnerOptions.add("No");
			chainSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> parent, View view,
						int selectedIndex, long selectedItemId) {
					// TODO Call web service to record value.
					if(selectedIndex > 0) {
						Toast.makeText(getApplicationContext(), "We'll make that change, thanks!", Toast.LENGTH_LONG).show();
						RestaurantInfo restaurantInfo = new RestaurantInfo();
						restaurantInfo.setId(biz.getId());
						restaurantInfo.setFranchise(selectedIndex == 1);
						restaurantInfo.setFranchiseId(biz.getFranchiseId());
						ERAService.updateRestaurantFranchise(restaurantInfo.getId(), restaurantInfo.isFranchise(), restaurantInfo.getFranchiseId());
					}
				} 

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// Do nothing...
				}
				
			});
		} else {
			noChainDataExistsPanel.setVisibility(LinearLayout.INVISIBLE);
			chainDataExistsPanel.setVisibility(LinearLayout.VISIBLE);
			if(restaurantInfo.isFranchise()) {			
				chainDataWrongLabelTV.setText(Html.fromHtml("This is a <em>chain restaurant</em>.  "));
			} else {		
				chainDataWrongLabelTV.setText(Html.fromHtml("This is not a <em>chain restaurant</em>.  "));
			}
			chainDataWrongLinkTV.setAutoLinkMask(Linkify.ALL);
			chainDataWrongLinkTV.setText(Html.fromHtml("<a href=#>Flag as inaccurate.</a>"));
			chainDataWrongLinkTV.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Call web service to flag this as inaccurate.			
					Toast.makeText(getApplicationContext(), "Marked for audit, thanks!", Toast.LENGTH_LONG).show(); 
				}
				
			});
		}

		if(dishes != null) {
			for(Dish dish : dishes) {
				dishesLayout.addView(dishRow(dish, dishesLayout));
			}
		}
		
	}
}
