package com.brandall.nutter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import br.com.dina.ui.p010a.C0090a;
import br.com.dina.ui.widget.UITableView;
import java.util.ArrayList;

public class ActivityBugs extends Activity {
    UITableView f658a;
    private EditText f659b;
    private Button f660c;

    static /* synthetic */ void m512a(ActivityBugs activityBugs) {
        ls.m1346c("executeString");
        String editable = activityBugs.f659b.getText().toString();
        if (editable != null && editable.length() > 0) {
            ls.m1344a("commandText: " + editable);
            new ArrayList().add(editable);
            if (ServiceTTS.f854f) {
                if (VERSION.SDK_INT >= 11) {
                    new nl(activityBugs).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{r1});
                    return;
                }
                new nl(activityBugs).execute(new ArrayList[]{r1});
            } else if (VERSION.SDK_INT >= 11) {
                new hs(activityBugs).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{r1});
            } else {
                new hs(activityBugs).execute(new ArrayList[]{r1});
            }
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
        setContentView(R.layout.bugs_layout);
        this.f659b = (EditText) findViewById(R.id.input_text);
        this.f659b.setVerticalScrollBarEnabled(true);
        this.f659b.setMaxLines(6);
        this.f660c = (Button) findViewById(R.id.executeButton);
        this.f660c.setOnClickListener(new al(this));
        this.f658a = (UITableView) findViewById(R.id.tableView);
        this.f658a.setClickListener(new am());
        C0090a c0090a = new C0090a("View in browser");
        c0090a.f294b = R.drawable.bugred;
        c0090a.f297e = "tap for web link";
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("Offline doesn't work!?", "\nThis is only available for devices running Jelly Bean at the moment. Please ensure your Google Search application is up to date by checking the Play Store. At the time of print, this was V2.3.11.575405.\n\nYou'll need to make sure that you have downloaded the necessary English language, offline recognition files, in the Android Voice Search settings. Your device may require a reboot, before this works correctly.");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("utter! doesn't speak to me!?", "\nGo to the Android Text to Speech settings and press ‘listen to an example’ if it doesn’t work, switch to another voice engine and test that too. \n\nYou may need to download additional files to get your preferred voice engine to work correctly. If you have recently upgraded your device, the existing files may no longer be compatible, it’s advised to clear them from the external storage, so the download will complete in its entirety again. \n\nOnce you have a voice engine that is working by ‘listening to an example’ open utter! and turn it off and on again with the button at the top. Go to the settings page in utter! and select ‘English Voice Engine’ – choose the same as you just did in the Android settings. \n\nTry launching the recognition again.");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("After utter! has spoken the intro, nothing happens?", "\nPlease follow the steps above to confirm your voice engine is functioning correctly. A small number of Galaxy SIII users report that this does not fix the issue - I'm trying to work out why. \n\nIf all else fails, kill utter! using a task manager.");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("utter! takes ages to start speaking", "\nThis is reported mainly by users of IVONA. It may sound great, but whilst it too is in beta, it can take 15+ seconds to initialise, if it initialises at all! This is also a problem when switching between voice engines during translation.\n\nTry another voice engine and see the difference, it's up to you if you want to put up with the delay...");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("Google Voice Search is returning rubbish in the results", "\nGo to the Play Store and search for Google Voice Search. Uninstall and reinstall the application. If you do not have permissions to do so, then search for a copy of the apk that matches your current version and install it over the top. Always check such side-loaded applications for viruses.");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("utter! uses a lot of device memory!", "\nThe application works as a Service and Android allocates a higher amount of memory for this type of implementation, usually around 20mb. In addition, the application binds to Google Voice Search and a Voice Engine, so you may see the total memory usage as a sum of all three of these applications. However, some users have reported that the memory usage continues to increase and I'm working to try and track this issue down as well as continuously trying to minimise the overall usage.");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("utter! kills my battery!", "\nIf you are using shake-to-wake or wave-to-wake they will be resource intensive, due to monitoring the sensors on your device. Considering switching these off when they are no longer needed. You may notice an initially high level of drain whilst you are configuring and testing commands, which involves recording audio and using your data connection. Once you have set the application up as you wish, you will (hopefully!) notice that it uses minimal resource whilst lying 'dormant' in the background. I'm continually working to try and improve the resource the application uses.");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("utter! said I have a Jelly Bean bug!?", "\nYou may be suffering from a bug in the latest Jelly Bean release, which is also appearing in custom ROMs. Until Google fix the problem, you need to open the Google Voice Search settings and change your default language from English (US) to English (UK).");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("Nothing happens when I open utter!?", "\nutter! does not provide an in-app-experience, instead it is activated in any one of the following ways:\n\n• Shaking the device\n• Long-press-search\n• Clicking the notification\n\nYou can activate utter! anywhere on the device, whilst using any application. Alternatively:\n\n• Launcher shortcut");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("Nothing happens when I activate utter!?", "\nYour speech engine files may be corrupted.\n\nSee above for instructions on how to check your custom voice engine installation. IVONA is known to be troublesome whilst in its beta stage. It often fails to initialise correctly, or take a long time to do so.");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("utter! doesn't recognise my commands!?", "\nThe speech recognition is powered by Google Voice Search. utter! uses advanced algorithms to analyse every sentence and individual word returned to try and piece together what you were asking, but if Google is returning rubbish, then utter! doesn't stand a chance... \n\nYou can view the returned results utter! is receiving by saying ‘enable visual results’ or typing the command in the box at the top of the Troubleshooting Tab. In addition, you can test the accuracy of other Voice Recognition providers in the Recognition & Voices Tab. These providers will be available as separate plugins soon.\n\nYou can create commands from the Customisation Menu, using words and phrases that Google always returns correctly for you. \n\nForgive me, but I'll also have to ask you nicely to check the command list to make sure you are structuring the phrases correctly...\n\nNatural speech recognition will improve over time, but right now the commands are fixed, but configurable.\n\nAlternatively, this is more likely to be a problem with the Google Voice Search application that utter! uses to process its commands. Please read above for the suggested way to resolve this.");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("utter! can't pronounce my name right!", "\nIn the box above you can enter commands manually. Try spelling your name phonetically by entering 'call me +phonetic spelling'.");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("Google Music search returns no results?", "\nThe search giant that is Google does not support searching your music library by album and artist...? Don't believe me? Open your Google Music console on your PC and try it. Ridiculous! \n\nUnfortunately you are left to search by just album or artist, but even then it does not support streaming of the full album, so a random track will be chosen to play. I can only hope Google up their game!");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("Why is there a permanent notification?", "\nutter! runs in the background of your device and if the notification wasn't there, Android doesn't know that it's not supposed to kill it! This may not be such as problem for the latest devices, but certainly on dating hardware Android was killing utter! mid-command! There is an option to remove the notification in the settings, but it may cause problems.");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("utter! is slow at processing commands", "\nThere are two reasons why this could be happening:\n\n• A poor network connection\n\nutter! initially displays a 'listening' notification, which remains in the notification bar until the speech results are returned from the Google Servers. The time between the end of your voice instruction and the notification changing to 'working' is a reflection on your network connection speed.\n\nIf you are using a WiFi network, you should expect the voice results to be returned almost instantaneously after you finish speaking. If this isn't the case for you, please don't hesitate to email me so I can investigate the cause further. *Note* Weather, time, knowledge base and localised queries will use additional network requests to resolve the commands.\n\n• Your device has low hardware specifications\n\nTo avoid potential criticism of the algorithm speed of the application, certain devices and older Android versions really should be excluded as incompatible. I didn't want to do this though... Instead I've chosen to make it open to as many devices as possible and added in this 'disclaimer'!\n\nutter! will work older devices very, very hard, as it relies on pure processing power to run though every eventuality to accurately identify your command. The latest devices, with good hardware (and network speed), should expect utter! to begin its vocal response in under one second after the voice data is received. If this isn't your experience, please do send me an email to help the development and get the application running for you as it should.\n\nDon't forget, rebooting your device can often clear out the cobwebs!");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("The weather/time gets my State wrong", "\nThe weather & time provider I'm using is hopeless.. I'll be changing it to a better one very soon!");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("Wave-to-wake doesn't work?", "\nI made it deliberately difficult to activate this function to prevent it happening by accident. Pass you hand back and forth in a windscreen-wiper motion across the front of your device, about 1cm away from it. Start off quite fast and gradually slow the rhythm down until hopefully you hit the sweet spot! Both wave and shake functions are disabled when the display turns off. A car mode is coming soon.");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("Why are features disabled?", "\nIf only everything that works flawlessly on my device worked as well on others... Did someone mention fragmentation? I certainly didn't...\n\nNow the framework is complete, I can add in feature after feature and I'm sat on plenty of them. They'll be available to test soon. If you can't wait, hit the XDA developers link in the main menu to catch all of the test releases before they make the Play Store.");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("Skype ID's aren't detected?", "\nIn order for utter! to detect the contact's Skype ID, you need to make sure this is held within their contact information. It should be entered under the 'IM' field heading, with the label option set to 'Skype'.");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("Shake gets activated in my pocket!", "\nYou can adjust the sensitivity of this feature by saying:\n\n• Set shake to very low\n• Set shake to low/medium/high/very high\n\nOr alternatively:\n\n• Turn shake off\n\nThat should stop your trousers talking to you!");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("Can I ask utter! any question I like?", "\nNot yet I'm afraid...\n\nSuch knowledge-based responses will rely heavily on Wolfram Alpha. They have asked for $1 for every install of utter! to provide this facility. Whilst utter! is in its testing stages there is unfortunately no funding to cover such costs. Once the application is generating revenue, I hope to include this straight away. ");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("Will utter! be multilingual?", "\nIt will indeed! Once it's functioning to a high standard in English, the translations to other languages will begin.\n\nYou can already configure utter! to use in your native language with a bit or work. Click on ‘user-guide’ in the main menu and follow the link for instructions. Separate language packs will be available to download and install soon, to keep the application size to a minimum.");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        c0090a = new C0090a("Can I do localised searches?", "\nThis feature is ready and sat waiting to be activated... \n\nHowever, some results will of course involve you making a selection and therefore a user-interface is required.\n\n• How can results be displayed when utter! doesn't have a UI!?\n\nA unique solution has been found! It'll be out to test soon...");
        c0090a.f293a = false;
        this.f658a.m292a(c0090a);
        ls.m1344a("CommandList total items: " + this.f658a.m293b());
        this.f658a.m291a();
    }

    public void onDestroy() {
        super.onDestroy();
        ls.m1346c("BugsActivity onDestroy");
        if (ServiceTTS.f854f && GlobalV.m865m() == 99) {
            nl.m1496a((Context) this);
        }
        getWindow().clearFlags(128);
    }

    public void onPause() {
        super.onPause();
        ls.m1346c("BugsActivity onPause");
    }

    public void onResume() {
        super.onResume();
        ls.m1346c("BugsActivity onResume");
        if (ServiceTTS.f854f) {
            getWindow().addFlags(128);
        }
    }
}
