---
title: Storing Data in Collections
duration: "1:30"
creator:
    name: Kristen Tonga
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Storing Data in Collections

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Create and manipulate arrays and ArrayLists
- Work with for loops to iterate over collections


### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Work with basic data types and assign variables
- Create basic functions
- Create a basic app, and change TextView, based on a button click

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Gather materials needed for class
- Complete prep work required
- Prepare any specific instructions

---
<a name="opening"></a>

## Opening (5 mins)

So far, we have stored all of the information for our apps in individual variables. That works for a small amount of information, but what if we had to manage larger sets of data? For instance, what if we had credit card transactions in a customer's banking app. Would we want to store every transaction in its own variable, or have a single variable that would hold all of the transactions at once?


<a name="introduction"></a>
## Introduction: Basic Arrays (5 mins)

An array is a container object that holds a **fixed** number of values of **a single type**. You've already seen an example in the `main` method.


Each item in an array is called an *element*, and each element can be accessed by it's *index*. The index of elements starts at 0. That means visually that:

  INDEX  | 0 | 1 | 2 | 3 | 4
  -------|---|---|---|---|---
| ELEMENT| x | x | x | x | x |
  -------|---|---|---|---|---


## Demo: Creating Arrays (5 mins)

Let's create an Array together:


```java
  class ArrayDemo {
    public static void main(String[] args) {
      //declares an array of integers
      int[] anArray; // note datatype, followed by [] indicating array

      //allocates memory for 10 integers
      anArray = new int[10];

      //assign elements
      anArray[0] = 111;
      anArray[1] = 222; //etc.

      //access elements
      System.out.println("Element at index 0: "+ anArray[0]);
      System.out.println("Element at index 1: "+ anArray[1]); //etc.
      System.out.println("The array has a size of "+anArray.length);
    }
  }
```


## Independent Practice: Creating Arrays (10 mins)

**Now you:** Create a String array of *three* of your favorite things. Print the result to the command line.



## Demo: Manipulating Arrays (15 mins)

Now that we know what the computer will be doing, let's use the shortened syntax. Arrays can also be created and initialized with one statement. The length of the array is automatically determined by the number of elements between the curly braces.

```java
  class FavoriteThings {
    public static void main(String[] args) {
      // shortened syntax. assign variable, allocate memory, and initialize values all in one
      String[] favoriteThings = {
        "raindrops",
        "roses",
        "whiskers on kittens"
      } // length will be inferred as: 3
    }
  }
```

#### Manipulating Basic Arrays

Let's take a look at some basic things you can do with an array.

Note that indexing (getting/setting the item based on its position in the array) and determining the length of the array have built-in syntax, while some less fundamental operations are performed by using methods on the `Arrays` object. This is similar to the way you can add two numbers together by just writing `a + b` but need to use methods on the `Math` object to do more esoteric things like rounding.

```java
  class ArrayManipulationDemo {
    // initialize array
        int[] primeNumbers = {5,3,11,7,2}; //next 13, 17, 19, 23

      // get the thing at a specified index
        int firstPrime = primeNumbers[0];
        System.out.println( "index 0: " + firstPrime );

      // print it
        System.out.println( Arrays.toString(primeNumbers) );

      // sort it
        Arrays.sort( primeNumbers );
        System.out.println( Arrays.toString(primeNumbers) );

      // get its length
        System.out.println(primeNumbers.length); // it's a constant, not a method -- we'll talk about this later

      // see if value is found in array. Returns -1 if not found.
      // Note: binarySearch() only works if the array is sorted.
        int indexOf11 = Arrays.binarySearch( primeNumbers, 11 );
        System.out.println( "index of 11: " + indexOf11 );

      // CHECK: How to get the value?
        // if(indexOf11 >= 0) {
            System.out.println("looking for 11, found value: " + primeNumbers[indexOf11]);
        // }
  }
```

#### Error Checking
Now what if we searched for an value that was not in the array? Let's see if 10 is a prime number.


