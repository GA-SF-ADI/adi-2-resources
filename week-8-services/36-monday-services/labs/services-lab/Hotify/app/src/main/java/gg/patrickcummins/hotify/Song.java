package gg.patrickcummins.hotify;

/**
 * Created by patrickcummins on 7/26/16.
 */

public class Song {
    String songName;
    String songUrl;

    public Song(String songName, String songUrl) {

        this.songName = songName;
        this.songUrl = songUrl;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }
}
