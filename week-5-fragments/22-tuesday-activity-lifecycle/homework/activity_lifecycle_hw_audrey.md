July 5, 2016
Activity Lifecycle Review HW

# 1
1. Create - this happens when you first open the app (place where things for the app are made)
2. Start - visible to the user
3. Resume - user can use it during this time
4. Pause - visible to the user, but it's faded in the background
5. Stop - hidden from the user, but not destroyed
6. Destroy- app has to be restarted again to be used again

# 2
Flow chart of the Android Activity Lifecycle



# 3

1. In onCreate(), the app and the activity data is set up. It is in the preparation stage.
2. In "Start" stage, the activity is visible to the user, but CANNOT be interacted with yet.
3. In the "Resume" stage, the activity is FULLY running and it's ready for the user to use it. The user
can interact with it.
4.In the "Paused" stage, the activity is visible in the background, but another activity (such as an alert, etc.) is 
covering it. It CANNOT be interacted with. **** NOTE: before the activity can be interacted with again, the user
has to resume it.
5. In the "Stopped" stage, the activity is totally hidden from the user. For example, the user could have
stopped the activity by returning to the home screen or perhaps by launching a different application.
6. In the "Destroyed" stage, the activity must be totally recreated to be used again. 