package org.ispeech;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class VisemeConnection extends Thread implements ParserCallback {
    private final String TAG = "VisemeConnection";
    private VisemeHolder _holder;
    private MouthMovements _mouthMovements;
    private String _url;

    public VisemeConnection(String str, MouthMovements mouthMovements) {
        this._mouthMovements = mouthMovements;
        this._url = str;
    }

    public VisemeHolder getHolder() {
        return this._holder;
    }

    public void getXml() {
        this._url = this._url.replaceAll("%3D", "=");
        InputStream bufferedInputStream = new BufferedInputStream(new URL(this._url).openConnection().getInputStream());
        DefaultHandler visemeSAXParser = new VisemeSAXParser(this);
        SAXParserFactory newInstance = SAXParserFactory.newInstance();
        newInstance.setFeature("http://xml.org/sax/features/namespaces", false);
        newInstance.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
        newInstance.newSAXParser().parse(bufferedInputStream, visemeSAXParser);
    }

    public void run() {
        try {
            getXml();
            this._mouthMovements.gotVisimes(getHolder());
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
            this._mouthMovements.gotVisimes(getHolder());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e2) {
            e2.printStackTrace();
        } catch (SAXException e3) {
            e3.printStackTrace();
        }
    }

    public void setHolder(VisemeHolder visemeHolder) {
        this._holder = visemeHolder;
    }
}
