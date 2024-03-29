package com.eatrightapp.android;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import com.eatrightapp.external.era.Dish;
import com.eatrightapp.external.era.ERAService;

public class CreateDishActivity extends Activity {
	private EatRightApp app;																			
	//private ImageLoader imageLoader;

	private ScrollView scroller;
	private EditText title;
	private EditText description;
	private EditText calories;
	private EditText protein;
	private EditText fat;
	private EditText carbohydrates;
	private Button save;
	private String restaurantId;
	private String franchiseId;
	private boolean franchise;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// activity = this;
		app = (EatRightApp) getApplication();
		//		app.getWaldo().start(getApplicationContext());
		//		imageLoader = app.getImageLoader();

		setContentView(R.layout.create_dish);
		scroller = (ScrollView) findViewById(R.id.CreateDish_Scroller);
		title = (EditText) findViewById(R.id.CreateDish_Title);
		description = (EditText) findViewById(R.id.CreateDish_Description);
		calories = (EditText) findViewById(R.id.CreateDish_Cals);
		protein = (EditText) findViewById(R.id.CreateDish_Prot);
		fat = (EditText) findViewById(R.id.CreateDish_Fat);
		carbohydrates = (EditText) findViewById(R.id.CreateDish_Carbs);
		save = (Button) findViewById(R.id.CreateDish_SaveBtn);
		
		restaurantId = getIntent().getExtras().getString("com.eatrightapp.android.CreateDishActivity.restaurantId");
		franchiseId = getIntent().getExtras().getString("com.eatrightapp.android.CreateDishActivity.franchiseId");
		franchise = getIntent().getExtras().getBoolean("com.eatrightapp.android.CreateDishActivity.isFranchise");
		
		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				saveNewDish();
				
			}
			
		});

	}

	protected void saveNewDish() {
		boolean valid = true;
		
		StringBuilder problems = new StringBuilder("Oops, please correct: \n");
		
		String _restaurantId = restaurantId;
		String _franchiseId = franchiseId;
		String _title = title.getText().toString();
		String _description = description.getText().toString();
		int _calories = 0;
		int _protein = 0;
		int _fat = 0;
		int _carbs = 0;
		
		if(_title == null || _title.trim().length() == 0) {
			valid = false;
			problems.append(" - Title is required.\n");
		}
		
		try {
			_calories = Math.round(Float.parseFloat(calories.getText().toString()));
		} catch(Exception ex) {
			valid = false;
			problems.append(" - Calories must be a valid number.\n");
		} finally {
			if(_calories < 0) {
				valid = false;
				problems.append(" - Calories must be at least 0.\n");				
			}
		}
		
		try {
			_protein = Math.round(Float.parseFloat(protein.getText().toString()));
		} catch(Exception ex) {
			valid = false;
			problems.append(" - Protein must be a valid number.\n");
		} finally {
			if(_protein < 0) {
				valid = false;
				problems.append(" - Protein must be at least 0.\n");
			}
		}
		
		try {
			_fat = Math.round(Float.parseFloat(fat.getText().toString()));
		} catch(Exception ex) {
			valid = false;
			problems.append(" - Fat must be a valid number.\n");
		} finally {
			if(_fat < 0) {
				valid = false;
				problems.append(" - Fat must be at least 0.\n");
			}
		}
		
		try {
			_carbs = Math.round(Float.parseFloat(carbohydrates.getText().toString()));
		} catch(Exception ex) {
			valid = false;
			problems.append(" - Carbs must be a valid number.\n");
		} finally {
			if(_carbs < 0) {
				problems.append(" - Carbs must be at least 0.\n");
			}
		}
		
		if(valid) {
					
			Dish dish = ERAService.createDish(_restaurantId, _franchiseId, _title, _description, 
					_calories, _protein, _fat, _carbs);
			
			if(dish == null || dish.getId() == null || dish.getId() == 0) {
				Toast.makeText(this, "Unable to save, try again later.", Toast.LENGTH_LONG).show();
			} else {			
				Toast.makeText(this, "Dish successfully saved!", Toast.LENGTH_LONG).show();
				finish();
			}
			
		} else {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage(problems.toString())
			       .setCancelable(true)
			       .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			                dialog.cancel();
			           }
			       });
			AlertDialog alert = builder.create();
			alert.show();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		app.getActivityStates().put(getClass().getCanonicalName(), getActivityState());
	}

	public Map<String, Object> getActivityState() {
		Map<String, Object> state = new HashMap<String, Object>();
		state.put("title", title.getText());
		state.put("description", description.getText());
		state.put("calories", calories.getText());
		state.put("protein", protein.getText());
		state.put("carbohydrates", carbohydrates.getText());
		state.put("fat", fat.getText());
		state.put("restaurantId", restaurantId);
		state.put("franchiseId", franchiseId);
		state.put("franchise", franchise);
		return state;
	}

	public void setActivityState(Map<String, Object> state) {
		if (state == null) {
			return;
		}
		title.setText((CharSequence) state.get("title")); 
		description.setText((CharSequence) state.get("description"));
		calories.setText((CharSequence) state.get("calories"));
		protein.setText((CharSequence) state.get("protein"));
		carbohydrates.setText((CharSequence) state.get("carbohydrates"));
		fat.setText((CharSequence) state.get("fat"));
		restaurantId = (String) state.get("restaurantId");
		franchiseId = (String) state.get("franchiseId");
		franchise = (Boolean) state.get("franchise");
	}
	
}
