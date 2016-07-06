---
title: Fragments
duration: "1:25"
creator:
    name: Drew Mahrt & Aleksandr Tomak
    city: NYC, SF
---
# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Fragments


### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Describe the purpose of a Fragment
- Give examples of when to use a Fragment
- Create an app that switches between Fragments

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Describe the purpose of an activity
- Describe the Activity Lifecycle

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Review pre-work, projects, or exit ticket, if applicable
- Review current lesson objectives
- Reference general course content or topics (e.g. code or concepts that have been used across multiple lessons)
- Include Hook / Real-world Relevance (why the content from this lesson is useful or important)

---
<a name="opening"></a>
## Opening (5 mins)

So far, all of our screens have been contained in separate activities. We can use something called a "Fragment" for showing multiple screens in one activity, or more than one layout on a single screen. This gives us much more flexibility with how we organize our Views, as well the overall design of the app.


***

<a name="introduction"></a>
## Introduction: What is a Fragment? (15 mins)

Fragments were introduced in version 3.0 of Android (Honeycomb) in order to allow for more flexible layouts on large screens. When the tablet and phone versions of Android were merged in Android 4.0 (Ice Cream Sandwich), Fragments were also available for phones.

With Fragments, you can swap out entire sections of the layout at runtime while the current Activity is still running. Fragments cannot be created on their own - they **must** be contained within an Activity. Due to the close relationship with the hosting Activity, they are also affected by the Activity's Lifecycle. In addition, each fragment has its own Lifecycle (something we will be discussing soon). Basically they are like a Sub-activity of the parent Activity.

<p align="center">
  <img src="./images/fragments.png">
</p>

#### Why Fragments?

The use of Fragments in Android apps can be somewhat controversial. In reality, almost everything you do with Fragments you can also just do with an Activity. For instance, the example described above with swapping entire parts of the screen out without switching Activities can be done by manually showing or hiding multiple UI elements on the screen. However, with a complicated layout, this can be a very long progress, and can make your code confusing.

Some developers like using Fragments extensively, while others use them as sparingly as possible. It is important to understand how they work so you can decide whether or not they fit your particular situation. There is no universal guide for exactly when a Fragment is required, but as you grow in your development career, you will begin to understand when it is ideal to use them.

The power of fragments shows when you want  to re-use the same screen over and over. Maybe you want to use a special map screen you created in your MainActivity, DetailActivity and SummaryActivity. Writing the MapFragment once, we can re-use it in all three activities without duplicating map code.

#### Fragment Lifecycle

<p align="center">
  <img src="./images/fragment_lifecycle.png">
</p>

While the Fragment Lifecycle is similar the Activity's, there are some key differences. Let's look at some of the important methods:

- `onCreate`: In Fragments, onCreate is used to initialize data, and retrieve data that might have been stored when the Fragment was stopped. **Don't use it to work with Views in the layout.**

- `onCreateView`: This is the method where you will get references to your Views, and act on them. This method returns a View, which is the parent View you will be showing in the Fragment.

- `onPause`: This is just like onPause from the Activity, but it only applies to the current Fragment.


> Check: Describe the relationship between fragments and activities.

***

<a name="demo"></a>
## Demo: Creating a Fragment (20 mins)

There are two ways of creating fragments.
1. Statically
2. Dynamically

> Check: Take 30 seconds to predict the difference between the two types of Fragments

A static fragment means its directly tied to the activity xml layout and can never be changed or swapped out for anther fragment.

A dynamic fragment lives inside of a `container` ( any layout, usually `FrameLayout` ) and can be swapped. Meaning that you can put FragmentA into your container. Later you can swap FragmentA for FragmentB. At some later time you can swap FragmentB for FragmentA again or another FragmentC instead. Its up to you!

#### 1. Creating Static fragments

There are three steps to creating a static fragment:
1. Create fragment layout
2. Create fragment class
3. Add fragment to activity xml

###### 1. Create Fragment layout

Lets create a layout for our fragment.

