package gg.patrickcummins.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;

/**
 * Created by patrickcummins on 7/9/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static DatabaseHelper INSTANCE;

    private static final String CREATE_PLAYER_TABLE = "CREATE TABLE " + PlayerValues.TABLE_NAME + " (" + PlayerValues._ID + " INTEGER PRIMARY KEY, " + PlayerValues.NAME + " TEXT, " + PlayerValues.TEAM + " TEXT, " + PlayerValues.NUMBER + " INTEGER, " + PlayerValues.POSITION + " TEXT, " + PlayerValues.PICTURE + " INTEGER)";
    private static final String DROP_PLAYER_TABLE = "DROP TABLE IF EXISTS " + PlayerValues.TABLE_NAME;

    public static abstract class PlayerValues implements BaseColumns {
        public static final String TABLE_NAME = "PlayerTable";
        public static final String NAME = "Name";
        public static final String NUMBER = "Number";
        public static final String POSITION = "Position";
        public static final String TEAM = "Team";
        public static final String PICTURE = "PlayerPicture";
    }

    private DatabaseHelper(Context context) {
        super(context, "db", null, 1);

    }

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseHelper(context);
        }
        return INSTANCE;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PLAYER_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_PLAYER_TABLE);
        onCreate(db);
    }

    public void insertPlayerRow(Player player) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PlayerValues.NAME, player.getName());
        values.put(PlayerValues.TEAM, player.getTeam());
        values.put(PlayerValues.NUMBER, player.getNumber());
        values.put(PlayerValues.PICTURE, player.getPlayerPicture());
        values.put(PlayerValues.POSITION, player.getPosition());

        db.insertOrThrow(PlayerValues.TABLE_NAME, null, values);
        db.close();

    }

    public ArrayList<Player> getTeamPlayerList(String team) {
        ArrayList<Player> playerArrayList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "";
        if (team.equals("warriors")) {
            query = "SELECT " + PlayerValues.NAME + ", " + PlayerValues.POSITION + ", " + PlayerValues.NUMBER + ", " + PlayerValues.PICTURE + ", " + PlayerValues.TEAM + " FROM " + PlayerValues.TABLE_NAME + " WHERE " +PlayerValues.TEAM + "='warriors'";
        } else if (team.equals("raiders")) {
            query = "SELECT " + PlayerValues.NAME + ", " + PlayerValues.POSITION + ", " + PlayerValues.NUMBER + ", " + PlayerValues.PICTURE + ", " + PlayerValues.TEAM + " FROM " + PlayerValues.TABLE_NAME + " WHERE " +PlayerValues.TEAM + "='raiders'";
        } else if (team.equals("sharks")) {
            query = "SELECT " + PlayerValues.NAME + " FROM " + PlayerValues.TABLE_NAME + " WHERE " +PlayerValues.TEAM + "='sharks'";
        }

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(PlayerValues.NAME));
            String position = cursor.getString(cursor.getColumnIndex(PlayerValues.POSITION));
            playerArrayList.add(new Player(cursor.getString(cursor.getColumnIndex(PlayerValues.NAME)), cursor.getString(cursor.getColumnIndex(PlayerValues.POSITION)), cursor.getInt(cursor.getColumnIndex(PlayerValues.NUMBER)), cursor.getInt(cursor.getColumnIndex(PlayerValues.PICTURE)), cursor.getString(cursor.getColumnIndex(PlayerValues.TEAM))));

        }
        cursor.close();
        return playerArrayList;
    }


}
