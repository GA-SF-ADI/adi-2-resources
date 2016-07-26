package co.ga.hotify;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class HotifyService extends Service {

    MediaPlayer mPlayer = new MediaPlayer();

    boolean isPrepared = false;

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {

        // Putting all of the code inside a runnable, to be run on a separate thread. If I don't, the
        // code will block the main thread and noticeably make the app slower

        // Don't forget to start the thread!

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (intent != null){
                    String action = intent.getAction(); // Should be PLAY, PAUSE, or STOP

                    if ("PLAY".equalsIgnoreCase(action)){
                        // if the action is PLAY...

                        // check if the player is prepared for playback. If not, prepare it.
                        if (!isPrepared){
                            try {

                                // Set the song to play. Here, I'm setting a Url to a song I want to stream.
                                // You can also play a song saved on the device using a file path or Uri, but
                                // do not have to set the audio stream type

                                String url = "http://download.lisztonian.com/music/download/Clair%2Bde%2BLune-113.mp3";

                                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                                mPlayer.setDataSource(url);

                                // The next line prepares the media player to be played. This is done
                                // asynchronously, with prepareAsync(). If you use the regular prepare()
                                // method, the method does not return until the full song is loaded.
                                // When using prepareAsync(), it returns immediately and, if streaming,
                                // does not load the whole song.

                                mPlayer.prepareAsync();
                                mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                    @Override
                                    public void onPrepared(MediaPlayer mp) {

                                        // once the player is prepared, start playing the song

                                        isPrepared = true;
                                        mPlayer.start();
                                    }
                                });

                                // Optional. I want the service to stop itself (closing the notification)
                                // when the song stops playing. This listener listens for when the
                                // media player's song is completed.

                                mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        stopSelf();
                                    }
                                });
                            } catch (Throwable e) {

                                // If anything fails and an exception is thrown, we catch it so the
                                // app doesn't crash. We print the stack trace and show the toast that
                                // tells the user something went wrong.

                                e.printStackTrace();
                                Toast.makeText(HotifyService.this, "Could not play file", Toast.LENGTH_SHORT).show();

                                // Might as well stop the service at this point

                                stopSelf();
                            }

                            // To keep this service running without it being removed from memory, you have
                            // to put it in the foreground. You put services in the foreground if the
                            // user is aware that it is running, like if a song is playing or a phone call
                            // is active. In those cases, a notification is created to show the user that
                            // it is running.

                            // As far as I know, there is no way of putting a service in the foreground
                            // without an notification.

                            // I made the getForegroundNotification() method. Look inside it to see the foreground code.

                            Notification notification = getForegroundNotification();
                            startForeground(8675309, notification);
                        } else {
                            // ... else, if the player is already prepared, just play the song
                            mPlayer.start();
                        }

                    } else if ("PAUSE".equalsIgnoreCase(action)){
                        // if the action is PAUSE, pause the player

                        if (mPlayer.isPlaying()) {
                            mPlayer.pause();
                        }
                    } else if ("STOP".equalsIgnoreCase(action)){
                        // if the action is STOP, stop this service.
                        stopSelf();
                    }
                }
            }
        };

        // Starting the thread. Without this, the code will not run

        new Thread(runnable).start();

        // With services, they can either be STICKY or NOT STICKY. When a service is stuck, then it is
        // restarted when the main app is killed. We don't want this, so onStartCommand() will return
        // START_NOT_STICKY.

        return START_NOT_STICKY;
    }

    private Notification getForegroundNotification() {

        // Create the notification, with a title, text, and small icon

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());

        builder.setContentTitle("Clair De Lune");
        builder.setContentText("Claude Debussy");
        builder.setSmallIcon(R.drawable.ic_fire_white); // icon I added in main/res/drawable-*
        builder.setColor(Color.parseColor("#b00000")); // same red as the launcher icon

        // When the notification itself is clicked, the app opens
        Intent appIntent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pendingAppIntent = PendingIntent.getActivity(getApplicationContext(), 0, appIntent, 0);
        builder.setContentIntent(pendingAppIntent);
        builder.setAutoCancel(true);

        // Add the play action to the notification. When these are clicked, they each
        // will start the service while passing the appropriate data in the intent

        Intent playServiceIntent = new Intent(getApplicationContext(), HotifyService.class);
        playServiceIntent.setAction("PLAY");
        PendingIntent pendingPlayServiceIntent = PendingIntent.getService(getApplicationContext(), 0, playServiceIntent, 0);
        builder.addAction(android.R.drawable.ic_media_play, "Play", pendingPlayServiceIntent);

        // ... and the pause action...

        Intent pauseServiceIntent = new Intent(getApplicationContext(), HotifyService.class);
        pauseServiceIntent.setAction("PAUSE");
        PendingIntent pendingPauseServiceIntent = PendingIntent.getService(getApplicationContext(), 0, pauseServiceIntent, 0);
        builder.addAction(android.R.drawable.ic_media_pause, "Pause", pendingPauseServiceIntent);

        // ... and, finally, the stop action...

        Intent stopServiceIntent = new Intent(getApplicationContext(), HotifyService.class);
        stopServiceIntent.setAction("STOP");
        PendingIntent pendingStopServiceIntent = PendingIntent.getService(getApplicationContext(), 0, stopServiceIntent, 0);
        builder.addAction(android.R.drawable.ic_delete, "Stop", pendingStopServiceIntent);

        // Build the notification, and return it

        return builder.build();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Optional. Stopping the playback.

        mPlayer.stop();

        // When the service is destroyed (anytime the service is stopped), we release the memory used
        // by the media player, which can be a lot of memory.

        mPlayer.release();
        isPrepared = false;

        // Remove the service from the foreground. This removes the notification, too.

        stopForeground(true);
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
