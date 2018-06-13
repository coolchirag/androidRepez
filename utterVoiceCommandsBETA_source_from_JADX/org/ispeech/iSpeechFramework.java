package org.ispeech;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import org.ispeech.core.ImageScreen;
import org.ispeech.core.InternalResources;
import org.ispeech.core.RecognizerDialog;
import org.ispeech.core.SynthesisDialog;

public final class iSpeechFramework extends Activity {
    public static final int CHECK_ID = -1;
    static final int DIALOG_ID_ADVERTISEMENT = 1;
    static final int DIALOG_ID_LOADING = 3;
    static final int DIALOG_ID_RECOGNIZER = 0;
    public static final int DIALOG_ID_SYNTHESIS = 2;
    private static final String TAG = "iSpeech SDK";
    Handler dialogMessageHandler;

    class C06051 extends Handler {
        C06051() {
        }

        public void handleMessage(Message message) {
            iSpeechFramework.this.showDialog(message.what);
        }
    }

    class C06062 implements OnClickListener {
        C06062() {
        }

        public void onClick(View view) {
            SynthesisDialog.getInstance().dismiss();
        }
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dialogMessageHandler = new C06051();
        int i = getIntent().getExtras().getInt(InternalResources.ISPEECH_SCREEN_TYPE);
        if (i == -1) {
            finish();
        } else {
            showDialog(i);
        }
    }

    protected final Dialog onCreateDialog(int i) {
        Dialog recognizerDialog;
        switch (i) {
            case 0:
                recognizerDialog = new RecognizerDialog(this);
                break;
            case 1:
                Intent intent = getIntent();
                String string = intent.getExtras().getString(InternalResources.ISPEECH_SCREEN_ADIURL);
                String string2 = intent.getExtras().getString(InternalResources.ISPEECH_SCREEN_ADCURL);
                int i2 = intent.getExtras().getInt(InternalResources.ISPEECH_SCREEN_AD_HEIGHT);
                recognizerDialog = new ImageScreen(this, string, string2, intent.getExtras().getInt(InternalResources.ISPEECH_SCREEN_AD_WIDTH), i2);
                break;
            case 2:
                recognizerDialog = SynthesisDialog.newInstance(this);
                recognizerDialog.setOnCancelClickListener(new C06062());
                break;
            case 3:
                recognizerDialog = new MProcessingDialog(this);
                break;
            default:
                recognizerDialog = null;
                break;
        }
        if (recognizerDialog != null) {
            recognizerDialog.setOwnerActivity(this);
        }
        return recognizerDialog;
    }
}
