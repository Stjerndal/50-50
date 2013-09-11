package com.paradox.fiftyfifty;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class FacebookUsernameActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_facebook_username);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.facebook_username, menu);
		return true;
	}

}
