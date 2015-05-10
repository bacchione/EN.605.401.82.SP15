// ------------------------------------ DBADapter.java ---------------------------------------------

// TODO: Change the package to match your project.
package com.bluebarracudas.trivialpursuit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


// TO USE:
// Change the package (at top) to match your project.
// Search for "TODO", and make the appropriate changes.
public class DBAdapter {

	/////////////////////////////////////////////////////////////////////
	//	Constants & Data
	/////////////////////////////////////////////////////////////////////
	// For logging:
	private static final String TAG = "DBAdapter";

	// DB Fields
	public static final String KEY_ROWID = "_id";
	public static final int COL_ROWID = 0;

	public static final String KEY_QUESTION = "question";
	public static final String KEY_ANSWER = "answer";
	public static final String KEY_CATEGORY = "category";

	// (0 = KEY_ROWID, 1=...)
	public static final int COL_QUESTION = 1;
	public static final int COL_ANSWER = 2;
	public static final int COL_CATEGORY = 3;


	public static final String[] ALL_KEYS = new String[] {KEY_ROWID, KEY_QUESTION, KEY_ANSWER, KEY_CATEGORY};

	// DB info: it's name, and the table we are using (just one).
	public static final String DATABASE_NAME = "trivialPursuitDb";
	public static final String QUESTIONS_TABLE = "questionsTable";
	public static final String GAMESTATE_TABLE = "gameStateTable";
	// Track DB version if a new version of your app changes the format.
	public static final int DATABASE_VERSION = 2;	

	private static final String QUESTIONS_DATABASE_CREATE_SQL = 
			"create table " + QUESTIONS_TABLE 
			+ " (" + KEY_ROWID + " integer primary key autoincrement, "

			// + KEY_{...} + " {type} not null"
			//	- Key is the column name you created above.
			//	- {type} is one of: text, integer, real, blob
			//		(http://www.sqlite.org/datatype3.html)
			//  - "not null" means it is a required field (must be given a value).
			// NOTE: All must be comma separated (end of line!) Last one must have NO comma!!
			+ KEY_QUESTION + " string not null, "
			+ KEY_ANSWER + " string not null, "
			+ KEY_CATEGORY + " string not null"

			// Rest  of creation:
			+ ");";

	// Context of application who uses us.
	private final Context context;

	private DatabaseHelper myDBHelper;
	private SQLiteDatabase db;

	/////////////////////////////////////////////////////////////////////
	//	Public methods:
	/////////////////////////////////////////////////////////////////////

	public DBAdapter(Context ctx) {
		this.context = ctx;
		myDBHelper = new DatabaseHelper(context);
	}

	// Open the database connection.
	public DBAdapter open() {
		db = myDBHelper.getWritableDatabase();
		return this;
	}

	// Close the database connection.
	public void close() {
		myDBHelper.close();
	}

	// Add a new set of values to the database.
	public long insertRow(String question, String answer, String category) {
		/*
		 * CHANGE 3:
		 */		
		// TODO: Update data in the row with new fields.
		// TODO: Also change the function's arguments to be what you need!
		// Create row's data:
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_QUESTION, question);
		initialValues.put(KEY_ANSWER, answer);
		initialValues.put(KEY_CATEGORY, category);

		// Insert it into the database.
		return db.insert(QUESTIONS_TABLE, null, initialValues);
	}

	// Delete a row from the database, by rowId (primary key)
	public boolean deleteRow(long rowId) {
		String where = KEY_ROWID + "=" + rowId;
		return db.delete(QUESTIONS_TABLE, where, null) != 0;
	}

	public void deleteAll() {
		Cursor c = getAllRows();
		long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
		if (c.moveToFirst()) {
			do {
				deleteRow(c.getLong((int) rowId));				
			} while (c.moveToNext());
		}
		c.close();
	}

	// Return all data in the database.
	public Cursor getAllRows() {
		String where = null;
		Cursor c = 	db.query(true, QUESTIONS_TABLE, ALL_KEYS, 
				where, null, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}

	// Get a specific row (by rowId)
	public Cursor getRow(long rowId) {
		String where = KEY_ROWID + "=" + rowId;
		Cursor c = 	db.query(true, QUESTIONS_TABLE, ALL_KEYS, 
				where, null, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}

	// Change an existing row to be equal to new data.
	public boolean updateRow(long rowId, String question, String answer, String category) {
		String where = KEY_ROWID + "=" + rowId;

		/*
		 * CHANGE 4:
		 */
		// TODO: Update data in the row with new fields.
		// TODO: Also change the function's arguments to be what you need!
		// Create row's data:
		ContentValues newValues = new ContentValues();
		newValues.put(KEY_QUESTION, question);
		newValues.put(KEY_ANSWER, answer);
		newValues.put(KEY_CATEGORY, category);

		// Insert it into the database.
		return db.update(QUESTIONS_TABLE, newValues, where, null) != 0;
	}
	
//	public Cursor getById(String id){
//		String[] args ={id};
//		return (getReadableDatabase()
//				.raqQuery("SELECT _id, * from * WHERE _id=?");
//	}



	/////////////////////////////////////////////////////////////////////
	//	Private Helper Classes:
	/////////////////////////////////////////////////////////////////////

	/**
	 * Private class which handles database creation and upgrading.
	 * Used to handle low-level database access.
	 */
	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase _db) {
			_db.execSQL(QUESTIONS_DATABASE_CREATE_SQL);			
		}

		@Override
		public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading application's database from version " + oldVersion
					+ " to " + newVersion + ", which will destroy all old data!");

			// Destroy old database:
			_db.execSQL("DROP TABLE IF EXISTS " + QUESTIONS_TABLE);

			// Recreate new database:
			onCreate(_db);
		}
	}
}
