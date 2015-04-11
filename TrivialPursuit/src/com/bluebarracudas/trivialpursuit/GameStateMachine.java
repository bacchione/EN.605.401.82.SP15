package com.bluebarracudas.trivialpursuit;

import java.util.ArrayList;
import java.util.List;

import com.bluebarracudas.trivialpursuit.Classes.BoardPosition;
import com.bluebarracudas.trivialpursuit.Classes.Category;
import com.bluebarracudas.trivialpursuit.Classes.Player;
import com.bluebarracudas.trivialpursuit.Classes.Position;
import com.bluebarracudas.trivialpursuit.Utilities.DefaultQuestionsGenerator;
import com.bluebarracudas.trivialpursuit.Utilities.Utils;

import Framework.ABaseDialog;
import android.R.anim;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
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
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameStateMachine extends Activity implements OnClickListener, OnItemClickListener {

	public final ArrayList<Category> categoryDatabase = new ArrayList<Category>();
	public final ArrayList<Player> playerDatabase = new ArrayList<Player>();
	
	public enum GameState{
		NOT_STARTED{
			@Override
			public int getStateId(){return 0;}
		},
		WAITING_TO_RESUME{
			@Override
			public int getStateId(){return 1;}
		},
		ASKING_PLAYER_1_QUESTION{
			@Override
			public int getStateId(){return 2;}
		},
		ASKING_PLAYER_2_QUESTION{
			@Override
			public int getStateId(){return 3;}
		},
		ASKING_PLAYER_3_QUESTION{
			@Override
			public int getStateId(){return 4;}
		},
		ASKING_PLAYER_4_QUESTION{
			@Override
			public int getStateId(){return 5;}
		},
		PLAYER_1_ANSWERED_QUESTION_CORRECT{
			@Override
			public int getStateId(){return 6;}
		},
		PLAYER_2_ANSWERED_QUESTION_CORRECT{
			@Override
			public int getStateId(){return 7;}
		},
		PLAYER_3_ANSWERED_QUESTION_CORRECT{
			@Override
			public int getStateId(){return 8;}
		},
		PLAYER_4_ANSWERED_QUESTION_CORRECT{
			@Override
			public int getStateId(){return 9;}
		},
		PLAYER_1_ANSWERED_QUESTION_INCORRECT{
			@Override
			public int getStateId(){return 10;}
		},
		PLAYER_2_ANSWERED_QUESTION_INCORRECT{
			@Override
			public int getStateId(){return 11;}
		},
		PLAYER_3_ANSWERED_QUESTION_INCORRECT{
			@Override
			public int getStateId(){return 12;}
		},
		PLAYER_4_ANSWERED_QUESTION_INCORRECT{
			@Override
			public int getStateId(){return 13;}
		},
		ROLL_DICE{
			@Override
			public int getStateId(){return 14;}
		},
		PLAYER_1_WINS{
			@Override
			public int getStateId(){return 18;}
		},
		PLAYER_2_WINS{
			@Override
			public int getStateId(){return 19;}
		},
		PLAYER_3_WINS{
			@Override
			public int getStateId(){return 20;}
		},
		PLAYER_4_WINS{
			@Override
			public int getStateId(){return 21;}
		},
		PLAYER_SPINS_AGAIN{
			@Override
			public int getStateId(){return 22;}
		},
		ANSWERING_QUESTION_TIME_UP{
			@Override
			public int getStateId(){return 23;}
		},
		STARTING_NEW_GAME{
			@Override
			public int getStateId(){return 24;}
		},
		CREATE_PLAYERS{
			@Override
			public int getStateId(){return 25;}
		},
		HIGHLIGHT_MOVE_OPTIONS{
			@Override
			public int getStateId(){return 26;}
		},
		ASK_QUESTION{
			@Override
			public int getStateId(){return 27;}
		},
		NULL{
			@Override
			public int getStateId(){return 28;}
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
		
		categoryDatabase.addAll(DefaultQuestionsGenerator
				.addDefaultQuestionsGenerator());
		
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
				if(((ColorDrawable)v.getBackground()).getColor() == Color.YELLOW){
					Toast.makeText(getApplicationContext(), "Selected move", Toast.LENGTH_SHORT).show();
					//move current player ones token to that spot
					setPlayerToken(0, BoardPosition.COORDINATES_0_0);
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
		// TODO Auto-generated method stub
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
			case CREATE_PLAYERS:
				
				ArrayList<Player> players = (ArrayList<Player>) intent.getSerializableExtra(Constants.NEW_PLAYERS_TAG);
				playerDatabase.clear();
				
				for(int i = 0; i < players.size(); i++){
					playerDatabase.add(players.get(i));
				}
				
				// Sets all the tokens to invisible when the game starts
				removeAllPlayerTokens();
				
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
		playerDatabase.get(playerIndex).setPosition(position);
		
		for(int i = 0; i < positions.size(); i++){
			if(playerDatabase.get(playerIndex).getPosition().getPosition().getX() == positions.get(i).getPosition().getX() &&
					playerDatabase.get(playerIndex).getPosition().getPosition().getY() == positions.get(i).getPosition().getY()){
				for(int x = 0; x < Constants.MAX_NUMBER_OF_CATEGORIES; x++){
					((ImageView) findViewById(positions.get(i).getTokenCategoryImageViewIdentifier(x, playerIndex))).setVisibility(View.VISIBLE);
				}
			}
			updatePositionColors();
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
		for(int i = 0; i < positions.size(); i++){
			for(int x = 0; x < Constants.MAX_NUMBER_OF_CATEGORIES; x++){
				((ImageView) findViewById(positions.get(i).getTokenCategoryImageViewIdentifier(x, playerIndex))).setVisibility(View.INVISIBLE);
			}
			updatePositionColors();
		}
	}
	
	public void updatePositionColors(){
		List<BoardPosition> positions = BoardPosition.getValues();
		for(int i = 0; i < positions.size(); i++){
			// Set the board positions to the color of the categories
			int categoryIndex = positions.get(i).getCategoryIndex();
			// Index equals -1 if the color doesn't change because it's a roll again or center hub position
			if(categoryIndex != -1){
				int categoryColor = categoryDatabase.get(categoryIndex).getColor();
				((GridLayout) findViewById(positions.get(i).getPositionIdentifier())).setBackgroundColor(categoryColor);
			}
		}
	}
	
	public boolean isGameOver(){
		//does a player have all the tokens and on the center hub and answered the last question correct
		return false;
	}
	
	public void updatePlayerStatus(){
		for(int i = 0; i < playerDatabase.size(); i++){
			GridLayout layout = (GridLayout) findViewById(playerDatabase.get(i).getPosition().getTokenCategoryIdentifier(i));
			Player player = playerDatabase.get(i);
			boolean[] arrays = player.getCategoryArray();
			
			ImageView imageview;
			if(arrays[0]){
				imageview = (ImageView) findViewById(playerDatabase.get(i).getPosition().getTokenCategoryImageViewIdentifier(i, 0));
				imageview.setVisibility(View.VISIBLE);
			}
				
			if(arrays[1]){
				imageview = (ImageView) findViewById(playerDatabase.get(i).getPosition().getTokenCategoryImageViewIdentifier(i, 1));
				imageview.setVisibility(View.VISIBLE);
			}
			
			if(arrays[2]){
				imageview = (ImageView) findViewById(playerDatabase.get(i).getPosition().getTokenCategoryImageViewIdentifier(i, 2));
				imageview.setVisibility(View.VISIBLE);
			}
			
			if(arrays[3]){
				imageview = (ImageView) findViewById(playerDatabase.get(i).getPosition().getTokenCategoryImageViewIdentifier(i, 3));
				imageview.setVisibility(View.VISIBLE);
			}
			
			layout.setVisibility(View.VISIBLE);
		}
		
		if(playerDatabase.size() >= 1){
			currentPlayerSlot.setText(playerDatabase.get(0).getName());
		} else{
			currentPlayerSlot.setText("");
		}
		
		if(playerDatabase.size() >= 2){
			secondPlayerSlot.setText(playerDatabase.get(1).getName());
		} else{
			secondPlayerSlot.setText("");
		}
		
		if(playerDatabase.size() >= 3){
			thirdPlayerSlot.setText(playerDatabase.get(2).getName());
		} else{
			thirdPlayerSlot.setText("");
		}
		
		if(playerDatabase.size() >= 4){
			fourthPlayerSlot.setText(playerDatabase.get(3).getName());
		} else{
			fourthPlayerSlot.setText("");
		}
	}
	
	public GameState continueGame(GameState currentState){
		GameState newState = GameState.NULL;
		
		switch(currentState){
		case STARTING_NEW_GAME:
			DialogCreatePlayers dialog = new DialogCreatePlayers();
			dialog.show(getFragmentManager(), ABaseDialog.TAG_DIALOG_FRAGMENT);
			break;
		case ROLL_DICE:
			dice.setVisibility(View.VISIBLE);
			rollResult.setText("?");
			Toast.makeText(getApplicationContext(), playerDatabase.get(0).getName() + ": Roll the dice!", Toast.LENGTH_SHORT).show();
			break;
		case HIGHLIGHT_MOVE_OPTIONS:
			List<BoardPosition> boardPositions = BoardPosition.getValues();
			ArrayList<Position> positions = Utils.getValidMoves(Integer.parseInt(rollResult.getText().toString()), playerDatabase.get(0).getPosition().getPosition());
			for (int i = 0; i < positions.size(); i++)
			{
				for (int x = 0; x < boardPositions.size(); x++){
					if(positions.get(i).getX() == boardPositions.get(x).getPosition().getX() &&
							positions.get(i).getY() == boardPositions.get(x).getPosition().getY()){
						GridLayout gridView = (GridLayout) findViewById(boardPositions.get(x).getPositionIdentifier());
						gridView.setBackgroundColor(Color.YELLOW);
					}
				}
			}
			break;
		case ASK_QUESTION:
			DialogAskQuestion questionDialog = new DialogAskQuestion();
			// need to send dialog the category to display
			questionDialog.show(getFragmentManager(), ABaseDialog.TAG_DIALOG_FRAGMENT);
			break;
		}
		
		return newState;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.dice_imageView:
			rollResult.setText(String.valueOf(Utils.generateRandomNumber()));
			//rollResult.setText("6");
			dice.setVisibility(View.INVISIBLE);
			continueGame(GameState.HIGHLIGHT_MOVE_OPTIONS);
			// show the places to move and the use selects one before asking the question
			// send back to get next state
			//DialogAskQuestion dialog = new DialogAskQuestion();
			//dialog.show(getFragmentManager(), ABaseDialog.TAG_DIALOG_FRAGMENT);
			return;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		if(view.getId() == BoardPosition.COORDINATES_3_3.getPositionIdentifier()){
			int m = 0;
			m++;
		}
	}
}
