package com.bluebarracudas.trivialpursuit;

import java.util.ArrayList;
import java.util.List;

import com.bluebarracudas.trivialpursuit.Classes.BoardPosition;
import com.bluebarracudas.trivialpursuit.Classes.Category;
import com.bluebarracudas.trivialpursuit.Classes.GameInformation;
import com.bluebarracudas.trivialpursuit.Classes.Player;
import com.bluebarracudas.trivialpursuit.Classes.Position;
import com.bluebarracudas.trivialpursuit.Classes.Question;
import com.bluebarracudas.trivialpursuit.Utilities.DefaultQuestionsGenerator;
import com.bluebarracudas.trivialpursuit.Utilities.Utils;

import Framework.ABaseDialog;
import android.R.anim;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameStateMachine extends Activity implements OnClickListener, OnItemClickListener {

	public GameInformation gameInformation = new GameInformation(null, null, 0);
	public int hubCategoryIndex;
	private ArrayList<Player> winningPlayers = new ArrayList<Player>();
	
	public enum GameState{
		NOT_STARTED{
			@Override
			public int getStateId(){return 0;}
		},
		ROLL_DICE{
			@Override
			public int getStateId(){return 1;}
		},
		STARTING_NEW_GAME{
			@Override
			public int getStateId(){return 2;}
		},
		CREATE_PLAYERS{
			@Override
			public int getStateId(){return 3;}
		},
		HIGHLIGHT_MOVE_OPTIONS{
			@Override
			public int getStateId(){return 4;}
		},
		ASK_QUESTION{
			@Override
			public int getStateId(){return 5;}
		},
		ANSWERED_QUESTION{
			@Override
			public int getStateId(){return 6;}
		},
		ASK_HUB_CATEGORY{
			@Override
			public int getStateId(){return 7;}
		},
		ASK_HUB_QUESTION{
			@Override
			public int getStateId(){return 8;}
		},
		CHOOSE_CATEGORIES{
			@Override
			public int getStateId(){return 9;}
		},
		NULL{
			@Override
			public int getStateId(){return 10;}
		};
		
		public abstract int getStateId();
		
		public static GameState getGameStateById(int stateId){
			GameState[] gameState = values();
			for(int i = 0, j = gameState.length; i < j; i++){
				if(gameState[i].getStateId() == stateId){
					return gameState[i];
				}
			}
			return null;
		}
	}
	
	private ImageView dice;
	private TextView rollResult;
	private TextView currentPlayerSlot;
	private TextView secondPlayerSlot;
	private TextView thirdPlayerSlot;
	private TextView fourthPlayerSlot;
	private TextView firstCategory;
	private TextView secondCategory;
	private TextView thirdCategory;
	private TextView fourthCategory;
	
	private GridLayout gridLayout00;
	private GridLayout gridLayout10;
	private GridLayout gridLayout20;
	private GridLayout gridLayout30;
	private GridLayout gridLayout40;
	private GridLayout gridLayout50;
	private GridLayout gridLayout60;
	private GridLayout gridLayout01;
	private GridLayout gridLayout02;
	private GridLayout gridLayout03;
	private GridLayout gridLayout04;
	private GridLayout gridLayout05;
	private GridLayout gridLayout06;
	private GridLayout gridLayout61;
	private GridLayout gridLayout62;
	private GridLayout gridLayout63;
	private GridLayout gridLayout64;
	private GridLayout gridLayout65;
	private GridLayout gridLayout66;
	private GridLayout gridLayout16;
	private GridLayout gridLayout26;
	private GridLayout gridLayout36;
	private GridLayout gridLayout46;
	private GridLayout gridLayout56;
	private GridLayout gridLayout31;
	private GridLayout gridLayout32;
	private GridLayout gridLayout33;
	private GridLayout gridLayout34;
	private GridLayout gridLayout35;
	private GridLayout gridLayout13;
	private GridLayout gridLayout23;
	private GridLayout gridLayout43;
	private GridLayout gridLayout53;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.board_fragment);
		dice = (ImageView) findViewById(R.id.dice_imageView);
		dice.setOnClickListener(this);
		rollResult = (TextView) findViewById(R.id.dice_result);
		
		currentPlayerSlot = (TextView) findViewById(R.id.current_player_name);
		secondPlayerSlot = (TextView) findViewById(R.id.second_slot_player_name);
		thirdPlayerSlot = (TextView) findViewById(R.id.third_slot_player_name);
		fourthPlayerSlot = (TextView) findViewById(R.id.fourth_slot_player_name);
		firstCategory = (TextView) findViewById(R.id.firstCategory);
		secondCategory = (TextView) findViewById(R.id.secondCategory);
		thirdCategory = (TextView) findViewById(R.id.thirdCategory);
		fourthCategory = (TextView) findViewById(R.id.fourthCategory);
		
		final Bundle intentBundle = getIntent().getExtras();
		
		final int size = intentBundle.getInt(Constants.CATEGORY_DATABASE_TAG);
		
		ArrayList<Category> categories = new ArrayList<Category>();
		for(int i = 0; i < size; i++){
			categories.add((Category) intentBundle.getParcelable(String.valueOf(i)));
		}
		
		gameInformation.setCategories(categories);
		
		gridLayout00 = (GridLayout) findViewById(R.id.GridLayout00);
		gridLayout10 = (GridLayout) findViewById(R.id.GridLayout10);
		gridLayout20 = (GridLayout) findViewById(R.id.GridLayout20);
		gridLayout30 = (GridLayout) findViewById(R.id.GridLayout30);
		gridLayout40 = (GridLayout) findViewById(R.id.GridLayout40);
		gridLayout50 = (GridLayout) findViewById(R.id.GridLayout50);
		gridLayout60 = (GridLayout) findViewById(R.id.GridLayout60);
		
		gridLayout01 = (GridLayout) findViewById(R.id.GridLayout01);
		gridLayout02 = (GridLayout) findViewById(R.id.GridLayout02);
		gridLayout03 = (GridLayout) findViewById(R.id.GridLayout03);
		gridLayout04 = (GridLayout) findViewById(R.id.GridLayout04);
		gridLayout05 = (GridLayout) findViewById(R.id.GridLayout05);
		gridLayout06 = (GridLayout) findViewById(R.id.GridLayout06);
		
		gridLayout61 = (GridLayout) findViewById(R.id.GridLayout61);
		gridLayout62 = (GridLayout) findViewById(R.id.GridLayout62);
		gridLayout63 = (GridLayout) findViewById(R.id.GridLayout63);
		gridLayout64 = (GridLayout) findViewById(R.id.GridLayout64);
		gridLayout65 = (GridLayout) findViewById(R.id.GridLayout65);
		gridLayout66 = (GridLayout) findViewById(R.id.GridLayout66);
		
		gridLayout16 = (GridLayout) findViewById(R.id.GridLayout16);
		gridLayout26 = (GridLayout) findViewById(R.id.GridLayout26);
		gridLayout36 = (GridLayout) findViewById(R.id.GridLayout36);
		gridLayout46 = (GridLayout) findViewById(R.id.GridLayout46);
		gridLayout56 = (GridLayout) findViewById(R.id.GridLayout56);
		
		gridLayout31 = (GridLayout) findViewById(R.id.GridLayout31);
		gridLayout32 = (GridLayout) findViewById(R.id.GridLayout32);
		gridLayout33 = (GridLayout) findViewById(R.id.GridLayout33);
		gridLayout34 = (GridLayout) findViewById(R.id.GridLayout34);
		gridLayout35 = (GridLayout) findViewById(R.id.GridLayout35);
		
		gridLayout13 = (GridLayout) findViewById(R.id.GridLayout13);
		gridLayout23 = (GridLayout) findViewById(R.id.GridLayout23);
		gridLayout43 = (GridLayout) findViewById(R.id.GridLayout43);
		gridLayout53 = (GridLayout) findViewById(R.id.GridLayout53);
		
		gridLayout00.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_0_0.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_0_0);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout10.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_1_0.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_1_0);
					continueGame(GameState.ROLL_DICE);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout20.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_2_0.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_2_0);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout30.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_3_0.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_3_0);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout40.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_4_0.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_4_0);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout50.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_5_0.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_5_0);
					continueGame(GameState.ROLL_DICE);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout60.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_6_0.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_6_0);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_0_1.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_0_1);
					continueGame(GameState.ROLL_DICE);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout02.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_0_2.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_0_2);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout03.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_0_3.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_0_3);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout04.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_0_4.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_0_4);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout05.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_0_5.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_0_5);
					continueGame(GameState.ROLL_DICE);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout06.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_0_6.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_0_6);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout61.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_6_1.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_6_1);
					continueGame(GameState.ROLL_DICE);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout62.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_6_2.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_6_2);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout63.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_6_3.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_6_3);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout64.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_6_4.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_6_4);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout65.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_6_5.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_6_5);
					continueGame(GameState.ROLL_DICE);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout66.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_6_6.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_6_6);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout16.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_1_6.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_1_6);
					continueGame(GameState.ROLL_DICE);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout26.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_2_6.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_2_6);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout36.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_3_6.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_3_6);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout46.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_4_6.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_4_6);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout56.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_5_6.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_5_6);
					continueGame(GameState.ROLL_DICE);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout31.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_3_1.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_3_1);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout32.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_3_2.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_3_2);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout33.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_3_3.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_3_3);
					// let other select the category
					continueGame(GameState.ASK_HUB_CATEGORY);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout34.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_3_4.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_3_4);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout35.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_3_5.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_3_5);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout13.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_1_3.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_1_3);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout23.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_2_3.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_2_3);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout43.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_4_3.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_4_3);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		gridLayout53.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(((ColorDrawable)((GridLayout) findViewById(BoardPosition.COORDINATES_5_3.getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()))).getBackground()).getColor() == Color.YELLOW){
					//Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					removePlayerTokens(gameInformation.getCurrentPlayer());
					setPlayerToken(gameInformation.getCurrentPlayer(), BoardPosition.COORDINATES_5_3);
					continueGame(GameState.ASK_QUESTION);
					//move the person's token to this section and ask question
				}
			}
		});
		
		dice.setVisibility(View.INVISIBLE);
		registerReceiver(mCreatePlayersReceiver, new IntentFilter(Constants.ACTION_GAME_STATE_CHANGE));
		
		this.continueGame(GameState.STARTING_NEW_GAME);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(mCreatePlayersReceiver);
	}
	
	private final BroadcastReceiver mCreatePlayersReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			final Bundle bundle = intent.getExtras();
			
			if(!bundle.containsKey(Constants.GAME_STATE_TAG)){
				throw new IllegalStateException("Failed to send Game State Tag.");
			}
			
			GameState gameState = GameState.getGameStateById(intent.getIntExtra(Constants.GAME_STATE_TAG, 0));
			GameState nextGameState = GameState.NULL;
    		
			switch(gameState){
			case CHOOSE_CATEGORIES:
				final int size = intent.getExtras().getInt(Constants.CATEGORY_DATABASE_TAG);
				
				final ArrayList<Category> temp = new ArrayList<Category>();
				
				for(int i = 0; i < size; i++){
					temp.add((Category) intent.getExtras().getParcelable(String.valueOf(i)));
				}
				gameInformation.setCategories(new ArrayList<Category>(temp));
				
				firstCategory.setText(gameInformation.getCategories().get(0).getName());
				secondCategory.setText(gameInformation.getCategories().get(1).getName());
				thirdCategory.setText(gameInformation.getCategories().get(2).getName());
				fourthCategory.setText(gameInformation.getCategories().get(3).getName());
				
				firstCategory.setTextColor(gameInformation.getCategories().get(0).getColor());
				secondCategory.setTextColor(gameInformation.getCategories().get(1).getColor());
				thirdCategory.setTextColor(gameInformation.getCategories().get(2).getColor());
				fourthCategory.setTextColor(gameInformation.getCategories().get(3).getColor());
				
				nextGameState = GameState.ROLL_DICE;
				break;
			case ASK_HUB_CATEGORY:
				hubCategoryIndex = intent.getIntExtra(Constants.CHOOSE_CATEGORY, 0);
				//Toast.makeText(getApplicationContext(), String.valueOf(hubCategoryIndex), Toast.LENGTH_SHORT).show();
				nextGameState = GameState.ASK_HUB_QUESTION;
				break;
			case CREATE_PLAYERS:
				
				ArrayList<Player> players = (ArrayList<Player>) intent.getSerializableExtra(Constants.NEW_PLAYERS_TAG);
				gameInformation.setPlayers(new ArrayList<Player>());
				
				for(int i = 0; i < players.size(); i++){
					gameInformation.getPlayers().add(players.get(i));
				}
				
				// Sets all the tokens to invisible when the game starts
				removeAllPlayerTokens();
				
				nextGameState = GameState.CHOOSE_CATEGORIES;
				//nextGameState = GameState.ROLL_DICE;
				break;
			case ANSWERED_QUESTION:
				boolean answeredCorrect = intent.getBooleanExtra(Constants.ASK_QUESTION_RESULT, false);
				
				if(answeredCorrect){
					
					Toast.makeText(getApplicationContext(), "Answered Correct", Toast.LENGTH_SHORT).show();
					
					// only mark token if the person is on a headquarter
					if(gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getPosition().getPosition().getX() == BoardPosition.COORDINATES_3_3.getPosition().getX() &&
							gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getPosition().getPosition().getY() == BoardPosition.COORDINATES_3_3.getPosition().getY() &&
							gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getCategoryArray()[0] == true && 
							gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getCategoryArray()[1] == true && 
							gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getCategoryArray()[2] == true && 
							gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getCategoryArray()[3] == true){
						
						winningPlayers.add(gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()));
						
						gameInformation.setCurrentPlayer(gameInformation.getCurrentPlayer() + 1);
						if(gameInformation.getCurrentPlayer() > gameInformation.getPlayers().size() - 1){
							gameInformation.setCurrentPlayer(0);
						}
						
					}
					else if((gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getPosition().getPosition().getX() == BoardPosition.COORDINATES_0_0.getPosition().getX() &&
							gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getPosition().getPosition().getY() == BoardPosition.COORDINATES_0_0.getPosition().getY())
							
							||
							
							(gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getPosition().getPosition().getX() == BoardPosition.COORDINATES_0_6.getPosition().getX() &&
							gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getPosition().getPosition().getY() == BoardPosition.COORDINATES_0_6.getPosition().getY())
							
							||
							
							(gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getPosition().getPosition().getX() == BoardPosition.COORDINATES_6_0.getPosition().getX() &&
							gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getPosition().getPosition().getY() == BoardPosition.COORDINATES_6_0.getPosition().getY())
							
							||
							
							(gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getPosition().getPosition().getX() == BoardPosition.COORDINATES_6_6.getPosition().getX() &&
							gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getPosition().getPosition().getY() == BoardPosition.COORDINATES_6_6.getPosition().getY())
							){
						// give the person the category
						int categoryIndex = gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getPosition().getCategoryIndex();
						gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getCategoryArray()[categoryIndex] = true;
					}
				} else{
					Toast.makeText(getApplicationContext(), "Answered Wrong", Toast.LENGTH_SHORT).show();
					// Pick the next player to go
					gameInformation.setCurrentPlayer(gameInformation.getCurrentPlayer() + 1);
					if(gameInformation.getCurrentPlayer() > gameInformation.getPlayers().size() - 1){
						gameInformation.setCurrentPlayer(0);
					}
				}
				nextGameState = GameState.ROLL_DICE;
				break;
			}
			
			updatePlayerStatus();
			continueGame(nextGameState);
		}
	};
	
	public void setAllPlayerTokens(BoardPosition position){
		setPlayerToken(0, position);
		setPlayerToken(1, position);
		setPlayerToken(2, position);
		setPlayerToken(3, position);
	}
	
	public void setPlayerToken(int playerIndex, BoardPosition position){
		List<BoardPosition> positions = BoardPosition.getValues();
		gameInformation.getPlayers().get(playerIndex).setPosition(position);
		boolean[] categoryArray = gameInformation.getPlayers().get(playerIndex).getCategoryArray();
		
		((GridLayout) findViewById(position.getTokenCategoryIdentifier(playerIndex))).setVisibility(View.VISIBLE);
		((GridLayout) findViewById(position.getTokenCategoryIdentifier(playerIndex))).setBackgroundColor(Color.BLACK);
		
		for(int x = 0; x < Constants.MAX_NUMBER_OF_CATEGORIES; x++){
			if(categoryArray[x]){
				((ImageView) findViewById(position.getTokenCategoryImageViewIdentifier(playerIndex, x))).setVisibility(View.VISIBLE);
			} else{
				((ImageView) findViewById(position.getTokenCategoryImageViewIdentifier(playerIndex, x))).setVisibility(View.INVISIBLE);
			}
		}
	}
	
	public void removeAllPlayerTokens(){
		removePlayerTokens(0);
		removePlayerTokens(1);
		removePlayerTokens(2);
		removePlayerTokens(3);
	}
	
	public void removePlayerTokens(int playerIndex){
		List<BoardPosition> positions = BoardPosition.getValues();
		
		List<BoardPosition> boardPositions = BoardPosition.getValues();
		for(int i = 0; i < boardPositions.size(); i++){
			((GridLayout) findViewById(boardPositions.get(i).getTokenCategoryIdentifier(playerIndex))).setBackgroundColor(Color.BLACK);
			((GridLayout) findViewById(boardPositions.get(i).getTokenCategoryIdentifier(playerIndex))).setVisibility(View.INVISIBLE);
			
			for(int x = 0; x < Constants.MAX_NUMBER_OF_CATEGORIES; x++){
				((ImageView) findViewById(boardPositions.get(i).getTokenCategoryImageViewIdentifier(playerIndex, x))).setVisibility(View.INVISIBLE);
			}
		}
		
		//remove all grid layouts on the board for that player
		
	}
	
	public boolean isGameOver(){
		//does a player have all the tokens and on the center hub and answered the last question correct
		return false;
	}
	
	public void updatePlayerStatus(){
		for(int i = 0; i < gameInformation.getPlayers().size(); i++){
			GridLayout layout = (GridLayout) findViewById(gameInformation.getPlayers().get(i).getPosition().getTokenCategoryIdentifier(i));
			Player player = gameInformation.getPlayers().get(i);
			boolean[] arrays = player.getCategoryArray();
			
			ImageView imageview;
			for(int x = 0; x < Constants.MAX_NUMBER_OF_CATEGORIES; x++){
				imageview = (ImageView) findViewById(gameInformation.getPlayers().get(i).getPosition().getTokenCategoryImageViewIdentifier(i, x));
				if(arrays[x]){
					imageview.setVisibility(View.VISIBLE);
				} else{
					imageview.setVisibility(View.INVISIBLE);
				}
			}
			
			layout.setVisibility(View.VISIBLE);
		}
		
		ArrayList<Player> playersTemp = new ArrayList<Player>(gameInformation.getPlayers());
		
		if(gameInformation.getPlayers().size() >= 1){
			currentPlayerSlot.setText(gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getName());
			playersTemp.remove(gameInformation.getCurrentPlayer());
		} else{
			currentPlayerSlot.setText("");
		}
		
		if(gameInformation.getPlayers().size() >= 2){
			secondPlayerSlot.setText(playersTemp.get(0).getName());
			playersTemp.remove(0);
		} else{
			secondPlayerSlot.setText("");
		}
		
		if(gameInformation.getPlayers().size() >= 3){
			thirdPlayerSlot.setText(playersTemp.get(0).getName());
			playersTemp.remove(0);
		} else{
			thirdPlayerSlot.setText("");
		}
		
		if(gameInformation.getPlayers().size() >= 4){
			fourthPlayerSlot.setText(playersTemp.get(0).getName());
			playersTemp.remove(0);
		} else{
			fourthPlayerSlot.setText("");
		}
	}
	
	public GameState continueGame(GameState currentState){
		GameState newState = GameState.NULL;
		
		switch(currentState){
		case CHOOSE_CATEGORIES:
			DialogChooseCategories selectCategoryDialog = new DialogChooseCategories();
			selectCategoryDialog.setCancelable(false);
			final Bundle category = new Bundle();
			
			category.putInt(Constants.CATEGORY_DATABASE_TAG, gameInformation.getCategories().size());
			for(int i = 0; i < gameInformation.getCategories().size(); i++){
				category.putParcelable(String.valueOf(i), gameInformation.getCategories().get(i));
			}
			selectCategoryDialog.setArguments(category);
			selectCategoryDialog.show(getFragmentManager(), ABaseDialog.TAG_DIALOG_FRAGMENT);
			break;
		case STARTING_NEW_GAME:
			DialogCreatePlayers dialog = new DialogCreatePlayers();
			dialog.setCancelable(false);
			dialog.show(getFragmentManager(), ABaseDialog.TAG_DIALOG_FRAGMENT);
			break;
		case ROLL_DICE:
			boolean doneGame = false;
			for(int i = 0; i < winningPlayers.size(); i++){
				if(winningPlayers.get(i).getName() == gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getName()){
					//done game
					String output = "";
					for(int x = 0; x < winningPlayers.size(); x++){
						output += winningPlayers.get(x).getName() + "\n";
					}
					
					Toast.makeText(getApplicationContext(), output + " WIN!", Toast.LENGTH_SHORT).show();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					doneGame = true;
					break;
				}
			}
			
			if(doneGame){
				onBackPressed();
				return newState;
			}
			
			dice.setVisibility(View.VISIBLE);
			rollResult.setText("?");
			Toast.makeText(getApplicationContext(), gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getName() + ": Roll the dice!", Toast.LENGTH_SHORT).show();
			break;
		case HIGHLIGHT_MOVE_OPTIONS:
			List<BoardPosition> boardPositions = BoardPosition.getValues();
			ArrayList<Position> positions = Utils.getValidMoves(Integer.parseInt(rollResult.getText().toString()), gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getPosition().getPosition());
			boolean[] categoryArray = gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getCategoryArray();
			
			for (int i = 0; i < positions.size(); i++)
			{
				for (int x = 0; x < boardPositions.size(); x++){
					if(positions.get(i).getX() == boardPositions.get(x).getPosition().getX() &&
							positions.get(i).getY() == boardPositions.get(x).getPosition().getY()){
						GridLayout gridView = (GridLayout) findViewById(boardPositions.get(x).getTokenCategoryIdentifier(gameInformation.getCurrentPlayer()));
						gridView.setBackgroundColor(Color.YELLOW);
						gridView.setVisibility(View.VISIBLE);
					}
					
					for(int y = 0; y < Constants.MAX_NUMBER_OF_CATEGORIES; y++){
						if(categoryArray[y]){
							((ImageView) findViewById(boardPositions.get(x).getTokenCategoryImageViewIdentifier(gameInformation.getCurrentPlayer(), y))).setVisibility(View.VISIBLE);
						} else{
							((ImageView) findViewById(boardPositions.get(x).getTokenCategoryImageViewIdentifier(gameInformation.getCurrentPlayer(), y))).setVisibility(View.INVISIBLE);
						}
					}
				}
			}
			break;
		case ASK_HUB_CATEGORY:
			// ask witch category
			DialogSelectHubCategory selectCategoryDialog2 = new DialogSelectHubCategory();
			selectCategoryDialog2.setCancelable(false);
			final Bundle categoryBundle2 = new Bundle();
			
			categoryBundle2.putInt(Constants.CATEGORY_DATABASE_TAG, 4);
			for(int i = 0; i < 4; i++){
				categoryBundle2.putParcelable(String.valueOf(i), gameInformation.getCategories().get(i));
			}
			selectCategoryDialog2.setArguments(categoryBundle2);
			selectCategoryDialog2.show(getFragmentManager(), ABaseDialog.TAG_DIALOG_FRAGMENT);
			break;
		case ASK_HUB_QUESTION:
			DialogAskQuestion hubQuestionDialog = new DialogAskQuestion();
			hubQuestionDialog.setCancelable(false);
			
			// get the question to ask and place it at the end of the deck
			Question hubQuestion = gameInformation.getCategories().get(hubCategoryIndex).getQuestionByIndex(0);
			gameInformation.getCategories().get(hubCategoryIndex).getQuestionArray().remove(0);
			gameInformation.getCategories().get(hubCategoryIndex).getQuestionArray().add(hubQuestion);
			
			final Bundle hubBundle = new Bundle();
			hubBundle.putParcelable(Constants.CHOSEN_QUESTION_TAG, hubQuestion);
			hubQuestionDialog.setArguments(hubBundle);
			
			// need to send dialog the category to display
			hubQuestionDialog.show(getFragmentManager(), ABaseDialog.TAG_DIALOG_FRAGMENT);
			break;
		case ASK_QUESTION:
			DialogAskQuestion questionDialog = new DialogAskQuestion();
			questionDialog.setCancelable(false);
			
			// get the question to ask and place it at the end of the deck
			Question question = gameInformation.getCategories().get(gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getPosition().getCategoryIndex()).getQuestionByIndex(0);
			gameInformation.getCategories().get(gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getPosition().getCategoryIndex()).getQuestionArray().remove(0);
			gameInformation.getCategories().get(gameInformation.getPlayers().get(gameInformation.getCurrentPlayer()).getPosition().getCategoryIndex()).getQuestionArray().add(question);
			
			final Bundle bundle = new Bundle();
			bundle.putParcelable(Constants.CHOSEN_QUESTION_TAG, question);
			questionDialog.setArguments(bundle);
			
			// need to send dialog the category to display
			questionDialog.show(getFragmentManager(), ABaseDialog.TAG_DIALOG_FRAGMENT);
			break;
		}
		
		return newState;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.dice_imageView:
			rollResult.setText(String.valueOf(Utils.generateRandomNumber()));
			dice.setVisibility(View.INVISIBLE);
			
			continueGame(GameState.HIGHLIGHT_MOVE_OPTIONS);
			return;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
	}
	
	@Override
	public void onBackPressed() {
		Toast.makeText(getApplicationContext(), "Game data not saved", Toast.LENGTH_SHORT).show();
		this.finish();
	}
}
