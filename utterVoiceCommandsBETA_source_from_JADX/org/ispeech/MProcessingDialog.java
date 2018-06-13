package org.ispeech;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import org.ispeech.error.InvalidApiKeyException;
import org.ispeech.tools.Utilities;

public class MProcessingDialog extends Dialog implements Runnable {
    private static final String TAG = "iSpeech SDK";
    private final int MINIMUM_DIALOG_TIME = 1500;
    private Activity _callingActivity;
    Context _context;
    Dialog _self = this;
    boolean audioPlayStarted = false;
    private long processingEndTime;
    private long processingStartTime;
    SpeechSynthesis speechSyntesisInstance;
    private SpeechSynthesisEvent speechSynthesisEventListener;

    class C05811 implements OnCancelListener {
        C05811() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            MProcessingDialog.this.speechSyntesisInstance.cancel();
            MProcessingDialog.this.dismiss();
        }
    }

    class C05822 extends SpeechSynthesisEvent {
        C05822() {
        }

        public void onPlayFailed(Exception exception) {
            Log.v(MProcessingDialog.TAG, "Audio play started");
            MProcessingDialog.this.audioPlayStarted = false;
            MProcessingDialog.this.processingEndTime = System.currentTimeMillis();
            if (MProcessingDialog.this.processingEndTime - MProcessingDialog.this.processingStartTime > 1500) {
                MProcessingDialog.this.dismiss();
            } else {
                MProcessingDialog.this.startDialogWaitingThread();
            }
        }

        public void onPlayStart() {
            Log.v(MProcessingDialog.TAG, "Audio play started");
            MProcessingDialog.this.audioPlayStarted = true;
            MProcessingDialog.this.processingEndTime = System.currentTimeMillis();
            if (MProcessingDialog.this.processingEndTime - MProcessingDialog.this.processingStartTime > 1500) {
                MProcessingDialog.this.dismiss();
            } else {
                MProcessingDialog.this.startDialogWaitingThread();
            }
        }
    }

    class C05833 implements OnClickListener {
        C05833() {
        }

        public void onClick(View view) {
            MProcessingDialog.this._self.cancel();
        }
    }

    public MProcessingDialog(Activity activity) {
        super(activity);
        this._callingActivity = activity;
        this.processingStartTime = System.currentTimeMillis();
        try {
            this.speechSyntesisInstance = SpeechSynthesis.getInstance(this._callingActivity);
        } catch (InvalidApiKeyException e) {
        }
        setupDialogBody(activity);
        setOnCancelListener(new C05811());
        this.speechSynthesisEventListener = new C05822();
        this.speechSyntesisInstance.setSpeechSynthesisEvent(this.speechSynthesisEventListener);
    }

    private View getCancelButtonView(Context context) {
        View button = new Button(context);
        button.setText("Cancel");
        button.setOnClickListener(new C05833());
        return button;
    }

    private View getProgressBarView(Context context) {
        View linearLayout = new LinearLayout(context);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, (int) Utilities.dp2px(10.0f, context), 0, (int) Utilities.dp2px(10.0f, context));
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        View progressBar = new ProgressBar(context);
        progressBar.setIndeterminate(true);
        linearLayout.addView(progressBar);
        return linearLayout;
    }

    private View getiSpeechLogoView(Context context) {
        View imageView = new ImageView(context);
        imageView.setImageBitmap(BitmapFactory.decodeStream(MProcessingDialog.class.getClassLoader().getResourceAsStream("org/ispeech/raw/logo.png")));
        return imageView;
    }

    private void setupDialogBody(Context context) {
        requestWindowFeature(1);
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.addView(getiSpeechLogoView(context));
        linearLayout.addView(getProgressBarView(context));
        linearLayout.addView(getCancelButtonView(context));
        setContentView(linearLayout);
    }

    private void startDialogWaitingThread() {
        new Thread(this).start();
    }

    public void dismiss() {
        this.speechSyntesisInstance.unregisterSpeechSynthesisEventListener(this.speechSynthesisEventListener);
        super.dismiss();
        if (getOwnerActivity() != null) {
            getOwnerActivity().finish();
        }
    }

    public void run() {
        try {
            Thread.sleep(1500 - (this.processingEndTime - this.processingStartTime));
            dismiss();
        } catch (InterruptedException e) {
        }
    }
}
