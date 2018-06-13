package com.brandall.nutter;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.Vibrator;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;
import br.com.dina.ui.p010a.C0090a;
import br.com.dina.ui.widget.UITableView;
import com.dropbox.client2.C0196a;
import com.dropbox.client2.android.AuthActivity;
import com.dropbox.client2.android.C0199a;
import com.dropbox.client2.android.C0200b;
import com.dropbox.client2.p022c.C0214k;
import com.dropbox.client2.p022c.C0215l;
import com.dropbox.client2.p022c.C0216n;
import com.google.ads.AdView;
import com.google.ads.C0237d;
import com.google.ads.p028a.C0227h;
import com.google.ads.p028a.p029a.C0228a;
import com.p011a.p012a.C0102b;
import java.util.List;
import winterwell.jtwitter.android.AndroidTwitterLogin;

public class ActivityLinkApps extends Activity {
    C0102b f683a = new C0102b("337811739620196");
    UITableView f684b;
    AndroidTwitterLogin f685c;
    private final String f686d = "gglnjer4bz97cf9";
    private final String f687e = "r2i7yv5ojyjjbyr";
    private final C0216n f688f = C0216n.APP_FOLDER;
    private C0196a<C0199a> f689g;
    private boolean f690h = false;
    private boolean f691i = false;
    private AdView f692j;

    static /* synthetic */ void m569A(ActivityLinkApps activityLinkApps) {
        ls.m1346c("fileExpertPlay");
        jy.m1264o(activityLinkApps, "xcxin.filexpert");
    }

    static /* synthetic */ void m570B(ActivityLinkApps activityLinkApps) {
        ls.m1346c("wolframPlay");
        jy.m1264o(activityLinkApps, "com.wolfram.android.alpha");
    }

    static /* synthetic */ void m571C(ActivityLinkApps activityLinkApps) {
        ls.m1346c("ebayPlay");
        jy.m1264o(activityLinkApps, "com.ebay.mobile");
    }

    static /* synthetic */ void m572D(ActivityLinkApps activityLinkApps) {
        ls.m1346c("imdbPlay");
        jy.m1264o(activityLinkApps, "com.imdb.mobile");
    }

    static /* synthetic */ void m573E(ActivityLinkApps activityLinkApps) {
        ls.m1346c("mapsPlay");
        jy.m1264o(activityLinkApps, "com.google.android.apps.maps");
    }

    static /* synthetic */ void m574F(ActivityLinkApps activityLinkApps) {
        ls.m1346c("streetViewPlay");
        jy.m1264o(activityLinkApps, "com.google.android.street");
    }

    static /* synthetic */ void m575G(ActivityLinkApps activityLinkApps) {
        ls.m1346c("earthPlay");
        jy.m1264o(activityLinkApps, "com.google.earth");
    }

    static /* synthetic */ void m576H(ActivityLinkApps activityLinkApps) {
        ls.m1346c("wazePlay");
        jy.m1264o(activityLinkApps, "com.waze");
    }

    static /* synthetic */ void m577I(ActivityLinkApps activityLinkApps) {
        ls.m1346c("instagramPlay");
        jy.m1264o(activityLinkApps, "com.instagram.android");
    }

    static /* synthetic */ void m578J(ActivityLinkApps activityLinkApps) {
        ls.m1346c("screencastPlay");
        jy.m1264o(activityLinkApps, "com.ms.screencastfree");
    }

    static /* synthetic */ void m579K(ActivityLinkApps activityLinkApps) {
        ls.m1346c("spotifyPlay");
        jy.m1264o(activityLinkApps, "com.spotify.mobile.android.ui");
    }

    static /* synthetic */ void m580L(ActivityLinkApps activityLinkApps) {
        C0102b c0102b = activityLinkApps.f683a;
        Editor edit = activityLinkApps.getSharedPreferences("utterPref", 0).edit();
        edit.putString("fb_access_token", c0102b.m307b());
        edit.putLong("fb_access_expires", c0102b.m309c());
        edit.commit();
        lx.ar(activityLinkApps);
        lc.m1313a(activityLinkApps, false, "Facebook authorisation successful.");
    }

    static /* synthetic */ void m581a(ActivityLinkApps activityLinkApps) {
        ls.m1346c("dropboxMain");
        jy.m1264o(activityLinkApps, "com.dropbox.android");
    }

