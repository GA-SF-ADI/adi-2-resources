package com.example.hollis.gson_example;

/**
 * Created by audreyeso on 7/18/16.
 */
public class Artists {
    private ExternalURLS externalURLS;
    private Followers followers;
    private Genres genres;
    private String href;
    private String id;
    private Images images;
    private String name;
    private int popularity;
    private String artist;
    private String uri;


    public ExternalURLS getExternalURLS() {
        return externalURLS;
    }

    public void setExternalURLS(ExternalURLS externalURLS) {
        this.externalURLS = externalURLS;
    }

    public Followers getFollowers() {
        return followers;
    }

    public void setFollowers(Followers followers) {
        this.followers = followers;
    }

    public Genres getGenres() {
        return genres;
    }

    public void setGenres(Genres genres) {
        this.genres = genres;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
