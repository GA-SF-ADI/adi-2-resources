---
title: Grocery List with Details
type: lab
duration: "1:25"
creator:
    name: Drew Mahrt
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Grocery List with Details

## Introduction


In this lab, we will be continuing our work on the Grocery List: when the user clicks on one of the grocery items, your app will navigate to a new activity that will display extra details about the item. The details you need to display are already stored in the columns for `description`, `price`, and `type`. See the screenshots below for an example.

<p align="center">
  <img src="./screenshots/database.png" width="60%">
</p>

## Exercise

#### Requirements

- Allow the user to click on a grocery item to go to a detail screen
- Display all four details from the database
- Gather the details for the selected item from the database (not passed through the intent)

**Bonus:**
- Add additional columns to the database and display those on the details screen
- Add an additional activity to allow the user to add more groceries to the list

#### Starter code

The [starter code](starter-code) contains the the solution code to the Enabling Search lab in a new project. If your code was working properly, you may continue using that codebase, if you prefer.

#### Deliverable

Here are screenshots of what the master and detail views should look like:

<p align="center">
  <img src="screenshots/screen1.png" width="300">
  <img src="screenshots/screen2.png" width="300">
</p>

## Additional Resources

- [Activities and Intents](http://developer.android.com/guide/components/intents-filters.html)
- [SQLite Database Documentation](http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html)
