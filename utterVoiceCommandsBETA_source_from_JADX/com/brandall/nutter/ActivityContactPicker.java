package com.brandall.nutter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ActivityContactPicker extends Activity {
    private static boolean f665a = false;
    private static boolean f666b = false;
    private static boolean f667c = false;

    private void m520a() {
        Intent intent = new Intent("android.intent.action.PICK", Contacts.CONTENT_URI);
        intent.setFlags(1073741824);
        startActivityForResult(intent, 1468);
    }

    private void m523b() {
        ls.m1346c("ACP tidyUp");
        new he(this).m1067a(GlobalV.m798K());
        ls.m1344a("GlobalV.getDbUcRow(): " + GlobalV.m798K());
        GlobalV.m815a();
        finish();
    }

    @SuppressLint({"NewApi"})
    public void onActivityResult(int i, int i2, Intent intent) {
        ls.m1346c("onActivityResult");
        if (i != 1468 || i2 != -1) {
            ls.m1348e("picker data was null");
            if (f667c) {
                lc.m1313a(this, false, "Nickname selection cancelled.");
                finish();
                return;
            }
            m523b();
            lc.m1313a(this, false, "The command creation has been cancelled");
        } else if (intent != null) {
            Uri data = intent.getData();
            if (data != null) {
                String trim = intent.getData().getLastPathSegment().trim();
                ls.m1346c("contactURI: " + data);
                ls.m1346c("contactID: " + trim);
                String a = hx.m1148a((Context) this, data);
                ls.m1346c("contactName: " + a);
                if (a == null || a.isEmpty() || trim == null || trim.isEmpty()) {
                    ls.m1348e("contactName contactID null");
                    if (f667c) {
                        lc.m1313a(this, false, "Something went wrong storing the contact data. The nickname selection cancelled.");
                        finish();
                        return;
                    }
                    m523b();
                    lc.m1313a(this, false, "Something went wrong storing the contact data. The command creation has been cancelled");
                    return;
                } else if (f665a) {
                    ls.m1346c("call: true");
                    r0 = new ArrayList();
                    List b = hx.m1151b(this, trim);
                    if (b.isEmpty()) {
                        lc.m1313a(this, false, "Sorry, but I didn't detect any numbers for that contact.");
                        m523b();
                        return;
                    }
                    ls.m1346c("numberDialog");
                    lc.m1313a(this, false, "Please select the number.");
                    Builder builder = new Builder(this);
                    builder.setIcon(17301652);
                    builder.setTitle("Select Number");
                    View listView = new ListView(this);
                    listView.setAdapter(new ArrayAdapter(this, 17367043, 16908308, b));
                    builder.setOnCancelListener(new bb(this));
                    builder.setNegativeButton("Cancel", new bc(this));
                    builder.setView(listView);
                    Dialog create = builder.create();
                    listView.setOnItemClickListener(new bd(this, a, trim, create));
                    create.show();
                    return;
                } else if (f666b) {
                    ls.m1346c("display: true");
                    r0 = new ArrayList();
                    r0.add(a);
                    r0.add(trim);
                    if (VERSION.SDK_INT >= 11) {
                        new gx(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{r0});
                    } else {
                        new gx(this).execute(new ArrayList[]{r0});
                    }
                    finish();
                    return;
                } else if (f667c) {
                    ls.m1346c("nicknames: true");
                    ls.m1346c("in nameDialog");
                    View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.nickname_dialog_layout, (ViewGroup) findViewById(R.id.ndl));
                    Dialog dialog = new Dialog(this);
                    dialog.requestWindowFeature(3);
                    dialog.setTitle("Enter contact nickname");
                    EditText editText = (EditText) inflate.findViewById(R.id.nickname);
                    editText.setHint(lv.m1356a());
                    ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.helpButton);
                    Button button = (Button) inflate.findViewById(R.id.positiveButton);
                    Button button2 = (Button) inflate.findViewById(R.id.negativeButton);
                    dialog.setContentView(inflate);
                    dialog.setFeatureDrawableResource(3, R.drawable.nicknames);
                    dialog.setTitle("Enter contact nickname");
                    dialog.show();
                    dialog.setOnCancelListener(new ax(this));
                    button.setOnClickListener(new ay(this, editText, a, trim, dialog));
                    button2.setOnClickListener(new az(this, dialog));
                    imageButton.setOnClickListener(new ba(this));
                    return;
                } else {
                    ls.m1347d("call display: false");
                    m523b();
                    lc.m1313a(this, false, "Something went wrong. The creation has been cancelled");
                    return;
                }
            }
            ls.m1348e("contactURI was null");
            if (f667c) {
                lc.m1313a(this, false, "Something went wrong storing the contact data. The nickname selection cancelled.");
                finish();
                return;
            }
            m523b();
            lc.m1313a(this, false, "Something went wrong storing the contact data. The command creation has been cancelled");
        } else {
            ls.m1348e("picker selection was null");
            if (f667c) {
                lc.m1313a(this, false, "Nickname selection cancelled.");
                finish();
                return;
            }
            m523b();
            lc.m1313a(this, false, "The command creation has been cancelled");
        }
    }

    public void onBackPressed() {
        ls.m1346c("ACP onBackPressed");
        if (f667c) {
            lc.m1313a(this, false, "Nickname selection cancelled.");
        } else {
            m523b();
            lc.m1313a(this, false, "The command creation has been cancelled");
        }
        finish();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            ls.m1345b("Landscape");
        } else if (configuration.orientation == 1) {
            ls.m1345b("Portrait");
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ls.m1346c("ActivityContactPicker onCreate");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            f665a = false;
            f666b = false;
            if (extras.getString("sender").matches("call")) {
                ls.m1346c("ACP sender call");
                f665a = true;
            } else if (extras.getString("sender").matches("display")) {
                ls.m1346c("ACP sender display");
                f666b = true;
            } else if (extras.getString("sender").matches("nicknames")) {
                ls.m1346c("ACP sender nicknames");
                f667c = true;
            } else {
                ls.m1347d("ACP sender no data");
            }
        }
        m520a();
    }

    public void onDestroy() {
        super.onDestroy();
        ls.m1346c("ACP onDestroy");
    }

    public void onPause() {
        super.onPause();
        ls.m1346c("ACP onPause");
    }

    public void onResume() {
        super.onResume();
        ls.m1346c("ACP onResume");
    }
}
