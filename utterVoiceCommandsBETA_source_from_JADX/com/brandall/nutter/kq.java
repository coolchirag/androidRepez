package com.brandall.nutter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import java.io.File;

final class kq implements OnItemClickListener {
    final /* synthetic */ FileBrowserActivity f1618a;

    kq(FileBrowserActivity fileBrowserActivity) {
        this.f1618a = fileBrowserActivity;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f1618a.f755e = ((kt) this.f1618a.f753c.get(i)).f1621a;
        File file = new File(this.f1618a.f754d + "/" + this.f1618a.f755e);
        if (file.isDirectory()) {
            if (file.canRead()) {
                this.f1618a.f751a.add(this.f1618a.f755e);
                this.f1618a.f754d = new File(file);
                this.f1618a.m732d();
                this.f1618a.f752b.notifyDataSetChanged();
                this.f1618a.m729c();
                return;
            }
            Toast.makeText(this.f1618a, "Path does not exist or cannot be read", 1).show();
        } else if (!this.f1618a.f757g) {
            FileBrowserActivity.m731c(this.f1618a, file.getAbsolutePath());
        }
    }
}
