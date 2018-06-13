package com.brandall.nutter;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class gx extends AsyncTask<ArrayList<String>, Void, Void> {
    private static boolean f1256e = false;
    Context f1257a;
    lb f1258b;
    int f1259c = 0;
    private String f1260d = "";
    private boolean f1261f = false;

    public gx(Context context) {
        this.f1257a = context;
    }

    private static void m1003a() {
        ls.m1346c("CC tidyVariables");
        GlobalV.m815a();
        f1256e = false;
    }

    protected final /* synthetic */ Object doInBackground(Object... objArr) {
        ArrayList[] arrayListArr = (ArrayList[]) objArr;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = arrayListArr[0];
        ListIterator listIterator = arrayList2.listIterator();
        Locale locale = Locale.US;
        while (listIterator.hasNext()) {
            String trim = ((String) listIterator.next()).toString().toLowerCase(locale).trim();
            if (hc.f1269b) {
                ls.m1344a("mypass: " + trim);
            }
            if (!trim.matches("cancel") && !trim.matches("council") && !trim.matches("cancer") && !trim.contains("council council") && !trim.contains("cancer cancer")) {
                if (trim.contains("cancel cancel")) {
                    this.f1261f = true;
                    break;
                }
            }
            this.f1261f = true;
            break;
        }
        if (!this.f1261f) {
            Matcher matcher = Pattern.compile("[\\*]+").matcher((CharSequence) arrayList2.get(0));
            ls.m1344a("responseData: " + arrayList2.size() + " : " + arrayList2.toString());
            he heVar = new he(this.f1257a);
            int ac = GlobalV.ac();
            ls.m1344a("CreateStage: " + ac);
            ContentValues contentValues;
            SQLiteDatabase writableDatabase;
            switch (ac) {
                case 0:
                    ls.m1347d("CC stage: 0");
                    this.f1260d = "Sorry, something went wrong in the command creation.";
                    m1003a();
                    break;
                case 1:
                    ls.m1346c("CreateStage: " + ac);
                    Context context = this.f1257a;
                    ha a = gz.m1056a(arrayList2);
                    if (a.f1265b != 0 && a.f1264a != null) {
                        ls.m1346c("mCI.toSay: " + a.f1264a);
                        Intent intent;
                        switch (a.f1265b) {
                            case 1:
                                ls.m1346c("Case: 1: stage: " + ac);
                                this.f1258b = heVar.m1065a("NULL", a.f1265b, "NULL", "NULL", "NULL", "NULL", "NULL", "NULL");
                                GlobalV.m816a(this.f1258b.f1653a);
                                intent = new Intent(this.f1257a, ActivityContactPicker.class);
                                intent.setFlags(1073741824);
                                intent.setFlags(268435456);
                                intent.putExtra("sender", "display");
                                this.f1257a.startActivity(intent);
                                GlobalV.m858k(2);
                                f1256e = false;
                                break;
                            case 2:
                                ls.m1346c("Case: 2: stage: " + ac);
                                this.f1258b = heVar.m1065a("NULL", a.f1265b, "NULL", "NULL", "NULL", "NULL", "NULL", "NULL");
                                GlobalV.m816a(this.f1258b.f1653a);
                                intent = new Intent(this.f1257a, ActivityTasker.class);
                                intent.setFlags(1073741824);
                                intent.setFlags(268435456);
                                intent.putExtra("sender", "creator");
                                this.f1257a.startActivity(intent);
                                GlobalV.m858k(2);
                                f1256e = false;
                                break;
                            case 3:
                                ls.m1346c("Case: 3: stage: " + ac);
                                this.f1258b = heVar.m1065a("NULL", a.f1265b, "NULL", "NULL", "NULL", "NULL", "NULL", "NULL");
                                GlobalV.m816a(this.f1258b.f1653a);
                                intent = new Intent(this.f1257a, ActivityPickerActivity.class);
                                intent.setFlags(1073741824);
                                intent.setFlags(268435456);
                                intent.putExtra("sender", "creator");
                                this.f1257a.startActivity(intent);
                                GlobalV.m858k(2);
                                f1256e = false;
                                break;
                            case 4:
                                ls.m1346c("Case: 4: stage: " + ac);
                                this.f1258b = heVar.m1065a("NULL", a.f1265b, "NULL", "NULL", "NULL", "NULL", "NULL", "NULL");
                                GlobalV.m816a(this.f1258b.f1653a);
                                intent = new Intent(this.f1257a, ActivityContactPicker.class);
                                intent.setFlags(1073741824);
                                intent.setFlags(268435456);
                                intent.putExtra("sender", "call");
                                this.f1257a.startActivity(intent);
                                GlobalV.m858k(2);
                                f1256e = false;
                                break;
                            case 5:
                                ls.m1346c("Case: 4: stage: " + ac);
                                this.f1258b = heVar.m1065a("NULL", a.f1265b, "NULL", "NULL", "NULL", "NULL", "NULL", "NULL");
                                GlobalV.m816a(this.f1258b.f1653a);
                                intent = new Intent(this.f1257a, ActivityApplications.class);
                                intent.setFlags(1073741824);
                                intent.setFlags(268435456);
                                this.f1257a.startActivity(intent);
                                GlobalV.m858k(2);
                                f1256e = false;
                                break;
                            case 999:
                                ls.m1347d("mCI.commandInteger: 999");
                                m1003a();
                                break;
                        }
                        this.f1260d = a.f1264a;
                        break;
                    }
                    ls.m1347d("CC case1 mCI =0 null");
                    this.f1260d = a.f1264a;
                    f1256e = false;
                    m1003a();
                    break;
                case 2:
                    ls.m1346c("in CreateStage: " + ac);
                    this.f1259c = heVar.m1082i(GlobalV.m798K());
                    switch (this.f1259c) {
                        case 0:
                            ls.m1347d("CC stage: 0");
                            this.f1260d = "Sorry, something went wrong in the command creation.";
                            break;
                        case 1:
                            ls.m1346c("Case: 1: stage: " + ac);
                            if (arrayList2.size() <= 1) {
                                this.f1260d = "Sorry, but there was an error in the contact data. The command creation has been cancelled";
                                heVar.m1067a(GlobalV.m798K());
                                m1003a();
                                break;
                            }
                            contentValues = new ContentValues();
                            contentValues.put("string_1", (String) arrayList2.get(0));
                            contentValues.put("string_2", (String) arrayList2.get(1));
                            writableDatabase = heVar.getWritableDatabase();
                            writableDatabase.update("user_commands", contentValues, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                            writableDatabase.close();
                            f1256e = true;
                            this.f1260d = "Okay. Please say the command phrase.";
                            GlobalV.m858k(3);
                            break;
                        case 2:
                            ls.m1346c("Case: 2: stage: " + ac);
                            contentValues = new ContentValues();
                            contentValues.put("string_1", (String) arrayList2.get(0));
                            writableDatabase = heVar.getWritableDatabase();
                            writableDatabase.update("user_commands", contentValues, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                            writableDatabase.close();
                            f1256e = true;
                            this.f1260d = "Thank you. Please say the command phrase.";
                            GlobalV.m858k(3);
                            break;
                        case 3:
                            ls.m1346c("Case: 3: stage: " + ac);
                            contentValues = new ContentValues();
                            contentValues.put("string_1", (String) arrayList2.get(0));
                            contentValues.put("string_2", (String) arrayList2.get(1));
                            writableDatabase = heVar.getWritableDatabase();
                            writableDatabase.update("user_commands", contentValues, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                            writableDatabase.close();
                            f1256e = true;
                            this.f1260d = "Thank you. Please say the command phrase.";
                            GlobalV.m858k(3);
                            break;
                        case 4:
                            ls.m1346c("Case: 4: stage: " + ac);
                            if (arrayList2.size() <= 1) {
                                this.f1260d = "Sorry, but there was an error in the contact data. The command creation has been cancelled";
                                heVar.m1067a(GlobalV.m798K());
                                m1003a();
                                break;
                            }
                            contentValues = new ContentValues();
                            contentValues.put("string_1", (String) arrayList2.get(0));
                            contentValues.put("string_2", (String) arrayList2.get(1));
                            contentValues.put("string_3", (String) arrayList2.get(2));
                            writableDatabase = heVar.getWritableDatabase();
                            writableDatabase.update("user_commands", contentValues, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                            writableDatabase.close();
                            f1256e = true;
                            this.f1260d = "Okay. Please say the command phrase.";
                            GlobalV.m858k(3);
                            break;
                        case 5:
                            ls.m1346c("Case: 5: stage: " + ac);
                            if (arrayList2.size() <= 1) {
                                this.f1260d = "Sorry, but there was an error in the application data. The command creation has been cancelled";
                                heVar.m1067a(GlobalV.m798K());
                                m1003a();
                                break;
                            }
                            contentValues = new ContentValues();
                            contentValues.put("string_1", (String) arrayList2.get(0));
                            contentValues.put("string_2", (String) arrayList2.get(1));
                            writableDatabase = heVar.getWritableDatabase();
                            writableDatabase.update("user_commands", contentValues, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                            writableDatabase.close();
                            f1256e = true;
                            this.f1260d = "Okay. Please say the command phrase.";
                            GlobalV.m858k(3);
                            break;
                        case 999:
                            ls.m1347d("CC stage: 0");
                            this.f1260d = "Sorry, something went wrong in the command creation.";
                            break;
                        default:
                            break;
                    }
                case 3:
                    ls.m1346c("CreateCond: " + ac);
                    ArrayList arrayList3 = new ArrayList();
                    this.f1259c = heVar.m1082i(GlobalV.m798K());
                    switch (this.f1259c) {
                        case 0:
                            m1003a();
                            break;
                        case 1:
                            ls.m1346c("CC stage: 3 : CommandInt: 1");
                            arrayList3 = heVar.m1066a();
                            ls.m1344a("ucArray:" + arrayList3.size() + " : " + arrayList3.toString());
                            if (!arrayList3.contains(arrayList2.get(0))) {
                                contentValues = new ContentValues();
                                contentValues.put("keyword", (String) arrayList2.get(0));
                                heVar.getWritableDatabase().update("user_commands", contentValues, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                                f1256e = true;
                                this.f1260d = "Please confirm that phrase.";
                                GlobalV.m858k(4);
                                break;
                            }
                            ls.m1347d("ucArray contains phrase");
                            this.f1260d = "Sorry, that phrase is already used. You can edit your custom commands and phrases in the Customisation Tab.";
                            heVar.m1067a(GlobalV.m798K());
                            m1003a();
                            break;
                        case 2:
                            ls.m1346c("CC stage: 3 : CommandInt: 2");
                            arrayList3 = heVar.m1066a();
                            ls.m1344a("ucArray:" + arrayList3.size() + " : " + arrayList3.toString());
                            if (!arrayList3.contains(arrayList2.get(0))) {
                                contentValues = new ContentValues();
                                contentValues.put("keyword", (String) arrayList2.get(0));
                                writableDatabase = heVar.getWritableDatabase();
                                writableDatabase.update("user_commands", contentValues, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                                writableDatabase.close();
                                f1256e = true;
                                this.f1260d = "Please confirm that phrase.";
                                GlobalV.m858k(4);
                                break;
                            }
                            ls.m1347d("ucArray contains phrase");
                            this.f1260d = "Sorry, that phrase is already used. You can edit your custom commands and phrases in the Customisation Tab.";
                            heVar.m1067a(GlobalV.m798K());
                            m1003a();
                            break;
                        case 3:
                            ls.m1346c("CC stage: 3 : CommandInt: 3");
                            arrayList3 = heVar.m1066a();
                            ls.m1344a("ucArray:" + arrayList3.size() + " : " + arrayList3.toString());
                            if (!arrayList3.contains(arrayList2.get(0))) {
                                contentValues = new ContentValues();
                                contentValues.put("keyword", (String) arrayList2.get(0));
                                writableDatabase = heVar.getWritableDatabase();
                                writableDatabase.update("user_commands", contentValues, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                                writableDatabase.close();
                                f1256e = true;
                                this.f1260d = "Please confirm that phrase.";
                                GlobalV.m858k(4);
                                break;
                            }
                            ls.m1347d("ucArray contains phrase");
                            this.f1260d = "Sorry, that phrase is already used. You can edit your custom commands and phrases in the Customisation Tab.";
                            heVar.m1067a(GlobalV.m798K());
                            m1003a();
                            break;
                        case 4:
                            ls.m1346c("CC stage: 3 : CommandInt: 4");
                            arrayList3 = heVar.m1066a();
                            ls.m1344a("ucArray:" + arrayList3.size() + " : " + arrayList3.toString());
                            if (!arrayList3.contains(arrayList2.get(0))) {
                                contentValues = new ContentValues();
                                contentValues.put("keyword", (String) arrayList2.get(0));
                                writableDatabase = heVar.getWritableDatabase();
                                writableDatabase.update("user_commands", contentValues, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                                writableDatabase.close();
                                f1256e = true;
                                this.f1260d = "Please confirm that phrase.";
                                GlobalV.m858k(4);
                                break;
                            }
                            ls.m1347d("ucArray contains phrase");
                            this.f1260d = "Sorry, that phrase is already used. You can edit your custom commands and phrases in the Customisation Tab.";
                            heVar.m1067a(GlobalV.m798K());
                            m1003a();
                            break;
                        case 5:
                            ls.m1346c("CC stage: 3 : CommandInt: 5");
                            arrayList3 = heVar.m1066a();
                            ls.m1344a("ucArray:" + arrayList3.size() + " : " + arrayList3.toString());
                            if (!arrayList3.contains(arrayList2.get(0))) {
                                contentValues = new ContentValues();
                                contentValues.put("keyword", (String) arrayList2.get(0));
                                writableDatabase = heVar.getWritableDatabase();
                                writableDatabase.update("user_commands", contentValues, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                                writableDatabase.close();
                                f1256e = true;
                                this.f1260d = "Please confirm that phrase.";
                                GlobalV.m858k(4);
                                break;
                            }
                            ls.m1347d("ucArray contains phrase");
                            this.f1260d = "Sorry, that phrase is already used. You can edit your custom commands and phrases in the Customisation Tab.";
                            heVar.m1067a(GlobalV.m798K());
                            m1003a();
                            break;
                        default:
                            break;
                    }
                case 4:
                    ls.m1346c("CreateCond: " + ac);
                    this.f1259c = heVar.m1082i(GlobalV.m798K());
                    switch (this.f1259c) {
                        case 0:
                            ls.m1347d("CC stage: 0");
                            this.f1260d = "Sorry, something went wrong in the command creation.";
                            m1003a();
                            break;
                        case 1:
                            ls.m1346c("CC stage: 4 : CommandInt: 1");
                            if (!matcher.find()) {
                                if (!((String) arrayList2.get(0)).matches(heVar.m1069b(GlobalV.m798K()))) {
                                    ls.m1347d("userCommandPhrase didn't match");
                                    this.f1260d = "Sorry, those phrases didn't match. The command creation has been cancelled.";
                                    heVar.m1067a(GlobalV.m798K());
                                    m1003a();
                                    break;
                                }
                                f1256e = true;
                                this.f1260d = "Okay, that's fine. What do you want me to say if the command is successful?";
                                GlobalV.m858k(5);
                                break;
                            }
                            this.f1260d = "Sorry, the phrase contained an asterisk, which isn't allowed. The command creation has been cancelled.";
                            heVar.m1067a(GlobalV.m798K());
                            m1003a();
                            break;
                        case 2:
                            ls.m1346c("CC stage: 4 : CommandInt: 2");
                            if (!matcher.find()) {
                                if (!((String) arrayList2.get(0)).matches(heVar.m1069b(GlobalV.m798K()))) {
                                    ls.m1347d("userCommandPhrase didn't match");
                                    this.f1260d = "Sorry, those phrases didn't match.";
                                    heVar.m1067a(GlobalV.m798K());
                                    m1003a();
                                    break;
                                }
                                f1256e = true;
                                this.f1260d = "Okay, that's fine. What do you want me to say if the command is successful?";
                                GlobalV.m858k(5);
                                break;
                            }
                            this.f1260d = "Sorry, the phrase contained an asterisk, which isn't allowed. The command creation has been cancelled.";
                            heVar.m1067a(GlobalV.m798K());
                            m1003a();
                            break;
                        case 3:
                            ls.m1346c("CC stage: 4 : CommandInt: 3");
                            if (!matcher.find()) {
                                if (!((String) arrayList2.get(0)).matches(heVar.m1069b(GlobalV.m798K()))) {
                                    ls.m1347d("userCommandPhrase didn't match");
                                    this.f1260d = "Sorry, those phrases didn't match.";
                                    heVar.m1067a(GlobalV.m798K());
                                    m1003a();
                                    break;
                                }
                                f1256e = true;
                                this.f1260d = "Okay, that's fine. What do you want me to say if the command is successful?";
                                GlobalV.m858k(5);
                                break;
                            }
                            this.f1260d = "Sorry, the phrase contained an asterisk, which isn't allowed. The command creation has been cancelled.";
                            heVar.m1067a(GlobalV.m798K());
                            m1003a();
                            break;
                        case 4:
                            ls.m1346c("CC stage: 4 : CommandInt: 4");
                            if (!matcher.find()) {
                                if (!((String) arrayList2.get(0)).matches(heVar.m1069b(GlobalV.m798K()))) {
                                    ls.m1347d("userCommandPhrase didn't match");
                                    this.f1260d = "Sorry, those phrases didn't match. The command creation has been cancelled.";
                                    heVar.m1067a(GlobalV.m798K());
                                    m1003a();
                                    break;
                                }
                                f1256e = true;
                                this.f1260d = "Okay, that's fine. What do you want me to say if the command is successful?";
                                GlobalV.m858k(5);
                                break;
                            }
                            this.f1260d = "Sorry, the phrase contained an asterisk, which isn't allowed. The command creation has been cancelled.";
                            heVar.m1067a(GlobalV.m798K());
                            m1003a();
                            break;
                        case 5:
                            ls.m1346c("CC stage: 4 : CommandInt: 5");
                            if (!matcher.find()) {
                                if (!((String) arrayList2.get(0)).matches(heVar.m1069b(GlobalV.m798K()))) {
                                    ls.m1347d("userCommandPhrase didn't match");
                                    this.f1260d = "Sorry, those phrases didn't match. The command creation has been cancelled.";
                                    heVar.m1067a(GlobalV.m798K());
                                    m1003a();
                                    break;
                                }
                                f1256e = true;
                                this.f1260d = "Okay, that's fine. What do you want me to say if the command is successful?";
                                GlobalV.m858k(5);
                                break;
                            }
                            this.f1260d = "Sorry, the phrase contained an asterisk, which isn't allowed. The command creation has been cancelled.";
                            heVar.m1067a(GlobalV.m798K());
                            m1003a();
                            break;
                        default:
                            break;
                    }
                case 5:
                    ls.m1346c("CreateCond: " + ac);
                    ContentValues contentValues2 = new ContentValues();
                    this.f1259c = heVar.m1082i(GlobalV.m798K());
                    SQLiteDatabase writableDatabase2 = heVar.getWritableDatabase();
                    switch (this.f1259c) {
                        case 0:
                            ls.m1347d("CC stage: 0");
                            this.f1260d = "Sorry, something went wrong in the command creation.";
                            m1003a();
                            break;
                        case 1:
                            ls.m1346c("CC stage: 5 : CommandInt: 1");
                            contentValues2.put("success_words", (String) arrayList2.get(0));
                            writableDatabase2.update("user_commands", contentValues2, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                            writableDatabase2.close();
                            f1256e = true;
                            this.f1260d = "And if it fails?";
                            GlobalV.m858k(6);
                            break;
                        case 2:
                            ls.m1346c("CC stage: 5 : CommandInt: 2");
                            contentValues2.put("success_words", (String) arrayList2.get(0));
                            writableDatabase2.update("user_commands", contentValues2, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                            writableDatabase2.close();
                            f1256e = true;
                            this.f1260d = "And if it fails?";
                            GlobalV.m858k(6);
                            break;
                        case 3:
                            ls.m1346c("CC stage: 5 : CommandInt: 3");
                            contentValues2.put("success_words", (String) arrayList2.get(0));
                            writableDatabase2.update("user_commands", contentValues2, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                            writableDatabase2.close();
                            f1256e = true;
                            this.f1260d = "And if it fails?";
                            GlobalV.m858k(6);
                            break;
                        case 4:
                            ls.m1346c("CC stage: 5 : CommandInt: 4");
                            contentValues2.put("success_words", (String) arrayList2.get(0));
                            writableDatabase2.update("user_commands", contentValues2, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                            writableDatabase2.close();
                            f1256e = true;
                            this.f1260d = "And if it fails?";
                            GlobalV.m858k(6);
                            break;
                        case 5:
                            ls.m1346c("CC stage: 5 : CommandInt: 5");
                            contentValues2.put("success_words", (String) arrayList2.get(0));
                            writableDatabase2.update("user_commands", contentValues2, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                            writableDatabase2.close();
                            f1256e = true;
                            this.f1260d = "And if it fails?";
                            GlobalV.m858k(6);
                            break;
                        default:
                            break;
                    }
                case 6:
                    ls.m1346c("CreateCond: " + ac);
                    contentValues = new ContentValues();
                    this.f1259c = heVar.m1082i(GlobalV.m798K());
                    SQLiteDatabase writableDatabase3 = heVar.getWritableDatabase();
                    switch (this.f1259c) {
                        case 0:
                            ls.m1347d("CC stage: 0");
                            this.f1260d = "Sorry, something went wrong in the command creation.";
                            m1003a();
                            break;
                        case 1:
                            ls.m1346c("CC stage: 6 : CommandInt: 1");
                            contentValues.put("fail_words", (String) arrayList2.get(0));
                            writableDatabase3.update("user_commands", contentValues, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                            writableDatabase3.close();
                            this.f1260d = "Okay, I've created that command. When you say, " + heVar.m1069b(GlobalV.m798K()) + ", I'll display the contact, " + heVar.m1071c(GlobalV.m798K()) + ".  If it's successful, I'll say, " + heVar.m1079g(GlobalV.m798K()) + ".  If it's unsuccessful, I'll say, " + heVar.m1081h(GlobalV.m798K());
                            lx.m1439l(this.f1257a, true);
                            m1003a();
                            break;
                        case 2:
                            ls.m1346c("CC stage: 6 : CommandInt: 2");
                            contentValues.put("fail_words", (String) arrayList2.get(0));
                            writableDatabase3.update("user_commands", contentValues, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                            writableDatabase3.close();
                            this.f1260d = "Okay, I've created that command. When you say, " + heVar.m1069b(GlobalV.m798K()) + ", I'll execute the task, " + heVar.m1071c(GlobalV.m798K()) + ".  If it's successful, I'll say, " + heVar.m1079g(GlobalV.m798K()) + ".  If it's unsuccessful, I'll say, " + heVar.m1081h(GlobalV.m798K());
                            lx.m1439l(this.f1257a, true);
                            m1003a();
                            break;
                        case 3:
                            ls.m1346c("CC stage: 6 : CommandInt: 3");
                            contentValues.put("fail_words", (String) arrayList2.get(0));
                            writableDatabase3.update("user_commands", contentValues, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                            writableDatabase3.close();
                            this.f1260d = "Okay, I've created that command. When you say, " + heVar.m1069b(GlobalV.m798K()) + ", I'll execute the activity, " + heVar.m1071c(GlobalV.m798K()) + ".  If it's successful, I'll say, " + heVar.m1079g(GlobalV.m798K()) + ".  If it's unsuccessful, I'll say, " + heVar.m1081h(GlobalV.m798K());
                            lx.m1439l(this.f1257a, true);
                            m1003a();
                            break;
                        case 4:
                            ls.m1346c("CC stage: 6 : CommandInt: 4");
                            contentValues.put("fail_words", (String) arrayList2.get(0));
                            writableDatabase3.update("user_commands", contentValues, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                            writableDatabase3.close();
                            this.f1260d = "Okay, I've created that command. When you say, " + heVar.m1069b(GlobalV.m798K()) + ", I'll call the contact, " + heVar.m1071c(GlobalV.m798K()) + ",  on, " + heVar.m1075e(GlobalV.m798K()).replaceAll(".(?=.)", "$0 ").trim() + ".  If it's successful, I'll say, " + heVar.m1079g(GlobalV.m798K()) + ".  If it's unsuccessful, I'll say, " + heVar.m1081h(GlobalV.m798K());
                            lx.m1439l(this.f1257a, true);
                            m1003a();
                            break;
                        case 5:
                            ls.m1346c("CC stage: 6 : CommandInt: 5");
                            contentValues.put("fail_words", (String) arrayList2.get(0));
                            writableDatabase3.update("user_commands", contentValues, "_id = ?", new String[]{String.valueOf(GlobalV.m798K())});
                            writableDatabase3.close();
                            this.f1260d = "Okay, I've created that command. When you say, " + heVar.m1069b(GlobalV.m798K()) + ", I'll open the application, " + heVar.m1071c(GlobalV.m798K()) + ",  If it's successful, I'll say, " + heVar.m1079g(GlobalV.m798K()) + ".  If it's unsuccessful, I'll say, " + heVar.m1081h(GlobalV.m798K());
                            lx.m1439l(this.f1257a, true);
                            m1003a();
                            break;
                        default:
                            break;
                    }
            }
        }
        this.f1260d = "Cancelling.";
        m1003a();
        return null;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Void voidR = (Void) obj;
        ls.m1345b("CommandCreator onPostEx");
        if (!this.f1260d.matches("tasker")) {
            if (f1256e) {
                ls.m1346c("startRecog: true");
                lc.m1313a(this.f1257a, true, this.f1260d);
            } else {
                ls.m1346c("startRecog: false");
                lc.m1313a(this.f1257a, false, this.f1260d);
            }
        }
        super.onPostExecute(voidR);
    }
}
