package Framework;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import com.bluebarracudas.trivialpursuit.R;
import com.bluebarracudas.trivialpursuit.Classes.Category;
import com.bluebarracudas.trivialpursuit.Classes.Question;

public class QuestionAdapter extends BaseAdapter {

	private ArrayList<Question> mQuestions = new ArrayList<Question>();
	private final LayoutInflater mInflater;

	public QuestionAdapter(Activity context, ArrayList<Question> questions) {
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		mQuestions = questions;
	}

	@Override
	public int getCount() {
		return mQuestions.size();
	}

	@Override
	public Question getItem(int position) {
		return mQuestions.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup group) {
		final Question question = getItem(position);
		final ViewHolder holder;

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.question_list_item, null,
					false);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.question.setText("Q: " + question.getQuestion());
		holder.answer.setText("A:  " + question.getAnswer());

		return convertView;
	}

	private static final class ViewHolder {
		final TextView question;
		final TextView answer;

		public ViewHolder(View view) {
			question = (TextView) view.findViewById(R.id.question_item_name);
			answer = (TextView) view.findViewById(R.id.answer_item_name);
		}
	}

}