package com.brandall.nutter;

import java.util.regex.Pattern;
import org.ispeech.core.HttpRequestParams;

public final class gy {
    private static final String f1262a = Pattern.quote("f*** off");

    public static boolean m1004A(String str) {
        return (str.startsWith("playlist ") || str.startsWith("play list ")) ? false : false;
    }

    public static boolean m1005B(String str) {
        return str.startsWith("play ");
    }

    public static boolean m1006C(String str) {
        return str.startsWith("where's my car") || str.startsWith("where is my car");
    }

    public static boolean m1007D(String str) {
        return str.startsWith("navigate ") && str.contains(" contact");
    }

    public static boolean m1008E(String str) {
        return str.startsWith("navigate ") && !str.contains(" contact");
    }

    public static boolean m1009F(String str) {
        return (str.startsWith("set ") || str.startsWith("create ") || str.startsWith("new ") || str.startsWith("remind me ")) && ((str.contains(" alarm ") && str.contains(" in ")) || str.contains(" reminder "));
    }

    public static boolean m1010G(String str) {
        return ((str.startsWith("set ") || str.startsWith("new ") || str.startsWith("create ") || str.startsWith("make ")) && (str.contains("calendar") || str.contains("appointment") || str.contains(" event "))) || str.startsWith("calendar entry ");
    }

    public static boolean m1011H(String str) {
        return str.startsWith("show me ") && (str.contains("results") || str.contains("weather"));
    }

    public static boolean m1012I(String str) {
        return (str.startsWith("browse ") || str.startsWith("browse a ")) && str.contains("directory");
    }

    public static boolean m1013J(String str) {
        return str.startsWith("how do you spell ") || str.startsWith("spell ");
    }

    public static boolean m1014K(String str) {
        return str.startsWith("define ");
    }

    public static boolean m1015L(String str) {
        return str.startsWith("search ebay ");
    }

    public static boolean m1016M(String str) {
        return str.startsWith("translate ");
    }

    public static boolean m1017N(String str) {
        return str.startsWith("create command") || str.startsWith("create a command");
    }

    public static boolean m1018O(String str) {
        return str.startsWith("here's a joke") || str.startsWith("here is a joke") || str.startsWith("i've got a joke") || str.startsWith("i have a joke");
    }

    public static boolean m1019P(String str) {
        return str.startsWith("tell me a joke");
    }

    public static boolean m1020Q(String str) {
        return (str.startsWith("generate ") || str.startsWith("generator ")) && (str.contains("md5") || str.contains("m d 5"));
    }

    public static boolean m1021R(String str) {
        return str.startsWith("zip ") && (str.contains(" screen shot") || str.contains(" screenshot") || str.contains(" picture") || str.contains(" image"));
    }

    public static boolean m1022S(String str) {
        return (str.startsWith("take") && (str.contains(" screen shot") || str.contains(" screenshot"))) || str.matches("screenshot");
    }

    public static boolean m1023T(String str) {
        return str.startsWith("where am i");
    }

    public static boolean m1024U(String str) {
        return str.startsWith("go to ") || str.startsWith("goto ");
    }

    public static boolean m1025V(String str) {
        return str.startsWith("email ") || str.startsWith("e-mail ");
    }

    public static boolean m1026W(String str) {
        return (!str.startsWith("text ") || str.startsWith("text to speech ") || str.contains(" wifi") || str.contains(" bluetooth") || str.contains(" data") || str.contains(" airplane") || str.contains(" aeroplane") || str.contains(" mobile data")) ? false : true;
    }

    public static boolean m1027X(String str) {
        return str.startsWith("skype");
    }

    public static boolean m1028Y(String str) {
        return str.startsWith("kill ");
    }

    public static boolean m1029Z(String str) {
        return str.startsWith("read ") && (str.contains("clipboard") || str.contains("clip board"));
    }

