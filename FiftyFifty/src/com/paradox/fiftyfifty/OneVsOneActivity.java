package com.paradox.fiftyfifty;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class OneVsOneActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one_vs_one);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.one_vs_one, menu);
		return true;
	}

}
