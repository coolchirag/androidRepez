package com.brandall.nutter;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.telephony.SmsManager;
import java.util.ArrayList;

public final class kh {
    public static void m1293a(String str, String str2) {
        SmsManager smsManager = SmsManager.getDefault();
        if (str2.length() > 160) {
            ls.m1347d("messageBody > 160: " + str2.length());
            ArrayList arrayList = new ArrayList();
            ArrayList divideMessage = smsManager.divideMessage(str2);
            ls.m1346c("myMessage: " + divideMessage.size() + " : " + divideMessage.toString());
            if (divideMessage.size() < 7) {
                smsManager.sendMultipartTextMessage(str, null, divideMessage, null, null);
                return;
            }
            ls.m1347d("myMessage too large: " + divideMessage.size());
            smsManager.sendTextMessage(str, null, "The response was too large to send!?", null, null);
            return;
        }
        ls.m1346c("messageBody < 160: " + str2.length());
        smsManager.sendTextMessage(str, null, str2, null, null);
    }

    public static boolean m1294a(Context context, String str, String str2) {
        SmsManager smsManager = SmsManager.getDefault();
        if (str2.length() > 160) {
            ls.m1347d("messageBody > 160: " + str2.length());
            ArrayList arrayList = new ArrayList();
            ArrayList divideMessage = smsManager.divideMessage(str2);
            ls.m1346c("myMessage: " + divideMessage.size() + " : " + divideMessage.toString());
            if (divideMessage.size() < 7) {
                smsManager.sendMultipartTextMessage(str, null, divideMessage, null, null);
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("address", str);
                    contentValues.put("body", str2);
                    context.getContentResolver().insert(Uri.parse("content://sms/sent"), contentValues);
                } catch (Exception e) {
                    ls.m1348e("Insert Into Sent Foler ERROR: " + e.toString());
                }
                return true;
            }
            ls.m1347d("myMessage too large: " + divideMessage.size());
            return false;
        }
        ls.m1346c("messageBody < 160: " + str2.length());
        smsManager.sendTextMessage(str, null, str2, null, null);
        try {
            contentValues = new ContentValues();
            contentValues.put("address", str);
            contentValues.put("body", str2);
            context.getContentResolver().insert(Uri.parse("content://sms/sent"), contentValues);
        } catch (Exception e2) {
            ls.m1348e("Insert Into Sent Foler ERROR: " + e2.toString());
        }
        return true;
    }
}
