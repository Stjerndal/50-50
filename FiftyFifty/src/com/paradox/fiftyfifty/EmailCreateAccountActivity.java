package com.paradox.fiftyfifty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class EmailCreateAccountActivity extends Activity {
	private User user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email_create_account);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.email_create_account, menu);
		return true;
	}
	
	public void toMainMenuActivity(View view) {
		
		EditText inputEmail = (EditText) findViewById(R.id.et_reg_email_address);
		EditText inputUsername = (EditText) findViewById(R.id.et_reg_username);
		user = new User(inputUsername.getText().toString(),inputEmail.getText().toString());		
		
		Intent intent = new Intent(this, MainMenuActivity.class);
		intent.putExtra(V.KEY_CURRENT_USER, user);
		startActivity(intent);
	}
	
	public void toLoginActivity(View view) {
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}

}
