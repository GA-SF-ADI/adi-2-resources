package generalassembly.yuliyakaleda.contentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
  public static final Uri CONTENT_URI = Uri.parse("content://generalassembly.yuliyakaleda.contentprovider.MyContentProvider/products");

  private EditText mInputName;
  private EditText mInputQuantity;
  private TextView mResultTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button add = (Button) findViewById(R.id.add_button);
    Button find = (Button) findViewById(R.id.find_button);
    Button delete = (Button) findViewById(R.id.delete_button);
    Button update = (Button) findViewById(R.id.update_button);

    add.setOnClickListener(this);
    find.setOnClickListener(this);
    delete.setOnClickListener(this);
    update.setOnClickListener(this);

    mInputName = (EditText) findViewById(R.id.input_name);
    mInputQuantity = (EditText) findViewById(R.id.input_quantity);
    mResultTextView = (TextView) findViewById(R.id.result);
  }

  //Use content provider's methods!
  public void addProduct () {
    ContentResolver contentResolver = getContentResolver();
    ContentValues contentValues = new ContentValues();
    contentValues.put("productname",mInputName.getText().toString());
    contentValues.put("quantity",mInputQuantity.getText().toString());
    contentResolver.insert(CONTENT_URI,contentValues);
  }

  public void lookupProduct () {
    String name = mInputName.getText().toString();

  }

  public void removeProduct () {

  }

  public void updateProduct(){

  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.add_button:
        addProduct();
        break;
      case R.id.find_button:
        lookupProduct();
        break;
      case R.id.delete_button:
        removeProduct();
        break;
      case R.id.update_button:
        updateProduct();
        break;
      default:
        break;
    }
  }
}
