---
title: Firebase
duration: "1:25"
creator:
    name: Drew Mahrt && Aleksandr Tomak
    city: NYC && SF
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Firebase


### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Explain the basics of Firebase
- Integrate Firebase into your apps

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Describe the basics of databases

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Read through the lesson
- Add additional instructor notes as needed
- Edit language or examples to fit your ideas and teaching style
- Open, read, run, and edit (optional) the starter and solution code to ensure it's working and that you agree with how the code was written

---
<a name="opening"></a>
## Opening (5 mins)

Databases can be a crucial part of our apps, but we are normally limited by this data being isolated by each device. The obvious solution would be to host our database on the internet, and access it from the app. While this sounds like a great idea, this can result in long delays. Firebase provides us with a fast, easy to set up answer.

> Check: Ask the students if they've heard of Firebase before.

***

<a name="introduction"></a>
## Introduction: What is Firebase (10 mins)

Firebase is a quick way to store your app's data on the cloud in a structured, but very flexible manner. While it holds your data in a database, it is fundamentally different from what we're used to in SQLite.

In Firebase, you don't set up Columns, Data types, keys, etc. ahead of time. You simply add and modify the data on-the-fly. Some of the biggest features of Firebase are how fast it is, and how quickly it can automatically sync the data on your apps. As soon as changes are made online, all apps connected to your Firebase database are notified of the changes, and can update their view accordingly. This is not just limited to Android, but reflects across all platforms (iOS, web, etc.).

