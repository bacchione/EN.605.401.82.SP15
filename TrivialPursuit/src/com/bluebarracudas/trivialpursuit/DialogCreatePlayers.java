package com.bluebarracudas.trivialpursuit;

import Framework.ABaseDialog;
import Framework.ADialogAlert;
import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bluebarracudas.trivialpursuit.Classes.BoardPosition;
import com.bluebarracudas.trivialpursuit.Classes.Category;
import com.bluebarracudas.trivialpursuit.Classes.Player;
import com.bluebarracudas.trivialpursuit.Classes.Question;
import com.bluebarracudas.trivialpursuit.Utilities.Utils;

public class DialogCreatePlayers extends ADialogAlert implements OnClickListener, View.OnClickListener {

	public class PlayerCreation implements Comparable{
		public Player player;
		public int diceValue;
		
		public PlayerCreation(Player player, int diceValue) {
			super();
			this.player = player;
			this.diceValue = diceValue;
		}

		@Override
		public int compareTo(Object comparestu) {
	        int compareage=((PlayerCreation)comparestu).diceValue;
	        return compareage - this.diceValue;
		}
	}
	
	ArrayList<PlayerCreation> playerList = new ArrayList<PlayerCreation>();

	private EditText mEditTextPlayer1;
	private EditText mEditTextPlayer2;
	private EditText mEditTextPlayer3;
	private EditText mEditTextPlayer4;
	
	private ImageView mImageViewPlayer1;
	private ImageView mImageViewPlayer2;
	private ImageView mImageViewPlayer3;
	private ImageView mImageViewPlayer4;
	
	private TextView mTextViewPlayer1;
	private TextView mTextViewPlayer2;
	private TextView mTextViewPlayer3;
	private TextView mTextViewPlayer4;

