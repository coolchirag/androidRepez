package com.catchnotes.p020a;

import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.Location;
import android.net.Uri;
import android.widget.Toast;
import com.catchnotes.samples.integration.C0186R;
import java.util.ArrayList;

public final class C0174a {
    private final Context f1841a;

    public C0174a(Context context) {
        this.f1841a = context;
    }

    private void m1511a(int i) {
        new Builder(this.f1841a).setIcon(17301543).setTitle(C0186R.string.error_dialog_title).setMessage(i).setPositiveButton(this.f1841a.getString(C0186R.string.ok_button), null).show();
    }

    static /* synthetic */ void m1512a(C0174a c0174a) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://market.android.com/search?q=pname:com.threebanana.notes"));
            intent.addFlags(524288);
            c0174a.f1841a.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            c0174a.m1511a(C0186R.string.market_error_message);
        }
    }

    public final void m1513a(Intent intent) {
        try {
            this.f1841a.startActivity(intent);
            if (intent.hasExtra("com.catchnotes.intent.extra.AUTOSAVE")) {
                Toast.makeText(this.f1841a, C0186R.string.toast_quick_note, 0).show();
            }
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            m1511a(C0186R.string.notes_intent_error);
        }
    }

    public final void m1514a(String str, Location location, int i, boolean z, Uri uri) {
        if (m1516a()) {
            Intent intent = new Intent();
            intent.setAction("com.catchnotes.intent.action.ADD");
            intent.putExtra("android.intent.extra.TEXT", str);
            intent.putExtra("com.catchnotes.intent.extra.SOURCE", "Catch Intent Test Utility");
            intent.putExtra("com.catchnotes.intent.extra.SOURCE_URL", "https://catch.com/");
            intent.putExtra("android.intent.extra.TITLE", "testing Catch Intents");
            if (uri != null) {
                intent.putExtra("android.intent.extra.STREAM", uri);
            }
            if (location != null) {
                intent.putExtra("com.catchnotes.intent.extra.LOCATION", location);
            }
            if (0 > System.currentTimeMillis()) {
                intent.putExtra("com.catchnotes.intent.extra.REMINDER", 0);
            }
            if (i >= 0) {
                intent.putExtra("com.catchnotes.intent.extra.CURSOR_POSITION", i);
            }
            if (z) {
                intent.putExtra("com.catchnotes.intent.extra.AUTOSAVE", true);
            }
            m1513a(intent);
        }
    }

    public final void m1515a(String str, String str2, ArrayList<String> arrayList) {
        if (m1516a()) {
            Intent intent = new Intent();
            intent.setAction("com.catchnotes.intent.action.VIEW");
            if (str != null) {
                intent.putExtra("com.catchnotes.intent.extra.VIEW_FILTER_STREAM", str);
            }
            if (str2 != null) {
                intent.putExtra("com.catchnotes.intent.extra.VIEW_FILTER", str2);
            }
            if (arrayList != null) {
                intent.putExtra("com.catchnotes.intent.extra.VIEW_FILTER_TAGS", arrayList);
            }
            intent.setFlags(268435456);
            m1513a(intent);
        }
    }

    public final boolean m1516a() {
        Builder builder;
        try {
            PackageInfo packageInfo = this.f1841a.getPackageManager().getPackageInfo("com.threebanana.notes", 1);
            if (packageInfo.versionCode >= 54) {
                return true;
            }
            String str = packageInfo.applicationInfo.name;
            builder = new Builder(this.f1841a);
            builder.setTitle(C0186R.string.upgrade_notes_title);
            builder.setMessage(C0186R.string.upgrade_notes_message);
            builder.setIcon(C0186R.drawable.market_icon);
            builder.setNegativeButton(C0186R.string.cancel_button, null);
            builder.setPositiveButton(C0186R.string.upgrade_button, new C0176c(this));
            builder.show();
            return false;
        } catch (NameNotFoundException e) {
            builder = new Builder(this.f1841a);
            builder.setTitle(C0186R.string.install_notes_title);
            builder.setMessage(C0186R.string.install_notes_message);
            builder.setIcon(C0186R.drawable.market_icon);
            builder.setNegativeButton(C0186R.string.cancel_button, null);
            builder.setPositiveButton(C0186R.string.install_button, new C0175b(this));
            builder.show();
            return false;
        }
    }
}
