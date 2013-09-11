package com.paradox.fiftyfifty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class FacebookUsernameActivity extends Activity {
	private User user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_facebook_username);
		
		Bundle b = getIntent().getExtras();
		user = b.getParcelable(V.KEY_CURRENT_USER);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.facebook_username, menu);
		return true;
	}
	
	public void toMainMenuActivity(View view) {
		EditText inputUsername = (EditText) findViewById(R.id.et_facebook_username);
		user.setUserName(inputUsername.getText().toString());
		Intent intent = new Intent(this, MainMenuActivity.class);
		intent.putExtra(V.KEY_CURRENT_USER, user);
		startActivity(intent);
	}

}
