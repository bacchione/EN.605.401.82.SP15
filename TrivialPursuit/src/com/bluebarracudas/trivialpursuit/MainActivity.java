package com.bluebarracudas.trivialpursuit;

import java.util.ArrayList;

import com.bluebarracudas.trivialpursuit.Classes.Category;
import com.bluebarracudas.trivialpursuit.Classes.GameInformation;
import com.bluebarracudas.trivialpursuit.Classes.Player;
import com.bluebarracudas.trivialpursuit.Utilities.DefaultQuestionsGenerator;

import Framework.ABaseDialog;
import Framework.ADialogAlert;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	public ArrayList<Category> categoryDatabase = new ArrayList<Category>();
	public final ArrayList<Player> playerDatabase = new ArrayList<Player>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		categoryDatabase.addAll(DefaultQuestionsGenerator
				.addDefaultQuestionsGenerator());
		
		final IntentFilter updatefilter = new IntentFilter();
		updatefilter.addAction("Update Category Database");
        this.registerReceiver(mCategoryDatabaseEditorReceiver, updatefilter);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();

		this.unregisterReceiver(mCategoryDatabaseEditorReceiver);
	}
	
	private final BroadcastReceiver mCategoryDatabaseEditorReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			final int size = intent.getExtras().getInt(Constants.CATEGORY_DATABASE_TAG);
			categoryDatabase = new ArrayList<Category>();
			for(int i = 0; i < size; i++){
				categoryDatabase.add((Category) intent.getExtras().getParcelable(String.valueOf(i)));
			}
			
		};
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public GameInformation readDatabaseInformation(){
		// Not implemented
		return new GameInformation(categoryDatabase, playerDatabase, 0);
	}
	
	public void writeDatabaseInformation(GameInformation gameInformation){
		// Not implemented
	}
	
	public void saveAndClose(){
		finish();
		System.exit(0);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		switch (item.getItemId()) {
		case R.id.menu_new_game:
			// open new game question dialog screen to start game
			Intent intents = new Intent(this, GameStateMachine.class);
			intents.putExtra(Constants.CATEGORY_DATABASE_TAG, categoryDatabase.size());
			for(int i = 0; i < categoryDatabase.size(); i++){
				intents.putExtra(String.valueOf(i), categoryDatabase.get(i));
			}
			startActivity(intents);
			return true;
		case R.id.menu_question_database:
			// open question database fragment
			Intent intent = new Intent(this, CategoryActivity.class);
			intent.putExtra(Constants.CATEGORY_DATABASE_TAG, categoryDatabase.size());
			intent.putExtra(Constants.CHOOSE_CATEGORY, false);
			for(int i = 0; i < categoryDatabase.size(); i++){
				intent.putExtra(String.valueOf(i), categoryDatabase.get(i));
			}
			
			startActivity(intent);
			return true;
		case R.id.menu_save:
			saveAndClose();
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
