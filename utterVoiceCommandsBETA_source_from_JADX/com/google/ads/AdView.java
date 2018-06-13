package com.google.ads;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0255g;
import com.google.ads.internal.C0264p;
import com.google.ads.internal.C0272x;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0290d;
import java.util.HashSet;
import java.util.Set;

public class AdView extends RelativeLayout implements C0226a {
    private C0264p f1930a;

    public AdView(Activity activity, C0245g c0245g, String str) {
        super(activity.getApplicationContext());
        try {
            m1587a((Context) activity, c0245g, null);
            m1591b((Context) activity, c0245g, null);
            m1583a(activity, c0245g, str);
        } catch (C0255g e) {
            m1585a((Context) activity, e.m1694c("Could not initialize AdView"), c0245g, null);
            e.m1692a("Could not initialize AdView");
        }
    }

    protected AdView(Activity activity, C0245g[] c0245gArr, String str) {
        this(activity, new C0245g(0, 0), str);
        m1586a(c0245gArr);
    }

    public AdView(Context context, AttributeSet attributeSet) {
        C0255g c0255g;
        C0245g[] c0245gArr;
        String c;
        C0245g c0245g;
        super(context, attributeSet);
        if (attributeSet != null) {
            try {
                String a = m1582a("adSize", context, attributeSet, true);
                C0245g[] a2 = m1589a(a);
                if (a2 != null) {
                    try {
                        if (a2.length != 0) {
                            if ((attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", "adUnitId") != null ? 1 : 0) == 0) {
                                throw new C0255g("Required XML attribute \"adUnitId\" missing");
                            } else if (isInEditMode()) {
                                m1584a(context, "Ads by Google", -1, a2[0], attributeSet);
                                return;
                            } else {
                                String a3 = m1582a("adUnitId", context, attributeSet, true);
                                boolean a4 = m1588a("loadAdOnCreate", context, attributeSet);
                                if (context instanceof Activity) {
                                    Activity activity = (Activity) context;
                                    m1587a((Context) activity, a2[0], attributeSet);
                                    m1591b((Context) activity, a2[0], attributeSet);
                                    if (a2.length == 1) {
                                        m1583a(activity, a2[0], a3);
                                    } else {
                                        m1583a(activity, new C0245g(0, 0), a3);
                                        m1586a(a2);
                                    }
                                    if (a4) {
                                        Set b = m1590b("testDevices", context, attributeSet);
                                        if (b.contains("TEST_EMULATOR")) {
                                            b.remove("TEST_EMULATOR");
                                            b.add(C0237d.f2026a);
                                        }
                                        m1593a(new C0237d().m1642b(b).m1639a(m1590b("keywords", context, attributeSet)));
                                        return;
                                    }
                                    return;
                                }
                                throw new C0255g("AdView was initialized with a Context that wasn't an Activity.");
                            }
                        }
                    } catch (C0255g e) {
                        c0255g = e;
                        c0245gArr = a2;
                        c = c0255g.m1694c("Could not initialize AdView");
                        if (c0245gArr != null) {
                        }
                        m1585a(context, c, c0245g, attributeSet);
                        c0255g.m1692a("Could not initialize AdView");
                        if (!isInEditMode()) {
                            c0255g.m1693b("Could not initialize AdView");
                        }
                    }
                }
                throw new C0255g("Attribute \"adSize\" invalid: " + a);
            } catch (C0255g e2) {
                C0255g c0255g2 = e2;
                c0245gArr = null;
                c0255g = c0255g2;
                c = c0255g.m1694c("Could not initialize AdView");
                c0245g = (c0245gArr != null || c0245gArr.length <= 0) ? C0245g.f2071b : c0245gArr[0];
                m1585a(context, c, c0245g, attributeSet);
                c0255g.m1692a("Could not initialize AdView");
                if (!isInEditMode()) {
                    c0255g.m1693b("Could not initialize AdView");
                }
            }
        }
    }

    public AdView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet);
    }

    private static int m1581a(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    private String m1582a(String str, Context context, AttributeSet attributeSet, boolean z) {
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", str);
        if (attributeValue != null) {
            String packageName = context.getPackageName();
            if (attributeValue.matches("^@([^:]+)\\:(.*)$")) {
                packageName = attributeValue.replaceFirst("^@([^:]+)\\:(.*)$", "$1");
                attributeValue = attributeValue.replaceFirst("^@([^:]+)\\:(.*)$", "@$2");
            }
            if (attributeValue.startsWith("@string/")) {
                String substring = attributeValue.substring(8);
                TypedValue typedValue = new TypedValue();
                try {
                    getResources().getValue(packageName + ":string/" + substring, typedValue, true);
                    if (typedValue.string != null) {
                        attributeValue = typedValue.string.toString();
                    } else {
                        throw new C0255g("Resource " + str + " was not a string: " + typedValue);
                    }
                } catch (Throwable e) {
                    throw new C0255g("Could not find resource for " + str + ": " + attributeValue, e);
                }
            }
        }
        if (!z || attributeValue != null) {
            return attributeValue;
        }
        throw new C0255g("Required XML attribute \"" + str + "\" missing");
    }

    private void m1583a(Activity activity, C0245g c0245g, String str) {
        View frameLayout = new FrameLayout(activity);
        frameLayout.setFocusable(false);
        this.f1930a = new C0264p(this, activity, c0245g, str, frameLayout);
        setGravity(17);
        try {
            View a = C0272x.m1806a(activity, this.f1930a);
            if (a != null) {
                a.addView(frameLayout, -2, -2);
                addView(a, -2, -2);
                return;
            }
            addView(frameLayout, -2, -2);
        } catch (Throwable e) {
            C0290d.m1863a("Gestures disabled: Not supported on this version of Android.", e);
            addView(frameLayout, -2, -2);
        }
    }

    private void m1584a(Context context, String str, int i, C0245g c0245g, AttributeSet attributeSet) {
        if (c0245g == null) {
            c0245g = C0245g.f2071b;
        }
        C0245g a = C0245g.m1659a(c0245g, context.getApplicationContext());
        if (getChildCount() == 0) {
            View textView = attributeSet == null ? new TextView(context) : new TextView(context, attributeSet);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(-16777216);
            View linearLayout = attributeSet == null ? new LinearLayout(context) : new LinearLayout(context, attributeSet);
            linearLayout.setGravity(17);
            View linearLayout2 = attributeSet == null ? new LinearLayout(context) : new LinearLayout(context, attributeSet);
            linearLayout2.setGravity(17);
            linearLayout2.setBackgroundColor(i);
            int a2 = m1581a(context, a.m1661a());
            int a3 = m1581a(context, a.m1662b());
            linearLayout.addView(textView, a2 - 2, a3 - 2);
            linearLayout2.addView(linearLayout);
            addView(linearLayout2, a2, a3);
        }
    }

    private void m1585a(Context context, String str, C0245g c0245g, AttributeSet attributeSet) {
        C0290d.m1865b(str);
        m1584a(context, str, -65536, c0245g, attributeSet);
    }

    private void m1586a(C0245g... c0245gArr) {
        Object obj = new C0245g[c0245gArr.length];
        for (int i = 0; i < c0245gArr.length; i++) {
            obj[i] = C0245g.m1659a(c0245gArr[i], getContext());
        }
        this.f1930a.m1742g().f2021l.m1852a(obj);
    }

    private boolean m1587a(Context context, C0245g c0245g, AttributeSet attributeSet) {
        if (AdUtil.m1842c(context)) {
            return true;
        }
        m1585a(context, "You must have AdActivity declared in AndroidManifest.xml with configChanges.", c0245g, attributeSet);
        return false;
    }

    private boolean m1588a(String str, Context context, AttributeSet attributeSet) {
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", str);
        boolean attributeBooleanValue = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/lib/com.google.ads", str, false);
        if (attributeValue != null) {
            String packageName = context.getPackageName();
            if (attributeValue.matches("^@([^:]+)\\:(.*)$")) {
                packageName = attributeValue.replaceFirst("^@([^:]+)\\:(.*)$", "$1");
                attributeValue = attributeValue.replaceFirst("^@([^:]+)\\:(.*)$", "@$2");
            }
            if (attributeValue.startsWith("@bool/")) {
                String substring = attributeValue.substring(6);
                TypedValue typedValue = new TypedValue();
                try {
                    getResources().getValue(packageName + ":bool/" + substring, typedValue, true);
                    if (typedValue.type == 18) {
                        return typedValue.data != 0;
                    } else {
                        throw new C0255g("Resource " + str + " was not a boolean: " + typedValue);
                    }
                } catch (Throwable e) {
                    throw new C0255g("Could not find resource for " + str + ": " + attributeValue, e);
                }
            }
        }
        return attributeBooleanValue;
    }

    private static C0245g[] m1589a(String str) {
        String[] split = str.split(",");
        C0245g[] c0245gArr = new C0245g[split.length];
        for (int i = 0; i < split.length; i++) {
            String trim = split[i].trim();
            if (trim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                String[] split2 = trim.split("[xX]");
                split2[0] = split2[0].trim();
                split2[1] = split2[1].trim();
                try {
                    C0245g c0245g = new C0245g("FULL_WIDTH".equals(split2[0]) ? -1 : Integer.parseInt(split2[0]), "AUTO_HEIGHT".equals(split2[1]) ? -2 : Integer.parseInt(split2[1]));
                } catch (NumberFormatException e) {
                    return null;
                }
            }
            c0245g = "BANNER".equals(trim) ? C0245g.f2071b : "SMART_BANNER".equals(trim) ? C0245g.f2070a : "IAB_MRECT".equals(trim) ? C0245g.f2072c : "IAB_BANNER".equals(trim) ? C0245g.f2073d : "IAB_LEADERBOARD".equals(trim) ? C0245g.f2074e : "IAB_WIDE_SKYSCRAPER".equals(trim) ? C0245g.f2075f : null;
            if (c0245g == null) {
                return null;
            }
            c0245gArr[i] = c0245g;
        }
        return c0245gArr;
    }

    private Set<String> m1590b(String str, Context context, AttributeSet attributeSet) {
        int i = 0;
        String a = m1582a(str, context, attributeSet, false);
        Set<String> hashSet = new HashSet();
        if (a != null) {
            String[] split = a.split(",");
            int length = split.length;
            while (i < length) {
                String trim = split[i].trim();
                if (trim.length() != 0) {
                    hashSet.add(trim);
                }
                i++;
            }
        }
        return hashSet;
    }

    private boolean m1591b(Context context, C0245g c0245g, AttributeSet attributeSet) {
        if (AdUtil.m1839b(context)) {
            return true;
        }
        m1585a(context, "You must have INTERNET and ACCESS_NETWORK_STATE permissions in AndroidManifest.xml.", c0245g, attributeSet);
        return false;
    }

    public final void m1592a() {
        this.f1930a.m1733b();
    }

    public final void m1593a(C0237d c0237d) {
        if (this.f1930a != null) {
            if (this.f1930a == null ? false : this.f1930a.m1751p()) {
                this.f1930a.m1740e();
            }
            this.f1930a.m1726a(c0237d);
        }
    }

    protected void onMeasure(int i, int i2) {
        AdWebView j = this.f1930a.m1745j();
        if (j != null) {
            j.setVisibility(0);
        }
        super.onMeasure(i, i2);
    }

    public void setAdListener(C0241c c0241c) {
        this.f1930a.m1742g().f2022m.m1852a(c0241c);
    }

    public void setAppEventListener(C0246h c0246h) {
        this.f1930a.m1742g().f2023n.m1852a(c0246h);
    }

    public void setSupportedAdSizes(C0245g... c0245gArr) {
        if (this.f1930a.m1742g().f2021l.m1851a() == null) {
            C0290d.m1865b("Error: Tried to set supported ad sizes on a single-size AdView.");
        } else {
            m1586a(c0245gArr);
        }
    }
}
