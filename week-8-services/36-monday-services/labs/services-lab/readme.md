---
title: Services
type: lab
duration: "1:25"
creator: James Davis (NYC)
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Services

## Exercise

You are creating a Service that will play/pause/stop music player.

#### Learn about Media Player

Read the [Media Player](https://developer.android.com/guide/topics/media/mediaplayer.html) documentation to get started.

Don't forget your permissions if using URL for a song. Note to use `prepareAsync()` method instead of `prepare()`.

#### Requirements

* Whether you stream the song or save it in your project, Hotify should be able to play one song using services
* Hotify has one screen - make this screen have three buttons: Play, Pause, and Stop
  * Each button will control the playback of the song
  

**Bonus:**

* Make Hotify able to play more than one song
* Show a notification when the song service is started
* Be able to control the song playback through the notification

#### Deliverable

An Android Studio project, with no particular format. It just has to meet the requirements above. Peak at the [solution code](solution-code) if you're stuck!

#### Media Player Hints

If you're stuck on reading documentation about Media Player you can use 
these hints to get started.


Create media player
```java
MediaPlayer mPlayer = new MediaPlayer();
```

Get media url and set it on the player. Then prepare it.
```java
// Set the song to play. Here, I'm setting a Url to a song I want to stream.
// You can also play a song saved on the device using a file path or Uri, but
// do not have to set the audio stream type
String url = "http://download.lisztonian.com/music/download/Clair%2Bde%2BLune-113.mp3";

// We are streaming music and setting the URL of song on the player
mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
mPlayer.setDataSource(url);

// The next line prepares the media player to be played. This is done
// asynchronously, with prepareAsync(). If you use the regular prepare()
// method, the method does not return until the full song is loaded.
// When using prepareAsync(), it returns immediately and, if streaming,
// does not load the whole song.
mPlayer.prepareAsync();
```

Listen to when player is prepared
```java
mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
@Override
public void onPrepared(MediaPlayer mp) {
    
        // once the player is prepared, start playing the song
        mPlayer.start();
        
        // save state of whether we are prepared or not. If later you notice isPrepared == true, then mPlayer.start() can be called directly without any setup needing to happen
        isPrepared = true;
        
    }
});
```

List to when song is completed
```java
// Optional. I want the service to stop itself
// when the song stops playing. This listener listens for when the
// media player's song is completed.

mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer mp) {
        stopSelf();
    }
});
```


#### Resources

- [Services | Android Developers](http://developer.android.com/reference/android/app/Service.html)
- [Media Player](https://developer.android.com/guide/topics/media/mediaplayer.html)
