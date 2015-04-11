package com.bluebarracudas.trivialpursuit;

import java.util.ArrayList;

import com.bluebarracudas.trivialpursuit.Classes.Category;
import com.bluebarracudas.trivialpursuit.Classes.Player;
import com.bluebarracudas.trivialpursuit.Utilities.DefaultQuestionsGenerator;

import Framework.ABaseDialog;
import Framework.ADialogAlert;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	public final ArrayList<Category> categoryDatabase = new ArrayList<Category>();
	public final ArrayList<Player> playerDatabase = new ArrayList<Player>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		categoryDatabase.addAll(DefaultQuestionsGenerator
				.addDefaultQuestionsGenerator());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		switch (item.getItemId()) {
		case R.id.action_settings:
			return true;
		case R.id.menu_new_game:
			// open new game question dialog screen to start game
			Intent intents = new Intent(this, GameStateMachine.class);
			
			startActivity(intents);
			return true;
		case R.id.menu_question_database:
			// open question database fragment
			Intent intent = new Intent(this, CategoryActivity.class);
			intent.putExtra(Constants.CATEGORY_DATABASE_TAG, categoryDatabase.size());
			for(int i = 0; i < categoryDatabase.size(); i++){
				intent.putExtra(String.valueOf(i), categoryDatabase.get(i));
			}
			
			startActivity(intent);
			return true;
		case R.id.menu_save:
			/*String csv = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
			CSVWriter writer = new CSVWriter(new FileWriter(csv));

			List<String[]> data = new ArrayList<String[]>();
			data.add(new String[] {"India", "New Delhi"});
			data.add(new String[] {"United States", "Washington D.C"});
			data.add(new String[] {"Germany", "Berlin"});

			writer.writeAll(data);

			writer.close();
			finish();
			System.exit(0);*/
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
