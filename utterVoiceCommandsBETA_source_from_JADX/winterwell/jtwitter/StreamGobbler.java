package winterwell.jtwitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import winterwell.json.JSONObject;
import winterwell.jtwitter.AStream.IListen;
import winterwell.jtwitter.Twitter.ITweet;

final class StreamGobbler extends Thread {
    static final /* synthetic */ boolean $assertionsDisabled = (!StreamGobbler.class.desiredAssertionStatus());
    Exception ex;
    int forgotten;
    private ArrayList<String> jsons = new ArrayList();
    volatile boolean stopFlag;
    final AStream stream;

    public StreamGobbler(AStream aStream) {
        setDaemon(true);
        this.stream = aStream;
    }

    private void readJson(BufferedReader bufferedReader, int i) {
        if ($assertionsDisabled || i > 0) {
            char[] cArr = new char[i];
            int i2 = 0;
            while (i > 0) {
                int read = bufferedReader.read(cArr, i2, i);
                if (read == -1) {
                    throw new IOException("end of stream");
                }
                i2 += read;
                i -= read;
            }
            String str = new String(cArr);
            if (!this.stream.listenersOnly) {
                synchronized (this) {
                    this.jsons.add(str);
                    this.forgotten += AStream.forgetIfFull(this.jsons);
                }
            }
            readJson2_notifyListeners(str);
            return;
        }
        throw new AssertionError();
    }

    private void readJson2_notifyListeners(String str) {
        if (this.stream.listeners.size() != 0) {
            synchronized (this.stream.listeners) {
                try {
                    Object read3_parse = AStream.read3_parse(new JSONObject(str), this.stream.jtwit);
                    for (IListen iListen : this.stream.listeners) {
                        boolean processTweet = read3_parse instanceof ITweet ? iListen.processTweet((ITweet) read3_parse) : read3_parse instanceof TwitterEvent ? iListen.processEvent((TwitterEvent) read3_parse) : iListen.processSystemEvent((Object[]) read3_parse);
                        if (processTweet) {
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private int readLength(BufferedReader bufferedReader) {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int read = bufferedReader.read();
            if (read == -1) {
                throw new IOException("end of stream " + this);
            }
            char c = (char) read;
            if (c == '\n' || c == '\r') {
                if (stringBuilder.length() != 0) {
                    return Integer.valueOf(stringBuilder.toString()).intValue();
                }
            } else if (!$assertionsDisabled && !Character.isDigit(c)) {
                throw new AssertionError(c);
            } else if ($assertionsDisabled || stringBuilder.length() < 10) {
                stringBuilder.append(c);
            } else {
                throw new AssertionError(stringBuilder);
            }
        }
    }

    protected final void finalize() {
        if (this.stream != null) {
            InternalUtils.close(this.stream.stream);
        }
    }

    public final void pleaseStop() {
        if (this.stream != null) {
            URLConnectionHttpClient.close(this.stream.stream);
        }
        this.stopFlag = true;
    }

    public final synchronized String[] popJsons() {
        String[] strArr;
        strArr = (String[]) this.jsons.toArray(new String[this.jsons.size()]);
        this.jsons = new ArrayList();
        return strArr;
    }

    public final void run() {
        while (!this.stopFlag) {
            if ($assertionsDisabled || this.stream.stream != null) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.stream.stream));
                    while (!this.stopFlag) {
                        readJson(bufferedReader, readLength(bufferedReader));
                    }
                } catch (Exception e) {
                    if (!this.stopFlag) {
                        this.ex = e;
                        this.stream.addSysEvent(new Object[]{"exception", this.ex});
                        if (this.stream.autoReconnect) {
                            this.stream.reconnectFromGobblerThread();
                            if (!$assertionsDisabled && this.stream.stream == null) {
                                throw new AssertionError(this.stream);
                            }
                        }
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    this.ex = e2;
                    return;
                }
            }
            throw new AssertionError(this.stream);
        }
    }

    public final String toString() {
        return getName() + "[" + this.jsons.size() + "]";
    }
}
