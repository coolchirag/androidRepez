package com.brandall.nutter;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

final class mf extends BroadcastReceiver {
    final /* synthetic */ ServiceTTS f1709a;

    mf(ServiceTTS serviceTTS) {
        this.f1709a = serviceTTS;
    }

    @SuppressLint({"NewApi"})
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null) {
            if (hc.f1269b) {
                ls.m1344a(intent.getAction());
            }
            boolean al = lx.al(this.f1709a);
            boolean am = lx.am(this.f1709a);
            boolean aa = lx.aa(this.f1709a);
            if (intent.getAction().equals("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE")) {
                if (hc.f1269b) {
                    ls.m1346c("ACTION_EXTERNAL_APPLICATIONS_AVAILABLE");
                }
                if (VERSION.SDK_INT >= 11) {
                    new kv(context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } else {
                    new kv(context).execute(new Void[0]);
                }
            } else if (intent.getAction().equals("android.intent.action.VOICE_COMMAND")) {
                if (hc.f1269b) {
                    ls.m1346c("ACTION_VOICE_COMMAND");
                }
            } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                if (hc.f1269b) {
                    ls.m1346c("ACTION_SCREEN_ON");
                }
                if (al) {
                    if (hc.f1269b) {
                        ls.m1346c("shakeSet: true : started");
                    }
                    try {
                        context.startService(new Intent(context, ServiceShakeEvent.class));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (hc.f1269b) {
                    ls.m1346c("shakeSet: false : no action");
                }
                if (am) {
                    if (hc.f1269b) {
                        ls.m1346c("waveSet: true: started");
                    }
                    try {
                        context.startService(new Intent(context, ServiceWaveEvent.class));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (hc.f1269b) {
                    ls.m1346c("waveSet: false : no action");
                }
                if (aa) {
                    if (hc.f1269b) {
                        ls.m1346c("visual: true: started");
                    }
                    ly.m1460a(context, 13000, true);
                } else if (hc.f1269b) {
                    ls.m1346c("visual: false : no action");
                }
            } else if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                if (hc.f1269b) {
                    ls.m1346c("ACTION_SCREEN_OFF");
                }
                if (al) {
                    if (hc.f1269b) {
                        ls.m1346c("shakeSet: true : stopping");
                    }
                    try {
                        if (hc.f1269b) {
                            ls.m1346c("Shutting down SSE");
                        }
                        context.stopService(new Intent(context, ServiceShakeEvent.class));
                    } catch (Exception e22) {
                        if (hc.f1269b) {
                            ls.m1348e("Shutting down SSE failed!");
                        }
                        e22.printStackTrace();
                    }
                } else if (hc.f1269b) {
                    ls.m1346c("shakeSet: false : no action");
                }
                if (am) {
                    if (hc.f1269b) {
                        ls.m1346c("waveSet: true: stopping");
                    }
                    try {
                        if (hc.f1269b) {
                            ls.m1346c("Shutting down SWE");
                        }
                        context.stopService(new Intent(context, ServiceWaveEvent.class));
                    } catch (Exception e222) {
                        if (hc.f1269b) {
                            ls.m1348e("Shutting down SWE failed!");
                        }
                        e222.printStackTrace();
                    }
                } else if (hc.f1269b) {
                    ls.m1346c("waveSet: false : no action");
                }
                if (aa) {
                    if (hc.f1269b) {
                        ls.m1346c("visual: true: stopping");
                    }
                    try {
                        if (hc.f1269b) {
                            ls.m1346c("Shutting down visual");
                        }
                        ly.m1460a(context, 13000, false);
                    } catch (Exception e2222) {
                        if (hc.f1269b) {
                            ls.m1348e("Shutting down visual failed!");
                        }
                        e2222.printStackTrace();
                    }
                } else if (hc.f1269b) {
                    ls.m1346c("visual: false : no action");
                }
            } else if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
                if (hc.f1269b) {
                    ls.m1346c("SMS_RECEIVED");
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    Object[] objArr = (Object[]) extras.get("pdus");
                    SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
                    for (int i = 0; i < objArr.length; i++) {
                        smsMessageArr[i] = SmsMessage.createFromPdu((byte[]) objArr[i]);
                    }
                    if (smsMessageArr.length >= 0) {
                        if (hc.f1269b) {
                            ls.m1344a("sender: " + smsMessageArr[0].getOriginatingAddress());
                            ls.m1344a("body: " + smsMessageArr[0].getMessageBody());
                            ls.m1344a("timestamp: " + smsMessageArr[0].getTimestampMillis());
                        }
                        if (lx.m1387Z(this.f1709a) && !lx.m1384W(this.f1709a) && lx.m1376O(this.f1709a)) {
                            if (smsMessageArr[0].getMessageBody().toLowerCase(Locale.US).startsWith(new StringBuilder(String.valueOf(lx.m1385X(this.f1709a))).append("_utter").toString())) {
                                String str;
                                Location a;
                                double latitude;
                                double[] dArr;
                                if (hc.f1269b) {
                                    ls.m1346c("Password Confirmed - received a text message - aborting broadcast");
                                }
                                abortBroadcast();
                                String toLowerCase = smsMessageArr[0].getMessageBody().toLowerCase(Locale.US);
                                String originatingAddress = smsMessageArr[0].getOriginatingAddress();
                                ls.m1346c("RemoteSMS remoteControl");
                                ls.m1344a("remoteControl: smsBody: " + toLowerCase);
                                ls.m1344a("remoteControl: smsOriginator: " + originatingAddress);
                                String str2 = "";
                                String X = lx.m1385X(context);
                                if (toLowerCase.contains("email_")) {
                                    if (toLowerCase.endsWith("email_")) {
                                        aa = false;
                                        str = str2;
                                        str2 = toLowerCase.replaceFirst("email_", "").trim();
                                        toLowerCase = str;
                                    } else {
                                        String[] split = toLowerCase.split("email_");
                                        if (split.length > 1) {
                                            str2 = split[1];
                                            toLowerCase = toLowerCase.replaceFirst("email_" + str2, "").trim();
                                            if (lx.m1379R(context) && str2.contains("@")) {
                                                aa = true;
                                                str = str2;
                                                str2 = toLowerCase;
                                                toLowerCase = str;
                                            }
                                        } else {
                                            aa = false;
                                            str = str2;
                                            str2 = toLowerCase.replaceFirst("email_", "").trim();
                                            toLowerCase = str;
                                        }
                                    }
                                    if (str2.startsWith(new StringBuilder(String.valueOf(X)).append("_utter_do ").toString())) {
                                        ls.m1344a("smsBody: _utter_do command ");
                                        str2 = str2.replaceFirst(new StringBuilder(String.valueOf(X)).append("_utter_do ").toString(), "");
                                        new ArrayList().add(str2);
                                        new hs(context).execute(new ArrayList[]{r1});
                                        return;
                                    } else if (str2.startsWith(new StringBuilder(String.valueOf(X)).append("_utter_say ").toString())) {
                                        ls.m1344a("smsBody: _utter_say command ");
                                        lc.m1313a(context, false, str2.replaceFirst(new StringBuilder(String.valueOf(X)).append("_utter_say ").toString(), ""));
                                        return;
                                    } else if (str2.startsWith(new StringBuilder(String.valueOf(X)).append("_utter_where_are_you").toString())) {
                                        ls.m1344a("smsBody: utter_where_are_you command ");
                                        a = ik.m1175a(context);
                                        if (a == null) {
                                            ls.m1346c("RemoteSMS: Got GPS Fix");
                                            latitude = a.getLatitude();
                                            str2 = "https://maps.google.com/maps?z=17&t=m&q=loc:" + latitude + "+" + a.getLongitude();
                                            if (aa) {
                                                kh.m1293a(originatingAddress, str2);
                                                return;
                                            }
                                            new kd(context).execute(new String[]{toLowerCase, str2});
                                            return;
                                        }
                                        ls.m1346c("RemoteSMS: GPS Fix failed: Getting last known");
                                        dArr = null;
                                        try {
                                            dArr = ik.m1176b(context);
                                        } catch (Exception e3) {
                                            ls.m1348e("gps Exception: ");
                                            if (aa) {
                                                new kd(context).execute(new String[]{toLowerCase, "I'm afraid I coudn't get a location fix."});
                                            } else {
                                                kh.m1293a(originatingAddress, "I'm afraid I coudn't get a location fix.");
                                            }
                                        }
                                        if (dArr != null && dArr.length > 0) {
                                            X = String.valueOf(dArr[0]);
                                            str2 = "https://maps.google.com/maps?z=17&t=m&q=loc:" + X + "+" + String.valueOf(dArr[1]);
                                            if (aa) {
                                                new kd(context).execute(new String[]{toLowerCase, "Last known location: " + str2});
                                                return;
                                            }
                                            kh.m1293a(originatingAddress, "Last known location: " + str2);
                                            return;
                                        }
                                        return;
                                    } else if (str2.startsWith(new StringBuilder(String.valueOf(X)).append("_utter_shell ").toString())) {
                                        ls.m1344a("smsBody: utter shell command ");
                                        str2 = str2.replaceFirst(new StringBuilder(String.valueOf(X)).append("_utter_shell ").toString(), "");
                                        ls.m1344a("smsAction: " + str2);
                                        GlobalV.m786B(str2);
                                        try {
                                            if (((Boolean) new kf(context).execute(new String[]{"remote"}).get()).booleanValue()) {
                                                str2 = GlobalV.m796I();
                                                ls.m1344a("shellOutput: " + str2.length() + " : " + str2);
                                                if (aa) {
                                                    kh.m1293a(originatingAddress, str2);
                                                    return;
                                                }
                                                new kd(context).execute(new String[]{toLowerCase, str2});
                                                return;
                                            } else if (aa) {
                                                kh.m1293a(originatingAddress, "Shell command failed");
                                                return;
                                            } else {
                                                new kd(context).execute(new String[]{toLowerCase, "Shell command failed"});
                                                return;
                                            }
                                        } catch (InterruptedException e4) {
                                            e4.printStackTrace();
                                            kh.m1293a(originatingAddress, "Shell command failed");
                                            return;
                                        } catch (ExecutionException e5) {
                                            e5.printStackTrace();
                                            kh.m1293a(originatingAddress, "Shell command failed");
                                            return;
                                        }
                                    } else if (aa) {
                                        kh.m1293a(originatingAddress, "I didn't understand that instruction!?");
                                        return;
                                    } else {
                                        new kd(context).execute(new String[]{toLowerCase, "I didn't understand that instruction!?"});
                                        return;
                                    }
                                }
                                aa = false;
                                str = str2;
                                str2 = toLowerCase;
                                toLowerCase = str;
                                if (str2.startsWith(new StringBuilder(String.valueOf(X)).append("_utter_do ").toString())) {
                                    ls.m1344a("smsBody: _utter_do command ");
                                    str2 = str2.replaceFirst(new StringBuilder(String.valueOf(X)).append("_utter_do ").toString(), "");
                                    new ArrayList().add(str2);
                                    new hs(context).execute(new ArrayList[]{r1});
                                    return;
                                } else if (str2.startsWith(new StringBuilder(String.valueOf(X)).append("_utter_say ").toString())) {
                                    ls.m1344a("smsBody: _utter_say command ");
                                    lc.m1313a(context, false, str2.replaceFirst(new StringBuilder(String.valueOf(X)).append("_utter_say ").toString(), ""));
                                    return;
                                } else if (str2.startsWith(new StringBuilder(String.valueOf(X)).append("_utter_where_are_you").toString())) {
                                    ls.m1344a("smsBody: utter_where_are_you command ");
                                    a = ik.m1175a(context);
                                    if (a == null) {
                                        ls.m1346c("RemoteSMS: GPS Fix failed: Getting last known");
                                        dArr = null;
                                        dArr = ik.m1176b(context);
                                        if (dArr != null) {
                                            return;
                                        }
                                        return;
                                    }
                                    ls.m1346c("RemoteSMS: Got GPS Fix");
                                    latitude = a.getLatitude();
                                    str2 = "https://maps.google.com/maps?z=17&t=m&q=loc:" + latitude + "+" + a.getLongitude();
                                    if (aa) {
                                        kh.m1293a(originatingAddress, str2);
                                        return;
                                    }
                                    new kd(context).execute(new String[]{toLowerCase, str2});
                                    return;
                                } else if (str2.startsWith(new StringBuilder(String.valueOf(X)).append("_utter_shell ").toString())) {
                                    ls.m1344a("smsBody: utter shell command ");
                                    str2 = str2.replaceFirst(new StringBuilder(String.valueOf(X)).append("_utter_shell ").toString(), "");
                                    ls.m1344a("smsAction: " + str2);
                                    GlobalV.m786B(str2);
                                    if (((Boolean) new kf(context).execute(new String[]{"remote"}).get()).booleanValue()) {
                                        str2 = GlobalV.m796I();
                                        ls.m1344a("shellOutput: " + str2.length() + " : " + str2);
                                        if (aa) {
                                            kh.m1293a(originatingAddress, str2);
                                            return;
                                        }
                                        new kd(context).execute(new String[]{toLowerCase, str2});
                                        return;
                                    } else if (aa) {
                                        kh.m1293a(originatingAddress, "Shell command failed");
                                        return;
                                    } else {
                                        new kd(context).execute(new String[]{toLowerCase, "Shell command failed"});
                                        return;
                                    }
                                } else if (aa) {
                                    kh.m1293a(originatingAddress, "I didn't understand that instruction!?");
                                    return;
                                } else {
                                    new kd(context).execute(new String[]{toLowerCase, "I didn't understand that instruction!?"});
                                    return;
                                }
                            }
                            if (hc.f1269b) {
                                ls.m1346c("No password match - releasing");
                            }
                            lw.m1361a(context, smsMessageArr[0].getMessageBody().toLowerCase(Locale.US), smsMessageArr[0].getOriginatingAddress());
                            return;
                        }
                        if (hc.f1269b) {
                            ls.m1346c("releasing sms due to SPH");
                        }
                        lw.m1361a(context, smsMessageArr[0].getMessageBody().toLowerCase(Locale.US), smsMessageArr[0].getOriginatingAddress());
                    }
                }
            } else if (intent.getAction().equals("android.intent.action.MEDIA_BUTTON") && GlobalV.m802O()) {
                abortBroadcast();
                KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                if (keyEvent.getAction() == 0) {
                    if (hc.f1269b) {
                        ls.m1346c("ACTION_DOWN");
                    }
                    if (keyEvent.isLongPress() && hc.f1269b) {
                        ls.m1346c("isLongPress");
                    }
                } else if (keyEvent.getAction() == 1) {
                    if (hc.f1269b) {
                        ls.m1346c("ACTION_UP");
                    }
                } else if (keyEvent.getAction() == 2 && hc.f1269b) {
                    ls.m1346c("ACTION_MULTIPLE");
                }
                if (keyEvent != null) {
                    int keyCode = keyEvent.getKeyCode();
                    switch (keyCode) {
                        case 79:
                            if (hc.f1269b) {
                                ls.m1346c("KEYCODE_HEADSETHOOK");
                                return;
                            }
                            return;
                        case 85:
                            if (hc.f1269b) {
                                ls.m1346c("KEYCODE_MEDIA_PLAY_PAUSE");
                                return;
                            }
                            return;
                        case 86:
                            if (hc.f1269b) {
                                ls.m1346c("KEYCODE_MEDIA_STOP");
                                return;
                            }
                            return;
                        case 87:
                            if (hc.f1269b) {
                                ls.m1346c("KEYCODE_MEDIA_NEXT");
                                return;
                            }
                            return;
                        case 88:
                            if (hc.f1269b) {
                                ls.m1346c("KEYCODE_MEDIA_PREVIOUS");
                                return;
                            }
                            return;
                        case 126:
                            if (hc.f1269b) {
                                ls.m1346c("KEYCODE_MEDIA_PLAY");
                                return;
                            }
                            return;
                        case 127:
                            if (hc.f1269b) {
                                ls.m1346c("KEYCODE_MEDIA_PAUSE");
                                return;
                            }
                            return;
                        case 187:
                            if (hc.f1269b) {
                                ls.m1346c("KEYCODE_APP_SWITCH");
                                return;
                            }
                            return;
                        default:
                            if (hc.f1269b) {
                                ls.m1346c("STTS key default: " + KeyEvent.keyCodeToString(keyCode));
                                return;
                            }
                            return;
                    }
                }
            }
        }
    }
}
