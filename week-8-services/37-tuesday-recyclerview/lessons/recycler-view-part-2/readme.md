---
title: Recycler View Part 2
duration: "3:00"
creator:
    name: Aleksandr Tomak
    city: SF
---


# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) RecyclerView Custom Adapter


### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Extend `RecyclerView.Adapter`
- Create your very own `OnItemClickListener` interface
- Use the **required** `ViewHolder` pattern

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Understand Recycler View Part 1
- Understand Interfaces and inter fragment communication ( same idea for this lesson )
- Understand ViewHolder pattern from CustomAdapters lesson

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Ready through the lesson and make necessary modification to match your teaching style
- Open and run the starter and solution code
- Add extra checks for understanding as needed

---
<a name="opening"></a>
## Opening (5 mins)

Let's discuss the benefits of using a Recycler View again!

> Check: Break up into groups and list the benefits of using recycler view.

The con of Recycler View is that it takes more time to implement. The custom adapter for Recycler View is more
complex then the one for List View. 

This lesson shows you how to create your own custom Recycler View adapter.

***

<a name="introduction"></a>
## Introduction: Recipe Steps (5 mins)

There are 8 steps to creating a custom Recycler View Adapter

* Step 1) Create list item xml layout
* Step 2) Create CustomRecyclerViewAdapter class
* Step 3) Create ViewHolder
* Step 4) Declare ViewHolder to the ReycyclerView.Adapter
* Step 5) Implement `RecyclerView.Adapter` methods
* Step 6) Create Data list variable && Constructor for CustomRecyclerViewAdapter class
* Step 7) Add code to 3 implemented methods from Step 5
* Step 8) Handling whole OnItemClicks


## Step 1) Create list item xml layout ( 5 min )

This is the easiest step. You just create a new xml layout for what each of the list items will look like.

We can use this simple `rv_list_item.xml` layout that has a
* Parent linear layout
* ImageView
* TextView

<details>
  <summary>Click here to see what your rv_list_item.xml file should look like</summary>
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="10dp"
    android:layout_marginBottom="10dp"
    android:background="?android:attr/selectableItemBackground">

    <ImageView
        android:id="@+id/list_item_image_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

    <TextView
        android:id="@+id/list_item_text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginLeft="20dp"
        android:text="Some text"/>
