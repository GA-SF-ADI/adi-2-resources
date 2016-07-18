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

## Mapping JSON to Java Objects (20 mins)

> Check: Pair up and discuss what this JSON object reminds you of. ( 1 min )

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

> Check: Split into groups and discuss what is the type for each of the fields! For example, "available" is a boolean! ( 4 min )


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


<a name="ind-practice"></a>
## Independent Practice: JSON to Java object (10 mins)

[This](https://developer.spotify.com/web-api/get-audio-features/) Spotify API returns to us the following JSON object modeling audio features for a class
```json
{
	"danceability": 0.735,
	"energy": 0.578,
	"key": 5,
	"loudness": -11.84,
	"mode": 0,
	"speechiness": 0.0461,
	"acousticness": 0.514,
	"instrumentalness": 0.0902,
	"liveness": 0.159,
	"valence": 0.624,
	"tempo": 98.002,
	"type": "audio_features",
	"id": "06AKEBrKUckW0KREUWRnvT",
	"uri": "spotify:track:06AKEBrKUckW0KREUWRnvT",
	"track_href": "https://api.spotify.com/v1/tracks/06AKEBrKUckW0KREUWRnvT",
	"analysis_url": "http://echonest-analysis.s3.amazonaws.com/TR/xZIVRgimIx9_iJFqTriVhCm_4unjh7tZAglpO5D-xS4xNkvxq70uCFAtuoVYTaIeHbWoLKvCB6W-kvd9E=/3/full.json?AWSAccessKeyId=AKIAJRDFEY23UEVW42BQ&Expires=1455893394&Signature=rmceqCXLMbPrXt9RTIJwk%2BQzxoY%3D",
	"duration_ms": 255349,
	"time_signature": 4
}
```

You need to create a Java object to match this JSON object just like we did above.
- Start by deciding what type is each field
- Then create the class, you can call it `AudioFeatures.java`

<details>
  <summary>Click here to see solutions</summary>
```java
public class AudioFeatures {
    private double danceability;
    private double energy;
    private double loudness;
    private double speechiness;
    private double acousticness;
    private double instrumentalness;
    private double liveness;
    private double valence;
    private double tempo;

    private String type;
    private String id;
    private String uri;
    
    @SerializedName("track_href")
    private String trackUrl;
    @SerializedName("analysis_url")
    private String analysisUrl;
    
    private int key;
    private int mode;
    private int time_signature;
    private long duration_ms;
    
    // Getters and Setters


    public double getDanceability() {
        return danceability;
    }

    public void setDanceability(double danceability) {
        this.danceability = danceability;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getLoudness() {
        return loudness;
    }

    public void setLoudness(double loudness) {
        this.loudness = loudness;
    }

    public double getSpeechiness() {
        return speechiness;
    }

    public void setSpeechiness(double speechiness) {
        this.speechiness = speechiness;
    }

    public double getAcousticness() {
        return acousticness;
    }

    public void setAcousticness(double acousticness) {
        this.acousticness = acousticness;
    }

    public double getInstrumentalness() {
        return instrumentalness;
    }

    public void setInstrumentalness(double instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public double getLiveness() {
        return liveness;
    }

    public void setLiveness(double liveness) {
        this.liveness = liveness;
    }

    public double getValence() {
        return valence;
    }

    public void setValence(double valence) {
        this.valence = valence;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getTrackUrl() {
        return trackUrl;
    }

    public void setTrackUrl(String trackUrl) {
        this.trackUrl = trackUrl;
    }

    public String getAnalysisUrl() {
        return analysisUrl;
    }

    public void setAnalysisUrl(String analysisUrl) {
        this.analysisUrl = analysisUrl;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getTime_signature() {
        return time_signature;
    }

    public void setTime_signature(int time_signature) {
        this.time_signature = time_signature;
    }

    public long getDuration_ms() {
        return duration_ms;
    }

    public void setDuration_ms(long duration_ms) {
        this.duration_ms = duration_ms;
    }
}
```
</details>


## Nested JSON objects to Nested Java objects ( 10 mins)

Given the following JSON 
```json
{
	"book-one": {
		"title": "Enders Game"
	},
	"book-two": {
		"title": "The Martian"
	}
}
```

We see that we have objects `book_one` and `book_two` ( who have a variable `title`). Both of these are encapsulated by the whole json object. 

The outer object could represent a Bookshelf that has these two books. Lets model this JSON bookshelf as a Java object.

First, we need to model the **inner** JSON object, meaning the book object itself.
```java
public class Book {
	private String title;
	
	... // Rest of code omitted
}
```

This Book class represents **any** book object. It can work for book-one or book-two because both of those just have the `String title` field.

Now, lets make use of the Book class in our BookShelf class ( outer JSON object that holds both books )
```java
public class BookShelf {
	@SerializedName("book-one")
	private Book book1 // notice we use a different variable name and use @SerializedName()
	
	@SerializedName("book-two")
	private Book book2 // notice we use a different variable name and use @SerializedName()
	
	... // Rest of code omitted
}
```

You can model nested objects as deep as they go. Meaning that if BookShelf has Book objects but those Book objects could have Chapter objects which could also hold Page objects, etc. 


## JSON Arrays to Java Arrays

Lets take a look at how we can model JSON arrays inside of Java objects.

Given the following JSON object:
```json
{
	"employees": [
		{
			"firstName": "John",
			"lastName": "Doe"
		},
		{
			"firstName": "Anna",
			"lastName": "Smith"
		},
		{
			"firstName": "Peter",
			"lastName": "Jones"
		}
	]
}
```

Remember its easiest to work from **inside-out** when modeling JSON to Java.

We can see we have *3* employee objects that have a `firstName` and a `lastName`.

Lets create an `Employee.java` class
```java
public class Employee {
	private String firstName;
	private String lastName;
	
	... // Rest of code omitted
}
```

Next, we see we have an **array of employeess** which is called `"employees"`. This array of employees lives inside the whole JSON object which probably represents a company.

Lets create a `Company.java` class:
```java
public class Company {
	Employee[] employees;
	
	... // Rest of code omitted
}
```

Do you see how the JSON `"employees"` array is also an array of employee objects inside of Java? The variable name stays the same, ie `employees` but the `Employee[]` is created by us because each `Employee.java` object models one of the three employees.

<a name="ind-practice"></a>
## Independent Practice: Model JSON Arrays and Nested Objects to Java (20 mins)

Create proper Java classes to model this JSON object:
```json
{
	"bookshelfs": [
		{
			"books": [
				{
					"title": "Ender's Game",
					"author": "Orson Scott Card",
					"cover": {
						"color": "red",
						"material": "leather"
					}
				},
				{
					"title": "The Martian",
					"author": "Andy Weir",
					"cover": {
						"color": "blue",
						"material": "plastic"
					}
				},
				{
					"title": "A Song of Ice and Fire",
					"author": "George RR Martin",
					"cover": {
						"color": "green",
						"material": "paper"
					}
				}
			]
		},
		{
			"books": [
				{
					"title": "Harry Potter and the Chamber of Secrets",
					"author": "JK Rowling",
					"cover": {
						"color": "black",
						"material": "leather"
					}
				},
				{
					"title": "I, Robot",
					"author": "Isaac Asimov",
					"cover": {
						"color": "white",
						"material": "metal"
					}
				}
			]
		}
	]
}
```

Remember you should
- Start working our way from **inside-out** by creating models for simples case and then work your way up





If you get stuck, here are some hints:
- Create a model for BookCover.java
- Create a model for Book.java which has a BookCover object
- Create a model for Bookshelf.java that holds an array of Books
- Create a model for Libarary that holds an array of Bookselves 

<details>
  <summary>Click here to see solution for BookCover.java</summary>
```java
public class BookCover {
    private String color;
    private String material;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
```
</details>

<details>
  <summary>Click here to see solution for Book.java</summary>
```java
public class Book {
    private String title;
    private String author;
    private BookCover cover;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookCover getCover() {
        return cover;
    }

    public void setCover(BookCover cover) {
        this.cover = cover;
    }
}
```
</details>

<details>
  <summary>Click here to see solution for BookShelf.java</summary>
```java
public class Bookshelf {
    Book[] books;

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
}
```
</details>

<details>
  <summary>Click here to see solution for Library.java</summary>
```java
public class Library {
    Bookshelf[] bookshelfs;

    public Bookshelf[] getBookshelfs() {
        return bookshelfs;
    }

    public void setBookshelfs(Bookshelf[] bookshelfs) {
        this.bookshelfs = bookshelfs;
    }
}
```
</details>

You can also look at the [solution code](solution-code/ArraysAndNestedJSON/). It holds the above classes inside a package called **models**. The app does nothing but display hello world.

<a name="demo"></a>
## Demo: Using GSON (15 mins)

The first step is to add GSON to your app gradle file:

```
compile 'com.google.code.gson:gson:2.6'
```

Next, we will create a Java objects to represent our search result, and the items in the search result.



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


***

<a name="conclusion"></a>
## Conclusion (5 mins)

GSON is an extremely helpful tool for more complicated JSON data, but it can be overkill for simple tasks. Being able to easily convert between JSON and Java is a nice feature to have, and can make data transfer code much cleaner.

***

### ADDITIONAL RESOURCES
- [GSON](https://github.com/google/gson)
- [JSON code beautify view](http://codebeautify.org/jsonviewer)
