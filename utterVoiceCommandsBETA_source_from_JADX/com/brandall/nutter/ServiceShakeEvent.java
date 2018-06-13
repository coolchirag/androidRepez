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

public class ServiceShakeEvent extends Service implements SensorEventListener {
    private static long f830j = 0;
    private static long f831k = 0;
    private static long f832l = 0;
    String f833a = "";
    private SensorManager f834b;
    private float f835c;
    private float f836d;
    private float f837e;
    private float f838f = 0.0f;
    private float f839g = 0.0f;
    private float f840h = 0.0f;
    private float f841i = 0.0f;
    private int f842m = 0;

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (hc.f1269b) {
            ls.m1346c("SSE onCreate");
        }
    }

    public void onDestroy() {
        if (hc.f1269b) {
            ls.m1346c("SSE onDestroy");
        }
        try {
            this.f834b.unregisterListener(this);
        } catch (Exception e) {
            if (hc.f1269b) {
                ls.m1348e("mSensorManager unregister");
            }
            e.printStackTrace();
        }
        stopSelf();
        super.onDestroy();
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            this.f838f = sensorEvent.values[0];
            this.f839g = sensorEvent.values[1];
            this.f840h = sensorEvent.values[2];
            this.f837e = this.f836d;
            this.f836d = (float) Math.sqrt((double) (((this.f838f * this.f838f) + (this.f839g * this.f839g)) + (this.f840h * this.f840h)));
            this.f841i = this.f836d - this.f837e;
            this.f835c = (this.f835c * 0.9f) + this.f841i;
            if (this.f835c > ((float) this.f842m)) {
                long currentTimeMillis = System.currentTimeMillis();
                f830j = currentTimeMillis;
                f832l = currentTimeMillis - f831k;
                if (hc.f1269b) {
                    ls.m1344a("now - then: " + f830j + " - " + f831k);
                }
                if (f832l > 4000) {
                    if (hc.f1269b) {
                        ls.m1344a("shake > 4000: " + f832l);
                    }
                    if (hc.f1269b) {
                        ls.m1346c("onShake");
                    }
                    f831k = System.currentTimeMillis();
                    ((Vibrator) getSystemService("vibrator")).vibrate(100);
                    Intent intent = new Intent(this, LauncherShortcutActivity.class);
                    intent.setFlags(268435456);
                    try {
                        startActivity(intent);
                    } catch (Exception e) {
                        if (hc.f1269b) {
                            ls.m1348e("onShake: Failed to start LauncherShortcutActivity");
                        }
                    }
                    try {
                        StandOutWindow.m740a(getApplicationContext(), VoiceResultsWindow.class);
                    } catch (Exception e2) {
                        if (hc.f1269b) {
                            ls.m1347d("StandOutWindow.closeAll");
                        }
                    }
                } else if (hc.f1269b) {
                    ls.m1347d("shake < 4000: " + f832l);
                }
            }
        } else if (hc.f1269b) {
            ls.m1347d("Not TYPE_ACCELEROMETER");
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (hc.f1269b) {
            ls.m1346c("SSE onStartCommand");
        }
        if (intent == null && hc.f1269b) {
            ls.m1347d("SSE onStartCommand mIntent was null");
        }
        this.f842m = lx.m1422f(this);
        if (hc.f1269b) {
            ls.m1346c("SSE shakeLevel: " + this.f842m);
        }
        this.f834b = (SensorManager) getSystemService("sensor");
        this.f834b.registerListener(this, this.f834b.getDefaultSensor(1), 3);
        this.f835c = 0.0f;
        this.f836d = 9.80665f;
        this.f837e = 9.80665f;
        return 1;
    }
}
