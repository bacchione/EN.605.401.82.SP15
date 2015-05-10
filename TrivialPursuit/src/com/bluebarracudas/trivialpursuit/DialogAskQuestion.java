package com.bluebarracudas.trivialpursuit;

import Framework.ABaseDialog;
import Framework.ADialogAlert;
import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import com.bluebarracudas.trivialpursuit.Classes.Category;
import com.bluebarracudas.trivialpursuit.Classes.Question;
import com.bluebarracudas.trivialpursuit.Utilities.DefaultQuestionsGenerator;
import com.bluebarracudas.trivialpursuit.Utilities.Utils;

public class DialogAskQuestion extends ADialogAlert implements OnClickListener {

	private TextView mEditTextQuestion;
	private EditText mEditTextAnswer;

	private Question mQuestion;
	
	private ProgressBar mProgress;
	CountDownTimer mCountDownTimer;
	int i = 100;
	private boolean debug = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final Bundle bundle = getArguments();
	    mQuestion = (Question) bundle.getParcelable(Constants.CHOSEN_QUESTION_TAG);
	}

	@SuppressLint("InflateParams")
	@Override
	public Builder buildDialog(Builder builder) {

		final LayoutInflater inflater = (LayoutInflater) getActivity()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		final View view = inflater.inflate(R.layout.question_display_fragment, null, false);

		mEditTextQuestion = (TextView) view.findViewById(R.id.question);
		mEditTextAnswer = (EditText) view.findViewById(R.id.editTextAnswer);
		
		mProgress = (ProgressBar) view.findViewById(R.id.progressBarTimer);
		mProgress.setProgress(i);
		   mCountDownTimer=new CountDownTimer(20000,200) {

		        @Override
		        public void onTick(long millisUntilFinished) {
		            //Log.v("Log_tag", "Tick of Progress"+ i + millisUntilFinished);
		            i--;
		            mProgress.setProgress(i);

		        }

		        @Override
		        public void onFinish() {
		        //Do what you want 
		            i--;
		            mProgress.setProgress(i);
					final Intent intent = new Intent(Constants.ACTION_GAME_STATE_CHANGE);
					intent.putExtra(Constants.GAME_STATE_TAG, GameStateMachine.GameState.ANSWERED_QUESTION.getStateId());
					intent.putExtra(Constants.ASK_QUESTION_RESULT, false);
					getActivity().sendBroadcast(intent);
					dismiss();
		            // return from result as wrong
		        }
		    };
		    mCountDownTimer.start();

		mEditTextQuestion.setText(mQuestion.getQuestion());
		
		if(debug){
			mEditTextAnswer.setText(mQuestion.getAnswer());
		}

		builder.setView(view);
		builder.setTitle("Question");
		builder.setCancelable(false);
		builder.setPositiveButton("Submit", this);

		return builder;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		switch(which){
		case DialogInterface.BUTTON_POSITIVE:
			mCountDownTimer.cancel();
			final Intent intent = new Intent(Constants.ACTION_GAME_STATE_CHANGE);
			intent.putExtra(Constants.GAME_STATE_TAG, GameStateMachine.GameState.ANSWERED_QUESTION.getStateId());

			if(mEditTextAnswer.getText().toString().equalsIgnoreCase(mQuestion.getAnswer())){
				// return true
				intent.putExtra(Constants.ASK_QUESTION_RESULT, true);
			} else {
				// return wrong
				intent.putExtra(Constants.ASK_QUESTION_RESULT, false);
			}
			
			getActivity().sendBroadcast(intent);
			break;
		}
	}
}