fragment_example.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="I am a fragment!"/>
</LinearLayout>
```

###### 2. Create fragment class 

To create a Fragment, we must make a new Java file and extend Fragment. There are some other specialized Fragments such as `ListFragment`, `DialogFragment`, and `PreferenceFragment`, but we will just concentrate on the base Fragment for now:

**NOTE:** You should always use the `android.support.v4.app.Fragment` import.

```java
public class ExampleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.example_fragment, container, false);
    }
}
```
Notice that you have to use the inflater to inflate our fragment layout and return it as the view.

###### 3. Add fragment to Activity xml

In your `activity_main.xml`:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <fragment android:name="ly.generalassemb.drewmahrt.basicfragment.ExampleFragment"
        android:id="@+id/fragment1"
        android:layout_weight="1"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
    <fragment android:name="ly.generalassemb.drewmahrt.basicfragment.ExampleFragment"
        android:id="@+id/fragment2"
        android:layout_weight="2"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
</LinearLayout>
```
Note here that we wrote the code for `ExampleFragment` **once**, but we are able to use it more then once - and in the same activity. Talk about code re-use!

Note the `android:name` property in the xml, this points to the actual fragment class inside of our project. That class, then inflates the layout for the fragment - we don't ever mention the fragment's layout in the activity's xml.

> Check: Quickly, describe the steps needed to add a fragment based on what we saw above.
> Solution: 1. Create fragment layout 2. Create Fragment class 3. Include fragment inside the activity layout xml


***

<a name="guided-practice"></a>
#### Independent Practice: Static fragments (15 mins)

Open the [starter-code](starter-code/StaticFragment) and add the following:
- ExampleFragment.java class
- Make sure your ExampleFragment.java class overrides `onCreateView()` method and returns the inflated layout `fragment_example.xml`
- Add the ExampleFragment to `activity_main.xml`.

The layout for ExampleFragment is complete, along with a starter version of `activity_main.xml`.

**Bonus**: 
- Add a second ExampleFragment to main activity xml
- Create your own ExampleFragment layout
- Add Logs to each fragment life cycle method

Check your work against [solution code](solution-code/StaticFragment)

***


#### 2. Creating Dynamic Fragments

This will allow us to add Fragments programmatically, with no XML.

There are x steps to create a Dynamic Fragment:
1. Create your fragment xml layout
2. Create your fragment class
3. Create a container layout inside your activity xml
4. Override `onCreate()` in activity to use `FragmentManager` and `FragmentTransaction` to **add** your fragment. There is no fragment yet so we have to first add it. Later we can use **replace()** method when swapping fragments.
5. Tell your fragment to retain state across configuration changes. That is, when user rotates the screen and activity is destroyed and re-created, the fragment will remain and will not be destroyed. Read this [useful information](http://stackoverflow.com/questions/11182180/understanding-fragments-setretaininstanceboolean).


###### 1. Create Fragment layout

Lets create a layout for our fragment.

fragment_example.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="I am a fragment!"/>
</LinearLayout>
```

###### 2. Create fragment class 

To create a Fragment, we must make a new Java file and extend Fragment. There are some other specialized Fragments such as `ListFragment`, `DialogFragment`, and `PreferenceFragment`, but we will just concentrate on the base Fragment for now:

**NOTE:** You should always use the `android.support.v4.app.Fragment` import.

```java
public class ExampleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.example_fragment, container, false);
    }
}
```
Notice that you have to use the inflater to inflate our fragment layout and return it as the view.


###### 3. Create a container layout

We need to add a container of some sort for the fragment. Put the following in your `activity_main.xml` (it doesn't have to be a frame layout but usually is):

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    
    <FrameLayout
        android:id="@+id/fragment_container"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
    </FrameLayout>
    
</LinearLayout>
```
Notice that this `activity_main.xml` does not have anything except for the fragment container. Note that the container layouts id name is `fragment_container`. We will need this later to find our container.


###### 4. Adding the Fragment

Add the following to the `onCreate` of your main activity:

