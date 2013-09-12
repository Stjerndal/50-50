package com.paradox.fiftyfifty;

public class Question {

	int noOfAnswer1;
	int noOfAnswer2;
	int chosenAnswer; //1 for answer1, 2 for answer2
	Answer answer1;
	Answer answer2;
	String questionText;
	String userID;
	
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

	public Question() {
		noOfAnswer1 = 0;
		noOfAnswer2 = 0;
		chosenAnswer = 0;
		answer1 = new Answer();
		answer2 = new Answer();
		questionText = "";
		userID = "placeholder";
	}

	/**
	 * Adds a new question to database with @accepted set to false.
	 * 
	 * New question becomes subject to review. 
	 */
	public void submitQuestion(String[] suggestedQuestion){
		
	}
	
	/**
	 * Changes the properties of a question in the database.
	 */
	public void setQuestionStats(Question question, Object Somethingsomething){
		
	}
	
	/**
	 * @return the number corresponding to the most popular answer of this question.
	 */
	public int getMostPopularAnswer(){
		if(noOfAnswer1 > noOfAnswer2){
			return 1;
		}
		else return 2;
	}
	
	/**
	 * Calculates the ratio of (number of answers for the most popular alternative) 
	 * divided by (total number of answers)
	 * For close question this is just above 0.5 (ideally exactly 0.5)
	 * 
	 * @return the degree of difficulty
	 */
	public String getMode(){
		double ratio = 0;
		
		if(getMostPopularAnswer() == 1){
			ratio = noOfAnswer1/(noOfAnswer1+noOfAnswer2);
		}
		else if(getMostPopularAnswer() == 2){
			ratio = noOfAnswer2/(noOfAnswer1+noOfAnswer2);
		}
		
		if(ratio > 0.55) return "Hard"; //gör en switch här istället kanske (snyggare) (jag har glömt hur man gör)
		else if (ratio > 0.60) return "Medium";
		else return "Easy";
	}

}
