---
title: Event Handlers
duration: "1:30"
creator:
    name: Drew Mahrt
    city: NYC
---

<!--  OUTSTANDING

- May want to demonstrate grabbing and using user input in this lesson
- Discussion questions for the conclusion

-->

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Event Handlers

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Identify the different types of events that can be assigned to activity components
- Describe the concept as an event handler
- Describe how event listeners and handlers fit together
- Implement event listeners and handlers

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Describe basic XML layouts with buttons and text views
- Instantiate Java and Android objects

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Gather materials needed for class
- Complete Prep work required
- Prepare any specific instructions

---
<a name="opening"></a>
## Opening (5 mins)

There are two primary components to handling input events from the user. The first component is something called an event listener. These register a View to respond to a certain user action, or "event". They "listen" for an event to happen, such as a press on the screen. The second component is the event handler. Event handlers are the pieces of code that actually process and act on the events that were being listened for.

>Check: Ask the student to give examples of Views we've seen (ie Buttons) and how we've handled input events (ie onClick with a listener).

<a name="introduction"></a>
## Introduction: Event Handlers (25 mins)

The two most common ways to work with event handlers are by listening for events on existing views built into Android, or by creating a completely custom View component and directly extending View (or its subclasses).

A way to handle events are with the combination of 
- event listeners 
- event handlers 
 
Some common event listeners we see are:
- onClickListener 
- onFocusChangeListener
- onLongClickListener
 
These listeners have respective handlers:
- onClick() 
- onFocusChange()
- onLongClick()
 
Event listeners are tied to existing View objects through methods such as `setOnClickListener()`, which accepts an `onClickListener`, which in turns implements the `onClick()` event. This flow is actually displayed visually in your code, which we will see in the upcoming demo.


<a name="demo"></a>
## Demo: Listeners and Handlers (20 mins)

Our demo will involve a very simple listener which you have used in many of your daily apps: the `onLongClickListener`. As the name implies, it listens for a long click, or when you hold your finger down for an extended period of time on a component.

Let's start off with the basic listener:

```java
Button button = (Button) findViewById(R.id.button);

button.setOnLongClickListener(new View.OnLongClickListener() {

});
```

> Instructor Note: Ask the students what they think the event handler should be, and how it should be defined.

Now we need to pass an `OnLongClickListener` object to the `setOnLongClickListener()` method. We use the `new` keyword, and let Android Studio automatically provide the methods we must override. In this case, it provides the `onLongClick()` method:

```java
Button button = (Button)findViewById(R.id.button);

// we set a listener using the 'new' keyword
button.setOnLongClickListener(new View.OnLongClickListener() {

  // we handle the event when a long click is detected with 'onLongClick'
  @Override
  public boolean onLongClick(View v) {
    Toast.makeText(EventHandlersActivity.class,"Long Press handled!",Toast.LENGTH_SHORT).show();
  }
});
```

As you can see, we take the action we want to do within the `onLongClick()` method. All click listeners and event handlers follow this same basic flow, just with different names.

Using the example above, write code to add a `setOnFocusChangeListener()` on the same button we defined above. Let Android Studio auto complete the code for you with the new keyword.

Now write out a list of all the event listeners you know of and their respective handlers!
- Example: A view's `setOnFocusChangeListener()` takes a `focusChangeListener` listener object ( from `View.OnFocusChangeListener` ) and the event is handled in the `onFocusChanged()` method.

```java
Button button = (Button)findViewById(R.id.button);

// set a focus change listener. Using 'new' keyword we create a new listener
button.setOnFocusChangeListener(new View.OnFocusChangeListener() {

        // handle what happens when focus changes
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            Log.d("Tag", "Focus has changed!");
        }
});
```

<a name="ind-practice"></a>
## Independent Practice: Event Handlers -  Button enabling (15 mins)

In this practice, you must test that the user has checked a checkbox in order to enable a button. 
- If user checks the box, button should be enable.
- If user unchecks the box, the button should be disabled. 
 
This is used in systems such as registration forms where the user must agree to terms before they can register. 

**Don't forget to make a new branch for this lesson before you begin working** 

Starter code is provided in the [starter-code/ButtonEnabling](starter-code/ButtonEnabling) project.

Solution code is available in the [solution-code/ButtonEnabling](solution-code/ButtonEnabling) project.

<a name="ind-practice"></a>
## Independent Practice: Event Handlers (20 minutes)

In this independent practice, you must implement click listeners for the provided eight buttons.

The buttons are arranged in columns with labels to determine whether it will change the background or text color.
- If user clicks the `Red` button under the `TextColor` column, we change the sample text's color to red.
- If user clicks the `Red` button udner the `Background Color` column, we change the sample text's background color to red.
- Repeat for all the colors
- If user clicks on the `Sample Text` textview, you should change the text's color to black and background to white.

**If you haven't already, don't forget to make a new branch for this lesson before you begin working** 

Starter code is provided in the [starter-code/ColorChooser](starter-code/ColorChooser) project.

Solution code is available in the [solution-code/ColorChooser](solution-code/ColorChooser) project.

> Check: Were students able to create the desired deliverable(s)? Did it meet all necessary requirements / constraints?


<a name="conclusion"></a>
## Conclusion (5 mins)

Event listeners and event handlers are the foundation of user interaction with most apps, so becoming familiar with all of the listeners provided by Android will make you a stronger developer. With very little code, you are able to create highly interactive apps for your users. Hopefully you also have a better understanding about how many of the interactions work with your favorite daily apps.



### ADDITIONAL RESOURCES
- [Input Events](http://developer.android.com/guide/topics/ui/ui-events.html)
- [Custom Components](http://developer.android.com/guide/topics/ui/custom-components.html)
- [Java static colors](http://docs.oracle.com/javase/7/docs/api/java/awt/Color.html)
