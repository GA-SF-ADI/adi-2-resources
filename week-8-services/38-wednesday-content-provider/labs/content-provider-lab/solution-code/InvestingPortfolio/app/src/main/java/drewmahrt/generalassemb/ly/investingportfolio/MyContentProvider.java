package drewmahrt.generalassemb.ly.investingportfolio;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

public class MyContentProvider extends ContentProvider {

  private MyDBHandler myDB;
  private static final String AUTHORITY = "drewmahrt.generalassemb.ly.investingportfolio.MyContentProvider";
  private static final String STOCKS_TABLE = "stocks";
  public static final Uri CONTENT_URI = Uri.parse("content://"
      + AUTHORITY + "/" + STOCKS_TABLE);

  public static final int STOCKS = 1;
  public static final int STOCKS_ID = 2;
  public static final int STOCKS_SYMBOLS = 3;

  private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

  static {
    sURIMatcher.addURI(AUTHORITY, STOCKS_TABLE, STOCKS);
    sURIMatcher.addURI(AUTHORITY, STOCKS_TABLE + "/#", STOCKS_ID);
    sURIMatcher.addURI(AUTHORITY, STOCKS_TABLE + "/symbols", STOCKS_SYMBOLS);
  }

  @Override
  public boolean onCreate() {
    myDB = new MyDBHandler(getContext(), null, null, 1);
    return false;
  }

  @Override
  public Uri insert(Uri uri, ContentValues values) {
    int uriType = sURIMatcher.match(uri);

    long id = 0;
    switch (uriType) {
      case STOCKS:
        id = myDB.addStock(values);
        break;
      default:
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }
    getContext().getContentResolver().notifyChange(uri, null);
    return Uri.parse(STOCKS_TABLE + "/" + id);
  }

  @Override
  public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
    int uriType = sURIMatcher.match(uri);
    Cursor cursor = null;

    switch (uriType) {
      case STOCKS_ID:
        break;
      case STOCKS:
        cursor = myDB.getStocks(selection);
        break;
      case STOCKS_SYMBOLS:
        cursor = myDB.getStockSymbols(selection);
        break;
      default:
        throw new IllegalArgumentException("Unknown URI");
    }

    cursor.setNotificationUri(getContext().getContentResolver(), uri);
    return cursor;
  }

  @Nullable
  @Override
  public String getType(Uri uri) {
    return null;
  }


  @Override
  public int delete(Uri uri, String selection, String[] selectionArgs) {

    int uriType = sURIMatcher.match(uri);
    SQLiteDatabase sqlDB = myDB.getWritableDatabase();
    int rowsDeleted = 0;

    switch (uriType) {
      case STOCKS:
        break;
      case STOCKS_ID:
        String id = uri.getLastPathSegment();
        rowsDeleted = myDB.deleteStockById(id);
        break;
      default:
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }
    getContext().getContentResolver().notifyChange(uri, null);
    return rowsDeleted;
  }

  @Override
  public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
    return 0;
  }
}
