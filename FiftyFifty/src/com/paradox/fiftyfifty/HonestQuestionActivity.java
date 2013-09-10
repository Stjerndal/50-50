package com.paradox.fiftyfifty;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HonestQuestionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_honest_question);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.honest_question, menu);
		return true;
	}
	
	 /**
	  * Called when an answer button is pushed
	  */
	 public void buttonPressed(View view){
	//  Intent intent = new Intent(this, HonestQuestionActivity.class);
	//  startActivity(intent);
	  Button button = (Button) view;
	  TextView textView1 = (TextView) findViewById(R.id.feedback);
	     textView1.setText("You selected " + button.getText()); 
	     Intent intent = new Intent(this, MainMenuActivity.class);
	 }

}