</LinearLayout>
```
</details>

## Step 2) Create CustomRecyclerViewAdapter class ( 2 min )

Create a new `CustomRecyclerViewAdapter.java` class.

Make sure it extends RecyclerView.Adapter<>
```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<> {

}
```

**Note**: Everything will be underlined red, fear not we will fix this as we go.

## Step 3) Create ViewHolder ( 15 min )

There are 3 steps to creating a ViewHolder ( steps a, b, c )

> Check: Take 1 minute to remember why are we using a View Holder?

> Solution: View Holder increases performance by not making extra calls to findViewById(). Also, Recycler View requires a View Holder.

#### Step 3a) Declare Inner View Holder Class ( 5 min )

Inside CustomRecyclerViewAdapter class, we need to declare an inner class ( remember: you can define a class inside of another class )

We will create a `public static` class called `SampleViewHolder`. Make sure it extends `ReyclerView.ViewHolder`!

```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<>{

    // Inner class SampleViewHolder that is public and static. It is also extending RecyclerView.ViewHolder.
    public static class SampleViewHolder extends RecyclerView.ViewHolder {

    }
}
```

#### Step 3b) SampleViewHolder constructor ( 3 min )

SampleViewHolder inner class needs a default constructor. 

You can generate one by:
* pressing ( command + n ) keys 
* selecting override 
* selecting ViewHolder in the popup
* pressing enter will generate the following code


```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<>{
    
	// Inner class SampleViewHolder that is public and static. It is also extending RecyclerView.ViewHolder.
	public static class SampleViewHolder extends RecyclerView.ViewHolder {
	
		// Default constructor that takes a view as an argument and passes it to super
		public SampleViewHolder(View itemView) {
	    		super(itemView);
		}
	}
}
```

Or you can just type it out. Remember that **default** constructor must take a `View` as an argument and you should pass it along to `super()`

#### Step 3c) Create views inside SampleViewHolder ( 5 min )

Remember the custom item layout we created in Step 1? The `rv_list_item.xml` layout contained an ImageView and a TextView Inside of a Linear Layout.

We need to create variables to track ImageView and TextView inside of our SampleViewHolder

Next, we assign the `ImageView imageView` and `TextView textView` variables some values in the
constructor of SampleViewHolder using `findViewById()` on the view coming into the constructor.

```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<>{
	
	// Inner class SampleViewHolder that is public and static. It is also extending RecyclerView.ViewHolder.
	public static class SampleViewHolder extends RecyclerView.ViewHolder {
		public ImageView imageView; 
		public TextView textView;
		
		// Default constructor that takes a view as an argument and passes it to super
		public SampleViewHolder(View itemView) {
			super(itemView);
			
			// find our TextView from the parent view coming in
			textView = (TextView) itemView.findViewById(R.id.list_item_text_view);
			
			// find our ImageView from the parent view coming in
			imageView = (ImageView) itemView.findViewById(R.id.list_item_image_view);
		}
	}
}
```

## Step 4) Declare ViewHolder to the ReycyclerView.Adapter ( 5 min )

Lets include our SampleViewHolder class in the declaration of the CustomRecyclerViewAdapter definition. 

Top line of `CustomRecyclerViewAdapter` will look like this: 
```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder>{
```

<details>
  <summary>Click here to see complete CustomRecyclerViewAdapter class</summary>
```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder>{
    
	// Inner class SampleViewHolder that is public and static. It is also extending RecyclerView.ViewHolder.
	public static class SampleViewHolder extends RecyclerView.ViewHolder {
		public ImageView imageView; 
		public TextView textView;
	
	    	// Default constructor that takes a view as an argument and passes it to super
		public SampleViewHolder(View itemView) {
		    super(itemView);
		    
		    // find our TextView from the parent view coming in
		    textView = (TextView) itemView.findViewById(R.id.list_item_text_view);
		
		    // find our ImageView from the parent view coming in
		    imageView = (ImageView) itemView.findViewById(R.id.list_item_image_view);
		}
	}
}
```
</details>


## Step 5) Implement `RecyclerView.Adapter` methods ( 13 min )

If you hover over the `CustomRecyclerViewAdapter` class declaration with the **red underline**, you'll notice a message telling you to either declare the class `abstract or implement` some methods. 

Let's implement these methods in *step a* and learn about what they do in *step b*.

#### Step 5a)  Implementing methods ( 3 min )

Lets click at the *end* of `SampleViewHolder` inner class and press enter a few times. This will give us some space to work in. 

Now do the following: 
* Press ( command + n ) 
* Select the `Implement methods` option 
* You'll see another popup with three highlighted/selected methods ( if they're not highlited/selected, make sure to highlight them ) 
* Press enter


<details>
  <summary>Click here to see CustomRecyclerViewAdapter class with implemented methods</summary>
```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder>{

	// Inner class SampleViewHolder that is public and static. It is also extending RecyclerView.ViewHolder.
	public static class SampleViewHolder extends RecyclerView.ViewHolder {
		public ImageView imageView; 
		public TextView textView;
	
	    	// Default constructor that takes a view as an argument and passes it to super
		public SampleViewHolder(View itemView) {
		    super(itemView);
		    
		    // find our TextView from the parent view coming in
		    textView = (TextView) itemView.findViewById(R.id.list_item_text_view);
		
		    // find our ImageView from the parent view coming in
		    imageView = (ImageView) itemView.findViewById(R.id.list_item_image_view);
		}
	}

    
	/**
	* Below three methods are auto generated when we implement them
	*/
	
	@Override
	public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return null;
	}
	
	@Override
	public void onBindViewHolder(SampleViewHolder holder, int position) {
	
	}
	
	@Override
	public int getItemCount() {
		return 0;
	}
}
```
</details>


#### Step 5b) What does each method do? ( 10 min )

`onCreateViewHolder()` is the method responsible for creating the ViewHolder. Notice the return type is *SampleViewHolder*. This is where we will have to return an instance of our *SampleViewHolder*.

`onBindViewHolder()` is the method responsible for binding our data to the view holder ( SampeViewHolder in our case ).
This will update the recycled views with contents from the correct piece of data. Note that we have the position variable which will give us access to data from the data list ( i.e. `dataList.get(position)` ).

`getItemCount()` is the method that returns how many data items are in this adapter. By default it returns 0 but we will have to change that.

> Check: Pair up and discuss how many times do you think onCreateViewHolder() will be called? What about onBindViewHolder()?

> Solution: onCreateViewHolder() is called once for each list item. So a screen with 7 list items will call this method 7 times. onBindViewHolder() is called everytime we switch the data inside any of the 7 list items ( scrolling ).

<a name="ind-practice"></a>
## Independent Practice: Implement steps 2 - 5 (20 minutes)

Open the [starter code](create-custom-adapter/starter-code) and fill out all of the TODO's.

You are tasked with completing your custom adapter by finshing 
* step 2
* step 3 
* step 4
* step 5

**Each step to finish is clearly marked inside the starter code** ( which is solution code from last exercise but also includes the TODO's as a guideline )

Your completed assignment will
- Have a completed Custom Adapter class based on steps 2 - 5. Step 1 has been completed for you.

You can check your work against the [solution code](create-custom-adapter/solution-code)

***



## Step 6) Create Data list variable && Constructor for CustomRecyclerViewAdapter class ( 7 min )

We need to create a data list in *step a* and initiliaze it inside our constructor in *step b*

#### Step 6a) Create data list variable ( 2 min )

We need to hold our data in some sort of variable. Lets assume our data comes in an *ArrayList of Strings* called data. We can declare it above the SampleViewHolder class ( at the top of the CustomRecyclerViewAdapter class) like so:

```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder>{
	// data is a list of strings, could be a list of objects.
	private ArrayList<String> data; 

	// Inner class SampleViewHolder that is public and static. It is also extending RecyclerView.ViewHolder.
	public static class SampleViewHolder extends RecyclerView.ViewHolder {
	
	... // Rest of the code
```


<details>
  <summary>Click here to see CustomRecyclerViewAdapter class with data list</summary>
```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder>{
	// data is a list of strings, could be a list of objects.
	private ArrayList<String> data; 

	// Inner class SampleViewHolder that is public and static. It is also extending RecyclerView.ViewHolder.
	public static class SampleViewHolder extends RecyclerView.ViewHolder {
		public ImageView imageView; 
		public TextView textView;
	
	    	// Default constructor that takes a view as an argument and passes it to super
		public SampleViewHolder(View itemView) {
		    super(itemView);
		    
		    // find our TextView from the parent view coming in
		    textView = (TextView) itemView.findViewById(R.id.list_item_text_view);
		
		    // find our ImageView from the parent view coming in
		    imageView = (ImageView) itemView.findViewById(R.id.list_item_image_view);
		}
	}

    
	/**
	* Below three methods are auto generated when we implement them
	*/
	
	@Override
	public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return null;
	}
	
	@Override
	public void onBindViewHolder(SampleViewHolder holder, int position) {
	
	}
	
	@Override
	public int getItemCount() {
		return 0;
	}
}
```
</details>


#### Step 6b) Create Constructor ( 5 min )

We need to create a constructor for our CustomRecyclerViewAdapter. Lets also make sure that this constructor takes in the ArrayList of Strings and initializes data variable we created in step a.

> Instructor Note: Decide if you want to teach setting data via setters or constructor. Benefit of the latter this is that `data` will not be null because of our checks. 

We should place this constructor below the *SampleViewHolder* static class declaration but above the `onCreateViewHolder()` method.

```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder>{
	// data is a list of strings, could be a list of objects.
	private ArrayList<String> data; 
	
	... // SampleViewHolder code ommitted
	
	public CustomRecyclerViewAdapter(ArrayList<String> inComingData) {
		if (inComingData != null){
		        // if there is incoming data, use it
			this.data = inComingData;
		} else {
			// if there is no incoming data, make an empty list to avoid NullPointerExceptions
	    		this.data = new ArrayList<String>();
		}
	}
	
	... // Implemented methods ommitted
```


<details>
  <summary>Click here to see complete CustomRecyclerViewAdapter class with data list and constructor</summary>
```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder>{
	// data is a list of strings, could be a list of objects.
	private ArrayList<String> data; 

	// Inner class SampleViewHolder that is public and static. It is also extending RecyclerView.ViewHolder.
	public static class SampleViewHolder extends RecyclerView.ViewHolder {
		public ImageView imageView; 
		public TextView textView;
	
	    	// Default constructor that takes a view as an argument and passes it to super
		public SampleViewHolder(View itemView) {
		    super(itemView);
		    
		    // find our TextView from the parent view coming in
		    textView = (TextView) itemView.findViewById(R.id.list_item_text_view);
		
		    // find our ImageView from the parent view coming in
		    imageView = (ImageView) itemView.findViewById(R.id.list_item_image_view);
		}
	}
	
	// Constructor for our custom adapter. It takes an ArrayList of data as an argument.
	public CustomRecyclerViewAdapter(ArrayList<String> inComingData) {
		if (inComingData != null){
			// if there is incoming data, use it
			this.data = inComingData;
		} else {
			// if there is no incoming data, make an empty list to avoid NullPointerExceptions
	    		this.data = new ArrayList<String>();
		}
	}

    
	/**
	* Below three methods are auto generated when we implement them
	*/
	
	@Override
	public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return null;
	}
	
	@Override
	public void onBindViewHolder(SampleViewHolder holder, int position) {
	
	}
	
	@Override
	public int getItemCount() {
		return 0;
	}
}
```
</details>


## Step 7) Add code to 3 implemented methods from Step 5 ( 22 min )

Lets work on filling out the `onCreateViewHolder()`, `onBindViewHolder()`, `getItemCount()` methods in *steps ( a, b, and c )* respectively.

#### Step 7a) `onCreateViewHolder()` ( 10 min )

`onCreateViewHolder()` is the method where we inflate our list item xml layout and store necessary fields in the ViewHolder. Finally, we return the ViewHolder.

```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder>{
	
	... // SampleViewHolder and Constructor code omitted 

	@Override
	public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// Get context from parent ViewGroup
		Context context = parent.getContext();
		
		// Get layoutInflater, which will inflate our custom list item layout for us
		LayoutInflater inflater = LayoutInflater.from(context);
		
		/**
		* Inflate the custom list item layout. The view returned back is our top level
		* view. If you look at step 1, you'll see our top level layout  for our list 
		* item is LinearLayout.
		*
		* We pass this LinearLayout view to our SampleViewHolder so we can find our
		* ImageView and TextView via findViewById() 
		*/
		View listItemLayout = inflater.inflate(R.layout.rv_list_item, parent, false);
		
		// Return a new SampleViewHolder instance
		SampleViewHolder viewHolder = new SampleViewHolder(listItemLayout);
		return viewHolder;
	}
	
	... // Rest of the code omitted
}
```

> Check: Pair up and discuss what is the View listItemLayout?

> Solution: This is the top list item layout view, in our case its the LinearLayout but we don't cast it and keep it as a View.

#### Step 7b) `onBindViewHolder()` ( 10 min )

`onBindViewHolder()` will bind our SampleViewHolder to the CustomRecyclerViewAdapter, and thus bind our data to our recycled views.

```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder>{
	
	... // SampleViewHolder and Constructor code omitted 

	@Override
	public void onBindViewHolder(SampleViewHolder holder, int position) {
		// Get our data item for the current position from the data list
		String dataItem = data.get(position);
		
		/**
		* Pull out the inflated TextView/ImageView references out of our SampleViewHolder
		* instance.
		*
		* Look at the constructor of SampleViewHolder() and note that variable fields
		* 'imageView' and 'textView' are both public ( which is why we don't need a 
		* getter ).
		*/
		TextView textView = holder.textView;
		ImageView imageView = holder.imageView;
		
		// put our dataItem string as text into the text view
		textView.setText(dataItem);
		
		// set the launcher icon as our image resource
		imageView.setImageResource(R.mipmap.ic_launcher);
	}
	
	... // Rest of the code omitted
}
```

> Check: Take 20 seconds to decide what is another way of setting text and image on the TextView and ImageView?

> Solution: holder.textView.setText(dataItem) and holder.imageView.setImageResource(R.mipmap.ic_launcher)

#### Step 7c) `getItemCount()` ( 2 min )

`getItemCount()` this one is easy. We can just return the size of our data list!

```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder>{
	
	... // SampleViewHolder and Constructor code omitted 

	@Override
	public int getItemCount() {
		return data.size();
	}
	
	... // Rest of the code omitted
}
```

#### Completion!

<details>
  <summary>Click here to see complete CustomRecyclerViewAdapter with implemented methods</summary>
```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder>{
	// data is a list of strings, could be a list of objects.
	private ArrayList<String> data; 

	// Inner class SampleViewHolder that is public and static. It is also extending RecyclerView.ViewHolder.
	public static class SampleViewHolder extends RecyclerView.ViewHolder {
		public ImageView imageView; 
		public TextView textView;
	
	    	// Default constructor that takes a view as an argument and passes it to super
		public SampleViewHolder(View itemView) {
		    super(itemView);
		    
		    // find our TextView from the parent view coming in
		    textView = (TextView) itemView.findViewById(R.id.list_item_text_view);
		
		    // find our ImageView from the parent view coming in
		    imageView = (ImageView) itemView.findViewById(R.id.list_item_image_view);
		}
	}
	
	// Constructor for our custom adapter. It takes an ArrayList of data as an argument.
	public CustomRecyclerViewAdapter(ArrayList<String> inComingData) {
		if (inComingData != null){
			// if there is incoming data, use it
			this.data = inComingData;
		} else {
			// if there is no incoming data, make an empty list to avoid NullPointerExceptions
	    		this.data = new ArrayList<String>();
		}
	}

	@Override
	public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// Get context from parent ViewGroup
		Context context = parent.getContext();
		
		// Get layoutInflater, which will inflate our custom list item layout for us
		LayoutInflater inflater = LayoutInflater.from(context);
		
		/**
		* Inflate the custom list item layout. The view returned back is our top level
		* view. If you look at step 1, you'll see our top level layout  for our list 
		* item is LinearLayout.
		*
		* We pass this LinearLayout view to our SampleViewHolder so we can find our
		* ImageView and TextView via findViewById() 
		*/
		View listItemLayout = inflater.inflate(R.layout.rv_list_item, parent, false);
		
		// Return a new SampleViewHolder instance
		SampleViewHolder viewHolder = new SampleViewHolder(listItemLayout);
		return viewHolder;
	}
	
	@Override
	public void onBindViewHolder(SampleViewHolder holder, int position) {
		// Get our data item for the current position from the data list
		String dataItem = data.get(position);
		
		/**
		* Pull out the inflated TextView/ImageView references out of our SampleViewHolder
		* instance.
		*
		* Look at the constructor of SampleViewHolder() and note that variable fields
		* 'imageView' and 'textView' are both public ( which is why we don't need a 
		* getter ).
		*/
		TextView textView = holder.textView;
		ImageView imageView = holder.imageView;
		
		// put our dataItem string as text into the text view
		textView.setText(dataItem);
		
		// set the launcher icon as our image resource
		imageView.setImageResource(R.mipmap.ic_launcher);
	}
	
	@Override
	public int getItemCount() {
		return data.size();
	}
}
```
</details>

## Step 8) Handling whole OnItemClicks ( 32 min )

#### Step 8a) Define an OnRecyclerViewItemClickListener ( 5 min )

We need to define an interface that will allow us to process clicks outside of the adapter.
The interface will be defined in the adapter.

> Check: Why might we want to process a click outside the adapter? 

> Solution: If your item click needs to start another activity or do anything complex. The adapter should be as decoupled as posible from specific behaviours. Having an interface allows us to re-use this adapter with different components that have different use cases. ( i.e. In  MainActivity our click might launch another activty, while in DetailActivity the click might swap a fragment. Assuming both Activities use the same RecyclerViewAdapter )

```java 
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder>{
	// data is a list of strings, could be a list of objects.
	private ArrayList<String> data;
	
	/**
	 * Interface that will pass along the item position of the list item
	 * that was clicked!
	 *
	 * Note: You could also pass along any vies you might want to manipulate. 
	 * i.e. Pass an imageView back and we can update the image or background, etc.
	 */
	public interface OnRecyclerViewItemClickListener {
	    void onItemClick(int position);
	}
	
	... // SampleViewHolder class, Constructor, and Implemented methods are omitted
	
}
```

#### Step 8b) Create instance of OnRecyclerViewItemClickListener ( 2 min )

We need to create a private static instance variable of the OnRecyclerViewItemClickListener inside our CustomRecyclerViewAdapter.

> Check: Why must the instance be static?

> Solution: We will use the interface inside the SampleViewHolder, which is static. Therefore, any variable used inside the ViewHolder must also be static.

```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder>{
	// data is a list of strings, could be a list of objects.
	private ArrayList<String> data;
	
	// Private static variable to hold an instance of OnRecyclerViewItemClickListener interface 
	private static OnRecyclerViewItemClickListener onItemClickListener;
	
	/**
	 * Interface that will pass along the item position of the list item
	 * that was clicked!
	 *
	 * Note: You could also pass along any vies you might want to manipulate. 
	 * i.e. Pass an imageView back and we can update the image or background, etc.
	 */
	public interface OnRecyclerViewItemClickListener {
	    void onItemClick(int position);
	}
	
	... // SampleViewHolder class, Constructor, and Implemented methods are omitted
	
}
```

#### Step 8c) Take an implementation of OnRecyclerViewItemClickListener interface in CustomRecyclerViewAdapter constructor ( 5 min )

We should enforce that any user of CustomRecyclerViewAdapter will provide us with an implementation of OnRecyclerViewItemClickListener by making it an argument inside of our CustomRecyclerViewAdapter's constructor.

Don't forget to set the incoming click listener to our private static variable.
```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder>{
	
	... // Variable, Interface definition, and SampleViewHolder code is omitted
	
	// Updated constructor for our custom adapter. It takes an ArrayList of data and OnRecyclerViewItemClickListener as arguments.
	public CustomRecyclerViewAdapter(ArrayList<String> inComingData,  OnRecyclerViewItemClickListener listener) {
		// set our OnRecyclerViewItemClickListener instance to the incoming listener
		this.onItemClickListener = listener;
		
		if (inComingData != null){
			// if there is incoming data, use it
			this.data = inComingData;
		} else {
			// if there is no incoming data, make an empty list to avoid NullPointerExceptions
	    		this.data = new ArrayList<String>();
		}
	}
	
	... // Rest of the code omitted
}
```

#### Step 8d) Pass item layout click events to interface ( 10 min )

Now, we forward all item click events ( we detect them inside the SampleViewHolder ) back up to the implementor of OnRecyclerViewItemClickListener using the `onItemClick(position)` method

```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder>{

	... // Variables and Interface definition code omitted	
		
	// Inner class SampleViewHolder that is public and static. It is also extending RecyclerView.ViewHolder.
	public static class SampleViewHolder extends RecyclerView.ViewHolder {
		public ImageView imageView; 
		public TextView textView;
	
	    	// Default constructor that takes a view as an argument and passes it to super
		public SampleViewHolder(View itemView) {
			super(itemView);
			
			// find our TextView from the parent view coming in
			textView = (TextView) itemView.findViewById(R.id.list_item_text_view);
			
			// find our ImageView from the parent view coming in
			imageView = (ImageView) itemView.findViewById(R.id.list_item_image_view);
		    
		    
    			// We set a click listener on the whole custom item layout ( i.e. itemView )
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
				    	/**
				    	 * Whenever the custom item layout is clicked, we pass the layout and position
				    	 * to whoever implemented the OnRecyclerViewItemClickListener ( i.e our Activity )
				    	 *
				    	 * Note: getLayoutPosition() returns the list item position in the RecyclerView
				    	 */
					onItemClickListener.onItemClick(getLayoutPosition());
				}
			});
		}
	}
		
		
	... // Rest of the code is omitted
	
}
```

<details>
  <summary>Click here to see complete CustomRecyclerViewAdapter with implemented item click</summary>
```java
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder>{
	// data is a list of strings, could be a list of objects.
	private ArrayList<String> data; 
	
	// Private static variable to hold an instance of OnRecyclerViewItemClickListener interface 
	private static OnRecyclerViewItemClickListener onItemClickListener;
	
	/**
	 * Interface that will pass along the item position of the list item
	 * that was clicked!
	 *
	 * Note: You could also pass along any vies you might want to manipulate. 
	 * i.e. Pass an imageView back and we can update the image or background, etc.
	 */
	public interface OnRecyclerViewItemClickListener {
	    void onItemClick(int position);
	}

	// Inner class SampleViewHolder that is public and static. It is also extending RecyclerView.ViewHolder.
	public static class SampleViewHolder extends RecyclerView.ViewHolder {
		public ImageView imageView; 
		public TextView textView;
	
	    	// Default constructor that takes a view as an argument and passes it to super
		public SampleViewHolder(View itemView) {
		    	super(itemView);
		    
		    	// find our TextView from the parent view coming in
		    	textView = (TextView) itemView.findViewById(R.id.list_item_text_view);
		
		    	// find our ImageView from the parent view coming in
		    	imageView = (ImageView) itemView.findViewById(R.id.list_item_image_view);
		    
		    	// We set a click listener on the whole custom item layout ( i.e. itemView )
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
				    	/**
				    	 * Whenever the custom item layout is clicked, we pass the layout and position
				    	 * to whoever implemented the OnRecyclerViewItemClickListener ( i.e our Activity )
				    	 *
				    	 * Note: getLayoutPosition() returns the list item position in the RecyclerView
				    	 */
					onItemClickListener.onItemClick(getLayoutPosition());
				}
			});
		}
	}
	
	// Updated constructor for our custom adapter. It takes an ArrayList of data and OnRecyclerViewItemClickListener as arguments.
	public CustomRecyclerViewAdapter(ArrayList<String> inComingData,  OnRecyclerViewItemClickListener listener) {
		// set our OnRecyclerViewItemClickListener instance to the incoming listener
		this.onItemClickListener = listener;
		
		if (inComingData != null){
			// if there is incoming data, use it
			this.data = inComingData;
		} else {
			// if there is no incoming data, make an empty list to avoid NullPointerExceptions
	    		this.data = new ArrayList<String>();
		}
	}
	
	
	@Override
	public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// Get context from parent ViewGroup
		Context context = parent.getContext();
		
		// Get layoutInflater, which will inflate our custom list item layout for us
		LayoutInflater inflater = LayoutInflater.from(context);
		
		/**
		* Inflate the custom list item layout. The view returned back is our top level
		* view. If you look at step 1, you'll see our top level layout  for our list 
		* item is LinearLayout.
		*
		* We pass this LinearLayout view to our SampleViewHolder so we can find our
		* ImageView and TextView via findViewById() 
		*/
		View listItemLayout = inflater.inflate(R.layout.rv_list_item, parent, false);
		
		// Return a new SampleViewHolder instance
		SampleViewHolder viewHolder = new SampleViewHolder(listItemLayout);
		return viewHolder;
	}
	
	@Override
	public void onBindViewHolder(SampleViewHolder holder, int position) {
		// Get our data item for the current position from the data list
		String dataItem = data.get(position);
		
		/**
		* Pull out the inflated TextView/ImageView references out of our SampleViewHolder
		* instance.
		*
		* Look at the constructor of SampleViewHolder() and note that variable fields
		* 'imageView' and 'textView' are both public ( which is why we don't need a 
		* getter ).
		*/
		TextView textView = holder.textView;
		ImageView imageView = holder.imageView;
		
		// put our dataItem string as text into the text view
		textView.setText(dataItem);
		
		// set the launcher icon as our image resource
		imageView.setImageResource(R.mipmap.ic_launcher);
	}
	
	@Override
	public int getItemCount() {
		return data.size();
	}
}
```
</details>


#### Step 8e) Implement OnRecyclerViewItemClick Listener! ( 10 min )

Final step is to implement the OnRecyclerViewItemClick inside our component ( i.e. Activity or Fragment !.

Then we pass `this` into the **updated** `CustomRecyclerViewAdapter` constructor.

```java
public class MainActivity extends Activity implements CustomRecyclerViewAdapter.OnRecyclerViewItemClick {

