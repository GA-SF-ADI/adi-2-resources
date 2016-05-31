---
title: Data Types and Variables
duration: "1:30"
creator:
    name: Kristen Tonga
    city: NYC
---


# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Data Types and Variables


### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Identify and describe the Java data types and use cases
- Describe the different types of variables (locals, instance, constants) and when to use them
- Use class methods to manipulate data in the Math and String classes
- Describe the difference between NaN and null

### STUDENT PRE-WORK

*Before this lesson, you should already be able to:*
- List a few of the basic Java data types
- Assign a variable in Java (`int a = 1;`)
- Describe Objects in Java

### INSTRUCTOR PREP

*Before this lesson, instructors will need to:*
- Open and run the starter and solution code
- Modify sections and checks as needed

---
<a name="opening"></a>
## Opening (5 min)

In programming, we need a way to store information while our programs are running. This could be anything from names, to numbers, to dates, and many other things, which are all known as `data types`. These data types are stored in `variables`, just like algebra class. Today we are going to be exploring how data types and variables are the very basic building blocks of programming and how we actually use them to store information in our programs.

## Introduction: Data types in Java (10 mins)

From the Wikipedia:

In computer science and computer programming, a data type or simply type is a classification identifying one of various types of data that determines:
- the possible values for that type;
- the operations that can be done on values of that type;
- the meaning of the data;
- and the way values of that type can be stored.

Data types are similar across different languages, including English:


|Category    | DataType                     | Description          | Example |
|------------|------------------------------|----------------------|---------|
|True/False  | boolean, Boolean                   | Represents either true or false                               |true, false|
|Integers    | short, int, Integer, long, Long    | Whole numbers, with no delimiter. Can optionally have underscores to make large numbers easier to read	| 42, 1024, 1_000_000 |
|Decimals    | float, Float, double, Double       | Decimals, with no delimiter                                   | '42.123', 2.5' |
|Characters  | char                               | Single character, surrounded by single quotes                 | 'a', 'A'|
|Strings     | String                             | Single words or sentences, surrounded by double quotes        | "lots of kittens", "a lazy lizard"    |                                                                | true, false


