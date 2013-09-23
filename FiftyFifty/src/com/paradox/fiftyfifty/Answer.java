package com.paradox.fiftyfifty;

import android.os.Parcel;
import android.os.Parcelable;

public class Answer implements Parcelable{

	String answerText;
	
	/**
	 * Constructor
	 * 
	 * @param args
	 */
	public Answer(){
		answerText = "";
	}
	public Answer(String answerText){
		this.answerText = answerText;
	}
	
	public Answer(Parcel in) {
		readFromParcel(in);
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
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

		dest.writeString(answerText);
	}

	/**
	 * * * Called from the constructor to create this * object from a parcel. ** @param
	 * in parcel from which to re-create object
	 */
	private void readFromParcel(Parcel in) {
		// We just need to read back each
		// field in the order that it was
		// written to the parcel
		answerText = in.readString();
	}

	/**
	 * * * This field is needed for Android to be able to * create new objects,
	 * individually or as arrays. * * This also means that you can use use the
	 * default * constructor to create the object and use another * method to
	 * hydrate it as necessary. * * I just find it easier to use the constructor.
	 * * It makes sense for the way my brain thinks ;-) *
	 */
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
		public Answer createFromParcel(Parcel in) {
			return new Answer(in);
		}

		public Answer[] newArray(int size) {
			return new Answer[size];
		}
	};
}