    static /* synthetic */ void m583a(ActivityLinkApps activityLinkApps, String str, String str2) {
        Editor edit = activityLinkApps.getSharedPreferences("utterPref", 0).edit();
        edit.putString("tw_token_key", str);
        edit.putString("tw_token_secret", str2);
        edit.commit();
        lx.ar(activityLinkApps);
        ls.m1344a("key: " + str + " :secret: " + str2);
    }

    private void m584a(String str) {
        ((Vibrator) getSystemService("vibrator")).vibrate(100);
        Toast.makeText(this, str, 0).show();
    }

    static /* synthetic */ void m585b(ActivityLinkApps activityLinkApps) {
        ls.m1346c("dropboxAuth");
        activityLinkApps.f689g = new C0196a(new C0199a(new C0215l("gglnjer4bz97cf9", "r2i7yv5ojyjjbyr"), activityLinkApps.f688f));
        C0199a c0199a = (C0199a) activityLinkApps.f689g.m1522a();
        C0215l c0215l = c0199a.f1861a;
        Intent intent = new Intent("android.intent.action.VIEW");
        String str = "db-" + c0215l.a;
        intent.setData(Uri.parse(str + "://1/test"));
        List queryIntentActivities = activityLinkApps.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() == 0) {
            throw new IllegalStateException("URI scheme in your app's manifest is not set up correctly. You should have a com.dropbox.client2.android.AuthActivity with the scheme: " + str);
        }
        if (queryIntentActivities.size() > 1) {
            Builder builder = new Builder(activityLinkApps);
            builder.setTitle("Security alert");
            builder.setMessage("Another app on your phone may be trying to pose as the app you are currently using. The malicious app cannot access your account, but linking to Dropbox has been disabled as a precaution. Please contact support@dropbox.com.");
            builder.setPositiveButton("OK", new C0200b(c0199a));
            builder.show();
        } else {
            if (activityLinkApps.getPackageName().equals(((ResolveInfo) queryIntentActivities.get(0)).activityInfo.packageName)) {
                Intent intent2 = new Intent(activityLinkApps, AuthActivity.class);
                intent2.putExtra("EXTRA_INTERNAL_CONSUMER_KEY", c0215l.a);
                intent2.putExtra("EXTRA_INTERNAL_CONSUMER_SECRET", c0215l.b);
                if (!(activityLinkApps instanceof Activity)) {
                    intent2.addFlags(268435456);
                }
                activityLinkApps.startActivity(intent2);
            } else {
                throw new IllegalStateException("There must be an AuthActivity within your app's package registered for your URI scheme (" + str + "). However, it appears that an activity in a different package is registered for that scheme instead. If you have multiple apps that all want to use the same accesstoken pair, designate one of them to do authentication and have the other apps launch it and then retrieve the token pair from it.");
            }
        }
        lc.m1313a(activityLinkApps, false, "Please confirm that I'm able to access your drop box account.");
    }

    static /* synthetic */ void m590c(ActivityLinkApps activityLinkApps, String str, String str2) {
        lx.m1410c(activityLinkApps, str, str2, true);
        new cy(activityLinkApps, activityLinkApps).execute(new Void[0]);
    }

    static /* synthetic */ void m591d(ActivityLinkApps activityLinkApps) {
        ls.m1346c("facebookPlay");
        jy.m1264o(activityLinkApps, "com.facebook.katana");
    }

    static /* synthetic */ void m592e(ActivityLinkApps activityLinkApps) {
        ls.m1346c("facebookAuth");
        String V = lx.m1383V(activityLinkApps);
        long longValue = lx.m1382U(activityLinkApps).longValue();
        if (!V.isEmpty()) {
            activityLinkApps.f683a.m308b(V);
        }
        if (longValue != 0) {
            activityLinkApps.f683a.m304a(longValue);
        }
        if (activityLinkApps.f683a.m306a()) {
            ls.m1346c("Facebook Session valid");
            lc.m1313a(activityLinkApps, false, "I'm already authorized to post to your Facebook wall.");
            return;
        }
        ls.m1346c("Facebook Session invalid");
        lc.m1313a(activityLinkApps, false, "Authenticating with Facebook, one moment.");
        activityLinkApps.f683a.m305a((Activity) activityLinkApps, new String[]{"publish_stream"}, new cr(activityLinkApps));
    }

    static /* synthetic */ void m593f(ActivityLinkApps activityLinkApps) {
        ls.m1346c("twitterPlay");
        jy.m1264o(activityLinkApps, "com.twitter.android");
    }

    static /* synthetic */ void m594g(ActivityLinkApps activityLinkApps) {
        ls.m1346c("twitterAuth");
        lc.m1313a(activityLinkApps, false, "Please confirm that I am able to post tweets on your behalf.");
        activityLinkApps.f685c = new cs(activityLinkApps, activityLinkApps, "03pZjJaVqOO74I3oBaag", "vUKejSsvTadh4YsrY37EWPBgPjVlFnYyLUsXRhuYzBM", "http://someurl.com");
        try {
            activityLinkApps.f685c.run();
        } catch (Exception e) {
            ls.m1347d("jtwitter Exception atl.run");
            ls.m1347d(e.toString());
            lc.m1313a(activityLinkApps, false, "Twitter authentication failed. Please confirm your device date and time settings are configured correctly.");
        }
    }

    static /* synthetic */ void m595h(ActivityLinkApps activityLinkApps) {
        ls.m1346c("taskerPlay");
        jy.m1264o(activityLinkApps, "net.dinglisch.android.taskerm");
    }

    static /* synthetic */ void m596i(ActivityLinkApps activityLinkApps) {
        ls.m1346c("taskerAuth");
        if (activityLinkApps.f691i) {
            mw b = mv.m1489b(activityLinkApps);
            if (b.equals(mw.NotInstalled)) {
                ls.m1347d("taskerStatus: NotInstalled");
            } else if (b.equals(mw.NotEnabled)) {
                ls.m1347d("taskerStatus: NotEnabled or wrong version");
                String a = mv.m1485a((Context) activityLinkApps);
                if (a.matches("net.dinglisch.android.tasker") || a.matches("net.dinglisch.android.taskerm")) {
                    String str = "";
                    if (a.matches("net.dinglisch.android.tasker")) {
                        ls.m1346c("tskpack Direct: " + a);
                        str = "net.dinglisch.android.tasker";
                    } else if (a.matches("net.dinglisch.android.taskerm")) {
                        ls.m1346c("tskpack Market: " + a);
                        str = "net.dinglisch.android.taskerm";
                    }
                    lc.m1313a(activityLinkApps, false, "Please enable Tasker.");
                    jy.m1251f(activityLinkApps, str);
                    return;
                }
                return;
            } else if (b.equals(mw.AccessBlocked)) {
                ls.m1347d("taskerStatus: AccessBlocked");
                activityLinkApps.startActivity(mv.m1488b());
                lc.m1313a(activityLinkApps, false, "So I can execute tasks for you, please tick the box that allows external access.");
                return;
            } else if (b.equals(mw.OK)) {
                ls.m1346c("taskerStatus: OK");
                lc.m1313a(activityLinkApps, false, "I already have external access permissions for Tasker.");
                activityLinkApps.startActivity(mv.m1488b());
                return;
            } else {
                lc.m1313a(activityLinkApps, false, "There was an error communicating with Tasker.");
                return;
            }
        }
        lc.m1313a(activityLinkApps, false, "You don't have Tasker installed.");
    }

    static /* synthetic */ void m597j(ActivityLinkApps activityLinkApps) {
        ls.m1346c("fourSquarePlay");
        jy.m1264o(activityLinkApps, "com.joelapenna.foursquared");
    }

    static /* synthetic */ void m598k(ActivityLinkApps activityLinkApps) {
        View webView = new WebView(activityLinkApps);
        webView.setBackgroundColor(-16777216);
        webView.setVisibility(0);
        Dialog dialog = new Dialog(activityLinkApps, 16973834);
        dialog.setContentView(webView);
        dialog.show();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new co(activityLinkApps, dialog));
        webView.requestFocus(130);
        webView.setOnTouchListener(new cp(activityLinkApps));
        new Handler().postDelayed(new cq(activityLinkApps, webView), 10);
    }

    static /* synthetic */ void m599l(ActivityLinkApps activityLinkApps) {
        ls.m1346c("googleplusPlay");
        jy.m1264o(activityLinkApps, "com.google.android.apps.plus");
    }

    static /* synthetic */ void m600m(ActivityLinkApps activityLinkApps) {
        ls.m1346c("googleplusAuth");
        activityLinkApps.m584a("Coming very soon!");
    }

    static /* synthetic */ void m601n(ActivityLinkApps activityLinkApps) {
        ls.m1346c("drivePlay");
        jy.m1264o(activityLinkApps, "com.google.android.apps.docs");
    }

    static /* synthetic */ void m602o(ActivityLinkApps activityLinkApps) {
        ls.m1346c("driveAuth");
        activityLinkApps.m584a("Nearly ready to test!");
    }

    static /* synthetic */ void m603p(ActivityLinkApps activityLinkApps) {
        ls.m1346c("linkedinPlay");
        jy.m1264o(activityLinkApps, "com.linkedin.android");
    }

    static /* synthetic */ void m604q(ActivityLinkApps activityLinkApps) {
        ls.m1346c("linkedinAuth");
        activityLinkApps.m584a("Not quite ready yet!");
    }

    static /* synthetic */ void m605r(ActivityLinkApps activityLinkApps) {
        ls.m1346c("emailAuth");
        lc.m1313a(activityLinkApps, false, "Please log in to your Live, Yahoo or Gmail account.");
        View inflate = ((LayoutInflater) activityLinkApps.getSystemService("layout_inflater")).inflate(R.layout.email_dialog_layout, (ViewGroup) activityLinkApps.findViewById(R.id.edl));
        Builder builder = new Builder(activityLinkApps);
        builder.setIcon(R.drawable.email);
        builder.setTitle("E-mail Authentication");
        builder.setMessage("@gmail/@live/@yahoo");
        builder.setInverseBackgroundForced(true);
        EditText editText = (EditText) inflate.findViewById(R.id.username);
        EditText editText2 = (EditText) inflate.findViewById(R.id.password);
        EditText editText3 = (EditText) inflate.findViewById(R.id.signature);
        if (lx.m1373L(activityLinkApps).matches(" ")) {
            editText3.setHint("No signature set");
        } else {
            editText3.setText(Html.fromHtml("Sent by voice from <a href='https://play.google.com/store/apps/details?id=com.brandall.nutter&hl=en'>utter!</a>"));
        }
        builder.setView(inflate);
        builder.setPositiveButton("Validate", new ct(activityLinkApps, editText, editText2, editText3));
        builder.setNegativeButton("Cancel", new cu(activityLinkApps));
        builder.show();
    }

    static /* synthetic */ void m606s(ActivityLinkApps activityLinkApps) {
        ls.m1346c("emailAuth");
        lc.m1313a(activityLinkApps, false, "Please log in to your Google Music account.");
        View inflate = ((LayoutInflater) activityLinkApps.getSystemService("layout_inflater")).inflate(R.layout.music_dialog_layout, (ViewGroup) activityLinkApps.findViewById(R.id.mdl));
        Builder builder = new Builder(activityLinkApps);
        builder.setIcon(R.drawable.playmusic);
        builder.setTitle("Play Music Authentication");
        builder.setInverseBackgroundForced(true);
        EditText editText = (EditText) inflate.findViewById(R.id.usernamem);
        EditText editText2 = (EditText) inflate.findViewById(R.id.passwordm);
        builder.setView(inflate);
        builder.setPositiveButton("Validate", new cv(activityLinkApps, editText, editText2));
        builder.setNegativeButton("Cancel", new cw(activityLinkApps));
        builder.show();
    }

    static /* synthetic */ void m607t(ActivityLinkApps activityLinkApps) {
        ls.m1346c("evernotePlay");
        jy.m1264o(activityLinkApps, "com.evernote");
    }

    static /* synthetic */ void m608u(ActivityLinkApps activityLinkApps) {
        ls.m1346c("catchnotesPlay");
        jy.m1264o(activityLinkApps, "com.threebanana.notes");
    }

    static /* synthetic */ void m609v(ActivityLinkApps activityLinkApps) {
        ls.m1346c("springpadPlay");
        jy.m1264o(activityLinkApps, "com.springpad");
    }

    static /* synthetic */ void m610w(ActivityLinkApps activityLinkApps) {
        ls.m1346c("spotifyPlay");
        jy.m1264o(activityLinkApps, "com.ghisler.android.TotalCommander");
    }

    static /* synthetic */ void m611x(ActivityLinkApps activityLinkApps) {
        ls.m1346c("rootExplorerPlay");
        jy.m1264o(activityLinkApps, "com.speedsoftware.rootexplorer");
    }

    static /* synthetic */ void m612y(ActivityLinkApps activityLinkApps) {
        ls.m1346c("explorerPlay");
        jy.m1264o(activityLinkApps, "com.speedsoftware.explorer");
    }

    static /* synthetic */ void m613z(ActivityLinkApps activityLinkApps) {
        ls.m1346c("solidExplorerPlay");
        jy.m1264o(activityLinkApps, "pl.solidexplorer");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ls.m1346c("Facebook Auth onActivityResult");
        try {
            this.f683a.m303a(i, i2, intent);
        } catch (Exception e) {
            ls.m1347d("onActivityResult LinkApps Facebook");
            e.printStackTrace();
            lc.m1313a(this, false, "Something went wrong with the Facebook authorisation. If this persists, please do feel free to email the developer for help.");
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            ls.m1345b("Landscape");
        } else if (configuration.orientation == 1) {
            ls.m1345b("Portrait");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ls.m1346c("ActivityLinkApps onCreate");
        setContentView(R.layout.linkapps_layout);
        this.f692j = (AdView) findViewById(R.id.adView);
        StrictMode.setThreadPolicy(new ThreadPolicy.Builder().permitAll().build());
        this.f684b = (UITableView) findViewById(R.id.tableView);
        ls.m1346c("ActivityLinkApps createList");
        this.f684b.setClickListener(new cx());
        C0090a c0090a = new C0090a("Dropbox");
        if (jy.m1262m(this, "com.dropbox.android")) {
            c0090a.f297e = "Dropbox is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Dropbox";
        }
        c0090a.f294b = R.drawable.dropbox;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Link Dropbox");
        c0090a.f297e = "tap here to authorise";
        c0090a.f294b = R.drawable.linked;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Facebook");
        if (jy.m1262m(this, "com.facebook.katana")) {
            c0090a.f297e = "Facebook is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Facebook";
        }
        c0090a.f294b = R.drawable.facebook;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Link Facebook");
        c0090a.f297e = "tap here to authorise";
        c0090a.f294b = R.drawable.linked;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Twitter");
        if (jy.m1262m(this, "com.twitter.android")) {
            c0090a.f297e = "Twitter is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Twitter";
        }
        c0090a.f294b = R.drawable.twitter36;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Link Twitter");
        c0090a.f297e = "tap here to authorise";
        c0090a.f294b = R.drawable.linked;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Tasker");
        if (mv.m1491c(this)) {
            this.f691i = true;
            c0090a.f297e = "Tasker is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Tasker";
        }
        c0090a.f294b = R.drawable.tasker;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Link Tasker");
        c0090a.f297e = "tap here to authorise";
        c0090a.f294b = R.drawable.linked;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Foursquare");
        if (jy.m1262m(this, "com.joelapenna.foursquared")) {
            c0090a.f297e = "Foursquare is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Foursquare";
        }
        c0090a.f294b = R.drawable.foursquare;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Link Foursquare");
        c0090a.f297e = "tap here to authorise";
        c0090a.f294b = R.drawable.linked;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Google+");
        if (jy.m1262m(this, "com.google.android.apps.plus")) {
            c0090a.f297e = "Google+ is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Google+";
        }
        c0090a.f294b = R.drawable.gplus36;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Link Google+");
        c0090a.f297e = "tap here to authorise";
        c0090a.f294b = R.drawable.linked;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Drive");
        if (jy.m1262m(this, "com.google.android.apps.docs")) {
            c0090a.f297e = "Drive is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Drive";
        }
        c0090a.f294b = R.drawable.drive;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Link Drive");
        c0090a.f297e = "tap here to authorise";
        c0090a.f294b = R.drawable.linked;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("LinkedIn");
        if (jy.m1262m(this, "com.linkedin.android")) {
            c0090a.f297e = "LinkedIn is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install LinkedIn";
        }
        c0090a.f294b = R.drawable.linkedin;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Link LinkedIn");
        c0090a.f297e = "tap here to authorise";
        c0090a.f294b = R.drawable.linked;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Link Email");
        c0090a.f297e = "tap here to authorise";
        c0090a.f294b = R.drawable.email36;
        if (lx.m1378Q(this).matches("")) {
            c0090a.f295c = R.drawable.cross;
        } else {
            c0090a.f295c = R.drawable.tick;
        }
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Link Play Music");
        c0090a.f297e = "tap here to authorise";
        c0090a.f294b = R.drawable.playmusic;
        if (lx.m1380S(this).matches("")) {
            c0090a.f295c = R.drawable.cross;
        } else {
            c0090a.f295c = R.drawable.tick;
        }
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Evernote");
        if (jy.m1262m(this, "com.evernote")) {
            c0090a.f297e = "Evernote is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Evernote";
        }
        c0090a.f294b = R.drawable.evernote;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Catch Notes");
        if (jy.m1262m(this, "com.threebanana.notes")) {
            c0090a.f297e = "Catch Notes is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Catch Notes";
        }
        c0090a.f294b = R.drawable.catchnotes;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Springpad");
        if (jy.m1262m(this, "com.springpad")) {
            c0090a.f297e = "Springpad is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Springpad";
        }
        c0090a.f294b = R.drawable.springpad;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Total Commander");
        if (jy.m1262m(this, "com.ghisler.android.TotalCommander")) {
            c0090a.f297e = "Total Commander is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Total Commander";
        }
        c0090a.f294b = R.drawable.totalcommander;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Root Explorer");
        if (jy.m1262m(this, "com.speedsoftware.rootexplorer")) {
            c0090a.f297e = "Root Explorer is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Root Explorer";
        }
        c0090a.f294b = R.drawable.rootexplorer;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Explorer");
        if (jy.m1262m(this, "com.speedsoftware.explorer")) {
            c0090a.f297e = "Explorer is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Explorer";
        }
        c0090a.f294b = R.drawable.rootexplorerfree;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Solid Explorer");
        if (jy.m1262m(this, "pl.solidexplorer")) {
            c0090a.f297e = "Solid Explorer is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Solid Explorer";
        }
        c0090a.f294b = R.drawable.solidexplorer;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("File Expert");
        if (jy.m1262m(this, "xcxin.filexpert")) {
            c0090a.f297e = "File Expert is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install File Expert";
        }
        c0090a.f294b = R.drawable.fileexpert;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Wolfram Alpha");
        if (jy.m1262m(this, "com.wolfram.android.alpha")) {
            c0090a.f297e = "Wolfram Alpha is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Wolfram Alpha";
        }
        c0090a.f294b = R.drawable.wolframalpha;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("eBay");
        if (jy.m1262m(this, "com.ebay.mobile")) {
            c0090a.f297e = "eBay is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install eBay";
        }
        c0090a.f294b = R.drawable.ebay;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("IMDb");
        if (jy.m1262m(this, "com.imdb.mobile")) {
            c0090a.f297e = "IMDb is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install IMDb";
        }
        c0090a.f294b = R.drawable.imdb;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Maps");
        if (jy.m1262m(this, "com.google.android.apps.maps")) {
            c0090a.f297e = "Maps is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Maps";
        }
        c0090a.f294b = R.drawable.maps;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Street View");
        if (jy.m1262m(this, "com.google.android.street")) {
            c0090a.f297e = "Street View is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Street View";
        }
        c0090a.f294b = R.drawable.streetview;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Earth");
        if (jy.m1262m(this, "com.google.earth")) {
            c0090a.f297e = "Earth is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Earth";
        }
        c0090a.f294b = R.drawable.earth;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Waze");
        if (jy.m1262m(this, "com.waze")) {
            c0090a.f297e = "Waze is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Waze";
        }
        c0090a.f294b = R.drawable.waze;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Instagram");
        if (jy.m1262m(this, "com.instagram.android")) {
            c0090a.f297e = "Instagram is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Instagram";
        }
        c0090a.f294b = R.drawable.instagram;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Screencast");
        if (jy.m1262m(this, "com.ms.screencastfree") || jy.m1262m(this, "com.ms.screencast")) {
            c0090a.f297e = "Screencast is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Screencast";
        }
        c0090a.f294b = R.drawable.screencast;
        this.f684b.m292a(c0090a);
        c0090a = new C0090a("Spotify");
        if (jy.m1262m(this, "com.spotify.mobile.android.ui")) {
            c0090a.f297e = "Spotify is installed";
            c0090a.f295c = R.drawable.tick;
        } else {
            c0090a.f297e = "Install Spotify";
        }
        c0090a.f294b = R.drawable.spotify;
        this.f684b.m292a(c0090a);
        this.f684b.m291a();
        C0227h a = new C0228a().mo111a("color_bg", "FFFFFF").mo111a("color_link", "000080").mo111a("color_text", "808080").mo111a("color_url", "008000");
        C0237d c0237d = new C0237d();
        if (GlobalV.m887s()) {
            c0237d.m1638a("FAFFD14896DE0B88FCFDD1692625BFAD");
            c0237d.m1638a("CC24C2B6FF78E3A8AD39DD88ECEF74EF");
            c0237d.m1638a("CC24C2B6FF78E4A8AD39DD88ECEF74EF");
            c0237d.m1638a("26F26F9E436091DB6D26BBFDBBC01B01");
        }
        c0237d.m1636a(a);
        this.f692j.m1593a(c0237d);
    }

    public void onDestroy() {
        super.onDestroy();
        ls.m1346c("ActivityLinkApps onDestroy");
        if (this.f692j != null) {
            this.f692j.removeAllViews();
            this.f692j.m1592a();
        }
        getWindow().clearFlags(128);
    }

    public void onPause() {
        super.onPause();
        ls.m1346c("ActivityLinkApps onPause");
    }

    public void onResume() {
        super.onResume();
        ls.m1346c("ActivityLinkApps onResume");
        if (ServiceTTS.f854f) {
            getWindow().addFlags(128);
        }
        if (this.f690h) {
            String stringExtra;
            String stringExtra2;
            boolean z;
            C0199a c0199a;
            Intent intent;
            String stringExtra3;
            this.f689g.m1522a();
            Intent intent2 = AuthActivity.f1855a;
            if (intent2 != null) {
                stringExtra = intent2.getStringExtra("ACCESS_TOKEN");
                stringExtra2 = intent2.getStringExtra("ACCESS_SECRET");
                String stringExtra4 = intent2.getStringExtra("UID");
                if (!(stringExtra == null || stringExtra.equals("") || stringExtra2 == null || stringExtra2.equals("") || stringExtra4 == null || stringExtra4.equals(""))) {
                    z = true;
                    if (z) {
                        ls.m1347d("Dropbox authentication failed");
                        lc.m1313a(this, false, "Drop box authentication failed.");
                        this.f690h = false;
                        return;
                    }
                    ls.m1346c("Dropbox authenticationSuccessful");
                    try {
                        c0199a = (C0199a) this.f689g.m1522a();
                        intent = AuthActivity.f1855a;
                        if (intent != null) {
                            throw new IllegalStateException();
                        }
                        stringExtra2 = intent.getStringExtra("ACCESS_TOKEN");
                        stringExtra3 = intent.getStringExtra("ACCESS_SECRET");
                        stringExtra = intent.getStringExtra("UID");
                        if (stringExtra2 != null || stringExtra2.equals("") || stringExtra3 == null || stringExtra3.equals("") || stringExtra == null || stringExtra.equals("")) {
                            throw new IllegalStateException();
                        }
                        c0199a.f1862b = new C0214k(stringExtra2, stringExtra3);
                        C0214k c0214k = ((C0199a) this.f689g.m1522a()).f1862b;
                        stringExtra = c0214k.a;
                        stringExtra4 = c0214k.b;
                        Editor edit = getSharedPreferences("utterPref", 0).edit();
                        edit.putString("db_token_key", stringExtra);
                        edit.putString("db_token_secret", stringExtra4);
                        edit.commit();
                        lx.ar(this);
                        ls.m1344a("key: " + stringExtra + " :secret: " + stringExtra4);
                        lc.m1313a(this, false, "Drop box authentication successful.");
                        this.f690h = false;
                        return;
                    } catch (IllegalStateException e) {
                        ls.m1348e("Error authenticating Dropbox");
                        e.printStackTrace();
                        this.f690h = false;
                        return;
                    }
                }
            }
            z = false;
            if (z) {
                ls.m1347d("Dropbox authentication failed");
                lc.m1313a(this, false, "Drop box authentication failed.");
                this.f690h = false;
                return;
            }
            ls.m1346c("Dropbox authenticationSuccessful");
            c0199a = (C0199a) this.f689g.m1522a();
            intent = AuthActivity.f1855a;
            if (intent != null) {
                stringExtra2 = intent.getStringExtra("ACCESS_TOKEN");
                stringExtra3 = intent.getStringExtra("ACCESS_SECRET");
                stringExtra = intent.getStringExtra("UID");
                if (stringExtra2 != null) {
                }
                throw new IllegalStateException();
            }
            throw new IllegalStateException();
        }
    }
}
