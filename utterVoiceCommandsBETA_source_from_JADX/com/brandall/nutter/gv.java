package com.brandall.nutter;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.faceture.google.play.QueryParamConst;
import java.text.DecimalFormat;

public final class gv {
    public static String m1000a(Context context, String str) {
        String str2 = "error";
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (str.matches("level")) {
            str2 = String.valueOf(registerReceiver.getIntExtra("level", -1) + "%");
            if (hc.f1269b) {
                ls.m1346c("level: " + str2);
            }
        } else if (str.matches("voltage")) {
            str2 = String.valueOf(new StringBuilder(String.valueOf(registerReceiver.getIntExtra("voltage", -1) / 1000)).append(" Volts.").toString());
            if (hc.f1269b) {
                ls.m1346c("voltage: " + str2);
            }
        } else if (str.matches("temperature")) {
            int intExtra = registerReceiver.getIntExtra("temperature", -1) / 10;
            String format = new DecimalFormat(QueryParamConst.U_VALUE).format((((double) intExtra) * 1.8d) + 32.0d);
            str2 = lx.m1449r(context).matches("c") ? " " + intExtra + " degrees celsius" : lx.m1449r(context).matches("f") ? " " + format + " degrees fahrenheit." : " " + intExtra + " degrees celsius, that's " + format + " degrees fahrenheit.";
            if (hc.f1269b) {
                ls.m1346c("temperature: " + str2);
            }
        } else if (str.matches("status")) {
            switch (registerReceiver.getIntExtra("status", 1)) {
                case 1:
                case 5:
                    str2 = " Currrently indeterminable";
                    break;
                case 2:
                    switch (registerReceiver.getIntExtra("plugged", 1)) {
                        case 1:
                            str2 = " A C charging";
                            break;
                        case 2:
                            str2 = " U S B Charging";
                            break;
                        default:
                            str2 = " Charging";
                            break;
                    }
                case 3:
                    str2 = " Discharging";
                    break;
                case 4:
                    str2 = " On battery power";
                    break;
                default:
                    str2 = " returning an error status";
                    break;
            }
            if (hc.f1269b) {
                ls.m1346c("batStatus: " + str2);
            }
        } else if (str.matches("health")) {
            str2 = " returning an error status";
            switch (registerReceiver.getIntExtra("health", 1)) {
                case 1:
                    str2 = " Currrently indeterminable";
                    break;
                case 2:
                    str2 = " Good";
                    break;
                case 3:
                    str2 = " Over Heating";
                    break;
                case 4:
                    str2 = " Dead";
                    break;
                case 5:
                    str2 = " Over Voltage";
                    break;
                case 6:
                    str2 = " returning an unspecified Failure";
                    break;
                case 7:
                    break;
                default:
                    str2 = " returning an error status";
                    break;
            }
            if (hc.f1269b) {
                ls.m1346c("batHealth: " + str2);
            }
        }
        return str2;
    }
}
