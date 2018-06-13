package com.brandall.nutter;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.speech.RecognitionListener;
import java.util.ArrayList;
import wei.mark.standout.StandOutWindow;

public final class mh implements RecognitionListener {
    final /* synthetic */ ServiceTTS f1710a;

    public mh(ServiceTTS serviceTTS) {
        this.f1710a = serviceTTS;
    }

    public final void onBeginningOfSpeech() {
        if (hc.f1269b) {
            ls.m1346c("Speech starting");
        }
    }

    public final void onBufferReceived(byte[] bArr) {
    }

    public final void onEndOfSpeech() {
        if (hc.f1269b) {
            ls.m1346c("onEndOfSpeech");
        }
        if (ServiceTTS.f861m) {
            if (hc.f1269b) {
                ls.m1344a("onEndOfSpeech wup: true");
            }
            ServiceTTS.m925d();
            return;
        }
        ServiceTTS.f866w = false;
        if (hc.f1269b) {
            ls.m1344a("onEndOfSpeech setting recogs: " + ServiceTTS.f866w);
        }
        ((Vibrator) this.f1710a.getSystemService("vibrator")).vibrate(100);
        this.f1710a.f870A = true;
        new Handler().postDelayed(new mi(this), 1000);
    }

    public final void onError(int i) {
        if (hc.f1269b) {
            ls.m1346c("Error listening for speech: " + i);
        }
        if (GlobalV.ab()) {
            ServiceTTS.m916a(this.f1710a);
        }
        ServiceTTS.f866w = false;
        ServiceTTS.f867x = true;
        GlobalV.m815a();
        switch (i) {
            case 1:
                if (hc.f1269b) {
                    ls.m1348e("Network operation timed out.");
                }
                ServiceTTS.m921b("The network connection timed out.");
                return;
            case 2:
                if (hc.f1269b) {
                    ls.m1348e("Other network related errors.");
                }
                ServiceTTS.m921b("I lost the network connection.");
                return;
            case 3:
                if (hc.f1269b) {
                    ls.m1348e("Audio recoding error.");
                }
                ServiceTTS.m920b();
                ServiceTTS.m921b("The was an audio recording error.");
                return;
            case 4:
                if (hc.f1269b) {
                    ls.m1348e("Server sends error status.");
                }
                ServiceTTS.m921b("There was a speech server error.");
                return;
            case 5:
                if (hc.f1269b) {
                    ls.m1348e("Other client side errors.");
                }
                ServiceTTS.m920b();
                ServiceTTS.m921b("We have network problems.");
                return;
            case 6:
                if (hc.f1269b) {
                    ls.m1348e("No speech input");
                }
                if (ServiceTTS.f861m) {
                    ServiceTTS.f867x = false;
                    ServiceTTS.m931j();
                    return;
                }
                ServiceTTS.m921b("I didn't hear any speech?");
                return;
            case 7:
                if (hc.f1269b) {
                    ls.m1348e("No recognition result matched.");
                }
                if (ServiceTTS.f843B) {
                    if (hc.f1269b) {
                        ls.m1346c("userStop: " + ServiceTTS.f843B);
                    }
                    ServiceTTS.f843B = false;
                    ServiceTTS.m921b("Cancelled");
                    return;
                }
                if (hc.f1269b) {
                    ls.m1346c("userStop: " + ServiceTTS.f843B);
                }
                if (ServiceTTS.f861m) {
                    ServiceTTS.f867x = false;
                    ServiceTTS.m931j();
                    return;
                }
                ServiceTTS.m921b("Sorry, but I didn't hear anything.");
                return;
            case 8:
                if (hc.f1269b) {
                    ls.m1348e("RecognitionService busy.");
                }
                ServiceTTS.m920b();
                ServiceTTS.m914a(ServiceTTS.f849a, "The recogniser is busy, please wait...");
                return;
            case 9:
                if (hc.f1269b) {
                    ls.m1348e("Insufficient permissions");
                }
                ServiceTTS.m921b("I got a perculiar permissions error");
                return;
            default:
                if (hc.f1269b) {
                    ls.m1348e("Unknown error.");
                }
                ServiceTTS.m920b();
                ServiceTTS.m921b("An unknown error occurred");
                return;
        }
    }

