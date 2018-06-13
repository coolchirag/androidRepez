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

public class ActivityUserNickNames extends Activity {
    ArrayList<String> f722a = new ArrayList();
    ArrayList<String> f723b = new ArrayList();
    ArrayList<Integer> f724c = new ArrayList();
    private ListView f725d;
    private int f726e = 0;
    private AdView f727f;
    private int f728g = 0;
    private hh f729h;

    static /* synthetic */ void m691a(ActivityUserNickNames activityUserNickNames, String str, String str2, String str3) {
        View inflate = ((LayoutInflater) activityUserNickNames.getSystemService("layout_inflater")).inflate(R.layout.edit_nickname_dialog_layout, (ViewGroup) activityUserNickNames.findViewById(R.id.endl));
        Builder builder = new Builder(activityUserNickNames);
        builder.setIcon(R.drawable.people);
        builder.setTitle("Edit Nickname");
        builder.setMessage(str2);
        builder.setInverseBackgroundForced(true);
        EditText editText = (EditText) inflate.findViewById(R.id.enname);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.helpButton);
        Button button = (Button) inflate.findViewById(R.id.positiveButton);
        Button button2 = (Button) inflate.findViewById(R.id.negativeButton);
        editText.setHint(lv.m1356a());
        editText.setText(str);
        builder.setView(inflate);
        Dialog show = builder.show();
        show.setOnCancelListener(new fv(activityUserNickNames));
        button.setOnClickListener(new fw(activityUserNickNames, editText, str2, str3, show));
        button2.setOnClickListener(new fx(activityUserNickNames, show));
        imageButton.setOnClickListener(new fy(activityUserNickNames));
    }

    private void m692b() {
        this.f722a = this.f729h.m1092a();
        this.f723b = this.f729h.m1097b();
        this.f724c = this.f729h.m1099c();
        if (this.f722a.isEmpty()) {
            ls.m1347d("EUC arrayNickNames empty");
            lc.m1313a(this, false, "You don't have any custom nicknames to edit");
            lx.m1427g((Context) this, false);
            finish();
            return;
        }
        if (this.f726e == 0) {
            lc.m1313a(this, false, "Tap the nickname you wish to edit.");
            this.f726e++;
        }
        ls.m1344a("arrayNickNames: " + this.f722a.size() + " : " + this.f722a.toString());
        ls.m1344a("arrayRowID: " + this.f724c.size() + " : " + this.f724c.toString());
        ls.m1344a("arrayContactNames: " + this.f723b.size() + " : " + this.f723b.toString());
        this.f725d.setAdapter(new ArrayAdapter(this, 17367043, this.f722a));
    }

    static /* synthetic */ void m693b(ActivityUserNickNames activityUserNickNames) {
        Builder builder = new Builder(activityUserNickNames);
        builder.setItems(new String[]{"edit", "delete"}, new fu(activityUserNickNames));
        builder.show();
    }

    public final void m695a() {
        ls.m1346c("in deleteEntry");
        this.f729h.m1093a((long) ((Integer) this.f724c.get(this.f728g)).intValue());
        m692b();
    }

    public final void m696a(String str, String str2, String str3) {
        lc.m1313a(this, false, "I've updated the nickname, " + str + ", for the contact, " + str2);
        this.f729h.m1095a(str, str2, str3, ((Integer) this.f724c.get(this.f728g)).intValue());
        m692b();
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
        setContentView(R.layout.nicknames_layout);
        this.f729h = new hh(this);
        this.f727f = (AdView) findViewById(R.id.adView);
        this.f725d = (ListView) findViewById(R.id.list);
        this.f725d.setOnItemClickListener(new ft(this));
        C0227h a = new C0228a().mo111a("color_bg", "FFFFFF").mo111a("color_link", "000080").mo111a("color_text", "808080").mo111a("color_url", "008000");
        C0237d c0237d = new C0237d();
        if (GlobalV.m887s()) {
            c0237d.m1638a("FAFFD14896DE0B88FCFDD1692625BFAD");
            c0237d.m1638a("CC24C2B6FF78E3A8AD39DD88ECEF74EF");
            c0237d.m1638a("CC24C2B6FF78E4A8AD39DD88ECEF74EF");
            c0237d.m1638a("26F26F9E436091DB6D26BBFDBBC01B01");
        }
        c0237d.m1636a(a);
        this.f727f.m1593a(c0237d);
        m692b();
    }

    public void onDestroy() {
        super.onDestroy();
        ls.m1346c("AUN onDestroy");
        if (this.f727f != null) {
            this.f727f.removeAllViews();
            this.f727f.m1592a();
        }
    }

    public void onPause() {
        super.onPause();
        ls.m1346c("AUN onPause");
    }

    public void onResume() {
        super.onResume();
        ls.m1346c("AUN onResume");
    }
}
