package com.bluebarracudas.trivialpursuit.Classes;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

public class Category implements Parcelable {

	private String name;
	private int color;
	private ArrayList<Question> questionArray = new ArrayList<Question>();

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getColor() {
		return this.color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public void setQuestionArray(ArrayList<Question> questionArray) {
		this.questionArray = questionArray;
	}

	public ArrayList<Question> getQuestionArray() {
		return this.questionArray;
	}

	public Question getQuestionByIndex(int index) {
		if (index < this.questionArray.size()) {
			return this.questionArray.get(index);
		}
		return null;
	}

	public void writeToParcel(Parcel out, int flags) {
		out.writeString(name);
		out.writeInt(color);
		out.writeTypedList(questionArray);
	}

	public Category(String name, int color, ArrayList<Question> questionArray) {
		super();
		this.name = name;
		this.color = color;
		this.questionArray = questionArray;
	}

	public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() {
		@Override
		public Category createFromParcel(Parcel in) {
			String name = in.readString();
			int color = in.readInt();
			ArrayList<Question> questionArray = new ArrayList<Question>();
			in.readTypedList(questionArray, Question.CREATOR);
			// in.readList(questionArray, getClass().getClassLoader());
			// final ArrayList<Question> questionArray =
			// in.readArrayList(getClass().getClassLoader());

			return new Category(name, color, questionArray);
		}

		@Override
		public Category[] newArray(int size) {
			return new Category[size];
		}
	};

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
}
