---
title: Activities and Intents
type: lesson
duration: "2:05"
creator:
  name: James Davis
  city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Activities and Intents

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
* Given a running application, identify the activities in that application
* Identify the same activities in the app manifest
* List the intents required to move between these activities
* Given a code fragment that creates an intent, describe what the code does
* Pass data between activities

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Create an activity
- Use nested layouts to create more complicated views
- Explain view recycling and why it matters

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Read through the lesson
- Add additional instructor notes as needed
- Edit language or examples to fit your ideas and teaching style
- Open, read, run, and edit (optional) the starter and solution code to ensure it's working and that you agree with how the code was written
- **Note**: With the addition of `startActivityForResult`, this lesson is unusually long. Consider giving the students a break mid-way through.


## Opening (5 mins)

Most of the time, you can think of an Activity as a screen of your app - that's all!



## Introduction: What is an Activity? What is a Manifest? (10 mins)

The definition of an activity is something that is done for a particular purpose.

Think about the activity that the user is doing on a screen. If you are looking at a screen whose purpose is to log in the user, for example, it should be called the Login Activity. If the activity shows a user's social network profile , it should be called the User Profile Activity.

An Activity is a plain ol' Java class, so you already know how to add it to a project.

Right click on the folder where you want to put the activity, then go to *New* > *Activity*, and then click on the type of base activity you want (usually, *Empty Activity* is what you want if you want to build it from scratch).

Doing this also adds the Activity to the Android Manifest.


#### What is a Manifest?

The dictionary defines a ship's manifest to be "a document giving comprehensive details of a ship and its cargo and other contents, passengers, and crew for the use of customs officers."

The ship, in our case, is the app you are building.

The Android Manifest xml file presents important information about your app to the Android system. If something isn't defined in the manifest, then the system just ignores it.

