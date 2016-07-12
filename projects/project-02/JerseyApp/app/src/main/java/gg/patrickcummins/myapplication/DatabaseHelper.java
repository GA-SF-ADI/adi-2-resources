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
//TODO:Implement Cart Table
public class DatabaseHelper extends SQLiteOpenHelper {
    private static DatabaseHelper INSTANCE;

    private static final String CREATE_PLAYER_TABLE = "CREATE TABLE " + PlayerValues.TABLE_NAME + " (" + PlayerValues._ID + " INTEGER PRIMARY KEY, " + PlayerValues.NAME + " TEXT, " + PlayerValues.TEAM + " TEXT, " + PlayerValues.NUMBER + " INTEGER, " + PlayerValues.POSITION + " TEXT, " + PlayerValues.PICTURE + " INTEGER, " + PlayerValues.JERSEY1 + " INTEGER, " + PlayerValues.JERSEY2 + " INTEGER, " + PlayerValues.JERSEY3 + " INTEGER)";
    private static final String CREATE_CART_TABLE = "CREATE TABLE " + CartValues.TABLE_NAME + " (" + CartValues._ID + " INTEGER PRIMARY KEY, " + CartValues.PLAYERNAME + " TEXT, " + CartValues.COLOR + " TEXT, " + CartValues.PICTURE + " INTEGER, " + CartValues.PRICE + " REAL)";

    private static final String DROP_PLAYER_TABLE = "DROP TABLE IF EXISTS " + PlayerValues.TABLE_NAME;
    private static final String DROP_CART_TABLE = "DROP TABLE IF EXISTS " + CartValues.TABLE_NAME;

    public static abstract class PlayerValues implements BaseColumns {
        public static final String TABLE_NAME = "PlayerTable";
        public static final String NAME = "Name";
        public static final String NUMBER = "Number";
        public static final String POSITION = "Position";
        public static final String TEAM = "Team";
        public static final String PICTURE = "PlayerPicture";
        public static final String JERSEY1 = "Jersey1";
        public static final String JERSEY2 = "Jersey2";
        public static final String JERSEY3 = "Jersey3";
    }

    public static abstract class CartValues implements BaseColumns {
        public static final String TABLE_NAME = "CartTable";
        public static final String PICTURE = "JerseyPicture";
        public static final String PLAYERNAME = "Player Name";
        public static final String PRICE = "Price";
        public static final String COLOR = "Color";

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
        db.execSQL(CREATE_CART_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_PLAYER_TABLE);
        db.execSQL(DROP_CART_TABLE);
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
        values.put(PlayerValues.JERSEY1, player.getJersey1());
        values.put(PlayerValues.JERSEY2, player.getJersey2());
        values.put(PlayerValues.JERSEY3, player.getJersey3());


        db.insertOrThrow(PlayerValues.TABLE_NAME, null, values);
        db.close();

    }

    public void insertCartRow(CartItem cartItem) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CartValues.PLAYERNAME, cartItem.getPlayerName());
        values.put(CartValues.COLOR, cartItem.getColor());
        values.put(CartValues.PICTURE, cartItem.getPicture());
        values.put(CartValues.PRICE, cartItem.getPrice());

        db.insertOrThrow(CartValues.TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<Player> getTeamPlayerList(String team) {
        ArrayList<Player> playerArrayList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "";
        if (team.equals("warriors")) {
            query = "SELECT " + PlayerValues.NAME + ", " + PlayerValues.POSITION + ", " + PlayerValues.NUMBER + ", " + PlayerValues.PICTURE + ", " + PlayerValues.JERSEY1 + ", " + PlayerValues.JERSEY2 + ", " + PlayerValues.JERSEY3 + ", " + PlayerValues.TEAM + " FROM " + PlayerValues.TABLE_NAME + " WHERE " + PlayerValues.TEAM + "='warriors'";
        } else if (team.equals("raiders")) {
            query = "SELECT " + PlayerValues.NAME + ", " + PlayerValues.POSITION + ", " + PlayerValues.NUMBER + ", " + PlayerValues.PICTURE + ", " + PlayerValues.JERSEY1 + ", " + PlayerValues.JERSEY2 + ", " + PlayerValues.JERSEY3 + ", " + PlayerValues.TEAM + " FROM " + PlayerValues.TABLE_NAME + " WHERE " + PlayerValues.TEAM + "='raiders'";
        } else if (team.equals("sharks")) {
            query = "SELECT " + PlayerValues.NAME + ", " + PlayerValues.POSITION + ", " + PlayerValues.NUMBER + ", " + PlayerValues.PICTURE + ", " + PlayerValues.JERSEY1 + ", " + PlayerValues.JERSEY2 + ", " + PlayerValues.JERSEY3 + ", " + PlayerValues.TEAM + " FROM " + PlayerValues.TABLE_NAME + " WHERE " + PlayerValues.TEAM + "='sharks'";
        }

        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            playerArrayList.add(new Player(cursor.getString(cursor.getColumnIndex(PlayerValues.NAME)), cursor.getString(cursor.getColumnIndex(PlayerValues.POSITION)), cursor.getInt(cursor.getColumnIndex(PlayerValues.NUMBER)), cursor.getInt(cursor.getColumnIndex(PlayerValues.PICTURE)), cursor.getString(cursor.getColumnIndex(PlayerValues.TEAM)), cursor.getInt(cursor.getColumnIndex(PlayerValues.JERSEY1)), cursor.getInt(cursor.getColumnIndex(PlayerValues.JERSEY2)), cursor.getInt(cursor.getColumnIndex(PlayerValues.JERSEY3))));

        }
        cursor.close();
        return playerArrayList;
    }

    public ArrayList<Integer> getPlayerJerseysList(String playerName) {
        ArrayList<Integer> jerseyList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT " + PlayerValues.JERSEY1 + ", " + PlayerValues.JERSEY2 + ", " + PlayerValues.JERSEY3 + " FROM " + PlayerValues.TABLE_NAME + " WHERE " + PlayerValues.NAME + " = " + "'" + playerName + "'";
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            jerseyList.add(cursor.getInt(cursor.getColumnIndex(PlayerValues.JERSEY1)));
            jerseyList.add(cursor.getInt(cursor.getColumnIndex(PlayerValues.JERSEY2)));
            jerseyList.add(cursor.getInt(cursor.getColumnIndex(PlayerValues.JERSEY3)));

        }
        return jerseyList;
    }

    public ArrayList<CartItem> getCartItemArrayList() {
        ArrayList<CartItem> cartItemArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT " + CartValues.PLAYERNAME + ", " + CartValues.COLOR + ", " + CartValues.PRICE + ", " + CartValues.PICTURE + " FROM " + CartValues.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            CartItem cartItem = new CartItem(cursor.getString(cursor.getColumnIndex(CartValues.PLAYERNAME)), cursor.getString(cursor.getColumnIndex(CartValues.COLOR)), cursor.getInt(cursor.getColumnIndex(CartValues.PICTURE)), cursor.getDouble(cursor.getColumnIndex(CartValues.PRICE)));
            cartItemArrayList.add(cartItem);
        }
        cursor.close();
        return cartItemArrayList;
    }


}
