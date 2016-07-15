package com.differentdevices.fishtankv9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sterlinggerritz on 7/14/16.
 */
public class Dbase extends SQLiteOpenHelper {
    private static final String NAME = "product_db";
    private static final int DATABASE_VERSION = 1;
    public static final String PRODUCT_LIST_TABLE_NAME = "PRODUCT_LIST";
    public static final String SHOPPING_CART_LIST_TABLE_NAME = "SHOPPING_CART_LIST";

    public static final String COL_ID = "_id";
    public static final String COL_ITEM_NAME = "NAME";
    public static final String COL_ITEM_PRICE = "PRICE";
    public static final String COL_ITEM_DESCRIPTION = "DESCRIPTION";
    public static final String COL_ITEM_RATING = "RATING";
    public static final String COL_ITEM_IMAGE = "IMAGE";
    public static final String COL_ITEM_TYPE = "TYPE";
    public static final String COL_ITEM_QUANTITY = "QUANTITY";
    private static Dbase instance;



    public static final String[] PRODUCT_COLUMNS = {
            COL_ID,
            COL_ITEM_NAME,
            COL_ITEM_DESCRIPTION,
            COL_ITEM_PRICE,
            COL_ITEM_RATING,
            COL_ITEM_IMAGE,
            COL_ITEM_TYPE,

    };

    private static final String CREATE_PRODUCT_LIST_TABLE =
            "CREATE TABLE " + PRODUCT_LIST_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_ITEM_NAME + " TEXT, " +
                    COL_ITEM_DESCRIPTION + " TEXT, " +
                    COL_ITEM_PRICE + " DOUBLE, " +
                    COL_ITEM_RATING + " INTEGER, " +
                    COL_ITEM_IMAGE + " TEXT, " +
                    COL_ITEM_TYPE + " TEXT) ";


    private static final String CREATE_SHOPPING_CART_LIST_TABLE =
            "CREATE TABLE " + SHOPPING_CART_LIST_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY, " +
                    COL_ITEM_QUANTITY + " INTEGER )";


