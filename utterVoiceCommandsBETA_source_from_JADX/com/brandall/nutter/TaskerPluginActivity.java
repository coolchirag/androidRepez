package com.brandall.nutter;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.p017c.p018a.C0173a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class TaskerPluginActivity extends Activity {
    CheckBox f886a;
    CheckBox f887b;
    CheckBox f888c;
    CheckBox f889d;
    RadioGroup f890e;
    RadioButton f891f;
    RadioButton f892g;
    Button f893h;
    Button f894i;
    EditText f895j;
    EditText f896k;
    private boolean f897l = false;
    private boolean f898m = false;
    private boolean f899n = false;
    private boolean f900o = true;
    private String f901p = "";
    private String f902q = "";
    private String f903r = "";
    private String f904s = "";

    private static String m946a(String str) {
        return (str == null || str.isEmpty() || str.replaceAll("\\s", "").isEmpty()) ? "NULL" : str.trim();
    }

    private void m947a() {
        if (!this.f897l) {
            this.f903r = this.f896k.getText().toString();
            if (!this.f899n && m946a(this.f903r).matches("NULL")) {
                setResult(0);
            } else if (this.f899n) {
                this.f903r = "";
                this.f900o = false;
                this.f901p = "";
                this.f898m = false;
                this.f904s = this.f895j.getText().toString();
                if (m946a(this.f904s).matches("NULL")) {
                    lc.m1313a(this, false, "Please ensure the variable name is structured correctly");
                    return;
                } else if (this.f904s.startsWith("%")) {
                    this.f904s = this.f904s.trim();
                } else {
                    lc.m1313a(this, false, "Please ensure the variable name is structured correctly");
                    return;
                }
            } else {
                this.f903r = this.f903r.trim();
                if (this.f890e.getCheckedRadioButtonId() != R.id.radio0) {
                    this.f900o = false;
                }
                this.f898m = this.f887b.isChecked();
            }
        }
        finish();
    }

    static /* synthetic */ void m950a(TaskerPluginActivity taskerPluginActivity, ArrayList arrayList, ArrayList arrayList2) {
        ls.m1346c("langDialog");
        lc.m1313a(taskerPluginActivity, false, "Please select your native recognition language.");
        Builder builder = new Builder(taskerPluginActivity);
        builder.setIcon(R.drawable.gvs);
        builder.setTitle("Select Language");
        builder.setInverseBackgroundForced(true);
        View listView = new ListView(taskerPluginActivity);
        listView.setAdapter(new ArrayAdapter(taskerPluginActivity, 17367043, 16908308, arrayList));
        builder.setNegativeButton("Cancel", new ni(taskerPluginActivity));
        builder.setOnCancelListener(new nj(taskerPluginActivity));
        builder.setView(listView);
        Dialog create = builder.create();
        listView.setOnItemClickListener(new my(taskerPluginActivity, arrayList2, create));
        create.show();
    }

    private void m952a(ArrayList<Locale> arrayList) {
        if (hc.f1269b) {
            ls.m1346c("localeDialog");
        }
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
        builder.setOnCancelListener(new mz(this));
        builder.setNegativeButton("Cancel", new na(this));
        builder.setView(listView);
        Dialog create = builder.create();
        listView.setOnItemClickListener(new nb(this, create));
        create.show();
    }

    static /* synthetic */ void m955c(TaskerPluginActivity taskerPluginActivity) {
        BroadcastReceiver nhVar = new nh(taskerPluginActivity);
        taskerPluginActivity.sendOrderedBroadcast(new Intent("android.speech.action.GET_LANGUAGE_DETAILS"), null, nhVar, null, -1, null, null);
    }

    public final void finish() {
        ls.m1346c("TPA onFinish()");
        if (this.f897l) {
            setResult(0);
        } else {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("com.brandall.nutter.extra.STRING_MESSAGE", this.f903r);
            bundle.putString("com.brandall.nutter.extra.STRING_MESSAGE1", String.valueOf(this.f900o));
            bundle.putString("com.brandall.nutter.extra.STRING_MESSAGE2", this.f901p);
            bundle.putString("com.brandall.nutter.extra.STRING_MESSAGE3", String.valueOf(this.f898m));
            bundle.putString("com.brandall.nutter.extra.STRING_MESSAGE4", String.valueOf(this.f899n));
            bundle.putString("com.brandall.nutter.extra.STRING_MESSAGE5", this.f904s);
            bundle.putString("com.brandall.nutter.extra.STRING_MESSAGE6", this.f904s);
            bundle.putString("com.brandall.nutter.extra.STRING_MESSAGE7", this.f902q);
            if (this.f899n) {
                ls.m1346c("storeOnly: true - sending message5");
                bundle.putString("net.dinglisch.android.tasker.extras.VARIABLE_REPLACE_KEYS", "com.brandall.nutter.extra.STRING_MESSAGE5");
                this.f896k.setText(this.f904s);
            } else {
                ls.m1346c("storeOnly: false - sending message");
                bundle.putString("net.dinglisch.android.tasker.extras.VARIABLE_REPLACE_KEYS", "com.brandall.nutter.extra.STRING_MESSAGE");
            }
            intent.putExtra("com.twofortyfouram.locale.intent.extra.BUNDLE", bundle);
            if (this.f903r.length() > getResources().getInteger(R.integer.twofortyfouram_locale_maximum_blurb_length) && this.f904s.length() > getResources().getInteger(R.integer.twofortyfouram_locale_maximum_blurb_length)) {
                intent.putExtra("com.twofortyfouram.locale.intent.extra.BLURB", this.f903r.substring(0, getResources().getInteger(R.integer.twofortyfouram_locale_maximum_blurb_length)));
            } else if (this.f899n) {
                intent.putExtra("com.twofortyfouram.locale.intent.extra.BLURB", this.f904s);
            } else {
                intent.putExtra("com.twofortyfouram.locale.intent.extra.BLURB", this.f903r);
            }
            setResult(-1, intent);
        }
        super.finish();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && intent != null) {
            try {
                Iterator it = intent.getStringArrayListExtra("availableVoices").iterator();
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    Locale locale = new Locale((String) it.next());
                    if (hc.f1269b) {
                        ls.m1346c("language locale: " + locale.toString());
                    }
                    arrayList.add(locale);
                }
                m952a(arrayList);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Something went wrong", 0).show();
            }
        }
        this.f886a.setChecked(false);
    }

    public final void onBackPressed() {
        ls.m1346c("APA onBackPressed");
        m947a();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            ls.m1345b("Landscape");
        } else if (configuration.orientation == 1) {
            ls.m1345b("Portrait");
        }
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tasker_plugin_layout);
        this.f889d = (CheckBox) findViewById(R.id.checkBoxvrl);
        this.f886a = (CheckBox) findViewById(R.id.checkBoxve);
        this.f887b = (CheckBox) findViewById(R.id.checkBoxvr);
        this.f888c = (CheckBox) findViewById(R.id.checkBoxso);
        this.f890e = (RadioGroup) findViewById(R.id.radioGroup1);
        this.f891f = (RadioButton) findViewById(R.id.radio0);
        this.f892g = (RadioButton) findViewById(R.id.radio1);
        this.f893h = (Button) findViewById(R.id.saveButton);
        this.f894i = (Button) findViewById(R.id.cancelButton);
        this.f895j = (EditText) findViewById(R.id.editTextName);
        this.f896k = (EditText) findViewById(R.id.textUtter);
        gw.m1001a(getIntent());
        gw.m1002a(getIntent().getBundleExtra("com.twofortyfouram.locale.intent.extra.BUNDLE"));
        if (VERSION.SDK_INT >= 11) {
            CharSequence applicationLabel;
            try {
                applicationLabel = getPackageManager().getApplicationLabel(getPackageManager().getApplicationInfo(getCallingPackage(), 0));
            } catch (Throwable e) {
                Log.e("TaskerPlugin", "Calling package couldn't be found", e);
                applicationLabel = null;
            }
            if (applicationLabel != null) {
                setTitle(applicationLabel);
            }
        } else {
            setTitle(C0173a.m1510a(getApplicationContext(), getIntent(), getString(R.string.plugin_name)));
        }
        if (bundle == null) {
            Bundle bundleExtra = getIntent().getBundleExtra("com.twofortyfouram.locale.intent.extra.BUNDLE");
            if (lu.m1355a(bundleExtra)) {
                if (bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE4") == null || !bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE4").matches("true")) {
                    if (bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE") != null) {
                        this.f896k.setText(bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE"));
                    }
                    if (bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE1") == null || !bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE1").matches("true")) {
                        this.f892g.setChecked(true);
                    } else {
                        this.f891f.setChecked(true);
                    }
                    if (bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE3") == null || !bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE3").matches("true")) {
                        this.f889d.setChecked(false);
                    } else {
                        this.f887b.setChecked(true);
                        this.f889d.setVisibility(0);
                        if (!(bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE7") == null || bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE7").isEmpty())) {
                            this.f889d.setChecked(true);
                            this.f889d.setText(bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE7"));
                        }
                    }
                    if (bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE2") == null || bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE2").isEmpty()) {
                        this.f886a.setChecked(false);
                    } else {
                        this.f886a.setChecked(true);
                        this.f886a.setText(bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE2"));
                    }
                } else {
                    this.f888c.setChecked(true);
                    this.f899n = true;
                    this.f886a.setVisibility(8);
                    this.f887b.setVisibility(8);
                    this.f890e.setVisibility(8);
                    this.f889d.setVisibility(8);
                    this.f896k.setVisibility(8);
                    this.f895j.setVisibility(0);
                    this.f895j.setText(bundleExtra.getString("com.brandall.nutter.extra.STRING_MESSAGE6"));
                }
            }
        }
        this.f893h.setOnClickListener(new mx(this));
        this.f894i.setOnClickListener(new nc(this));
        this.f887b.setOnCheckedChangeListener(new nd(this));
        this.f889d.setOnCheckedChangeListener(new ne(this));
        this.f888c.setOnCheckedChangeListener(new nf(this));
        this.f886a.setOnCheckedChangeListener(new ng(this));
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.twofortyfouram_locale_help_save_dontsave, menu);
        if (VERSION.SDK_INT >= 11) {
            getActionBar().setSubtitle(C0173a.m1510a(getApplicationContext(), getIntent(), getString(R.string.plugin_name)));
        }
        if (VERSION.SDK_INT >= 14) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
            try {
                getActionBar().setIcon(getPackageManager().getApplicationIcon(getCallingPackage()));
            } catch (Throwable e) {
                Log.w("TaskerPlugin", "An error occurred loading the host's icon", e);
            }
        }
        return true;
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        } else if (itemId == R.id.twofortyfouram_locale_menu_help) {
            try {
                startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse("http://forum.xda-developers.com/showthread.php?t=1508195")));
                return true;
            } catch (Throwable e) {
                Log.e("TaskerPlugin", "Couldn't start Activity", e);
                return true;
            }
        } else if (itemId == R.id.twofortyfouram_locale_menu_dontsave) {
            this.f897l = true;
            finish();
            return true;
        } else if (itemId != R.id.twofortyfouram_locale_menu_save) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            finish();
            return true;
        }
    }
}
