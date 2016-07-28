---
title: Permissions
duration: "1:30 lesson. 0:40 Independent work"
creator:
    name: Aleksandr Tomak 
    city: SF
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Permissions


### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Understand how permissions evolved from Android M ( 6.0 ) and up
- Understand how to handle permissions on older and newer OS versions
- Properly ask for user permissions
- Handle cases where users deny permissions without crashing


### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Start a new project that targets SDK 23 or above

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Read through each lesson section and add or edit content as needed

---
<a name="opening"></a>
## Opening (5 mins)

Whats App is quite popular nowadays. Its an app that allows people to text and call each other among other things.

Whats App requires use of microphone in order to provide use of their call feature.

![](http://core0.staticworld.net/images/article/2015/05/android_m_permissions-100587839-orig.jpg)

> Check: Ask students to take 20 seconds and decide which picture is the old permission model and which picture is the new one?

> Check: Ask students what the difference is between old permission model and new permission model? Ans: Install time vs Run Time.

***

<a name="introduction"></a>
## Introduction: Permission Models (10 mins)

Prior to Android M ( 6.0 ) users had accept **all** requested permission during **app installation**. If you did not like that an
app was asking for a certain permission, you had two choices:
- Do not install the app, and therefore don't use it.
- Install the app and give up certain privacy. i.e. giving up your location or contacts to the app.

Android M ( 6.0 ) and above, users are **not** asked for permissions during installation. Instead, users are asked to grant permissions
whenever the app needs that permission. For example, Whats App should ask for Microphone permission when a user is trying to make a call - not at any other time. 
The app can still run and work fine if the user denies the Microphone permission, but the calling feature will **not** work anymore for this user.

Note: With the new permission model, a user can **revoke any** permission at **any time** by going into their 
```
Settings -> Apps -> YourApp -> Permissions
````

This means that even if a user has granted a permission in the past, you are **not garunteed** to still be granted that permission. Users can
and do grant/revoke permissions when you app is **not even running**.

> Check: What would happen if I granted Whats App microphone permission, but closed their app, and went into settings and revoked that permission? Ans: Whats App would need to ask for it again, if it assumes it has the permission - it will crash!

***

## Types of permissions (20 mins)

There are **two types** of permissions:
- Normal Permissions
- Dangerous Permissions

#### Normal Permissions:
Indicates that there's no great risk to the user's privacy or security in letting apps have those permissions. 
For example, here's no great risk in allowing an app to vibrate the device, so that permission is designated as normal. 
Whereas, access to contacts affects the user's privacy, so its a dangerous permission.

If an app declares in its manifest that it needs a normal permission, the system automatically grants the app that permission at install time.
The system does not prompt the user to grant normal permissions, and users cannot revoke these permissions.

Find a list of normal permissions [here](http://developer.android.com/guide/topics/security/normal-permissions.html).
If a permission is not on this list, then it must be dangerous.

#### Dangerous Permissions: 
Dangerous permissions cover areas where the app wants data or resources that involve the user's private information, or could potentially affect the user's stored data or the operation of other apps. 
For example, the ability to read the user's contacts is a dangerous permission. If an app declares that it needs a dangerous permission, the user has to explicitly grant the permission to the app.

Dangerous permissions are split into groups, visible [here](http://developer.android.com/guide/topics/security/permissions.html#normal-dangerous).
If an app requests a dangerous permission listed in its manifest, and the app already has another dangerous permission in the same permission group, the system immediately grants the permission without any interaction with the user

***

## Checking for permissions (10 mins)

If your app needs a dangerous permission, you must check whether you have that permission every time you perform an operation that requires that permission. 
The user is always free to revoke the permission, so even if the app used the camera yesterday, it can't assume it still has that permission today.

```java
int permissionCheck = checkSelfPermission(Manifest.permission.WRITE_CALENDAR);
```

If the app has the permission, the method returns ```PackageManager.PERMISSION_GRANTED```, and the app can proceed with the operation. 
If the app does not have the permission, the method returns ```PERMISSION_DENIED```, and the app has to explicitly ask the user for permission.

> Check: Ask students to pair up and discuss when Instagram should be checking if a user granted the camera permission? File storage permission? 

***

## Asking for permissions (10 mins)

If your application does not have the granted permission you are looking for, you can request it like so:

```java
String[] permissions = new String[]{Manifest.permission.READ_CONTACTS};
requestPermissions(permissions, PERMISSION_REQUEST_CODE);
```

```MY_PERMISSIONS_REQUEST_READ_CONTACTS``` is an app-defined int constant ( just like request codes for start-activity for result).
The callback method gets the result of the request.

> Check: Ask students to pair up and explain why there is a ```new String[] {}``` instead of just a String?

We can pass in **multiple** permission requests at the same time via the 
```java
new String[] {permission1, permission2, etc}
```.
They will all be cycled through in the same popup dialog with page indicators. 
![](http://www.androidpolice.com/wp-content/uploads/2015/05/nexus2cee_appops-03.png)

***

#### Demo: Check permission and ask for it (15 min)

Before we ask for a permission, we should check that we don't have it first. If we don't have the permission then we need to ask for it.
If we do have the permission, then we can just continue with our code.

```java
// Here, thisActivity is the current activity
if (checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
    
    // Should we show an explanation?
    if (shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS)) {

        // Show an expanation to the user *asynchronously* -- don't block
        // this thread waiting for the user's response! After the user
        // sees the explanation, try again to request the permission.

    } else {
        // No explanation needed, we can request the permission.
        String[] permissions = new String[]{Manifest.permission.READ_CONTACTS};
        requestPermissions(permissions, PERMISSION_REQUEST_CODE);

        // PERMISSION_REQUEST_CODE is an
        // app-defined int constant. The callback method gets the
        // result of the request.
    }
} else if (checkSelfPermission(Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
    
    // Permission is granted, execute code normally since you have the permission.
    // For example, here we are granted the contacts permission so now we can actually access the contacts here.
    
}
```

```shouldShowRequestPermissionRationale()```. This method returns true if the app has requested this permission previously and the user denied the request.

Note: If the user turned down the permission request in the past and chose the ```Don't ask again``` option in the permission request system dialog, this method returns false. 
The method also returns false if a device policy prohibits the app from having that permission.

The reason this method exists is to provide a way for the app to detect when a user might be confused about permissions.

For example, if a user launches a photography app, the user probably won't be surprised that the app asks for permission to use the camera,
but the user might not understand why the app wants access to the user's location or contacts. In this case, the user will probably deny access to location/contacts. 
Next time you check for these permissions, your ```shouldShowRequestPermissionRationale()``` would return ```true```, hinting to you that you might want to **explain** why you are asking for these permissions. 
i.e. Using a popup dialog.


***

<a name="guided demo"></a>
## Independent Practice: Ask for Contacts permission (20 mins)

Open up the [starter-code](starter-code) and run the application. Make sure that your device or emulator has some contacts, if
it doesn't then please create a few! Press on the button which should populate all contacts in a listview below the button.
- If your emulator, phone/tablet is running Android M or above, you should get permission denied errors in your logs and probably a crash as well.
- If you're running an OS older then Android M, then the button click will pull out the contacts and add them to the list view.


Lets fix that crash on Android M and above OS's! 
- Fill out the TODO statement inside the ```requestUserForPermission()```.
- Your job is to ask for the Contacts Read permission which is pre-defined by variable ```CONTACTS_PERMISSION```. 

If you've done this correctly, you should get a popup dialog asking for the permission. If you press allow/accept, then nothing
will happen ( we are not listening for permission results YET ). Pressing the button again will populate the listview.

If you pressed deny then pressing the button again will show the permission popup once more.


## Handling Permission Results (15 min)

When your app requests permissions, the system presents a dialog box to the user. When the user responds, the system invokes your app's ```onRequestPermissionsResult()``` method, passing it the user response.
Your app has to override that method to find out whether the permission was granted. The callback is passed the **same request code** you passed to ```requestPermissions()```.

```java
@Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode){
            case PERMISSION_REQUEST_CODE:
                if (permissions.length < 0){
                    return; // no permissions were returned, nothing to process here
                }
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // contacts permission was granted! Lets now grab contacts or show them!
                } else {
                    // contacts permission was denied, lets warn the user that we need this permission!
                    Toast.makeText(getApplicationContext(), "You need to grant contacts permission", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
```

Note that permissions is a String array and grantResults is an int Array. This means that:
- permissions[0] relates to grantResults[0]
- permissions[1] relates to grantResults[1]
- permissions[2] relates to grantResults[2]
- etc

This is true for **EACH** permission asked, assuming you asked for multple permissions in your String[]. So if you ask for three permissions via the String[], both of these arrays
will have a lenght of 3 like shown above. 

In our case, we only asked for one permission. So we only check permissions[0] and its matching grantResults[0].
 
> Check: Why do we pass in a request code when asking for permissions?

<a name="guided demo"></a>
## Independent Practice: Handle permission results (20 mins)

Working off your previous solution to the [starter-code](starter-code), lets add support for permission results.

You must:
- Override ```onRequestPermissionsResult()``` on ```line 163``` of MainActivity.java
- Make sure you are working with results from the **correct** request code.
- Check if the permission was ```granted``` or ```denied```.
- If permission was ```granted```, you should show the contact list by calling ```showContacts()```.
- If permission was ```denied```, you should give some visual feedback to the user. A toast will be fine for this exercise.


If you got this working successfully, then after user grants the app ```READ_CONTACTS``` permission, the list view should auto
populate with contact names! Otherwise, if permission was denied, we should see some sort of toast.

Refer to the [solution-code](solution-code) if you get stuck or want to check your answers!

***

<a name="conclusion"></a>
## Conclusion (5 mins)

- How does the new permission model differ from the old permission model?
- When can a user grant or revoke permissions?
- What are normal permissions?
- What are dangerous permissions?
- What are permission groups?


***

### ADDITIONAL RESOURCES
- [Normal Permission](http://developer.android.com/guide/topics/security/normal-permissions.html)
- [Permission groups](http://developer.android.com/guide/topics/security/permissions.html#normal-dangerous)
- [Requesting permissions](http://developer.android.com/training/permissions/requesting.html)
- [Best practices for permissions](http://developer.android.com/training/permissions/best-practices.html) 
- [Declaring permissions](http://developer.android.com/training/permissions/declaring.html)
