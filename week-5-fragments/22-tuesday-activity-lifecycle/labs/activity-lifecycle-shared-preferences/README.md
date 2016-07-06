# Shared Preferences Lab

## Shared Preferences

We just learned a lot about saving preferences, and this lab will be going over two different ways that using Shared Preferences is useful. 

First, you can see that we are inserting data into our database inside of the onCreate method. The problem with this is that the data will keep on being inserted into your database every time. We want you to use shared preferences to figure out how to only load the data the very first time your app is created.

The second is a problem with settings, there are three different temperatures that can be read from the database. I want you to use shared preferences to make it so the last temperature type that was displayed is loaded when the app is resumed. So if I had last pressed the Celsius button to be displaying the temperature in Celsius, the next time I load the app it should load as Celsius. 
 
## TO DO

1. Use Shared Preferences to only insert data into the database 1 time
2. Use Shared Preferences to save the last chosen temperature type. 

### Bonus
You can see that the starter code repeats itself a lot. Try and find places where there is repitition and clean it up. 

