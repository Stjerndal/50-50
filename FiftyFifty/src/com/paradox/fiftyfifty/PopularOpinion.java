package com.paradox.fiftyfifty;

public class PopularOpinion {

	User user;
	
	/**
	 * Constructor
	 */
	public PopularOpinion(User user){
		this.user = user;
	}
	
	/**
	 * contacts a DBHandler to get a random question from the database.
	 * 
	 * @return question
	 */
	public Question fetchQuestion() {
		Question question = DBHandler.getRandomQuestion();
		return question;
	}
	
	/**
	 * Adds a point to the user score if the guess matches the correct answer.
	 * 
	 * @return true if the user guessed right, false if the user guessed wrong.
	 */
	public boolean wasRight(String guess, String correct){
		if(guess.equals(correct)){//right
			user.addPointGuessing(1);
			return true;
		}
		else{//wrong
			return false;
		}
	}

}
