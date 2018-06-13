package com.p013b.p014a.p015a;

import com.faceture.google.play.QueryParamConst;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum C0139a {
    AUTO_DETECT(""),
    ARABIC("ar"),
    BULGARIAN("bg"),
    CATALAN("ca"),
    CHINESE_SIMPLIFIED("zh-CHS"),
    CHINESE_TRADITIONAL("zh-CHT"),
    CZECH("cs"),
    DANISH("da"),
    DUTCH("nl"),
    ENGLISH(QueryParamConst.HL_VALUE),
    ESTONIAN("et"),
    FINNISH("fi"),
    FRENCH("fr"),
    GERMAN("de"),
    GREEK("el"),
    HAITIAN_CREOLE("ht"),
    HEBREW("he"),
    HINDI("hi"),
    HMONG_DAW("mww"),
    HUNGARIAN("hu"),
    INDONESIAN("id"),
    ITALIAN("it"),
    JAPANESE("ja"),
    KOREAN("ko"),
    LATVIAN("lv"),
    LITHUANIAN("lt"),
    NORWEGIAN("no"),
    POLISH("pl"),
    PORTUGUESE(QueryParamConst.PT_NAME),
    ROMANIAN("ro"),
    RUSSIAN("ru"),
    SLOVAK("sk"),
    SLOVENIAN("sl"),
    SPANISH("es"),
    SWEDISH("sv"),
    THAI("th"),
    TURKISH("tr"),
    UKRAINIAN("uk"),
    VIETNAMESE("vi");
    
    private final String f637N;
    private Map<C0139a, String> f638O;

    private C0139a(String str) {
        this.f638O = new ConcurrentHashMap();
        this.f637N = str;
    }

    public final String toString() {
        return this.f637N;
    }
}
