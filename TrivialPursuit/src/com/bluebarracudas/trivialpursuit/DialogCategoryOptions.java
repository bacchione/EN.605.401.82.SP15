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

public class DialogCategoryOptions extends ADialogAlert implements OnClickListener {

	private EditText mEditTextCategoryName;
	private RadioButton mRadioButtonRed;
	private RadioButton mRadioButtonBlue;
	private RadioButton mRadioButtonGreen;
	private RadioButton mRadioButtonWhite;

	private Category mCategory;
	private int categoryIndex;
	
	private String[] mOptions = {"Edit", "Remove"};

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
		builder.setTitle("Select Category Options");
		builder.setItems(mOptions, this);
		builder.setPositiveButton(android.R.string.cancel, this);
		builder.setCancelable(false);

		return builder;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		final Intent intent = new Intent("Update Categories");
		intent.putExtra("Reset Category Edit", -1);
		getActivity().sendBroadcast(intent);
	};
	
	@Override
	public void onClick(DialogInterface dialog, int which) {
		switch (which) {
		case 0:
			//edit
			//Toast.makeText(getActivity(), "Edit", Toast.LENGTH_LONG).show();
			final Bundle bundle = new Bundle();
			bundle.putParcelable(Constants.CHOOSE_CATEGORY, mCategory);
			bundle.putInt("Category Index", categoryIndex);
			DialogEditCategory dialogs = new DialogEditCategory();
			dialogs.setArguments(bundle);
			dialogs.show(getFragmentManager(), ABaseDialog.TAG_DIALOG_FRAGMENT);
			break;
		case 1:
			//remove
			//Toast.makeText(getActivity(), "Remove", Toast.LENGTH_LONG).show();
			final Intent intent = new Intent("Update Categories");
			intent.putExtra("Remove Category Index", categoryIndex);
			getActivity().sendBroadcast(intent);
			break;
		}
		dismiss();
	}
}
