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
    setNotificationStyle();
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

  public void setNotificationStyle() {
    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
    mBuilder.setSmallIcon(R.mipmap.ic_notification);
    mBuilder.setContentTitle("Notification Alert, Click Me!");
    mBuilder.setContentText("Hi, This is Android Notification Detail!");
    mBuilder.setAutoCancel(true);
    
    NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
    inboxStyle.setBigContentTitle("Inbox Notification");
    inboxStyle.addLine("Message 1.");
    inboxStyle.addLine("Message 2.");
    inboxStyle.addLine("Message 3.");
    inboxStyle.addLine("Message 4.");
    inboxStyle.addLine("Message 5.");
    inboxStyle.setSummaryText("+2 more");
    NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
    bigText.bigText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
    bigText.setBigContentTitle("Big Text Notification");
    bigText.setSummaryText("By: Author of Lorem ipsum");
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
