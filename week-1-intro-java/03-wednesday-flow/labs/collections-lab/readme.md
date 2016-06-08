---
title: Writing Functions that use Iteration and Collections
type: Lab
duration: "1:30"
creator:
    name: Yuliya Kaleda
    city: NY
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Writing Functions that use Iteration and Collections


## Exercise

#### Requirements
Write 8 functions(2 bonus) that accept parameters that use combinations of control flow and multiple conditionals. Some of these functions will also require you to iterate over data collections (Arrays, ArrayLists, LinkedLists, Hash Maps). When a function is created, please call it and test all the cases including edge ones (e.g. empty strings, null values, big and small values). It is of high importance to practice and master Java fundamentals, which are the core of Android development.

#### Functions
1. Write a function that takes in a word. This function should return true if the word is a palindrome and false if it is not. A string is considered a palindrome if it remains unchanged when reversed. For example, "dad" is a palindrome as reverse of "dad" is "dad", whereas "program" is not a palindrome. Note: palindromes are case insensitive ("Dad" and "dad" are both palindromes).

2. Write a function that accepts no parameters and creates a list of any characters and returns a string, which
contains every other element in the list. Thus, if the list has 'a', 'b', 'c', 'd', the output should be "bd".

3. Write a function that takes in an array of integers and returns the max value in that array. Please do not sort the array.

4. Write a function that takes in a month of the year and returns the number of days in this month. If the input is not a
valid month, return 0.

5. Write a function that takes in an array of integers, sums the integers that are greater than 1, and subtracts 3 if the number is greater than 20. The function returns the result of the operations on the array.

6. Write a function that takes in a list of names, filters the list removing all duplicate names and returns a list with
unique names.

7. Write a function that takes in a string, omits all vowels and returns a new string that contains only consonants.
Make sure to catch the edge cases (e.g. empty string, upper/lower case).

8. Write a function that takes in a list of countries, swaps the first country with the last one in the list and prints
out each of them following the new order. Choose the best collection that gives you access to the first and last element.


*Bonus*
9. Write in a function that takes in a positive integer, creates a linked list with integers in the range from 1 to the input number
and returns a middle element of the linked list if the length of the linked list is an odd number, otherwise -1.

10. Write a function that creates the right data structure to keep the names of your family members and their age. The
function asks the user to type in a family member's name and returns his/her age if the name exists or the string
"Such family member does not exist!" if such a member does not exit.

#### Deliverable

You are expected to create a Java file with 8 functions and run them testing all cases.

#### Resources

- []()
- [Collections](https://developer.android.com/reference/java/util/Collections.html)
