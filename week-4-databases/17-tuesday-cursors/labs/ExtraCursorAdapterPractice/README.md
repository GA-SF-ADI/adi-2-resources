# Extra Cursor Adapter Practice! 

This is going to be some extra practice using Cursors, SQliteOpenHelper, and CursorAdapters (both simple and custom!)

## Refactoring

We have supplied you with some simple starter code using an ArrayAdapter to hold a list of Animal Objects. What we want you to do is refactor this code so you can use a database and a cursor adapter to make it so your data persists between sesssions! 

This means, we want you to 

-implement your own SqliteOpenHelper
-turn the array adapter into a cursor adapter
-change the add button functionality to add the new animal to the database
-change the onItemClickListener to remove the item from your database

You can use a SimpleCursorAdapter for now, but feel free to go the extra mile and create your own CustomCursorAdapter! 