	... // Omitted code inside MainActivity
	
	@Override
	public void onItemClick(int position) {
		/**
		 * We have the position of which item was clicked, now we can do whatever we want next.
		 *
		 * In this case, we Toast the item at the position from original dataList along with its position
		 */
		Toast.makeText(MainActivity.this, "Clicked on " + dataList.get(position) + " at position " + position, Toast.LENGTH_SHORT).show();
	}
	
	
	@Override
    	protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	
	        ... // omitted code
	
		/**
		 * Passing in `this` implementation of CustomRecyclerViewAdapter.OnRecyclerViewItemClick to our custom
		 * adapter
		 */
	        rvAdapter = new CustomAdapter(dataList, this);
	        recyclerView.setAdapter(rvAdapter);
    	}
}
```

***

<a name="ind-practice"></a>
## Independent Practice: Implement steps 6 - 8 (20 minutes)

Open the [starter code](implement-methods-and-click-listener/starter-code) and fill out all of the TODO's.

You are tasked with completing your custom adapter by finshing 
* step 6
* step 7 
* step 8 

**Each step to finish is clearly marked inside the starter code** ( which is solution code from last exercise but also includes the TODO's as a guideline )

Your completed assignment will
- Create data list and constructor as seen in step 6
- implement the 3 methods as seen in step 7 
- make the list item clickable via an interface described in step 8.

You can check your work against the [solution code](implement-methods-and-click-listener/solution-code)

***

<a name="conclusion"></a>
## Conclusion (5 mins)



### ADDITIONAL RESOURCES
- [Extensive guide to creating RecyclerView](https://guides.codepath.com/android/using-the-recyclerview#layouts)
- [Why Recycler View does not have OnItemClickListener](http://stackoverflow.com/questions/24885223/why-doesnt-recyclerview-have-onitemclicklistener-and-how-recyclerview-is-dif/24933117#24933117)
- [Nice way to handle item clicks](http://www.littlerobots.nl/blog/Handle-Android-RecyclerView-Clicks/)
- [Static vs Non Static View Holder](http://stackoverflow.com/questions/31302341/what-difference-between-static-and-non-static-viewholder-in-recyclerview-adapter)
- [Leak Safe Annonomous Inner Classes](http://stackoverflow.com/questions/10864853/when-exactly-is-it-leak-safe-to-use-anonymous-inner-classes)
- [Google guide to creating RecyclerView](https://developer.android.com/training/material/lists-cards.html)
- [RecyclerView Class Documentation](https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html)
- [ViewHolder Pattern](https://developer.android.com/training/improving-layouts/smooth-scrolling.html#ViewHolder)
- [findViewById() is expensive](http://stackoverflow.com/questions/14192709/is-it-possible-to-embed-youtube-vimeo-videos-in-markdown-using-a-c-sharp-markdow)
- [Guide to RecyclerView Animations](http://frogermcs.github.io/recyclerview-animations-androiddevsummit-write-up/)

