package com.paradox.fiftyfifty;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HonestQuestionActivity extends Activity {

	private User user;
	private ArrayList<Question> questionSet;
	private int index;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_honest_question);

		Bundle b = getIntent().getExtras();
		user = b.getParcelable(V.KEY_CURRENT_USER);
		questionSet = b.getParcelableArrayList(V.KEY_CURRENT_QUESTIONSET);
		index = b.getInt(V.KEY_CURRENT_QUESTIONSET_INDEX);
		
		Button answerButton1 = (Button) findViewById(R.id.honestAnswer1);
		Button answerButton2 = (Button) findViewById(R.id.honestAnswer2);
		Question currentQuestion = questionSet.get(index);
		if(new Random().nextBoolean()){
			answerButton1.setText(currentQuestion.getAnswer1().getAnswerText());
			answerButton2.setText(currentQuestion.getAnswer2().getAnswerText());
		}
		else{
			answerButton1.setText(currentQuestion.getAnswer2().getAnswerText());
			answerButton2.setText(currentQuestion.getAnswer1().getAnswerText());
		}
		
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


		Button button = (Button) view;
		TextView textView1 = (TextView) findViewById(R.id.feedback);



		//UPDATE QUESTIONS STATS
		Question currentQuestion = questionSet.get(index);

		if(button.getText().equals(currentQuestion.answer1.getAnswerText())){
			currentQuestion.setChosenAnswer(1);
			currentQuestion.setNoOfAnswer1(currentQuestion.getNoOfAnswer1()+1);
		}
		else if(button.getText().equals(currentQuestion.answer2.getAnswerText())){
			currentQuestion.setChosenAnswer(2);
			currentQuestion.setNoOfAnswer2(currentQuestion.getNoOfAnswer2()+1);
		}
		else{
			Log.d(V.LOG_TAG , "Something went horribly wrong in 'buttonPressed' method");
		}

		//DISPLAY STATISTICS
		int totalAnswers = currentQuestion.getNoOfAnswer1() + currentQuestion.getNoOfAnswer2();
		textView1.setText("You selected " + button.getText() + ". " + currentQuestion.getNoOfAnswer1()/totalAnswers + " % of people answered '"
				+ currentQuestion.getAnswer1().getAnswerText() + "' ," + currentQuestion.getNoOfAnswer2()/totalAnswers + " % of people answered '"
				+ currentQuestion.getAnswer2().getAnswerText() + "'"); 

	}

	/**
	 * if the "next"-button has been pressed
	 * @param view
	 */
	public void next(View view){
		//APPEND PARCABLE OBJECTS
		if(index == questionSet.size()-2){
			questionSet.addAll(HonestQuestion.fetchQuestionSet());
		}
		index++;
		Intent intent = new Intent(this, HonestQuestionActivity.class);
		intent.putExtra(V.KEY_CURRENT_USER, user);
		intent.putParcelableArrayListExtra(V.KEY_CURRENT_QUESTIONSET, DBHandler.getQuestionSet());
		intent.putExtra(V.KEY_CURRENT_QUESTIONSET_INDEX, index);

		//START NEW INTENT (HONESTQUESTIONACTIVITY)
		startActivity(intent);
	}


	/**
	 * Player wants to cancel
	 * @param view
	 */
	public void submitAnswers(View view){

	}

}
