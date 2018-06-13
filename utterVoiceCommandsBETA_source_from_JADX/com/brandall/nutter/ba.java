package com.brandall.nutter;

import android.view.View;
import android.view.View.OnClickListener;

final class ba implements OnClickListener {
    final /* synthetic */ ActivityContactPicker f955a;

    ba(ActivityContactPicker activityContactPicker) {
        this.f955a = activityContactPicker;
    }

    public final void onClick(View view) {
        if (GlobalV.ap()) {
            try {
                ServiceTTS.m911a();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        GlobalV.m899w(true);
        lc.m1313a(this.f955a, false, "Please enter the nickname for this contact. It will be matched every time you perform a contact command. It's always a good idea to check first, that Google Voice Search recognises the nickname you are intending to use. As an example, you could enter, my best friend, and I will link this contact to that name. Then you can say, call my best friend on their mobile. Don't forget, you'll need to make sure that when calling contacts on their mobile, or texting them, they have a number listed in the mobile field of their contact card. Custom labels or work numbers will not be detected.");
    }
}
