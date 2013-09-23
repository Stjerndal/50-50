package com.paradox.fiftyfifty;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainMenuActivity extends Activity {
	private User user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		
		Bundle b = getIntent().getExtras();
		user = b.getParcelable(V.KEY_CURRENT_USER);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
	
	public void toSubmitQuestionsActivity(View view){
		if(user.amountOfQuestionSpots()>0){
		Intent intent = new Intent(this, SubmitQuestionActivity.class);
		intent.putExtra(V.KEY_CURRENT_USER, user);
		startActivity(intent);
		}else{
			AlertDialog.Builder popup = new AlertDialog.Builder(this);
			popup.setTitle("Not enough questions answered!");
			popup.setMessage("You need to answer more honest questions before you can submit a new question!");
			popup.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) { 
					// continue with delete
				}
			});
			//		    popup.setNegativeButton("No", new DialogInterface.OnClickListener() {
			//		        public void onClick(DialogInterface dialog, int which) { 
			//		            // do nothing
			//		        }
			//		     });
			popup.show();
		}
	}
	
	public void toMyProfileActivity(View view) {
		Intent intent = new Intent(this, MyProfileActivity.class);
		intent.putExtra(V.KEY_CURRENT_USER, user);
		startActivity(intent);
		
//		User newUser = new User(V.TMP_USERNAME, V.TMP_USER_EMAIL, V.TMP_USER_REAL_NAME);
		
//		Intent intent = new Intent(this, MyProfileActivity.class);
//		intent.putExtra(V.KEY_CURRENT_USER, newUser);
//		startActivity(intent);
	}
	
	public void toHonestQuestionActivity(View view){
		Intent intent = new Intent(this, HonestQuestionActivity.class);
		intent.putExtra(V.KEY_CURRENT_USER, user);
		intent.putExtra(V.KEY_CURRENT_QUESTIONSET, HonestQuestion.fetchQuestionSet());
		intent.putExtra(V.KEY_CURRENT_QUESTIONSET_INDEX, 0);
		startActivity(intent);
	}
	
	public void toPopularOpinionActivity(View view){
		Intent intent = new Intent(this, PopularOpinionActivity.class);
		intent.putExtra(V.KEY_CURRENT_USER, user);
		startActivity(intent);
	}
	
	public void toLeaderboardsActivity(View view){
		Intent intent = new Intent(this, LeaderboardsActivity.class);
		intent.putExtra(V.KEY_CURRENT_USER, user);
		startActivity(intent);
	}
	
	public void toOneVsOneActivity(View view){
		Intent intent = new Intent(this, OneVsOneActivity.class);
		intent.putExtra(V.KEY_CURRENT_USER, user);
		startActivity(intent);
	}


}
