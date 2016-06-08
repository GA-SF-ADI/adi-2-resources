---
title: Databases Intro
type: lesson
duration: "1:00"
creator:
    name: Micah Rich
    city: LA
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Databases Intro

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Define “what is a database?”
- Describe the relationship between tables, rows and columns

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Describe how objects have attributes and functionality associated with them

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- n/a

---
<a name="opening"></a>
## Opening (5 mins)

A database is a place where information gets stored in a hard drive - or distributed across multiple hard drives - on a computer somewhere. Much like we've been creating and storing data, here and there, a database represents a collection of individual pieces of data stored in a highly structured and searchable way; they represent a model of reality.


## Introduction: What goes into a database? (20 mins)

Inside a database, we do basic actions like create, read, update, and destroy data – hey look, CRUD!

In modern development, there are different categories of databases – SQL, NoSQL, Key/Value. We're focusing on SQL because historically that's the father to the others, but we will talk about the others later in the course.


SQL stands for Structured Query Language, and it's a language used to manage and get information from considered what are considered "relational" databases (we'll talk more about SQL next lesson).

We call these "relational" because different models - or pieces of data - can be linked to other models, aka "related". Relational DB's store data in a "table" so think of it like a spreadsheet. The table holds all the data for one model, while the columns define what attributes that model has; we often call columns "attributes" or "fields". A row is an instance (remember instantiation!) like a unique copy of the blueprint that is our model, often called a record.

![relational db](https://cloud.githubusercontent.com/assets/25366/8589355/2646c588-25ca-11e5-9f2d-3d3afe8b7817.png)


## Guided Practice: Let's Draw on The Board  (15 mins)

Let's say we're making an app for a library and look at what some tables would look like (e.g. what information or attributes would be associated with each table?)


- What would the table for a book look like?
- What would the table for an author look like?
- What would the table for a category look like?


See, this is when we start seeing relationships form. This is great. You can imagine duplicate pieces of data being stored naturally, especially when an author has multiple books, for instance. That's a waste of space!  So, let's talk about how we can connect these tables, this way, we don't have tons of duplicate data all over the place.

## Independent Practice: Think About the Database for Project 2 (15 mins)

Look over the project prompt for project 2 and begin to draw up the different tables, with the appropriate columns, that would be needed to set up an appropriate database.



## Conclusion (5 mins)

- Why is it important to store data in an Android app?
- Describe the difference between a SQL and a NoSQL database.
