#Solution Code

One Last Walkthrough on how to use intents to start an activity for result
## In your starting (In our case, Main) Activity
Step 1. Make your intent. This follows the pattern 
	```Intent intent = new Intent(CurrentActivity.this, TargetActivity.class)```
	
Step 2. Put any data you want into your intent. Use intent.putExtra(key, value) to put all of your data into the intent. This step is optional, you only need to do it if you want to send data to the next activity.

Step 3. Define your request code as a public member variable. Basically, add this line of code to the top of your activity. 
```public static final int REQUEST_CODE = Some number```
	You can make the request code be whatever you want.
	
Step 4. Start your activitiy for result using the startActivityForResult method. It will look like this
```startActivityForResult(REQUEST_CODE, intent)```

## In the Second Activity

Step 5. Now, we can grab any data from the intent that we want. The first thing to do is get intent. This follows the pattern
```Intent recievedIntent = getIntent();```

Step 6. Now, grab your data from the intent. This is similar to a HashMap, and follows the pattern
```DataType variableName = recievedIntent.getDataTypeExtra(key)```
Where DataType would be your variable type, so String, or int, or boolean, or whatever you put in, variableName is what you want to call your variable, and key is the key you specified in the starting activity. Only run this step if you put data into your first intent! 

Step 7. Now lets prepare the onClickListener to send the result back. First thing is to just create a new OnClickListener

Step 8. Once we are inside of the onClickListener, the first step is to create your intent to send data back. We juts need to create an empty intent, so follow the pattern
```Intent resultIntent = new Intent();```

Step 9. Now, put any data we want to send back into this intent. This is exactly the same as with the other intent, just use the putExtra method! 

Step 10. Finally, set the result! This follows the pattern
```setResult(RESULT_OK, resultIntent);```
You don't need to worry about defining the result code, RESULT_OK is a variable that Android defined for you and that you should use in this case.

Step 11. Now we're done with this activity! The last thing you need to do is call the finish() function to end the activity and go back

##First Activity Again

Step 12. Now we're back in the starting activity! The first thing we need to do is Override the onActivityResult method, as that is the method Android gives activities to handle having started an activity for result. To do this, click outside of the onCreate method but inside of your activity class and hit command N. Then, select OverRide methods, and choose onActivityResult. It should autopopulate something that looks like
```  
@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
} 
```
Here is where we want to check the result of our activity. 

Step 13. First, we want to check that we are handling the correct request code. This is a simple if statement
```if(requestCode == REQUEST_CODE)```
Just check that the request code you get back in your onActivityResult method matches your coded Request Code. 

Step 14. Now, result code
```if(resultCode == RESULT_OK)```

Step 15. Finally, you have your intent that you passed forward. you can pull your information out of the data intent using the getVariableTypeExtra method! 

That's it! Let me know if you have any more questions!
