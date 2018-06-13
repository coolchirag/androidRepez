package com.brandall.nutter;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Locale;
import java.util.regex.Pattern;
import wei.mark.standout.StandOutWindow;

public final class nl extends AsyncTask<ArrayList<String>, String, Void> {
    static Context f1774a;
    private static final Pattern f1775f = Pattern.compile(".*\\bmail\\b.*");
    private static final Pattern f1776g = Pattern.compile(".*\\bmale\\b.*");
    private static final Pattern f1777h = Pattern.compile(".*\\bfemale\\b.*");
    private static final Pattern f1778i = Pattern.compile(".*\\bboy\\b.*");
    private static final Pattern f1779j = Pattern.compile(".*\\bgirl\\b.*");
    private static final Pattern f1780k = Pattern.compile(".*\\bwoman\\b.*");
    private static final Pattern f1781l = Pattern.compile(".*\\bman\\b.*");
    private static final Pattern f1782m = Pattern.compile(".*\\blady\\b.*");
    private static final Pattern f1783n = Pattern.compile(".*\\bgentleman\\b.*");
    private static final Pattern f1784o = Pattern.compile(".*\\bhermaphrodite\\b.*");
    private static boolean f1785q = false;
    private static boolean f1786r = false;
    private static boolean f1787s = false;
    int f1788b = 0;
    private final String f1789c = "hello how are you today";
    private final String f1790d = "what's the time";
    private final String f1791e = "what's the time";
    private String f1792p = "";
    private final Locale f1793t = Locale.US;

    public nl(Context context) {
        f1774a = context;
    }