```java
FragmentManager fragmentManager = getSupportFragmentManager();
FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

// create a new fragment
ExampleFragment fragment = new ExampleFragment();

// add fragment to the container ( there is nothing there yet, that is why we add )
fragmentTransaction.add(R.id.fragment_container, fragment);
fragmentTransaction.commit();
```
> Check: Why are we using the add() method?

> Solution: Activity is just being created, this means the container doesn't have any fragments yet. We first have to add it. Later we can use replace() to swap out one fragment for anther one.

This uses two classes - `FragmentManager` and the `FragmentTransaction`.

As you can see, we use the `FragmentManager` to start a `FragmentTransaction`. With the `FragmentTransaction` we **add** a new Fragment and then commit the change.

**NOTE:** You should always use the `android.support.v4.app.Fragment` import for both `FragmentManager` and the `FragmentTransaction`.

**FragmentManager**

The [FragmentManager class](http://developer.android.com/guide/components/fragments.html#Managing), as the name implies, is used to manage your Fragments.

Its key features include:

- Finding fragments in your activity
- Removing fragments from the stack (like pressing the back button)
- Using FragmentTransactions (discussed below)

Basically, it is the top level management for everything Fragment-related in your apps.


**FragmentTransaction**

The [FragmentTransaction class](http://developer.android.com/guide/components/fragments.html#Transactions) is very closely tied to the FragmentManager. While Transactions can do many different things, it is mostly used for `adding, removing, and replacing Fragments` in your activities.

A Transaction is basically a sequence of commands you build up (such as adding and deleting), which you then commit to apply all at once. **Important:** These changes don't happen immediately, they are added to the backlog of items waiting to be run on the UI thread.


###### 5. Retaining fragment state

Finally, you can call the following method to save the state of the fragment across activity recreation. It is recommended you call it in `onActivityCreated()` **in your fragment**. Read this [useful post about the method](http://stackoverflow.com/questions/11182180/understanding-fragments-setretaininstanceboolean)

```java
public class ExampleFragment extends Fragment {
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }
    
    ...// rest of fragment code
}
```

#### Completion

Now you have a dynamic fragment that lives inside of your activity xml. Specifically, it lives inside the container we created in that layout.

> Check: Describe how to create a fragment programmatically without XML.

> Check: How would I replace the current fragment with another one?


***

<a name="ind-practice"></a>
#### Independent Practice: Dynamic Fragment (25 mins)

Open the [starter code](starter-code/DynamicFragment). It is a weather forecast app that holds the daily weather for Wednesday and Weekly weather ( Mon - Sun ).

The fragment layouts are completed for you.

Your task is to:
- Create a DailyForecastFragment.java fragment, link `fragment_daily.xml` to this fragment
- Create a WeeklyForecastFragment.java fragment, link `fragment_weekly.xml` to this fragment
- Inside main acitivity's `activity_main.xml` you need to create a fragment container
- Inside main activity's `onCreate()` you should add the DailyForecastFragment to the fragment container
- Inside main activity's `onClick()` method you need to replace daily/weekly fragment based on what is clicked

The fully functioning app should switch between daily and weekly forecast fragments when the respective button is pressed.

Bonus: 
- Create custom layouts for both fragments
- Add a third, 10-day forecast fragment to switch between
- Add Log statements to fragment lifecycle methods

Check your work against the [solution code](solution-code/DynamicFragment)

***

<a name="conclusion"></a>
## Conclusion (5 mins)

Fragments are very useful for certain situations, but you should probably avoid building your entire app out of them. They are extremely useful when you want to have entire parts of the screen you want to swap out on the fly. Carefully think through when you want to use them.

> Check: What is the downside of using fragments to build your app? 
> Solution: Added complexity and overhead. Especially maintaining fragment life cycle and moving data across fragments ( upcoming lecture ).


***

### ADDITIONAL RESOURCES
- [Fragments (Developer's Guide)](http://developer.android.com/guide/components/fragments.html)
- [Building a Dynamic UI with Fragments](http://developer.android.com/training/basics/fragments/index.html)
- [Retaining fragment state](http://stackoverflow.com/questions/11182180/understanding-fragments-setretaininstanceboolean)
