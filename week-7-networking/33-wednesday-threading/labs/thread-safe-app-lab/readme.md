---
title: Thread-Safe Lab: Image Processing
type: lab
duration: "1:25"
creator:
    name: Yuliya Kaleda
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Thread-Safe Lab: Image Processing

## Introduction


In this lab, you will be using the starter code provided to finish an app that takes a selected image from your device, inverts all of the colors, and displays the modified image on the screen. Your app must be thread-safe, because you need to show a progress bar displaying how far along the image processing is. In addition to getting practice with threading, you will also get some practice using bitmaps.  

The [Bitmap object](http://developer.android.com/reference/android/graphics/Bitmap.html) in Android is just a Java object that contains all of the data for an image, including access to the properties for each pixel in the image. The following methods are all you need to complete the section of the lab for manipulating the Bitmap.

- [getPixel](http://developer.android.com/reference/android/graphics/Bitmap.html#getPixel(int,int)
- [Color.red](http://developer.android.com/reference/android/graphics/Color.html#red(int)
- [Color.blue](http://developer.android.com/reference/android/graphics/Color.html#blue(int)
- [Color.green](http://developer.android.com/reference/android/graphics/Color.html#green(int)
- [Color.argb](http://developer.android.com/reference/android/graphics/Color.html#argb(int,int,int,int)
- [setPixel](http://developer.android.com/reference/android/graphics/Bitmap.html#setPixel(int,int,int)

## Exercise

#### Requirements

- use an AsyncTask to perform the image processing
- reverse the colors for a chosen bitmap
- display the modified image on the screen
- display a progress bar for the image processing

**Bonus**

- Perform additional image processing effects, such as black & white, blur, sepia, etc.

#### Starter code

Import the [starter code](starter-code) provided.  Fill in all of the areas that have a "TODO" next to it. Some of the AsyncTask is complete for you.

#### Deliverable

An app that meets the requirements above. See the screenshots below for some inspiration:

<p>
  <img src="./screenshots/screen1.png" width="200"/>
  <img src="./screenshots/screen2.png" width="200"/>
</p>

#### Resources

- [Bitmap Objects](https://developer.android.com/reference/android/graphics/Bitmap.html)
- [ASyncTask](https://developer.android.com/reference/android/os/AsyncTask.html)
