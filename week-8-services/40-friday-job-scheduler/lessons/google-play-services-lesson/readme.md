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

Now we have setup firebase inside of our app! Time to get message notifications working.

<a name="guided-practice"></a>
## Guided Practice: Implementing the Analytics API (30 mins)

Open a new project in Android Studio.

Now, in your build.gradle, add the following line of code in your dependencies section:

```xml
compile 'com.google.android.gms:play-services:8.4.0'
```

**It is recommended that you specify what APIs you want to use in your app instead of adding all of the services.**  For example:

```xml
compile 'com.google.android.gms:play-services-fitness:8.4.0'
compile 'com.google.android.gms:play-services-wearable:8.4.0'
```

Next, your main activity must implement the `OnConnectionFailedListener` interface. This requires you to implement the `OnConnectionFailedListener` method, which is called if there is a complete failure for your app to connect to Play Services.

Now, the way we can access all of the Play Services APIs is through an object called `GoogleApiClient`. Put the following code in your `onCreate` method. While we aren't going to need this for the current example, you will need the GoogleApiClient for today's lab.

```java
GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(this)
    .enableAutoManage(this /* AppCompatActivity */,
                      this /* OnConnectionFailedListener */)
    .addApi(Drive.API)
    .addScope(Drive.SCOPE_FILE)
    .build();
```

In this example, we are accessing the Drive API.

Go to this link and sign in with your Google account: https://developers.google.com/mobile/add.

Let's follow the instructions for Analytics: You might need to edit the `gradle-wrapper.properties` file to point to a newer version of gradle:

```xml
https://services.gradle.org/distributions/gradle-2.10-all.zip
```
Put the following after your dependencies, not before:

```xml
apply plugin: 'com.google.gms.google-services'
```
Create the `AnalyticsApplication` class which extends `Application`. In the class, we declare a `Tracker` object and create a method that will return this tracker to us after setting it up with GoogleAnalytics and our Tracker ID.

```java
public class AnalyticsApplication extends Application {
    private Tracker mTracker;

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(/* Your Tracker ID String here */);
        }
        return mTracker;
    }
}
```

In your manifest, we need to declare this application class we created just like we do with activities!
```xml
<application
    android:name=".AnalyticsApplication"
    ... <!-- Other lines in the application tag -->
</application>
```

In `AnalyticsApplication.java`, modify the following line to match whatever is in your Tracker page.

```java
 mTracker = analytics.newTracker("UA-74227592-1"); // Sample Tracker ID is "UA-74227592-1"
```

Launch the app, and go to the Analytics page at analytics.google.com. Look under the real-time tracking and you should see your screen!

> Check: Were students able to successfully solve the problem or complete the task?

***

<a name="ind-practice"></a>
## Independent Practice: Topic (20 mins)

Now that you know how to track what screen a user is seeing, you will try tracking user actions in your app. Review the link below on Event Tracking. Add at least 3 different UI Widgets and track some action for each of them. Confirm that they are showing up in your analytics tracker!

[Event Tracking](https://developers.google.com/analytics/devguides/collection/android/v4/events)

> Check: Were students able to create the desired deliverable(s)? Did it meet all necessary requirements / constraints?

***

<a name="conclusion"></a>
## Conclusion (5 mins)

The Google Play Services API have grown to encompass a very large set of features, and they can be difficult to navigate around sometimes, but once you get used to them, they are extremely helpful. With their assistance, you are able to add some extremely powerful capabilities with relatively little effort.

***

### ADDITIONAL RESOURCES
- [Google Play Services](https://developers.google.com/android/guides/overview)
- [Adding Google Services to your app](https://developers.google.com/mobile/add)
- [Event Tracking](https://developers.google.com/analytics/devguides/collection/android/v4/events)
