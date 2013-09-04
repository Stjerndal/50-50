package com.paradox.fiftyfifty;

import java.util.ArrayList;

/**
 * @author Anden
 * 
 */
/**
 * @author Anden
 *
 */
/**
 * @author Anden
 *
 */
/**
 * @author Anden
 *
 */
/**
 * @author Anden
 *
 */
/**
 * @author Anden
 * 
 */
public class User {
	static final int AMOUNT_OF_QUESTIONS_REQUIRED_TO_SUBMIT = 5;

	String userID;
	String realName;
	String userName;
	String emailAddress;

	int numberOfQuestionsAnswered;
	int pointsTotal;

	ArrayList<String> questionIDs;

	/**
	 * userID & userName is set to @param userName. realName, emailAddress is
	 * set to "", numberOfQuestionsAnswered & pointsTotal is set to 0
	 * 
	 * @param userName
	 *            the new userName;
	 */
	public User(String userName) {
		this.userID = userName;
		this.userName = userName;
		this.realName = "";
		this.emailAddress = "";
		this.numberOfQuestionsAnswered = 0;
		this.pointsTotal = 0;
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
	public User(String userName, String emailAddress) {
		this.userID = userName;
		this.userName = userName;
		this.realName = "";
		this.emailAddress = emailAddress;
		this.numberOfQuestionsAnswered = 0;
		this.pointsTotal = 0;
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
	public User(String userName, String emailAddress, String realName) {
		this.userID = userName;
		this.userName = userName;
		this.realName = realName;
		this.emailAddress = emailAddress;
		this.numberOfQuestionsAnswered = 0;
		this.pointsTotal = 0;
	}

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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getNumberOfQuestionsAnswered() {
		return numberOfQuestionsAnswered;
	}

	public void setNumberOfQuestionsAnswered(int numberOfQuestionsAnswered) {
		this.numberOfQuestionsAnswered = numberOfQuestionsAnswered;
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

	public static int getAmountOfQuestionsRequiredToSubmit() {
		return AMOUNT_OF_QUESTIONS_REQUIRED_TO_SUBMIT;
	}

}
