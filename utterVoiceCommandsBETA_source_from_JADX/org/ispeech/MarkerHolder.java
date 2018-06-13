package org.ispeech;

import java.util.Vector;

public class MarkerHolder {
    private int _len;
    public Vector _marker = new Vector();
    private String _text;
    private String _voice;
    private int _words;

    public MarkerHolder(String str, String str2, int i, int i2) {
        this._text = str;
        this._voice = str2;
        this._len = i;
        this._words = i2;
    }

    public void addFrame() {
        this._words++;
    }

    public void addMarker(Marker marker) {
        this._marker.addElement(marker);
    }

    public int getEnd(int i) {
        return ((Marker) this._marker.get(i)).getEnd();
    }

    public int getLength(int i) {
        return ((Marker) this._marker.get(i)).getEnd() - ((Marker) this._marker.get(i)).getStart();
    }

    public Vector<Marker> getMarker() {
        return this._marker;
    }

    public int getStart(int i) {
        return ((Marker) this._marker.get(i)).getStart();
    }

    public String getText(int i) {
        return ((Marker) this._marker.get(i)).getText();
    }

    public int getTotalLength() {
        return this._len;
    }

    public int getWords() {
        return this._words - 1;
    }
}
