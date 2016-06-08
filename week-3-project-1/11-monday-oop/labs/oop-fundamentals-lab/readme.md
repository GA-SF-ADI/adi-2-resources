---
title: OOP & Singleton with Animals
type: lab
duration: "1:30"
creator:
    name: Drew Mahrt
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) OOP & Singleton with Animals

## Introduction

This lab will continue our subclasses lab where we created subclasses of Animals. Instead of storing all of our Animals in an ArrayList, we're going to store all of them in a Zoo class that is a Singleton. If you remember from the lesson, a Singleton is a class where only one instance exists in memory. In addition to giving our Animal objects a new place to live, the Zoo will make sure our Animals only exist once in memory.

In addition, add a method makeNoise() that returns the sound that animal makes as a String. When the user presses on the Animal in the list, a Toast pops up with whatever that Animal's noise is ("Roar","Hiss","Meow" etc.).

## Exercise

#### Requirements

- Contain all of your Animals in a Zoo singleton
- Perform all of the same functionality as the previous lab
- Make a Toast appear when clicking on the list item that shows the appropriate sound for the Animal

**Bonus:**
- Add the ability to remove Animals from the Zoo

#### Starter code

The starter code is the solution code to the subclasses lab.

You can use your previous code if you would like to.

#### Deliverable

An Android app that meets the requirements above.

## Additional Resources

- [Singleton implementation](http://www.javaworld.com/article/2073352/core-java/simply-singleton.html)
