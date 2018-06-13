package com.faceture.google.play.domain;

import java.util.Collection;

public class SearchResults {
    private Collection<Song> albums;
    private Collection<Song> artists;
    private Collection<Song> songs;

    public Collection<Song> getAlbums() {
        return this.albums;
    }

    public Collection<Song> getArtists() {
        return this.artists;
    }

    public Collection<Song> getSongs() {
        return this.songs;
    }

    public void setAlbums(Collection<Song> collection) {
        this.albums = collection;
    }

    public void setArtists(Collection<Song> collection) {
        this.artists = collection;
    }

    public void setSongs(Collection<Song> collection) {
        this.songs = collection;
    }
}
