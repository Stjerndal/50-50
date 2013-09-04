package com.paradox.fiftyfifty;

/**
 * This class is meant to handle all the traffic between client and database
 * @author Måns Odstam, Andreas Stjerndal, Kalle Sederblad
 *
 */
public class DBHandler {

	/**
	 * Constructor
	 * @param args
	 */
	public DBHandler(){
	//TODO	
	}
	
	/**
	 * Gets a users information from the database, constructs and returns an User object
	 * @param userID
	 * @return User
	 */
	public User getUser(String userID){
		//TODO	
		return null;
	}
	
	/**
	 * Gets a random question form the database and puts it into a Question object
	 * @return Question
	 */
	public Question getRandomQuestion(){
		//TODO
		return null;
	}
	
	/**
	 * Takes an User object and stores it in the database
	 * @param user
	 */
	public void newUser(User user){
		//TODO
	}
	
	/**
	 * Takes an User object and updates an existing user in the database with the given data 
	 * @param user
	 */
	public void modifyUser(User user){
		//TODO
	}
	
	/**
	 * Takes a Question object and stores it in the database 
	 * @param question
	 */
	public void submitQuestion(Question question){
		//TODO
	}
	
	/**
	 * Takes a Question object and updates the corresponding question in the database with it's information
	 * @param question
	 */
	public void updateQuestion(Question question){
		//TODO
	}
	
	/**
	 * Takes a User object (which contains login information) and finds
	 * the corresponding user in the database and return it
	 * @param user
	 * @return User
	 */
	public User login(User user){
		//TODO
		return null;
	}
	
	
	
}
