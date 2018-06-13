package org.ispeech;

import com.faceture.google.play.QueryParamConst;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class MouthMovements extends TimerTask {
    final String TAG = "MouthMovements";
    private String _apiKey;
    private String _format;
    public VisemeHolder _holder;
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

    public MouthMovements(String str) {
        this._text = str;
        getVisimes();
    }

    public MouthMovements(String str, String str2) {
        this._apiKey = str2;
        this._urlBaseVisme += str2;
        this._urlBaseVisme += "&action=viseme&";
        this._text = str;
        getVisimes();
    }

    public MouthMovements(String str, String str2, String str3, String str4, String str5) {
        this._apiKey = str2;
        this._urlBaseVisme += str2;
        this._urlBaseVisme += "&action=viseme";
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
        VisemeConnection visemeConnection = new VisemeConnection(getURL(), this);
        visemeConnection.run2();
        this._holder = visemeConnection.getHolder();
    }

    public String getText() {
        return this._text;
    }

    public VisemeHolder getVisemeHolder() {
        return this._holder;
    }

    public void gotVisimes(VisemeHolder visemeHolder) {
        this._holder = visemeHolder;
        this._holder.addFrame();
        this._holder.getViseme().addElement(new Viseme(visemeHolder.getTotalLength() + 1, visemeHolder.getTotalLength() + 1000, 0));
        Vector vector = visemeHolder._viseme;
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
