---
title: Cursor Adapters
duration: "1:30"
creator:
    name: Drew Mahrt
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Cursor Adapters
Week 4 | Lesson 4

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Define what the Cursor Adapter is doing
- Add a Cursor Adapter to link a database to the screen
- Define what the Simple Cursor Adapter is doing
- Add a Simple Cursor Adapter to link a database to the screen

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Understand the code supporting Cursor behavior
- Be able to perform basic SQLite queries in an Android app

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Gather materials needed for class
- Complete Prep work required
- Prepare any specific instructions

---
<a name="opening"></a>
## Opening (5 mins)

Now that we've covered the basics of SQL, integrating SQLite databases into your apps, and Cursor behavior, we are finally ready to cover Cursor Adapters. Databases are a very important part to many popular apps, and knowing how to work with them is crucial. In addition to regular Cursor Adapters, we will explore Simple Cursor Adapters which make working with the results of databases even easier.   


***

<a name="introduction"></a>
## Introduction: Cursor Adapters (15 mins)

We've already seen Adapters when working with ListViews, and how important they are for displaying your collections in your app. Similarly, Cursor Adapters exist for showing the data from the cursor in a ListView. All of the main concepts remain from Array Adapters, including custom views and notifying the adapter when data changes (a cursor in this case). Each time a new query is made, a new cursor is returned, and it can be swapped out in the adapter.

One important item to note is that your table in the database **must** have a column named `_id` that contains a unique id value for each entry.



***

<a name="demo"></a>
## Demo: Cursor Adapters (10 mins)

Now that we know what a cursor adapter does, let's create and implement a very basic one. We can start with the CursorAdapterDemo project, and make our adapter there.

```java
  //Get cursor
  Cursor cursor = ExampleSQLiteOpenHelper.getInstance(MainActivity.this).getExampleList();

  //Define CursorAdapter
  CursorAdapter cursorAdapter = new CursorAdapter(MainActivity.this,cursor,0) {
      @Override
      public View newView(Context context, Cursor cursor, ViewGroup parent) {
          return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,parent,false);
      }

      @Override
      public void bindView(View view, Context context, Cursor cursor) {
          TextView textView = (TextView)view.findViewById(android.R.id.text1);

          textView.setText(cursor.getString(cursor.getColumnIndex(ExampleSQLiteOpenHelper.COL_ITEM_NAME)));
      }
  };

  //Set adapter
  listView.setAdapter(cursorAdapter);
```

When creating the CursorAdapter, the constructor takes three parameters. The first is the current context, the second is the cursor that contains all of the data, and the final is for flags to customize the adapter. We aren't using any flags, so we can leave it at a default value of 0.

As you can see, there are two methods we are required to override. newView is simply responsible for inflating the list item layout. bindView is responsible for setting up all of the views in the layout, such as text and images.


***

<a name="guided-practice"></a>
## Guided Practice: Cursor Adapters (15 mins)

Now that we've created a basic Cursor Adapter, let's try changing it to use a custom layout for the ListView item.

First, we need to create our new layout, then we can change our CursorAdapter.

```java
//XML Layout
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:id="@+id/name_text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
    <TextView
        android:id="@+id/description_text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
</LinearLayout>

//Changed CursorAdapter
CursorAdapter cursorAdapter = new CursorAdapter(MainActivity.this,cursor,0) {
  @Override
  public View newView(Context context, Cursor cursor, ViewGroup parent) {
    return LayoutInflater.from(context).inflate(R.layout.list_item_layout,parent,false);
  }

  @Override
  public void bindView(View view, Context context, Cursor cursor) {
    TextView nameTextView = (TextView)view.findViewById(R.id.name_text_view);
    TextView descriptionTextView = (TextView)view.findViewById(R.id.description_text_view);

    nameTextView.setText(cursor.getString(cursor.getColumnIndex(ExampleSQLiteOpenHelper.COL_ITEM_NAME)));
    descriptionTextView.setText(cursor.getString(cursor.getColumnIndex(ExampleSQLiteOpenHelper.COL_ITEM_DESCRIPTION)));
  }
};
```

There were only three changes we needed to make in order to use our custom layout:

1) Inflate the new layout
2) Get the new TextView
3) Set the new TextView to the description value


***

<a name="introduction"></a>
## Introduction: Simple Cursor Adapters (10 mins)

Just as the ArrayAdapter allows us to create a quick adapter for a simple collection (instead of using a more complicated ListAdapter), the SimpleCursorAdapter allows us to create a CursorAdapter with a single line of code. While this may not work for every situation, it is very useful for layouts that don't require too much customization.


The constructor takes 6 parameters:
1) The current context
2) The layout to use
3) The cursor that contains the data
4) An array of strings that contains the column titles to take from the cursor
5) An array of ints that contains the id of the view item in the layout to assign to the corresponding cursor data value
6) An integer for flags


***

<a name="demo"></a>
## Demo: SimpleCursorAdapter (5 mins)

Now we're going to try to display the name column in the listView using a SimpleCursorAdapter. Let's comment out the CursorAdapter we defined before, and start writing a SimpleCursorAdapter.


```java
//Create SimpleCursorAdapter
String[] columns = new String[]{ExampleSQLiteOpenHelper.COL_ITEM_NAME};
int[] viewNames = new int[]{android.R.id.text1};
CursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(MainActivity.this,android.R.layout.simple_list_item_1,cursor,columns,viewNames,0);

//Set adapter
listView.setAdapter(simpleCursorAdapter);
```


***

<a name="guided-practice"></a>
## Guided Practice: SimpleCursorAdapter (10 mins)

Let's change the SimpleCursorAdapter to use the custom layout we created earlier. Once again, we need to change the layout name, the columns we are retrieving the data from, and the view names where we are assigning data.

```java
//Create SimpleCursorAdapter
String[] columns = new String[]{ExampleSQLiteOpenHelper.COL_ITEM_NAME,ExampleSQLiteOpenHelper.COL_ITEM_DESCRIPTION};
int[] viewNames = new int[]{R.id.name_text_view,R.id.description_text_view};
CursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(MainActivity.this,R.layout.list_item_layout,cursor,columns,viewNames,0);
```


***

<a name="ind-practice"></a>
## Independent Practice: Topic (15 minutes)


Now it's time for you to create your own CursorAdapter using a custom layout. Each list item should contain two items:

- A string from the database
- The corresponding icon, obtained from the helper function getDrawableValue()

[The starter code is in the IconList project](./starter-code/IconList/).


***

<a name="conclusion"></a>
## Conclusion (5 mins)

Databases play such a large part in many modern apps, which means Cursors and CursorAdapters are extremely important. Being able to easily integrate data queries into our ListViews is an important skill to have. Our next lesson is going to expand on our work with databases, and we'll implement search into our database queries.

***

### ADDITIONAL RESOURCES
- [Cursor Adapter](http://developer.android.com/reference/android/widget/CursorAdapter.html)
