package com.bluebarracudas.trivialpursuit;

import Framework.ABaseDialog;
import Framework.ADialogAlert;
import Framework.CategoryAdapter;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
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
import android.widget.ListView;
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

public class DialogSelectHubCategory extends ADialogAlert implements OnClickListener {
	
	ArrayList<Category> mCategories = new ArrayList<Category>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

		final Bundle intentBundle = getArguments();
		
		final int size = intentBundle.getInt(Constants.CATEGORY_DATABASE_TAG);
		
		for(int i = 0; i < size; i++){
			mCategories.add((Category) intentBundle.getParcelable(String.valueOf(i)));
		}
    }
    
	@Override
	public Builder buildDialog(Builder builder) {

        final List<String> vals = new ArrayList<String>();
        
        for(int i = 0; i < mCategories.size(); i++){
        	vals.add(mCategories.get(i).getName());
        }

        int selected = -1;

        builder.setTitle("Choose Category");
        builder.setSingleChoiceItems(vals.toArray(new CharSequence[vals.size()]), selected, this);
		
		return builder;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		final String selectedCategory = (String) ((AlertDialog)dialog).getListView().getAdapter().getItem(((AlertDialog)dialog).getListView().getCheckedItemPosition());
		int position = 0;

        for(int i = 0; i < mCategories.size(); i++){
        	if(selectedCategory == mCategories.get(i).getName()){
        		position = i;
        		break;
        	}
        }
		
		final Intent intent = new Intent(Constants.ACTION_GAME_STATE_CHANGE);
		intent.putExtra(Constants.GAME_STATE_TAG, GameStateMachine.GameState.ASK_HUB_CATEGORY.getStateId());
		intent.putExtra(Constants.CHOOSE_CATEGORY, position);
		getActivity().sendBroadcast(intent);
		dismiss();
	}
}