    public Dbase(Context context) {
        super(context, NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL(CREATE_PRODUCT_LIST_TABLE);
        db.execSQL(CREATE_SHOPPING_CART_LIST_TABLE);

        addProduct(db, "Blue Tang",
                "Paracanthurus hepatus has a royal blue body, yellow tail, and black palette design. The lower body is yellow in the west-central Indian Ocean. ",
                123.60,
                1,
                "http://www.reefsecrets.com.au/image/cache/data/blue%20tang-700x700.jpg",
                "Fish");
       addProduct(db, "Trigger", "Triggerfish have an oval shaped, highly compressed body. The head is large, terminating in a small but strong- jawed mouth with teeth adapted for crushing shells. The eyes are small, set far back from the mouth, at the top of the head. The anterior dorsal fin is reduced to a set of three spines. The first spine is stout and by far the longest. All three are normally retracted into a groove. The anal and posterior dorsal fins are capable of undulating from side to side to provide slow speed movement. The sickle shaped caudal fin is used only to escape predators.", 87.99, 5, "http://vignette4.wikia.nocookie.net/endlessocean/images/5/5c/Clown_Triggerfish.jpg/revision/latest?cb=20150730150309", "Fish");
       addProduct(db, "Zoanthid", "Zoanthids (order Zoantharia also called Zoanthidea or Zoanthiniaria) are an order of cnidarians commonly found in coral reefs, the deep sea and many other marine environments around the world. These animals come in a variety of different colonizing formations and in numerous colors. They can be found as individual polyps, attached by a fleshy stolon or a mat that can be created from small pieces of sediment, sand and rock.", 5389.99, 5, "http://www.zoanthids.com/images/SuperSunflowerZoanthids.jpg", "Coral");
      addProduct(db, "Coral Branches", "Coral Branches - Need Description", 20.99, 5, "https://s-media-cache-ak0.pinimg.com/736x/c5/16/b8/c516b8fbad1050230782b85c3edce148.jpg", "Coral");
        addProduct(db, "Frog Spawn", "The Frogspawn coral gets its name from the way the tentacles resemble a clutch of frog eggs.\n ", 32.50, 5, "http://s-media-cache-ak0.pinimg.com/736x/db/b4/5c/dbb45cdf04bf49beb5862712bcc2da77.jpg", "Coral");
        addProduct(db, "Fish Food", "Marine Fish Foods are formulated to provide the best nutrition for saltwater aquarium fish. Satisfy the nutritional needs of your marine fish with our selection of quality foods. Find the right food for your saltwater marine aquarium fish whether herbivore, carnivore or omnivore.Super mix contains every important major, minor and trace element necessary for the health of your aquarium.", 2660.99, 5, "https://coastalreefaquariums.files.wordpress.com/2012/07/newlifespectrum.jpg", "Supply");
        addProduct(db, "Sea Salt", "Super mix contains every important major, minor and trace element necessary for the health of your aquarium", 47.00, 4, "http://petus.imageg.net/PETNA_36/pimg/pPETNA-5046564_main_t300x300.jpg", "Supply");
       addProduct(db, "Test Kit", "API's REEF Master Test Kit measures the most important aquarium levels in a Reef Aquarium. 4 different tests calibrated specifically for Reef aquariums are designed to protect reef-dwellers from dangerous water conditions. Tests include: Calcium, Carbonate Hardness (KH), Phosphate & Nitrate), 4 test tubes, tray.", 10.99, 4, "http://www.fishkeeping.co.il/images/cache/51pQV1sGWYL._SX355_.jpg", "Supply");
        addProduct(db, "Clown Fish", "Clownfish or anemonefish are fishes from the subfamily Amphiprioninae in the family Pomacentridae. Thirty species are recognized: one in the genus Premnas, while the remaining are in the genus Amphiprion. In the wild, they all form symbiotic mutualisms with sea anemones. Depending on species, anemonefish are overall yellow, orange, or a reddish or blackish color, and many show white bars or patches. The largest can reach a length of 18 centimetres (7.1 in), while the smallest barely achieve 10 centimetres (3.9 in).", 21.99, 3, "https://kreaturamedia.com/wp-content/uploads/2013/12/clownfish.png", "Fish");

    }

    public Cursor fishQuery() {

        SQLiteDatabase db = getWritableDatabase();

        String[] condition = {"Fish"};

        String[] coralString = {"_id", "TYPE", "NAME"};
        Cursor cursor = db.query("PRODUCT_LIST",
                coralString," TYPE  = ?", condition,
                null, null, null, null);
        return cursor;
    }

        //same query for coral, except that we only specify rows of type "coral"
    public Cursor coralQuery() {

        SQLiteDatabase db = getReadableDatabase();
        String[] condition = {"Coral"};

        String[] coralString = {"_id", "TYPE", "NAME"};
        Cursor cursor = db.query("PRODUCT_LIST",
                coralString," TYPE  = ?", condition,
                null, null, null, null);
        return cursor;
    }

    //same query for supplies, except that we only specify rows of type "supply"
    public Cursor supplyQuery() {

        SQLiteDatabase db = getReadableDatabase();
        String[] condition = {"Supply"};

        String[] coralString = {"_id", "TYPE", "NAME"};
        Cursor cursor = db.query("PRODUCT_LIST",
                coralString," TYPE  = ?", condition,
                null, null, null, null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + PRODUCT_LIST_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SHOPPING_CART_LIST_TABLE_NAME);
        this.onCreate(db);
    }

    public long addProduct(SQLiteDatabase db, String name, String description, Double price, Integer rating, String image, String type){
        ContentValues values = new ContentValues();
        values.put(COL_ITEM_NAME, name);
        values.put(COL_ITEM_DESCRIPTION, description);
        values.put(COL_ITEM_PRICE, price);
        values.put(COL_ITEM_RATING, rating);
        values.put(COL_ITEM_IMAGE, image);
        values.put(COL_ITEM_TYPE, type);


        long returnId = db.insert(PRODUCT_LIST_TABLE_NAME, null, values);
        return returnId;
    }

    public List<ProductSingleton> getProduct() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(PRODUCT_LIST_TABLE_NAME, // a. table
                PRODUCT_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        cursor.moveToFirst();

        ArrayList<ProductSingleton> list = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            list.add(new ProductSingleton(
                    cursor.getInt(cursor.getColumnIndex(COL_ID)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_NAME)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_DESCRIPTION)),
                    cursor.getDouble(cursor.getColumnIndex(COL_ITEM_PRICE)),
                    cursor.getInt(cursor.getColumnIndex(COL_ITEM_RATING)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_IMAGE)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_TYPE))

            ));
            cursor.moveToNext();
        }
        return list;
    }

    public ProductSingleton getProductById (int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(PRODUCT_LIST_TABLE_NAME, // a. table
                PRODUCT_COLUMNS, // b. column names
                COL_ID + " = ?", // c. selections
                new String[] {String.valueOf(id)}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                "1"); // h. limit

        cursor.moveToFirst();

        ProductSingleton item = null;
        if (!cursor.isAfterLast()) {
            item = new ProductSingleton(
                    cursor.getInt(cursor.getColumnIndex(COL_ID)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_NAME)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_DESCRIPTION)),
                    cursor.getDouble(cursor.getColumnIndex(COL_ITEM_PRICE)),
                    cursor.getInt(cursor.getColumnIndex(COL_ITEM_RATING)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_IMAGE)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_TYPE))

            );
        }
        return item;
    }

    public static Dbase getInstance(Context context) {
        if (instance == null){
            instance = new Dbase(context);
        }
        return instance;
    }

//    public long addProductToCart (int id) {
//        ContentValues values = new ContentValues();
//        values.put(COL_ID, id);
//
//        SQLiteDatabase db = getWritableDatabase();
//        long returnId = db.insert(SHOPPING_CART_LIST_TABLE_NAME, null, values);
//        db.close();
//        return returnId;
//    }
//
//



    public ArrayList searchProductList(String query){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(PRODUCT_LIST_TABLE_NAME, // a. table
                PRODUCT_COLUMNS, // b. column names
                COL_ITEM_NAME + " LIKE ?", // c. selections
                new String[]{"%"+query+"%"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        cursor.moveToFirst();

        ArrayList<ProductSingleton> searchList = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            searchList.add(new ProductSingleton(
                    cursor.getInt(cursor.getColumnIndex(COL_ID)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_NAME)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_DESCRIPTION)),
                    cursor.getDouble(cursor.getColumnIndex(COL_ITEM_PRICE)),
                    cursor.getInt(cursor.getColumnIndex(COL_ITEM_RATING)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_IMAGE)),
                    cursor.getString(cursor.getColumnIndex(COL_ITEM_TYPE))


            ));
            cursor.moveToNext();
        }
        return searchList;
    }
}
