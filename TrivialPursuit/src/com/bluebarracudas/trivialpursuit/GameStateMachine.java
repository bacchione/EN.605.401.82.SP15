package com.bluebarracudas.trivialpursuit;

import java.util.ArrayList;
import java.util.List;

import com.bluebarracudas.trivialpursuit.Classes.BoardPosition;
import com.bluebarracudas.trivialpursuit.Classes.Category;
import com.bluebarracudas.trivialpursuit.Classes.Player;
import com.bluebarracudas.trivialpursuit.Classes.Position;
import com.bluebarracudas.trivialpursuit.Utilities.Utils;

import Framework.ABaseDialog;
import android.R.anim;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameStateMachine extends Activity implements OnClickListener {

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
		NULL{
			@Override
			public int getStateId(){return 27;}
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
	//private View boardGameView;
	
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
				
				nextGameState = GameState.ROLL_DICE;
				break;
			}
			
			updatePlayerStatus();
			continueGame(nextGameState);
		}
	};
	
	public void updatePlayerStatus(){
		if(playerDatabase.size() >= 1)
			currentPlayerSlot.setText(playerDatabase.get(0).getName());
		
		if(playerDatabase.size() >= 2)
			secondPlayerSlot.setText(playerDatabase.get(1).getName());
		
		if(playerDatabase.size() >= 3)
			thirdPlayerSlot.setText(playerDatabase.get(2).getName());
		
		if(playerDatabase.size() >= 4)
			fourthPlayerSlot.setText(playerDatabase.get(3).getName());
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
						GridView gridView = (GridView) findViewById(boardPositions.get(x).getIdentifier());
						gridView.setBackgroundColor(Color.YELLOW);
					}
				}
			}
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
			dice.setVisibility(View.INVISIBLE);
			continueGame(GameState.HIGHLIGHT_MOVE_OPTIONS);
			// show the places to move and the use selects one before asking the question
			// send back to get next state
			//DialogAskQuestion dialog = new DialogAskQuestion();
			//dialog.show(getFragmentManager(), ABaseDialog.TAG_DIALOG_FRAGMENT);
			return;
		}
	}
}
