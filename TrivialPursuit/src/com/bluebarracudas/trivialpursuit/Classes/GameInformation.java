package com.bluebarracudas.trivialpursuit.Classes;

import java.util.ArrayList;

import com.bluebarracudas.trivialpursuit.Constants;

import android.os.Parcel;
import android.os.Parcelable;

public class GameInformation implements Parcelable {
	
	ArrayList<Category> mCategories = new ArrayList<Category>();
	ArrayList<Player> mPlayers = new ArrayList<Player>();
	int mCurrentPlayersTurn = 0;
	
	public ArrayList<Category> getCategories() {
		return this.mCategories;
	}

	public void setCategories(ArrayList<Category> categories) {
		this.mCategories = categories;
	}
	
	public ArrayList<Player> getPlayers() {
		return this.mPlayers;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.mPlayers = players;
	}

	public int getCurrentPlayer() {
		return this.mCurrentPlayersTurn;
	}

	public void setCurrentPlayer(int currentPlayerTurn) {
		this.mCurrentPlayersTurn = currentPlayerTurn;
	}

	public void writeToParcel(Parcel out, int flags) {
		out.writeInt(mCurrentPlayersTurn);
		out.writeTypedList(mCategories);
		out.writeTypedList(mPlayers);
	}

	public GameInformation(ArrayList<Category> categories, ArrayList<Player> players, int currentPlayersTurn) {
		super();
		this.mCategories = categories;
		this.mPlayers = players;
		this.mCurrentPlayersTurn = currentPlayersTurn;
	}

	public static final Parcelable.Creator<GameInformation> CREATOR = new Parcelable.Creator<GameInformation>() {
		@Override
		public GameInformation createFromParcel(Parcel in) {

			int currentPlayersTurn = in.readInt();
			
			ArrayList<Category> categories = new ArrayList<Category>();
			in.readTypedList(categories, Category.CREATOR);
			
			ArrayList<Player> players = new ArrayList<Player>();
			in.readTypedList(players, Player.CREATOR);
			
			return new GameInformation(categories, players, currentPlayersTurn);
		}

		@Override
		public GameInformation[] newArray(int size) {
			return new GameInformation[size];
		}
	};

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
}
