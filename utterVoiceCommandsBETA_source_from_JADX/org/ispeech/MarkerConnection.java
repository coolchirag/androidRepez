package org.ispeech;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MarkerConnection extends Thread implements ParserMarkerCallback {
    private final String TAG = "VisemeConnection";
    private MarkerHolder _holder;
    private MarkerMovements _markerMovements;
    private String _url;

    public MarkerConnection(String str, MarkerMovements markerMovements) {
        this._markerMovements = markerMovements;
        this._url = str;
    }

    public MarkerHolder getHolder() {
        return this._holder;
    }

    public void getXml() {
        this._url = this._url.replaceAll("%3D", "=");
        InputStream bufferedInputStream = new BufferedInputStream(new URL(this._url).openConnection().getInputStream());
        DefaultHandler markerSAXParser = new MarkerSAXParser(this);
        SAXParserFactory newInstance = SAXParserFactory.newInstance();
        newInstance.setFeature("http://xml.org/sax/features/namespaces", false);
        newInstance.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
        newInstance.newSAXParser().parse(bufferedInputStream, markerSAXParser);
    }

    public void run() {
        try {
            getXml();
            this._markerMovements.gotMarkers(getHolder());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e2) {
            e2.printStackTrace();
        } catch (SAXException e3) {
            e3.printStackTrace();
        }
    }

    public void run2() {
        try {
            getXml();
            this._markerMovements.gotMarkers(getHolder());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e2) {
            e2.printStackTrace();
        } catch (SAXException e3) {
            e3.printStackTrace();
        }
    }

    public void setHolder(MarkerHolder markerHolder) {
        this._holder = markerHolder;
    }
}
