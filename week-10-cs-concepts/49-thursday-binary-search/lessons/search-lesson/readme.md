---
title: Linear and Binary Search
type: lesson
duration: "1:15"
creator: James Davis (NYC)

---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Linear and Binary Search Lesson

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Compare binary search with linear search strategies
- Use a binary search to search through an array or a tree

---
## Opening (5 mins)

Searching is a very important part of development. It's used in many applications, websites, etc.


Let's use Google as an example (it will be a recurring theme throughout this lesson). Google's sole purpose, originally, was to search through websites given a particular criteria.

There are many ways to search for particular items in a set of data. Today, I'm going to introduce a couple of ways: the brute-forcey (but still useful!) *Linear Search* and the more common *Binary Search*.


## Introduction: Linear Search (15 mins)

#### Solidify the concepts

*Close your laptops when doing this exercise.*

For the next 4 minutes, talk to the person next to you and try to figure how to do the following:

Given an array of random numbers, search for a particular number.

*Note:* This is a conceptual exercise; do not write this in Java!  Use your desks or the walls.


#### Brute forcing our way to the top!

So, the easiest way to search for something is to do a linear search.

The idea is to go through each item, one at a time, and checking if it is the droid you are looking for.

Here's some pseudocode for searching for a number in an array of numbers:

```
int linearSearch(int[] array) {
	for each number in array {
		does number equal array[position]?
			Yes: return position
	}

	if number was not found in array, return -1
}
```


<a name="guided-practice"></a>
#### Guided Practice: Linear Search (10 minutes)

Let's discuss and write out the steps to perform a search on this array:

12, -3, 5, 6, 3, 3, 0, -33, 6, 9, 12, 2

The goal: Find the number *9*.

## Introduction: Binary Search (15 mins)

#### Solidify the concepts

I'm thinking of a number between 60 and 80. Try to guess what number it is. I'll give you no context.

Alright, let's try it again. I'll give you context clues this time about whether it is higher or lower.

The latter is one of the ideas behind a binary search!

#### Binary Searching

The idea is interesting. If you have a sorted list of numbers, you can *divide and conquer* the set of numbers again and again until you find the answer:

First, you divide the set of numbers in half and look at the middle element in the sorted array. Is the number you are looking for higher or lower than the number you are looking at right now? If it's lower, look at the numbers before the number. Otherwise, look at the higher numbers.

You just eliminated half of the possibilities!

So then you do it again but now, just with the numbers left over. Rinse and repeat until you have one number left, the one you are looking for (or not).

<a name="guided-practice"></a>
#### Guided Practice: Linear Search (10 minutes)

Let's discuss and write out the steps to perform a binary search using this array:

12, -3, 5, 6, 3, 3, 0, -33, 6, 9, 12, 2

The goal: Let's try finding the number *9*, again.


<a name="independent-practice"></a>
#### Independent Practice: Pseudocode and Java (20 minutes)

For the next 20 minutes, write pseudocode for the binary search on that array. Then, try writing it out in Java.


<a name="conclusion"></a>
## Conclusion (5 mins)

- Since binary search only works on sorted arrays, what are the pros and cons of this method?