```java
  int[] primeNumbers = {5,3,11,7,2};

  int indexOf10 = Arrays.binarySearch( primeNumbers, 10 );
  System.out.println( "index of 10: " + indexOf11 );
  // if(indexOf11 >= 0) {
      System.out.println("looking for 10, found value: " + primeNumbers[indexOf11]);
  // }
```

An Exception is thrown when the computer is asked to do something it can't do, like accessing index -1 or 4 in a 4-element array. Exceptions bubble up, and unless caught (which we will talk about in a later lesson) cause the program to quit.

It is important to consider when the results of our actions might throw an exception, and add checks as needed.


## Demo: Problems with Arrays (10 min)

But what if I decide that actually, I want this list to include 4 things instead of 3? For example, let's go back to our favoriteList; I decide I really like chocolate and want it to be the fourth favorite thing.

Follow along, if you want:

```java
  public static void addFourthFav() {
    String[] favoriteThings = {"roses","whiskers on kittens","raindrops"};
    favoriteThings[3] = "chocolate"; // **Check:** why 3 not 4?
    System.out.println( Arrays.toString(favoriteThings) );
  }
```

That throws an out of bounds exception!

Why? As mentioned, arrays are fixed in size. To add chocolate as a fourth item in an array, I would have to create a new array of a larger size, copy the info over, and then initialize the additional elements.

```java
  public static void addFourthFav() {
    String[] favoriteThings = {"roses","whiskers on kittens","raindrops"};
    String[] favoriteThingsLarge = new String[4];

    System.arraycopy(favoriteThings, 0, favoriteThingsLarge, 0, 3);
    favoriteThingsLarge[3] = "chocolate";

    System.out.println( Arrays.toString(favoriteThingsLarge) );
  }
```

Luckily, Java has provided something better: collections.

## Demo: Collections (15 mins)

Collections will not only will provide us with more convenience methods, allowing us to do more things with the data we have, but will also *automatically increase in size* if we need!

There are many different collection classes that we use just like data types, each of which provides some distinct functionality, but for today, we're going to focus on just one of them.

#### ArrayList

Let's take the array we made of favorite things and convert it into an `ArrayList`.

```java
  public static void main(String[] args) {
    // initialize ArrayList
      ArrayList<String> favoriteThings = new ArrayList<>();
    // add items
      favoriteThings.add("bright copper kettles");
      favoriteThings.add("brown paper packages tied up with strings");
  }
```

Note, the data type of each element is defined in angle brackets `<>`. This data type could be any object type. So, if you'd created a `Person` object, as you may have in the pre-work, you could create an ArrayList of Persons! (i.e. an `ArrayList<Person>`)

If you want to make an ArrayList of a primitive type, you need to use a "boxed" version of that type as the thing in the angle brackets. For example, if you want to store a bunch of `int`s, you would use an `ArrayList<Integer>`.

#### Manipulating a ArrayList

An ArrayList is an object, with methods, which makes it much easier to manipulate than a simple array. Check out the following methods.

```java
  //to print. No need to explicitly convert it to a string first!
  //(because ArrayList has a toString() method, which automatically
  //gets called here)
    System.out.println("favoriteThings = " + favoriteThings);

  //add(item) -- adds to the end of the list
    favoriteThings.add("chocolate");
    System.out.println("favoriteThings = " + favoriteThings);

  //add(index, item) -- adds to the list at specified index and moves all other entries over. Think: what you would have to do with a simple array to do that?
    favoriteThings.add(1, "warm woolen mittens");
    System.out.println("favoriteThings = " + favoriteThings);

  //put(index, item) -- replace the item at the given index with a new one
    favoriteThings.put(0, "tarnished copper kettles");
    System.out.println("favoriteThings = " + favoriteThings);

  //to search for an entry
    int indexOfIceCream = favoriteThings.indexOf("icecream");
    if(indexOfIceCream != -1) {
      String ic = favoriteThings.get(indexOfIceCream);
      System.out.println("ic = " + ic);
    }
    else {
      System.out.println("icecream not found");
    }

 //here's another good one: get number of things in the ArrayList
    favoriteThings.size();
```




