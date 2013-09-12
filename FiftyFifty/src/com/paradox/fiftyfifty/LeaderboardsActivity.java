package com.paradox.fiftyfifty;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class LeaderboardsActivity extends Activity {
	private User user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leaderboards);

		Bundle b = getIntent().getExtras();
		user = b.getParcelable(V.KEY_CURRENT_USER);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.leaderboards, menu);
		return true;
	}

	/**
	 * total points
	 * @param view
	 */
	public void totalPoints(View view){
		PublicUser[] highscore = DBHandler.getTotalPointsHighScore();
		//INSERT STUFF

	}
	
	/**
	 * Popular Opinion 
	 * @param view
	 */
	public void pointsGuessPopular(View view){
		PublicUser[] highscore = DBHandler.getPointsGuessPopularHighScore();
		//INSERT STUFF
	}
	
	/**
	 * Submitted Questions
	 * @param view
	 */
	public void pointsSubmittedQuestions(View view){
		PublicUser[] highscore = DBHandler.getPointsSubmittedQuestionsHighScore();
		//INSERT STUFF
	}
	
	/**
	 * 1vs1 points
	 * @param view
	 */
	public void points1vs1(View view){
		PublicUser[] highscore = DBHandler.getPoints1vs1HighScore();
		//INSERT STUFF
	}

}
