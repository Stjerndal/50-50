package com.paradox.fiftyfifty;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity {
	private User user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	public void toMainMenu(View view) {

		EditText inputEmailOrUsername = (EditText) findViewById(R.id.et_login_username_or_email);
		EditText inputPassword = (EditText) findViewById(R.id.et_login_password);
		user = new User();
		user.setPassword(inputPassword.getText().toString());
		user.setUserID(V.TMP_USER_ID);
		user.setRealName(V.TMP_USER_REAL_NAME);

		String emailOrUsername = inputEmailOrUsername.getText().toString();
		if (emailOrUsername.contains("@")) {
			user.setEmailAddress(emailOrUsername);
			user.setUserName(emailOrUsername.split("@")[0]);
		} else {
			user.setUserName(emailOrUsername);
			user.setEmailAddress(V.TMP_USER_EMAIL);
		}

		Intent intent = new Intent(this, MainMenuActivity.class);
		intent.putExtra(V.KEY_CURRENT_USER, user);
		startActivity(intent);
	}

}
