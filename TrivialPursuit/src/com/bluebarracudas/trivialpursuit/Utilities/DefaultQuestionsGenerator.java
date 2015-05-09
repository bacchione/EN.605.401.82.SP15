package com.bluebarracudas.trivialpursuit.Utilities;

import java.util.ArrayList;

import android.graphics.Color;

import com.bluebarracudas.trivialpursuit.Classes.Category;
import com.bluebarracudas.trivialpursuit.Classes.Question;

public final class DefaultQuestionsGenerator {

	private DefaultQuestionsGenerator() {
	}

	public static final ArrayList<Category> addDefaultQuestionsGenerator() {

		final ArrayList<Category> categoryList = new ArrayList<Category>();
		{
			String categoryName = "People";
			int categoryColor = Color.RED;
			final ArrayList<Question> questionArray = new ArrayList<Question>();

			questionArray.add(new Question(categoryName,
					"Who was the first person to sign the Declaration of Independence?", "John Hancock"));
			questionArray.add(new Question(categoryName,"Who sewed the first American flag?", "Betsy Ross"));
			questionArray.add(new Question(categoryName,
			"What famous founding father wrote the first draft of the Declaration of Independence?", "Thomas Jefferson"));

			questionArray.add(new Question(categoryName,"How were deputies to the Constitutional Convention chosen?", "Appointed by the legislatures of different States."));

			questionArray.add(new Question(categoryName,"Were there any restrictions as to the number of deputies a State might send?", " No"));

			categoryList.add(new Category(categoryName, categoryColor,
					questionArray));

			// session.addGeofenceProfile(profile);
		}

		{
			String categoryName = "Places";
			int categoryColor = Color.BLUE;
			final ArrayList<Question> questionArray = new ArrayList<Question>();

			questionArray.add(new Question(categoryName,"Which State did not send deputies to the Constitutional Convention?", "Rhode Island and Providence Plantations"));
			questionArray.add(new Question(categoryName,"Where was the first flag with 50 stars flown?", "Philadelphia"));
			questionArray.add(new Question(categoryName,"Where is the Liberty Bell located?", "Philadelphia"));
			questionArray.add(new Question(categoryName,"Where was the Declaration of Independence signed?", "Philadelphia"));
			
			categoryList.add(new Category(categoryName, categoryColor,
					questionArray));
		}
		
		{
			String categoryName = "Events";
			int categoryColor = Color.WHITE;
			final ArrayList<Question> questionArray = new ArrayList<Question>();

			questionArray.add(new Question(categoryName,"When was the Declaration of Independence signed?", "July 4, 1776"));
			questionArray.add(new Question(categoryName,"When is Flag Day?", "June 14"));
			questionArray.add(new Question(categoryName,"When was the first flag with 50 stars flown?", "1960"));

			categoryList.add(new Category(categoryName, categoryColor,
					questionArray));
		}

		{
			String categoryName = "Independence Day Holiday";
			int categoryColor = Color.GREEN;
			final ArrayList<Question> questionArray = new ArrayList<Question>();

			questionArray.add(new Question(categoryName,"When is Independence Day?", "July 4th"));
			questionArray.add(new Question(categoryName,"When did the Liberty Bell get a crack?", "First Ring"));
			questionArray.add(new Question(categoryName,"Whas was Paul Revere's occupation?", "Silversmith"));
			questionArray.add(new Question(categoryName,"How many stripes are on the American flag?", "13"));
			questionArray.add(new Question(categoryName,"How many states are there?", "50"));

			categoryList.add(new Category(categoryName, categoryColor,
					questionArray));
		}

		return categoryList;
	}
}