package org.ispeech;

import org.ispeech.core.HttpRequestParams;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.helpers.DefaultHandler;

public class MarkerSAXParser extends DefaultHandler {
    private ParserMarkerCallback _callback;
    private String _curr;
    private int _end = 0;
    private MarkerHolder _holder;
    private boolean _inViseme = false;
    private int _len = 0;
    private int _start = 0;
    private String _text = "";
    private String _voice = "";
    private int _words;

    public MarkerSAXParser(ParserMarkerCallback parserMarkerCallback) {
        this._callback = parserMarkerCallback;
    }

    public void characters(char[] cArr, int i, int i2) {
        this._curr = new String(cArr, i, i2);
    }

    public void endDocument() {
        while (this._holder == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this._callback.setHolder(this._holder);
    }

    public void endElement(String str, String str2, String str3) {
        if (this._inViseme) {
            if (str3.equalsIgnoreCase("start")) {
                this._start = Integer.parseInt(this._curr);
            } else if (str3.equalsIgnoreCase("end")) {
                this._end = Integer.parseInt(this._curr);
            } else if (str3.equalsIgnoreCase(HttpRequestParams.TEXT)) {
                this._holder.addMarker(new Marker(this._start, this._end, this._curr));
            }
        } else if (str3.equalsIgnoreCase(HttpRequestParams.TEXT)) {
            this._text = this._curr;
        } else if (str3.equalsIgnoreCase(HttpRequestParams.VOICE)) {
            this._voice = this._curr;
        } else if (str3.equalsIgnoreCase("length")) {
            this._len = Integer.parseInt(this._curr);
        } else if (str3.equalsIgnoreCase("words")) {
            this._holder = new MarkerHolder(this._text, this._voice, this._len, Integer.parseInt(this._curr));
        }
        this._curr = "";
    }

    public void endPrefixMapping(String str) {
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) {
    }

    public void notationDecl(String str, String str2, String str3) {
    }

    public void processingInstruction(String str, String str2) {
    }

    public void setDocumentLocator(Locator locator) {
    }

    public void skippedEntity(String str) {
    }

    public void startDocument() {
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if (str3.equalsIgnoreCase("word")) {
            this._inViseme = true;
        }
    }

    public void startPrefixMapping(String str, String str2) {
    }

    public void unparsedEntityDecl(String str, String str2, String str3, String str4) {
    }
}
