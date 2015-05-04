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
import android.widget.Toast;

import java.util.ArrayList;

import com.bluebarracudas.trivialpursuit.Classes.Category;
import com.bluebarracudas.trivialpursuit.Classes.Question;
import com.bluebarracudas.trivialpursuit.Utilities.Utils;

public class DialogEditQuestion extends ADialogAlert implements OnClickListener {

	private EditText mEditTextQuestion;
	private EditText mEditTextAnswer;
	private EditText mEditTextWrongAnswerOne;
	private EditText mEditTextWrongAnswerTwo;
	private EditText mEditTextWrongAnswerThree;

	private Question mQuestion;
	private int questionIndex;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final Bundle bundle = getArguments();
		mQuestion = (Question) bundle.getParcelable(Constants.QUESTION_TAG);
		questionIndex = (int) bundle.getInt("Question Index");
	}

	@SuppressLint("InflateParams")
	@Override
	public Builder buildDialog(Builder builder) {

		final LayoutInflater inflater = (LayoutInflater) getActivity()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		final View view = inflater.inflate(R.layout.question_builder_fragment, null, false);

		mEditTextQuestion = (EditText) view.findViewById(R.id.question_editText);
		mEditTextAnswer = (EditText) view.findViewById(R.id.answer_editText);

		if(mQuestion.getQuestion() != null){
			mEditTextQuestion.setText(mQuestion.getQuestion());
			mEditTextAnswer.setText(mQuestion.getAnswer());
			builder.setTitle("Edit Question");
		} else {
			builder.setTitle("Add Question");
		}

		builder.setView(view);
		
		builder.setPositiveButton(android.R.string.ok, this);
		builder.setNegativeButton(android.R.string.cancel, null);

		return builder;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		switch (which) {
		case DialogInterface.BUTTON_POSITIVE:
		
			mQuestion.setQuestion(mEditTextQuestion.getText().toString());
			mQuestion.setAnswer(mEditTextAnswer.getText().toString());
			
			if(!mEditTextQuestion.getText().toString().matches("") && !mEditTextAnswer.getText().toString().matches("")){
				final Intent intent = new Intent(Constants.UPDATE_QUESTION_TAG);
				intent.putExtra("Question Index", questionIndex);
				intent.putExtra(Constants.QUESTION_TAG, mQuestion);
				getActivity().sendBroadcast(intent);
			}
			break;
		}
		dismiss();
	}
}
