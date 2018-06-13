package com.brandall.nutter;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import com.google.ads.AdView;
import com.google.ads.C0237d;
import com.google.ads.p028a.C0227h;
import com.google.ads.p028a.p029a.C0228a;
import java.util.ArrayList;

public class ActivityUserWords extends Activity {
    ArrayList<String> f741a = new ArrayList();
    ArrayList<String> f742b = new ArrayList();
    ArrayList<Integer> f743c = new ArrayList();
    private ListView f744d;
    private int f745e = 0;
    private AdView f746f;
    private int f747g = 0;
    private hk f748h;

    static /* synthetic */ void m715a(ActivityUserWords activityUserWords, String str, String str2) {
        View inflate = ((LayoutInflater) activityUserWords.getSystemService("layout_inflater")).inflate(R.layout.edit_words_dialog_layout, (ViewGroup) activityUserWords.findViewById(R.id.ewdl));
        Builder builder = new Builder(activityUserWords);
        builder.setIcon(R.drawable.replace);
        builder.setTitle("Custom Words");
        builder.setMessage("Configure the replacement");
        builder.setInverseBackgroundForced(true);
        EditText editText = (EditText) inflate.findViewById(R.id.eword);
        EditText editText2 = (EditText) inflate.findViewById(R.id.ereplace);
        editText.setText(str);
        editText2.setText(str2);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.helpButton);
        Button button = (Button) inflate.findViewById(R.id.positiveButton);
        Button button2 = (Button) inflate.findViewById(R.id.negativeButton);
        builder.setView(inflate);
        Dialog show = builder.show();
        show.setOnCancelListener(new gn(activityUserWords));
        button.setOnClickListener(new go(activityUserWords, editText, editText2, show));
        button2.setOnClickListener(new gp(activityUserWords, show));
        imageButton.setOnClickListener(new gq(activityUserWords));
    }

    private void m716b() {
        this.f741a = this.f748h.m1114a();
        this.f742b = this.f748h.m1120b();
        this.f743c = this.f748h.m1122c();
        if (this.f741a.isEmpty()) {
            ls.m1347d("EUC arrayNickNames empty");
            lc.m1313a(this, false, "You don't have any custom words to edit");
            lx.m1424f((Context) this, false);
            finish();
            return;
        }
        if (this.f745e == 0) {
            lc.m1313a(this, false, "Tap the word you wish to edit.");
            this.f745e++;
        }
        ls.m1344a("arrayNickNames: " + this.f741a.size() + " : " + this.f741a.toString());
        ls.m1344a("arrayRowID: " + this.f743c.size() + " : " + this.f743c.toString());
        ls.m1344a("arrayContactNames: " + this.f742b.size() + " : " + this.f742b.toString());
        this.f744d.setAdapter(new ArrayAdapter(this, 17367043, this.f741a));
    }

    static /* synthetic */ void m717b(ActivityUserWords activityUserWords) {
        Builder builder = new Builder(activityUserWords);
        builder.setItems(new String[]{"edit", "delete"}, new gm(activityUserWords));
        builder.show();
    }

    public final void m719a() {
        ls.m1346c("in deleteEntry");
        this.f748h.m1115a((long) ((Integer) this.f743c.get(this.f747g)).intValue());
        m716b();
    }

    public final void m720a(String str, String str2) {
        lc.m1313a(this, false, "I've updated your custom replacement. When I detect, " + str + ", in the voice data, I'll replace it with, " + str2);
        this.f748h.m1117a(str, str2, ((Integer) this.f743c.get(this.f747g)).intValue());
        m716b();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            ls.m1345b("Landscape");
        } else if (configuration.orientation == 1) {
            ls.m1345b("Portrait");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.user_words_layout);
        this.f748h = new hk(this);
        this.f746f = (AdView) findViewById(R.id.adView);
        this.f744d = (ListView) findViewById(R.id.list);
        this.f744d.setOnItemClickListener(new gl(this));
        C0227h a = new C0228a().mo111a("color_bg", "FFFFFF").mo111a("color_link", "000080").mo111a("color_text", "808080").mo111a("color_url", "008000");
        C0237d c0237d = new C0237d();
        if (GlobalV.m887s()) {
            c0237d.m1638a("FAFFD14896DE0B88FCFDD1692625BFAD");
            c0237d.m1638a("CC24C2B6FF78E3A8AD39DD88ECEF74EF");
            c0237d.m1638a("CC24C2B6FF78E4A8AD39DD88ECEF74EF");
            c0237d.m1638a("26F26F9E436091DB6D26BBFDBBC01B01");
        }
        c0237d.m1636a(a);
        this.f746f.m1593a(c0237d);
        m716b();
    }

    public void onDestroy() {
        super.onDestroy();
        ls.m1346c("AUW onDestroy");
        if (this.f746f != null) {
            this.f746f.removeAllViews();
            this.f746f.m1592a();
        }
    }

    public void onPause() {
        super.onPause();
        ls.m1346c("AUW onPause");
    }

    public void onResume() {
        super.onResume();
        ls.m1346c("AUW onResume");
    }
}
