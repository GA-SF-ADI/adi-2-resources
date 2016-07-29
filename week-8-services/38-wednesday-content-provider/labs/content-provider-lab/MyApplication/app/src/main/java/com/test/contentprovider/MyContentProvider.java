package com.test.contentprovider;

import android.content.ContentProvider;
import android.net.Uri;

/**
 * Created by Jon Kim on 7/27/16.
 */
public class MyContentProvider extends ContentProvider{
    private DatabaseHelper mHelper;
    private static final String AUTHORITY = "com.test.contentprovider";
    private static final String STOCKS_TABLE = "stocks";

    public static final Uri CONTENT_URI = Uri.parse("content://"
            + AUTHORITY + "/" + STOCKS_TABLE);
}
