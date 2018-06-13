package org.ispeech;

import java.util.Vector;

public class VisemeHolder {
    private int _frames;
    private int _len;
    private String _text;
    public Vector _viseme = new Vector();
    private String _voice;

    public VisemeHolder(String str, String str2, int i, int i2) {
        this._text = str;
        this._voice = str2;
        this._len = i;
        this._frames = i2;
    }

    public void addFrame() {
        this._frames++;
    }

    public void addViseme(Viseme viseme) {
        this._viseme.addElement(viseme);
    }

    public int getEnd(int i) {
        return ((Viseme) this._viseme.get(i)).getEnd();
    }

    public int getFrames() {
        return this._frames - 1;
    }

    public int getLength(int i) {
        return ((Viseme) this._viseme.get(i)).getEnd() - ((Viseme) this._viseme.get(i)).getStart();
    }

    public int getMouth(int i) {
        return ((Viseme) this._viseme.get(i)).getMouth();
    }

    public int getStart(int i) {
        return ((Viseme) this._viseme.get(i)).getStart();
    }

    public int getTotalLength() {
        return this._len;
    }

    public Vector<Viseme> getViseme() {
        return this._viseme;
    }
}