	@SuppressLint("InflateParams")
	@Override
	public Builder buildDialog(Builder builder) {

		final LayoutInflater inflater = (LayoutInflater) getActivity()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		final View view = inflater.inflate(R.layout.player_creation_fragments, null, false);

		mEditTextPlayer1 = (EditText) view.findViewById(R.id.editTextPlayer1);
		mEditTextPlayer2 = (EditText) view.findViewById(R.id.editTextPlayer2);
		mEditTextPlayer3 = (EditText) view.findViewById(R.id.editTextPlayer3);
		mEditTextPlayer4 = (EditText) view.findViewById(R.id.editTextPlayer4);
		
		mImageViewPlayer1 = (ImageView) view.findViewById(R.id.dice_imageView_player_1);
		mImageViewPlayer2 = (ImageView) view.findViewById(R.id.dice_imageView_player_2);
		mImageViewPlayer3 = (ImageView) view.findViewById(R.id.dice_imageView_player_3);
		mImageViewPlayer4 = (ImageView) view.findViewById(R.id.dice_imageView_player_4);
		
		mTextViewPlayer1 = (TextView) view.findViewById(R.id.dice_result_player_1);
		mTextViewPlayer2 = (TextView) view.findViewById(R.id.dice_result_player_2);
		mTextViewPlayer3 = (TextView) view.findViewById(R.id.dice_result_player_3);
		mTextViewPlayer4 = (TextView) view.findViewById(R.id.dice_result_player_4);
		
		mImageViewPlayer1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
		
				if(mEditTextPlayer1.getText().toString().equals(""))
					return;
				
				for(int i = 0; i < playerList.size(); i++){
					if(playerList.get(i).player.getName().equals(mEditTextPlayer1.getText().toString()))
						return;
				}
				
				mEditTextPlayer1.setEnabled(false);
				
				int diceValue = Utils.generateRandomNumber();
				
				boolean findingDiceValue = true;
				while(findingDiceValue && playerList.size() != 0){
					diceValue = Utils.generateRandomNumber();
					for(int i = 0; i < playerList.size(); i++){
						if(playerList.get(i).diceValue != diceValue){
							findingDiceValue = false;
						} else{
							findingDiceValue = true;
							break;
						}
					}
				}
				
				PlayerCreation player = 
						new PlayerCreation(new Player(mEditTextPlayer1.getText().toString(), 
								BoardPosition.COORDINATES_3_3, 
								new boolean[]{false, false, false, false}), diceValue);
				
				playerList.add(player);
				
				mImageViewPlayer1.setVisibility(View.GONE);
				mTextViewPlayer1.setText(String.valueOf(diceValue));
			}
		});
		
		mImageViewPlayer2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(mEditTextPlayer2.getText().toString().equals(""))
					return;
				
				for(int i = 0; i < playerList.size(); i++){
					if(playerList.get(i).player.getName().equals(mEditTextPlayer2.getText().toString()))
						return;
				}
				
				mEditTextPlayer2.setEnabled(false);
				
				int diceValue = Utils.generateRandomNumber();
				
				boolean findingDiceValue = true;
				while(findingDiceValue && playerList.size() != 0){
					diceValue = Utils.generateRandomNumber();
					for(int i = 0; i < playerList.size(); i++){
						if(playerList.get(i).diceValue != diceValue){
							findingDiceValue = false;
						} else{
							findingDiceValue = true;
							break;
						}
					}
				}
				
				PlayerCreation player = 
						new PlayerCreation(new Player(mEditTextPlayer2.getText().toString(), 
								BoardPosition.COORDINATES_3_3, 
								new boolean[]{false, false, false, false}), diceValue);
				
				playerList.add(player);
				
				mImageViewPlayer2.setVisibility(View.GONE);
				mTextViewPlayer2.setText(String.valueOf(diceValue));
			}
		});
		
		mImageViewPlayer3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(mEditTextPlayer3.getText().toString().equals(""))
					return;
				
				for(int i = 0; i < playerList.size(); i++){
					if(playerList.get(i).player.getName().equals(mEditTextPlayer3.getText().toString()))
						return;
				}
				
				mEditTextPlayer3.setEnabled(false);
				
				int diceValue = Utils.generateRandomNumber();
				
				boolean findingDiceValue = true;
				while(findingDiceValue && playerList.size() != 0){
					diceValue = Utils.generateRandomNumber();
					for(int i = 0; i < playerList.size(); i++){
						if(playerList.get(i).diceValue != diceValue){
							findingDiceValue = false;
						} else{
							findingDiceValue = true;
							break;
						}
					}
				}
				
				PlayerCreation player = 
						new PlayerCreation(new Player(mEditTextPlayer3.getText().toString(), 
								BoardPosition.COORDINATES_3_3, 
								new boolean[]{false, false, false, false}), diceValue);
				
				playerList.add(player);
				
				mImageViewPlayer3.setVisibility(View.GONE);
				mTextViewPlayer3.setText(String.valueOf(diceValue));
			}
		});
		
		mImageViewPlayer4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(mEditTextPlayer4.getText().toString().equals(""))
					return;
				
				for(int i = 0; i < playerList.size(); i++){
					if(playerList.get(i).player.getName().equals(mEditTextPlayer4.getText().toString()))
						return;
				}
				
				mEditTextPlayer4.setEnabled(false);
				
				int diceValue = Utils.generateRandomNumber();
				
				boolean findingDiceValue = true;
				while(findingDiceValue && playerList.size() != 0){
					diceValue = Utils.generateRandomNumber();
					for(int i = 0; i < playerList.size(); i++){
						if(playerList.get(i).diceValue != diceValue){
							findingDiceValue = false;
						} else{
							findingDiceValue = true;
							break;
						}
					}
				}
				
				PlayerCreation player = 
						new PlayerCreation(new Player(mEditTextPlayer4.getText().toString(), 
								BoardPosition.COORDINATES_3_3, 
								new boolean[]{false, false, false, false}), diceValue);
				
				playerList.add(player);
				
				mImageViewPlayer4.setVisibility(View.GONE);
				mTextViewPlayer4.setText(String.valueOf(diceValue));
			}
		});
		
		// REMOVE THIS WHEN IMPLEMENTED
		mEditTextPlayer1.setText("John");
		mEditTextPlayer2.setText("Sam");
		mEditTextPlayer3.setText("Thomas");
		mEditTextPlayer4.setText("Tony");

		builder.setView(view);
		builder.setTitle("Add Players");
		builder.setPositiveButton(android.R.string.ok, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {

				// Add valid player entries
				
				if(playerList.size() < 2)
				{
					Toast.makeText(getActivity(), "Not enough players were set.", Toast.LENGTH_SHORT).show();
					getActivity().finish();
					return;
				}
				
				// Put in ranked order
				Collections.sort(playerList);
				
				ArrayList<Player> players = new ArrayList<Player>();
				
				for(int i = 0; i < playerList.size(); i++){
					players.add(playerList.get(i).player);
				}
				
				final Intent intent = new Intent(Constants.ACTION_GAME_STATE_CHANGE);
				intent.putExtra(Constants.GAME_STATE_TAG, GameStateMachine.GameState.CREATE_PLAYERS.getStateId());
				intent.putExtra(Constants.NEW_PLAYERS_TAG, players);
				getActivity().sendBroadcast(intent);
			
				dismiss();
			}
		} );
		
		return builder;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}
}
