package com.paradox.fiftyfifty;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MyProfileActivity extends Activity {
	private User user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_profile);

		Bundle b = getIntent().getExtras();
		user = b.getParcelable(V.KEY_CURRENT_USER);
		
		TextView outTextView= (TextView) findViewById(R.id.tv_my_profile);
		StringBuilder out = new StringBuilder();
		
		out.append("UserID: \t" + user.getUserID());
		out.append("\nUsername: \t" + user.getUserName());
		out.append("\nReal Name: \t" + user.getRealName());
		out.append("\nEmail: \t" + user.getEmailAddress());
		out.append("\nPassword: \t" + user.getPassword());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_profile, menu);
		return true;
	}

}
