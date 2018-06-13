package com.brandall.nutter;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.List;

public final class dg extends BaseExpandableListAdapter {
    final /* synthetic */ ActivityPickerActivity f1048a;
    private final List<PackageInfo> f1049b;
    private final LayoutParams f1050c = new LayoutParams(-1, -2);
    private final LayoutParams f1051d = new LayoutParams(-1, this.f1052e);
    private final int f1052e;

    public dg(ActivityPickerActivity activityPickerActivity, List<PackageInfo> list) {
        this.f1048a = activityPickerActivity;
        this.f1049b = list;
        this.f1052e = activityPickerActivity.getResources().getDimensionPixelSize(17104896);
    }

    private ActivityInfo m984a(int i, int i2) {
        try {
            PackageInfo packageInfo = this.f1048a.f694a.getPackageInfo(((PackageInfo) this.f1049b.get(i)).packageName, 1);
            return packageInfo.activities != null ? packageInfo.activities[i2] : null;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    private PackageInfo m985a(int i) {
        return (PackageInfo) this.f1049b.get(i);
    }

    private TextView m986a() {
        TextView textView = new TextView(this.f1048a);
        textView.setLayoutParams(this.f1050c);
        textView.setGravity(19);
        textView.setPadding(this.f1052e, 0, 0, 0);
        return textView;
    }

    public final /* synthetic */ Object getChild(int i, int i2) {
        return m984a(i, i2);
    }

    public final long getChildId(int i, int i2) {
        return (long) i2;
    }

    public final View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        View a = m986a();
        ActivityInfo a2 = m984a(i, i2);
        if (a2 != null) {
            a.setText(a2.loadLabel(this.f1048a.f694a) + "(" + a2.name.replace(a2.packageName, "") + ")");
            a.setLayoutParams(this.f1051d);
        }
        return a;
    }

    public final int getChildrenCount(int i) {
        try {
            PackageInfo packageInfo = this.f1048a.f694a.getPackageInfo(((PackageInfo) this.f1049b.get(i)).packageName, 1);
            return packageInfo.activities != null ? packageInfo.activities.length : 0;
        } catch (NameNotFoundException e) {
            return 0;
        }
    }

    public final /* synthetic */ Object getGroup(int i) {
        return m985a(i);
    }

    public final int getGroupCount() {
        return this.f1049b.size();
    }

    public final long getGroupId(int i) {
        return (long) i;
    }

    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        View a = m986a();
        PackageInfo a2 = m985a(i);
        a.setText(a2.applicationInfo.loadLabel(this.f1048a.f694a));
        try {
            a.setCompoundDrawablesWithIntrinsicBounds(nk.m1493a(a2.applicationInfo.loadIcon(this.f1048a.f694a), this.f1048a), null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            ActivityPickerActivity activityPickerActivity = this.f1048a;
            ActivityPickerActivity.m615a();
            if (hc.f1269b) {
                ls.m1346c("ActivityPickerActivity catch");
            }
        }
        return a;
    }

    public final boolean hasStableIds() {
        return true;
    }

    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
