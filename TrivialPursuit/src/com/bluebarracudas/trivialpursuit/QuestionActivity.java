package com.bluebarracudas.trivialpursuit;

import java.util.ArrayList;

import com.bluebarracudas.trivialpursuit.R;
import com.bluebarracudas.trivialpursuit.Classes.Category;
import com.bluebarracudas.trivialpursuit.Classes.Question;
import com.bluebarracudas.trivialpursuit.Utilities.DefaultQuestionsGenerator;

import Framework.ABaseDialog;
import Framework.CategoryAdapter;
import Framework.QuestionAdapter;
import android.app.Activity;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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

public class QuestionActivity extends Activity implements OnClickListener,
		OnItemClickListener {

	private QuestionAdapter mQuestionAdapter;
	private ListView mQuestionListView;
	private Category mCategory;

	public static final String TAG = "CategoryActvity.TAG";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.question_list_fragment);
		final Bundle bundle = getIntent().getExtras();
		mCategory = (Category) bundle.getParcelable(Constants.QUESTION_TAG);

		mQuestionAdapter = new QuestionAdapter(this, mCategory.getQuestionArray());
		mQuestionListView = (ListView) findViewById(R.id.question_list);
		mQuestionListView.setAdapter(mQuestionAdapter);
		mQuestionListView.setOnItemClickListener(this);
		
		final IntentFilter updatefilter = new IntentFilter();
		updatefilter.addAction(Constants.UPDATE_QUESTION_TAG);
        this.registerReceiver(mProfileEditorReceiver, updatefilter);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		// display dialog question edit here
		final Bundle bundle = new Bundle();
		bundle.putParcelable(Constants.QUESTION_TAG, mCategory.getQuestionArray().get(position));
		DialogEditQuestion dialog = new DialogEditQuestion();
		dialog.setArguments(bundle);
		dialog.show(getFragmentManager(), ABaseDialog.TAG_DIALOG_FRAGMENT);
		
		// send in question
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		this.unregisterReceiver(mProfileEditorReceiver);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		boolean in = true;
		in = false;
	}
	
	private final BroadcastReceiver mProfileEditorReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			Question me = (Question) intent.getExtras().getParcelable(Constants.UPDATE_QUESTION_TAG);
			mCategory.getQuestionArray().add(me);
			mCategory.setQuestionArray(mCategory.getQuestionArray());
			mQuestionAdapter.notifyDataSetChanged();
		};
	};
}
