package generalassembly.yuliyakaleda.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.annotation.Nullable;

/**
 * Created by jeanweatherwax on 7/26/16.
 */

//Extend ContentProvider
public class MyContentProvider extends ContentProvider {

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        return null;
    }

    /**Create our Content Provider, add static Strings*/
    private MyDBHandler myDB;
    private static final String AUTHORITY = "com.example.database.provider.MyContentProvider";
    private static final String PRODUCTS_TABLE = "products";
    public static final Uri CONTENT_URI = Uri.parse("content://"
            + AUTHORITY + "/" + PRODUCTS_TABLE);

    public static final int PRODUCTS = 1;
    public static final int PRODUCTS_ID = 2;

    /**Create URI matcher and add URIs */
    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sURIMatcher.addURI(AUTHORITY, PRODUCTS_TABLE, PRODUCTS);
        sURIMatcher.addURI(AUTHORITY, PRODUCTS_TABLE + "/#", PRODUCTS_ID);
    }



    /**Get DBHandler in onCreate */
    @Override
    public boolean onCreate() {
        return false;
    }

    /**Override insert */
    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        int uriType = sURIMatcher.match(uri);

        long id = 0;
        switch (uriType) {
            case PRODUCTS:
                id = myDB.addProduct(contentValues);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return Uri.parse(PRODUCTS_TABLE + "/" + id);
    }
    /**Override query */
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, CancellationSignal cancellationSignal) {
        int uriType = sURIMatcher.match(uri);
        Cursor cursor = null;

        switch (uriType) {
            case PRODUCTS_ID:
                cursor = myDB.findProductById(uri.getLastPathSegment());
                break;
            case PRODUCTS:
                cursor = myDB.findProductByName(selection);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI");
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;    }

    /** Override getType */
    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }
    /** Override update */
    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        int uriType = sURIMatcher.match(uri);
        int rowsUpdated = 0;

        switch (uriType) {
            case PRODUCTS:
                rowsUpdated = myDB.updateProduct(contentValues,s,null);
                break;
            case PRODUCTS_ID:
                String id = uri.getLastPathSegment();
                rowsUpdated = myDB.updateProduct(contentValues,null,id);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return rowsUpdated;
    }
    /** Override delete */
    @Override
    public int delete(Uri uri, String s, String[] strings) {
        int uriType = sURIMatcher.match(uri);
        SQLiteDatabase sqlDB = myDB.getWritableDatabase();
        int rowsDeleted = 0;

        switch (uriType) {
            case PRODUCTS:
                rowsDeleted = myDB.deleteProductByName(s);
                break;

            case PRODUCTS_ID:
                String id = uri.getLastPathSegment();
                rowsDeleted = myDB.deleteProductById(id);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return rowsDeleted;
    }
}
