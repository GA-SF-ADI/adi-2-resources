package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sterlinggerritz on 7/8/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String DB_NAME = "soulsisters"; //name of db
    private static final int DB_VERSION=1; //the first version

    @Override

            public void OnCreate(SQLiteDatabase db) {
        SQLiteDatabase.execSQL(String sql); //execute the SQL in the string on my database
        db.execSQL("CREATE TABLE FOOD ("+"_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "NAME TEXT, " + "DESCRIPTION TEXT, " + "IMAGE_RESOURCE_ID INTEGER);" );
   //since I am about to use the insert() method to populate the database I have to specify
        //the name of the table I am inserting and also the values I am inserting.
        //I say the values by creating a ContentValuesObject:

        ContentValues foodValues = new ContentValues(); //holds name and value pairs of data
         //now i use put() to add data to the object.
        foodValues.put("Name", "Vegan Macaroni and Cheese");
        foodValues.put("Description", )


    }
    }

}
