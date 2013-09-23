package com.paradox.fiftyfifty;

import java.util.ArrayList;

public class Test {

	/**
	 * @param args
	 */
	public Test(){
		//TODO
	}

	/**
	 * returns an array of questions
	 * @return
	 */
	public static ArrayList<Question> getQuestionSet(){
		ArrayList<Question> questionSet = new ArrayList<Question>();
		questionSet.add(new Question("Be 1 meter tall and super handome or be 2 meters and kind of ugly?", new Answer("1 meter tall and super handsome"), new Answer("2 meters and kind of ugly")));
		questionSet.add(new Question("Cats or dogs?", new Answer("Cats"), new Answer("Dogs")));
		questionSet.add(new Question("Christianity or Islam?", new Answer("Christianity"), new Answer("Islam")));
		questionSet.add(new Question("Beer or wine?", new Answer("Beer"), new Answer("Wine")));
		questionSet.add(new Question("Ass or boobs?", new Answer("Ass"), new Answer("Boobs")));
		questionSet.add(new Question("Reddit or Facebook?", new Answer("Reddit"), new Answer("Facebook")));
		questionSet.add(new Question("Is it called football or soccer?", new Answer("Football"), new Answer("Soccer")));
		questionSet.add(new Question("Are you a day person or a night person?", new Answer("Day person"), new Answer("Night person")));
		questionSet.add(new Question("Would you rather have no arms or no legs?", new Answer("No arms"), new Answer("No legs")));
		questionSet.add(new Question("Would you rather be blind or retarded?", new Answer("Blind"), new Answer("Retarded")));



		return questionSet;		
	}


}
