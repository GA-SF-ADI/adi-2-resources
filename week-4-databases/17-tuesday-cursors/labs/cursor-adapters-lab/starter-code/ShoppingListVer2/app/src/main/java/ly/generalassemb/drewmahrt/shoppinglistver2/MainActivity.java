package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;

import ly.generalassemb.drewmahrt.shoppinglistver2.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity {

    private static final String DATABASE_NAME = "SHOPPING_DB";
    private static final int DATABASE_VERSION = 7;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

    }

    public DBAssetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
}
