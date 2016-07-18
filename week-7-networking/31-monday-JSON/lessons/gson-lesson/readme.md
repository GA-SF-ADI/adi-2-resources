---
title: GSON
duration: "1:30"
creator:
    name: Aleksandr Tomak
    city: SF
---
# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) GSON

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Describe what GSON is used for
- Incorporate GSON into your app
- Serialize JSON objects using GSON
- Deserialize JSON objects using GSON

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Understand JSON

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Run the solution code and look at the source code to make sure you agree with its implementation

---
<a name="opening"></a>
## Opening (5 mins)

> Check: What is JSON?

JSON (JavaScript Object Notation) is a lightweight data-interchange format. It is easy for humans to read and write. It is easy for machines to parse and generate. It is based on a subset of the JavaScript Programming Language

JSON is Its a string representation of complex data models. This isn't necessarily the best way of working with data inside of an Android Application. 

> Check: Group up and discuss ways we can incorporate JSON into our Apps. ( Hint: think about classes )

Today, we are going to learn about a library called `GSON`, which will go hand-in-hand with JSON.

***

<a name="introduction"></a>
## Introduction: What is GSON? (5 mins)

When we look at a JSON object, it is relatively simple to see how we could translate it into a Java object. The key-value pairs in JSON can directly correspond to member variables in a Java object. With the simple addition of assigning strict types in Java ( String, int, boolean, etc ), there really isn't much of a difference. 

Since Java is all about working with objects, the GSON library handily does two things:
- Converts **JSON objects to Java objects** with the method `fromJson()`
- Converts **Java objects to JSON** with the method `toJson()`

As you will see in the upcoming demo, this is a rather simple process, but makes working with more complicated data much easier.

***

<a name="demo"></a>
## Demo: Mapping JSON to Java Objects (15 mins)

> Check: Pair up and discuss what this JSON object reminds you of.

```json
{
	"name": "Sample Product",
	"model": "XYZ",
	"price": "19.99",
	"available": "true",
	"image-url": "http://example.com/image",
	"color": "green",
	"inventory" : "10"
}
```
> Solution: Its a model for a sample product item from project 2. Each of the variables would represent a column in your PRODUCT_TABLE.

> Check: Split into groups and discuss what is the type for each of the fields! For example, "available" is a boolean!


Look at the JSON object itself because we, as humans, can see that 
* `"name": "Sample Product"` has a String value 
* `"model": "XYZ"` has a String value 
* `"image-url": "http://example.com/image"` has a String value 
* `"color": "green"` has a String value 
* `"price": "19.99"` has a double value 
* `"inventory" : "10"` has an int value 
* `"available": "true"` has a boolean value 

Knowing this lets try and create a Java object from the JSON object. Lets call our class `Product.java` because the JSON object is modeling a product.

```java
public class Product {
	private String name;
	private String model;
	private String image-url;
	private String color;
	
	private double price;
	private int inventory;
	private boolean available;
	
	... // Constructor and Getters/Setters are omitted
	
}
```

Notice that the variable name inside `Product.java` matches the key from JSON key-value pair. 

For example, key-value pair: `"name": "Sample Product"` would map to our `private String name`. The variable `name` will hold the String value of "Sample Product" inside `Product.java` class.


Sometimes, the JSON objects have bad key names from the key-value pair. For example
```json
{
	"bad_name": "Sample Product",
	"model_that_is_very_long": "XYZ",
	"price": "19.99",
	"available": "true",
	"image-url": "http://example.com/image",
	"color": "green"
}
```

`"bad_name"` cannot translate to variable names in Java because Java does not allow "_" in variable names.
`"model_that_is_very_long"` is extremely long and maybe we want a shorter name inside our Java class.

The solution is to use the `@@SerializedName()` annotation.

```java 
public class Product {
	@SerializedName("bad_name")
	private String name;
	
	@SerializedName("model_that_is_very_long")
	private String model;
	
	private String image-url;
	private String color;
	
	private double price;
	private int inventory;
	private boolean available;
	
	... // Constructor and Getters/Setters are omitted
	
}
```

Basically, this will convert the JSON value at the key `"bad_name"` and use our `name` variable in Product class. For `"model_that_is_very_long"`, we would use the `model` variable and it will hold the data.

<a name="demo"></a>
## Demo: Using GSON (15 mins)


We're going to be using the Walmart API for our example in this exercise. Open the starter-code, and replace the API key with yours in the URL variable.

The first step is to add GSON to your gradle:

```
compile 'com.google.code.gson:gson:2.6'
```

Next, we will create a Java objects to represent our search result, and the items in the search result.

```java
public class WalmartItem {
    private String name;
    private String shortDescription;

    public String getName(){return name;}

    public String getShortDescription(){return shortDescription;}

    public void setName(String name){this.name = name;}

    public void setShortDescription(String description){this.shortDescription = description;}

    @Override
    public String toString() {
        return name;
    }
}
```

```java
public class WalmartSearchResult {
    private WalmartItem[] items;

    public void setItems(WalmartItem[] items){this.items = items;}

    public WalmartItem[] getItems(){return items;}

    @Override
    public String toString() {
        return items.length+" item(s) in the search result";
    }
}
```

The last step is simply to call `fromJson`:

```java
Gson gson = new Gson();
WalmartSearchResult result = gson.fromJson(data, WalmartSearchResult.class);
```

From here we can easily do whatever we want with the search results, such as printing out the name of the item.

We can also easily convert objects back to JSON:

```java
String json = gson.toJson(result);
```

***

<a name="ind-practice"></a>
## Independent Practice: Topic (20 mins)

Now it's time to practice. In pairs, add an EditText, a Button, and a ListView so you can search for an item using the Walmart API, and display the names of the items in your ListView.


***

<a name="conclusion"></a>
## Conclusion (5 mins)

GSON is an extremely helpful tool for more complicated JSON data, but it can be overkill for simple tasks. Being able to easily convert between JSON and Java is a nice feature to have, and can make data transfer code much cleaner.

***

### ADDITIONAL RESOURCES
- [GSON](https://github.com/google/gson)
