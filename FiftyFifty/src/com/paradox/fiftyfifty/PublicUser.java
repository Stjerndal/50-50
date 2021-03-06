package com.paradox.fiftyfifty;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Andreas Stjerndal, Kalle Sederblad, M�ns Odstam
 * 
 */
public class PublicUser implements Parcelable {

	private String userID;
	private String userName;
	private String realName;


	private int numberOfQuestionsAnswered;
	private int numberOfSubmittedQuestions;

	private int pointsTotal;
	private int pointsGuessPopular;
	private int pointsSubmittedQuestions;
	private int points1v1;

	private ArrayList<String> questionIDs;

	/**
	 * * * Constructor to use when re-constructing object * from a parcel * * @param
	 * in a parcel from which to read this object
	 */
	public PublicUser(Parcel in) {
		readFromParcel(in);
	}

	/**
	 * userID, userName, realName, emailAddress is set to "",
	 * numberOfQuestionsAnswered & pointsTotal is set to 0
	 * 
	 * @param userName
	 *            the new userName;
	 */
	public PublicUser() {
		this.userID = "";
		this.userName = "";
		this.realName = "";

		this.numberOfQuestionsAnswered = 0;
		this.numberOfSubmittedQuestions = 0;
		this.pointsTotal = 0;
		this.points1v1 = 0;
		this.pointsGuessPopular = 0;
		this.pointsSubmittedQuestions = 0;
		questionIDs = new ArrayList<String>();
	}

	/**
	 * userID & userName is set to @param userName. realName, emailAddress is
	 * set to "", numberOfQuestionsAnswered & pointsTotal is set to 0
	 * 
	 * @param userName
	 *            the new userName;
	 */
	public PublicUser(String userName) {
		this.userID = userName;
		this.userName = userName;
		this.realName = "";

		this.numberOfQuestionsAnswered = 0;
		this.numberOfSubmittedQuestions = 0;
		this.pointsTotal = 0;
		this.points1v1 = 0;
		this.pointsGuessPopular = 0;
		this.pointsSubmittedQuestions = 0;
		questionIDs = new ArrayList<String>();
	}

	/**
	 * userID & userName is set to @param userName. emailAddress is set to @param
	 * emailAddress. realName is set to "", numberOfQuestionsAnswered &
	 * pointsTotal is set to 0
	 * 
	 * @param userName
	 *            the new userName;
	 * @param emailAddress
	 *            the new emailAddress
	 */
	public PublicUser(String userName, String emailAddress) {
		this.userID = userName;
		this.userName = userName;
		this.realName = "";

		this.numberOfQuestionsAnswered = 0;
		this.numberOfSubmittedQuestions = 0;
		this.pointsTotal = 0;
		this.points1v1 = 0;
		this.pointsGuessPopular = 0;
		this.pointsSubmittedQuestions = 0;
		questionIDs = new ArrayList<String>();
	}

	/**
	 * userID & userName is set to @param userName. emailAddress is set to @param
	 * emailAddress. realName is set to @param realName.
	 * numberOfQuestionsAnswered & pointsTotal is set to 0
	 * 
	 * @param userName
	 *            the new userName;
	 * @param emailAddress
	 *            the new emailAddress
	 * @param realName
	 *            the new realName
	 */
	public PublicUser(String userName, String emailAddress, String realName) {
		this.userID = userName;
		this.userName = userName;
		this.realName = realName;

		this.numberOfQuestionsAnswered = 0;
		this.numberOfSubmittedQuestions = 0;
		this.pointsTotal = 0;
		this.points1v1 = 0;
		this.pointsGuessPopular = 0;
		this.pointsSubmittedQuestions = 0;
		questionIDs = new ArrayList<String>();
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

		// static final int AMOUNT_OF_QUESTIONS_REQUIRED_TO_SUBMIT = 5;

		dest.writeString(userID);
		dest.writeString(userName);
		dest.writeString(realName);


		dest.writeInt(numberOfQuestionsAnswered);
		dest.writeInt(numberOfSubmittedQuestions);

		dest.writeInt(pointsTotal);
		dest.writeInt(pointsGuessPopular);
		dest.writeInt(pointsSubmittedQuestions);
		dest.writeInt(points1v1);

		for (int i = 0; i < questionIDs.size(); i++) {
			dest.writeString(questionIDs.get(i));
		}
	}