    public static boolean m1030a(String str) {
        return str.startsWith("wifi settings") || str.startsWith("bluetooth settings") || str.startsWith("data settings") || str.startsWith("time settings") || str.startsWith("date settings") || str.startsWith("voice search settings") || str.startsWith("tts settings") || str.startsWith("t t s settings") || str.startsWith("text to speech settings") || str.startsWith("device settings") || str.startsWith("accessibility settings") || str.startsWith("apn settings") || str.startsWith("a p n settings") || str.startsWith("application settings") || str.startsWith("display settings") || str.startsWith("input settings") || str.startsWith("storage settings") || str.startsWith("locale settings") || str.startsWith("memory card settings") || str.startsWith("storage card settings") || str.startsWith("sd card settings") || str.startsWith("s d card settings") || str.startsWith("network operator settings") || str.startsWith("nfc settings") || str.startsWith("n f c settings") || str.startsWith("privacy settings") || str.startsWith("quick launch settings") || str.startsWith("search settings") || str.startsWith("settings") || str.startsWith("sound settings") || str.startsWith("volume settings") || str.startsWith("sync settings") || str.startsWith("sink settings") || str.startsWith("dictionary settings") || str.startsWith("location settings");
    }

    public static boolean aa(String str) {
        return str.startsWith("read ") && (str.contains("sms") || str.contains(HttpRequestParams.TEXT) || str.contains("message"));
    }

    public static boolean ab(String str) {
        return (str.startsWith("which app") || str.startsWith("what app")) && (str.contains("foreground") || str.contains("using"));
    }

    public static boolean ac(String str) {
        return (str.startsWith("what is") || str.startsWith("what's")) && str.contains("battery") && (str.contains("temperature") || str.contains("level") || str.contains("status") || str.contains("health") || str.contains("voltage"));
    }

    public static boolean ad(String str) {
        return str.startsWith("developer password ");
    }

    public static boolean ae(String str) {
        return str.startsWith("user password");
    }

    public static boolean af(String str) {
        return (!str.startsWith("call me ") || str.contains("mobile") || str.contains("work") || str.contains("office") || str.contains("home")) ? false : true;
    }

    public static boolean ag(String str) {
        return str.startsWith("set shake ") || str.startsWith("enable shake") || str.startsWith("disable shake");
    }

    public static boolean ah(String str) {
        return str.startsWith("enable wave") || str.startsWith("disable wave");
    }

    public static boolean ai(String str) {
        return str.contains("sound profile") && (str.contains("vibrate") || str.contains("silent") || str.contains("normal"));
    }

    public static boolean aj(String str) {
        return str.matches("cancel") || str.matches("council") || str.matches("cancer") || str.matches("never mind") || str.matches("shush") || str.contains("cancel cancel") || str.contains("cancer cancer") || str.contains("council council");
    }

    public static boolean ak(String str) {
        return str.startsWith("fly to");
    }

    public static boolean al(String str) {
        return str.startsWith("open ") || str.startsWith("load ") || str.startsWith("launch ");
    }

    public static boolean am(String str) {
        return str.startsWith("what's the time") || str.startsWith("what is the time") || str.startsWith("what time is it") || str.endsWith("what's the time") || str.endsWith("what is the time") || str.endsWith("what time is it") || str.matches("time");
    }

    public static boolean an(String str) {
        return str.startsWith("what's the date") || str.startsWith("what is the date") || str.startsWith("what date is it") || str.endsWith("what's the date") || str.endsWith("what is the date") || str.endsWith("what date is it") || str.matches("date");
    }

    public static boolean ao(String str) {
        return str.startsWith("search google") || str.startsWith("search bing") || str.startsWith("search yahoo") || str.startsWith("search ") || str.startsWith("find ") || (str.startsWith("show ") && (str.contains("image") || str.contains("picture") || str.contains("video")));
    }

    public static boolean ap(String str) {
        return (str.contains("toggle ") && (str.contains(" wifi") || str.contains(" data") || str.contains(" bluetooth") || str.contains(" airplane") || str.contains(" aeroplane"))) ? true : (str.contains("turn ") || str.contains("switch ")) && ((str.contains(" on") || str.contains(" off")) && (str.contains(" wifi") || str.contains(" data") || str.contains(" bluetooth") || str.contains(" airplane") || str.contains(" aeroplane")));
    }

    public static boolean aq(String str) {
        return (!str.startsWith("call ") || str.startsWith("call me ") || str.startsWith("call mee ") || str.matches("call back") || str.matches("call bac") || str.matches("call black") || str.matches("call bak") || str.startsWith("call mi ") || str.contains(" wifi") || str.contains(" bluetooth") || str.contains(" data") || str.contains(" airplane") || str.contains(" aeroplane") || str.contains(" mobile data")) ? false : true;
    }

    public static boolean ar(String str) {
        return (str.startsWith("super user ") || str.startsWith("superuser ")) && (str.contains(" reboot") || str.contains(" governor"));
    }

