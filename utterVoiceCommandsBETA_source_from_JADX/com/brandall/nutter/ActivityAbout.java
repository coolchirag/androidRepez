package com.brandall.nutter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import br.com.dina.ui.p010a.C0090a;
import br.com.dina.ui.widget.UITableView;

public class ActivityAbout extends Activity {
    UITableView f647a;

    static /* synthetic */ void m473a(ActivityAbout activityAbout) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://github.com/thiagolocatelli/android-uitableview"));
        intent.setFlags(268435456);
        activityAbout.startActivity(intent);
    }

    static /* synthetic */ void m474b(ActivityAbout activityAbout) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://github.com/pingpongboss/StandOut"));
        intent.setFlags(268435456);
        activityAbout.startActivity(intent);
    }

    static /* synthetic */ void m475c(ActivityAbout activityAbout) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://github.com/winterstein/JTwitter"));
        intent.setFlags(268435456);
        activityAbout.startActivity(intent);
    }

    static /* synthetic */ void m476d(ActivityAbout activityAbout) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://github.com/boatmeme/microsoft-translator-android-test"));
        intent.setFlags(268435456);
        activityAbout.startActivity(intent);
    }

    static /* synthetic */ void m477e(ActivityAbout activityAbout) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://github.com/xnickmx/google-play-client"));
        intent.setFlags(268435456);
        activityAbout.startActivity(intent);
    }

    static /* synthetic */ void m478f(ActivityAbout activityAbout) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://github.com/vaal12/AndroidFileBrowser"));
        intent.setFlags(268435456);
        activityAbout.startActivity(intent);
    }

    static /* synthetic */ void m479g(ActivityAbout activityAbout) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://theahrt.com"));
        intent.setFlags(268435456);
        activityAbout.startActivity(intent);
    }

    static /* synthetic */ void m480h(ActivityAbout activityAbout) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"benrandall76@gmail.com"});
        intent.putExtra("android.intent.extra.SUBJECT", "utter! Commercial Enquiry");
        intent.setFlags(268435456);
        try {
            activityAbout.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        setContentView(R.layout.about_layout);
        this.f647a = (UITableView) findViewById(R.id.tableView);
        this.f647a.setClickListener(new C0143b());
        C0090a c0090a = new C0090a("utter! release notes", "• Author - brandall @xda\n• Version 3.0.2B BETA release\n• Start at boot toggle\n• bug fixes\n• Version 3.0.1B BETA release\n• Offline ready - Jelly Bean\n• bug fixes\n• Version 3.0.0B BETA release\n• Foursquare\n• Tutorial\n• More ads\n• Information buttons\n• Google unknown\n• Localised english domains\n• Redial\n• Call back\n• Remember this\n• Waze support\n• Find my car\n• App search\n• File Expert Support\n• Call number\n• Proof read\n• Application settings\n• SMS fix\n• Navigate to contact\n• Long press home\n• BUG FIXES!\n• SPEED ENHANCEMENTS!\n\n• Version 2.2.9B BETA release\n• Updated app icon - thanks Hannes Ahremark!\n• Bug fixes\n• Version 2.2.8B BETA release\n• Bug fixes\n• Version 2.2.7B BETA release\n• Configurable to any Google Voice Search Language!\n• Replace Command Phrases & Words\n• Nicknames\n• XML/Cloud Import/Export\n• Sound Effects\n• ATT&T, Dragon, iSpeech Demo\n• Coding/speed enhancements");
        c0090a.f293a = false;
        this.f647a.m292a(c0090a);
        c0090a = new C0090a("UItableview - library");
        c0090a.f297e = "github.com/thiagolocatelli/android-uitableview";
        this.f647a.m292a(c0090a);
        c0090a = new C0090a("StandOut - library");
        c0090a.f297e = "github.com/pingpongboss/StandOut";
        this.f647a.m292a(c0090a);
        c0090a = new C0090a("JTwitter - library");
        c0090a.f297e = "github.com/winterstein/JTwitter";
        this.f647a.m292a(c0090a);
        c0090a = new C0090a("microsoft-translator - library");
        c0090a.f297e = "github.com/boatmeme/microsoft-translator";
        this.f647a.m292a(c0090a);
        c0090a = new C0090a("Google-Play-Client - library");
        c0090a.f297e = "github.com/xnickmx/google-play-client";
        this.f647a.m292a(c0090a);
        c0090a = new C0090a("File Browser - library");
        c0090a.f297e = "github.com/vaal12/AndroidFileBrowser";
        this.f647a.m292a(c0090a);
        c0090a = new C0090a("Hannes Ahremark - App Icon");
        c0090a.f297e = "theahrt.com";
        this.f647a.m292a(c0090a);
        c0090a = new C0090a("Special thanks to: ", "• nobnut@xda\n• Hannes Ahremark - icon\n• meadowsjared@xda\n• waydownsouth@xda\n\nThe many hardened testers @xda\nAll bug reports, feedback & messages of support!");
        c0090a.f293a = false;
        this.f647a.m292a(c0090a);
        c0090a = new C0090a("Commercial Enquiries");
        c0090a.f294b = R.drawable.email;
        c0090a.f297e = "email the developer";
        this.f647a.m292a(c0090a);
        this.f647a.m291a();
    }

    public void onDestroy() {
        super.onDestroy();
        if (hc.f1269b) {
            ls.m1346c("AboutActivity onDestroy");
        }
    }

    public void onPause() {
        super.onPause();
        if (hc.f1269b) {
            ls.m1346c("AboutActivity onPause");
        }
    }

    public void onResume() {
        super.onResume();
        if (hc.f1269b) {
            ls.m1346c("AboutActivity onResume");
        }
    }
}
