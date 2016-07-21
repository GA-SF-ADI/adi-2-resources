package generalassembly.yuliyakaleda.networknotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {
  public static final int NOTIFICATION_AVAILABLE = 1;
  public static final int NOTIFICATION_NOT_AVAILABLE = 2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
    if (networkInfo != null && networkInfo.isConnected()) {
      showNetworkAvailableNotification();
    } else {
      showNetworkNotAvailableNotification();
    }
  }

  private void showNetworkNotAvailableNotification() {
    NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
    bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.no_network)).build();
    Intent intent = new Intent(this, SecondActivity.class);
    PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
    mBuilder.setSmallIcon(R.drawable.icon);
    mBuilder.setContentTitle("Notification Alert!");
    mBuilder.setContentText("The network in your location is not available");
    mBuilder.setContentIntent(pIntent);
    mBuilder.setPriority(Notification.PRIORITY_MAX);
    mBuilder.setStyle(bigPictureStyle);
    NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    mNotificationManager.notify(NOTIFICATION_NOT_AVAILABLE, mBuilder.build());
  }

  private void showNetworkAvailableNotification() {
    NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
    bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.network_available)).build();
    Intent intent = new Intent(this, SecondActivity.class);
    PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
    mBuilder.setSmallIcon(R.drawable.icon);
    mBuilder.setContentTitle("Notification Alert!");
    mBuilder.setContentText("The network in your location is available");
    mBuilder.setContentIntent(pIntent);
    mBuilder.setStyle(bigPictureStyle);
    NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    mNotificationManager.notify(NOTIFICATION_AVAILABLE, mBuilder.build());
  }

}
