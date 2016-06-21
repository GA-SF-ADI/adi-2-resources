---
title: Custom Adapters
duration: "1:30"
creator:
    name: Aleksandr Tomak
    city: SF
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Custom Adapters

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Describe why you would use a Custom Adapter
- Create a custom adapter
- Create layouts for the custom adapter

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Create a listView using ArrayAdapter
- Create classes and subclasses

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Read through the lesson
- Add additional instructor notes as needed
- Edit language or examples to fit your ideas and teaching style
- Open, read, run, and edit (optional) the starter and solution code to ensure it's working and that you agree with how the code was written

---
<a name="opening"></a>
## Opening (5 mins)

When we want to create a list view, with complex list items, we have to use a Custom Adapter.

![](pandora_station_list.png)

> Check: Pair up and list the types of views do you see for each list item.

As you can see, this layout is fairly complex. It contains an 
- ImageView for station thumbnail. 
- TextView for station name. 
- TextView when station was played.
- ImageView for currently selected station that is otherwise not visible.

***

<a name="introduction"></a>
## Introduction: Topic (10 mins)

We've seen how to use [ArrayAdapters](https://developer.android.com/reference/android/widget/ArrayAdapter.html) with lists of data. Now lets learn how to draw a more complicated layout based on more complex data by **extending BaseAdapter** class.

ListView does something called view recycling, where even for a list of 1000 items, a list view will inflate as many list item layouts as there are visible elements. So if your screen can only fit 7 elements on screen, then 7 layouts are inflated. These 7 layouts are then **re-used** between all 1000 items you have in your data list for your list view.