[Let's watch a quick video.](https://youtu.be/U5aeM5dvUpA?list=PLl-K7zZEsYLmOF_07IayrTntevxtbUxDL)

> Check: Ask the students to discuss with each other (2 mins) ideas where Firebase could be used.

***

<a name="demo"></a>
## Demo: Setting Up Firebase (10 mins)

The signup process is exactly the same as our **Google Player Services Lesson** that covered Firebase Analytics and Push notifications. 

<details>
    <summary> Click here for a refresher of the steps </summary>
**If you don't have an account**, sign up [here](https://firebase.google.com/).

Next, open up the [console](https://console.firebase.google.com/) and press on the `create project` button and give you project a name. Then click `create project` once more. It will take a while to setup, then it should auto kick you into your created project, if not just click on it to load the next page.

Now, lets click on the `Add firebase to you Android App` button. You will have a popup asking for you project package name, lets come back to this.

Create a new project inside Android Studio called FireBaseStorage. Once the project is created, open your `AndroidManifest.xml` to find your `package="somePackage"` at the top. We want the "somePackage" value for the popup.

Come back to that popup we saw earlier. Paste your package path into the field and press `add app`. Your browser will then download a file `google-services.json`. We need to move this file into our android studio project. Follow the on screen instructions in the popup, they are self explanatory and provide a visual guide. Basically, you will switch from Android view to Project View, and paste the file into your `app/` folder. Once finished, press `continue` button on the web page.

Follow step 1 and step 2 on the popup. You are adding the line below to your **project** gradle file.
```
classpath 'com.google.gms:google-services:3.0.0'
```
Then in your **app** gradle file you need to add the below line at the **very bottom of the file**, below the dependency clause.
```
apply plugin: 'com.google.gms.google-services'
```

Now we have setup firebase inside of our app and on the website! 

</details>

Once you got firebase setup, make sure to go back to the web console and select the **DataBase / RealTime DataBase** tab on the left side. You will see a link at the bottom for [learn more](https://firebase.google.com/docs/database/) which points to the real time database documentation! 

Documentation on how to use the real time database on [Android is here](https://firebase.google.com/docs/database/android/start/)

On the RealTime Database view, you will see three tabs at the top. Data, Rules, and Usage. Press on the Rules section, and override the JSON there with this:
```json
{
  "rules": {
    ".read": true,
    ".write": true
  }
}
```

We just made our database **public**. This means **anyone** can read and write from it. It makes the demo easier to teach, however during production you should setup authentication for your users to get read/write access to the database. [Learn more about the process](https://firebase.google.com/docs/database/security/quickstart).

## Setting up Android  

The second step is to setup our Android project to use Firebase RealTime DataBase. Add the line below into your **app** level gradle file.
```
compile 'com.google.firebase:firebase-database:9.2.1'
```
Make sure to sync your gradle.

Don't forget to add the INTERNET permission into your manifest file!
```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

## Writing data to the cloud

Now we can write our very first item to firebase using the code below
```java
// Grab a reference to our singleton database
FirebaseDatabase database = FirebaseDatabase.getInstance();

// Grab a reference that represents category "message". Really its more of a JSON object.
DatabaseReference msgRef = database.getReference("message");

// Write the string "Hello, World!" to the cloud's category "message" 
msgRef.setValue("Hello, World!");
```
In the first line, we get a reference to the Firebase singleton instance. Using the database instance on line 2, we can grab a reference to database category "message" which will hold messages for us in this case. The we can use that reference to write values to it and to the cloud using the `setValue()` method on line 3.

If we look on the web console and refresh the data, we will see something that looks like
```
message: "Hello, World!"
```
This means our app wrote the string "Hellow, World!" to the cloud!

> Instructor note: Change the string value and re-run the app. Show the students that the value was updated.

## Reading and Receiving Updates from Cloud

Its great that we can write values to the cloud, what about receiving updates? If we changed the
```
message: "Hello, World!"
```
to 
```
message: "Hi, World!"
```
we want to receive these updates. Right now, if we changed the value we would not receive the update because *we aren't listening for it*.

To listen for changes in the value for a certain "category" we need to add a `addValueEventListener()` to our category reference like so:

```java
// Remember msgRef was defined above as:     DatabaseReference myRef = database.getReference("message");

// Add the value event listener to category for myRef
msgRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // DataSnapshot.getValue() is cast to String class and returned to us with updated value
                String updatedMessage = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Updated message is: " + updatedMessage);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
});
```
`onDataChange` is triggered whenever data is changed on Firebase, and `onCancelled` is triggered when there is an error with the connection.

Now if you run the app again, our code will overwrite whatever value in the cloud with "Hellow, World!" because of the code we have above.

Go into the web console and update the
```
message: "Hello, World!"
```
to 
```
message: "Hi, World!"
```
Inside your app you should see a log statement with the updated string "Updated message is: Hi, World!".


***

<a name="demo"></a>
## Independent Practice: Read and Write Data (20 mins)

Working off of the project you already created from the steps above ( if not, please do so first ) you want to add:
- An editText
- A TextView
- A Button

Your task is to create a clickListener for the Button that will take in whatever text is inside the EditText and push it up to the cloud. You should also update your TextView whenever the value is updated in the cloud. Basically, whenever user changes EditText text and presses the button, the TextView will update from the cloud. But the TextView will also update whenever you ( the admin ) will update the value from the console as well.

Feel free to use the "message" category or to create your very own category for this exercise.

***

<a name="introduction"></a>
## Introduction: Child Events (5 mins)

The ValueEvents that we just worked with are great for primitives and Objects, but if we want to work with things like lists of data, we want to use ChildEvents. ValueEvents passes back the entire object when a change is made, whereas ChildEvents can give us the individual items.

***

<a name="demo"></a>
## Demo: Child Events (5 mins)

Lets try adding a ChildEventListener to our code. It starts off just like our ValueEventListener, but the autocomplete looks very different.

> Walk through the methods with the students. Remember that onChildAdded is called when pulling down existing data.

***

<a name="guided-practice"></a>
## Guided Practice: Binding data to a ListView (10 mins)

Let's take our knowledge of ChildEvents and apply it to a ListView.

> Prompt the students to help complete these steps.

1. add a ListView to the app, and create a reference to it in our MainActivity.
2. Create an ArrayList to hold our data
3. Create an ArrayAdapter
4. Add messages when onChildAdded is called, and call notifyDataSetChanged

```xml
<ListView
        android:id="@+id/list"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/submit_button"/>
```

```java
public class MainActivity extends AppCompatActivity {
    TextView mCurrentText;
    EditText mNewText;
    Button mSubmitButton;
    ListView mListView;

    Firebase mFirebaseRootRef;

    ArrayList<String> mMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCurrentText = (TextView) findViewById(R.id.current_text);
        mNewText = (EditText)findViewById(R.id.edit_text);
        mSubmitButton = (Button)findViewById(R.id.submit_button);
        mListView = (ListView)findViewById(R.id.list);

        mFirebaseRootRef = new Firebase("https://exampleappdrew.firebaseio.com");

        final Firebase firebaseCurrentTextRef = mFirebaseRootRef.child("currentText");

        Firebase firebaseMessageRef = mFirebaseRootRef.child("messages");

        mMessages = new ArrayList<>();

        firebaseCurrentTextRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mCurrentText.setText("Latest Text: " + text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseCurrentTextRef.setValue(mNewText.getText().toString());
            }
        });

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mMessages);
        mListView.setAdapter(adapter);

        firebaseMessageRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String message = dataSnapshot.getValue(String.class);
                mMessages.add(message);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
```

One last note: To add values to a list with auto-generated keys, you use the following code:

```java
firebaseMessageRef.push().setValue("test insert2");
```

> Check: Were students able to successfully solve the problem or complete the task?

***

<a name="introduction"></a>
## Introduction: FirebaseUI (5 mins)

ChildEvents work fine when adding data to a list, but certain UI operations such as changing and deleting can quickly become very complicated. Luckily, Firebase provides the FirebaseUI library to help manage UI elements connected to Firebase, perform easy authentication, and other useful things!

[Check out the documentation](https://github.com/firebase/FirebaseUI-Android)

> Check: Ask the students why change and remove would be hard to manage in the ListView example

***

<a name="demo"></a>
## Demo: FirebaseUI (5 mins)

First, we need to add FirebaseUI to our gradle file.

```
compile 'com.firebaseui:firebase-ui:0.3.1'
```

Since we want to change our ListView to work with FirebaseUI, we are going to use the  FirebaseListAdapter.

```java
FirebaseListAdapter<String> adapter = new FirebaseListAdapter<String>(this, String.class, android.R.layout.simple_list_item_1, firebaseMessageRef) {
            @Override
            protected void populateView(View view, String s, int i) {
                TextView textView  = (TextView)view.findViewById(android.R.id.text1);
                textView.setText(s);
            }
        };

        mListView.setAdapter(adapter);
```

> Check: Ask the students what situations we would want to use FirebaseUI in.

***

<a name="ind-practice"></a>
## Independent Practice: Topic (10 mins)

Work with a partner to make a working version of Tic-Tac-Toe. You will create a layout with 9 EditTexts. The text you type into one of the EditTexts should sync immediately on the second person's device.

Hint: Try using addTextChangedListener

> Check: Were the students able to complete the activity?

***

<a name="conclusion"></a>
## Conclusion (5 mins)

Firebase is a very powerful tool for moving our databases to the cloud. The setup is extremely fast, and requires very little effort. Even though the structure is different than what we are used to with databases, our familiarity with JSON makes this transition much easier. Going forwards, consider adding Firebase to your apps to make syncing data much easier.

***

### ADDITIONAL RESOURCES
- [FireBase RealTime Database](https://firebase.google.com/docs/database/)
- [FireBase RealTime DataBase Android Setup](https://firebase.google.com/docs/database/android/start/)
- [Firebase UI](https://github.com/firebase/FirebaseUI-Android)
