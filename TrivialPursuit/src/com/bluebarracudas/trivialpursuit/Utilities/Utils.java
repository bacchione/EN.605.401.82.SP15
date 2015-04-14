package com.bluebarracudas.trivialpursuit.Utilities;

import java.util.ArrayList;
import java.util.List;

import com.bluebarracudas.trivialpursuit.Constants;
import com.bluebarracudas.trivialpursuit.Classes.BoardPosition;
import com.bluebarracudas.trivialpursuit.Classes.Position;

public final class Utils {
	public final static int generateRandomNumber() {
		return Constants.MINIMUM_DICE_VALUE
				+ (int) (Math.random() * Constants.MAXIMUM_DICE_VALUE);
	}
	public final static int generateRandomNumber(int min, int max) {
		return min + (int) (Math.random() * max);
	}
	public final static ArrayList<Position> getMoveCoordinates(int diceValue, Position currentPosition){
		int tempValue = diceValue;
		ArrayList<Position> positions = new ArrayList<Position>();
		
		for(int x = 0; x <= diceValue; x++){
			positions.add(new Position (x + currentPosition.getX(), tempValue + currentPosition.getY()));
			positions.add(new Position (-1 * x + currentPosition.getX(), tempValue + currentPosition.getY()));
			positions.add(new Position (x + currentPosition.getX(), -1 * tempValue + currentPosition.getY()));
			positions.add(new Position (-1 * x + currentPosition.getX(), -1 * tempValue + currentPosition.getY()));
			tempValue--;
		}
		return positions;
	}
	public final static ArrayList<Position> removeInvalidCoordinates(ArrayList<Position> positions){
		for (int i = 0; i < positions.size(); i++)
		{
			if(!validCoordinates(positions.get(i))){
				positions.remove(i);
				i = 0;
			}
		}
		return positions;
	}
	public final static ArrayList<Position> getValidMoves(int diceValue, Position currentPosition)
	{
		ArrayList<Position> temp = getMoveCoordinates(diceValue, currentPosition);
		return removeInvalidCoordinates(temp);
	}
	public final static boolean validCoordinates(Position position){
		List<BoardPosition> temp = BoardPosition.getValues();
		for(int i = 0; i < temp.size(); i++){
			if(position.getX() == temp.get(i).getPosition().getX() && 
			   position.getY() == temp.get(i).getPosition().getY())
			{
				return true;
			}
		}
		return false;
	}
}
