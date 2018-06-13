package com.brandall.nutter;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import br.com.dina.ui.p010a.C0090a;
import br.com.dina.ui.widget.UITableView;
import com.google.ads.AdView;
import com.google.ads.C0237d;
import com.google.ads.p028a.C0227h;
import com.google.ads.p028a.p029a.C0228a;

public class ActivityCommunity extends Activity {
    UITableView f663a;
    private AdView f664b;

    static /* synthetic */ void m514a(ActivityCommunity activityCommunity) {
        if (hc.f1269b) {
            ls.m1346c("in sendJoke");
        }
        Dialog dialog = new Dialog(activityCommunity);
        dialog.requestWindowFeature(3);
        View inflate = ((LayoutInflater) activityCommunity.getSystemService("layout_inflater")).inflate(R.layout.submit_joke_dialog_layout, (ViewGroup) activityCommunity.findViewById(R.id.sjdl));
        EditText editText = (EditText) inflate.findViewById(R.id.joke);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.helpButton);
        Button button = (Button) inflate.findViewById(R.id.positiveButton);
        Button button2 = (Button) inflate.findViewById(R.id.negativeButton);
        dialog.setContentView(inflate);
        dialog.setFeatureDrawableResource(3, R.drawable.acidhouse);
        dialog.setTitle("Submit a Joke!");
        dialog.show();
        dialog.setOnCancelListener(new as(activityCommunity));
        button.setOnClickListener(new at(activityCommunity, editText, dialog));
        button2.setOnClickListener(new au(activityCommunity, dialog));
        imageButton.setOnClickListener(new av(activityCommunity));
    }

    private void m516a(String str) {
        ((Vibrator) getSystemService("vibrator")).vibrate(100);
        Toast.makeText(this, str, 1).show();
    }

    static /* synthetic */ void m517b(ActivityCommunity activityCommunity) {
        if (hc.f1269b) {
            ls.m1346c("in submitKnowledge");
        }
        View inflate = ((LayoutInflater) activityCommunity.getSystemService("layout_inflater")).inflate(R.layout.submit_knowledge_dialog_layout, (ViewGroup) activityCommunity.findViewById(R.id.skdl));
        Builder builder = new Builder(activityCommunity);
        builder.setIcon(R.drawable.knowledgetree);
        builder.setTitle("Submit knowledge");
        builder.setInverseBackgroundForced(true);
        EditText editText = (EditText) inflate.findViewById(R.id.question);
        EditText editText2 = (EditText) inflate.findViewById(R.id.answer);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.helpButton);
        Button button = (Button) inflate.findViewById(R.id.positiveButton);
        Button button2 = (Button) inflate.findViewById(R.id.negativeButton);
        builder.setView(inflate);
        Dialog show = builder.show();
        show.setOnCancelListener(new ao(activityCommunity));
        button.setOnClickListener(new ap(activityCommunity, editText, editText2, show));
        button2.setOnClickListener(new aq(activityCommunity, show));
        imageButton.setOnClickListener(new ar(activityCommunity));
    }

    static /* synthetic */ void m519c(ActivityCommunity activityCommunity) {
        if (hc.f1269b) {
            ls.m1346c("in communityAnswers");
        }
        activityCommunity.m516a("Coming soon!");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            if (hc.f1269b) {
                ls.m1345b("Landscape");
            }
        } else if (configuration.orientation == 1 && hc.f1269b) {
            ls.m1345b("Portrait");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.community_layout);
        if (hc.f1269b) {
            ls.m1346c("ActivityCommunity OnCreate");
        }
        this.f664b = (AdView) findViewById(R.id.adView);
        this.f663a = (UITableView) findViewById(R.id.tableView);
        this.f663a.setClickListener(new aw());
        C0090a c0090a = new C0090a("Submit Joke");
        c0090a.f294b = R.drawable.acidhouse;
        c0090a.f297e = "tap to send";
        this.f663a.m292a(c0090a);
        c0090a = new C0090a("Submit Knowledge");
        c0090a.f294b = R.drawable.knowledgetree;
        c0090a.f297e = "tap to send";
        this.f663a.m292a(c0090a);
        c0090a = new C0090a("Community Responses");
        c0090a.f294b = R.drawable.communityresponses;
        c0090a.f297e = "tap to enable";
        if (getSharedPreferences("utterPref", 0).getBoolean("community_response", false)) {
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f295c = R.drawable.cross;
        }
        this.f663a.m292a(c0090a);
        this.f663a.m291a();
        StrictMode.setThreadPolicy(new ThreadPolicy.Builder().permitAll().build());
        C0227h a = new C0228a().mo111a("color_bg", "FFFFFF").mo111a("color_link", "000080").mo111a("color_text", "808080").mo111a("color_url", "008000");
        C0237d c0237d = new C0237d();
        if (GlobalV.m887s()) {
            c0237d.m1638a("FAFFD14896DE0B88FCFDD1692625BFAD");
            c0237d.m1638a("CC24C2B6FF78E3A8AD39DD88ECEF74EF");
            c0237d.m1638a("CC24C2B6FF78E4A8AD39DD88ECEF74EF");
            c0237d.m1638a("26F26F9E436091DB6D26BBFDBBC01B01");
        }
        c0237d.m1636a(a);
        this.f664b.m1593a(c0237d);
    }

    public void onDestroy() {
        super.onDestroy();
        if (hc.f1269b) {
            ls.m1346c("AC onDestroy");
        }
        if (this.f664b != null) {
            this.f664b.removeAllViews();
            this.f664b.m1592a();
        }
        getWindow().clearFlags(128);
    }

    public void onPause() {
        super.onPause();
        if (hc.f1269b) {
            ls.m1346c("AC onPause");
        }
    }

    public void onResume() {
        super.onResume();
        if (hc.f1269b) {
            ls.m1346c("AC onResume");
        }
    }
}
