#Algorithm Questions/Morning Exercises

## Ints/Doubles/Floats

### 1. Create a Change function

You are going to be given an integer amount in cents (So if I give you a dollar and thirty-two cents, the input would be 132). I want you to return an array that contains the coin values [Quarters, Dimes, Nickels, Pennies]. So for the example 132, the result would be 5 quarters, 1 nickel, and 2 pennies, so it would be represented by the array [5,0,1,2]. 
	
BONUS: You are also going to be given an array that contains the coin values. So if I just wanted the coins to be the standard US coins, I would pass in [25,10,5,1].  

[Solution](solutions/ints-doubles-floats/Change.java)

### 2. Check if an integer is binary (with or without converting it into a string)

A binary number is a number just made up of 1s and 0s. So something like 10101110101 is binary while something like 11101021012 is not. Given an integer input, return whether or not that integer is in binary or not. 

[Solution](solutions/ints-doubles-floats/IsBinary.java)

## Strings

### 3. Reverse a string using a for loop

You're given a string, and I want you to return the reverse of that string. For example, "Hello" would return "olleH". Try to not use any built in reverse methods, instead do it manually. For an extra challenge, do it in place (don't create an extra string! )

[Solution](solutions/strings/Reverse.java)

### 4. Check if a string is all unique characters.
	
I am going to give you a String, and I want you to check if it only contains unique characters. So "Hello" would return false but "Helo" would return true. Be careful with the edge case of capital letters. BONUS: Do this problem without using an outside data structure. 

[Solution](solutions/strings/UniqueChars.java)


### 5. Check if a string is a palindrome

You are given a String, and I want you to check if that String is a palindrome or not. So "tacocat" would return true but "burritocat" would return false. 

[Solution](solutions/strings/Palindrome.java)


### 6. Check if two Strings are anagarams. 

You are given two Strings, and I want you to check if they are anagrams of each other. Meaning, I want you to check if those two Strings are made up of the same characters. So "Hello" and "elohl" would return true, but "Hello" and "not hello" would return false.  

[Solution](solutions/strings/Anagrams.java)


### 7. Write a method that compresses a String

For example, if you are given the string aaabbbccca you will return a3b3c3a1

[Solution](solutions/strings/Compress.java)

##Array Manipulation:


### 8. Find the second highest integer in an array of integers

EXTRA REQUIREMENT: You CANNOT use Arrays.sort(). 

[Solution](solutions/arrays/SecondHighest.java)


### 9. Given an MxN Matrix (array of arrays), if one element of a row or column is 0, its entire row and column are set to 0

For example, if the input was

```
[[1,2,3,4]
[5,4,0,1]
[2,1,2,4]
[2,3,4,2]]
```
The output would be
```
[[1,2,0,4]
[0,0,0,0]
[2,1,0,4]
2,3,0,2]] 
```

[Solution](solutions/strings/ZeroMatrix.java)

### 10. Given an array of ints move all non zero numbers to the left and zeros to the right. How can you now improve your answer to O(n)? 

For example, if the input was 
```
[6, 4, 0, 5, 0, 0, 0, 1, 0]
```
The output would be
```
[6, 4, 5, 1, 0, 0, 0, 0, 0]
```

[Solution](solutions/arrays/MoveValuesToRight.java)

## Linked Lists: 

### 11. What is the difference between an ArrayList and LinkedList? Implement your own CustomLinkedListImplementation class. 
[Solution](solutions/linked-lists/CustomLinkedListImplementation.java)


### 12: Return the Kth to last element of a LinkedList

As a method of your CustomLinkedList, create a getKthFromLast(int k) method that returns the kth from last element in your list. As a bonus, try to do this in only one go through of your list (as in, don't just go through it to find how many there are in the list and then go through it again and get the kth from last one). 

[Solution](solutions/linked-lists/KthToLast.java)

### 13. Check if there is a loop

Go through your CustomLinkedList and check if there is a loop inside of it. Make sure that your list has a start and an end instead of going in circles for infinity. 

[Solution](solutions/linked-lists/LinkedListLoop.java)


## Stacks and Queues
	
### 14, Implement a Stack.  (requires lesson on what a Stack is)

[Solution](solutions/stacks-queues/CustomStackImplementation.java)

### 15. Implement a Stack with a minimum value variable

[Solution](solutions/stacks-queues/CustomMinStack.java)


### 16. Implement a Queue (requires lesson on what a Queue is)

[Solution](solutions/stacks-queues/CustomQueueImplementation.java)


### 17 Implement a Queue using only 2 stacks 
	
	
[Solution](solutions/stacks-queues/CustomQueueImplementedWithStacks.java)

### 18. Check Parenthesis. 

You are going to be given a string of parenthesis type characters (i.e., {{(([{}]))}}({)}))) and your job is to check whether or not it is properly formated. Meaning () would be true, (]) would be false, ([)] would be false, and ( would be false. 

[Solution](solutions/stacks-queues/CheckParens.java)

## Recursion: 

### 19. Recursively multiply two numbers

[Solution](solutions/recursion/Multiply.java)


### 20. Recursively print out the Fibonacci series. 

[Solution](solutions/recursion/Fibonacci.java)

### 21. Reverse a linked list using recursion.

[Solution] (solutions/recursion/reverselinkedlistrecursion.java)

## Binary Search:

### 22. Implement binary search to find the index of a number in a sorted array. If it does not exist return -1.

[Solution] (solutions/binarysearch/findindex.java)

### 23. Compute and return the square root of a number.

[Solution] (solutions/binarysearch/squareroot.java)

### 24. Given a sorted array of integers, find the number of occurrences of a given target value. 
Example:
Given [5, 7, 7, 8, 8, 10] and target value 8, return 2. If it is not found, return 0.

[Solution] (solutions/binarysearch/sortedarray.java)



		

