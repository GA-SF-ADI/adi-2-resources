
# Classes:
- They are a way to model complex data types such as cars, people, animals, etc.

## Oracle Documentation
- Same as before, read about classes on the Oracle website. It should make more sense now that you know what they are. 

The link is [here](https://docs.oracle.com/javase/tutorial/java/javaOO/). Read ALL of the sections and do the exercises! 

## Tutorials Point
- Re-read tutorials point on classes, it should make more sense again. Link is [here](http://www.tutorialspoint.com/java/java_object_classes.htm).
- Read about inner classes [here](http://www.tutorialspoint.com/java/java_innerclasses.htm) ( In recyclerView, Ayinde had ViewHolder class be inner class of RecyclerViewAdapter class ).
- Read about inheritance [here](http://www.tutorialspoint.com/java/java_inheritance.htm).
- Read about method overriding here ( this is what we did with onActivityResult() ).
- Read about encapsulation ( making things private/public/protected ) here.
- Read more about what interfaces are here.

## Other Readings on Classes:
- Read all 3 pages about classes here.
- Read the lecture notes which are pretty nice here.

2) Data Collections
- Read ALL of the following links showing you how to work with ARRAYS here.
- Read ALL of the following links showing you how to work with COLLECTIONS here.
- Read some more about STRINGS and what you can do with them here.

- How to move data with Arrays here.

3) Methods
- Some examples of problems and how to use methods to solve them here. NOTE: Fibonacci and Tower of Hanoi are common interview questions so study them. If you are not sure about what these mean, google the problems themselves for explanations.

*** 
4) Classes Exercises:
4a) Create Classes to model the following real world objects
- Create a "Contact" class that models are contact from your phone. 
** This class should hold contact "firstName", "lastName", "phoneNumber", and 'emailAddress". 
** MAKE SURE ALL FIELDS ARE PRIVATE. Write getters and setters for each field!
** This class should have a constructor that has at least a name and phone number arguments.

- Create a "PhoneBook" class that models a phone book. 
** This class should hold a list of "Contacts" and have these methods: "removeContact()", "addContact()", and "getContactList()".
** This class should have 2 constructors! One that takes not contact list and one that takes a contact list.

Inside your Main.java you should create 2 phone books. 
** One for iPhone that has an existing list of contacts.
** One for Android that has no contacts.

You should:
** Copy the iPhone contacts to the Android contacts
** Add a new Contact to Android 
** Remove all iPhone contacts using the Android contact list!

- Solutions are here.

4b) More problems
- Use IntelliJ instead of Eclipse like the assignments ask you to. 
- Do these two problems here. Solutions are found here if you want to check your work.
- Problems with arrays and Part II involves classes here. Solutions here.
- Do Part II here. Solutions here and diagrams here if they help
- Do this lab here to model a light-switch. Solutions here.

***

5) Subclassing exercises
5a) Building off of the Classes exercise
- Subclass phone book and create Android phone book
** Android phone book should at a minimum take a float as android version in constructor, and also android version and existing contact list
** Android phone book class needs a method to check if android version is supported ( supported only if > 4.0f )
** Inside PhoneBook.java add a private String field for "phoneBookType" that is initialized to "phoneBook". Create getter/setter for this field.
** Inside AndroidPhoneBook constructor, set the "phoneBookType" value to "Android"
** Inside Main.java, update the "androidBook" to be of type AndroidPhoneBook and initialize its constructor with version "2.0f".
** Now check if the version is supported, if so then copy the iphone contacts over. If not, then do not copy the contacts and print that version is not supported.

- Solutions here

6) Extra Resource:
- If you want to go back to basics, it is not a bad idea to take the free Udemy Java course here. 
- Also take a look at Code Academy's Java intro course here.
- Books on Java such as "Effective Java", "Java for Beginners", and "Java for Dummies" would all be great resources as well. Link is here.
