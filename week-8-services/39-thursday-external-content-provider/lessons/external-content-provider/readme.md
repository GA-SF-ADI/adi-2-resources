---
title: Using External Content Providers
duration: "1:25"
creator:
    name: Drew Mahrt
    city: NYC
---
# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Using External Content Providers

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Describe how content providers can be accessed from another applications
- Use the a Content Provider from an existing application in a new application

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Create a Content Provider

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Open and test the provided starter and solution code

---
<a name="opening"></a>
## Opening (5 mins)

As we saw in our previous lesson, we can use a Content Provider to add a layer of abstraction between our data, and being able to access it from within our own app. While this is very useful for internal use, Content Providers allow us to expose our data to other apps as well.


***

<a name="introduction"></a>
## Introduction: Content Providers and Contracts (15 mins)


#### How to expose a Content Provider's data

First, let's look at how we allow other apps to access our data.

```xml
<provider
  android:name=".MyContentProvider"
  android:authorities="com.example.content.MyContentProvider"
  android:exported="true"/>
```

Notice the last line, where exported is set to true. This property allows other apps to use the authority you provide to form a URI, just like we did internally in our app.

#### Contracts

While directly accessing our Content Provider URI will work, Android provides a much more streamlined process through Contracts. In a broad description, a Contract is a Java file that contains definitions of URIs, columns names for the database, permissions, and MIME types.

In our previous lesson, we ignored the MIME type, but today we will see it in use. Since some apps may contain multiple tables, the MIME types can be used to let another app know which table they will be receiving their data from, and therefore which columns you have access to with that data.

The permission mentioned above is what requires you to use the `<uses-permission>` tag in your Manifest. It is set as a the writePermission and readPermission properties in the Provider tag in the app containing the Content Provider. While this isn't required if you are exposing you app's data, it lets the user know they are granting this permission upon installing the app.

Using a Contract also allows you to change things like URIs and column names without breaking functionality of anyone using your Content Provider.


***

<a name="demo"></a>
## Demo: Contracts (15 mins)

Now that we understand the basics of what a Contract is, let's take a look at a basic example using the UserDictionary contract used for predictive text in Android.

[UserDictionary](https://github.com/android/platform_frameworks_base/blob/master/core/java/android/provider/UserDictionary.java)

The UserDictionary provides access the Authority, Content URI, all of the columns contained in the table, as well as a helper method for adding new words to the dictionary.


```java
public static void addWord(Context context, String word,
                int frequency, String shortcut, Locale locale) {
            final ContentResolver resolver = context.getContentResolver();

            if (TextUtils.isEmpty(word)) {
                return;
            }

            if (frequency < FREQUENCY_MIN) frequency = FREQUENCY_MIN;
            if (frequency > FREQUENCY_MAX) frequency = FREQUENCY_MAX;

            final int COLUMN_COUNT = 5;
            ContentValues values = new ContentValues(COLUMN_COUNT);

            values.put(WORD, word);
            values.put(FREQUENCY, frequency);
            values.put(LOCALE, null == locale ? null : locale.toString());
            values.put(APP_ID, 0); // TODO: Get App UID
            values.put(SHORTCUT, shortcut);

            Uri result = resolver.insert(CONTENT_URI, values);
            // It's ok if the insert doesn't succeed because the word
            // already exists.
        }
```


***

<a name="demo"></a>
## Codealong: UserDictionary (10 mins)

Let's try reading from the User Dictionary! We want to show the words from the user dictionary in a list on the screen.

Take 5 minutes with a partner and try to figure out the steps of what we need to do.

First, we need to create a ListView and get a reference to it. Next, we need to define the columns we want, and then query the dictionary.

```java
ListView listView = (ListView)findViewById(R.id.dictionary_list);

String [] columns = {UserDictionary.Words._ID,UserDictionary.Words.WORD};

Cursor cursor = getContentResolver().query(UserDictionary.Words.CONTENT_URI,columns,null,null,null);
```

Next, we need to create an adapter, then set it to the ListView.

```java
SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,cursor,columns,new int[]{android.R.id.text1},0);
        listView.setAdapter(simpleCursorAdapter);
```

If you notice, we have an error that we need to set the correct permission in our Manifest.

```xml
<uses-permission android:name="android.permission.READ_USER_DICTIONARY" />
```

That's it! We just used the User Dictionary Content Provider to retrieve information.

**You must manually add words to the dictionary if it is empty.** Go to Settings -> Language and Input -> Personal Dictionary.


***

## Independent Practice: Adding Words to the Dictionary (10 minutes)

Next, you will have to figure out how to add words to the dictionary. Using the link provided to the User Dictionary, or through the API documentation, write the code needed to add your own words. You must add an EditText to your Layout to retrieve the user input.


***

<a name="guided-practice"></a>
## Guided Practice: Retrieving Contacts (15 mins)

Another popular built-in Content Provider is for the user Contacts. Android provides a Contact Contract to access nearly every aspect of the contacts you have stored in your phone. We are going to build an app that displays the names of our Contacts.

First, we need to add the ListView to display our contacts.

```java
ListView listView = (ListView)findViewById(R.id.contacts_list);
```

Just like with the User Dictionary, we have to add in the permission to read from our contacts list.

```xml
<uses-permission android:name="android.permission.READ_CONTACTS"/>
```

Now, we have to start using the [Contacts Contract](http://developer.android.com/reference/android/provider/ContactsContract.html). Since we are using a SimpleCursorAdapter, we know we need the ID column, and we need the DISPLAY_NAME column because we want the names of our contacts. Also from the documentation, we know we need the CONTENT_URI.

```java
String[] projection = new String[] { ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME };
Uri uri = ContactsContract.Contacts.CONTENT_URI;
```

Next, we need to query the contacts list to get the name, and use that cursor to build our adapter.


```java
Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
mCursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,cursor,new    String[]{ContactsContract.Contacts.DISPLAY_NAME},new int[]{android.R.id.text1},0);
listView.setAdapter(mCursorAdapter);
```

That's it! Now when we run the app, it should show our contacts.


***

<a name="ind-practice"></a>
## Independent Practice: Contacts (15 mins)

Modify the Contacts code you have written so far to allow you to delete contacts from your Contact list. If you have extra time, add the ability to add and edit your contacts.


***

<a name="conclusion"></a>
## Conclusion (5 mins)

Accessing other apps' Content Providers through Contracts is a very easy way to work with data from all over your phone. It's important to know how to leverage the other data stored on your user's device and not feel the need to contain everything within your app. In a later lesson we are going to be retrieving data from your Portfolio app using the Content Provider you wrote.

***

### ADDITIONAL RESOURCES
- [Content Providers](http://developer.android.com/guide/topics/providers/content-providers.html)
- [Contacts Content Provider](http://developer.android.com/guide/topics/providers/contacts-provider.html)
- [Android Contracts](https://github.com/android/platform_frameworks_base/tree/master/core/java/android/provider)
