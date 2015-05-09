package com.bluebarracudas.trivialpursuit;


import Framework.ABaseDialog;
import Framework.ADialogAlert;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
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

public class DialogChooseCategories extends ADialogAlert {

	ArrayList<Category> mCategories = new ArrayList<Category>();
	private ArrayList<String> mCategoryNames = new ArrayList<String>();
	private ArrayList<Boolean> mCategoryBool = new ArrayList<Boolean>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		final Bundle intentBundle = getArguments();
		
		final int size = intentBundle.getInt(Constants.CATEGORY_DATABASE_TAG);
		
		for(int i = 0; i < size; i++){
			mCategories.add((Category) intentBundle.getParcelable(String.valueOf(i)));
			String color = null;
			if(mCategories.get(i).getColor() == Color.GREEN){
				color = "Green";
			} else if(mCategories.get(i).getColor() == Color.BLUE){
				color = "Blue";
			} else if(mCategories.get(i).getColor() == Color.RED){
				color = "Red";
			} else {
				color = "White";
			}
			mCategoryNames.add(mCategories.get(i).getName() + ": " + color);
			mCategoryBool.add(false);
		}
    }

    @Override
    public Builder buildDialog(Builder builder) {
        builder.setTitle("Choose Categories");
        
        boolean[] array = new boolean[mCategoryNames.size()];
        for (int i = 0; i < mCategoryNames.size(); i++) {
          array[i] = false;
        }
        
        final ArrayList<Boolean> defaultSelection = new ArrayList<Boolean>();
        
        for(int i = 0; i < mCategoryNames.size(); i++){
        	defaultSelection.add(false);
        }
        
        builder.setMultiChoiceItems(mCategoryNames.toArray(new CharSequence[mCategoryNames.size()]), array, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
        		mCategoryBool.set(which, !mCategoryBool.get(which));
            }
        });

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                //Do nothing here because we override this button later to change the close behaviour.
                //However, we still need this because on older versions of Android unless we
                //pass a handler the button doesn't get instantiated
            }
        });
        return builder;
    }

    @Override
    public void onStart(){
        super.onStart();    //super.onStart() is where dialog.show() is actually called on the underlying dialog, so we have to do it after this point

        // The onClick listener is done this way so the dialog doesn't dismiss when the 'OK' button is pressed
        // and the coordinates are wrong
        AlertDialog d = (AlertDialog)getDialog();
        if(d != null)
        {
            android.widget.Button positiveButton = (android.widget.Button) d.getButton(Dialog.BUTTON_POSITIVE);
            positiveButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {	
                	int numberOfCategories = 0;
                	for(int i = 0; i < mCategoryBool.size(); i ++){
                		if(mCategoryBool.get(i)){
                			numberOfCategories++;
                		}
                	}
                	
                	if(numberOfCategories != 4){
                		Toast.makeText(getActivity(), "Four categories need to be chosen", Toast.LENGTH_SHORT).show();
                		return;
                	} else{
                		ArrayList<Category> selectedCategories = new ArrayList<Category>();
                		
                    	for(int i = 0; i < mCategoryBool.size(); i ++){
                    		if(mCategoryBool.get(i)){
                    			selectedCategories.add(0, mCategories.get(i));
                    			if(selectedCategories.get(0).getQuestionArray().size() == 0){
                    				Toast.makeText(getActivity(), "You can't select a category that doesn't have questions.", Toast.LENGTH_SHORT).show();
                    				return;
                    			}
                    		} else{
                    			selectedCategories.add(selectedCategories.size(), mCategories.get(i));
                    		}
                    	}
                    	
                    	if(selectedCategories.get(0).getColor() == selectedCategories.get(1).getColor() || 
                    			selectedCategories.get(0).getColor() == selectedCategories.get(2).getColor() ||
                    			selectedCategories.get(0).getColor() == selectedCategories.get(3).getColor() ||
                    			selectedCategories.get(1).getColor() == selectedCategories.get(2).getColor() || 
                    			selectedCategories.get(1).getColor() == selectedCategories.get(3).getColor() || 
                    			selectedCategories.get(3).getColor() == selectedCategories.get(2).getColor()){
                    		Toast.makeText(getActivity(), "Categories can't have the same colors", Toast.LENGTH_SHORT).show();
                    		return;
                    	} else {
                    		final Intent intent = new Intent(Constants.ACTION_GAME_STATE_CHANGE);
                    		intent.putExtra(Constants.GAME_STATE_TAG, GameStateMachine.GameState.CHOOSE_CATEGORIES.getStateId());
                    		intent.putExtra(Constants.CATEGORY_DATABASE_TAG, selectedCategories.size());
                    		for(int i = 0; i < selectedCategories.size(); i++){
                    			intent.putExtra(String.valueOf(i), selectedCategories.get(i));
                    		}
                    		getActivity().sendBroadcast(intent);
                    	}	
                    	dismiss();
                	}
                }
            });
        }
    }
}
