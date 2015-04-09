package com.bluebarracudas.trivialpursuit.Classes;

import com.bluebarracudas.trivialpursuit.Constants;

import android.os.Parcel;
import android.os.Parcelable;

public class Position implements Parcelable {

	private int x;
	private int y;

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void writeToParcel(Parcel out, int flags) {
		out.writeInt(x);
		out.writeInt(y);
	}

	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public static final Parcelable.Creator<Position> CREATOR = new Parcelable.Creator<Position>() {
		@Override
		public Position createFromParcel(Parcel in) {
			int x = in.readInt();
			int y = in.readInt();

			return new Position(x, y);
		}

		@Override
		public Position[] newArray(int size) {
			return new Position[size];
		}
	};

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
}
