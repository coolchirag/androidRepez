package com.brandall.nutter;

import android.app.backup.BackupAgentHelper;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.FileBackupHelper;
import android.app.backup.SharedPreferencesBackupHelper;
import android.os.ParcelFileDescriptor;

public class BackupAgent extends BackupAgentHelper {
    public void onBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) {
        synchronized (ActivityCustomise.f669b) {
            if (hc.f1269b) {
                ls.m1346c("onBackup dataLock");
            }
            super.onBackup(parcelFileDescriptor, backupDataOutput, parcelFileDescriptor2);
        }
        if (hc.f1269b) {
            ls.m1346c("onBackup");
        }
    }

    public void onCreate() {
        addHelper("myspnutter", new SharedPreferencesBackupHelper(this, new String[]{"utterPref"}));
        addHelper("mydbnutter", new FileBackupHelper(this, new String[]{"../databases/userCommands.db", "../databases/userNicknames.db", "../databases/userWords.db"}));
    }

    public void onRestore(BackupDataInput backupDataInput, int i, ParcelFileDescriptor parcelFileDescriptor) {
        synchronized (ActivityCustomise.f669b) {
            if (hc.f1269b) {
                ls.m1346c("onRestore dataLock");
            }
            super.onRestore(backupDataInput, i, parcelFileDescriptor);
        }
        if (hc.f1269b) {
            ls.m1346c("onRestore");
        }
    }
}
