package com.bluebarracudas.trivialpursuit;

/**
 * Constants for extras and saving data so we don't type the names wrong in one
 * of the places we use them
 */
public interface Constants {
	public static final String PACKAGE = "com.bluebarracudas.trivialpursuit.";
	public static final int MAX_NUMBER_OF_CATEGORIES = 4;
	public static final int MAX_NUMBER_OF_ANSWERS_PER_QUESTION = 4;
	public static final int MINIUM_DICE_VALUE = 1;
	public static final int MAXIMUM_DICE_VALUE = 6;
	public static final String CATEGORY_DATABASE_TAG = "CATEGORY_DATABASE_TAG";
	public static final String QUESTION_TAG = "QUESTION_TAG";
	public static final String UPDATE_QUESTION_TAG = "UPDATE_QUESTION_TAG";
	public static final String NEW_PLAYERS_TAG = "NEW_PLAYERS_TAG";
	public static final String ACTION_ADD_NEW_PLAYERS = PACKAGE + "ACTION_ADD_NEW_PLAYERS";
	public static final String ACTION_GAME_STATE_CHANGE = PACKAGE + "ACTION_GAME_STATE_CHANGE";
	public static final String CHOSEN_QUESTION_TAG = "CHOSEN_QUESTION_TAG";
	public static final String GAME_STATE_TAG = "GAME_STATE_TAG";
	public static final String ASK_QUESTION_RESULT = "ASK_QUESTION_RESULT";
	public static final int MAX_NUMBER_OF_PLAYERS = 4;
	public static final String CHOOSE_CATEGORY = "CHOOSE_CATEGORY";
}
