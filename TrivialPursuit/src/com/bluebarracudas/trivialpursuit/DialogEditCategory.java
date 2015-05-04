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
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

import com.bluebarracudas.trivialpursuit.Classes.Category;
import com.bluebarracudas.trivialpursuit.Classes.Question;
import com.bluebarracudas.trivialpursuit.Utilities.Utils;

public class DialogEditCategory extends ADialogAlert implements OnClickListener {

	private EditText mEditTextCategoryName;
	private RadioButton mRadioButtonRed;
	private RadioButton mRadioButtonBlue;
	private RadioButton mRadioButtonGreen;
	private RadioButton mRadioButtonWhite;

	private Category mCategory;
	private int categoryIndex;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final Bundle bundle = getArguments();
		mCategory = (Category) bundle.getParcelable(Constants.CHOOSE_CATEGORY);
		categoryIndex = (int) bundle.getInt("Category Index");
	}

	@SuppressLint("InflateParams")
	@Override
	public Builder buildDialog(Builder builder) {

		final LayoutInflater inflater = (LayoutInflater) getActivity()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		final View view = inflater.inflate(R.layout.category_builder_fragment, null, false);

		mEditTextCategoryName = (EditText) view.findViewById(R.id.categoryName_editText);
		mRadioButtonRed = (RadioButton) view.findViewById(R.id.radioRed);
		mRadioButtonBlue = (RadioButton) view.findViewById(R.id.radioBlue);
		mRadioButtonGreen = (RadioButton) view.findViewById(R.id.radioGreen);
		mRadioButtonWhite = (RadioButton) view.findViewById(R.id.radioWhite);

		if(mCategory.getName() != null){
			mEditTextCategoryName.setText(mCategory.getName());
			if(mCategory.getColor() == Color.RED){
				mRadioButtonRed.setChecked(true);
			} else if(mCategory.getColor() == Color.BLUE){
				mRadioButtonBlue.setChecked(true);
			} else if(mCategory.getColor() == Color.GREEN){
				mRadioButtonGreen.setChecked(true);
			} else {
				mRadioButtonWhite.setChecked(true);
			}
			builder.setTitle("Edit Category");
		} else {
			builder.setTitle("Add Category");
			mRadioButtonRed.setChecked(true);
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
		
			mCategory.setName(mEditTextCategoryName.getText().toString());
			
			if(mRadioButtonRed.isChecked()){
				mCategory.setColor(Color.RED);
			} else if(mRadioButtonBlue.isChecked()){
				mCategory.setColor(Color.BLUE);
			} else if(mRadioButtonWhite.isChecked()){
				mCategory.setColor(Color.WHITE);
			} else {
				mCategory.setColor(Color.GREEN);
			}
			
			if(mCategory.getName() != ""){
				// send broadcast
				final Intent intent = new Intent("Update Categories");
				intent.putExtra("Category Index", categoryIndex);
				intent.putExtra("Category Tag", mCategory);
				// causes for close
				//getActivity().sendBroadcast(intent);
			}
			
			break;
		}
		dismiss();
	}
}
