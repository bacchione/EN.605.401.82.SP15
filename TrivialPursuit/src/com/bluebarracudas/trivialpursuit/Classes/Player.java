package com.bluebarracudas.trivialpursuit.Classes;

import com.bluebarracudas.trivialpursuit.Constants;

import android.os.Parcel;
import android.os.Parcelable;

public class Player implements Parcelable {

	private String name = "";
	private BoardPosition boardPosition;
	private boolean[] categoryArray = new boolean[Constants.MAX_NUMBER_OF_CATEGORIES];

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BoardPosition getPosition() {
		return this.boardPosition;
	}

	public void setPosition(BoardPosition boardPosition) {
		this.boardPosition = boardPosition;
	}

	public void setCategoryArrayValue(int categoryNumber, boolean value) {
		this.categoryArray[categoryNumber] = value;
	}

	public void setCategoryArray(boolean[] categoryArray) {
		this.categoryArray = categoryArray;
	}

	public boolean[] getCategoryArray() {
		return this.categoryArray;
	}

	public void writeToParcel(Parcel out, int flags) {
		out.writeString(name);
		//out.writeInt(Constants.MAX_NUMBER_OF_CATEGORIES);
		out.writeBooleanArray(categoryArray);
		out.writeSerializable(boardPosition);
	}

	public Player(String name, BoardPosition boardPosition, boolean[] categoryArray) {
		super();
		this.name = name;
		this.boardPosition = boardPosition;
		this.categoryArray = categoryArray;
	}

	public static final Parcelable.Creator<Player> CREATOR = new Parcelable.Creator<Player>() {
		@Override
		public Player createFromParcel(Parcel in) {
			String name = in.readString();
			//Position boardPosition = in.readParcelable(loader)
			// need to fix this so it reads the position
			boolean[] categoryArray = new boolean[Constants.MAX_NUMBER_OF_CATEGORIES];
			in.readBooleanArray(categoryArray);
			BoardPosition position = (BoardPosition) in.readSerializable();

			return new Player(name, position, categoryArray);
		}

		@Override
		public Player[] newArray(int size) {
			return new Player[size];
		}
	};

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
}
