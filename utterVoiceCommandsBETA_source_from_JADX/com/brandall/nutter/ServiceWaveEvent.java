package com.brandall.nutter;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.os.Vibrator;
import wei.mark.standout.StandOutWindow;

public class ServiceWaveEvent extends Service implements SensorEventListener {
    private static long f877b = 0;
    private static long f878c = 0;
    private static long f879d = 0;
    private static int f880e = 0;
    private SensorManager f881a;
    private int f882f = 120;
    private int f883g = 300;
    private int f884h = 600;
    private boolean f885i = false;

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (hc.f1269b) {
            ls.m1346c("SWE onCreate");
        }
    }

    public void onDestroy() {
        if (hc.f1269b) {
            ls.m1346c("SWE onDestroy");
        }
        try {
            this.f881a.unregisterListener(this);
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1348e("SWE mSensorManager unregister");
            }
            e.printStackTrace();
        }
        stopSelf();
        super.onDestroy();
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (hc.f1269b) {
            ls.m1346c("SWE onSensorChanged");
        }
        this.f885i = false;
        if (sensorEvent.values[0] == 0.0f) {
            if (hc.f1269b) {
                ls.m1346c("waveStart: true: " + String.valueOf(sensorEvent.values[0]));
            }
            this.f885i = true;
        } else {
            if (hc.f1269b) {
                ls.m1347d("waveStart: false: " + String.valueOf(sensorEvent.values[0]));
            }
            this.f885i = false;
        }
        long currentTimeMillis;
        switch (f880e) {
            case 0:
                if (hc.f1269b) {
                    ls.m1346c("WaveStage: 0");
                }
                if (this.f885i) {
                    f878c = System.currentTimeMillis();
                    f880e = 1;
                    return;
                }
                return;
            case 1:
                if (hc.f1269b) {
                    ls.m1346c("WaveStage: 1");
                }
                currentTimeMillis = System.currentTimeMillis();
                f877b = currentTimeMillis;
                f879d = currentTimeMillis - f878c;
                if (hc.f1269b) {
                    ls.m1344a("WS1: now - then = " + f879d);
                }
                if (f879d < ((long) this.f882f)) {
                    if (hc.f1269b) {
                        ls.m1346c("WS1 wave < " + this.f882f);
                    }
                    f880e = 2;
                    f878c = System.currentTimeMillis();
                    return;
                }
                if (hc.f1269b) {
                    ls.m1347d("WS1 wave > " + this.f882f);
                }
                f880e = 0;
                return;
            case 2:
                if (hc.f1269b) {
                    ls.m1346c("WaveStage: 2");
                }
                currentTimeMillis = System.currentTimeMillis();
                f877b = currentTimeMillis;
                f879d = currentTimeMillis - f878c;
                if (hc.f1269b) {
                    ls.m1344a("WS2: now - then = " + f879d);
                }
                if (f879d <= ((long) this.f883g) || f879d >= ((long) this.f884h)) {
                    if (hc.f1269b) {
                        ls.m1347d("WS2 wave < " + this.f883g + " or wave > " + this.f884h);
                    }
                    f880e = 0;
                    return;
                }
                if (hc.f1269b) {
                    ls.m1346c("WS2 wave > " + this.f883g + " && wave < " + this.f884h);
                }
                f880e = 3;
                f878c = System.currentTimeMillis();
                return;
            case 3:
                if (hc.f1269b) {
                    ls.m1346c("WaveStage: 3");
                }
                currentTimeMillis = System.currentTimeMillis();
                f877b = currentTimeMillis;
                f879d = currentTimeMillis - f878c;
                if (hc.f1269b) {
                    ls.m1344a("WS3: now - then = " + f879d);
                }
                if (f879d < ((long) this.f882f)) {
                    if (hc.f1269b) {
                        ls.m1346c("WS3 wave < " + this.f882f);
                    }
                    f880e = 4;
                    f878c = System.currentTimeMillis();
                    return;
                }
                if (hc.f1269b) {
                    ls.m1347d("WS3 wave > " + this.f882f);
                }
                f880e = 0;
                return;
            case 4:
                if (hc.f1269b) {
                    ls.m1346c("WaveStage: 4");
                }
                currentTimeMillis = System.currentTimeMillis();
                f877b = currentTimeMillis;
                f879d = currentTimeMillis - f878c;
                if (hc.f1269b) {
                    ls.m1344a("WS4: now - then = " + f879d);
                }
                if (f879d <= ((long) this.f883g) || f879d >= ((long) this.f884h)) {
                    if (hc.f1269b) {
                        ls.m1347d("WS4 wave < " + this.f883g + " or wave > " + this.f884h);
                    }
                    f880e = 0;
                    return;
                }
                if (hc.f1269b) {
                    ls.m1346c("WS2 wave > " + this.f883g + " && wave < " + this.f884h);
                }
                f880e = 0;
                ((Vibrator) getSystemService("vibrator")).vibrate(100);
                if (hc.f1269b) {
                    ls.m1346c("onWave");
                }
                Intent intent = new Intent(this, LauncherShortcutActivity.class);
                intent.setFlags(268435456);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    if (hc.f1269b) {
                        ls.m1348e("onWave: failed to start LauncherShortcutActivity");
                    }
                }
                try {
                    StandOutWindow.m740a(getApplicationContext(), VoiceResultsWindow.class);
                    return;
                } catch (Exception e2) {
                    if (hc.f1269b) {
                        ls.m1348e("StandOutWindow.closeAll");
                        return;
                    }
                    return;
                }
            default:
                return;
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (hc.f1269b) {
            ls.m1346c("SWE onStartCommand");
        }
        if (intent == null && hc.f1269b) {
            ls.m1347d("SWE onStartCommand mIntent was null");
        }
        this.f882f = lx.m1419e(this);
        this.f883g = getSharedPreferences("utterPref", 0).getInt("wave_level_2", 300);
        this.f884h = getSharedPreferences("utterPref", 0).getInt("wave_level_3", 600);
        if (hc.f1269b) {
            ls.m1346c("SWE 1: " + this.f882f + " 2: " + this.f883g + " 3: " + this.f884h);
        }
        this.f881a = (SensorManager) getSystemService("sensor");
        this.f881a.registerListener(this, this.f881a.getDefaultSensor(8), 3);
        return 1;
    }
}
