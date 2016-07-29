---
title: Google Play Services
duration: "1:25"
creator:
    name: Drew Mahrt
    city: NYC
---
# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Google Play Services

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Describe what features Google Play Services offers
- Set up and use the Analytics API

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Make APIs calls

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Run the solution code to ensure it works and that you agree with how it's implemented

---

### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 5 min  | [Opening](#opening-5-mins)  | Discuss lesson objectives |
| 15 min  | [Introduction](#introduction-what-are-google-play-services-15-mins)  | What are Google Play Services |
| 5 min  | [Demo](#demo-google-apis-reference-5-mins)  | Google APIs Reference |
| 10 min  | [Guided Practice](#guided-practice-setting-up-your-app-10-mins)  | Setting up your app |
| 30 min  | [Guided Practice](#guided-practice-implementing-the-analytics-api-30-mins)  | Implementing the Analytics API |
| 20 min  | [Independent Practice](#independent-practice-topic-20-mins)  | Topic |
| 5 min  | [Conclusion](#conclusion-5-mins)  | Review / Recap |
<a name="opening"></a>
## Opening (5 mins)

Up until this point, we haven't really differentiated between Android, the open-source operating system, and the version of Android offered by Google. When you use a device certified by Google (the vast majority of phones and tablets you come across), you gain the ability to use many special services offered by Google. Today, we will be learning about some of them, and how to actually use them.

> Check: Ask students to think of some specific features they think Google might offer that don't come standard with Android.

***

<a name="introduction"></a>
## Introduction: What are Google Play Services (15 mins)

Google Play Services was first introduced in 2012 to allow new authentication abilities and easier ways to access Google Plus. Since then, it has expanded to include many cool features used by all kinds of apps. These include things like location, Sign In, Drive, Cast, Ads, Wallet, and Fit.

Some devices choose not to use Play Services, such as the Fire line by Amazon. They run a heavily customized version of Android without access to the Play Store or any Play Services.

> Check: Predict, with a partner, the benefits of something like this.

Any device running Android 2.3 or newer has access to Play Services, and it automatically updates from the Play Store. Previously, new features were primarily rolled out through updates to Android, but with device manufacturers and service providers causing long delays, Play Services allows Google to quickly update all compatible devices.

Google updates Google Play Services often with some very cool features. Let's take a look at a [Youtube video](https://www.youtube.com/watch?v=nZjY_DPO1qs).

Keep an eye on the Google Developers YouTube channel for new updates about new features from Google.

> Check: What advantages does Google Play Services offer both users and developers? What are some disadvantages?

***

<a name="demo"></a>
## Demo: Google APIs Reference (5 mins)

Before we get started on actually using Google Play Services, [let's take a look at the documentation](https://developers.google.com/android/reference/packages). Some of the documentation is very technical, but it contains very useful information.

> Instructor note: Walk the students through a few APIs of your choice.

***

<a name="demo"></a>
## Guided Practice: Setting up your app (10 mins)

We need to complete a few steps to prepare our app to use Google Play Services.

First, we need to check if we have the correct files downloaded in the SDK Manager. Open the SDK Manager, go to the SDK Tools tab, then make sure Google Play Services is checked.

Next, if you use an emulator, make sure you chose an image that includes Google Play Services.

> Check: Were students able to install everything?

***

## Guided Practice: Firebase Notifications from the cloud! ( 20 min)

Sign up for an [account](https://firebase.google.com/).

Next, open up the [console](https://console.firebase.google.com/) and press on the `create project` button and give you project a name. Then click `create project` once more. It will take a while to setup, then it should auto kick you into your created project, if not just click on it to load the next page.

Now, lets click on the `Add firebase to you Android App` button. You will have a popup asking for you project package name, lets come back to this.

Create a new Android Studio project called FireBaseNotification. Once the project is created, open your `AndroidManifest.xml` to find your `package="somePackage"` at the top. We want the "somePackage" value for the popup.

Come back to that popup we saw earlier. Paste your package path into the field and press `add app`. Your browser will then download a file `google-services.json`. We need to copy this file into our android studio project. Follow the on screen instructions in the popup they are self explanatory and provide visual. You switch from Android view to project View, and paste the file into your `app/` folder. Once finished, press `continue` button.

Follow step 1 and step 2 on the popup. You are adding the line below to your **project** gradle file.
```
classpath 'com.google.gms:google-services:3.0.0'
```
Then in your **app** gradle file you need to add the below line at the **very bottom of the file**, below the dependency clause.
```
apply plugin: 'com.google.gms.google-services'
```

Now we have setup firebase inside of our app and on the website! 


We can follow this [guide](https://firebase.google.com/docs/cloud-messaging/android/client).
We need to add `compile 'com.google.firebase:firebase-messaging:9.2.1'` to our **app gradle** file.

Next we need to create a class that will extend `FirebaseMessagingService`. Inside this class we override the `onMessageReceived()` method and do whatever we wish with the incoming message.

```java
public class FireBaseGcm extends FirebaseMessagingService {
  
    private static final String TAG = "FireBaseGcm";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.i(TAG, "onMessageReceived: " + remoteMessage.getFrom());;
        Log.i(TAG, "onMessageReceived: body " + remoteMessage.getNotification().getBody());
    }
}
```

Finally, lets add this new `FireBaseGcm` into our `AndroidManifest.xml` file just like in the guide.
```xml
<application
    ... // activities declared here
    
    <service
        android:name=".FireBaseGcm">
        <intent-filter>
            <action android:name="com.google.firebase.MESSAGING_EVENT"/>
        </intent-filter>
    </service>
    
</application>
```


Time to get message notifications working. On the left side of the firebase console webpage, scroll down until you find the `Notifications` section and click on it. Press on the `Send your first message button`. This will take us to the screen that will send messages to **all** devices running our app. You enter `text` that will be the message and at the bottom you select your app from the dropdown and press send! The message will arrive on the phone.

Because we added the following line inside our custom class, we get the message from the `remoteMessage.getNotification().getBody()` as a String and log it out.
```java
Log.i(TAG, "onMessageReceived: body " + remoteMessage.getNotification().getBody());
```
***

<a name="ind-practice"></a>
## Independent Practice: Topic (20 mins)

You have two tasks: 1 Practice what we learned above. 2 Learn something new and on your own! There is no starter code but there is [solution-code](solution-code/MyApplication/)


* 1: Follow the above instructions to get Firebase Notifications working on your own app that you create from scratch. Lastly, in the  `onMessageReceived()` you should make a local device notification of the message we received from the cloud! Use title "FireBase Push notification!" and the content text should be the message body as seen in examples above.
* 2: Follow this [guide](https://firebase.google.com/docs/analytics/android/start/) to setup Firebase Analytics! This will allow you to track any actions you wish that the user makes inside your app. You can continue working off of the previous project from step 1. Your results will be visible within 24 hours on the console site or you can use the below commands to confirm the events as they happen.
```
adb shell setprop log.tag.FA VERBOSE
adb shell setprop log.tag.FA-SVC VERBOSE
adb logcat -v time -s FA FA-SVC
```

***

<a name="conclusion"></a>
## Conclusion (5 mins)

The Google Play Services API have grown to encompass a very large set of features, and they can be difficult to navigate around sometimes, but once you get used to them, they are extremely helpful. With their assistance, you are able to add some extremely powerful capabilities with relatively little effort.

***

### ADDITIONAL RESOURCES
- [Google Play Services](https://developers.google.com/android/guides/overview)
- [Adding Google Services to your app](https://developers.google.com/mobile/add)
- [Event Tracking](https://developers.google.com/analytics/devguides/collection/android/v4/events)
