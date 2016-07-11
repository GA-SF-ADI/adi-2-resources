package ly.generalassemb.drewmahrt.overridingexample;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.IntDef;
import android.widget.Toast;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by drewmahrt on 1/27/16.
 */
public class MyCustomToast extends Toast {
    public @interface Duration {}

    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     */
    public MyCustomToast(Context context) {
        super(context);
    }


    public static Toast makeText(Context context, CharSequence text, @Duration int duration) {
        return Toast.makeText(context, "My custom toast: "+text, duration);

    }
}
