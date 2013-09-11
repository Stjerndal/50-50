package com.paradox.fiftyfifty;

import android.os.Bundle;
import android.app.Activity;
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
//		user = b.getParcelable(V.KEY_CURRENT_USER);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
	
	public void toSubmitQuestionsActivity(View view){
		Intent intent = new Intent(this, SubmitQuestionActivity.class);
		startActivity(intent);
	}
	
	public void toMyProfileActivity(View view) {
//		Intent intent = new Intent(this, MyProfileActivity.class);
//		intent.putExtra(V.KEY_CURRENT_USER, user);
//		startActivity(intent);
		
		User newUser = new User(V.TMP_USERNAME, V.TMP_USER_EMAIL, V.TMP_USER_REAL_NAME);
		
		Intent intent = new Intent(this, MyProfileActivity.class);
		intent.putExtra(V.KEY_CURRENT_USER, newUser);
		startActivity(intent);
	}


}
