package com.brandall.nutter;

import android.content.Context;
import java.util.ArrayList;
import java.util.Random;

public final class lv {
    static final Random f1699a = new Random();

    public static String m1356a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Fatty");
        arrayList.add("Stupid face");
        arrayList.add("Turnip sniffer");
        arrayList.add("Tree hugger");
        arrayList.add("Bum face");
        arrayList.add("Criminal");
        arrayList.add("Purse snatcher");
        arrayList.add("Bad breath");
        arrayList.add("Balloon blower");
        arrayList.add("Frog kisser");
        arrayList.add("Burp breath");
        arrayList.add("Dog breath");
        arrayList.add("Bum tickler");
        arrayList.add("Bogie nose");
        arrayList.add("Bogie breath");
        arrayList.add("Bogie face");
        arrayList.add("Fart breath");
        arrayList.add("Fart sniffer");
        arrayList.add("Fart face");
        arrayList.add("Dumbo");
        arrayList.add("Window licker");
        arrayList.add("Cheese sniffer");
        arrayList.add("Poo face");
        arrayList.add("Geek");
        arrayList.add("Idiot");
        arrayList.add("Bum sniffer");
        arrayList.add("Onion breath");
        arrayList.add("Total idiot");
        arrayList.add("Nose blower");
        arrayList.add("Bum smacker");
        arrayList.add("Wolly");
        arrayList.add("Nerd");
        arrayList.add("Ugly");
        arrayList.add("Dog patter");
        arrayList.add("Idiot face");
        arrayList.add("Brain dead");
        arrayList.add("Thicky");
        return (String) arrayList.get(f1699a.nextInt(arrayList.size() - 1));
    }

    public static String m1357a(Context context) {
        ArrayList arrayList = new ArrayList();
        String string = context.getSharedPreferences("utterPref", 0).getString("user_name", "master");
        ls.m1346c("Shared Prefs userName: " + string);
        if (string.matches("master")) {
            arrayList.add("Sorry, but I didn't understand that request. Could you say it again please?");
            arrayList.add("Sorry, you lost me on that command. Could you repeat it.");
            arrayList.add("Sorry, but I'm not sure what you meant by that. Please say it again.");
            arrayList.add("That command meant nothing to me I'm afraid. Please try again.");
            arrayList.add("Sorry, but I don't think I heard you correctly on that command. Could you say it again please?");
            arrayList.add("Sorry, but I couldn't decipher that command. Try again.");
            arrayList.add("Really sorry, but I couldn't make out a command. What did you say?");
        } else {
            arrayList.add("Sorry, but I didn't understand that request. Could you say it again please?");
            arrayList.add("Sorry, you lost me on that command. Could you repeat it.");
            arrayList.add("Sorry, but I'm not sure what you meant by that. Please say it again.");
            arrayList.add("That command meant nothing to me I'm afraid. Please try again.");
            arrayList.add("Sorry, but I don't think I heard you correctly on that command. Could you say it again please?");
            arrayList.add("Sorry, but I couldn't decipher that command. Try again.");
            arrayList.add("Really sorry, but I couldn't make out a command. What did you say?");
            arrayList.add("Sorry, I didn't hear that. Come again?");
            arrayList.add("Sorry, I was in a daydream. What did you say?");
            arrayList.add("Sorry, I was in a daydream. Say that again.");
            arrayList.add("Sorry, I wasn't concentrating. Say that again please?");
            arrayList.add("Sorry, I wasn't paying attention. What did you say?");
            arrayList.add("Sorry " + string + ", could you say that again please.");
            arrayList.add("Sorry " + string + ", no idea what you meant there. Come again.");
            arrayList.add("Sorry " + string + ", but I'm not sure what you meant by that. Could you say it again please?");
            arrayList.add("I'm afraid that command meant nothing to me " + string + ". Could you say it again?");
            arrayList.add("Sorry " + string + ", but I don't think I heard you correctly. What did you say?");
            arrayList.add("Sorry" + string + ", I was in a daydream. What did you say?");
            arrayList.add("Sorry" + string + ", I was in a daydream. Say that again.");
            arrayList.add("Sorry" + string + ", I wasn't concentrating. Say that again please?");
            arrayList.add("Sorry" + string + ", I wasn't paying attention. What did you say?");
        }
        String str = (String) arrayList.get(f1699a.nextInt(arrayList.size() - 1));
        ls.m1346c("userName: " + str);
        return str;
    }

    public static String m1358b(Context context) {
        ArrayList arrayList = new ArrayList();
        String string = context.getSharedPreferences("utterPref", 0).getString("user_name", "master");
        ls.m1346c("Shared Prefs userName: " + string);
        if (string.matches("master")) {
            arrayList.add("Really sorry, but I didn't understand that request.");
            arrayList.add("Sorry, you lost me on that command");
            arrayList.add("Sorry, but I'm not sure what you meant by that");
            arrayList.add("That command meant nothing to me I'm afraid");
            arrayList.add("Sorry, but I don't think I heard you correctly on that command");
            arrayList.add("Sorry, but I couldn't decipher that command");
            arrayList.add("Really sorry, but I couldn't make out a command");
        } else {
            arrayList.add("Really sorry, but I didn't understand that request.");
            arrayList.add("Sorry, you lost me on that command");
            arrayList.add("Sorry, but I'm not sure what you meant by that");
            arrayList.add("That command meant nothing to me I'm afraid");
            arrayList.add("Sorry, but I don't think I heard you correctly on that command");
            arrayList.add("Sorry, but I couldn't decipher that command");
            arrayList.add("Really sorry, but I couldn't make out a command");
            arrayList.add("Really sorry " + string + ", but I didn't understand that request.");
            arrayList.add("Sorry " + string + ", but you lost me on that command");
            arrayList.add("Sorry " + string + ", but I'm not sure what you meant by that");
            arrayList.add("I'm afraid that command meant nothing to me " + string);
            arrayList.add("Sorry " + string + ", but I don't think I heard you correctly");
            arrayList.add("Sorry " + string + ", but I couldn't decipher that command");
            arrayList.add("Really sorry " + string + ", but I couldn't make out a command");
        }
        String str = (String) arrayList.get(f1699a.nextInt(arrayList.size() - 1));
        ls.m1346c("userName: " + str);
        return str;
    }

    public static String m1359c(Context context) {
        ArrayList arrayList = new ArrayList();
        String string = context.getSharedPreferences("utterPref", 0).getString("user_name", "master");
        ls.m1346c("Shared Prefs userName: " + string);
        if (string.matches("master")) {
            arrayList.add("Yes master?");
            arrayList.add("I'm listening");
            arrayList.add("What can I do for you?");
            arrayList.add("How can I help?");
            arrayList.add("How can I help you?");
            arrayList.add("Fire away");
        } else {
            arrayList.add("Fire away " + string);
            arrayList.add("Yes " + string + "?");
            arrayList.add("I'm listening " + string);
            arrayList.add("What can I do for you " + string + "?");
            arrayList.add("How can I help you " + string + "?");
            arrayList.add("I'm listening");
            arrayList.add("What can I do for you?");
            arrayList.add("How can I help?");
            arrayList.add("How can I help you?");
            arrayList.add("Fire away");
        }
        String str = (String) arrayList.get(f1699a.nextInt(arrayList.size() - 1));
        ls.m1346c("userName: " + str);
        return str;
    }
}
