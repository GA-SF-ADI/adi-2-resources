---
title: Fragments part 2
duration: "1:30"
creator:
    name: Drew Mahrt
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Fragments (part 2)

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Communicate between a fragment and its parent activity
- Communicate between fragments

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Describe and implement basic fragments

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Run the solution code to ensure it runs and that you agree with how it was implemented

---
<a name="opening"></a>
## Opening (5 mins)

We've covered the very basics of fragments so far, but there are many other things you can do with them. Until this point, our fragments have been isolated, performing work in their own section of the activity. 

Today we will talk about fragments communicating with other parts of the app like the Activity or other fragments.


***

<a name="introduction"></a>
## Introduction: Communicating with an activity (10 mins)

Remember that an Activity can access any fragment using the `FragmentManager`.
Even though fragments are independent modules, the activity can pass information to 
them via a method that the fragment owns. This is exactly the same way you had passed 
information to classes you created, using setter methods.

A fragment call also pass information to an Activity because fragment has access to its
parent activity via the `getActivity()` method. Using an interface, the fragment can pass information back to its parent activity.

Now, combine the above to methods of passing information from `Activity -> Fragment` and `Fragment -> Activity`.

> Check: Try to predict how we will use the above mentioned flow to connect data between two fragments.

You get: `FragmentA -> Activity -> FragmentB`. Where fragment A passes data to its parent activity. The parent activity now finds fragment B using `FragmentManager` and passes the data ( can be same or different, its up to you ) to fragment B using the setter method defined in fragment B.

***

<a name="demo"></a>
## Demo: Creating List Fragment and Regular Fragment (15 mins)

We need to create a new project where we will have two Fragments: A `ListFragment` and a normal Fragment. When we click on an item in the `ListFragment`, it will change text in the other Fragment.

Let's start by adding some data to show in the List. In your `strings.xml`, add the following ( its simply an array of strings called "Planets").

```xml
<string-array name="Planets">
        <item>Mercury</item>
        <item>Venus</item>
        <item>Earth</item>
        <item>Mars</item>
        <item>Jupiter</item>
        <item>Saturn</item>
        <item>Uranus</item>
        <item>Neptune</item>
    </string-array>
```

Now we can create the Java file for the List Fragment, lets call it MyListFragment.java.

It will extend `ListFragment`, this is a special type of fragment that subclasses `Fragment`. ListFragment is specialized to show lists. 

Note below that there is a `setListAdapter()` method, this given to you for free by the `ListFragment` class.

Also note that you can override `onListItemClick()` method to get the 
- ListView l
- View v
- int position
- long id

values for free as well. This means that `ListFragment` implements `OnListItemClickListener`. In this method we can decide what happens when a list item is clicked. For now, we just make a toast with the item position.

MyListFragment.java
```java
public class MyListFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Planets));
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT)
                .show();
    }
}
```

Finally, let's add the fragment to our activity xml layout and test it out.

activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:orientation="horizontal"
    tools:context="ly.generalassemb.drewmahrt.morefragments.MainActivity">

    <fragment
        android:id="@+id/list_fragment"
        android:name="ly.generalassemb.drewmahrt.morefragments.MyListFragment"
        android:layout_width="0dp"
        android:layout_height="match_parent"
        android:layout_weight="0.5"/>
</LinearLayout>
```

> Check: Is this a dynamic or static fragment?

It works so far!

Now it's time to add our second fragment, called DetailFragment. The layout for this fragment will be simple, it will just have a `LinearLayout` holding a `TextView` we can set. The fragment layout will be called `fragment_detail.xml`.

fragment_detail.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:id="@+id/text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Select a planet!" />
</LinearLayout>
```

Now we need to create our DetailFragment.java

```java
public class DetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // note here we are returning the layout xml we just defined above
        return inflater.inflate(R.layout.fragment_detail,container,false);
    }
}
```

Finally, lets add the detail fragment to our `activity_main.xml` and put it inside the linear layout ( which is horizontal ).


activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:orientation="horizontal"
    tools:context="ly.generalassemb.drewmahrt.morefragments.MainActivity">

    <fragment
        android:id="@+id/list_fragment"
        android:name="ly.generalassemb.drewmahrt.morefragments.MyListFragment"
        android:layout_width="0dp"
        android:layout_height="match_parent"
        android:layout_weight="0.5"/>

    <fragment
        android:id="@+id/detail_fragment"
        android:name="ly.generalassemb.drewmahrt.morefragments.DetailFragment"
        android:layout_width="0dp"
        android:layout_height="match_parent"
        android:layout_weight="0.5"/>
