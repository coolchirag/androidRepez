package com.brandall.nutter;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public final class jz extends AsyncTask<ArrayList<String>, String, Void> {
    static Context f1584a;
    private String f1585b = "";
    private boolean f1586c = false;

    public jz(Context context) {
        f1584a = context;
    }

    private static void m1276a() {
        if (hc.f1269b) {
            ls.m1346c("ExecuteJoke tidyVariables");
        }
        GlobalV.m889t(false);
        GlobalV.m862l(0);
    }

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        ArrayList[] arrayListArr = (ArrayList[]) objArr;
        ArrayList arrayList = new ArrayList();
        if (arrayListArr != null && arrayListArr.length > 0) {
            arrayList = arrayListArr[0];
        }
        int ae = GlobalV.ae();
        if (hc.f1269b) {
            ls.m1344a("JokeStage: " + ae);
        }
        if (arrayList.isEmpty()) {
            if (hc.f1269b) {
                ls.m1347d("responseData empty");
            }
            this.f1585b = "Sorry, something went wrong with the joke.";
            this.f1586c = false;
            m1276a();
        } else if (!arrayList.contains("cancel")) {
            String toLowerCase;
            Iterator it;
            boolean z;
            switch (ae) {
                case 0:
                    if (hc.f1269b) {
                        ls.m1347d("JokeStage: 0");
                    }
                    this.f1585b = "Sorry, something went wrong with my brain.";
                    this.f1586c = false;
                    m1276a();
                    break;
                case 1:
                    if (hc.f1269b) {
                        ls.m1346c("JokeStage: " + ae);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    this.f1585b = GlobalV.m814a(ae);
                    if (!this.f1585b.startsWith("A:")) {
                        if (this.f1585b.startsWith("R:")) {
                            this.f1585b = GlobalV.m814a(ae + 1).replace("S:", "");
                            if (!GlobalV.m814a(ae + 2).matches("null")) {
                                this.f1586c = true;
                                GlobalV.m862l(ae + 2);
                                break;
                            }
                            this.f1586c = false;
                            m1276a();
                            break;
                        }
                    }
                    this.f1585b = this.f1585b.replace("A:", "");
                    toLowerCase = this.f1585b.toLowerCase(Locale.US);
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (toLowerCase.matches((String) it.next())) {
                            z = true;
                            if (!z) {
                                if (GlobalV.m814a(ae + 1).matches("null")) {
                                    this.f1586c = false;
                                    m1276a();
                                    break;
                                }
                                this.f1586c = true;
                                GlobalV.m862l(ae + 1);
                                break;
                            }
                            this.f1585b = "You've heard that one then.";
                            this.f1586c = false;
                            m1276a();
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        this.f1585b = "You've heard that one then.";
                        this.f1586c = false;
                        m1276a();
                    } else if (GlobalV.m814a(ae + 1).matches("null")) {
                        this.f1586c = false;
                        m1276a();
                    } else {
                        this.f1586c = true;
                        GlobalV.m862l(ae + 1);
                    }
                    break;
                case 2:
                    if (hc.f1269b) {
                        ls.m1346c("JokeStage: " + ae);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    this.f1585b = GlobalV.m814a(ae);
                    if (!this.f1585b.startsWith("A:")) {
                        if (this.f1585b.startsWith("R:")) {
                            this.f1585b = GlobalV.m814a(ae + 1).replace("S:", "");
                            if (!GlobalV.m814a(ae + 2).matches("null")) {
                                this.f1586c = true;
                                GlobalV.m862l(ae + 2);
                                break;
                            }
                            this.f1586c = false;
                            m1276a();
                            break;
                        }
                    }
                    this.f1585b = this.f1585b.replace("A:", "");
                    toLowerCase = this.f1585b.toLowerCase(Locale.US);
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (toLowerCase.matches((String) it.next())) {
                            z = true;
                            if (!z) {
                                if (GlobalV.m814a(ae + 1).matches("null")) {
                                    this.f1586c = false;
                                    m1276a();
                                    break;
                                }
                                this.f1586c = true;
                                GlobalV.m862l(ae + 1);
                                break;
                            }
                            this.f1585b = "You've heard that one then.";
                            this.f1586c = false;
                            m1276a();
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        this.f1585b = "You've heard that one then.";
                        this.f1586c = false;
                        m1276a();
                    } else if (GlobalV.m814a(ae + 1).matches("null")) {
                        this.f1586c = false;
                        m1276a();
                    } else {
                        this.f1586c = true;
                        GlobalV.m862l(ae + 1);
                    }
                    break;
                case 3:
                    if (hc.f1269b) {
                        ls.m1346c("JokeStage: " + ae);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    this.f1585b = GlobalV.m814a(ae);
                    if (!this.f1585b.startsWith("A:")) {
                        if (this.f1585b.startsWith("R:")) {
                            this.f1585b = GlobalV.m814a(ae + 1).replace("S:", "");
                            if (!GlobalV.m814a(ae + 2).matches("null")) {
                                this.f1586c = true;
                                GlobalV.m862l(ae + 2);
                                break;
                            }
                            this.f1586c = false;
                            m1276a();
                            break;
                        }
                    }
                    this.f1585b = this.f1585b.replace("A:", "");
                    toLowerCase = this.f1585b.toLowerCase(Locale.US);
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (toLowerCase.matches((String) it.next())) {
                            z = true;
                            if (!z) {
                                if (GlobalV.m814a(ae + 1).matches("null")) {
                                    this.f1586c = false;
                                    m1276a();
                                    break;
                                }
                                this.f1586c = true;
                                GlobalV.m862l(ae + 1);
                                break;
                            }
                            this.f1585b = "You've heard that one then.";
                            this.f1586c = false;
                            m1276a();
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        this.f1585b = "You've heard that one then.";
                        this.f1586c = false;
                        m1276a();
                    } else if (GlobalV.m814a(ae + 1).matches("null")) {
                        this.f1586c = false;
                        m1276a();
                    } else {
                        this.f1586c = true;
                        GlobalV.m862l(ae + 1);
                    }
                    break;
                case 4:
                    if (hc.f1269b) {
                        ls.m1346c("JokeStage: " + ae);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    this.f1585b = GlobalV.m814a(ae);
                    if (!this.f1585b.startsWith("A:")) {
                        if (this.f1585b.startsWith("R:")) {
                            this.f1585b = GlobalV.m814a(ae + 1).replace("S:", "");
                            if (!GlobalV.m814a(ae + 2).matches("null")) {
                                this.f1586c = true;
                                GlobalV.m862l(ae + 2);
                                break;
                            }
                            this.f1586c = false;
                            m1276a();
                            break;
                        }
                    }
                    this.f1585b = this.f1585b.replace("A:", "");
                    toLowerCase = this.f1585b.toLowerCase(Locale.US);
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (toLowerCase.matches((String) it.next())) {
                            z = true;
                            if (!z) {
                                if (GlobalV.m814a(ae + 1).matches("null")) {
                                    this.f1586c = false;
                                    m1276a();
                                    break;
                                }
                                this.f1586c = true;
                                GlobalV.m862l(ae + 1);
                                break;
                            }
                            this.f1585b = "You've heard that one then.";
                            this.f1586c = false;
                            m1276a();
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        this.f1585b = "You've heard that one then.";
                        this.f1586c = false;
                        m1276a();
                    } else if (GlobalV.m814a(ae + 1).matches("null")) {
                        this.f1586c = false;
                        m1276a();
                    } else {
                        this.f1586c = true;
                        GlobalV.m862l(ae + 1);
                    }
                    break;
                case 5:
                    if (hc.f1269b) {
                        ls.m1346c("JokeStage: " + ae);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    this.f1585b = GlobalV.m814a(ae);
                    if (!this.f1585b.startsWith("A:")) {
                        if (this.f1585b.startsWith("R:")) {
                            this.f1585b = GlobalV.m814a(ae + 1).replace("S:", "");
                            if (!GlobalV.m814a(ae + 2).matches("null")) {
                                this.f1586c = true;
                                GlobalV.m862l(ae + 2);
                                break;
                            }
                            this.f1586c = false;
                            m1276a();
                            break;
                        }
                    }
                    this.f1585b = this.f1585b.replace("A:", "");
                    toLowerCase = this.f1585b.toLowerCase(Locale.US);
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (toLowerCase.matches((String) it.next())) {
                            z = true;
                            if (!z) {
                                if (GlobalV.m814a(ae + 1).matches("null")) {
                                    this.f1586c = false;
                                    m1276a();
                                    break;
                                }
                                this.f1586c = true;
                                GlobalV.m862l(ae + 1);
                                break;
                            }
                            this.f1585b = "You've heard that one then.";
                            this.f1586c = false;
                            m1276a();
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        this.f1585b = "You've heard that one then.";
                        this.f1586c = false;
                        m1276a();
                    } else if (GlobalV.m814a(ae + 1).matches("null")) {
                        this.f1586c = false;
                        m1276a();
                    } else {
                        this.f1586c = true;
                        GlobalV.m862l(ae + 1);
                    }
                    break;
                case 6:
                    if (hc.f1269b) {
                        ls.m1346c("JokeStage: " + ae);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    this.f1585b = GlobalV.m814a(ae);
                    if (!this.f1585b.startsWith("A:")) {
                        if (this.f1585b.startsWith("R:")) {
                            this.f1585b = GlobalV.m814a(ae + 1).replace("S:", "");
                            if (!GlobalV.m814a(ae + 2).matches("null")) {
                                this.f1586c = true;
                                GlobalV.m862l(ae + 2);
                                break;
                            }
                            this.f1586c = false;
                            m1276a();
                            break;
                        }
                    }
                    this.f1585b = this.f1585b.replace("A:", "");
                    toLowerCase = this.f1585b.toLowerCase(Locale.US);
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (toLowerCase.matches((String) it.next())) {
                            z = true;
                            if (!z) {
                                if (GlobalV.m814a(ae + 1).matches("null")) {
                                    this.f1586c = false;
                                    m1276a();
                                    break;
                                }
                                this.f1586c = true;
                                GlobalV.m862l(ae + 1);
                                break;
                            }
                            this.f1585b = "You've heard that one then.";
                            this.f1586c = false;
                            m1276a();
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        this.f1585b = "You've heard that one then.";
                        this.f1586c = false;
                        m1276a();
                    } else if (GlobalV.m814a(ae + 1).matches("null")) {
                        this.f1586c = false;
                        m1276a();
                    } else {
                        this.f1586c = true;
                        GlobalV.m862l(ae + 1);
                    }
                    break;
                case 7:
                    if (hc.f1269b) {
                        ls.m1346c("JokeStage: " + ae);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    this.f1585b = GlobalV.m814a(ae);
                    if (!this.f1585b.startsWith("A:")) {
                        if (this.f1585b.startsWith("R:")) {
                            this.f1585b = GlobalV.m814a(ae + 1).replace("S:", "");
                            if (!GlobalV.m814a(ae + 2).matches("null")) {
                                this.f1586c = true;
                                GlobalV.m862l(ae + 2);
                                break;
                            }
                            this.f1586c = false;
                            m1276a();
                            break;
                        }
                    }
                    this.f1585b = this.f1585b.replace("A:", "");
                    toLowerCase = this.f1585b.toLowerCase(Locale.US);
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (toLowerCase.matches((String) it.next())) {
                            z = true;
                            if (!z) {
                                if (GlobalV.m814a(ae + 1).matches("null")) {
                                    this.f1586c = false;
                                    m1276a();
                                    break;
                                }
                                this.f1586c = true;
                                GlobalV.m862l(ae + 1);
                                break;
                            }
                            this.f1585b = "You've heard that one then.";
                            this.f1586c = false;
                            m1276a();
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        this.f1585b = "You've heard that one then.";
                        this.f1586c = false;
                        m1276a();
                    } else if (GlobalV.m814a(ae + 1).matches("null")) {
                        this.f1586c = false;
                        m1276a();
                    } else {
                        this.f1586c = true;
                        GlobalV.m862l(ae + 1);
                    }
                    break;
                default:
                    if (hc.f1269b) {
                        ls.m1347d("default");
                    }
                    this.f1585b = "Sorry, something went wrong with the joke.";
                    this.f1586c = false;
                    m1276a();
                    break;
            }
        } else {
            if (hc.f1269b) {
                ls.m1347d("Cancel joke");
            }
            this.f1585b = "Okay";
            this.f1586c = false;
            m1276a();
        }
        return null;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Void voidR = (Void) obj;
        if (hc.f1269b) {
            ls.m1345b("ExecuteJoke onPostEx");
        }
        if (this.f1586c) {
            if (hc.f1269b) {
                ls.m1346c("startRecog: true");
            }
            lc.m1313a(f1584a, true, this.f1585b);
        } else {
            if (hc.f1269b) {
                ls.m1346c("startRecog: false");
            }
            lc.m1313a(f1584a, false, this.f1585b);
        }
        super.onPostExecute(voidR);
    }

    protected final /* synthetic */ void onProgressUpdate(Object... objArr) {
        String[] strArr = (String[]) objArr;
        super.onProgressUpdate(strArr);
        Toast.makeText(f1584a, strArr[0], 0).show();
    }
}
