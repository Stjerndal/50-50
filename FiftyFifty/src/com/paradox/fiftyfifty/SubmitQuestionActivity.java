package com.paradox.fiftyfifty;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class SubmitQuestionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_submit_question);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.submit_question, menu);
		return true;
	}

	/**
	 * submit a question to the database
	 * @param view
	 */
	public void submitQuestion(View view){
		//Submit question
		//Leave to previous activity
		EditText text1 = (EditText) findViewById(R.id.editText1);
		EditText text2 = (EditText) findViewById(R.id.editText2);
		EditText text3 = (EditText) findViewById(R.id.editText3);

		String questionText = text1.getText().toString();
		String answer1Text = text2.getText().toString();
		String answer2Text = text3.getText().toString();

		if(questionText.length()>0 && answer1Text.length()>0 && answer2Text.length()>0){
			Answer answer1 = new Answer();
			answer1.setAnswerText(answer1Text);
			Answer answer2 = new Answer();
			answer2.setAnswerText(answer2Text);
			String userID = ""; //<-------------------------------------------fix

			Question question = new Question();
			question.setQuestionText(questionText);
			question.setAnswer1(answer1);
			question.setAnswer2(answer2);
			question.setUserID(userID);
			DBHandler dbhandler = new DBHandler();
			dbhandler.submitQuestion(question);
			
			Intent intent = new Intent(this, MainMenuActivity.class);
			startActivity(intent);
		}
		else{
			//do nothing
		}

	}

	public void cancel(View view){
		//leave to previous activity
		Intent intent = new Intent(this, MainMenuActivity.class);
		startActivity(intent);
	}
}
