package com.bluebarracudas.trivialpursuit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import com.bluebarracudas.trivialpursuit.Classes.Category;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.service.textservice.SpellCheckerService.Session;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class CategoryListFragment extends Fragment implements
		OnItemClickListener, OnItemLongClickListener {
	public static final String TAG = CategoryListFragment.class.getSimpleName()
			+ ".TAG";

	private final ArrayList<Category> mCategoryList = new ArrayList<Category>();

	private CategoryAdapter mAdapter;
	private ListView mListView;
	private TextView mTextViewNoConfiguredDevices;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final Bundle bundle = getArguments();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		getActivity().getActionBar().setSubtitle("test");

		mAdapter = new CategoryAdapter(getActivity().getApplication(),
				getActivity(), mCategoryList);

		final View view = inflater.inflate(R.layout.category_list_fragment,
				null, false);

		mListView = (ListView) view.findViewById(R.id.category_list);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(this);
		mListView.setOnItemLongClickListener(this);

		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onDetach() {
		super.onDetach();

	}

	@Override
	public void onResume() {
		super.onResume();
		updateView();
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position,
			long id) {
		/*
		 * final Bundle bundle = new Bundle();
		 * bundle.putString(TrackCast.EXTRA_INTERACT_SESSION_UUID,
		 * mAdapter.getItem(position).uuid);
		 * 
		 * final NewDeviceInfoFragment fragment = new NewDeviceInfoFragment();
		 * fragment.setArguments(bundle);
		 * 
		 * ((MainActivity) getActivity()).replaceFragment(fragment,
		 * NewDeviceInfoFragment.TAG);
		 */
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> adapter, View view,
			int position, long id) {

		return true;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();

		mAdapter.dispose();
		getActivity().getActionBar().setSubtitle(null);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}

	private void updateView() {
		// Prevent updates when the UI is not yet visible
		if (mAdapter == null)
			return;

		mCategoryList.clear();

		mAdapter.notifyDataSetChanged();

		final boolean categoriesAvailable = mCategoryList.size() > 0;
		mTextViewNoConfiguredDevices
				.setVisibility(categoriesAvailable ? View.GONE : View.VISIBLE);
		mListView.setVisibility(categoriesAvailable ? View.VISIBLE : View.GONE);
	}

	private static final class CategoryAdapter extends BaseAdapter implements
			OnClickListener {

		private final Application mApplication;
		private final ArrayList<Category> mCategories;
		private final LayoutInflater mInflater;

		private Activity mActivity;

		public CategoryAdapter(Application application, Activity context,
				ArrayList<Category> categories) {
			mApplication = application;
			mInflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			mCategories = categories;
			mActivity = context;

			final Resources res = context.getResources();
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
		public View getView(int position, View convertView, ViewGroup group) {
			final Category category = getItem(position);
			final ViewHolder holder;

			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.category_list_item,
						null, false);
				holder = new ViewHolder(convertView);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			holder.viewColor.setBackgroundColor(Color.BLUE);

			holder.textViewName.setText("test category name");

			return convertView;
		}

		@Override
		public void onClick(View v) {
		}

		final void dispose() {
			mActivity = null;
		}

		private static final class ViewHolder {
			final View viewColor;
			final TextView textViewName;

			public ViewHolder(View view) {
				viewColor = view.findViewById(R.id.category_item_color);
				textViewName = (TextView) view
						.findViewById(R.id.category_item_name);
			}
		}

	}
}
