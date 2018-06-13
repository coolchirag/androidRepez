package com.brandall.nutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class cm implements OnClickListener {
    final /* synthetic */ ActivityHome f1015a;

    cm(ActivityHome activityHome) {
        this.f1015a = activityHome;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (!ServiceTTS.f854f) {
            if (hc.f1270c) {
                switch (i) {
                    case 0:
                        jy.m1274y(this.f1015a, "errorredirect.asp?id=" + lx.m1450s(this.f1015a) + "&page=ug_basic_usage");
                        return;
                    case 1:
                        jy.m1274y(this.f1015a, "errorredirect.asp?id=" + lx.m1450s(this.f1015a) + "&page=ug_create_commands");
                        return;
                    case 2:
                        jy.m1274y(this.f1015a, "errorredirect.asp?id=" + lx.m1450s(this.f1015a) + "&page=ug_translation");
                        return;
                    case 3:
                        jy.m1274y(this.f1015a, "errorredirect.asp?id=" + lx.m1450s(this.f1015a) + "&page=ug_word_replace");
                        return;
                    case 4:
                        jy.m1274y(this.f1015a, "errorredirect.asp?id=" + lx.m1450s(this.f1015a) + "&page=ug_sound_effects");
                        return;
                    case 5:
                        jy.m1274y(this.f1015a, "errorredirect.asp?id=" + lx.m1450s(this.f1015a) + "&page=ug_remote_control");
                        return;
                    case 6:
                        jy.m1274y(this.f1015a, "errorredirect.asp?id=" + lx.m1450s(this.f1015a) + "&page=ug_tasker_guide");
                        return;
                    case 7:
                        jy.m1274y(this.f1015a, "errorredirect.asp?id=" + lx.m1450s(this.f1015a) + "&page=ug_troubleshooting");
                        return;
                    case 8:
                        jy.m1274y(this.f1015a, "errorredirect.asp?id=" + lx.m1450s(this.f1015a) + "&page=ug_known_bugs");
                        return;
                    case 9:
                        jy.m1274y(this.f1015a, "errorredirect.asp?id=" + lx.m1450s(this.f1015a) + "&page=ug_download_icons");
                        return;
                    case 10:
                        jy.m1274y(this.f1015a, "errorredirect.asp?id=" + lx.m1450s(this.f1015a) + "&page=ug_coming_soon");
                        return;
                    default:
                        return;
                }
            }
            switch (i) {
                case 0:
                    jy.m1274y(this.f1015a, "http://forum.xda-developers.com/showpost.php?p=26804173&postcount=1043");
                    return;
                case 1:
                    jy.m1274y(this.f1015a, "http://forum.xda-developers.com/showpost.php?p=26883467&postcount=1050");
                    return;
                case 2:
                    jy.m1274y(this.f1015a, "http://forum.xda-developers.com/showpost.php?p=33876779&postcount=2041");
                    return;
                case 3:
                    jy.m1274y(this.f1015a, "http://forum.xda-developers.com/showpost.php?p=33882082&postcount=2047");
                    return;
                case 4:
                    jy.m1274y(this.f1015a, "http://forum.xda-developers.com/showpost.php?p=33877549&postcount=2042");
                    return;
                case 5:
                    jy.m1274y(this.f1015a, "http://forum.xda-developers.com/showpost.php?p=33882309&postcount=2049");
                    return;
                case 6:
                    jy.m1274y(this.f1015a, "http://forum.xda-developers.com/showpost.php?p=34339449&postcount=2155");
                    return;
                case 7:
                    jy.m1274y(this.f1015a, "http://forum.xda-developers.com/showpost.php?p=25228934&postcount=659");
                    return;
                case 8:
                    jy.m1274y(this.f1015a, "http://forum.xda-developers.com/showpost.php?p=25664421&postcount=753");
                    return;
                case 9:
                    jy.m1274y(this.f1015a, "http://theahrt.com/uttericons.html");
                    return;
                case 10:
                    jy.m1274y(this.f1015a, "http://forum.xda-developers.com/showpost.php?p=25666528&postcount=755");
                    return;
                default:
                    return;
            }
        }
    }
}