    public static boolean as(String str) {
        return str.startsWith("display contact ") || str.startsWith("display the contact ") || str.startsWith("show contact ") || str.startsWith("show me the contact ") || str.startsWith("show the contact ");
    }

    public static boolean at(String str) {
        return str.startsWith("execute task") || str.startsWith("display task") || str.startsWith("run task");
    }

    public static boolean au(String str) {
        return str.contains("facebook status");
    }

    public static boolean av(String str) {
        return str.startsWith("tweet");
    }

    public static boolean aw(String str) {
        return ((str.startsWith("what's") || str.startsWith("what is") || str.startsWith("how is") || str.startsWith("how's")) && str.contains("weather")) || str.matches("weather");
    }

    public static boolean m1031b(String str) {
        return str.matches("call back") || str.matches("call bak") || str.matches("call bac") || str.matches("call black");
    }

    public static boolean m1032c(String str) {
        return str.startsWith("check in to ") || str.startsWith("checkin to ") || str.startsWith("check into ") || str.startsWith("check me in to ") || str.startsWith("check me into ");
    }

    public static boolean m1033d(String str) {
        return str.matches("shut down") || str.matches("shutdown");
    }

    public static boolean m1034e(String str) {
        return str.startsWith("search") && (str.contains(" app") || str.contains(" apps"));
    }

    public static boolean m1035f(String str) {
        return (str.startsWith("locate") || str.startsWith("find")) && str.contains("car");
    }

    public static boolean m1036g(String str) {
        return str.startsWith("remember this");
    }

    public static boolean m1037h(String str) {
        return str.startsWith("redial") || str.startsWith("re dial") || str.startsWith("free dial") || str.startsWith("read dial");
    }

    public static boolean m1038i(String str) {
        return str.startsWith("fuck off") || str.matches(f1262a);
    }

    public static boolean m1039j(String str) {
        return (str.startsWith("float") || str.startsWith("flight") || str.startsWith("flyte") || str.startsWith("flite")) && str.contains(" command");
    }

    public static boolean m1040k(String str) {
        return str.startsWith("speak ") && (str.contains(" loud") || str.contains(" soft") || str.contains(" max") || str.contains(" min") || str.contains(" quiet"));
    }

    public static boolean m1041l(String str) {
        return str.startsWith("stream ") || str.startsWith("google play ");
    }

    public static boolean m1042m(String str) {
        return str.matches("pardon") || str.contains("say that again") || str.contains("what did you say") || str.contains("repeat that") || str.contains("repeat what") || str.contains("run that by me again") || str.contains("run that past me again") || str.matches("say what");
    }

    public static boolean m1043n(String str) {
        return !str.startsWith("where") && str.contains("park") && str.contains(" car");
    }

    public static boolean m1044o(String str) {
        return (str.startsWith("control") || str.startsWith("release")) && (str.contains("headset") || str.contains("head set"));
    }

    public static boolean m1045p(String str) {
        return str.matches("command") || str.matches("command help") || str.matches("command list") || str.matches("help me") || str.matches("commands") || str.matches("help") || ((str.startsWith("what") || str.startsWith("list") || str.startsWith("help") || str.startsWith("show") || str.startsWith("tell")) && str.contains("command"));
    }

    public static boolean m1046q(String str) {
        return str.startsWith("link application");
    }

    public static boolean m1047r(String str) {
        return str.startsWith("enable visual") || str.startsWith("disable visual");
    }

    public static boolean m1048s(String str) {
        return str.startsWith("edit ") && (str.contains(" screen shot") || str.contains(" screenshot") || str.contains(" picture") || str.contains(" image"));
    }

    public static boolean m1049t(String str) {
        return str.startsWith("search ") && (str.contains("movie") || str.contains("film"));
    }

    public static boolean m1050u(String str) {
        return str.contains("new voice note") || str.contains("new voicenote");
    }

    public static boolean m1051v(String str) {
        return str.contains("new note") && !str.contains(HttpRequestParams.VOICE);
    }

    public static boolean m1052w(String str) {
        return str.startsWith("upload ");
    }

    public static boolean m1053x(String str) {
        return str.startsWith("calculate ");
    }

    public static boolean m1054y(String str) {
        return str.startsWith("toast") && (str.contains("clip board") || str.contains("clipboard"));
    }

    public static boolean m1055z(String str) {
        return str.startsWith("question ");
    }
}
