package com.brandall.nutter;

import android.content.Context;

public final class hz {
    public static ia m1159a(Context context, String str) {
        hz hzVar = new hz();
        hzVar.getClass();
        ia iaVar = new ia(hzVar);
        String C;
        if (str.matches("explorer")) {
            if (!lx.m1365D(context)) {
                iaVar.f1425b = false;
                iaVar.f1424a = false;
            } else if (jy.m1262m(context, lx.m1364C(context))) {
                iaVar.f1425b = true;
                iaVar.f1424a = true;
                iaVar.f1426c = false;
                C = lx.m1364C(context);
                iaVar.f1427d = C;
                if (C.matches("com.ghisler.android.TotalCommander")) {
                    iaVar.f1428e = 1;
                } else if (C.matches("com.speedsoftware.rootexplorer")) {
                    iaVar.f1428e = 2;
                } else if (C.matches("com.estrongs.android.pop")) {
                    iaVar.f1428e = 3;
                } else if (C.matches("com.speedsoftware.explorer")) {
                    iaVar.f1428e = 4;
                } else if (C.matches("xcxin.filexpert")) {
                    iaVar.f1428e = 5;
                } else if (C.matches("pl.solidexplorer")) {
                    iaVar.f1428e = 6;
                }
            } else {
                iaVar.f1425b = false;
                iaVar.f1424a = true;
                lx.m1394a(context, "", false);
            }
            if (jy.m1262m(context, "com.ghisler.android.TotalCommander")) {
                iaVar.f1427d = "com.ghisler.android.TotalCommander";
                iaVar.f1428e = 1;
                iaVar.f1426c = false;
            } else if (jy.m1262m(context, "com.speedsoftware.rootexplorer")) {
                iaVar.f1427d = "com.speedsoftware.rootexplorer";
                iaVar.f1428e = 2;
                iaVar.f1426c = false;
            } else if (jy.m1262m(context, "com.estrongs.android.pop")) {
                iaVar.f1427d = "com.estrongs.android.pop";
                iaVar.f1428e = 3;
                iaVar.f1426c = false;
            } else if (jy.m1262m(context, "com.speedsoftware.explorer")) {
                iaVar.f1427d = "com.speedsoftware.explorer";
                iaVar.f1428e = 4;
                iaVar.f1426c = false;
            } else if (jy.m1262m(context, "xcxin.filexpert")) {
                iaVar.f1427d = "xcxin.filexpert";
                iaVar.f1428e = 5;
                iaVar.f1426c = false;
            } else if (jy.m1262m(context, "pl.solidexplorer")) {
                iaVar.f1427d = "pl.solidexplorer";
                iaVar.f1428e = 6;
                iaVar.f1426c = false;
            } else {
                iaVar.f1426c = true;
            }
        } else if (str.matches("notes")) {
            if (!lx.m1367F(context)) {
                iaVar.f1425b = false;
                iaVar.f1424a = false;
            } else if (jy.m1262m(context, lx.m1366E(context))) {
                iaVar.f1425b = true;
                iaVar.f1424a = true;
                iaVar.f1426c = false;
                C = lx.m1366E(context);
                iaVar.f1427d = C;
                if (C.matches("com.evernote")) {
                    iaVar.f1428e = 1;
                } else if (C.matches("com.threebanana.notes")) {
                    iaVar.f1428e = 2;
                }
            } else {
                iaVar.f1425b = false;
                iaVar.f1424a = true;
                lx.m1403b(context, "", false);
            }
            if (jy.m1262m(context, "com.evernote")) {
                iaVar.f1427d = "com.evernote";
                iaVar.f1428e = 1;
                iaVar.f1426c = false;
            } else if (jy.m1262m(context, "com.threebanana.notes")) {
                iaVar.f1427d = "com.threebanana.notes";
                iaVar.f1428e = 2;
                iaVar.f1426c = false;
            } else {
                iaVar.f1426c = true;
            }
        }
        return iaVar;
    }
}