    public final void onEvent(int i, Bundle bundle) {
        if (hc.f1269b) {
            ls.m1346c("onEvent");
        }
    }

    public final void onPartialResults(Bundle bundle) {
        if (ServiceTTS.f861m) {
            if (hc.f1269b) {
                ls.m1345b("onPartialResults");
            }
            if (bundle != null) {
                if (bundle.containsKey("com.google.android.voicesearch.UNSUPPORTED_PARTIAL_RESULTS")) {
                    for (String str : bundle.getStringArray("com.google.android.voicesearch.UNSUPPORTED_PARTIAL_RESULTS")) {
                        if (hc.f1269b) {
                            ls.m1345b("res: " + str);
                        }
                        if (str.contains("wake up")) {
                            ServiceTTS.f864s.stopListening();
                            ServiceTTS.m920b();
                            ServiceTTS.f866w = false;
                            ((Vibrator) this.f1710a.getSystemService("vibrator")).vibrate(70);
                            ServiceTTS.m918a("I'm awake. How can I help?");
                        }
                    }
                } else if (hc.f1269b) {
                    ls.m1347d("partialResults don't contain key");
                }
            } else if (hc.f1269b) {
                ls.m1347d("partialResults null");
            }
        }
    }

    public final void onReadyForSpeech(Bundle bundle) {
        if (hc.f1269b) {
            ls.m1346c("Ready for speech");
        }
        if (ServiceTTS.f861m) {
            nm.m1502f(ServiceTTS.f849a);
        }
        if (!ServiceTTS.f847F) {
            if (VERSION.SDK_INT < 16) {
                ((Vibrator) this.f1710a.getSystemService("vibrator")).vibrate(70);
            }
            ServiceTTS.f866w = true;
            if (hc.f1269b) {
                ls.m1344a("onReadyForSpeech setting recogs: " + ServiceTTS.f866w);
            }
            String str = "I'm listening...";
            String str2 = "utter!";
            String str3 = "is listening...";
            if (hc.f1269b) {
                ls.m1346c("getRootNotCond: " + GlobalV.aG());
            }
            if (GlobalV.aG()) {
                String aB = GlobalV.aB();
                if (hc.f1269b) {
                    ls.m1346c("shellCommand: " + aB);
                }
                if (aB.matches("rootReboot")) {
                    str = "utter! - reboot";
                } else if (aB.matches("rootRecovery")) {
                    str = "utter! - reboot recovery";
                } else if (aB.matches("rootBootloader")) {
                    str = "utter! - reboot bootloader";
                } else if (aB.matches("rootHot")) {
                    str = "utter! - hot reboot";
                } else if (aB.matches("rootGovernor")) {
                    str = "utter! - " + GlobalV.ak() + " governor";
                }
                GlobalV.m790C(false);
            }
            lt.m1352a(this.f1710a.getApplicationContext(), str, str2, str3, 17301668, false, 0, 1);
        } else if (hc.f1269b) {
            ls.m1345b("onReadyForSpeech wupNotification: true");
        }
    }