![](https://camo.githubusercontent.com/9ec060191347dd366729c095b529ed21e763a075/68747470733a2f2f692e696d6775722e636f6d2f535a38694b75752e6a7067)
Image taken from this [guide](https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView).

Notice how when we scroll the screen and element **1** moves offscreen while element **8** moves onto the screen. 
- Element 1 is moved offscreen, its `convertView` layout is then recycled and stored in memory
- getView() is called, and **re-use** the already created `convertView` but make modifications to it. If element 1 had a `TextView` that had text `"Position 1"`, we will now update the text to say `"Position 8"`. 
- The updated `convertView` layout is returned from the `Adapter` to the `ListView` and is drawn on screen.

## Extending BaseAdapter ( 40 mins )

#### Step 1) ( 1 min )

Add `ListView` item to your xml with an id. Our view id here is `list_view`.
```xml
<ListView
    android:id="@+id/list_view"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
</ListView>	
```

#### Step 2) ( 3 min )

Create your own custom item layout. It models what each item in the row looks like.

Layout below is called `list_item.xml`. It has two `TextViews` inside a `LinearLayout` one `Button` that says "Click me".

TextViews each have their own id, starting with layout name, view type, and order.
So `list_item_tv_first` for the first text view inside `list_item.xml` layout. 

It is good practice to start getting organized with your id names.

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:background="@android:color/holo_blue_dark">

    <TextView
        android:id="@+id/list_item_tv_first"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_weight="2"
        android:text="First"/>

    <TextView
        android:id="@+id/list_item_tv_second"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:text="Second"/>

    <Button
        android:id="@+id/list_item_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:text="Click me"/>

</LinearLayout>

```

#### Step 3) ( 1 min )

Lets create our Custom Base Adapter by creating a new file called `CustomBaseAdapter.java`. 

Inside `CustomBaseAdapter.java` you will declare the `CustomBaseAdapter` class like so:
```java
public class CustomBaseAdapter {

} 
```

#### Step 4) (  min )

Lets extend the `BaseAdapter` class inside our `CustomBaseAdapter` class.

Notice that there **will be red warnings** from Android Studio. Its ok, don't panic.
```java
public class CustomBaseAdapter extends BaseAdapter {

}
```

###### Step 4a) ( 5 min )

Next, let's make a constructor for our adapter that takes some data.

For this exercise, we will take a `Context` object and an `ArrayList` of Animal Objects as our arguments to the constructor. 
Save a reference to both of these variables inside `CustomBaseAdapter` by declaring and assigning member variables `data` and `context`.

```java
public class CustomBaseAdapter {
	private ArrayList<Animal> data;
    private Context context;

    public CustomBaseAdapter(Context context, ArrayList<Animal> animalList){
        this.data = animalList;
        this.context = context;
    }
}
```

Now the custom adapter has access to a context and some data!

> Check: Why do we need access to the data inside the adapter?

> Solution: The adapter binds the data to the views. Without the data there is nothing for the adapter to bind to the views.

#### Step 5) ( 5 min )

Time to fix all the red warnings, we will do this in steps a and b. We must `implement` the methods declared inside the **abstract** `BaseAdapter` class. 

###### Step a)

Inside CustomAdapter class, right click ( mac press command + n ) and select `Generate`. Next, select the `Implement Methods` option and press enter.

###### Step b)

There will be another popup highlighting **4** methods. Make sure **all 4 are selected** and press enter again. Android Studio will add them into your `CustomBaseAdapter` class.

```java
public class CustomBaseAdapter extends BaseAdapter {
	    private ArrayList<Animal> data;
        private Context context;

    public CustomBaseAdapter(Context context, ArrayList<Animal> animalList){
        this.data = animalList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
```

> Check: Why is it about the BaseAdapter that makes us implement the four methods?

> Solution: Base Adapter is an abstract class, and those four methods are abstract. They need to be implemented or our CustomBaseAdaper class becomes abstract if we don't.

#### Step 6) ( 25 min )

Lets add code to the 4 methods in steps a, b, c, and d.

###### Step a)

`getCount()`: This method returns the number of data items available. This is just the size of our `data` ArrayList
```java
@Override
public int getCount() {
    return data.size();
}
```

###### Step b)

`getItem()`: This method returns the data item at the specific position from our `data` ArrayList!
```java
@Override
public Object getItem(int position) {
    return data.get(position);
}
```

###### Step c)

`getItemId()`: This method returns the unique id identifying the item at this position. We don't necessarily have one for this example so we just return the position since each item has their own unique position.
```java
@Override
public long getItemId(int position) {
    return position;
}
```

###### Step d)

`getView()`: Meat of the class. This method will return the actual list item view that will be drawn inside the `ListView`. This method also binds the `data` List to the views associated with it. ( i.e. Setting text on `TextViews`, images on `ImageViews`, etc ).

<details>
  <summary>Click here to see what getView() should look like</summary>
```java
@Override
public View getView(final int position, View convertView, ViewGroup parent) {
    /**
     * Convert view will be the top level view of our list item layout.
     *
     * For us this means its a LinearLayout.
     *
     * We check if its null, and non existent then we inflate the view. Otherwise
     * we want to re-use the current layout.
     */
    if (convertView == null) {
        convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    /**
     * Using our top level layout, we can find all the subviews we defined within it.
     *
     * For us, we know we have 2 TextViews and 1 Button.
     */
    TextView firstTextView = (TextView) convertView.findViewById(R.id.list_item_tv_first);
    TextView secondTextView = (TextView) convertView.findViewById(R.id.list_item_tv_second);
    Button button = (Button) convertView.findViewById(R.id.list_item_button);


    /**
     * We can pull out our data object from the data list using its position.
     *
     * In this case, we grab the current animal for this view based on its position
     * in the data list.
     */
    final Animal currentAnimal = data.get(position);

    /**
     * Now we can bind our data values from the currentAnimal object instance into our
     * views!
     *
     * In this case we take the animal name and number of legs and set them as text in
     * both TextViews
     */
    firstTextView.setText(currentAnimal.getName());
    secondTextView.setText(currentAnimal.getSound());

    
    /**
     * Lastly, we create a button click listener that will toast the animal name and sound.
     * 
     * First we store the String `animalName says: animalSound` inside a variable to use inside
     * the Toast
     */
    final String toastText = currentAnimal.getName() + " says: "+ currentAnimal.getSound();

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
        }
    });

    /**
     * Return the whole item layout here so it can be drawn by the ListView
     */
    return convertView;
}
```
</details>

> Check: What does the getView() method do?


> Solution: It binds the data to the views of each row element in the ListView.

#### Step 7) ( 10 min )

Set the custom adapter on our ListView inside our Activity!

```java
public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Animal> animalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    	// find list view in main activity layout 
        listView = (ListView) findViewById(R.id.list_view);

    	// add some data to our animalList
        animalList = new ArrayList<>();
        animalList.add(new Animal("cow", "moo"));
        animalList.add(new Animal("cat", "meow"));
        animalList.add(new Animal("dog", "woof"));
        animalList.add(new Animal("sheep", "baaaa"));

    	// create an instance of our CustomBaseAdapter class, passing in context and data list 
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(MainActivity.this, animalList);
        
        // set custom adapter on our list view
        listView.setAdapter(customBaseAdapter);
    }
}
```

<details>
  <summary>Click here to see Animal.java</summary>
```java
public class Animal {
    private String name;
    private String sound;

