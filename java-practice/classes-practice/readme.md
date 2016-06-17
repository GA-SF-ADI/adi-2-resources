
# Classes:
- They are a way to model complex data types such as cars, people, animals, etc.
- This is a significant amount of reading, but Classes are arguably the most important concept from Java for you to understand how Android is built. Everything will be more clear if you understand classes. 

## Oracle Documentation
- Same as before, read about classes on the Oracle website. It should make more sense now that you know what they are. 

The link is [here](https://docs.oracle.com/javase/tutorial/java/javaOO/). Read ALL of the sections and do the exercises! 

## Tutorials Point
- Re-read tutorials point on classes, it should make more sense again. Link is [here](http://www.tutorialspoint.com/java/java_object_classes.htm).
- Read about inner classes [here](http://www.tutorialspoint.com/java/java_innerclasses.htm) ( These are different from subclasses, we will talk about them later ).
- Read about inheritance [here](http://www.tutorialspoint.com/java/java_inheritance.htm).
- Read about method overriding [here](http://www.tutorialspoint.com/java/java_overriding.htm) ( this is what we did with onActivityResult() ).
- Read about encapsulation ( making things private/public/protected ) [here](http://www.tutorialspoint.com/java/java_encapsulation.htm).
- Read more about what interfaces are [here](http://www.tutorialspoint.com/java/java_interfaces.htm). We will be covering them more on Monday.

## Other Readings on Classes:
- Read all 3 pages about classes [here](http://www.javaworld.com/article/2979739/learn-java/java-101-classes-and-objects-in-java.html).
- Read the lecture notes which are pretty nice [here](http://www.cs.cmu.edu/~mrmiller/15-110/Handouts/writingClasses.pdf).

2) Data Collections
- Read ALL of the following links showing you how to work with ARRAYS [here](http://www.tutorialspoint.com/javaexamples/java_arrays.htm).
- Read ALL of the following links showing you how to work with COLLECTIONS [here](http://www.tutorialspoint.com/javaexamples/java_collections.htm).
- Read some more about STRINGS and what you can do with them [here](http://www.tutorialspoint.com/javaexamples/java_strings.htm).

- How to move data with Arrays [here](http://www.cs.cmu.edu/~mrmiller/15-110/Handouts/movingArrays-4.pdf).

3) Methods
- Some examples of problems and how to use methods to solve them [here](http://www.tutorialspoint.com/javaexamples/java_methods.htm). NOTE: Fibonacci and Tower of Hanoi are common interview questions so study them. If you are not sure about what these mean, google the problems themselves for explanations.

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

- Solutions are [here](https://github.com/GA-SF-ADI/adi-2-resources/tree/master/java-practice/classes-examples/src/com/generalassembly/alex).

4b) More problems
- Use IntelliJ instead of Eclipse like the assignments ask you to. 
- Do these two problems [here](http://www.cs.cmu.edu/~mrmiller/15-110/Homework/homework6.html). Solutions are found [here](http://www.cs.cmu.edu/~mrmiller/15-110/Homework/homework6soln.txt) if you want to check your work.
- Problems with arrays and Part II involves classes [here](http://www.cs.cmu.edu/~mrmiller/15-110/Homework/homework7.html). Solutions [here](http://www.cs.cmu.edu/~mrmiller/15-110/Homework/homework7soln.txt).
- Do Part II [here](http://www.cs.cmu.edu/~mrmiller/15-110/Homework/homework8.html). Solutions [here](http://www.cs.cmu.edu/~mrmiller/15-110/Homework/homework8soln.txt) and diagrams [here](http://www.cs.cmu.edu/~mrmiller/15-110/Homework/homework8diagrams.pdf) if they help
- Do this lab [here](http://www.cs.cmu.edu/~mrmiller/15-110/Labs/lab5.html) to model a light-switch. Solutions [here](http://www.cs.cmu.edu/~mrmiller/15-110/Labs/lab5soln.txt).

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

- Solutions [here](https://github.com/GA-SF-ADI/adi-2-resources/tree/master/java-practice/subclasses-examples/src/com/generalassembly/alex)

6) Extra Resource:
- If you want to go back to basics, it is not a bad idea to take the free Udemy Java course [here](https://www.udemy.com/java-tutorial/). 
- Also take a look at Code Academy's Java intro course [here](https://www.codecademy.com/learn/learn-java).
- Books on Java such as "Effective Java", "Java for Beginners", and "Java for Dummies" would all be great resources as well. Link is [here](http://www.tutorialspoint.com/java/java_useful_resources.htm).