</LinearLayout>
```

## Demo: Communication between two fragments ( 30 mins )

We will learn to communicate in two parts.
- **Part 1)** We need to set up the communication from the list fragment back to the activity. `FragmentA -> Activity`.
- **Part 2)** We need to set up the cummunication from the activity to the detail fragment. `Activity -> FragmentB`.

#### Part 1) FragmentA -> Activity communication

When a fragment needs to talk back to its hosting Activity, you must perform the following steps:

1. Define an interface. Interface needs a method that takes some data as an agrument.
2. Override `onAttach()` method in your fragment. Get a reference to the interface by calling `getActivity()` and cast it to be the type of your interface.
3. Using the interface reference, you can pass the data to the activity at any time. Once you've passed data using the interface, the activity's implemented interface method ( called a callback ) will receive the data.
4. Implement the interface in the parent Activity.

In the callback method, you can perform some action in the Activity, or pass on information to a different Fragment.


###### Step 1

Define an interface in a separate file called `OnPlanetSelectedListener.java`. It will listen to which planet list item is selected and pass its name along to whoever implements the method ( in this case, its our activity ).

OnPlanetSelectedListener.java
```java
public interface OnPlanetSelectedListener {
  public void onPlanetSelected(String selectedPlanet);
}
```

###### Step 2

Overriding `onAttach` lets us check to make sure the parent activity implemented the callback needed for the interaction to be successful. That is why you see a try/catch block, which essentially checks if `getActivity()` implemented OnPlanetSelectedListener. If it didn't implement the interface, then a class cast exception will be thrown, because we try to cast our parent activity to something it is not!

In MyListFragment.java
```java

// declare a variable to store our instance of OnPlanetSelectedListener
OnPlanetSelectedListener mListener;
...


@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnPlanetSelectedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement OnPlanetSelectedListener");
        }
    }
```



###### Step 3

Pass some information from the fragment to the activity using our interface.

```java

    ... // code in MyListFragment

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        /**
         * When a list item is clicked, we can grab our adapter from listView `l`.
         * - l.getAdapter()
         *
         * From the adapter, we can grab our planet item by its position
         * - l.getAdapter().getItem(position)
         *
         * Lastly, we just toString() the item at the position to make sure its a 
         * String and store it inside selectedPlanetString variable. 

         * This planet is now passed to the interface and will be visible to
         * our parent activity's implemented method ( this will happen in step 4 ).
         */
        String selectedPlanetString = l.getAdapter().getItem(position).toString();
        mListener.onPlanetSelected(selectedPlanetString);
    }
```


###### Step 4.

Implement interface inside MainActivity, now we'll have our data from our fragment!

MainActivity.java
```java
public class MainActivity extends Activity implements OnPlanetSelectedListener {

    ...// MainActivity code
    
    @Override
    public void onPlanetSelected(String selectedPlanet) {
        // Our selected planet name is now inside our activity!

        // we can do whatever we want with it now! 
    }

}
```


#### Part 2) Activity -> FragmentB communication

To get communication between our activity and fragment working we have to follow these steps:

1. Add a helper method inside fragment B to take some data from the activity
2. Find fragment B inside parent activity using `FragmentManager` and pass data to it using the helper method we just created


###### Step 1.

Add a helper method in the detail fragment to accept the String from parent activity. Wwe are going to put the string inside the TextView.

```java
public class DetailFragment extends Fragment {

    ...// code from DetailFragment

    // Helper method to take selected planet string from activity
    public void setPlanetText(String planet){
            TextView text = (TextView)getView().findViewById(R.id.text);

            // set the selected planet name passed to us on our text view
            text.setText("Planet selected: "+planet);
    }
}
```

###### Step 2.

Lets find DetailFragment inside MainActivity's implemented method of OnPlanetSelectedListner.

MainActivity.java
```java
public class MainActivity extends Activity implements OnPlanetSelectedListener {
    
    ...// Rest of the code in MainActivity

    @Override
    public void onPlanetSelected(String selectedPlanet) {
        // Find DetailFragment by its fragment id!
        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
        detailFragment.setPlanetText(selectedPlanet);
    }
```


#### Completion!

Now you should have working communication between `FragmentA -> Activity -> FragmentB`.



***

<a name="ind-practice"></a>
## Independent Practice: Topic (25 mins)

Open the [starter-code](starter-code/MoreFragments).

You need to add fill in the TODO's inside these files in the order below:
- 1. MyListFragment
- 2. DetailFragment
- 3. MainActivity

The TODO's guide you in sending information from `MyListFragment -> MainActivity -> DetailFragment`.

All of the xml layouts and list adapters are premade for you! Simply practice getting information from one fragment, to the activity, and then to the next fragment.

There is [solution code](solution-code/MoreFragments) available for your reference.
***

<a name="conclusion"></a>
## Conclusion (5 mins)

Now that we have a more complete understanding of how fragments work, and how they interact with the activity as well as each other, we get a better idea of when they are appropriate to use. Setting up the interaction between a fragment and an activity might seem like a lot of work at first, but with practice it becomes easier.

> Check: Describe the steps needed to make the two fragments interact with each other.

***

### ADDITIONAL RESOURCES
- [Fragments Developers Guide](http://developer.android.com/guide/components/fragments.html)
- [Communicating in Fragments](https://developer.android.com/training/basics/fragments/communicating.html)
- [Adaptive UI Guide](http://developer.android.com/training/multiscreen/adaptui.html)
