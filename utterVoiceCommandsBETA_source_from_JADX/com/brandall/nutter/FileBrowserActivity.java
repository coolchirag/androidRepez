package com.brandall.nutter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileBrowserActivity extends Activity {
    private static int f750h = -1;
    ArrayList<String> f751a = new ArrayList();
    ArrayAdapter<kt> f752b;
    private List<kt> f753c = new ArrayList();
    private File f754d = null;
    private String f755e;
    private boolean f756f = true;
    private boolean f757g = false;

    static /* synthetic */ void m723a(FileBrowserActivity fileBrowserActivity) {
        fileBrowserActivity.f754d = new File(fileBrowserActivity.f754d.toString().substring(0, fileBrowserActivity.f754d.toString().lastIndexOf((String) fileBrowserActivity.f751a.remove(fileBrowserActivity.f751a.size() - 1))));
        fileBrowserActivity.f753c.clear();
    }

    private void m726b() {
        this.f751a.clear();
        String[] split = this.f754d.getAbsolutePath().split("/");
        for (Object add : split) {
            this.f751a.add(add);
        }
    }

    private void m729c() {
        String str = "";
        int i = 0;
        while (i < this.f751a.size()) {
            i++;
            str = new StringBuilder(String.valueOf(str)).append((String) this.f751a.get(i)).append("/").toString();
        }
        if (this.f751a.size() == 0) {
            ((Button) findViewById(R.id.upDirectoryButton)).setEnabled(false);
            str = "/";
        } else {
            ((Button) findViewById(R.id.upDirectoryButton)).setEnabled(true);
        }
        ((TextView) findViewById(R.id.currentDirectoryTextView)).setText("Current directory:\n" + str);
    }

    static /* synthetic */ void m731c(FileBrowserActivity fileBrowserActivity, String str) {
        Intent intent = new Intent();
        intent.putExtra("ua.com.vassiliev.androidfilebrowser.filePathRet", str);
        fileBrowserActivity.setResult(-1, intent);
        fileBrowserActivity.finish();
    }

    private void m732d() {
        try {
            this.f754d.mkdirs();
        } catch (SecurityException e) {
        }
        this.f753c.clear();
        if (this.f754d.exists() && this.f754d.canRead()) {
            String[] list = this.f754d.list(new kr(this));
            this.f757g = false;
            for (int i = 0; i < list.length; i++) {
                File file = new File(this.f754d, list[i]);
                int i2 = R.drawable.file_icon;
                boolean canRead = file.canRead();
                if (file.isDirectory()) {
                    i2 = canRead ? R.drawable.folder_icon : R.drawable.folder_icon_light;
                }
                this.f753c.add(i, new kt(this, list[i], Integer.valueOf(i2)));
            }
            if (this.f753c.size() == 0) {
                this.f757g = true;
                this.f753c.add(0, new kt(this, "Directory is parent", Integer.valueOf(-1)));
                return;
            }
            Collections.sort(this.f753c, new ku());
        }
    }

    static /* synthetic */ void m733d(FileBrowserActivity fileBrowserActivity) {
        Intent intent = new Intent();
        intent.putExtra("ua.com.vassiliev.androidfilebrowser.directoryPathRet", fileBrowserActivity.f754d.getAbsolutePath());
        fileBrowserActivity.setResult(-1, intent);
        fileBrowserActivity.finish();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != 2) {
            int i = configuration.orientation;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ua_com_vassiliev_filebrowser_layout);
        Intent intent = getIntent();
        f750h = 1;
        if (intent.getAction().equalsIgnoreCase("ua.com.vassiliev.androidfilebrowser.SELECT_FILE_ACTION")) {
            f750h = 2;
        }
        this.f756f = intent.getBooleanExtra("ua.com.vassiliev.androidfilebrowser.showCannotRead", true);
        String stringExtra = getIntent().getStringExtra("ua.com.vassiliev.androidfilebrowser.directoryPath");
        if (stringExtra != null && stringExtra.length() > 0) {
            File file = new File(stringExtra);
            if (file.isDirectory()) {
                this.f754d = file;
            }
        }
        if (this.f754d == null) {
            if (Environment.getExternalStorageDirectory().isDirectory() && Environment.getExternalStorageDirectory().canRead()) {
                this.f754d = Environment.getExternalStorageDirectory();
            } else {
                this.f754d = new File("/");
            }
        }
        m726b();
        m732d();
        this.f752b = new ks(this, this, this.f753c);
        ((Button) findViewById(R.id.upDirectoryButton)).setOnClickListener(new ko(this));
        Button button = (Button) findViewById(R.id.selectCurrentDirectoryButton);
        if (f750h == 1) {
            button.setOnClickListener(new kp(this));
        } else {
            button.setVisibility(8);
        }
        ListView listView = (ListView) findViewById(R.id.fileListView);
        listView.setBackgroundColor(-3355444);
        new LayoutParams(-1, -1).setMargins(15, 5, 15, 5);
        listView.setAdapter(this.f752b);
        listView.setOnItemClickListener(new kq(this));
        m729c();
    }
}
