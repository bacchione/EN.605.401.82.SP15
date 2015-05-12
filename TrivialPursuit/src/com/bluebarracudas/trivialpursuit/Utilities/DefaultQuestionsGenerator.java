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

			questionArray.add(new Question(categoryName, "Who was the first person to sign the Declaration of Independence?", "John Hancock"));
			questionArray.add(new Question(categoryName, "What famous founding father wrote the first draft of the Declaration of Independence?", "Thomas Jefferson"));
			questionArray.add(new Question(categoryName, "How were deputies to the Constitutional Convention chosen?", "They were appointed by the legislatures of the different States."));
			questionArray.add(new Question(categoryName, "Were there any restrictions as to the number of deputies a State might send?", "No"));
			questionArray.add(new Question(categoryName, "Who was called the Father of the Constitution?", "James Madison"));
			questionArray.add(new Question(categoryName, "Was Thomas Jefferson a member of the Constitutional Convention?", "No"));
			questionArray.add(new Question(categoryName, "What did Thomas Jefferson have to do with framing the Constitution?", "Although absent from the Constitutional Convention and during the period of ratification, Jefferson rendered no inconsiderable service to the cause of Constitutional Government, for it was partly through his insistence that the Bill of Rights, consisting of the first ten amendments, was adopted"));
			questionArray.add(new Question(categoryName, "Who presided over the Constitutional Convention?", "George Washington, chosen unanimously"));
			questionArray.add(new Question(categoryName, "Who was the oldest member of the Constitutional Convention?", "Benjamin Franklin, of Pennsylvania, then 81"));
			questionArray.add(new Question(categoryName, "Who was the youngest member of the Constitutional Convention?", "Jonathan Dayton, of New Jersey, 26"));
			questionArray.add(new Question(categoryName, "How many lawyers were members of the Constitutional Convention?", "There were probably 34, out of 55, who had at least made a study of the law"));
			questionArray.add(new Question(categoryName, "From what classes of society were the members of the Constitutional Convention drawn?", "In addition to the lawyers, there were soldiers, planters, educators, ministers, physicians, financiers, and merchants"));
			questionArray.add(new Question(categoryName, "How many members of the Constitutional Convention had been members of the Continental Congress?", "Forty, and two others were later members"));
			questionArray.add(new Question(categoryName, "Were there any members of the Constitutional Convention who never attended any of its meetings?", "There were nineteen who were never present. Some of these declined, others merely neglected the duty"));
			questionArray.add(new Question(categoryName, "Who was called the Sage of the Constitutional Convention?", "Benjamin Franklin, of Pennsylvania"));
			questionArray.add(new Question(categoryName, "Who presented the Virginia Plan?", "Edmund Randolph"));
			questionArray.add(new Question(categoryName, "Who actually wrote the Constitution?", "In none of the relatively meager records of the Constitutional Convention is the literary authorship of any part of the Constitution definitely established. The deputies debated proposed plans until, on July 24, 1787, substantial agreement having been reached, a Committee of Detail was appointed, consisting of John Rutledge, of South Carolina; Edmund Randolph, of Virginia; Nathaniel Gorham, of Massachusetts; Oliver Ellsworth, of Connecticut; and James Wilson, of Pennsylvania, who on August 6 reported a draft which included a Preamble and twenty-three articles, embodying fifty-seven sections. Debate continued until September 8, when a new Committee of Style was named to revise the draft. This committee included William Samuel Johnson, of Connecticut; Alexander Hamilton, of New York; Gouverneur Morris, of Pennsylvania; James Madison, of Virginia; and Rufus King, of Massachusetts, and they reported the draft in approximately its final shape on September 12. The actual literary form is believed to be largely that of Morris, and the chief testimony for this is in the letters and papers of Madison, and Morris's claim. However, the document in reality was built slowly and laboriously, with not a piece of material included until it has been shaped and approved. The preamble was written by the Committee of Style."));
			questionArray.add(new Question(categoryName, "Who was the penman who, after the text of the Constitution had been agreed on, engrossed it prior to the signing?", "Jacob Shallus who, at the time, was assistant clerk of the Pennsylvania State Assembly, and whose office was in the same building in which the Convention was held"));
			questionArray.add(new Question(categoryName, "Does the name of the penman appear on the document or in any of the papers pertaining to its preparation?", "No, the name of Jacob Shallus, the penman, does not appear on the document or in any of the papers pertaining to its preparation. In the financial memoranda there is an entry of $30 for clerks employed to transcribe & engross."));
			questionArray.add(new Question(categoryName, "How was the identity of the engrosser determined?", "His identity was determined after a long and careful search of collateral public documents, andwas recently disclosed for the first time."));
			questionArray.add(new Question(categoryName, "When was the identity of the engrosser determined?", "In 1937, on the occasion of the 150th anniversary of the Constitution. "));
			questionArray.add(new Question(categoryName, "Did Jacon Shallus realize the importance of the work he had done?", "Probably not; when he died, in 1796, the Constitution had not yet come to be the firmly established set of governmental principles it since has become"));
			questionArray.add(new Question(categoryName, "Which, if any, of the deputies to the Constitutional Convention refuse to sign the Constitution?", "There were three--Randolph and Mason, of Virginia, and Gerry, of Massachusetts--refused to sign"));
			questionArray.add(new Question(categoryName, "How many deputies to the Constitutional Convention signed the Constitution?", "Thirty-nine (39) deputies signed."));
			questionArray.add(new Question(categoryName, "Were any of the deputies' signatures made in absentia??", "Yes. One of the signatures is that of an absent deputy, John Dickinson, of Delaware, added at his request by George Read, who also was from Delaware"));
			questionArray.add(new Question(categoryName, "Did George Washington sign the Declaration of Independence?", "No. He did not. Research states that he had been appointed Commander-in-Chief of the Continental Army more than a year before and was at the time with the army in New York City"));
			questionArray.add(new Question(categoryName, "What party name was given to those who favored ratification of the Constitution?", "Those who favored ratification were called Federalist"));
			questionArray.add(new Question(categoryName, "What party name was given to those who opposed ratification of the Constitution?", "Those who were opposed to the ratification of the Constitution were known as Antifederalists"));
			questionArray.add(new Question(categoryName, "Who proposed the creation of the first executive departments and the first amendments to the Constitution?", "James Madison, of Virginia, proposed the resolutions for the formation of the first executive departments and the series of twelve amendments to the Constitution of which ten were finally ratified by the States."));
			questionArray.add(new Question(categoryName, "Who was called the Father of the Constitution?", "James Madison, of Virginia, because in point of erudition and actual contributions to the formation of the Constitution he was preeminent"));

			categoryList.add(new Category(categoryName, categoryColor,
					questionArray));

			// session.addGeofenceProfile(profile);
		}

		{
			String categoryName = "Places";
			int categoryColor = Color.BLUE;
			final ArrayList<Question> questionArray = new ArrayList<Question>();
			
			questionArray.add(new Question(categoryName,"Where was the first flag with 50 stars flown?", "Philadelphia"));
			questionArray.add(new Question(categoryName, "Which State did not send deputies to the Constitutional Convention?", "Rhode Island and Providence Plantations"));
			questionArray.add(new Question(categoryName, "Where did Jacob Shallus do the engrossing?", "There is no record of this, but probably in Independence Hall."));
			questionArray.add(new Question(categoryName,"Where was the Declaration of Independence signed?", "Philadelphia"));
			questionArray.add(new Question(categoryName, "In what order did the States ratify the Constitution?", "In the following order: Delaware, Pennsylvania, New Jersey, Georgia, Connecticut, Massachusetts, Maryland, South Carolina, New Hampshire, Virginia, and New York. After Washington had been inaugurated, North Carolina and Rhode Island ratified"));
			questionArray.add(new Question(categoryName, "After the Constitution was submitted for ratification, where did the greatest contests occur?", "In Massachusetts, Virginia, and New York"));
			questionArray.add(new Question(categoryName, "What cities have been Capitols of the United States government?", "The Continental Congress sat at Philadelphia, 1774-76, 1777, 1778-83; Baltimore, 1776-77; Lancaster, 1777; York, 1777-78; Princeton, 1783; Annapolis, 1783-84; Trenton, 1784; and New York, 1785-89. "));
			questionArray.add(new Question(categoryName, "Where was the first Capitol under the Constitution of the United States?", "The first Capitol under the Constitution of the United States was in New York"));
			questionArray.add(new Question(categoryName, "Where was the Capitol of the United States moved to in 1790 before becoming finding its permanent home in the District of Columbia ?", "In 1790, the Capitol of the United States was moved to Philadelphia. Here it was continued until 1800."));
			questionArray.add(new Question(categoryName,"Where is the Liberty Bell located?", "Philadelphia"));
			questionArray.add(new Question(categoryName, "When did the permanent Capitol, Washington, in the District of Columbia, become occupied?", "The permanent Capitol, Washington, in the new District of Columbia, became occupied in 1800"));
			questionArray.add(new Question(categoryName, "When did the phrase, The United States of America, originate?", "The first known use of the formal term United States of America was in the Declaration of Independence. Thomas Paine, in February, 1776, had written of Free and independent States of America."));

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
			questionArray.add(new Question(categoryName, "Where did the deputies to the Constitutional Convention assemble?", "In Philadelphia, in the State House where the Declaration of Independence was signed."));
			questionArray.add(new Question(categoryName, "When did the deputies to the Constitutional Convention assemble?", "The meeting was called for May 14, 1787, but a quorum was not present until May 25."));
			questionArray.add(new Question(categoryName, "When did the United States government go into operation under the Constitution?", "The Constitution became binding upon nine States by the ratification of the ninth State, New Hampshire, June 21, 1788."));
			questionArray.add(new Question(categoryName, "When was notice of the ratification of the Constitution received by Congress?", "Notice of this ratification was received by Congress on July 2, 1788"));
			questionArray.add(new Question(categoryName, "When did the old Confederation go out of existence??", "On March 3, 1789, the old Confederation went out of existence, according to a decision of the Supreme Court of the United States (wings v. Speed, 5 Wheat. 420); however, it had no practical existence until April 6, when first the presence of quorums in both Houses permitted organization of Congress"));
			questionArray.add(new Question(categoryName, "When did the new government of the United States legally begin to function?", "On March 4, 1789,  the new government of the United States began legally to function, according to a decision of the Supreme Court of the United States (wings v. Speed, 5 Wheat. 420)"));
			questionArray.add(new Question(categoryName, "When did the new government of the United States begin its practical existence?", "The new government had no practical existence until April 6, when first the presence of quorums in both Houses permitted organization of Congress"));
			questionArray.add(new Question(categoryName, "When was George Washington inaugurated as President of the United States?", "On April 30, 1789, George Washington was inaugurated as President of the United States"));
			questionArray.add(new Question(categoryName, "When did the Executive Branch of the government become operative under the Constitution?", "On the date of the inauguration of George Washington as President of the United States, the Executive Branch of the government under the Constitution became operative."));
			questionArray.add(new Question(categoryName, "When did the Supreme Court, as head of the third branch of the government, organize and hold its first session?", "It was not until February 2, 1790, that the Supreme Court, as head of the third branch of the government, organized and, held its first session"));
			questionArray.add(new Question(categoryName, "When did our government become fully operative under the Constitution?", "It was on the date of February 2, 1790, once the Supreme Court was in session, that our government under the Constitution became fully operative"));
			questionArray.add(new Question(categoryName, "When did the permanent Capitol, Washington, in the District of Columbia, become occupied?", "The permanent Capitol, Washington, in the new District of Columbia, was occupied in 1800"));

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
			questionArray.add(new Question(categoryName, "What event took place to celebrate the signing of the Declaration of Independence?", "The Liberty Bell was rung on July 8, 1776, to mark the signing of the Declaration of Independence, a milestone event"));
			questionArray.add(new Question(categoryName, "When did July 4th become a Federal holiday?", "The Fourth of July became a Federal holiday in 1941"));
			questionArray.add(new Question(categoryName, "When did the tradition of Independence Day celebrations begin?", "The tradition of Independence Day celebrations goes back to the 18th century and the American Revolution (1775-83)"));
			questionArray.add(new Question(categoryName, "When did the Continental Congress vote in favor of independence?", "On July 2nd, the Continental Congress voted in favor of independence"));
			questionArray.add(new Question(categoryName, "Why is July 4th celebrated as the birth of American Independence?", "On July 4th, 1776, delegates of the Continental Congress adopted the Declaration of Independence, a historic document drafted by Thomas Jefferson. "));

			categoryList.add(new Category(categoryName, categoryColor,
					questionArray));
		}

		return categoryList;
	}
}