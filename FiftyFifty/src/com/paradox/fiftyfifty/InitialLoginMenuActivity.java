package com.paradox.fiftyfifty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class InitialLoginMenuActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_initial_login_menu);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.initial_login_menu, menu);
		return true;
	}

	public void toFuckingSomething(View view) {
		User newFacebookUser = new User();
		newFacebookUser.setEmailAddress(V.TMP_USER_EMAIL);
		newFacebookUser.setRealName(V.TMP_USER_REAL_NAME);

		Intent intent = new Intent(this, MainMenuActivity.class);
		intent.putExtra(V.FLAG_CURRENT_USER, newFacebookUser);
		startActivity(intent);
	}

	public void toEmailCreateAccountActivity(View view) {
		Intent intent = new Intent(this, EmailCreateAccountActivity.class);
		startActivity(intent);
	}

}