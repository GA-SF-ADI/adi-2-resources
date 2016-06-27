---
title: Subclasses with Animals
type: lab
duration: "1:30"
creator:
    name: Drew Mahrt
    city: NYC
competencies: Classes and Subclasses
---

# Subclasses with Animals Lab

## Introduction


This lab is going to be an extention of this morning's exercise. You had an Animal class, but we are going to refactor your code to include subclassing. you are going to create subclasses of Animal called Mammal and Reptile. Additionally, you will create at least one subclass of Mammal, and one subclass of Reptile, making them whatever animals you want.

Each subclass should have some unique property that differentiates it from its parent class. For instance, a reptile could have a boolean to determine if it has a shell, or a snake could have a boolean to determine if it is poisonous.

You will create an Android app that allows the user to create these subclasses of Mammal and Reptile (the user gives some sort of input to customize it, giving it its name). Show the created animals in a ListView. 

## Exercise

#### Requirements

- Create an Animal class with the following properties set in the constructor: numLegs, topSpeed, isEndangered, name.
- Create subclasses of Animal called Mammal and Reptile
- Create at least one subclass of Mammal, and one subclass of Reptile
- Each subclass must have something that makes it unique from its parent class.
- Create an Android app that allows the user to add each of your unique animals, and have them shown in a ListView
- If something weird is showing up in your ListView, don't worry! We gave some resources below showing how to Override the toString method. This is just a taste of Overriding, we will be covering it more on Monday!

**Bonus:**
- Create more than the minimum number of mammal or reptile subclasses
- When the user clicks on a list item, it takes them to a details screen for the animal, showing all of its properties

#### Extra Information

- Making your class Serializable so you can pass it in an Intent. See the link below for more information.

```java
public class YourClass extends AnotherClass implements Serializable{
  private static final long serialVersionUID = 7526472295622776147L;

  ...
}
```

- Overriding toString to make it print the correct info in the ListView

```java
@Override
public String toString() {
    return "Whatever you want to show on the list item";
}
```

#### Starter code

Work off of your code from the morning lab! 

#### Deliverable

An Android app that meets the requirements above.

## Additional Resources

- [How to implement Serializable](http://www.javapractices.com/topic/TopicAction.do?Id=45)
