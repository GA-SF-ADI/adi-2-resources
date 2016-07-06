# Activity Lifecycle Review

The Android Activity Lifecycle is a very fundamental concept of Android development, and it's a great idea to understand this well, both for development and for interview preparation. Understanding this cycle and the states of activites will help you write better, more efficient code, and also help you understand the Android platform as a whole.

Please complete the following: 

1. Without looking at references, first list out the Android Activity Lifecycle methods (in order), and to the best of your knowledge write the meaning of each method. 
<<<<<<< HEAD
OnCreate() > OnStart() > OnResume() > OnPause() > OnStop() > OnDestroy()

on create: first thing called when activity starts

on start: called after on create.  can be overriden for specific tasks before the activity becomes visible.

on resume: This happens when the activity first becomes visible to the user

on pause: called when system is about to put the activity in the background

on stop: called when the activity is no longer visible to the user, stuff still stored in memory

on destroy: called when activity is no longer needed.  stuff is purged from the memory

2. Without looking at references, draw out a flow chart of the Android Activity lifecycle.

onCreate()-------> onStart()-------------> onResume()-----------> onPause() ---------------> onStop()-------------> onDestroy()

3. Now, go back to your notes/the course material references, and check your work, and rework any parts you may have missed or had out of order. Walk yourself through the launching of an Activity, and navigation through to a second activity, and the back to the Main activity. What lifecycle steps occur? What happens if you kill the app and reopen it?

Done, everything is checked and reworked.    When I re-opened the app the time was still there...

=======

2. Without looking at references, draw out a flow chart of the Android Activity lifecycle.

3. Now, go back to your notes/the course material references, and check your work, and rework any parts you may have missed or had out of order. Walk yourself through the launching of an Activity, and navigation through to a second activity, and the back to the Main activity. What lifecycle steps occur? What happens if you kill the app and reopen it?

>>>>>>> 49c2ef63d43f372c33bab8d65827ee6d3758caf1


