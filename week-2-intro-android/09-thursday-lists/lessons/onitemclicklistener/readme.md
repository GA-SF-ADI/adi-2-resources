---
title: Clicking on ListItems
duration: "1:20"
creator:
    name: Drew Mahrt
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) `OnItemClickListener`


### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Implement `OnItemClickListener`
- Use `OnItemClickListener` with data

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Create ListViews and ListAdapters

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Gather materials needed for class
- Complete Prep work required
- Prepare any specific instructions

---

<a name="opening"></a>
## Opening (5 mins)


`ListViews` and `ListAdapters` are used in all kinds of applications that need to display large amounts of data. From Twitter, which displays lists of Tweets, to Seamless, that displays lists of restaurants, we see them every day. So far, we have only seen how to create them and manipulate the data behind them. Now we will work on actually interacting with the list itself.




<a name="introduction"></a>
## Introduction: OnItemClickListener (10 mins)

So far we've handled clicking on Views using an `OnClickListener`, but in ListViews, we have a bunch of individual Views. What happens if we try to write an `OnClickListener` for a ListView?


Android Studio tells us that we don't want to use this!

The solution is to use something called the `OnItemClickListener`. Like the OnClickListener, the OnItemClickListener also contains a method where you put the code for what happens when you click. In this case, it's called `OnItemClick`.




<a name="demo"></a>
## Demo: `OnItemClickListener` (20 mins)

Let's walk through the following code:

```java
mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Do stuff
    }
});
```

- **parent**: The parent object refers to ListView object. From there we can do things like retrieve items from the data collection, or access the Adapter behind the ListView.

- **view**: This refers to the actual list item that was clicked

- **position**: This refers to the position in the view

- **id**: The position in the underlying data set

Let's make it show a toast.

```java
mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this,"Item clicked",Toast.LENGTH_SHORT).show();
    }
});
```

Now, let's have it say what position we clicked.

```java
Toast.makeText(MainActivity.this,"Item clicked at position "+position,Toast.LENGTH_SHORT).show();
```




<a name="guided-practice"></a>
## Guided Practice: Setting up `OnItemClickListener`s (10 mins)

Let's take our example further - do this with me.

How would we change the text for the item to show "You clicked position X" for each item? We know that one of the parameters of `onItemClick` is a View, but we need to figure out how to use it.

Check it out:

```java
mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    ((TextView)view).setText("Clicked "+position);
  }
});
```



<a name="ind-practice"></a>
## Independent Practice: Integrate `OnItemClickListener`(30 minutes)

We're going to change our morning exercise to use OnItemClickListener. Instead of having two buttons for showing abbreviations and full state names, we're going to do it individually for each list item.

- Remove the two buttons
- When you click a list item, toggle that specific state list item between the full state name and the abbreviation




<a name="conclusion"></a>
## Conclusion (5 mins)
- Why don't we use OnClickListener with ListViews?


### ADDITIONAL RESOURCES
- [OnItemClickListener](http://developer.android.com/reference/android/widget/AdapterView.OnItemClickListener.html)
