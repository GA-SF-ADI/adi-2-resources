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

In this lab you will be using your knowledge of classes to build an Animal class, complete with properties, getters and setters. After completing the class, you will then create subclasses of Animal called Mammal and Reptile. Finally, you will create at least one subclass of Mammal, and one subclass of Reptile, making them whatever animals you want.

Each subclass should have some unique property that differentiates it from its parent class. For instance, a reptile could have a boolean to determine if it has a shell, or a snake could have a boolean to determine if it is poisonous.

You will create an Android app that allows the user to create these subclasses of Mammal and Reptile (the user gives some sort of input to customize it, such as setting whether a snake is poisonous). Show the created animals in a ListView.

## Exercise

#### Requirements

- Create an Animal class with the following properties set in the constructor: mNumLegs, mTopSpeed, mIsEndangered, mName.
- Create subclasses of Animal called Mammal and Reptile
- Create at least one subclass of Mammal, and one subclass of Reptile
- Each subclass must have something that makes it unique from its parent class.
- Create an Android app that allows the user to add each of your unique animals, and have them shown in a ListView

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

There is no starter code for this lab.

#### Deliverable

An Android app that meets the requirements above.

## Additional Resources

- [How to implement Serializable](http://www.javapractices.com/topic/TopicAction.do?Id=45)
