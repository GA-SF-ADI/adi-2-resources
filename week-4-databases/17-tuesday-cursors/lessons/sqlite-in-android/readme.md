---
title: Building SQLite support in an Android app
duration: "1:25"
creator:
    name: James Davis
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Building SQLite support in an Android app


### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
* Describe the difference between SQL, SQLite, and PostgreSQL
* Create and query databases and tables with the SQLiteOpenHelper class

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- [Databases, tables, records, and columns](../databases-tables-records-columns-lesson)
- [SQL Setup, Insert, Update, and Delete](../sqlite-lesson)
- [Android Cursors](../android-cursors)

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Read through the lesson
- Add additional instructor notes as needed
- Edit language or examples to fit your ideas and teaching style
- Open, read, run, and edit (optional) the starter and solution code to ensure it's working and that you agree with how the code was written


## Opening (5 mins)

Now that we've gotten the basics of SQL down, let's explore the __easy__ Android options for creating, inserting, updating, reading, and destroying content from the database.

## Introduction: SQL vs. SQLite vs. PostgreSQL (5 mins)



## Demo: SQLiteOpenHelper (15 minutes)

There's a class called `SQLiteOpenHelper` that is a helper class that manages database creation. This class handles opening databases if they exist and creating them if they do not.

To use, you have to create your own subclass of `SQLiteOpenHelper`. This class should override the *onCreate* and *onUpgrade* methods.

In it, we define two static member variables - the database's name and version. It's good to have the database's name in one place, at the top of the class, and the constructor is calling the superclass's constructor, using the database name and version we just defined:


```java
public class DatabaseHelper extends SQLiteOpenHelper {
		// Define the database name and version
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Favorites.db";

		// override the SQLiteDatabase's constructor, onCreate, and onUpgrade
    public DatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
```


Alright, let's make a database with one table. This table will hold our favorite video games.

First, let's define the table columns. In SQLite, the statement used to create a new table is as follows:

```sqlite
CREATE TABLE games ( id INTEGER PRIMARY KEY, name TEXT, year TEXT );
```

... and to delete the table would be:

```sqlite
DROP TABLE IF EXISTS games;
```

We will use this to create the *games* table in out database. So, we'll save them as static member variables in our database helper.

**Pro Tip:** Defining the SQL statements and names as member variables makes it easier to reference and change them. It's faster to look at the top of a class for your values in one place, as opposed to digging through the methods to find them and change them individually.

```java
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Favorites.db";

		// Define SQL statements to create and delete games table
		public static final String SQL_CREATE_GAME_TABLE =
			"CREATE TABLE games ( id INTEGER PRIMARY KEY, name TEXT, year TEXT )";

		public static final String SQL_DROP_GAME_TABLE = "DROP TABLE IF EXISTS games";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

		// Create the games table when the database is created
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

		// When the database is upgraded, the old data isn't needed. Delete the games
		// table and recreate the table
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
```

At this point, we have a class that helps us create and update the games table in the Favorites database. Let's use the helper to help us do CRUD operations: insert, read, update, and delete values.


## Demo: Inserting, reading, and deleting values (25 mins)


You can: Create, Read, Update, and Destroy data (or CRUD, for short!)  We won't go over update here, but let's take take a look at the others.

#### Inserting new data into table and content values

One option we have for inserting data is to use the execSQL method like above. For example:

```
INSERT INTO games VALUES (10,'Joe','2005');
```

