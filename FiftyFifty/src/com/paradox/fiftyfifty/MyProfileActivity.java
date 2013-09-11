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
		
//		user = new User(V.TMP_USERNAME, V.TMP_USER_EMAIL, V.TMP_USER_REAL_NAME);
		out.append("UserID: \t\t" + user.getUserID());
		out.append("\nUsername: \t\t" + user.getUserName());
		out.append("\nReal Name: \t" + user.getRealName());
		out.append("\nEmail: \t\t" + user.getEmailAddress());
		out.append("\nPassword: \t\t" + user.getPassword());
		
		out.append("\nAnswered Qs: \t" + user.getNumberOfQuestionsAnswered());
		out.append("\nSubmitted Qs: \t" + user.getNumberOfQuestionsSubmitted());
		out.append("\nQ Spots: \t\t" + user.amountOfQuestionSpots());
		out.append("\nQs left: \t\t" + user.remainingQuestionsRequiredForNewQuestionSpot());
		
		out.append("\nPoints Total: \t" + user.getPointsTotal());
		out.append("\nPoints GuessPop: \t" + user.getPointsGuessPopular());
		out.append("\nPoints SubQs: \t" + user.getPointsSubmittedQuestions());
		out.append("\nPoints 1v1: \t" + user.getPoints1v1());
		
		out.append("\nSubmitted qIDs:\t" + "[");
		if(!user.getQuestionIDs().isEmpty()) {
		for(String qID : user.getQuestionIDs()) {
			out.append(qID + ",");
		}
		out.deleteCharAt(out.length()-1);
		}
		out.append("]");
		
		outTextView.setText(out.toString());
		
//		outTextView.setText(user.getUserID() + " " + user.getUserName());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_profile, menu);
		return true;
	}

}
