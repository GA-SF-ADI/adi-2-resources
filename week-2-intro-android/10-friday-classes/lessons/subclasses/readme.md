---
title: Subclassing
duration: "1:30"
creator:
    name: Drew Mahrt
    city: NYC

---

<!--  OUTSTANDING
1. high level conclusion discussion questions

-->

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Lesson Title


### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Describe what subclassing means
- Explain how subclassing works in Java
- Extend a class using Java

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Create a basic class with getters and setters
- Instantiate a user-defined class

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Gather materials needed for class
- Complete Prep work required
- Prepare any specific instructions

---
<a name="opening"></a>
## Opening (5 mins)

Today we will be expanding upon our last lesson about classes. We learned about the basic components of a class and how they are created, but they can do so much more. We will be learning about how classes interact with each other, and more specifically, how they are related to each other.



***

<a name="introduction"></a>
## Introduction: Subclassing (20 mins)

One of the key ideas behind Object-Oriented Programming is defining relationships between the classes you create. In OOP, we create templates that can be reproduced and interacted with. A subclass can be thought of as a more detailed version of a class you have already created.

For instance, a NormalUser and an Admin can both be considered a subclass of a User. We can say that a NormalUser `is a` User, and that an Admin `is a` User. We could simply make the properties and methods inside of User for every type of User, but our code becomes much clearer if we make a separate subclasses to represent each specific type of User.


<a name="demo"></a>
## Demo: Topic (15 mins)

Do this with me!

We're going to start with the example of shapes. First, let's define our Shape class with the property "mColor":

``` java
public class Shape {
  private String mColor;

  public Shape(String color){
    mColor = color;
  }

  public String getColor(){return mColor;}
}
```

When designing classes and subclasses, you need to ask yourself what properties or methods are unique to the subclass and what are common across all possible subclasses. In the case of our example, every type of shape has a color, so we include it in the superclass.

Now we're going to make a subclass, Square. A Square is a Shape, so we can make it a subclass:

``` java
public class Square extends Shape {
  private int mSideLength;

  public Square(int length, String color){
    super(color);
    mSideLength = length;
  }

  public int getArea(){
    return mSideLength * mSideLength;
  }
}
```

Now we will make a Triangle class that will still be a Shape, but have different behavior.

``` java
public class Triangle extends Shape {
  private int mSideLength1;
  private int mSideLength2;
  private int mSideLength3;

  public Triangle(int length1, int length2, int length3, String color){
    super(color);
    mSideLength1 = length1;
    mSideLength2 = length2;
    mSideLength3 = length3;
  }

  public double getArea(){
    double s = 1/2 * (mSideLength1 + mSideLength2 + mSideLength3);
    return Math.sqrt(s*(s-mSideLength1)*(s-mSideLength2)*(s-mSideLength3));
  }
}
```

There are some important keywords to notice:

- The `extends` keyword denotes that we are subclassing __Shape__ for this class. (Making __Shape__ our superclass)
- The `super` keyword is used to access members from the superclass, such as the constructor

What we have covered so far are all of the basics you need to build a class and create a subclass using it.



<a name="guided-practice"></a>
## Guided Practice: Subclassing (30 mins)


This is a tricky topic, so let's get some more guided practice.  Follow along:
Let's write a __Vehicle__ class with the  `mModel` and `mSpeed` member variable which are assigned on instantiation of the __Vehicle__.  How might we do that?

``` java
public class Vehicle {
    private double mSpeed;
    private String mModel;
    private String mOwnerName;

    public Car(String modelName, String ownerName) {
        mModel = modelName;
        mOwnerName = ownerName;
        mSpeed = 0.0;
    }

    public void goForward(){
      mSpeed += 5.0;
    }

    public double getSpeed(){return mSpeed;}
}

// creating a new object of type Car
Vehicle mFirstCar = new Vehicle("Civic");
```

That is a good start, but we can create a subclass of __Vehicle__ to get a more specific Vehicle.

So instead lets create a `class` __Car__ with all the properties we want:

```java
public class Car extends Vehicle {
    private int mNumWheels;

    public Car(String modelName, String ownerName) {
        super(modelName,ownerName);
        mNumWheels = 4;
    }

    public int getNumWheels(){return mNumWheels;}
}
```

Java provides us with an important concept in OOP. Inheritance. When we subclass the __Vehicle__ our __Car__ class will **inherit** all the methods and variables contained within:

```java
public class Main {
  public static void main(String[] args){
    Car myCar = new Car("Civic","Drew");
    myCar.goForward()
    System.out.println(myCar.getSpeed());
  }
}  

```

We call the constructor of __Car__ with our model name and owner name using the method call `super()`. This way now every `new` Car object will have its model name and owner name set correctly.

In practice, we can now use Car everywhere we use Vehicle but not the other way around. Think of it in the way all Squares are Shapes but not all Shapes are Squares.

```java
Vehicle myCar2 = new Car("CR-V","Drew");

//To use Car's methods, we need to cast it.

System.out.println("Side Length: "+((Car)myCar2).getNumWheels());

```

We can't define a Car as a Vehicle.

```java
//ERROR
Car myCar3 = new Vehicle("Accord","Drew");

System.out.println("Number of wheels: "+myCar3.getNumWheels());
```

How could I fix this?

```java
//In main
Car myCar3 = (Car)getSomeVehicle();

//outside of main
public Vehicle getSomeVehicle(){
  return new Car("Accord","Drew");
}

```


We have seen this before in our previous Android apps when we use the findViewById method to find the instance of our View from the layout.

```java
TextView textView = (TextView)findViewById(R.id.textview);
```
`findViewById` returns a View, but TextView is a subclass of View, so we can `cast` the View to a TextView.


<a name="ind-practice"></a>
## Independent Practice: Subclassing Cards (15 minutes)


Now, you are going to try implementing your own class and subclasses. Create a new project:

- create a superclass Card and subclasses DebitCard and CreditCard
- give your superclass the properties "nameOnCard" and "cardBrand" (Visa, Mastercard, etc.)
- CreditCard should contain the property "cardLimit", and DebitCard should have the property "accountBalance"
- Add any other properties you want
- Instantiate your Classes and print out their member variables in a main method


<a name="conclusion"></a>
## Conclusion (5 mins)

Today we gained a further understanding of how multiple classes can fit together to make a useful system that reduces code duplication and makes your code much easier to understand. You can have many levels of subclasses beyond the simple two-level examples we saw today. Hopefully the concepts you learned today helps you understand some of the code that Android Studio is automatically generating for you when you create new Activities. In our next lesson, we will be discussing more concepts and keywords that can be applied to your classes and subclasses.

### ADDITIONAL RESOURCES
- [Inheritance](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
