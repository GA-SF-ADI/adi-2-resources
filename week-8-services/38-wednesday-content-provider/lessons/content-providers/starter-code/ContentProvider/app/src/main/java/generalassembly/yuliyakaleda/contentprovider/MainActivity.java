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
  //get a contentResolver
    ContentResolver contentResolver = getContentResolver();
    //use insert method from content provider
    ContentValues values = new ContentValues();
    values.put("productname", mInputName.getText().toString());
    values.put("quantity", mInputQuantity.getText().toString());
    Uri uri = contentResolver.insert(CONTENT_URI, values);
    mResultTextView.setText(mInputName.getText().toString());
  }

  public void lookupProduct () {
    final String name = mInputName.getText().toString();
    int quantity = getProductCount(name);

    if (quantity == 0) {
      mResultTextView.setText("That product cannot be found");
    } else {
      mResultTextView.setText(name+ " count: "+quantity);
    }
  }

  public int getProductCount(String name){
    ContentResolver contentResolver = getContentResolver();
    Cursor cursor = contentResolver.query(CONTENT_URI,null,"productname = '"+ name +"'",null,null);
    int quantity = 0;
    if(cursor.moveToFirst()){
      quantity = cursor.getInt(cursor.getColumnIndex("quantity"));
    }
    return quantity;
  }

  public void removeProduct () {
    String name = mInputName.getText().toString();
    ContentResolver contentResolver = getContentResolver();
    int rowsDeleted = contentResolver.delete(CONTENT_URI,"productname = '"+name+"'",null);
    if (rowsDeleted > 0) {
      mResultTextView.setText("Product deleted");
    } else
      mResultTextView.setText("That product cannot be found");
  }

  public void updateProduct(){
    ContentResolver contentResolver = getContentResolver();
    ContentValues values = new ContentValues();
    values.put("quantity",mInputQuantity.getText().toString());
    int rowsUpdated = contentResolver.update(CONTENT_URI,values,"productname = '"+mInputName.getText().toString()+"'",null);

    if(rowsUpdated > 0)
      mResultTextView.setText(mInputName.getText().toString()+ " has been updated!");
    else
      mResultTextView.setText("That product cannot be found");
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
