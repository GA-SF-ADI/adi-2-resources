---
title: Android Architecture
type: lesson
duration: "1:20"
creator:
    name: Jean Weatherwax
    city: San Francisco
---

---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Android Architecture

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Understand the levels of Android architecture
- Describe basic functionality of different architecture components

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Describe the different [Android components](https://developer.android.com/guide/components/fundamentals.html)

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Review lesson and reference materials

---

## Opening (5 mins)

We have spent a lot of time now exploring the different Android components are in code, and we've had experience with building apps ontop of the Android framework. But what do we really know about Android hardware? As software developers, it's good to keep in mind that you're making code to run on actual devices, with lower-level components that make up the modern mobile device. 

In this lesson, we're going to cover the basics of Android architecture. This is a peek under the hood of how your code actually turns into a functional product. 

## Introduction (5 mins)

The Android architecture is roughly divided into about 5 sections. Let's take a look at each.

[![Architecture](http://programmersnight.com/wp-content/uploads/2015/12/Android-Architecure-1.png)](http://programmersnight.com/wp-content/uploads/2015/12/Android-Architecure-1.png)

## Linux Kernel (5 mins)

At the base of the Android architecture is a Linux platform. This is an interface to hardware and it contains all the essential hardware drivers. These include the keypad, display, camera, sensors on more advanced smartphones (pressure, motion etc). The kernel also takes care of networking and device drivers.

## Android Libraries (10 mins)

Built on top of the Linux kernel is a set of built-in libraries. These include:

* Webkit: an open-source web browser engine
* SQLite Database: storage
* SSL libraries: internet security purposes
* Audio/Video libraries: play and record media functionality
* libc: standard c library with useful standard functions
* OpenGL ES: computer graphics rendering
* SGL: Scalable Graphics Library
* FreeType: font rendering

In addition, there are Android specific libraries. These include things like _android.widget_, _android.view_, _android.content_, and _android.app_. These are application framework libraries and libraries that facilitate user interface building.

## Android Runtime (10 mins)

Android Runtime contains a very important component known as the Dalvik Virtual Machine (named by Dan Bornstein after a village in Iceland). It's a Java VM, and it is specifically made for Android.

The Dalvik VM uses Linux core memory management. It also uses Linux-based multi-threading. These are very important to Java and the DVM allows each Android application to run its own process, with it's own VM instance.

Further, the Android runtime contains core libraries which allow us as developers to write Android apps using Java as the base language.

## Application Framework (10 mins)

This layer provides service access to apps as Java classes. These are included services:

* View System : An extensible set of views used to create application user interfaces.

* Activity Manager : Controls all aspects of the application lifecycle and activity stack.

* Content Providers : Allows applications to publish and share data with other applications.

* Resource Manager : Provides access to non-code embedded resources such as strings, color settings and user interface layouts.

* Notifications Manager : Allows applications to display alerts and notifications to the user.

## Applications (10 mins)

As an Android developer, this is where we get to put our mark. The Applications layer includes built-in utility apps (like Home, SMS, clock, Contacts/Phone, Calendar) as well as sensor-facing built-in apps like Camera and Media Player. This layer also includes apps you can download from the Play Store or install with adb.

## Independent Practice (20 mins)

Take a few minutes to review the Android architecture layers. Then, take 10 minutes(without referencing materials) to either discuss in pairs or write down individually the Android architecture layers and the important functions/features of each.

## Conclusion (5 mins)

The Android system has been built up on layers of hardware and lower-level architecture components to give us what we have today as a flexible and fun development platform. It's good to understand the architecture layers both for interviews and for development skills.

## Reference:

[Tutorial](http://www.tutorialspoint.com/android/android_architecture.htm)

[Dalvik VM Architecture](http://davidehringer.com/software/android/The_Dalvik_Virtual_Machine.pdf)





