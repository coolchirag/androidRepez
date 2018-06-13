package org.ispeech;

public class Viseme {
    public int _end;
    public int _mouth;
    public int _start;

    public Viseme(int i, int i2, int i3) {
        this._start = i;
        this._end = i2;
        this._mouth = i3;
    }

    public int getEnd() {
        return this._end;
    }

    public int getMouth() {
        return this._mouth;
    }

    public int getStart() {
        return this._start;
    }
}
