package org.ispeech;

public class Marker {
    public int _end;
    public int _start;
    public String _text;

    public Marker(int i, int i2, String str) {
        this._start = i;
        this._end = i2;
        this._text = str;
    }

    public int getEnd() {
        return this._end;
    }

    public int getStart() {
        return this._start;
    }

    public String getText() {
        return this._text;
    }
}
