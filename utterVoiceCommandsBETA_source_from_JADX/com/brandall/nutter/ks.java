package com.brandall.nutter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

final class ks extends ArrayAdapter<kt> {
    final /* synthetic */ FileBrowserActivity f1620a;

    ks(FileBrowserActivity fileBrowserActivity, Context context, List list) {
        this.f1620a = fileBrowserActivity;
        super(context, 17367057, 16908308, list);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        TextView textView = (TextView) view2.findViewById(16908308);
        textView.setCompoundDrawablesWithIntrinsicBounds(((kt) this.f1620a.f753c.get(i)).f1622b != -1 ? ((kt) this.f1620a.f753c.get(i)).f1622b : 0, 0, 0, 0);
        textView.setEllipsize(null);
        textView.setCompoundDrawablePadding((int) ((3.0f * this.f1620a.getResources().getDisplayMetrics().density) + 0.5f));
        textView.setBackgroundColor(-3355444);
        return view2;
    }
}
