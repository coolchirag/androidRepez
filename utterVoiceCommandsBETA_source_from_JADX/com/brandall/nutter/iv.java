package com.brandall.nutter;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Locale;

public final class iv extends AsyncTask<ArrayList<String>, Integer, ArrayList<String>> {
    Context f1483a;
    private String f1484b = "";
    private boolean f1485c = false;
    private boolean f1486d = false;
    private boolean f1487e = false;
    private boolean f1488f = false;

    public iv(Context context) {
        this.f1483a = context;
    }

    private static String m1185a(String str) {
        char[] toCharArray = str.toCharArray();
        toCharArray[0] = Character.toUpperCase(toCharArray[0]);
        return new String(toCharArray);
    }

    private void m1186a() {
        this.f1485c = false;
        GlobalV.m893u(false);
        GlobalV.m827c(false);
        GlobalV.m822b("");
        GlobalV.m862l(0);
        this.f1487e = false;
    }

    private void m1187b() {
        this.f1485c = false;
        GlobalV.m893u(false);
        GlobalV.m875o(false);
        GlobalV.m874o("");
        GlobalV.m845h(0);
    }

    private void m1188c() {
        this.f1485c = false;
        GlobalV.m893u(false);
        GlobalV.m877p(false);
        GlobalV.m876p("");
        GlobalV.m850i(0);
    }

    private void m1189d() {
        this.f1485c = false;
        GlobalV.m893u(false);
        GlobalV.m785A(false);
        GlobalV.m866m(0);
        GlobalV.m895v("");
        GlobalV.m888t("");
    }

    private void m1190e() {
        this.f1485c = false;
        GlobalV.m893u(false);
        GlobalV.m787B(false);
        GlobalV.m869n(0);
        GlobalV.m906z("");
        GlobalV.m784A("");
    }

    private void m1191f() {
        this.f1485c = false;
        GlobalV.m893u(false);
        GlobalV.m896v(false);
    }