Notably, the manifest is known for describing the main components of your app; the Activities, Services, Content Providers, etc. It is also the place to define permissions (e.g., giving your app permission to access the internet or to access a device's camera).

Whenever you create a new Activity, if it is not automatically added, it should be added to the manifest. Otherwise, the app will crash.


## Demo: Creating Activities (15 mins)

In this demo, let's walk through the following:

* Creating a new project in Android Studio
* Examining the manifest file, describing components like the XML elements, attributes, and package
* Describe what a launcher activity is (The activity that opens when the app is launched), and make comparisons to Java's *public static void main* method
* Add 2 more activities to the project, and go back to the manifest and see them added




## Introduction: What are Intents? (10 mins)

Intent, as defined in the dictionary, means: purpose, goal, objective. *Something intends to do some goal*.

This translates to your app and activities; every activity has a goal.

For example, a `ComposeEmailActivity` allows the user to compose and send an email. If you click a "compose new email" button, you are actively saying "I intend to compose an email".

This is the idea behind Intents in Android. Intents are messages you send between app components, like Activities, usually with the intent of doing something.


The following "dialogue" is happening:

- EmailListActivity: "Hey, you clicked one of your emails. What's up?"
- You: "I intend on reading that email. Is that okay?"
- EmailListActivity: "Yeah, sure! I'll start the ReadEmailActivity now."
- You: "Thank you."

So, how does this look in code?

```java

	Intent intent = new Intent(EmailListActivity.this, ReadEmailActivity.class);
	startActivity(Intent);

```

You create a new Intent object, and you pass it two parameters: The activity you are currently in, and the class of the activity you intend to start. The code snippet above could be read as, *From the Email List Activity, please start the Read Email Activity*.

The method, `startActivity()`, starts the intended activity immediately.


## Demo: Starting an activity with an Intent (10 mins)

Using the code from the previous demo, add a button to the app's main activity. Set an `onClickListener` to that button and have the listener start one of the other activities. Run the app in a virtual device, and click on the button to start the new activity. Feel free to codealong, if you'd like!

Note: A complete example of this is found in the [solution code folder](solution-code).

## Introduction: Sending data from one Activity to another Activity (10 mins)

Intents are how Activities communicate with each other. In the previous example, we started an activity to read an email by clicking an email in the list. However, how does the ReadEmailActivity know what email to show?


When you start a new activity, it is shown with the default settings that you give it. However, some activities need to receive a bit more information. This info is sent from the original activity to the one you are starting.

When creating new intents, you can also give it *extra* data. Here's an example:

```java

	Intent intent = new Intent(EmailListActivity.this, ReadEmailActivity.class);
	intent.putExtra("ID", 123);
	intent.putExtra("SENDER", "John Smith");
	startActivity(Intent);

```


The Intent class has a handful of helper methods you can call to get and store extra data. The main one is `putExtra()`, which takes two parameters: a String that gives the data a name, and the data itself.

With `Intent.putExtra()`, you can put data inside the intent (including Strings, numbers, booleans, certain objects).

Once you start a new activity, you can retrieve the Intent and get the sent data, as follows:

```java

	// get the intent that started this activity
	Intent intent = getIntent();

	// get the data from the intent
	int id = intent.getIntExtra("ID", 0);
	String sender = intent.getStringExtra("SENDER");

```

Again, the Intent class has a handful of getters for extra data, usually formatted like *get_____Extra*. Examples, `getIntExtra()`, `getStringExtra()`, `getBooleanExtra()`, etc.

**Note**: You should only send data if you need to do so. If the activity you are starting doesn't need extra data, you don't have to set it.

## Guided Practice: Sending Data between Activities (15 mins)


With the person next to you, go ahead and start a new Android project with a empty main activity. Do the following:

- Add a new Activity, and call it `EchoActivity`.
- Take 2 minutes and do this: In `MainActivity`, add an `EditText` and a Button. In the `EchoActivity`, it will just have a `TextView`.
- Take 2 minutes and do this: In Java, set an `onClickListener` to the button and make it start the `EchoActivity`. The value of the `EditText` is passed in the intent.
- Take 2 minutes and do this: In the `EchoActivity`, the value is plucked from the intent and put in the TextView.

#### Independent Practice: Add two numbers (15 mins)


Now, with the person next to you, without stopping every two minutes, do the following:

* Create a new project, with a blank main Activity
* Create a new activity, call it SolutionActivity
* In the main activity, put two EditTexts and one button in the layout. The button's text will say "Add"
* In the solution activity, just have one TextView
* When the button is pressed, it takes the two values and sends them to the solution activity, where the sum of the two numbers are shown.

## Demo: Passing data back in the result (20 mins)

Passing data works in both directions, and you can receive data when returning from an Activity you previously started. For example, if you start SecondActivity from MainActivity, you can get data back from SecondActivity when it closes.

Returning data from an Activity only requires a few additions to your code.

This can be broken down into changes in your calling Activity (the one you are starting the second activity from), and changes in your secondary Activity.

Open the Starter-Code and follow along, if you'd like.

#### Second Activity

First, let's look at the second Activity, or the one you are passing the data back from. In this Activity, we press a button, and it passes the values from the two EditTexts back to the Main Activity.


Just like when we're starting an Activity, we also pass data back using an Intent.

```java
mButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
    Intent resultIntent = new Intent();
    resultIntent.putExtra("first",mFirstNameText.getText().toString());
    resultIntent.putExtra("last",mLastNameText.getText().toString());

    setResult(RESULT_OK,resultIntent);
    finish();
}
});
```

First we create an intent, then put the two Strings in as extras. The next two lines of code are new, though.

- **setResult**: This method takes two parameters. The first is a value that lets our first Activity know that everything went well, and that this Activity finished correctly. The second parameter is simply an Intent holding the data we want to pass back.
- **finish**: This method closes the current Activity and returns to the previous one.

#### Main Activity

Now that we've finished the Second Activity, let's return to the Main Activity. We have two steps to complete.


We need to start the Second Activity and get the results from the Second Activity.

Starting the Activity is almost identical to how we previously did it, with one exception:

```java
Intent intent = new Intent(MainActivity.this,SecondActivity.class);
startActivityForResult(intent,NAME_REQUEST);
```

Notice the `startActivityForResult` method. The first parameter is a normal Intent, but the second is a variable telling the system what we are asking for (we will use this in a minute). We need to add that variable at the top of the Activity.

```java
private static final int NAME_REQUEST = 20;
```

You can assign any integer value that is **greater than 0**.

Next, we have to get the results from the Second Activity. Whenever you return from an Activity that is expecting results, the `onActivityResult` is automatically called.


```java
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	// Check what request we're responding to...
	if (requestCode == NAME_REQUEST) {
	    // Make sure the request was successful...
	    if (resultCode == RESULT_OK) {
	        String firstName = data.getStringExtra("first");
	        String lastName = data.getStringExtra("last");
	        mText.setText(firstName+" "+lastName);
	    }
	}
}
```

The first parameter is the static variable we passed in when starting the activity, in our case `NAME_REQUEST`. The second parameter is the result status, in our case `RESULT_OK`. The final parameter is the Intent we passed back containing the data.

Since we could be starting different Activities from our Main Activity, we first have to check that our result is coming from the `NAME_REQUEST` activity, then we have to check to make sure the results are valid. After that, we can retrieve the data like normal and use it however we want.


## Independent Practice: startActivityForResult (10 mins)

**Do this activity with a partner**

This practice is going to be similar to the previous one but reversed: instead of passing values from the first activity to the second, we are going to give the user two options in the main activity, add and subtract.

If the user chooses add, they are taken to a different activity with two EditTexts where they type 2 numbers, and the sum is returned in the result of the main activity where it is displayed.

If the user chooses subtract, the same steps occur, except the difference is returned to the main activity.


#### Conclusion (5 mins)

- What is an activity?
- What is an intent?
- How do we start an activity?
- How do we send data from one activity to another?
- How do we receive data when returning from an activity?

## Additional Resources

* Android Developer | Starting Activities - http://developer.android.com/guide/components/activities.html#StartingAnActivity
* Android Developer | Intents - http://developer.android.com/guide/components/intents-filters.html
