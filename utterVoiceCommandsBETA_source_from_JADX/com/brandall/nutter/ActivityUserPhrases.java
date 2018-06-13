package com.brandall.nutter;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.google.ads.AdView;
import com.google.ads.C0237d;
import com.google.ads.p028a.C0227h;
import com.google.ads.p028a.p029a.C0228a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ActivityUserPhrases extends Activity {
    ArrayList<String> f730a = new ArrayList();
    ArrayList<Integer> f731b = new ArrayList();
    ArrayList<Integer> f732c = new ArrayList();
    he f733d = new he(this);
    private ListView f734e;
    private int f735f = 0;
    private AdView f736g;
    private CheckBox f737h;
    private CheckBox f738i;
    private String f739j = "";
    private int f740k = 0;

    private void m700a(String str, String str2, String str3, String str4) {
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.edit_command_dialog_layout, (ViewGroup) findViewById(R.id.ecdl));
        Builder builder = new Builder(this);
        builder.setIcon(R.drawable.phrases);
        builder.setTitle("Custom Commands");
        builder.setMessage(str4);
        builder.setInverseBackgroundForced(true);
        TextView textView = (TextView) inflate.findViewById(R.id.ecommandt);
        TextView textView2 = (TextView) inflate.findViewById(R.id.esuccesst);
        TextView textView3 = (TextView) inflate.findViewById(R.id.efailt);
        EditText editText = (EditText) inflate.findViewById(R.id.ecommand);
        EditText editText2 = (EditText) inflate.findViewById(R.id.esuccess);
        EditText editText3 = (EditText) inflate.findViewById(R.id.efail);
        editText.setText(str);
        editText2.setText(str2);
        editText3.setText(str3);
        textView.setText("Command Phrase:");
        textView2.setText("Success Phrase:");
        textView3.setText("Fail Phrase:");
        builder.setPositiveButton("Save", new ge(this, editText, editText2, editText3));
        builder.setNegativeButton("Cancel", new gf(this));
        builder.setView(inflate);
        builder.show();
    }

    private void m701a(ArrayList<Locale> arrayList) {
        ls.m1346c("localeDialog");
        lc.m1313a(this, false, "Please select the language in which I should respond.");
        Builder builder = new Builder(this);
        builder.setIcon(R.drawable.phrases);
        builder.setTitle("Select the Locale");
        builder.setInverseBackgroundForced(true);
        List arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Locale) it.next()).toString());
        }
        View listView = new ListView(this);
        listView.setAdapter(new ArrayAdapter(this, 17367043, 16908308, arrayList2));
        builder.setOnCancelListener(new ga(this));
        builder.setNegativeButton("Cancel", new gb(this));
        builder.setView(listView);
        Dialog create = builder.create();
        listView.setOnItemClickListener(new gc(this, create));
        create.show();
    }

    static /* synthetic */ void m702b(ActivityUserPhrases activityUserPhrases) {
        Builder builder = new Builder(activityUserPhrases);
        builder.setItems(new String[]{"edit", "delete"}, new gd(activityUserPhrases));
        builder.show();
    }

    private void m705c() {
        this.f730a = this.f733d.m1066a();
        this.f731b = this.f733d.m1078f();
        this.f732c = this.f733d.m1080g();
        if (this.f730a.isEmpty()) {
            ls.m1347d("EUC arrayUC empty");
            lc.m1313a(this, false, "You don't have any custom commands to edit");
            lx.m1439l(this, false);
            finish();
            return;
        }
        if (this.f735f == 0) {
            lc.m1313a(this, false, "Tap the command you wish to edit.");
            this.f735f++;
        }
        ls.m1344a("arrayUC: " + this.f730a.size() + " : " + this.f730a.toString());
        ls.m1344a("arrayID: " + this.f731b.size() + " : " + this.f731b.toString());
        ls.m1344a("arrayCI: " + this.f732c.size() + " : " + this.f732c.toString());
        this.f734e.setAdapter(new ArrayAdapter(this, 17367043, this.f730a));
    }

    public final void m708a() {
        ls.m1346c("in editEntry");
        int intValue = ((Integer) this.f731b.get(this.f740k)).intValue();
        ls.m1344a("commandPhrase: " + this.f733d.m1069b((long) intValue));
        ls.m1344a("successWords: " + this.f733d.m1079g((long) intValue));
        ls.m1344a("failWords: " + this.f733d.m1081h((long) intValue));
        ls.m1344a("getLocale: " + this.f733d.m1077f((long) intValue));
        switch (this.f733d.m1082i((long) intValue)) {
            case 1:
                m700a(this.f733d.m1069b((long) intValue), this.f733d.m1079g((long) intValue), this.f733d.m1081h((long) intValue), "Display Contact : " + this.f733d.m1071c((long) intValue));
                return;
            case 2:
                m700a(this.f733d.m1069b((long) intValue), this.f733d.m1079g((long) intValue), this.f733d.m1081h((long) intValue), "Tasker Task : " + this.f733d.m1071c((long) intValue));
                return;
            case 3:
                m700a(this.f733d.m1069b((long) intValue), this.f733d.m1079g((long) intValue), this.f733d.m1081h((long) intValue), "Launch Intent : " + this.f733d.m1071c((long) intValue));
                return;
            case 4:
                m700a(this.f733d.m1069b((long) intValue), this.f733d.m1079g((long) intValue), this.f733d.m1081h((long) intValue), "Call " + this.f733d.m1071c((long) intValue) + " on " + this.f733d.m1075e((long) intValue));
                return;
            case 5:
                m700a(this.f733d.m1069b((long) intValue), this.f733d.m1079g((long) intValue), this.f733d.m1081h((long) intValue), "Launch Application : " + this.f733d.m1071c((long) intValue));
                return;
            case 777:
                CharSequence b = this.f733d.m1069b((long) intValue);
                CharSequence g = this.f733d.m1079g((long) intValue);
                String c = this.f733d.m1071c((long) intValue);
                Object f = this.f733d.m1077f((long) intValue);
                View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.edit_phrase_dialog_layout, (ViewGroup) findViewById(R.id.epdl));
                Builder builder = new Builder(this);
                builder.setIcon(R.drawable.phrases);
                builder.setTitle("Custom Phrases");
                builder.setMessage("Create your own responses!");
                builder.setInverseBackgroundForced(true);
                EditText editText = (EditText) inflate.findViewById(R.id.ephrase);
                EditText editText2 = (EditText) inflate.findViewById(R.id.eresponse);
                ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.helpButton);
                Button button = (Button) inflate.findViewById(R.id.positiveButton);
                Button button2 = (Button) inflate.findViewById(R.id.negativeButton);
                this.f737h = (CheckBox) inflate.findViewById(R.id.checkBox3);
                this.f738i = (CheckBox) inflate.findViewById(R.id.checkBox4);
                editText.setText(b);
                editText2.setText(g);
                builder.setView(inflate);
                Dialog show = builder.show();
                if (c.matches("true")) {
                    this.f737h.setChecked(true);
                }
                if (!(f.matches("") || f.matches("NULL"))) {
                    this.f738i.setChecked(true);
                    this.f738i.setText(f);
                    this.f739j = f;
                }
                show.setOnCancelListener(new gg(this));
                this.f738i.setOnCheckedChangeListener(new gh(this));
                button.setOnClickListener(new gi(this, editText, editText2, show));
                button2.setOnClickListener(new gj(this, show));
                imageButton.setOnClickListener(new gk(this));
                return;
            default:
                lc.m1313a(this, false, "Sorry, Something went wrong.");
                return;
        }
    }

    public final void m709a(String str, String str2, String str3) {
        lc.m1313a(this, false, "I've updated that command");
        ContentValues contentValues = new ContentValues();
        contentValues.put("keyword", str);
        contentValues.put("success_words", str2);
        contentValues.put("fail_words", str3);
        this.f733d.getWritableDatabase().update("user_commands", contentValues, "_id = ?", new String[]{String.valueOf(this.f731b.get(this.f740k))});
        m705c();
    }

    public final void m710a(String str, String str2, boolean z) {
        String str3 = null;
        if (str2.toLowerCase(Locale.US).contains("se~")) {
            str3 = str2.toLowerCase(Locale.US).replaceAll("se~", ", Sound effect of a ");
            int i = 1;
        } else {
            boolean z2 = false;
        }
        if (z) {
            if (i != 0) {
                lc.m1313a(this, false, "I've updated the current phrase. When you say. " + str + ". I'll respond with. " + str3 + ", and start listening.");
            } else {
                lc.m1313a(this, false, "I've updated the current phrase. When you say. " + str + ". I'll respond with. " + str2 + ", and start listening.");
            }
        } else if (i != 0) {
            lc.m1313a(this, false, "I've updated the current phrase. When you say. " + str + ". I'll respond with. " + str3);
        } else {
            lc.m1313a(this, false, "I've updated the current phrase. When you say. " + str + ". I'll respond with. " + str2);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("keyword", str);
        contentValues.put("success_words", str2);
        contentValues.put("command_int", Integer.valueOf(777));
        contentValues.put("string_1", String.valueOf(z));
        if (this.f739j.matches("")) {
            ls.m1346c("Custom Language NULL");
            contentValues.put("string_4", "NULL");
        } else {
            ls.m1346c("userLocaleSelection: " + this.f739j);
            contentValues.put("string_4", this.f739j);
        }
        this.f733d.getWritableDatabase().update("user_commands", contentValues, "_id = ?", new String[]{String.valueOf(this.f731b.get(this.f740k))});
        m705c();
    }

    public final void m711b() {
        ls.m1346c("in deleteEntry");
        this.f733d.m1067a((long) ((Integer) this.f731b.get(this.f740k)).intValue());
        m705c();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 0 || intent == null) {
            this.f738i.setChecked(false);
            lc.m1313a(this, false, "I will use your default voice engine and language");
            return;
        }
        try {
            Iterator it = intent.getStringArrayListExtra("availableVoices").iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                Locale locale = new Locale((String) it.next());
                ls.m1346c("language locale: " + locale.toString());
                arrayList.add(locale);
            }
            m701a(arrayList);
        } catch (Exception e) {
            e.printStackTrace();
            this.f738i.setChecked(false);
            lc.m1313a(this, false, "Sorry, the data for that voice engine is corrupt.");
        }
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
        setContentView(R.layout.phrase_layout);
        this.f736g = (AdView) findViewById(R.id.adView);
        this.f737h = (CheckBox) findViewById(R.id.checkBox1);
        this.f738i = (CheckBox) findViewById(R.id.checkBox2);
        this.f734e = (ListView) findViewById(R.id.list);
        this.f734e.setOnItemClickListener(new fz(this));
        C0227h a = new C0228a().mo111a("color_bg", "FFFFFF").mo111a("color_link", "000080").mo111a("color_text", "808080").mo111a("color_url", "008000");
        C0237d c0237d = new C0237d();
        if (GlobalV.m887s()) {
            c0237d.m1638a("FAFFD14896DE0B88FCFDD1692625BFAD");
            c0237d.m1638a("CC24C2B6FF78E3A8AD39DD88ECEF74EF");
            c0237d.m1638a("CC24C2B6FF78E4A8AD39DD88ECEF74EF");
            c0237d.m1638a("26F26F9E436091DB6D26BBFDBBC01B01");
        }
        c0237d.m1636a(a);
        this.f736g.m1593a(c0237d);
        m705c();
    }

    public void onDestroy() {
        super.onDestroy();
        ls.m1346c("AUP onDestroy");
        if (this.f736g != null) {
            this.f736g.removeAllViews();
            this.f736g.m1592a();
        }
    }

    public void onPause() {
        super.onPause();
        ls.m1346c("AUP onPause");
    }

    public void onResume() {
        super.onResume();
        ls.m1346c("AUP onResume");
    }
}
