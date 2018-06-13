package com.brandall.nutter;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import br.com.dina.ui.p010a.C0090a;
import br.com.dina.ui.widget.UITableView;
import com.google.ads.AdView;
import com.google.ads.C0237d;
import com.google.ads.p028a.C0227h;
import com.google.ads.p028a.p029a.C0228a;

public class ActivityCommand extends Activity {
    UITableView f661a;
    private AdView f662b;

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            ls.m1345b("Landscape");
        } else if (configuration.orientation == 1) {
            ls.m1345b("Portrait");
        }
    }

    public void onCreate(Bundle bundle) {
        C0090a c0090a;
        super.onCreate(bundle);
        setContentView(R.layout.command_layout);
        this.f662b = (AdView) findViewById(R.id.adView);
        this.f661a = (UITableView) findViewById(R.id.tableView);
        this.f661a.setClickListener(new an());
        if (!ServiceTTS.f854f) {
            c0090a = new C0090a("Float Command List");
            c0090a.f294b = R.drawable.list;
            c0090a.f297e = "tap to float!";
            this.f661a.m292a(c0090a);
        }
        this.f661a.m292a(new C0090a("Command Key", "• \t\tStart of command\n+ \t\tContinue to say...\n/ \t\tSay only one of\n() \t\tOptional\n~ \t\tInteractive command\n[D] \tDisabled\n[R] \tRoot only"));
        this.f661a.m292a(new C0090a("Set Your Name!", "• Call me\n+ 'your name'"));
        this.f661a.m292a(new C0090a("Cancel Command", "• Cancel\n• Never mind\n• Shush!\n• Cancel cancel [mid-sentence]"));
        this.f661a.m292a(new C0090a("Time", "• What's the time ?\n• What's the time in +'City Country' ?"));
        this.f661a.m292a(new C0090a("Date", "• What's the date ?\n• What date is it?"));
        this.f661a.m292a(new C0090a("Weather", "• What's the weather doing ?\n• What's the weather like in +'City Country' ?"));
        this.f661a.m292a(new C0090a("Texting", "• Text + 'contact name' ~\n\n• Read my last text message"));
        c0090a = new C0090a("Emailing", "• Email + 'contact name' ~");
        c0090a.f293a = false;
        this.f661a.m292a(c0090a);
        this.f661a.m292a(new C0090a("Facebook", "• Facebook status ~"));
        this.f661a.m292a(new C0090a("Twitter", "• Tweet ~"));
        this.f661a.m292a(new C0090a("Foursquare", "• Checkin to +'venue name'"));
        this.f661a.m292a(new C0090a("Battery", "• What is my battery\n+ level\n+ temperature\n+ health\n+ status\n+ voltage"));
        this.f661a.m292a(new C0090a("Contacts", "• Display contact +'contact name'"));
        this.f661a.m292a(new C0090a("Calling", "• Skype +'contact name'\n• Call +'contact name' ~\n\n• Call +'contact name' at/on\n+ home/work/mobile\n\n• Call +'number'\n• Redial\n• Call back"));
        this.f661a.m292a(new C0090a("Music", "• Play +'artist' +'track name'\n• Stream +'track name' [Google Music]\n• Spotify +'track name' [D]"));
        this.f661a.m292a(new C0090a("Applications", "• Open/launch/load +'name of app'\n• Kill +'name of app'\n\n• Which application am I using ?\n• Application settings +'name of app'\n\n• Search for\n+ trending/editor's choice/top paid/top free\n+ top new free/top new paid/featured/top grossing\n+ applications"));
        this.f661a.m292a(new C0090a("WiFi", "• Toggle WiFi\n• Turn/switch on/off WiFi"));
        this.f661a.m292a(new C0090a("Mobile Data", "• Toggle (mobile) data\n• Turn/switch on/off (mobile) data"));
        this.f661a.m292a(new C0090a("Bluetooth", "• Toggle Bluetooth\n• Turn/switch on/off Bluetooth"));
        this.f661a.m292a(new C0090a("Airplane Mode", "• Toggle airplane mode\n• Turn/switch on/off airplane mode"));
        this.f661a.m292a(new C0090a("Navigation", "• Navigate to +'destination'\n• Navigate to contact +'contact name' +(at + home/work)\n• Find my car"));
        c0090a = new C0090a("Calendar", "• Set/create/new (a) appointment/event/calendar entry \n + event details \n + (called + event name)");
        c0090a.f293a = false;
        this.f661a.m292a(c0090a);
        c0090a = new C0090a("Alarms", "• Set (an) alarm/reminder in +'hours minutes' called +'alarm name'");
        c0090a.f293a = false;
        this.f661a.m292a(c0090a);
        this.f661a.m292a(new C0090a("Translate", "• Translate to\n+ German +'phrase'\n+ French +'phrase'\n+ Romanian +'phrase'\n+ Spanish +'phrase'\n+ Italian +'phrase'\n+ Polish +'phrase'"));
        this.f661a.m292a(new C0090a("Web Search", "• Search\n+ Google +'your search term'\n+ Bing +'search term'\n+ Yahoo +'search term'\n+ for images/pictures of +'search term'\n\n• Go to +'website name' dot com/net/etc"));
        this.f661a.m292a(new C0090a("Video Search", "• Search\n+ for videos of +'search term'"));
        this.f661a.m292a(new C0090a("Movie Search", "• Search\n+ for the movie/film +'title'"));
        c0090a = new C0090a("Notes", "• New note\n• New voice note");
        c0090a.f293a = false;
        this.f661a.m292a(c0090a);
        this.f661a.m292a(new C0090a("Volume", "• Set sound profile to\n+ vibrate\n+ silent\n+ normal\n\n• Speak louder\n• Speak maximum\n\n• Speak softer\n• Speak minimum"));
        this.f661a.m292a(new C0090a("Spelling & Meanings", "• Spell +'word'\n• Define +'word' [D]"));
        this.f661a.m292a(new C0090a("Clipboard", "• Read the clipboard\n• Toast the clipboard\n• Remember this + clipboard content"));
        this.f661a.m292a(new C0090a("File Management", "• Browse \n+ directory +'directory name'\n+ subdirectory +'subdirectory name' [slow]"));
        this.f661a.m292a(new C0090a("Screenshot [R]", "• Take a screenshot"));
        this.f661a.m292a(new C0090a("Root Functions [R!]", "• Superuser\n+ reboot\n+ hot reboot\n+ reboot recovery\n+ reboot bootloader\n+ set CPU governor to +'governor name'"));
        this.f661a.m292a(new C0090a("Location Services", "• Where am I? [D]\n• Set this location as +'location profile name' ~ [D]\n\n• I've parked my car\n• Where's my car?"));
        this.f661a.m292a(new C0090a("Password", "• User password ~"));
        this.f661a.m292a(new C0090a("Google Earth", "• Fly to +'location name'"));
        this.f661a.m292a(new C0090a("Tasker", "• Display tasks\n• Run task +'your task name'"));
        this.f661a.m292a(new C0090a("Repeat Utterance", "• Pardon\n• Can you repeat that?\n• Say that again\n• What did you say?"));
        this.f661a.m292a(new C0090a("Shake-To-Wake", "• Enable/Disable shake\n• Set shake to\n+ very low/low/medium/high/very high"));
        this.f661a.m292a(new C0090a("Wave-To-Wake", "• Enable/Disable wave"));
        this.f661a.m292a(new C0090a("Visual Results", "• Enable/Disable visual results\n• Float command list"));
        this.f661a.m292a(new C0090a("Device Settings", "• settings\n• wifi settings\n• bluetooth settings\n• data settings\n• time settings\n• date settings\n• voice search settings\n• tts settings\n• device settings\n• accessibility settings\n• apn settings\n• application settings\n• display settings\n• input settings\n• storage settings\n• locale settings\n• memory/storage/sd card settings\n• network operator settings\n• nfc settings\n• privacy settings\n• quick launch settings\n• search settings\n• sound/volume settings\n• sync settings\n• dictionary settings\n• location settings\n• application settings +'name of app'"));
        this.f661a.m291a();
        C0227h a = new C0228a().mo111a("color_bg", "FFFFFF").mo111a("color_link", "000080").mo111a("color_text", "808080").mo111a("color_url", "008000");
        C0237d c0237d = new C0237d();
        if (GlobalV.m887s()) {
            c0237d.m1638a("FAFFD14896DE0B88FCFDD1692625BFAD");
            c0237d.m1638a("CC24C2B6FF78E3A8AD39DD88ECEF74EF");
            c0237d.m1638a("CC24C2B6FF78E4A8AD39DD88ECEF74EF");
            c0237d.m1638a("26F26F9E436091DB6D26BBFDBBC01B01");
        }
        c0237d.m1636a(a);
        this.f662b.m1593a(c0237d);
    }

    public void onDestroy() {
        super.onDestroy();
        ls.m1346c("AboutCommand onDestroy");
        getWindow().clearFlags(128);
        if (this.f662b != null) {
            this.f662b.removeAllViews();
            this.f662b.m1592a();
        }
        if (!lx.aa(this)) {
            ly.m1460a(this, 12000, false);
        }
    }

    public void onPause() {
        super.onPause();
        ls.m1346c("AboutCommand onPause");
    }

    public void onResume() {
        super.onResume();
        ls.m1346c("AboutCommand onResume");
        if (ServiceTTS.f854f) {
            getWindow().addFlags(128);
        }
    }
}
