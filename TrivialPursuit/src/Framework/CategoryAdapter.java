package Framework;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import com.bluebarracudas.trivialpursuit.R;
import com.bluebarracudas.trivialpursuit.Classes.Category;

public class CategoryAdapter extends BaseAdapter implements
		View.OnClickListener {

	private ArrayList<Category> mCategories = new ArrayList<Category>();
	private final LayoutInflater mInflater;

	public CategoryAdapter(Activity context, ArrayList<Category> categories) {
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		mCategories = categories;
	}

	@Override
	public int getCount() {
		return mCategories.size();
	}

	@Override
	public Category getItem(int position) {
		return mCategories.get(position);
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
	public void onClick(View v) {

	}

	@Override
	public View getView(int position, View convertView, ViewGroup group) {
		final Category category = getItem(position);
		final ViewHolder holder;

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.category_list_item, null,
					false);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.textViewCategoryName.setText(category.getName());
		holder.colorSelectionSpinner.setBackgroundColor(category.getColor());

		return convertView;
	}

	private static final class ViewHolder {
		final Spinner colorSelectionSpinner;
		final TextView textViewCategoryName;
		final LinearLayout categoryLayout;

		public ViewHolder(View view) {
			textViewCategoryName = (TextView) view
					.findViewById(R.id.category_item_name);
			colorSelectionSpinner = (Spinner) view
					.findViewById(R.id.category_item_color);
			categoryLayout = (LinearLayout) view
					.findViewById(R.id.category_linearLayout);
		}
	}

}