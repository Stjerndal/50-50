package com.paradox.fiftyfifty;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PopularOpinionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_popular_opinion);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.popular_opinion, menu);
		return true;
	}

}
