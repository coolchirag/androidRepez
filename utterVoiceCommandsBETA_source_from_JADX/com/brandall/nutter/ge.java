package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;

final class ge implements OnClickListener {
    final /* synthetic */ ActivityUserPhrases f1225a;
    private final /* synthetic */ EditText f1226b;
    private final /* synthetic */ EditText f1227c;
    private final /* synthetic */ EditText f1228d;

    ge(ActivityUserPhrases activityUserPhrases, EditText editText, EditText editText2, EditText editText3) {
        this.f1225a = activityUserPhrases;
        this.f1226b = editText;
        this.f1227c = editText2;
        this.f1228d = editText3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String editable = this.f1226b.getText().toString();
        String editable2 = this.f1227c.getText().toString();
        String editable3 = this.f1228d.getText().toString();
        if (editable == null || editable.isEmpty() || editable.matches("") || editable.length() <= 0 || editable2 == null || editable2.isEmpty() || editable2.matches("") || editable2.length() <= 0 || editable3 == null || editable3.isEmpty() || editable3.matches("") || editable3.length() <= 0) {
            lc.m1313a(this.f1225a, false, "The format of your custom command was incorrect. It has not been edited.");
        } else {
            this.f1225a.m709a(editable.trim(), editable2.trim(), editable3.trim());
        }
    }
}