There are also a few odd ones:
- Byte, which is one bit of data. You don't need to worry about it right now.  
- Collections (we'll talk more about this Week 3)

We'll elaborate all of the categories on the board, and show you some helper methods to help you manipulate them.


## Demo: Lets start with Numbers (15 mins)

#### Starting an IntelliJ Project


Steps to Create a new IntelliJ Project: File > New > Project > Next > Create from Template.
Note: you are given a class, that is named the same as the file with a `main` method inside it.

Also Note: What does the `//` mean?  This represents a comment. You can also replace `//` with a multi-line comment `/* write your code here */`.  Comments are used to clearly articulate what your code is doing so that other developers can easily jump into a project and understand what's going on.

We'll talk more about all of these pieces later, for now, write your code directly within the main method, where the comment says, `//Write your code here`.

#### Decimals vs Integers


First off, lets talk a bit about those Number data types.

What do you expect to be printed to the console?

```java
int num1 = 5;
System.out.println("num1, type int = " + num1);
=> num1 = 2
```

How about here?

```java
int num2 = 5 / 2;
System.out.println("num2, type int = 5/2 = " + num2);
=> num2 = 2
```

But Why is `num2` not 2.5? Well, in low-level languages (unlike JavaScript, Ruby or PHP) numbers are strictly typed, and a type is either an integer or decimal.  An int stores a Integer, not a decimal, as demonstrated in the previous function.

So, what sort of variable would we use if we wanted to assign a variable to a decimal?
How about a float?

```java
float num3 = 5 / 2;
System.out.println("num3, type float = 5/2 = " + num3);
=> num3 = 2
```


Because both 5 and 2 are automatically assigned data type int, when the calculation is done the answer is also an int ( `float a = (float) int a = int b / int c;` ). We must tell the computer that the divisors are of a decimal type, not an integer type.

```java
float num4 = 5f / 2f;
System.out.println("num4, type float = 5f/2f = " + num4);
=> num4 = 2.5
```

```java
double num5 = 5d / 2d;
System.out.println("num5, type double = 5d/2d " + num5);
=> num5 = 2.5
```

Note: In the previous example, we used both a float and a double data type to save decimal numbers.  


#### Number data types and Bits

To answer this question, it is helpful to understand that a data type defines not only the type of data but also the methods that can be used to manipulate that data. The *primitive* data types in Java also has a certain pre-assigned size in memory. This is represented in a number of bits.

| Name  | Width in bits | Range    |
|-------|---------------|----------|
| float   | 32          | 3.4e–038 to 3.4e+038 |
| double  | 64          | 1.7e–308 to 1.7e+308 |

More memory means more information can fit into that variable. Double's are much larger than floats.
What does that mean for working with decimals? Floats are more memory efficient, and doubles provide more accuracy.

Double's are recommended for currency and where accuracy is important.
There is also a `BigDecimal` class, used when even more decimal points are needed.

The same data type differentiation exists in Integers between shorts (did you notice it in our list), ints and longs.

| Name  | Width in bits | Range    |
|-------|---------------|----------|
| short | 16           | -32,768 to 32,768                  |
| int   | 32           | -(2^31) to 2^31 (approx 2 billion) |
| long  | 64           | -(2^63) to 2^63                    |

`int` will cover almost all of your Integer needs.



#### Using Standard Arithmetic Operators

Now that we understand a bit more about the Number data types, lets look a bit at what we can do with them.

The standard arithmetic operators - that you've been learning since grade school:


``` java
System.out.println(2 + 2);
System.out.println(2 - 2);
System.out.println(2 / 2);
System.out.println(2 * 2);
System.out.println(2 % 2); // What does this do??
```

## Demo: Using Special number Operators (10 mins)

Coding languages can be a little cheap with the number of operations they allow you to do.
For example, how do you square or cube a number? There is a special 'Math' Object, provided by Java, that has some very useful methods.  Follow along!


Taking a number to a 'power' ? Then just use `Math.pow(num1,num2)`
``` java
// 3^2 becomes
System.out.println( Math.pow(3,2) );
=> 4
```

Taking a square root ? Then just use `Math.sqrt(num1)`
``` java
// √(4) becomes
Math.sqrt(4);
=> 2
```

Need a random number? Then use `Math.random()`.
``` java
// returns double value with positive sign greater than or equal to 0.0 and less than 1.0
Math.random()
=> ?
// returns random number in range
int range = Math.abs(max - min) + 1;
(Math.random() * range) + min;
```


## Introduction: Primitives vs. Objects (10 mins)

Before we get into Strings, let's take a step back. Have you noticed that all the data types we've used so far are lowercase? What do you notice about the `String` data type?

What is the difference?  Do you notice that it is capitalized?  This is a naming convention that is used to distinguish between primitive and Object data types.

**Primitive data types**: are a piece of data and are **pass-by-value**.  This means: Using a primitive as a parameter is like writing a number on a post-it note and handing it off. `int a = 1; ` is a *copy* of the number data, not a reference to where the data is stored;

**Object data types**: contain attributes and methods, and start with a capital letter. These are **pass-by-reference**.

In other words: Using an object is like using a dewi decimal system in the library. A variable assigned to an Object is given a number that references where a book can be found in the computer's library but is not a copy of the book itself. `Person a = new Person(Nancy, Drew); ` is a reference to the data Object that contains all info and methods in the class of that object.


#### Words: char and Strings

With that basic introduction to the two larger sorts of data types, primitives and Objects, lets talk about words.

A `char` is a primitive data type.  What is an example of a `char`?

A String is capitalized because a String is an Object.


Strings are collections of letters and symbols known as *characters*, and we use them to deal with words and text.

Strings are special - String is actually a array of 'char' data:

``` java
String str = "abc";
// is actually
char data[] = {'a', 'b', 'c'};
```

## Demo: Creating a new string (15 mins)

Strings are a weird type of Object.

Try this with me.  You can instantiate (or create an instance) a String in a few ways:

``` java
//variable can be assigned like a primitive
String a = "I'm a string."
```

Which is really short for:
``` java
//variable assigned like an Object
String a = new String("I'm a string too!")
```

#### String helper methods

Because a String is an Object, it has pre-defined methods we can use.

To find the length of a string, use it's `length` property:

```java
"hello".length();
=> 5
```

To get the first letter of a String:

```java
"hello".charAt(0);
=> "h"
```

To replace part of a String:

```java
"hello world".replace("hello", "goodbye");
=> "goodbye world"
```

To make a String uppercase:

```java
"hello".toUpperCase();
=> "HELLO"
```

To add two Strings together:
```java
"hello".concat(" world");
=> "hello world"
```

Remember, Strings are special Objects that look like primitives. Use the `str1.concat(str2)` function.
Or concatenate (add together) using + :

```java
String twoStringsTogether = "Hello" + " World";
=> "Hello World"
```


##### A special note on Equality among Strings:

What if you want to compare two strings?

Can you remember from the pre-work how to compare variables?

```java
boolean areEqual = (1 == 2);
=> false
```

What's special about strings?

```java
String blue = "blue";
boolean withSign = (blue == "blue");            //=> true
boolean withWords = (blue).equals("blue");      //=> true
```

Do you know which one of these would be preferred? Well, lets do another example to show you which and why:

```java
String blue = "blue";
String bl = "bl";
String ue = "ue";
System.out.println(bl+ue);                      //=> blue
boolean withSigns = (bl+ue == blue);            //=> false
boolean withWords = (bl+ue).equals(blue);       //=> true
```

Why isn't `withSigns` true? The print out looks the same. Remember, String is actually an object, and Objects are **passed by reference.**

`==` compares the place where the object was stored on the computer to access whether they are the same.  `String blue` has a reference to where it is stored on the computer, and that is a different place than `String bl` is stored. `equals`, on the other hand, is a method that can be called on an instance(`str1`) of a String Object. And accesses whether the `char` arrays in each String are the same, not whether the references are the same.

The long and short of it, use `equals` when comparing strings.



## Demo: Converting between data types (10 mins)

Sometimes it is necessary to convert between data types.  User input is _always_ a string - like when you enter your email address, age, income, etc.  If you'd like to operate on those numbers though, you'll have convert it to a type of number.

Remember how we talked about the size of primitive data types? An float is smaller than a double, and a double smaller than a long?

When converting from smaller types to larger types, for example, int(4 byte) to double(8 byte), conversion is done automatically. This is called **implicit casting**.

```java
int a = 100;
double b = a;
System.out.println(b);
```

If, on the other hand, you are converting from a bigger data type to a smaller data type, for example, a double(8 byte) to an int(4 byte), the change in data type must be clearly marked. This is called **explicit casting**.

```java
double a = 100.7;
int b = (int) a;
System.out.println(b);
```

While that is useful for numbers, to cast successfully, a variable must be an **instance of** that second Object.
What do you think would happen if you tried to cast a String to an int?

There is a different way to convert Strings to numbers.

Did you notice that there is both an `int` and an `Integer` data type? The `Integer` data type is a wrapper around an int that provides certain methods.
For example, to convert an String to an Integer, one can use:

```java
String strValue = "42";
int intValue = new Integer(strValue).intValue();
```

Similar methods exist for all of the wrappers.

#### NaN

If a String is converted to a number but contains an invalid character, the result of the conversion will be **NaN**, which stands for: Not A Number.

NaN is toxic, and if a calculation is attempted on that variable or a method called subsequently, your program will break.

Test for NaN using `isNaN()`.

#### Null

A null value is an empty value.  Taken from a StackOverflow post:

"Zero" is a value. It is the unique, known quantity of zero, which is meaningful in arithmetic and other math.

"Null" is a non-value. It is a "placeholder" for a data value that is not known or not specified. It is only meaningful in this context;


<a name="ind-practice"></a>
## Independent Practice: Practice! (15 minutes)

Download the coding prompt found in `VariablePractice` and complete all tasks. We will go over the answers in 12 minutes.



***

<a name="conclusion"></a>
## Conclusion (5 mins)

- Identify the different types of data?
- What type of data do you think is passed as a web request?


### ADDITIONAL RESOURCES
- [Oracle Java Docs on Primitive Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)
- [Oracle Java Docs on Math Object](https://docs.oracle.com/javase/7/docs/api/java/lang/Math.html)
