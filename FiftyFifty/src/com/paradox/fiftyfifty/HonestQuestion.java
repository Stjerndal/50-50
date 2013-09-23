package com.paradox.fiftyfifty;

import java.util.ArrayList;

/**
 * This class is meant to provide methods used in the "Honest Question" game
 * mode
 * 
 * @author Måns Odstam, Andreas Stjerndal, Kalle Sederblad
 * 
 */
public class HonestQuestion {
	private User user;
	
	
	/**
	 * constructor, takes the active player's user object
	 *
	 */
	public HonestQuestion(User user) {
		this.user = user;
	}
	
	public User getUser(){
		return this.user;
	}

	/**
	 * contacts a DBHandler to get a random question from the database
	 * 
	 * @return question
	 */
	public Question fetchRandomQuestion() {
		Question question = DBHandler.getRandomQuestion();
		return question;
	}
	
	/**
	 * Fetches a set of questions for the game
	 * @return
	 */
	public ArrayList<Question> fetchQuestionSet(){
		return DBHandler.getQuestionSet();
	}

	/**
	 * Takes a question object and an answer in string form and sees what answer
	 * has been given. Then updates the questions statistics in the database.
	 * 
	 * @param question
	 * @param answer
	 */
	public void answerQuestion(Question question, String answer) {
		if (answer.equals(question.answer1)) {
			question.setChosenAnswer(1);
			DBHandler.updateQuestion(question);
		} else if (answer.equals(question.answer2)) {
			question.setChosenAnswer(2);
			DBHandler.updateQuestion(question);
		} else {
			System.err.println("No answer, -> HonestQuestion/answerQuestion");
		}
		user.updateNumberOfQuestionsAnswered(1);
	}

}
