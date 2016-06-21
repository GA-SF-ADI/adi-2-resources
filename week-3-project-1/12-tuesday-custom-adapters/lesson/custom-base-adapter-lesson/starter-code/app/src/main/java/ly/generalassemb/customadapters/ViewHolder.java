package ly.generalassemb.customadapters;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by kitty on 6/21/16.
 */
public class ViewHolder {
    TextView firstTV;
    TextView secondTV;
    Button button;

    public ViewHolder(View itemLayout) {
        this.firstTV = (TextView) itemLayout.findViewById(R.id.list_item_tv_first);
        this.secondTV = (TextView) itemLayout.findViewById(R.id.list_item_tv_second);
        this.button = (Button) itemLayout.findViewById(R.id.list_item_button);
    }
}
