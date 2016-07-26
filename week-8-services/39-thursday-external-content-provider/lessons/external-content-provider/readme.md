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

Since Marshmallow, some Content Providers have 'Normal Permissions' whilst others have 'Dangerous Permissions'. Dangerous Permissions refer to anything which may access the users' confidential data, such as Contacts, Camera, Location, and phone, for example.

For Content Providers with Dangerous Permissions, you will be required to prompt the user for permission.

***

<a name="guided-practice"></a>
## Guided Practice: Retrieving Contacts (30 mins)

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

Finally, because Contacts requires us to prompt the user for permissions (because it is a "Dangerous Permissions" Content Provider), we must prompt the user for permission. To do this, we implement the following methods. Let's work through each step here:


```java
// Identifier for the permission request
    private static final int READ_CONTACTS_PERMISSIONS_REQUEST = 1;

    // Called when the user is performing an action which requires the app to read the
    // user's contacts
    public void getPermissionToReadUserContacts() {
        // 1) Use the support library version ContextCompat.checkSelfPermission(...) to avoid
        // checking the build version since Context.checkSelfPermission(...) is only available
        // in Marshmallow
        // 2) Always check for permission (even if permission has already been granted)
        // since the user can revoke permissions at any time through Settings
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            // The permission is NOT already granted.
            // Check if the user has been asked about this permission already and denied
            // it. If so, we want to give more explanation about why the permission is needed.
            if (shouldShowRequestPermissionRationale(
                    Manifest.permission.READ_CONTACTS)) {
                // Show our own UI to explain to the user why we need to read the contacts
                // before actually requesting the permission and showing the default UI
            }

            // Fire off an async request to actually get the permission
            // This will show the standard permission request dialog UI
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},
                    READ_CONTACTS_PERMISSIONS_REQUEST);
        } else if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                == PackageManager.PERMISSION_GRANTED) {
            //Permission granted. List the contacts.
            setContactListView();
        }
    }

    // Callback with the request from calling requestPermissions(...)
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        // Make sure it's our original READ_CONTACTS request
        if (requestCode == READ_CONTACTS_PERMISSIONS_REQUEST) {
            if (grantResults.length == 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Read Contacts permission granted", Toast.LENGTH_SHORT).show();
            } else {
                // showRationale = false if user clicks Never Ask Again, otherwise true
                boolean showRationale = shouldShowRequestPermissionRationale( this, Manifest.permission.READ_CONTACTS)

                if (showRationale) {
                   // do something here to handle degraded mode
                else {
                   Toast.makeText(this, "Read Contacts permission denied", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

```

Now when we run the app, it should show our contacts.


***

<a name="ind-practice"></a>
## Independent Practice: Contacts (15 mins)

Modify the Contacts code you have written so far to allow you to delete contacts from your Contact list. 


***

<a name="conclusion"></a>
## Conclusion (5 mins)

Accessing other apps' Content Providers through Contracts is a very easy way to work with data from all over your phone. It's important to know how to leverage the other data stored on your user's device and not feel the need to contain everything within your app. In a later lesson we are going to be retrieving data from your Portfolio app using the Content Provider you wrote.

***

### ADDITIONAL RESOURCES
- [Content Providers](http://developer.android.com/guide/topics/providers/content-providers.html)
- [Contacts Content Provider](http://developer.android.com/guide/topics/providers/contacts-provider.html)
- [Android Contracts](https://github.com/android/platform_frameworks_base/tree/master/core/java/android/provider)
- [Normal and Dangerous Permissions] (https://developer.android.com/guide/topics/security/permissions.html#normal-dangerous)
