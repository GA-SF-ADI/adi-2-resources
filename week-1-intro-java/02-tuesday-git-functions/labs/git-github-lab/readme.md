---
title: Git and GitHub Intro Lab
type: Lab
duration: "1.25"
creator:
    name: Jay Nappy
    city: NYC
competencies: Workflow
---

# Git and GitHub Intro Lab

## Introduction

> ***Note:*** _This can be a pair programming activity or done independently._

Let's apply what we've learned from class to share and update each other's code.  With a partner, you're going going to alternate between who 'drives' and who 'navigates' while following the requirements under "Exercise" below. The goal will be to create a project, have a partner fork, clone, and edit the project, submit the changes as a pull request, and then have the changes merged.  

Be sure to look at the previous lesson for notes and helpful hints.

## Exercise

Partners will be referred to as partner1 and partner2.

### Part 1

**With partner1 driving:**

- create a repo on github called `git-and-github-practice`
- clone your `git-and-github-practice` repo to your desktop and `cd` into this new repo folder on your desktop
- within that folder create a new IntelliJ Project, make sure to check-off `Create project from template` option on the second screen.
- in the `Main.java` class, add `int` variables `one`, `two`, and `three`. Then assign some values to them.
- stage and commit your changes
- push to GitHub


**With partner2 driving, from their computer:**

- get your partners link to the GitHub repository and fork it. Next, clone the repository to your desktop.
- open the project inside IntelliJ by pressing the `open` button or `file -> open` if you have another project open.
- open `Main.java` file 
    - add three member variables of type `String` called `string1`, `string2`, and `string3`.
    - Assign some values to each of the variables.
- cd into your cloned repo folder on your desktop
- stage your changes
- commit your changes 
- push your changes to your remote github fork
- go to github.com and create a pull request from your fork back to partner1


**With partner1 driving:**

- merge the pull request from the GitHub interface



### Part 2

**With partner2 driving**:

- create a new repo called `git-and-github-practice-two`
- clone your `git-and-github-practice-two` repo to your desktop and `cd` into this new repo folder on your desktop
- within that folder create a new IntelliJ Project, make sure to check-off `Create project from template` option on the second screen. 
- copy and paste the code from the pull request you sent your partner (of your partners `git-and-github-practice` project) from each of the appropriate files to your own
- stage your changes
- commit your changes
- push your changes to your remote GitHub repo

> Note: Partner2 should now have the solution from Part 1 locally

**With partner1 driving:**

- get your partner's link to the new GitHub repository - fork it. 
- clone your fork to your desktop.
- `cd` into your cloned repo on your desktop.
- open the project and make the main method, in the `Main.java` class, print "Hello World".
- stage your changes
- commit your changes 
- push your changes to your remote fork on GitHub
- go to github.com and create a pull request from your fork back to partner2


**With partner2 driving:**

- merge the pull request from the GitHub interface

**Bonus**:

- use the [syncing a fork](https://help.github.com/articles/syncing-a-fork/) documentation to update partner2's local version of `git-and-github-practice` without copying and pasting any code
- push the updated local copy to GitHub


#### Deliverable

You should have two separate GitHub repositories that have merged pull requests.

## Additional Resources

- [Git documentation](https://git-scm.com/documentation)
- [Forking on github](https://help.github.com/articles/fork-a-repo/)
- [Syncing a fork](https://help.github.com/articles/syncing-a-fork/)
