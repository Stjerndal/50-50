package com.paradox.fiftyfifty;

import android.os.Parcel;
import android.os.Parcelable;

public class Question implements Parcelable {

	int noOfAnswer1;
	int noOfAnswer2;
	int chosenAnswer; // 1 for answer1, 2 for answer2
	Answer answer1;
	Answer answer2;
	String questionText;
	String userID;

	public Question() {
		noOfAnswer1 = 0;
		noOfAnswer2 = 0;
		chosenAnswer = 0;
		answer1 = new Answer();
		answer2 = new Answer();
		questionText = "";
		userID = "placeholder";
	}

	public Question(Parcel in) {
		readFromParcel(in);
	}

	public int getNoOfAnswer1() {
		return noOfAnswer1;
	}

	public void setNoOfAnswer1(int noOfAnswer1) {
		this.noOfAnswer1 = noOfAnswer1;
	}

	public int getNoOfAnswer2() {
		return noOfAnswer2;
	}

	public void setNoOfAnswer2(int noOfAnswer2) {
		this.noOfAnswer2 = noOfAnswer2;
	}

	public int getChosenAnswer() {
		return chosenAnswer;
	}

	public void setChosenAnswer(int chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}

	public Answer getAnswer1() {
		return answer1;
	}

	public void setAnswer1(Answer answer1) {
		this.answer1 = answer1;
	}

	public Answer getAnswer2() {
		return answer2;
	}

	public void setAnswer2(Answer answer2) {
		this.answer2 = answer2;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * Adds a new question to database with @accepted set to false.
	 * 
	 * New question becomes subject to review.
	 */
	public void submitQuestion(String[] suggestedQuestion) {

	}

	/**
	 * Changes the properties of a question in the database.
	 */
	public void setQuestionStats(Question question, Object Somethingsomething) {

	}

	/**
	 * @return the number corresponding to the most popular answer of this
	 *         question.
	 */
	public int getMostPopularAnswer() {
		if (noOfAnswer1 > noOfAnswer2) {
			return 1;
		} else
			return 2;
	}

	/**
	 * Calculates the ratio of (number of answers for the most popular
	 * alternative) divided by (total number of answers) For close question this
	 * is just above 0.5 (ideally exactly 0.5)
	 * 
	 * @return the degree of difficulty
	 */
	public String getMode() {
		double ratio = 0;

		if (getMostPopularAnswer() == 1) {
			ratio = noOfAnswer1 / (noOfAnswer1 + noOfAnswer2);
		} else if (getMostPopularAnswer() == 2) {
			ratio = noOfAnswer2 / (noOfAnswer1 + noOfAnswer2);
		}

		if (ratio > 0.55)
			return "Hard"; // g�r en switch h�r ist�llet kanske (snyggare) (jag
							// har gl�mt hur man g�r)
		else if (ratio > 0.60)
			return "Medium";
		else
			return "Easy";
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// We just need to write each field into the
		// parcel. When we read from parcel, they
		// will come back in the same order
//		
//		int noOfAnswer1;
//		int noOfAnswer2;
//		int chosenAnswer; // 1 for answer1, 2 for answer2
//		Answer answer1;
//		Answer answer2;
//		String questionText;
//		String userID;
		
		dest.writeInt(noOfAnswer1);
		dest.writeInt(noOfAnswer2);
		dest.writeInt(chosenAnswer);
		
		dest.writeParcelable(answer1, flags);
		dest.writeParcelable(answer2, flags);
		
		dest.writeString(questionText);
		dest.writeString(userID);
	}

	/**
	 * * * Called from the constructor to create this * object from a parcel. ** @param
	 * in parcel from which to re-create object
	 */
	private void readFromParcel(Parcel in) {
		// We just need to read back each
		// field in the order that it was
		// written to the parcel
		noOfAnswer1 = in.readInt();
		noOfAnswer2 = in.readInt();
		chosenAnswer = in.readInt();
		answer1 = in.readParcelable(Answer.class.getClassLoader());
		answer2 = in.readParcelable(Answer.class.getClassLoader());
		questionText = in.readString();
		userID = in.readString();
	}

	/**
	 * * * This field is needed for Android to be able to * create new objects,
	 * individually or as arrays. * * This also means that you can use use the
	 * default * constructor to create the object and use another * method to
	 * hydrate it as necessary. * * I just find it easier to use the constructor.
	 * * It makes sense for the way my brain thinks ;-) *
	 */
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
		public Question createFromParcel(Parcel in) {
			return new Question(in);
		}

		public Question[] newArray(int size) {
			return new Question[size];
		}
	};
}
