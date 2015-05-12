package com.bluebarracudas.trivialpursuit;

import java.util.ArrayList;

import com.bluebarracudas.trivialpursuit.DBAdapter;
import com.bluebarracudas.trivialpursuit.Classes.Category;
import com.bluebarracudas.trivialpursuit.Classes.GameInformation;
import com.bluebarracudas.trivialpursuit.Classes.Player;
import com.bluebarracudas.trivialpursuit.Classes.Question;
import com.bluebarracudas.trivialpursuit.Utilities.DefaultQuestionsGenerator;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	public ArrayList<Category> categoryDatabase = new ArrayList<Category>();
	public final ArrayList<Player> playerDatabase = new ArrayList<Player>();
	DBAdapter myDb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		openDB();
		Cursor cursor = myDb.getAllRows();
		cursor.moveToFirst();
		if(cursor.isAfterLast()){
			categoryDatabase.addAll(DefaultQuestionsGenerator
					.addDefaultQuestionsGenerator());
		}else{
			populateArrayListsFromDB();
		}
		
		final IntentFilter updatefilter = new IntentFilter();
		updatefilter.addAction("Update Category Database");
		this.registerReceiver(mCategoryDatabaseEditorReceiver, updatefilter);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		this.unregisterReceiver(mCategoryDatabaseEditorReceiver);
		closeDB();
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

		return new GameInformation(categoryDatabase, playerDatabase, 0);
	}

	public void writeDatabaseInformation(GameInformation gameInformation){
		// Not implemented
	}

	public void save(){
		updateDBWithArrayLists();
		Toast.makeText(getApplicationContext(), "Saved categories to database!", Toast.LENGTH_SHORT).show();
	}

	private void updateDBWithArrayLists(){
		myDb.deleteAll();
		//save questions
		for(int i=0 ; i < categoryDatabase.size(); i++){
			Category currCat = categoryDatabase.get(i);
			for(int j=0 ; j < currCat.getQuestionArray().size(); j++){
				Question currQuestion = currCat.getQuestionByIndex(j);
				myDb.insertRow(currQuestion.getQuestion(), currQuestion.getAnswer(), currCat.getName(), currCat.getColor());
			}
		}	
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		switch (item.getItemId()) {
		case R.id.menu_new_game:
			// open new game question dialog screen to start game
			if(categoryDatabase.size() < 4){
				Toast.makeText(getApplicationContext(), "At least 4 categories must exist to start the game", Toast.LENGTH_SHORT).show();
				return true;
			}

			for(int i = 0; i < categoryDatabase.size(); i++){
				if(categoryDatabase.get(i).getQuestionArray().size() == 0){
					Toast.makeText(getApplicationContext(), "Please make sure all categories have at least 1 question", Toast.LENGTH_SHORT).show();
					return true;
				}
			}

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
		case R.id.menu_restore_database:
			myDb.deleteAll();
			categoryDatabase.clear();
			categoryDatabase.addAll(DefaultQuestionsGenerator
					.addDefaultQuestionsGenerator());
			Toast.makeText(getApplicationContext(), "Restored category defaults to database!", Toast.LENGTH_SHORT).show();
			save();
			return true;
		case R.id.menu_save:
			save();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void openDB() {
		myDb = new DBAdapter(this);
		myDb.open();
	}
	private void closeDB() {
		myDb.close();
	}

	private void populateArrayListsFromDB() {
		Cursor cursor = myDb.getAllRows();
		if (cursor.moveToFirst()){
			ArrayList<Question> questionsToAdd = new ArrayList<Question>();
			ArrayList<String> categoriesToAdd = new ArrayList<String>();
			ArrayList<Integer> categoriesColors = new ArrayList<Integer>();
			//Gets questions and categories out of database
			while(!cursor.isAfterLast()){
				String id = cursor.getString(cursor.getColumnIndex(DBAdapter.KEY_ROWID));
				String question = cursor.getString(cursor.getColumnIndex(DBAdapter.KEY_QUESTION));
				String answer = cursor.getString(cursor.getColumnIndex(DBAdapter.KEY_ANSWER));
				String category = cursor.getString(cursor.getColumnIndex(DBAdapter.KEY_CATEGORY));
				Integer color = cursor.getInt(cursor.getColumnIndex(DBAdapter.KEY_CAT_COLOR));
				if(!categoriesToAdd.contains(category)){
					categoriesToAdd.add(category);
					categoriesColors.add(color);
				}
				Question currQ = new Question(category, question, answer);
				questionsToAdd.add(currQ);
				cursor.moveToNext();
			}
			//From list of questions by categories
			ArrayList<ArrayList<Question>> questionsByCategoryLists = new ArrayList<ArrayList<Question>>();
			for(String category : categoriesToAdd){
				for(Question question : questionsToAdd){
					if(question.getCategoryName().equals(category)){
						Boolean added = false;
						for(ArrayList<Question> questionsOfSameCat : questionsByCategoryLists){
							if(questionsOfSameCat.get(0).getCategoryName().equals(question.getCategoryName())){
								if(!questionsOfSameCat.contains(question)){
									questionsOfSameCat.add(question);
								}
								added = true;
							}
						}
						if(added==false){
							ArrayList<Question> ql = new ArrayList<Question>();
							ql.add(question);
							questionsByCategoryLists.add(ql);
						}
					}
				}
			}
			//Add Categories to category array lists use in game application 
			int colorIndex = 0;
			for(ArrayList<Question> questionsOfSameCat : questionsByCategoryLists){
				String category = questionsOfSameCat.get(0).getCategoryName();
				categoryDatabase.add(new Category(category, categoriesColors.get(colorIndex), questionsOfSameCat));
				colorIndex++;
			}
		}
		cursor.close();
	}
	
//	public void onClick_ClearAll(View v) {
//		myDb.deleteAll();
//		categoryDatabase.clear();
//	}
}