	/**
	 * * * Called from the constructor to create this * object from a parcel. *
	 * * @param in parcel from which to re-create object
	 */
	private void readFromParcel(Parcel in) {
		// We just need to read back each
		// field in the order that it was written to the parcel

		userID = in.readString();
		userName = in.readString();
		realName = in.readString();


		numberOfQuestionsAnswered = in.readInt();
		numberOfSubmittedQuestions = in.readInt();

		pointsTotal = in.readInt();
		pointsGuessPopular = in.readInt();
		pointsSubmittedQuestions = in.readInt();
		points1v1 = in.readInt();

		questionIDs = new ArrayList<String>();
		for (int i = 0; i < questionIDs.size(); i++) {
			questionIDs.add(in.readString());
		}
	}

	/**
	 * This field is needed for Android to be able to create new objects,
	 * individually or as arrays. This also means that you can use use the
	 * default constructor to create the object and use another method to
	 * hydrate it as necessary. I just find it easier to use the constructor. It
	 * makes sense for the way my brain thinks
	 */
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
		public User createFromParcel(Parcel in) {
			return new User(in);
		}

		public User[] newArray(int size) {
			return new User[size];
		}
	};

	/**
	 * Add points
	 * 
	 * @param pointsToBeAdded
	 */
	public void addPointsTotal(int pointsToBeAdded) {
		this.pointsTotal += pointsToBeAdded;
	}

	/**
	 * Add a new question ID to the array.
	 * 
	 * @param questionIDtoBeAdded
	 */
	public void addQuestionID(String questionIDtoBeAdded) {
		this.questionIDs.add(questionIDtoBeAdded);
	}

	/**
	 * Update the number of questions the user has answered.
	 * 
	 * @param modifier
	 *            the change, for example 1, -2 etc.
	 */
	public void updateNumberOfQuestionsAnswered(int modifier) {
		this.numberOfQuestionsAnswered += modifier;
	}

	/**
	 * Calculate the amount of questions remaining to be answered before the
	 * user can sumit another question
	 * 
	 * @return the amount of questions remaining
	 */
	public int remainingQuestionsRequiredForNewQuestionSpot() {
		return (numberOfQuestionsAnswered
				/ V.AMOUNT_OF_QUESTIONS_REQUIRED_TO_SUBMIT + 1)
				* V.AMOUNT_OF_QUESTIONS_REQUIRED_TO_SUBMIT
				- numberOfQuestionsAnswered;
	}

	/**
	 * Calculate the amount of questions the user can submit at this time.
	 * 
	 * @return the amount of questions the user can submit
	 */
	public int amountOfQuestionSpots() {
		return (numberOfQuestionsAnswered / V.AMOUNT_OF_QUESTIONS_REQUIRED_TO_SUBMIT)
				- numberOfSubmittedQuestions;
	}

	/**
	 * Method to be invoked when a user guessed the right popular opinion
	 */
	public void guessedCorrect() {
		this.pointsGuessPopular++;

	}

	/**
	 * The user submitted a question, call this to increase the stat
	 */
	public void submittedNewQuestion() {
		numberOfSubmittedQuestions++;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getNumberOfQuestionsAnswered() {
		return numberOfQuestionsAnswered;
	}

	public void setNumberOfQuestionsAnswered(int numberOfQuestionsAnswered) {
		this.numberOfQuestionsAnswered = numberOfQuestionsAnswered;
	}

	public int getNumberOfSubmittedQuestions() {
		return numberOfSubmittedQuestions;
	}

	public void setNumberOfSubmittedQuestions(int numberOfSubmittedQuestions) {
		this.numberOfSubmittedQuestions = numberOfSubmittedQuestions;
	}

	public int getPointsTotal() {
		return pointsTotal;
	}

	public void setPointsTotal(int pointsTotal) {
		this.pointsTotal = pointsTotal;
	}

	public ArrayList<String> getQuestionIDs() {
		return questionIDs;
	}

	public void setQuestionIDs(ArrayList<String> questionIDs) {
		this.questionIDs = questionIDs;
	}

	public int getPointsGuessPopular() {
		return pointsGuessPopular;
	}

	public void setPointsGuessPopular(int pointsGuessPopular) {
		this.pointsGuessPopular = pointsGuessPopular;
	}

	public int getPointsSubmittedQuestions() {
		return pointsSubmittedQuestions;
	}

	public void setPointsSubmittedQuestions(int pointsSubmittedQuestions) {
		this.pointsSubmittedQuestions = pointsSubmittedQuestions;
	}

	public int getPoints1v1() {
		return points1v1;
	}

	public void setPoints1v1(int points1v1) {
		this.points1v1 = points1v1;
	}

}
