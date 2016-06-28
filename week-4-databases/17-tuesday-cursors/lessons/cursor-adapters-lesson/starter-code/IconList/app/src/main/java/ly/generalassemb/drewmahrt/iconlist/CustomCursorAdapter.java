package ly.generalassemb.drewmahrt.iconlist;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hollis on 6/28/16.
 */
public class CustomCursorAdapter extends CursorAdapter {

    public CustomCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }
///CREATES OUR VIEW
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.icon_list_item, parent, false);
    }
///SETS THE VIEWS TO THE ITEM AT OUR CURRENT CURSOR POSITION
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textView = (TextView) view.findViewById(R.id.icon_name_text_view);
        ImageView imageView = (ImageView) view.findViewById(R.id.icon_image_view);

        String icon = cursor.getString(cursor.getColumnIndex(IconSQLiteOpenHelper.COL_ICON_NAME));

        textView.setText(icon);
        imageView.setImageResource(MainActivity.getDrawableValue(icon));
    }
}