    private void m1192g() {
        this.f1485c = false;
        GlobalV.m893u(false);
        GlobalV.m868m(false);
        GlobalV.m842g(0);
        GlobalV.m870n("");
    }

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        ArrayList[] arrayListArr = (ArrayList[]) objArr;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = arrayListArr[0];
        ListIterator listIterator = arrayList2.listIterator();
        Locale locale = Locale.US;
        while (listIterator.hasNext()) {
            String trim = ((String) listIterator.next()).toString().toLowerCase(locale).trim();
            if (hc.f1269b) {
                ls.m1344a("mypass: " + trim);
            }
            if (!trim.matches("cancel") && !trim.matches("council") && !trim.matches("cancer") && !trim.contains("council council") && !trim.contains("cancer cancer")) {
                if (trim.contains("cancel cancel")) {
                    this.f1486d = true;
                    break;
                }
            }
            this.f1486d = true;
            break;
        }
        if (this.f1486d) {
            this.f1484b = "Cancelling.";
            this.f1485c = false;
            GlobalV.m893u(false);
            GlobalV.m787B(false);
            GlobalV.m869n(0);
            GlobalV.m906z("");
            GlobalV.m784A("");
            GlobalV.m785A(false);
            GlobalV.m866m(0);
            GlobalV.m895v("");
            GlobalV.m888t("");
            GlobalV.m877p(false);
            GlobalV.m876p("");
            GlobalV.m850i(0);
            GlobalV.m875o(false);
            GlobalV.m874o("");
            GlobalV.m845h(0);
            GlobalV.m868m(false);
            GlobalV.m842g(0);
            GlobalV.m870n("");
            GlobalV.m864l(false);
            GlobalV.m851i("");
            GlobalV.m855j("");
            GlobalV.m859k("");
            GlobalV.m846h("");
            GlobalV.m827c(false);
            GlobalV.m822b("");
            GlobalV.m862l(0);
            this.f1487e = false;
            GlobalV.m896v(false);
            GlobalV.m819a(false);
            GlobalV.m817a("");
        } else if (GlobalV.aC()) {
            if (hc.f1269b) {
                ls.m1346c("RootCond: true");
                ls.m1346c("DIB getYNStatus: " + GlobalV.aH());
            }
            GlobalV.m893u(false);
            r0 = jo.m1213a(arrayList2);
            if (hc.f1269b) {
                ls.m1346c("ynpResponse.returnStatus: " + r0.f1563a);
            }
            if (r0.f1563a.equals(jp.yes)) {
                GlobalV.m907z(true);
                if (!GlobalV.aB().matches("rootGovernor")) {
                    this.f1484b = "I feel sleepy";
                }
            } else if (r0.f1563a.equals(jp.no)) {
                this.f1484b = "Sub command cancelled.";
                GlobalV.m904y(false);
                GlobalV.m786B("");
                GlobalV.m907z(false);
            } else if (r0.f1563a.equals(jp.unclear)) {
                this.f1484b = "Your response was unclear. Sub command cancelled.";
                GlobalV.m904y(false);
                GlobalV.m786B("");
                GlobalV.m907z(false);
            }
        } else if (GlobalV.aE()) {
            if (hc.f1269b) {
                ls.m1346c("EmailCond: true");
            }
            r0 = GlobalV.an();
            if (hc.f1269b) {
                ls.m1344a("emailStage: " + r0);
            }
            switch (r0) {
                case 1:
                    if (hc.f1269b) {
                        ls.m1346c("emailCond: " + r0 + " : body");
                    }
                    GlobalV.m860k(true);
                    GlobalV.m895v(m1185a((String) arrayList2.get(0)));
                    if (hc.f1269b) {
                        ls.m1344a("emailBody: " + m1185a((String) arrayList2.get(0)));
                    }
                    this.f1485c = true;
                    GlobalV.m866m(2);
                    this.f1484b = "And the subject?";
                    break;
                case 2:
                    if (hc.f1269b) {
                        ls.m1346c("emailCond: " + r0 + " : title");
                    }
                    GlobalV.m892u(m1185a((String) arrayList2.get(0)));
                    if (hc.f1269b) {
                        ls.m1344a("emailSubject: " + m1185a((String) arrayList2.get(0)));
                    }
                    GlobalV.m866m(3);
                    this.f1485c = true;
                    if (!lx.m1430h(this.f1483a)) {
                        this.f1484b = "Do you want to proof read it?";
                        break;
                    }
                    GlobalV.m899w(true);
                    this.f1484b = "Okay, this is what I heard. " + GlobalV.ah() + "... Do you want to proof read it?";
                    break;
                case 3:
                    if (hc.f1269b) {
                        ls.m1346c("emailCond: " + r0 + " : send condition");
                    }
                    r0 = jo.m1213a(arrayList2);
                    if (hc.f1269b) {
                        ls.m1346c("ynpResponse.returnStatus: " + r0.f1563a);
                    }
                    if (!r0.f1563a.equals(jp.yes)) {
                        if (!r0.f1563a.equals(jp.no)) {
                            if (r0.f1563a.equals(jp.unclear)) {
                                this.f1485c = true;
                                this.f1484b = "Sorry, could you say that again please.";
                                break;
                            }
                        }
                        if (lx.m1379R(this.f1483a)) {
                            this.f1484b = "Sent.";
                            if (!ju.m1219a(this.f1483a, GlobalV.af(), GlobalV.ag(), GlobalV.ah())) {
                                this.f1484b = "Something went wrong trying to automatically send that email.";
                                jy.m1231a(this.f1483a, GlobalV.af(), GlobalV.ag(), GlobalV.ah());
                            }
                        } else {
                            this.f1484b = "You don't have an email account configured. Please see the linked applications tab in the main application.";
                            jy.m1231a(this.f1483a, GlobalV.af(), GlobalV.ag(), GlobalV.ah());
                        }
                        m1189d();
                        break;
                    }
                    this.f1484b = "Okay.";
                    jy.m1231a(this.f1483a, GlobalV.af(), GlobalV.ag(), GlobalV.ah());
                    m1189d();
                    break;
                    break;
                default:
                    break;
            }
        } else if (GlobalV.aF()) {
            if (hc.f1269b) {
                ls.m1346c("SMSCond: " + GlobalV.aF());
            }
            r0 = GlobalV.ao();
            if (hc.f1269b) {
                ls.m1344a("SMSStage: " + r0);
            }
            switch (r0) {
                case 1:
                    if (hc.f1269b) {
                        ls.m1346c("SMSCond: " + r0 + " : body: " + m1185a((String) arrayList2.get(0)) + " : recipient: " + GlobalV.ay());
                    }
                    GlobalV.m906z(m1185a((String) arrayList2.get(0)));
                    this.f1485c = true;
                    GlobalV.m869n(2);
                    if (!lx.m1430h(this.f1483a)) {
                        this.f1484b = "Do you want to proof read it?";
                        break;
                    }
                    GlobalV.m899w(true);
                    this.f1484b = "Okay, this is what I heard. " + GlobalV.ax() + "... Do you want to proof read it?";
                    break;
                case 2:
                    if (hc.f1269b) {
                        ls.m1346c("SMSCond: " + r0 + " : send condition");
                    }
                    r0 = jo.m1213a(arrayList2);
                    if (hc.f1269b) {
                        ls.m1346c("ynpResponse.returnStatus: " + r0.f1563a);
                    }
                    if (!r0.f1563a.equals(jp.yes)) {
                        if (!r0.f1563a.equals(jp.no)) {
                            if (r0.f1563a.equals(jp.unclear)) {
                                this.f1485c = true;
                                this.f1484b = "Sorry, could you say that again please.";
                                break;
                            }
                        }
                        if (kh.m1294a(this.f1483a, GlobalV.ay(), GlobalV.ax())) {
                            this.f1484b = "Sent.";
                        } else {
                            this.f1484b = "The message is quite large. Please send it manually.";
                            jy.m1232a(this.f1483a, GlobalV.ay(), GlobalV.ax(), lx.m1418d(this.f1483a));
                        }
                        m1190e();
                        break;
                    }
                    this.f1484b = "Okay.";
                    jy.m1232a(this.f1483a, GlobalV.ay(), GlobalV.ax(), lx.m1418d(this.f1483a));
                    m1190e();
                    break;
                    break;
                default:
                    break;
            }
        } else if (GlobalV.am()) {
            if (!arrayList2.isEmpty()) {
                trim = (String) arrayList2.get(0);
                switch (lx.m1425g(this.f1483a)) {
                    case 1:
                        if (!trim.toLowerCase(locale).matches("xda developers") && !trim.toLowerCase(locale).matches("xd a developers") && !trim.toLowerCase(locale).matches("x d a developers")) {
                            this.f1484b = "Sorry, but that's the wrong password.";
                            m1191f();
                            break;
                        }
                        this.f1484b = "Password accepted. XDA Developers was the place I was born and raised. Please say the, second, Easter Egg password.";
                        lx.m1407c(this.f1483a, 2);
                        this.f1485c = true;
                        break;
                        break;
                    case 2:
                        if (!trim.toLowerCase(locale).matches("ben randall") && !trim.toLowerCase(locale).matches("ben randle")) {
                            this.f1484b = "Sorry, but that's the wrong password.";
                            m1191f();
                            break;
                        }
                        this.f1484b = "Password accepted. Ben Randall is my creator, and I'm sure he won't mind me saying that he's incredibly talented, and devastatingly handsome. Please say the, third, Easter Egg password.";
                        lx.m1407c(this.f1483a, 3);
                        this.f1485c = true;
                        break;
                    case 3:
                        this.f1484b = "Sorry, but that's the wrong password.";
                        m1191f();
                        break;
                    default:
                        break;
                }
            }
            this.f1484b = "Sorry, but that's the wrong password.";
            m1191f();
        } else if (GlobalV.aj()) {
            r0 = jo.m1213a(arrayList2);
            if (hc.f1269b) {
                ls.m1346c("ynpResponse.returnStatus: " + r0.f1563a);
            }
            if (r0.f1563a.equals(jp.yes)) {
                this.f1484b = "Okay.";
                GlobalV.m893u(false);
                GlobalV.ai();
            } else if (r0.f1563a.equals(jp.no)) {
                this.f1484b = "Okay. I've zipped the screenshot";
                this.f1483a.sendBroadcast(new mv("ZIDo"));
                GlobalV.m893u(false);
                GlobalV.ai();
            } else if (r0.f1563a.equals(jp.unclear)) {
                this.f1485c = true;
                this.f1484b = "Sorry, could you say that again please.";
                GlobalV.m893u(true);
            }
        } else if (GlobalV.m848h()) {
            if (hc.f1269b) {
                ls.m1346c("getSubmitJokeCond: true");
            }
            r0 = GlobalV.ae();
            if (hc.f1269b) {
                ls.m1344a("JokeStage: " + r0);
            }
            switch (r0) {
                case 1:
                    if (hc.f1269b) {
                        ls.m1346c("JokeCond: " + r0);
                    }
                    if (arrayList2.isEmpty()) {
                        this.f1484b = "Sorry, but I didn't hear anything. I've cancelled the submission.";
                        m1186a();
                    } else {
                        GlobalV.m822b((String) arrayList2.get(0));
                        GlobalV.m899w(true);
                        GlobalV.m862l(2);
                        this.f1485c = true;
                        this.f1484b = "Okay, this is what I heard. " + GlobalV.m841g() + "... Shall I submit it?";
                    }
                    GlobalV.m844g(false);
                    break;
                case 2:
                    if (hc.f1269b) {
                        ls.m1346c("JokeCond: " + r0);
                    }
                    r0 = jo.m1213a(arrayList2);
                    if (hc.f1269b) {
                        ls.m1346c("ynpResponse.returnStatus: " + r0.f1563a);
                    }
                    if (!r0.f1563a.equals(jp.yes)) {
                        if (!r0.f1563a.equals(jp.no)) {
                            if (r0.f1563a.equals(jp.unclear)) {
                                this.f1485c = true;
                                this.f1484b = "Sorry, could you say that again please?";
                                break;
                            }
                        }
                        this.f1485c = false;
                        this.f1484b = "Okay, I've cancelled the submission";
                        m1186a();
                        break;
                    }
                    this.f1485c = false;
                    this.f1484b = "Okay, I've submitted that. Thank you.";
                    this.f1487e = true;
                    break;
                    break;
                default:
                    break;
            }
        } else if (GlobalV.m812Y()) {
            if (hc.f1269b) {
                ls.m1346c("NoteCond: true");
            }
            r0 = GlobalV.m811X();
            if (hc.f1269b) {
                ls.m1344a("noteStage: " + r0);
            }
            switch (r0) {
                case 1:
                    if (hc.f1269b) {
                        ls.m1346c("noteCond: " + r0 + " : body");
                    }
                    GlobalV.m883r(m1185a((String) arrayList2.get(0)));
                    if (hc.f1269b) {
                        ls.m1344a("noteBody: " + m1185a((String) arrayList2.get(0)));
                    }
                    this.f1485c = true;
                    GlobalV.m854j(2);
                    this.f1484b = "What do you want to call the note?";
                    break;
                case 2:
                    if (hc.f1269b) {
                        ls.m1346c("noteCond: " + r0 + " : title");
                    }
                    GlobalV.m879q(m1185a((String) arrayList2.get(0)));
                    if (hc.f1269b) {
                        ls.m1344a("NoteTitle: " + m1185a((String) arrayList2.get(0)));
                    }
                    this.f1485c = true;
                    GlobalV.m854j(3);
                    this.f1484b = "Do you want to proof read it?";
                    break;
                case 3:
                    if (hc.f1269b) {
                        ls.m1346c("noteCond: " + r0 + " : proof condition");
                    }
                    r0 = jo.m1213a(arrayList2);
                    if (hc.f1269b) {
                        ls.m1346c("ynpResponse.returnStatus: " + r0.f1563a);
                    }
                    ia a;
                    if (!r0.f1563a.equals(jp.yes)) {
                        if (!r0.f1563a.equals(jp.no)) {
                            if (r0.f1563a.equals(jp.unclear)) {
                                this.f1485c = true;
                                this.f1484b = "Sorry, could you say that again please.";
                                GlobalV.m893u(true);
                                break;
                            }
                        }
                        this.f1484b = "Your new note is saved.";
                        a = hz.m1159a(this.f1483a, "notes");
                        switch (a.f1428e) {
                            case 1:
                                jy.m1244c(this.f1483a, GlobalV.m809V(), GlobalV.m810W(), false);
                                break;
                            case 2:
                                jy.m1240b(this.f1483a, GlobalV.m809V(), GlobalV.m810W(), false);
                                break;
                            default:
                                this.f1484b = "Sorry, something went wrong with the note creation";
                                break;
                        }
                        if (a.f1424a && !a.f1425b) {
                            this.f1484b = "Your default notes application is no longer installed.";
                        } else if (!a.f1424a) {
                            this.f1484b = "Please take a moment to select your default notes application, from the Settings Tab.";
                        }
                        GlobalV.m893u(false);
                        GlobalV.m880q(false);
                        GlobalV.m854j(0);
                        break;
                    }
                    this.f1484b = "There you go.";
                    a = hz.m1159a(this.f1483a, "notes");
                    switch (a.f1428e) {
                        case 1:
                            jy.m1244c(this.f1483a, GlobalV.m809V(), GlobalV.m810W(), true);
                            break;
                        case 2:
                            jy.m1240b(this.f1483a, GlobalV.m809V(), GlobalV.m810W(), true);
                            break;
                        default:
                            this.f1484b = "Sorry, something went wrong with the note creation";
                            break;
                    }
                    if (a.f1424a && !a.f1425b) {
                        this.f1484b = "Your default notes application is no longer installed.";
                    } else if (!a.f1424a) {
                        this.f1484b = "Please take a moment to select your default notes application, from the Settings Tab.";
                    }
                    GlobalV.m893u(false);
                    GlobalV.m880q(false);
                    GlobalV.m854j(0);
                    break;
                    break;
                default:
                    break;
            }
        } else if (GlobalV.m805R()) {
            if (hc.f1269b) {
                ls.m1346c("getFacebookCond: true");
            }
            r0 = GlobalV.m806S();
            if (hc.f1269b) {
                ls.m1344a("facebookStage: " + r0);
            }
            switch (r0) {
                case 1:
                    if (hc.f1269b) {
                        ls.m1346c("facebookCond: " + r0 + " : body");
                    }
                    GlobalV.m874o(m1185a((String) arrayList2.get(0)));
                    if (hc.f1269b) {
                        ls.m1344a("facebookBody: " + m1185a((String) arrayList2.get(0)));
                    }
                    this.f1485c = true;
                    GlobalV.m845h(2);
                    this.f1484b = "Do you want me to read it back to you?";
                    break;
                case 2:
                    if (hc.f1269b) {
                        ls.m1346c("facebookCond: " + r0 + " : read condition");
                    }
                    r0 = jo.m1213a(arrayList2);
                    if (hc.f1269b) {
                        ls.m1346c("ynpResponse.returnStatus: " + r0.f1563a);
                    }
                    if (!r0.f1563a.equals(jp.yes)) {
                        if (!r0.f1563a.equals(jp.no)) {
                            if (r0.f1563a.equals(jp.unclear)) {
                                this.f1485c = true;
                                this.f1484b = "Sorry, could you say that again please.";
                                break;
                            }
                        }
                        this.f1484b = "Okay, I've updated your status.";
                        jw.m1220a(this.f1483a, GlobalV.m803P());
                        m1187b();
                        break;
                    }
                    GlobalV.m899w(true);
                    GlobalV.m845h(3);
                    this.f1485c = true;
                    this.f1484b = "Okay, this is what I heard. " + GlobalV.m803P() + "... Shall I post it?";
                    GlobalV.m844g(true);
                    break;
                    break;
                case 3:
                    if (hc.f1269b) {
                        ls.m1346c("facebookCond: " + r0 + " : send condition");
                    }
                    r0 = jo.m1213a(arrayList2);
                    if (hc.f1269b) {
                        ls.m1346c("ynpResponse.returnStatus: " + r0.f1563a);
                    }
                    if (!r0.f1563a.equals(jp.yes)) {
                        if (!r0.f1563a.equals(jp.no)) {
                            if (r0.f1563a.equals(jp.unclear)) {
                                this.f1485c = true;
                                this.f1484b = "Sorry, could you say that again please.";
                                break;
                            }
                        }
                        this.f1484b = "Okay, I've cancelled that.";
                        m1187b();
                        break;
                    }
                    this.f1484b = "Okay, I've updated your status.";
                    jw.m1220a(this.f1483a, GlobalV.m803P());
                    m1187b();
                    break;
                    break;
                default:
                    break;
            }
        } else if (GlobalV.m807T()) {
            if (hc.f1269b) {
                ls.m1346c("twitterCond: true");
            }
            r0 = GlobalV.m808U();
            if (hc.f1269b) {
                ls.m1344a("twitterStage: " + r0);
            }
            switch (r0) {
                case 1:
                    if (hc.f1269b) {
                        ls.m1346c("twitterCond: " + r0 + " : body");
                    }
                    if (((String) arrayList2.get(0)).length() >= 161) {
                        jy.m1239b(this.f1483a, m1185a((String) arrayList2.get(0)), "");
                        this.f1484b = "Your tweet is a little too long. Please manually edit it.";
                        m1188c();
                        break;
                    }
                    GlobalV.m876p(m1185a((String) arrayList2.get(0)));
                    if (hc.f1269b) {
                        ls.m1344a("twitterBody: " + m1185a((String) arrayList2.get(0)));
                    }
                    this.f1485c = true;
                    GlobalV.m850i(2);
                    if (!lx.m1430h(this.f1483a)) {
                        this.f1484b = "Do you want to proof read it?";
                        break;
                    }
                    GlobalV.m899w(true);
                    this.f1484b = "Okay, this is what I heard. " + GlobalV.m804Q() + "... Do you want to proof read it?";
                    break;
                case 2:
                    if (hc.f1269b) {
                        ls.m1346c("twitterCond: " + r0 + " : proofRead");
                        ls.m1346c("DIB getYNStatus: " + GlobalV.aH());
                    }
                    r0 = jo.m1213a(arrayList2);
                    if (hc.f1269b) {
                        ls.m1346c("ynpResponse.returnStatus: " + r0.f1563a);
                    }
                    if (!r0.f1563a.equals(jp.yes)) {
                        if (!r0.f1563a.equals(jp.no)) {
                            if (r0.f1563a.equals(jp.unclear)) {
                                this.f1485c = true;
                                this.f1484b = "Sorry, could you say that again please.";
                                GlobalV.m893u(true);
                                break;
                            }
                        }
                        if (kl.m1304a(this.f1483a, GlobalV.m804Q())) {
                            this.f1484b = "Okay, that's been tweeted";
                        } else {
                            this.f1484b = "Sorry, something went wrong posting that tweet. Please check Twitter is correctly authorised.";
                            jy.m1239b(this.f1483a, GlobalV.m804Q(), "");
                        }
                        m1188c();
                        break;
                    }
                    jy.m1239b(this.f1483a, GlobalV.m804Q(), "");
                    this.f1484b = "There you go.";
                    m1188c();
                    break;
                    break;
                default:
                    break;
            }
        } else if (GlobalV.m799L()) {
            if (hc.f1269b) {
                ls.m1346c("passwordCond: true");
            }
            r0 = GlobalV.m800M();
            if (hc.f1269b) {
                ls.m1344a("passwordStage: " + r0);
            }
            switch (r0) {
                case 1:
                    if (!((String) arrayList2.get(0)).toLowerCase(locale).trim().replaceAll("\\s", "").matches(lx.m1385X(this.f1483a))) {
                        this.f1484b = "Sorry, but that's not the current password I have stored for you. Your device will self destruct in five seconds.";
                        m1192g();
                        break;
                    }
                    this.f1484b = "Password accepted. Please say your new password.";
                    this.f1485c = true;
                    GlobalV.m842g(2);
                    break;
                case 2:
                    GlobalV.m870n(((String) arrayList2.get(0)).toLowerCase(locale).trim().replaceAll("\\s", ""));
                    if (hc.f1269b) {
                        ls.m1344a("passwordBody: " + ((String) arrayList2.get(0)).toLowerCase(locale).trim().replaceAll("\\s", ""));
                    }
                    this.f1485c = true;
                    GlobalV.m842g(3);
                    this.f1484b = "Please repeat your password.";
                    break;
                case 3:
                    trim = ((String) arrayList2.get(0)).toLowerCase(locale).trim().replaceAll("\\s", "");
                    if (hc.f1269b) {
                        ls.m1344a("passwordMatch: " + trim);
                    }
                    String N = GlobalV.m801N();
                    if (hc.f1269b) {
                        ls.m1344a("passwordOriginal: " + N);
                    }
                    if (trim.matches(N)) {
                        this.f1484b = "Confirmed. Your password has been stored.";
                        lx.m1386Y(this.f1483a);
                        lx.m1431i(this.f1483a, trim);
                    } else {
                        this.f1484b = "Sorry, but those passwords didn't match. Please try again.";
                    }
                    m1192g();
                    break;
                default:
                    break;
            }
        } else if (GlobalV.m791D()) {
            if (hc.f1269b) {
                ls.m1346c("getCallContactCond: true");
            }
            if (((String) arrayList2.get(0)).toLowerCase(locale).contains("mobile")) {
                if (GlobalV.m795H() == null || GlobalV.m795H().isEmpty() || GlobalV.m795H().matches("")) {
                    this.f1484b = "Sorry, but I don't have a mobile number listed for " + GlobalV.m792E();
                } else {
                    jy.m1272w(this.f1483a, "tel:" + GlobalV.m795H());
                }
            } else if (((String) arrayList2.get(0)).toLowerCase(locale).contains("home")) {
                if (GlobalV.m793F() == null || GlobalV.m793F().isEmpty() || GlobalV.m793F().matches("")) {
                    this.f1484b = "Sorry, but I don't have a home number listed for " + GlobalV.m792E();
                } else {
                    jy.m1272w(this.f1483a, "tel:" + GlobalV.m793F());
                }
            } else if (((String) arrayList2.get(0)).toLowerCase(locale).contains("work")) {
                if (GlobalV.m794G() == null || GlobalV.m794G().isEmpty() || GlobalV.m794G().matches("")) {
                    this.f1484b = "Sorry, but I don't have a work number listed for " + GlobalV.m792E();
                } else {
                    jy.m1272w(this.f1483a, "tel:" + GlobalV.m794G());
                }
            }
            this.f1485c = false;
            GlobalV.m893u(false);
            GlobalV.m864l(false);
            GlobalV.m851i("");
            GlobalV.m855j("");
            GlobalV.m859k("");
            GlobalV.m846h("");
        } else if (GlobalV.m836e()) {
            if (hc.f1269b) {
                ls.m1346c("getUnknownCondition: true");
            }
            listIterator = arrayList2.listIterator();
            boolean m = jy.m1262m(this.f1483a, "com.wolfram.android.alpha");
            while (listIterator.hasNext()) {
                trim = ((String) listIterator.next()).toString().toLowerCase(locale).trim();
                if (hc.f1269b) {
                    ls.m1344a("mypass: " + trim);
                }
                if (m && (trim.contains("wolfram") || trim.matches("alpha"))) {
                    this.f1484b = "Okay. There you go.";
                    jy.m1238b(this.f1483a, GlobalV.m829d().replaceAll(" ", "%20"));
                    this.f1488f = true;
                    this.f1485c = false;
                    GlobalV.m893u(false);
                    break;
                } else if (trim.contains("google") || (trim.contains("web") && trim.contains("search"))) {
                    this.f1484b = "Okay. There you go.";
                    jn.f1553a = true;
                    jy.m1274y(this.f1483a, "http://google." + jn.m1212a() + "/search?q=" + GlobalV.m829d());
                    this.f1488f = true;
                    this.f1485c = false;
                    GlobalV.m893u(false);
                    break;
                }
            }
            if (this.f1488f) {
                GlobalV.m819a(false);
                GlobalV.m817a("");
            }
        }
        return arrayList2;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        if (hc.f1269b) {
            ls.m1345b("EstablishResponse onPostEx");
        }
        if (!GlobalV.m836e() || this.f1488f) {
            if (this.f1485c) {
                if (hc.f1269b) {
                    ls.m1346c("startRecog: true");
                }
                lc.m1313a(this.f1483a, true, this.f1484b);
            } else {
                if (hc.f1269b) {
                    ls.m1346c("startRecog: false");
                }
                lc.m1313a(this.f1483a, false, this.f1484b);
            }
            if (this.f1487e) {
                if (hc.f1270c) {
                    if (VERSION.SDK_INT >= 11) {
                        kz.f1636e = true;
                        kz.f1646o = GlobalV.m841g();
                        new kz(this.f1483a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    } else {
                        new kz(this.f1483a).execute(new Void[0]);
                    }
                }
                m1186a();
            }
            this.f1488f = false;
        } else {
            GlobalV.m819a(false);
            GlobalV.m817a("");
            GlobalV.m893u(false);
            if (VERSION.SDK_INT >= 11) {
                new hs(this.f1483a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{arrayList});
            } else {
                new hs(this.f1483a).execute(new ArrayList[]{arrayList});
            }
        }
        super.onPostExecute(arrayList);
    }

    protected final void onPreExecute() {
        super.onPreExecute();
        if (hc.f1269b) {
            ls.m1345b("EstablishResponse onPreEx");
        }
    }

    protected final /* synthetic */ void onProgressUpdate(Object... objArr) {
        Integer[] numArr = (Integer[]) objArr;
        if (hc.f1269b) {
            ls.m1345b("EstablishResponse onProgressUpdate");
        }
        super.onProgressUpdate(numArr);
    }
}
