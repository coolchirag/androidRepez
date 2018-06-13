package com.brandall.nutter;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import wei.mark.standout.C0615g;
import wei.mark.standout.C0616h;
import wei.mark.standout.StandOutWindow;

public class VoiceResultsWindow extends StandOutWindow {
    private ListView f905a;

    protected final String mo66a() {
        return " utter!";
    }

    protected final C0615g mo67a(int i) {
        return i == 2 ? new C0615g(this, i, 400, 600) : new C0615g(this, i, 275, 300);
    }

    protected final void mo68a(int i, FrameLayout frameLayout) {
        ls.m1346c("createAndAttachView");
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        switch (i) {
            case 0:
                this.f905a = (ListView) layoutInflater.inflate(R.layout.voice_results_widget, frameLayout, true).findViewById(R.id.list);
                ArrayList arrayList = new ArrayList();
                List aA = GlobalV.aA();
                ls.m1346c("toDisplay: " + aA.toString());
                this.f905a.setAdapter(new ArrayAdapter(getApplicationContext(), 17367043, aA));
                return;
            case 2:
                TextView textView = (TextView) layoutInflater.inflate(R.layout.command_list_window, frameLayout, true).findViewById(R.id.textViewCL);
                textView.setText(getResources().getString(R.string.command_content));
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                return;
            default:
                return;
        }
    }

    protected final int mo69b() {
        return R.drawable.utternotpb;
    }

    protected final Animation mo70b(int i) {
        return m775f(i) ? AnimationUtils.loadAnimation(this, 17432576) : super.mo70b(i);
    }

    protected final int mo71c() {
        return (((C0616h.f3150a | C0616h.f3154e) | C0616h.f3157h) | C0616h.f3158i) | C0616h.f3160k;
    }

    protected final Animation mo72d() {
        return AnimationUtils.loadAnimation(this, 17432577);
    }
}
