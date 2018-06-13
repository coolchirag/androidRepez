package com.google.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.faceture.google.play.QueryParamConst;
import com.google.ads.internal.C0264p;
import com.google.ads.internal.C0265q;
import java.util.HashMap;

final class C0313x implements OnClickListener {
    private C0264p f2309a;

    public C0313x(C0264p c0264p) {
        this.f2309a = c0264p;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(QueryParamConst.U_NAME, "market://details?id=com.google.android.apps.plus");
        AdActivity.m1566a(this.f2309a, new C0265q("intent", hashMap));
    }
}
