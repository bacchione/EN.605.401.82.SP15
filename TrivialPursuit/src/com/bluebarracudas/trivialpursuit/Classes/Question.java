package com.bluebarracudas.trivialpursuit.Classes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import com.bluebarracudas.trivialpursuit.Constants;

import android.os.Parcel;
import android.os.Parcelable;

public class Question implements Parcelable {

	private String categoryName;
	private String question;
	private String answer;

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void writeToParcel(Parcel out, int flags) {
		out.writeString(categoryName);
		out.writeString(question);
		out.writeString(answer);
	}

	public Question(String categoryName, String question, String answer) {
		super();
		this.categoryName = categoryName;
		this.question = question;
		this.answer = answer;
	}

	public static final Parcelable.Creator<Question> CREATOR = new Parcelable.Creator<Question>() {
		@Override
		public Question createFromParcel(Parcel in) {
			String categoryName = in.readString();
			String question = in.readString();
			String answer = in.readString();

			return new Question(categoryName, question, answer);
		}

		@Override
		public Question[] newArray(int size) {
			return new Question[size];
		}
	};

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
}
