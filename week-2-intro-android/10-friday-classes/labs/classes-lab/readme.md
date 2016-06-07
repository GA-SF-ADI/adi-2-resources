---
title: Creating Classes
type: lab
duration: "1:30"
creator:
    name: Drew Mahrt
    city: NYC

---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Creating Classes

## Introduction

> ***Note:*** _This can be a pair programming activity or done independently._

In this lab you will be using your knowledge of classes to build an app that utilizes an Animal class, complete with properties, getters and setters. After completing the class, you will instantiate your Animal and use the getters and setters to fill out TextViews.

## Exercise

#### Requirements

- Create an Animal class with the following properties: numLegs, topSpeed, isEndangered, name
- Complete the constructor for the Animal class
- Create all getters and setters for the Animal  properties
- Instantiate an Animal in your activity's onCreate, and display some of its properties in a TextView
- Use the setter methods to modify some of the animal's properties and show the modified animal in a second TextView

**Bonus:**
- Add additional methods to your Animal class that return a formatted String using the class properties.

#### Starter code

You will need to complete the constructor, getters and setters in the provided Animal.java file. MainActivity.java contains comments guiding you on the code you need to write.

#### Deliverable

Make your app look like the screenshot below, following the requirements above.

<img src="./screenshots/classes_lab.png" width="360" height="640">

#### Test your code

Included in this lab is a test suite you can use to test you code. The starter-code already has all the tests set up and available to you. These test use AndroidJUnit4 and Espresso. Be sure your phone or emulator are unlocked when running these tests.

In order to run these tests, go to the Build Variants section of Android Studio (usually bottom left of screen) and be sure to set "Test Artifacts" to "Android Instrumentation Test". Right click on the MainActivityTest.java file and click "Run MainActivityTest".

This will test a couple things about your application.

* If you have all the widgets needed and have id'd them correctly

 * R.id.output_text
 * R.id.changed_output_text
* Test if your text views have proper text in them
* Tests if your Animal constructor works correctly with proper parameters
* Tests Animal classes getters
* Tests Animal classes setters


## Additional Resources

- [TextViews](http://developer.android.com/reference/android/widget/TextView.html)
- Oracle: [Defining a class](https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html)
- Oracle: [Instantiating a class](https://docs.oracle.com/javase/tutorial/java/javaOO/objects.html)
