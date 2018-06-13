package org.ispeech;

import com.faceture.google.play.QueryParamConst;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class MarkerMovements extends TimerTask {
    final String TAG = "MouthMovements";
    private String _apiKey;
    private String _format;
    public MarkerHolder _holder;
    private String _speed;
    private String _text;
    private String _urlBaseVisme = "http://api.ispeech.org/api/rest/?apikey=";
    private boolean _valid = false;
    private String _voice;
    private String _xml;
    private int index = 0;
    private long start = 0;
    private long time = 0;
    private Timer timer;

    public MarkerMovements(String str) {
        this._text = str;
        getVisimes();
    }

    public MarkerMovements(String str, String str2) {
        this._apiKey = str2;
        this._urlBaseVisme += str2;
        this._urlBaseVisme += "&action=markers&";
        this._text = str;
        getVisimes();
    }

    public MarkerMovements(String str, String str2, String str3, String str4, String str5) {
        this._apiKey = str2;
        this._urlBaseVisme += str2;
        this._urlBaseVisme += "&action=markers";
        this._urlBaseVisme += "&voice=" + str3;
        this._urlBaseVisme += "&speed=" + str4;
        this._urlBaseVisme += "&format=" + str5 + "&";
        this._text = str;
        getVisimes();
    }

    public static String getMouthImage(int i) {
        return QueryParamConst.U_VALUE;
    }

    private String getURL() {
        String str = "";
        try {
            str = URLEncoder.encode(this._text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return this._urlBaseVisme + "text=" + str + "&deviceType=Android";
    }

    private void getVisimes() {
        MarkerConnection markerConnection = new MarkerConnection(getURL(), this);
        markerConnection.run2();
        this._holder = markerConnection.getHolder();
    }

    public MarkerHolder getMarkerHolder() {
        return this._holder;
    }

    public String getText() {
        return this._text;
    }

    public void gotMarkers(MarkerHolder markerHolder) {
        this._holder = markerHolder;
        this._holder.addFrame();
        this._holder.getMarker().addElement(new Marker(markerHolder.getTotalLength() + 1, markerHolder.getTotalLength() + 1000, ""));
        Vector vector = markerHolder._marker;
        if (vector != null && vector.size() > 0) {
            this._valid = true;
        }
    }

    public void playMouth() {
        if (this.timer != null) {
            this.timer.cancel();
        }
        this.timer = new Timer();
        this.index = 0;
        this.start = System.currentTimeMillis();
        this.timer.scheduleAtFixedRate(this, 0, 15);
    }

    public void run() {
    }

    public void setTime() {
    }

    public boolean validVismes() {
        return this._valid;
    }
}
