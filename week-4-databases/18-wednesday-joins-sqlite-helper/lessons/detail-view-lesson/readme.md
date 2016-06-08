---
title: Building a Detail View
duration: "1:30"
creator:
    name: Drew Mahrt
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Building a Detail View


### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Use a Singleton to open a database connection from master and detail views
- Determine the data to pass from master to detail view
- Create a detail View in a new Activity
- Override the correct methods to open a detail view from a single item in a list
- Pass a database connection between master and detail views

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Create new Activities with Intents
- Pass data between activities
- Retrieve data from a SQLite database

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Read through the lesson
- Add additional instructor notes as needed
- Edit language or examples to fit your ideas and teaching style
- Open, read, run, and edit (optional) the starter and solution code to ensure it's working and that you agree with how the code was written

---
<a name="opening"></a>
## Opening (5 mins)

All of our apps with databases so far have been in a single Activity. As you can imagine, most apps have more than one screen and often need to access the database across each screen. Even something as simple as a to-do-list would need access to the same information in different activities, such as the list item on one screen, but all of the details on the next. All of this information needs to be pulled from the same database. Today we will learn about the correct way to access the same database to gather information across multiple activities.


***

<a name="introduction"></a>
## Introduction: Opening Multiple Database Connections (15 mins)

In our `SQLiteOpenHelper`, one of the parameters we pass is the context. So far we have used `MainActivity.this` and left it at that.

If you remember, context works similar to scope, and if we move to another activity, we don't want to be using the context of the previous activity. Opening a new database connection on each activity can become very expensive in terms of system resources, and it's possible to run into conflicts with multiple things trying to change the database at once. How do we get around this?

The first way is to use the Singleton pattern. Instead of creating a new instance of the Helper class in each activity, we can initialize it once, and use it everywhere after that.

The second way is by using something called a `ContentProvider`, which we will cover later in the course. Using a Singleton is a very common way to go about doing this though.


***

<a name="demo"></a>
## Codealong: Using a Singleton with SQLiteOpenHelper (20 mins)

The first step to making this a Singleton is to make a private static instance of the class as a member variable:

```java
private static ExampleSQLiteOpenHelper mInstance;
```

Next, we have to make the constructor private, and create a getInstance method. In `getInstance`, we need to use the context `getApplicationContext`:

```java
public static ExampleSQLiteOpenHelper getInstance(Context context){
  if(mInstance == null){
    mInstance = new ExampleSQLiteOpenHelper(context.getApplicationContext());
  }
  return mInstance;
}
```

Finally, in our `MainActivity`, we need to use getInstance instead of calling new:

```java
ExampleSQLiteOpenHelper helper = ExampleSQLiteOpenHelper.getInstance(MainActivity.this);
```

That's it! Now our `SQLiteOpenHelper` is using a Singleton!


***

<a name="guided-practice"></a>
## Codealong: Adding a detail view (20 mins)

Let's use this to create a detail view which will also access the database.

Since we want to get the data for the individual item we click on, we need to pass the id column value into the intent in our `MainActivity` in the item click listener.

Since we have the cursor, we can move it to the clicked position, and get the id.

```java
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    Intent intent =  new Intent(MainActivity.this,DetailActivity.class);
    cursor.moveToPosition(position);
    intent.putExtra("id",cursor.getInt(cursor.getColumnIndex(ExampleSQLiteOpenHelper.COL_ID)));
    startActivity(intent);
  }
});
```

Let's add a helper method to get the description for the item by id.

```java
public String getDescriptionById(int id){
  SQLiteDatabase db = this.getReadableDatabase();

  Cursor cursor = db.query(EXAMPLE_LIST_TABLE_NAME,
                new String[]{COL_ITEM_DESCRIPTION},
                COL_ID+" = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

  if(cursor.moveToFirst()){
    return cursor.getString(cursor.getColumnIndex(COL_ITEM_DESCRIPTION));
  } else {
    return "No Description Found";
  }
}
```

Then in our `DetailActivity`, we have to get the description and put it in our TextView.

```java
ExampleSQLiteOpenHelper helper = ExampleSQLiteOpenHelper.getInstance(DetailActivity.this);

int id = getIntent().getIntExtra("id",-1);

if(id >= 0){
    String description = helper.getDescriptionById(id);
    TextView textView = (TextView)findViewById(R.id.description_text);
    textView.setText(description);
}
```


***

<a name="ind-practice"></a>
## Independent Practice: Icon List v2 (25 mins)


We are going to take the [Icon List example](starter-code) from the Cursor Adapters lesson and make it into two activities. The first activity will just show the icon, and when you click on it, the second activity will show the text for that icon.


***

<a name="conclusion"></a>
## Conclusion (5 mins)

Since many apps are so data-intensive today, databases play a large role in Android app development. Now you know how to create, manipulate, and access your database across multiple activities in your apps.

***

### ADDITIONAL RESOURCES
- [Correctly Managing your SQLite Database](http://www.androiddesignpatterns.com/2012/05/correctly-managing-your-sqlite-database.html)
- [Understanding Context](https://possiblemobile.com/2013/06/context/?utm_source=Android%20Weekly&utm_campaign=78ad4cb95e-Android_Weekly_64&utm_medium=email&utm_term=0_4eb677ad19-78ad4cb95e-328260729)