## Guided Practice: Iterating Through a List with For Loops (15 mins)
One more thing before we start talking about lists in Android: How do you iterate through a list?

#### The For Loop
Do you remember the syntax used in a for loop? We used it in the Control Flow lesson to print something to the command line a set number of times.

The for loop is also commonly used with arrays and collections to iterate through each of the elements and do something with each entry.

For example, let's create a list of 5 movies and iterate through it, printing each one to the command line.


```java
  public static void main(String[] args) {
    ArrayList<String> movieList = new ArrayList<>();
    movieList.add(/*student suggestion here*/); //x5
    printMovies(movieList);
  }

  public static void printMovies(ArrayList<String> movies) {
    for (int i = 0; i < movies.size(); i++) {
      System.out.println("where i="+i+" : "+movies.get(i));
    }
  }

```

To review, a for loop has an initialization stage (where i is initialized), a termination condition (which includes the logic for when the loop stops), and an increment stage (that will occur on the completion of each loop).

#### The Enhanced For Loop
There is also another for loop syntax that is especially for arrays and lists. This is sometimes referred to as the **enhanced** for loop. Try it with me:

```java
 for (String movie : movieList) {
  System.out.println("I love "+movie+"!");
 }
```

The enhanced for loop is the form that is recommended by Oracle for arrays and collections.

A normal for loop is still useful sometimes -- it makes it easier to work with the index of each item alongside its value, or to modify the collection while you're iterating over it. But if you just need to do something with each element, the enhanced for loop is cleaner and more efficient.


## Independent Practice (15 mins)

Complete as many of the following challenges as you can in the next 15 minutes. Each challenge should be completed in its own method.

1. Find the size:
  a. Create an array of ints.
  b. Print the length of the array to the command line.

2. Concrete Jungle
  a. Create a ArrayList of New York City wildlife.
  b. Create a function that, given an ArrayList of Strings, prints for each element: "Today, I spotted a /*Thing here*/ in the concrete jungle!"

3. Create a method that, given an array of ints, return the sum of the first 2 elements in the array. If the array length is 1, just return the single element, and return 0 if the array is empty (has length 0).

4. Create an method that, given an ArrayList of words (Strings), turns each word into Pig Latin. The rules of Pig Latin are as follows:
  a. The first consonant is moved it to the end of the word and suffixed with an `ay`.
  b. If a word begins with a vowel you just add `way` to the end.

For example, `pig` becomes `igpay`, `banana` becomes `ananabay`, `twig` becomes `wigtay`, and `aadvark` becomes `aadvarkway`.


<a name="conclusion"></a>
## Conclusion (5 mins)

Quick review:
- List some differences between arrays and Array lists

Arrays and ArrayLists are fundamental tools needed by anything that wants to store and manipulate collections of data. Now that you know how to use them, we can start creating apps that use those collections. Excited?



### ADDITIONAL RESOURCES
- [Oracle Java Docs - Arrays](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
- [Android Docs - ArrayList](http://developer.android.com/reference/java/util/ArrayList.html)
- [Oracle Java Docs - The for Statement](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html)
- [CodingBat - Array-1 examples](http://codingbat.com/java/Array-1)
- [Android Docs - Building Layouts with an Adapter](http://developer.android.com/guide/topics/ui/declaring-layout.html#AdapterViews)
- [Android Docs - Adapter](http://developer.android.com/reference/android/widget/Adapter.html)



<!--
## Add On Lesson
To tackle these Collections Classes, we first need to learn a bit of vocabulary.

Interface | Classes               | Reasons to use it
----------|-----------------------|---------------------------------
List      | ArrayList, LinkedList, Vector, Stack | collection of Objects(most similar to simple array)\ndata is accessed by index
Sets      | HashSet, TreeSet      | unique collection of Objects(like a list, but no duplicates)\ndata is accessed by value
Maps      | HashMap, TreeMap      | set of key/value pairs(similar to a dictionary)\nkeys must be unique\ndata is accessed by using the key


**Student Exercise:** (5 min) Take five minutes to write down a thing that might be either a List, a Map, or a Set. Throw something around the room to get examples from each student -->