There is, however, an easier, more flexible option to insert data in Android. Before we discuss this, we need to go over a new way to represent the data to store in the database. We use the `ContentValues` class to hold the data we will insert into a database. The [ContentValues](http://developer.android.com/reference/android/content/ContentValues.html) class is very similar to a bundle or a map where it is a data type that maps values to particular keys. The keys represent the table column names and the values are the newly inserted data.

In your `SQLiteOpenHelper` subclass, create the *insert* methods. (You are not overriding these methods but making them from scratch).

```java
public class DatabaseHelper extends SQLiteOpenHelper {
    // below the other methods and variables defined earlier

		public void insert(int id, String name, String year){
				// Get a reference to the database
				SQLiteDatabase db = getWritableDatabase();

				// create a new content value to store values
				ContentValues values = new ContentValues();
				values.put("id", id);
				values.put("name", name);
				values.put("year", year);

				// Insert the row into the games table
				db.insert("games", null, values);
		}
}
```

By using ContentValues along with the insert method, we are making our interactions with the database much cleaner rather than forming sometimes very complicated SQL queries.

#### Reading data from database (Cursors)

In your subclass of `SQLiteOpenHelper`, we will add a method that helps us retrieve data from a table.

Essentially, you will run a query on the database and do operations on the cursor that is returned.

Again, we have the option of writing a raw SQL query:

```
SELECT id, name, year FROM games WHERE id = 10;
```

As you can see below, Android once again provides us with a handy query method.

Let's assume we had a class that defined a game in Java called Game. It has a constructor setting a game's id, name, and year:

```java
public class DatabaseHelper extends SQLiteOpenHelper {
    // below the other methods and variables defined earlier

		public Game getGame(int id){
			// Get a reference to the database
			SQLiteDatabase db = getReadableDatabase();

			// Define a projection, which tells the query to return only the columns mentioned
			// similar to "SELECT column1, column2, column3"
			String[] projection = new String[]{ "id", "name", "year" };

			// Define a selection, which defines the WHERE clause of the query (but not the values for it)
			// similar to "WHERE x < 23", only without the value; "WHERE x < ?"
			String selection = "id = ?";

			// Define the selection values. The ?'s in the selection
			// The number of values in the following array should equal the number of ? in the where clause
			String[] selectionArgs = new String[]{ String.valueOf(id) };

			// Make the query, getting the cursor object
			Cursor cursor = db.query("games", projection, selection, selectionArgs, null, null, null, null);

			// With the cursor, create a new game object and return it
			cursor.moveToFirst();

			String name = cursor.getString( cursor.getColumnIndex("name") );
			String year = cursor.getString( cursor.getColumnIndex("year") );

			return new Game(id, name, year);
		}
}
```

#### Deleting rows from table

To delete a row with `SQLiteOpenHelper`, you have to define the WHERE clause and values that define what you want to delete. In this example, we want to delete a game with a certain id:

```java
public class DatabaseHelper extends SQLiteOpenHelper {
    // below the other methods and variables defined earlier

		public void delete(int id){
				// Get a reference to the database
				SQLiteDatabase db = getWritableDatabase();

				// Define the selection, or the where
				String selection = "id = ?";

				// Define the selection values. The ?'s in the selection
				// The number of values in the following array should equal the number of ? in the where clause
				String[] selectionArgs = new String[]{ String.valueOf(id) };

				// Delete everything that satisfies the selection
				db.delete("games", selection, selectionArgs);
		}
}
```

The raw SQL option would look like this:

```
DELETE FROM games WHERE id = 10;
```

#### Using the subclass of `SQLiteOpenHelper`

Use this class from anywhere with access to a Context (i.e., an Activity):

```java
public class GameActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        DatabaseHelper db = new DatabaseHelper(this);

				db.insert(1, "Super Mario", "1985");
				db.insert(2, "Legend of Zelda", "1986");

				Game retrievedGame = db.query(2);
    }
}
```

## Independent Practice: Creating a subclass of SQLiteOpenHelper (30 minutes)

Using what we've learned as guidance, create your own subclass of SQLiteOpenHelper that does the following:

* Creates a database, called "store"
* Creates a table called "televisions", with the columns:
	* id
	* brand
	* size (i.e. 40")
	* price (integer)
* In the main activity of your app, insert at least 5 televisions into the database
* Also, delete 2 of them

In a commented line above each CRUD method of the SQLiteOpenHelper, write the equivalent raw SQL String you could use as an alternative.

Be sure to leverage documentation!


## Conclusion (5 mins)

- Describe the differences between SQL, SQLite, and PostgreSQL.
- What are the functions of the `SQLiteOpenHelper` class?

## Additional Resources

- [Saving Data in SQL Databases (Android Developers)](http://developer.android.com/training/basics/data-storage/databases.html)
- [Android SQLite Database Tutorial](http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/)