    public final void onResults(Bundle bundle) {
        this.f1710a.f870A = false;
        ArrayList arrayList = new ArrayList();
        if (ServiceTTS.f861m) {
            if (hc.f1269b) {
                ls.m1347d("onResults wup: true - resetting");
            }
            arrayList = bundle.getStringArrayList("results_recognition");
            if (arrayList == null || arrayList.isEmpty()) {
                if (hc.f1269b) {
                    ls.m1347d("heardVoice null or empty: ");
                }
            } else if (hc.f1269b) {
                ls.m1344a("heardVoice size: " + arrayList.size() + " : " + arrayList.toString());
            }
            ServiceTTS.m931j();
            return;
        }
        if (hc.f1269b) {
            ls.m1346c("RESULTS_RECOGNITION != null");
        }
        Context context = ServiceTTS.f849a;
        lt.m1352a(context, "Computing...", "utter!", "is computing...", 17301599, false, 0, 1);
        arrayList = bundle.getStringArrayList("results_recognition");
        if (arrayList != null) {
            if (hc.f1269b) {
                ls.m1346c("heardVoice != null");
            }
            if (arrayList.size() > 0) {
                if (hc.f1269b) {
                    ls.m1344a("heardVoice size: " + arrayList.size());
                }
                GlobalV.m823b(arrayList);
                boolean aa = lx.aa(this.f1710a);
                if (aa) {
                    if (hc.f1269b) {
                        ls.m1346c("visualSet: " + aa);
                    }
                    StandOutWindow.m741a(this.f1710a.getApplicationContext(), VoiceResultsWindow.class, 0);
                }
                if (hc.f1269b) {
                    ls.m1344a("heardVoice: " + arrayList.toString());
                }
                if (GlobalV.ab()) {
                    if (hc.f1269b) {
                        ls.m1346c("onResults - createCond: " + GlobalV.ab());
                    }
                    if (VERSION.SDK_INT >= 11) {
                        new gx(this.f1710a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{arrayList});
                    } else {
                        new gx(this.f1710a).execute(new ArrayList[]{arrayList});
                    }
                } else if (GlobalV.ad()) {
                    if (hc.f1269b) {
                        ls.m1346c("onResults - JokeCond: true");
                    }
                    if (VERSION.SDK_INT >= 11) {
                        new jz(this.f1710a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{arrayList});
                    } else {
                        new jz(this.f1710a).execute(new ArrayList[]{arrayList});
                    }
                } else if (GlobalV.al()) {
                    if (hc.f1269b) {
                        ls.m1346c("onResults - ResponseCond: " + GlobalV.al());
                    }
                    if (VERSION.SDK_INT >= 11) {
                        new iv(this.f1710a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{arrayList});
                    } else {
                        new iv(this.f1710a).execute(new ArrayList[]{arrayList});
                    }
                } else if (GlobalV.m881q()) {
                    GlobalV.m839f(false);
                    StandOutWindow.m741a(this.f1710a.getApplicationContext(), VoiceResultsWindow.class, 0);
                    lt.m1349a(1);
                } else if (ServiceTTS.f854f) {
                    if (hc.f1269b) {
                        ls.m1346c("tutorial: true");
                    }
                    GlobalV.m833e(GlobalV.m865m() + 1);
                    if (VERSION.SDK_INT >= 11) {
                        new nl(ServiceTTS.f849a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{arrayList});
                    } else {
                        new nl(ServiceTTS.f849a).execute(new ArrayList[]{arrayList});
                    }
                } else if (VERSION.SDK_INT >= 11) {
                    new hs(this.f1710a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList[]{arrayList});
                } else {
                    new hs(this.f1710a).execute(new ArrayList[]{arrayList});
                }
            } else if (hc.f1269b) {
                ls.m1347d("heardVoice size: " + arrayList.size());
            }
        } else {
            if (hc.f1269b) {
                ls.m1347d("heardVoice == null");
            }
            if (ServiceTTS.f854f) {
                nl.m1496a(ServiceTTS.f849a);
            }
            lt.m1349a(1);
            GlobalV.m815a();
            Intent intent = new Intent(this.f1710a, ActivityBugs.class);
            intent.setFlags(268435456);
            this.f1710a.startActivity(intent);
            ServiceTTS.m921b("You appear to be affected by a known Android bug. Please read the second entry down and adjust your default Google Voice Search language. ");
        }
        if (hc.f1269b) {
            ls.m1346c("CONFIDENCE_SCORES != null");
        }
    }

    public final void onRmsChanged(float f) {
    }
}