    private Void m1495a(ArrayList<String>... arrayListArr) {
        boolean z = false;
        ArrayList arrayList = (arrayListArr == null || arrayListArr.length <= 0) ? new ArrayList() : arrayListArr[0];
        if (!arrayList.contains("cancel ")) {
            int m = GlobalV.m865m();
            if (m == 98) {
                m = 99;
            }
            if (hc.f1269b) {
                ls.m1344a("TutorialStage: " + m);
            }
            Intent intent;
            ListIterator listIterator;
            boolean z2;
            boolean nextIndex;
            String trim;
            int i;
            jq a;
            switch (m) {
                case 0:
                    if (hc.f1269b) {
                        ls.m1347d("TutorialStage: 0");
                    }
                    this.f1792p = "Sorry, something went wrong with the tutorial";
                    m1496a(f1774a);
                    break;
                case 1:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                    }
                    intent = new Intent(f1774a, ActivityCommand.class);
                    intent.setFlags(268566528);
                    f1774a.startActivity(intent);
                    this.f1792p = "First place we'll go is the command list where the in-built structured commands are detailed. I'm going to give you thirty seconds to memorise them all, and then we'll start the test. Go. ";
                    f1785q = false;
                    break;
                case 2:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                    }
                    lc.f1666a = true;
                    this.f1792p = "";
                    f1785q = false;
                    break;
                case 3:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                    }
                    this.f1792p = "Just kidding. There's a lot to take in here, but don't worry, you don't have to memorise every one to use the application, as each command below can be changed to your liking in the Customization section. In a moment we'll check how accurately Google Voice Search works for you. If it doesn't work well, you'll need to tweak these commands accordingly. You can float this command list any time you need a reminder of what to say. You can do this by simply saying, float commands, and this box will appear. ";
                    f1785q = false;
                    break;
                case 4:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                    }
                    if (VERSION.SDK_INT >= 16) {
                        this.f1792p = "My creator needs a few tips on formatting, but it gets the job done. You can resize it and move it around the screen, so it doesn't get in the way too much. Okay, let's try a command or two and I'll show you what Google is sending back for me to work with. The time to start speaking is when the device beeps";
                    } else {
                        this.f1792p = "My creator needs a few tips on formatting, but it gets the job done. You can resize it and move it around the screen, so it doesn't get in the way too much. Okay, let's try a command or two and I'll show you what Google is sending back for me to work with. The time to start speaking is when the device vibrates";
                    }
                    f1785q = false;
                    break;
                case 5:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                    }
                    try {
                        f1774a.stopService(new Intent(f1774a, VoiceResultsWindow.class));
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (hc.f1269b) {
                            ls.m1347d("visualSet failed to stop service");
                        }
                    }
                    lt.m1352a(f1774a.getApplicationContext(), "I'm listening...", "utter!", "is listening...", 17301668, false, 0, 1);
                    lt.m1349a(1);
                    this.f1792p = "and the listening notification appears in the status bar. Starting to speak too soon is a common reason users get poor results. Right, let's get on with it. Just a couple of things to remember. Please speak to me in a perfectly natural way, just as if you were chatting to a friend. Don't speak louder than normal, or attempt to over annunciate your words. The recognition will be much more accurate this way, and also improve much quicker with your usage. Okay, here we go. Please repeat after me.";
                    f1785q = false;
                    break;
                case 6:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                    }
                    this.f1792p = "Hello, how are you today?";
                    f1785q = true;
                    break;
                case 7:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    if (arrayList.isEmpty()) {
                        GlobalV.m830d(3);
                        this.f1792p = "Something went wrong, as I didn't get any speech data returned. Let's try another one. Repeat after me. What's the time";
                    } else {
                        GlobalV.m823b(arrayList);
                        StandOutWindow.m741a(f1774a.getApplicationContext(), VoiceResultsWindow.class, 0);
                        listIterator = arrayList.listIterator();
                        z2 = false;
                        while (listIterator.hasNext()) {
                            nextIndex = listIterator.nextIndex();
                            trim = ((String) listIterator.next()).toString().toLowerCase(this.f1793t).trim();
                            if (hc.f1269b) {
                                ls.m1344a("ucPass: " + trim);
                            }
                            if (trim.matches("hello how are you today")) {
                                z = true;
                                if (z) {
                                    if (hc.f1269b) {
                                        ls.m1347d("Match: false");
                                    }
                                    GlobalV.m830d(3);
                                    this.f1792p = "Well that didn't go too well, as it's not appeared in the list of returned results. We won't panic just yet, let's try something else. Repeat after me. What's the time";
                                } else {
                                    if (hc.f1269b) {
                                        ls.m1346c("rdInt: " + i);
                                    }
                                    if (i != 0) {
                                        GlobalV.m830d(1);
                                        this.f1792p = "Excellent. Google Voice Search returned that nice and clearly as the top entry. Let's try another. Repeat after me. What's the time";
                                    } else if (i <= 0 && i < 6) {
                                        GlobalV.m830d(1);
                                        this.f1792p = "Good. That wasn't too bad. It wasn't the top result returned by Google, but I analyse everything that is sent back, so I would have understood you and spotted the command at entry number " + (i + 1) + "Let's try another. Repeat after me. What's the time";
                                    } else if (i > 5 || i >= 11) {
                                        GlobalV.m830d(2);
                                        this.f1792p = "Okay, not a great start as it was right down the list in position number " + (i + 1) + ", but I would have seen it and understood what you meant, as I check every entry in the list. Let's try another. Repeat after me. What's the time";
                                    } else {
                                        GlobalV.m830d(2);
                                        this.f1792p = "That wasn't great. It was quite far down the list in position number " + (i + 1) + ", but I still would have spotted it, as I analyse every returned sentence. Let's try another. Repeat after me. What's the time";
                                    }
                                }
                            } else {
                                z2 = nextIndex;
                            }
                        }
                        i = z2;
                        if (z) {
                            if (hc.f1269b) {
                                ls.m1347d("Match: false");
                            }
                            GlobalV.m830d(3);
                            this.f1792p = "Well that didn't go too well, as it's not appeared in the list of returned results. We won't panic just yet, let's try something else. Repeat after me. What's the time";
                        } else {
                            if (hc.f1269b) {
                                ls.m1346c("rdInt: " + i);
                            }
                            if (i != 0) {
                                if (i <= 0) {
                                    break;
                                }
                                if (i > 5) {
                                }
                                GlobalV.m830d(2);
                                this.f1792p = "Okay, not a great start as it was right down the list in position number " + (i + 1) + ", but I would have seen it and understood what you meant, as I check every entry in the list. Let's try another. Repeat after me. What's the time";
                            } else {
                                GlobalV.m830d(1);
                                this.f1792p = "Excellent. Google Voice Search returned that nice and clearly as the top entry. Let's try another. Repeat after me. What's the time";
                            }
                        }
                    }
                    f1785q = true;
                    break;
                case 8:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    try {
                        StandOutWindow.m740a(f1774a.getApplicationContext(), VoiceResultsWindow.class);
                    } catch (Exception e2) {
                        ls.m1348e("StandOutWindow.closeAll: " + e2.toString());
                    }
                    if (!arrayList.isEmpty()) {
                        GlobalV.m823b(arrayList);
                        StandOutWindow.m741a(f1774a.getApplicationContext(), VoiceResultsWindow.class, 0);
                        listIterator = arrayList.listIterator();
                        z2 = false;
                        while (listIterator.hasNext()) {
                            nextIndex = listIterator.nextIndex();
                            trim = ((String) listIterator.next()).toString().toLowerCase(this.f1793t).trim();
                            if (hc.f1269b) {
                                ls.m1344a("ucPass: " + trim);
                            }
                            if (trim.matches("what's the time") || trim.matches("what's the time")) {
                                z = true;
                                m = GlobalV.m861l();
                                if (!z) {
                                    if (hc.f1269b) {
                                        ls.m1346c("rdInt: " + i);
                                        ls.m1346c("currentSuccessLevel: " + m);
                                    }
                                    if (i != 0) {
                                        if (i > 0 || i >= 6) {
                                            if (i <= 5 && i < 11) {
                                                GlobalV.m830d(m + 2);
                                                switch (m) {
                                                    case 1:
                                                        this.f1792p = "Not quite as good as last time, as it's quite far down the list in position " + (i + 1) + ". But I still would have spotted it. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                                        break;
                                                    case 2:
                                                        this.f1792p = "About the same as last time, as it's quite far down the list in position " + (i + 1) + ". But I still would have spotted it. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                                        break;
                                                    case 3:
                                                        this.f1792p = "It was definitely better than last time, although it's still quite far down the list in position " + (i + 1) + ". But I still would have seen it and understood you. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                                        break;
                                                    default:
                                                        break;
                                                }
                                            }
                                            GlobalV.m830d(m + 2);
                                            switch (m) {
                                                case 1:
                                                    this.f1792p = "Not as good as last time, as it's quite far down the list in position " + (i + 1) + ". But I still would have spotted it. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                                    break;
                                                case 2:
                                                    this.f1792p = "About the same as last time, as it's quite far down the list in position " + (i + 1) + ". But I still would have spotted it. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                                    break;
                                                case 3:
                                                    this.f1792p = "It was definitely better than last time, although it's still quite far down the list in position " + (i + 1) + ". But I still would have seen it and understood you. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }
                                        GlobalV.m830d(m + 1);
                                        switch (m) {
                                            case 1:
                                                this.f1792p = "Great. It wasn't the top entry, but I would have still understood what you meant. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                                break;
                                            case 2:
                                                this.f1792p = "That's much better. It wasn't the top result, but higher than last time. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                                break;
                                            case 3:
                                                this.f1792p = "That's much better. It wasn't the top result, but much higher than last time. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                    GlobalV.m830d(m + 1);
                                    switch (m) {
                                        case 1:
                                            this.f1792p = "Excellent. The top result, this is going well. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                            break;
                                        case 2:
                                            this.f1792p = "That's much better. Google Voice Search returned that nice and clearly as the top entry. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                            break;
                                        case 3:
                                            this.f1792p = "That's much better. Google Voice Search returned that nice and clearly as the top entry. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                            break;
                                    }
                                }
                                if (hc.f1269b) {
                                    ls.m1347d("Match: false");
                                }
                                GlobalV.m830d(m + 3);
                                switch (m) {
                                    case 1:
                                        this.f1792p = "It didn't go as well as last time, as it's not appeared in the list of returned results. We won't panic just yet though. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                        break;
                                    case 2:
                                        this.f1792p = "It didn't go as well as last time, as it's not appeared in the list of returned results. We won't panic just yet though. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                        break;
                                    case 3:
                                        this.f1792p = "Okay, not great, as this time it's not appeared in the list of returned results at all. We won't panic just yet though. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                        break;
                                    default:
                                        break;
                                }
                            }
                            z2 = nextIndex;
                        }
                        i = z2;
                        m = GlobalV.m861l();
                        if (!z) {
                            if (hc.f1269b) {
                                ls.m1347d("Match: false");
                            }
                            GlobalV.m830d(m + 3);
                            switch (m) {
                                case 1:
                                    this.f1792p = "It didn't go as well as last time, as it's not appeared in the list of returned results. We won't panic just yet though. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                    break;
                                case 2:
                                    this.f1792p = "It didn't go as well as last time, as it's not appeared in the list of returned results. We won't panic just yet though. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                    break;
                                case 3:
                                    this.f1792p = "Okay, not great, as this time it's not appeared in the list of returned results at all. We won't panic just yet though. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (hc.f1269b) {
                            ls.m1346c("rdInt: " + i);
                            ls.m1346c("currentSuccessLevel: " + m);
                        }
                        if (i != 0) {
                            GlobalV.m830d(m + 1);
                            switch (m) {
                                case 1:
                                    this.f1792p = "Excellent. The top result, this is going well. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                    break;
                                case 2:
                                    this.f1792p = "That's much better. Google Voice Search returned that nice and clearly as the top entry. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                    break;
                                case 3:
                                    this.f1792p = "That's much better. Google Voice Search returned that nice and clearly as the top entry. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                    break;
                            }
                        }
                        if (i > 0) {
                            break;
                        }
                        if (i <= 5) {
                        }
                        GlobalV.m830d(m + 2);
                        switch (m) {
                            case 1:
                                this.f1792p = "Not as good as last time, as it's quite far down the list in position " + (i + 1) + ". But I still would have spotted it. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                break;
                            case 2:
                                this.f1792p = "About the same as last time, as it's quite far down the list in position " + (i + 1) + ". But I still would have spotted it. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                break;
                            case 3:
                                this.f1792p = "It was definitely better than last time, although it's still quite far down the list in position " + (i + 1) + ". But I still would have seen it and understood you. Let's get to know each other a little better. Tell me, are you male, or female. ";
                                break;
                            default:
                                break;
                        }
                    }
                    GlobalV.m830d(3);
                    this.f1792p = "Something went wrong, as I didn't get any speech data returned. Never mind, we'll keep going. Let's get to know each other a little better. Tell me, are you male, or female. ";
                    f1785q = true;
                    break;
                case 9:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    try {
                        StandOutWindow.m740a(f1774a.getApplicationContext(), VoiceResultsWindow.class);
                    } catch (Exception e22) {
                        ls.m1348e("StandOutWindow.closeAll: " + e22.toString());
                    }
                    if (arrayList.isEmpty()) {
                        this.f1792p = "Something went wrong, as I didn't get any speech data returned. Never mind, we'll keep going. I'm going to ask you to tell me your name. You can change how I address you when you activate me by saying the command, call me, followed by your name. So, I would say, call me, utter. After the vibrate, try this command.";
                    } else {
                        GlobalV.m823b(arrayList);
                        StandOutWindow.m741a(f1774a.getApplicationContext(), VoiceResultsWindow.class, 0);
                        ListIterator listIterator2 = arrayList.listIterator();
                        if (f1776g.matcher((CharSequence) arrayList.get(0)).matches()) {
                            z2 = true;
                        } else if (f1777h.matcher((CharSequence) arrayList.get(0)).matches()) {
                            z2 = false;
                            z = true;
                        } else {
                            boolean z3 = false;
                            nextIndex = false;
                            int i2 = 0;
                            int i3 = 0;
                            while (listIterator2.hasNext()) {
                                CharSequence trim2 = ((String) listIterator2.next()).toString().toLowerCase(this.f1793t).trim();
                                if (hc.f1269b) {
                                    ls.m1344a("ucPass: " + trim2);
                                }
                                if (f1776g.matcher(trim2).matches() || f1781l.matcher(trim2).matches() || f1778i.matcher(trim2).matches() || f1775f.matcher(trim2).matches() || f1783n.matcher(trim2).matches()) {
                                    i3++;
                                    nextIndex = !z3 ? true : nextIndex;
                                } else if (f1777h.matcher(trim2).matches() || f1780k.matcher(trim2).matches() || f1779j.matcher(trim2).matches() || f1782m.matcher(trim2).matches()) {
                                    i2++;
                                    z3 = !nextIndex ? true : z3;
                                } else if (f1784o.matcher(trim2).matches()) {
                                    z2 = true;
                                    if (!z2) {
                                        this.f1792p = "Well I'm sure that has many advantages. Next, I'm going to ask you to tell me your name. You can change how I address you when you activate me by saying the command, call me, followed by your name. So, I would say, call me, utter. After the vibrate, try this command.";
                                    } else if (i3 > i2) {
                                        z2 = true;
                                    } else if (i2 <= i3) {
                                        z2 = false;
                                        z = true;
                                    } else if (i3 != 0 && i2 == 0) {
                                        this.f1792p = "I didn't detect your answer in the results. Never mind, let's try again. Tell me, are you male, or female.";
                                        GlobalV.m833e(GlobalV.m865m() - 1);
                                        z2 = false;
                                    } else if (nextIndex) {
                                        z2 = true;
                                    } else if (z3) {
                                        z2 = false;
                                        z = true;
                                    }
                                    z2 = false;
                                }
                            }
                            z2 = false;
                            if (!z2) {
                                this.f1792p = "Well I'm sure that has many advantages. Next, I'm going to ask you to tell me your name. You can change how I address you when you activate me by saying the command, call me, followed by your name. So, I would say, call me, utter. After the vibrate, try this command.";
                            } else if (i3 > i2) {
                                z2 = true;
                            } else if (i2 <= i3) {
                                if (i3 != 0) {
                                }
                                if (nextIndex) {
                                    z2 = true;
                                } else if (z3) {
                                    z2 = false;
                                    z = true;
                                }
                            } else {
                                z2 = false;
                                z = true;
                            }
                            z2 = false;
                        }
                        if (z2) {
                            lx.m1423f(f1774a, "M");
                            this.f1792p = "Great, men are so much more predictable. Next, I'm going to ask you to tell me your name. You can change how I address you when you activate me by saying the command, call me, followed by your name. So, I would say, call me, utter. After the vibrate, try this command.";
                        } else if (z) {
                            lx.m1423f(f1774a, "F");
                            this.f1792p = "Great, girls are much more intelligent, so I'm glad. Next, I'm going to ask you to tell me your name. You can change how I address you when you activate me by saying the command, call me, followed by your name. So, I would say, call me, utter. After the vibrate, try this command.";
                        }
                    }
                    f1785q = true;
                    break;
                case 10:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    try {
                        StandOutWindow.m740a(f1774a.getApplicationContext(), VoiceResultsWindow.class);
                    } catch (Exception e222) {
                        ls.m1348e("StandOutWindow.closeAll: " + e222.toString());
                    }
                    if (arrayList.isEmpty()) {
                        this.f1792p = "Something went wrong, as I didn't get any speech data returned. Never mind, let's try again. Say the command, call me, followed by your name. ";
                        GlobalV.m833e(GlobalV.m865m() - 1);
                    } else {
                        GlobalV.m823b(arrayList);
                        StandOutWindow.m741a(f1774a.getApplicationContext(), VoiceResultsWindow.class, 0);
                        String str = "";
                        String trim3 = ((String) arrayList.get(0)).toLowerCase(this.f1793t).trim();
                        if (Pattern.compile("[\\*]+").matcher(trim3).find()) {
                            this.f1792p = "Sorry, but your name contained an illegal character. Let's try again. Say the command, call me, followed by your name. ";
                            GlobalV.m833e(GlobalV.m865m() - 1);
                        } else {
                            String[] strArr = null;
                            if (trim3.contains("call me ")) {
                                strArr = trim3.split("call me ");
                                trim3 = str;
                            } else if (trim3.contains("name is ")) {
                                strArr = trim3.split("name is ");
                                trim3 = str;
                            } else if (trim3.contains("called ")) {
                                strArr = trim3.split("called ");
                                trim3 = str;
                            } else if (trim3.contains("name's ")) {
                                strArr = trim3.split("name's ");
                                trim3 = str;
                            } else if (trim3.contains("i am ")) {
                                strArr = trim3.split("i am ");
                                trim3 = str;
                            } else if (trim3.matches("call me")) {
                                trim3 = "";
                                strArr = null;
                            } else if (trim3.contains(" ")) {
                                strArr = trim3.split(" ", 2);
                                trim3 = str;
                            }
                            if (trim3.matches("") && strArr != null && strArr.length > 1) {
                                trim3 = strArr[1].trim();
                            } else if (trim3.matches("")) {
                                this.f1792p = "Something went wrong trying to work out your name. Never mind, let's try again. Say the command, call me, followed by your name. ";
                                GlobalV.m833e(GlobalV.m865m() - 1);
                            }
                            if (hc.f1269b) {
                                ls.m1344a("name: " + trim3);
                            }
                            lx.m1411c(f1774a, trim3, true);
                            if (io.m1181a(trim3)) {
                                this.f1792p = "That's the most unusual name, " + trim3 + ".  Are you sure that's what you want me to call you?";
                                lx.m1411c(f1774a, trim3, true);
                            } else if (!trim3.matches("")) {
                                this.f1792p = "I heard your name as, " + trim3 + ".  Is that correct?";
                                lx.m1411c(f1774a, trim3, true);
                            }
                        }
                    }
                    f1785q = true;
                    break;
                case 11:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    try {
                        StandOutWindow.m740a(f1774a.getApplicationContext(), VoiceResultsWindow.class);
                    } catch (Exception e2222) {
                        ls.m1348e("StandOutWindow.closeAll: " + e2222.toString());
                    }
                    if (!arrayList.isEmpty()) {
                        GlobalV.m823b(arrayList);
                        StandOutWindow.m741a(f1774a.getApplicationContext(), VoiceResultsWindow.class, 0);
                        a = jo.m1213a(arrayList);
                        if (hc.f1269b) {
                            ls.m1346c("ynpResponse.returnStatus: " + a.f1563a);
                        }
                        if (!a.f1563a.equals(jp.yes)) {
                            if (!a.f1563a.equals(jp.no)) {
                                if (a.f1563a.equals(jp.unclear)) {
                                    this.f1792p = "Sorry, could you say that again please.";
                                    GlobalV.m833e(GlobalV.m865m() - 1);
                                    f1785q = true;
                                    break;
                                }
                            }
                            lx.m1411c(f1774a, "", false);
                            if (GlobalV.m857k() != 0) {
                                GlobalV.m825c(0);
                                intent = new Intent(f1774a, ActivityBugs.class);
                                intent.setFlags(872415232);
                                f1774a.startActivity(intent);
                                try {
                                    StandOutWindow.m740a(f1774a.getApplicationContext(), VoiceResultsWindow.class);
                                } catch (Exception e22222) {
                                    ls.m1348e("StandOutWindow.closeAll: " + e22222.toString());
                                }
                                this.f1792p = "Okay, please type your name into the box at the top for me. Spell it phonetically if you think that's necessary, then press the run button, and I'll read it back to you. ";
                                GlobalV.m833e(98);
                                f1785q = false;
                                break;
                            }
                            GlobalV.m825c(1);
                            this.f1792p = "Oh dear. Never mind, let's try once more. If this doesn't work, you can type it for me to read. After the vibrate, please say the command, call me, followed by your name. ";
                            GlobalV.m833e(GlobalV.m865m() - 2);
                            f1785q = true;
                            break;
                        }
                        GlobalV.m825c(0);
                        this.f1792p = "Great. It's a pleasure to meet you " + lx.ag(f1774a) + ".  Okay, let's head over to the customisation section, where the fun really starts. ";
                        f1785q = false;
                        break;
                    }
                    this.f1792p = "Sorry, something went wrong as I didn't get any speech data. Could you say that again please.";
                    GlobalV.m833e(GlobalV.m865m() - 1);
                    f1785q = true;
                    break;
                    break;
                case 12:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    try {
                        StandOutWindow.m740a(f1774a.getApplicationContext(), VoiceResultsWindow.class);
                    } catch (Exception e222222) {
                        ls.m1348e("StandOutWindow.closeAll: " + e222222.toString());
                    }
                    this.f1792p = "If you scroll up and down you'll see all the fun you're about to have, tweaking the things I can do and say. You can create entire conversations and baffle your friends with exactly how much I appear to know, about the most random of subjects. You can make me burp se~burp and fart se~fart giggle se~giggle cough se~cough and fart again se~fart or make any sound effect you download and place on your external storage. ";
                    jk.m1209b(f1774a, this.f1792p);
                    f1785q = false;
                    break;
                case 13:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    this.f1792p = "Each of these menus has a help button you can press, and I'll explain how the features work, and give you some examples to be getting on with. Right, let's go to the settings menu. ";
                    f1785q = false;
                    break;
                case 14:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    this.f1792p = "There a plenty of tweaks here to be keeping you busy, from ways you can activate me, to setting your default applications that I'll use when executing your commands. The same as the customisation section, each setting has a help button you can press, so I can explain the usage further. You'll notice that some of the features are marked, coming soon. Sorry to disappoint, they will be available to test as soon as my creator gets his ass into gear. Next, let's go to the Linked Applications section. ";
                    f1785q = false;
                    break;
                case 15:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    this.f1792p = "Here you'll see the applications that I am currently compatible with, or will be within the next couple of releases. For security reasons, you'll need to manually authorise most of the applications here. If you are a more advanced user, I can execute any of your Tasker tasks for you. ";
                    f1785q = false;
                    break;
                case 16:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    this.f1792p = "Details of how to use the Tasker plug in can be found in the user guide, which also contains a sample project. The user guide has many sections, from basic usage, to sound effects, translation, and the most common solutions to bugs. Please do take the time to read the links if you are having a problem. ";
                    f1785q = false;
                    break;
                case 17:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    this.f1792p = "Finally, the recognition and voices section gives you a chance to test the alternative recognition providers. They will be available to use across the entire application very soon, so if Google Voice Search just doesn't work well for you, then all is not lost. These providers also have custom network synthesised voices, which sound pretty good. They'll be available too. Scrolling down you'll find links to voice engines you can install from the Play Store. Please be aware, if you use Ivona, it may sound fantastic, but can often take over 10 seconds to initialize. Ivona is still in beta, so I'm sure they'll correct that issue soon, and I'm certain you're very patient with applications that are in beta, and the little bugs they may have. Or at least I hope so. Okay. I think I've waffled enough. Please remember that each setting has a help button in, so a quick tap of that, and I'll be back to explain in more detail how to use each feature. I hope we're going to have some fun together, and you'll find me super useful. Speak soon.";
                    f1787s = true;
                    break;
                case 18:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    m1496a(f1774a);
                    break;
                case 19:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    m1496a(f1774a);
                    break;
                case 20:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    m1496a(f1774a);
                    break;
                case 99:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                        ls.m1346c("responseData: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    try {
                        StandOutWindow.m740a(f1774a.getApplicationContext(), VoiceResultsWindow.class);
                    } catch (Exception e2222222) {
                        ls.m1348e("StandOutWindow.closeAll: " + e2222222.toString());
                    }
                    if (!arrayList.isEmpty()) {
                        f1786r = false;
                        trim = ((String) arrayList.get(0)).replaceFirst("call me ", "");
                        this.f1792p = "I'm going to call you " + trim + ".  Is that correct?";
                        lx.m1411c(f1774a, trim, true);
                        f1785q = true;
                        break;
                    }
                    f1786r = true;
                    break;
                case 100:
                    if (hc.f1269b) {
                        ls.m1346c("TutorialStage: " + m);
                        ls.m1346c("responseDate: " + arrayList.size() + " : " + arrayList.toString());
                    }
                    f1786r = false;
                    lt.m1349a(1);
                    if (!arrayList.isEmpty()) {
                        a = jo.m1213a(arrayList);
                        if (hc.f1269b) {
                            ls.m1346c("ynpResponse.returnStatus: " + a.f1563a);
                        }
                        if (!a.f1563a.equals(jp.yes)) {
                            if (!a.f1563a.equals(jp.no)) {
                                if (a.f1563a.equals(jp.unclear)) {
                                    this.f1792p = "Sorry, could you say that again please.";
                                    GlobalV.m833e(GlobalV.m865m() - 1);
                                    f1785q = true;
                                    break;
                                }
                            }
                            lx.m1411c(f1774a, "", false);
                            if (GlobalV.m857k() != 0) {
                                GlobalV.m825c(0);
                                this.f1792p = "Okay. You can return here to the Troubleshooting tab at any time, to test further phonetic spellings of your name, but for now, let's move on to the customisation section, where the fun really starts. ";
                                GlobalV.m833e(11);
                                f1785q = false;
                                break;
                            }
                            GlobalV.m825c(1);
                            this.f1792p = "Oh dear. Never mind. Try typing the phonetic spelling of your name once more. If it still doesn't sound right, you can return here another time. ";
                            GlobalV.m833e(98);
                            f1785q = false;
                            break;
                        }
                        GlobalV.m825c(0);
                        this.f1792p = "Great. It's a pleasure to meet you " + lx.ag(f1774a) + ".  Okay, let's head over to the customisation section, where the fun really starts. ";
                        GlobalV.m833e(11);
                        f1785q = false;
                        break;
                    }
                    this.f1792p = "Sorry, something went wrong as I didn't get any speech data. Could you say that again please.";
                    GlobalV.m833e(GlobalV.m865m() - 1);
                    f1785q = true;
                    break;
                    break;
            }
        }
        this.f1792p = "Okay.";
        m1496a(f1774a);
        return null;
    }

    public static void m1496a(Context context) {
        if (hc.f1269b) {
            ls.m1346c("VoiceTutorial tidyVariables");
        }
        GlobalV.m833e(0);
        GlobalV.m830d(0);
        GlobalV.m825c(0);
        GlobalV.m821b(0);
        ServiceTTS.f854f = false;
        ServiceTTS.f855g = false;
        f1785q = false;
        f1786r = false;
        ly.m1460a(context, 12000, false);
        lt.m1349a(399);
    }

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        return m1495a((ArrayList[]) objArr);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Void voidR = (Void) obj;
        if (hc.f1269b) {
            ls.m1345b("VoiceTutorial onPostEx");
        }
        if (!f1786r) {
            if (f1785q) {
                ls.m1346c("startRecog: true");
                lc.m1313a(f1774a, true, this.f1792p);
            } else {
                ls.m1346c("startRecog: false");
                lc.m1313a(f1774a, false, this.f1792p);
            }
        }
        if (f1787s) {
            f1787s = false;
            if (hc.f1270c) {
                kz.f1638g = true;
                if (VERSION.SDK_INT >= 11) {
                    new kz(f1774a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } else {
                    new kz(f1774a).execute(new Void[0]);
                }
            }
        }
        super.onPostExecute(voidR);
    }

    protected final /* synthetic */ void onProgressUpdate(Object... objArr) {
        String[] strArr = (String[]) objArr;
        super.onProgressUpdate(strArr);
        Toast.makeText(f1774a, strArr[0], 0).show();
    }
}
