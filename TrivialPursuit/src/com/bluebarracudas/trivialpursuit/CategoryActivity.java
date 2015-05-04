package com.bluebarracudas.trivialpursuit;

import java.util.ArrayList;

import com.bluebarracudas.trivialpursuit.R;
import com.bluebarracudas.trivialpursuit.Classes.Category;
import com.bluebarracudas.trivialpursuit.Classes.Question;
import com.bluebarracudas.trivialpursuit.Utilities.DefaultQuestionsGenerator;

import Framework.ABaseDialog;
import Framework.CategoryAdapter;
import android.app.Activity;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class CategoryActivity extends Activity implements OnClickListener,
		OnItemClickListener {

	private CategoryAdapter mCategoryAdapter;
	private ListView mCategoryListView;
	private ArrayList<Category> mCategories = new ArrayList<Category>();
	public static final String TAG = "CategoryActvity.TAG";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.category_list_fragment);
		final Bundle intentBundle = getIntent().getExtras();
		
		final int size = intentBundle.getInt(Constants.CATEGORY_DATABASE_TAG);
		
		for(int i = 0; i < size; i++){
			mCategories.add((Category) intentBundle.getParcelable(String.valueOf(i)));
		}

		mCategoryAdapter = new CategoryAdapter(this, mCategories);
		mCategoryListView = (ListView) findViewById(R.id.category_list);
		mCategoryListView.setAdapter(mCategoryAdapter);
		mCategoryListView.setOnItemClickListener(this);
		
		final IntentFilter updatefilter = new IntentFilter();
		updatefilter.addAction("Update Categories");
        this.registerReceiver(mCategoryEditorReceiver, updatefilter);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();

		this.unregisterReceiver(mCategoryEditorReceiver);
	}
	
	private final BroadcastReceiver mCategoryEditorReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {

			int categoryIndex;
			
			if(intent.getExtras().containsKey("Category Index")){
				categoryIndex = intent.getExtras().getParcelable("Category Index");
				if(categoryIndex != -1){
					mCategories.remove(categoryIndex);
					mCategories.add(categoryIndex, (Category) intent.getExtras().getParcelable("Category Tag"));
				} else {
					mCategories.add((Category) intent.getExtras().getParcelable("Category Tag"));
				}
				mCategoryAdapter.notifyDataSetChanged();
				
			} else {
				Category modifiedCategory = (Category) intent.getExtras().getParcelable("Category Tag");
				for(int i = 0; i < mCategories.size(); i ++){
					
					if(mCategories.get(i).getName().equals(modifiedCategory.getName())){
						mCategories.remove(i);
						mCategories.add(i, modifiedCategory);
						break;
					}
				}	
			}
		};
	};

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		// need to send the question array
		Intent intent = new Intent(this, QuestionActivity.class);
		// intent.putParcelableArrayListExtra(Constants.QUESTION_TAG,
		// mCategories.get(position).getQuestionArray());
		intent.putExtra(Constants.QUESTION_TAG, mCategories.get(position));
		startActivity(intent);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		boolean value = super.onCreateOptionsMenu(menu);
			getMenuInflater().inflate(R.menu.add_menu, menu);
		return value;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_add:
			final Bundle bundle = new Bundle();
			bundle.putParcelable(Constants.CHOOSE_CATEGORY, new Category(null, 0, null));
			bundle.putInt("Category Index", -1);
			DialogEditCategory dialog = new DialogEditCategory();
			dialog.setArguments(bundle);
			dialog.show(getFragmentManager(), ABaseDialog.TAG_DIALOG_FRAGMENT);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onBackPressed() {
		// send data update
		final Intent intent = new Intent("Update Category Database");
		intent.putExtra(Constants.CATEGORY_DATABASE_TAG, mCategories.size());
		for(int i = 0; i < mCategories.size(); i++){
			intent.putExtra(String.valueOf(i), mCategories.get(i));
		}
		this.sendBroadcast(intent);
		this.finish();
	}
}