    public Animal(String name, String sound){
        this.name = name;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
```
</details>

#### Completion ( almost )

That's it, you created an adapter that takes a custom layout and allows for all sorts of fancy things with lists! 

## Improve ListView Performance with View Holder Pattern ( 20 min )

Say say we have a really long list of data through which we scrolled often. Our list items might get jarbled up and not be ordered properly.

The way to fix this is to use something called a `View Holder Pattern`.

`ViewHolder Pattern` is basically a way to recycle views. Instead of inflating many multiple LinearLayouts with two `TextViews` and one `Button` ( our custom item layout ), we can just inflate it once and hold a reference to these views.

When we need to update what the contents of each view are, based on the position of the item in the list, we simply pull them out of our `ViewHolder` object.

#### Step 1) ( 5 min )

Create a ViewHolder inside of our `CustomBaseAdapter.java` class.

At the bottom of the class, create an inner class ( a class that is defined inside of another class ) called `ViewHolder`
```java
private class ViewHolder {
    TextView firstTextView;
    TextView secondTextView;
    Button button;
    
    public ViewHolder(View itemLayout){
        this.firstTextView = (TextView) itemLayout.findViewById(R.id.list_item_tv_first);
        this.secondTextView = (TextView) itemLayout.findViewById(R.id.list_item_tv_second);
        this.button = (Button) itemLayout.findViewById(R.id.list_item_button);
    }
}
```

<details>
  <summary>Click here to see what CustomAdapter.java looks like </summary>
```java
public class CustomBaseAdapter extends BaseAdapter {
    private ArrayList<Animal> data;
    private Context context;

    public CustomBaseAdapter(Context context, ArrayList<Animal> animalList){
        this.data = animalList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        /**
         * Convert view will be the top level view of our list item layout.
         *
         * For us this means its a LinearLayout.
         *
         * We check if its null, and non existent then we inflate the view. Otherwise
         * we want to re-use the current layout.
         */
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        /**
         * Using our top level layout, we can find all the subviews we defined within it.
         *
         * For us, we know we have 2 TextViews and 1 Button.
         */
        TextView firstTextView = (TextView) convertView.findViewById(R.id.list_item_tv_first);
        TextView secondTextView = (TextView) convertView.findViewById(R.id.list_item_tv_second);
        Button button = (Button) convertView.findViewById(R.id.list_item_button);


        /**
         * We can pull out our data object from the data list using its position.
         *
         * In this case, we grab the current animal for this view based on its position
         * in the data list.
         */
        final Animal currentAnimal = data.get(position);

        /**
         * Now we can bind our data values from the currentAnimal object instance into our
         * views!
         *
         * In this case we take the animal name and number of legs and set them as text in
         * both TextViews
         */
        firstTextView.setText(currentAnimal.getName());
        secondTextView.setText(currentAnimal.getSound());


        /**
         * Lastly, we create a button click listener that will toast the animal name and sound.
         *
         * First we store the String `animalName says: animalSound` inside a variable to use inside
         * the Toast
         */
        final String toastText = currentAnimal.getName() + " says: "+ currentAnimal.getSound();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * Return the whole item layout here so it can be drawn by the ListView
         */
        return convertView;
    }

    private class ViewHolder {
        TextView firstTextView;
        TextView secondTextView;
        Button button;

        public ViewHolder(View itemLayout){
            this.firstTextView = (TextView) itemLayout.findViewById(R.id.list_item_tv_first);
            this.secondTextView = (TextView) itemLayout.findViewById(R.id.list_item_tv_second);
            this.button = (Button) itemLayout.findViewById(R.id.list_item_button);
        }
    }
}
```
</details>

> Check: What is an inner class? Does ViewHolder have to be an inner class?

> Solution: Inner class is a class defined inside of another class. ViewHolder does not have to be an inner class. In fact, if you plan to re-use this ViewHolder for other adapters, you should make it a separate file. 

#### Step 2) ( 2 min )

Lets make use of this `ViewHolder` class by creating an object.

Add a global `ViewHolder viewHolder` variable at the top of `CustomBaseAdapter` class.

```java
public class CustomBaseAdapter extends BaseAdapter {
    private ArrayList<Animal> data;
    private Context context;
    private ViewHolder viewHolder;

    ... // rest of the code would be here
}
```

> Check: Where do you think we'll use this ViewHolder?

ViewHolder will be used inside the getView() method. Specifally, it is tied to our convertView.

#### Step 3) ( 3 min )

Lets use this new `viewHolder` variable.

Remember that orignally, `getView()` had an if-statement that looked like 
```java
@Override
public View getView(final int position, View convertView, ViewGroup parent) {

	if (convertView == null) {
        	convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
	}

	... // rest of code in method
}
```

Now, we will create an instance of the `ViewHolder` the first time `convertView == null`. Then we set the `viewHolder` as a tag on the `convertView` so that we can reference it later! 

Lastly, add an else clause to reference the `viewHolder` when `convertView` is not null!

```java
@Override
public View getView(final int position, View convertView, ViewGroup parent) {

	if (convertView == null) {
        convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        // create new ViewHolder and set it as the tag for convertView
		viewHolder = new ViewHolder(convertView);
        convertView.setTag(viewHolder);
    } else {
        // convertView exists, so we can grab our viewHolder from its tag
        viewHolder = (ViewHolder) convertView.getTag();
    }

    ... // rest of code in method
}
```


#### Step 4) ( 5 min )

The final step is to make use of this viewHolder instance and its references to our `firstTextView`, `secondTextView`, and `button`. We no longer need to use the `convertView.findViewById(R.id.view_id)` method since that is done for us inside the ViewHolder! **Remove all the findViewById() methods**. 

> Check: Pair up and predict how might we access our views from the ViewHolder

We can simply reference the view we want from `ViewHolder` and do what we want with that view.
```java
viewHolder.firstTextView.setText("Example of setting text on first text view from view holder!");
```

Now you have an efficient way of re-using inflated views for every list item! 

The completed getView() looks like this

<details>
  <summary>Click here to see what CustomAdapter.java should look like</summary>
```java
@Override
public View getView(final int position, View convertView, ViewGroup parent) {
    /**
     * Convert view will be the top level view of our list item layout.
     *
     * For us this means its a LinearLayout.
     *
     * We check if its null, and non existent then we inflate the view. Otherwise
     * we want to re-use the current layout.
     */
    if (convertView == null) {
        convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        viewHolder = new ViewHolder(convertView);
        convertView.setTag(viewHolder);
    } else {
        viewHolder = (ViewHolder) convertView.getTag();
    }

    /**
     * We can pull out our data object from the data list using its position.
     *
     * In this case, we grab the current animal for this view based on its position
     * in the data list.
     */
    final Animal currentAnimal = data.get(position);

    /**
     * Now we can bind our data values from the currentAnimal object instance into our
     * views, which are saved inside the ViewHolder!
     */
    viewHolder.firstTextView.setText(currentAnimal.getName());
    viewHolder.secondTextView.setText(currentAnimal.getSound());


    /**
     * Lastly, we create a button click listener that will toast the animal name and sound.
     *
     * First we store the String `animalName says: animalSound` inside a variable to use inside
     * the Toast
     */
    final String toastText = currentAnimal.getName() + " says: "+ currentAnimal.getSound();
    viewHolder.button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
        }
    });

    /**
     * Return the whole item layout here so it can be drawn by the ListView
     */
    return convertView;
}
```
</details>


<a name="ind-practice"></a>
## Independent Practice: Topic (20 minutes)

Open up the [starter-code](starter-code/) inside Android Studio.

You will find 3 classes
- Animal.java
- MainActivity.java
- **CustomBaseAdapter.java**

Your task is to fill in the `CustomBaseAdapter` class and get the application working.
- Follow the steps from above.
- Note that everything is created for you, from custom layouts, to main_acitivy.xml and MainActivity class itself.
- Only CustomBaseAdaper needs to be filled in.

[Solution code](solution-code/) is available.

**Bonus:** Use the ViewHolder pattern!

**Bonus:** Use your own custom layout with `different` view elements!

***

<a name="conclusion"></a>
## Conclusion (5 mins)
- Why would you create a CustomAdapter?
- What types of data can a CustomAdapter take?
- What does ViewHolder Pattern do?

***


### ADDITIONAL RESOURCES
- [Base Adapter Docs](https://developer.android.com/reference/android/widget/BaseAdapter.html)
- [Guide to Custom Adapters](https://guides.codepath.com/android/Using-a-BaseAdapter-with-ListView)
- [ViewHolder Pattern](https://developer.android.com/training/improving-layouts/smooth-scrolling.html#ViewHolder)
- [Custom Array Adapters](https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView)
- [Arrays Recycling Views](http://android.amberfog.com/?p=296)
