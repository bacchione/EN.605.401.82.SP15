package com.bluebarracudas.trivialpursuit;

import java.util.ArrayList;

import com.bluebarracudas.trivialpursuit.R;
import com.bluebarracudas.trivialpursuit.Classes.Category;
import com.bluebarracudas.trivialpursuit.Utilities.DefaultQuestionsGenerator;

import Framework.CategoryAdapter;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
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
		// mCategories =
		// intentBundle.getParcelableArrayList(Constants.CATEGORY_DATABASE_TAG);

		//mCategories = DefaultQuestionsGenerator.addDefaultQuestionsGenerator();

		mCategoryAdapter = new CategoryAdapter(this, mCategories);
		mCategoryListView = (ListView) findViewById(R.id.category_list);
		mCategoryListView.setAdapter(mCategoryAdapter);
		mCategoryListView.setOnItemClickListener(this);
	}

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
}
