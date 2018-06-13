package org.ispeech.core;

import DrawImage.DrawCanvas;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TextView;
import org.ispeech.SpeechRecognizer;
import org.ispeech.tools.Utilities;

public class RecognizerDialog extends Dialog {
    public static final int DISMISS_DIALOG = 0;
    public static final int SET_PROCESSING = 2;
    public static final int SHOW_DIALOG = 1;
    private static final String TAG = ("iSpeech SDK->" + RecognizerDialog.class.getSimpleName());
    public static final int UPDATE_MICROPHONE_LEVEL = 3;
    private static RecognizerDialog _instance;
    public static boolean dialogRunning = true;
    private ImageView animation;
    private Button cancel;
    Context context;
    private LinearLayout ll;
    private DrawCanvas myCanvas;
    Handler refresh = new Handler();
    private Button stop;
    private TextView text;

    class C05991 implements OnClickListener {
        C05991() {
        }

        public void onClick(View view) {
            try {
                SpeechRecognizer.getInstance(RecognizerDialog.this.context).stopRecord();
            } catch (Throwable e) {
                Log.e(RecognizerDialog.TAG, e.getMessage(), e);
            }
        }
    }

    class C06002 implements OnClickListener {
        C06002() {
        }

        public void onClick(View view) {
            try {
                SpeechRecognizer.getInstance(RecognizerDialog.this.context).cancelRecord();
            } catch (Throwable e) {
                Log.e(RecognizerDialog.TAG, e.getMessage(), e);
            }
            RecognizerDialog.this.clearLayout();
            RecognizerDialog.this.dismiss();
        }
    }

    class C06013 implements Runnable {
        C06013() {
        }

        public void run() {
            RecognizerDialog.this.myCanvas.setBackgroundDrawable(null);
        }
    }

    class C06024 implements OnClickListener {
        C06024() {
        }

        public void onClick(View view) {
            try {
                SpeechRecognizer.getInstance(RecognizerDialog.this.context).cancelProcessing();
            } catch (Throwable e) {
                Log.e(RecognizerDialog.TAG, e.getMessage(), e);
            }
            RecognizerDialog.this.clearLayout();
            RecognizerDialog.this.dismiss();
        }
    }

    public RecognizerDialog(Context context) {
        super(context, 16973914);
        this.context = context;
        requestWindowFeature(1);
        setCancelable(false);
        loadMicrophoneAnimationFrames();
        initLayout();
        _instance = this;
    }

    private void addCancelStopButtons(LinearLayout linearLayout) {
        this.stop = new Button(this.context);
        this.stop.setText("Done");
        this.cancel = new Button(this.context);
        this.cancel.setText("Cancel");
        this.stop.setOnClickListener(new C05991());
        this.cancel.setOnClickListener(new C06002());
        this.stop.setLayoutParams(new LayoutParams(-1, -2, 0.5f));
        this.cancel.setLayoutParams(new LayoutParams(-1, -2, 0.5f));
        linearLayout.addView(this.stop);
        linearLayout.addView(this.cancel);
    }

    public static RecognizerDialog getInstance() {
        int i = 0;
        int i2 = 0;
        while (i2 == 0) {
            if (_instance == null) {
                Log.e(TAG, "Instance is Null, trying again...");
                int i3 = i + 1;
                try {
                    Thread.sleep(1000);
                    if (i3 == 8) {
                        Log.e(TAG, "Action timed out, closing dialog...");
                        if (getInstance().getOwnerActivity() != null) {
                            getInstance().getOwnerActivity().finish();
                        }
                        i = i3;
                        i2 = 1;
                    } else {
                        i = i3;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    i = i3;
                }
            } else {
                i2 = 1;
            }
        }
        return _instance;
    }

    private void initLayout() {
        new GradientDrawable(Orientation.BOTTOM_TOP, new int[]{-14540254, -7829368}).setCornerRadii(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        this.myCanvas = new DrawCanvas(this.context);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        this.text = new TextView(this.context);
        this.text.setTextColor(-1);
        this.text.setTextSize(25.0f);
        this.text.setGravity(1);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.setMargins((int) Utilities.dp2px(20.0f, this.context), 0, (int) Utilities.dp2px(20.0f, this.context), (int) Utilities.dp2px(20.0f, this.context));
        this.text.setLayoutParams(layoutParams2);
        this.ll = new LinearLayout(this.context);
        layoutParams2 = new LayoutParams((int) Utilities.dp2px(200.0f, this.context), -1);
        layoutParams2.setMargins((int) Utilities.dp2px(50.0f, this.context), (int) Utilities.dp2px(10.0f, this.context), (int) Utilities.dp2px(50.0f, this.context), (int) Utilities.dp2px(10.0f, this.context));
        this.ll.setLayoutParams(layoutParams2);
        this.ll.setGravity(17);
        this.ll.setOrientation(1);
        this.myCanvas.setId(1000);
        this.myCanvas.setBackgroundColor(0);
        this.myCanvas.setLayoutParams(new LayoutParams(200, 249));
        this.ll.addView(this.myCanvas);
        View linearLayout = new LinearLayout(this.context);
        linearLayout.setBackgroundColor(-7829368);
        linearLayout.setGravity(17);
        linearLayout.setLayoutParams(new TableLayout.LayoutParams(-1, -2));
        addCancelStopButtons(linearLayout);
        this.ll.addView(linearLayout);
        setContentView(this.ll);
        setRecording();
    }

    private void loadMicrophoneAnimationFrames() {
    }

    public void clearLayout() {
        this.ll.removeAllViews();
    }

    public void dismiss() {
        super.dismiss();
        if (getOwnerActivity() != null) {
            getOwnerActivity().finish();
        }
        dialogRunning = false;
    }

    public void fixCanvas() {
        this.refresh.post(new C06013());
    }

    public DrawCanvas getCanvas() {
        return this.myCanvas;
    }

    public boolean isDialogRunning() {
        return dialogRunning;
    }

    public void setMicrophoneLevel(int i) {
        this.myCanvas.setY(i);
    }

    public void setRecognizing() {
        this.myCanvas.setLayoutParams(new LayoutParams(200, 150));
        this.myCanvas.setProcessing();
        this.stop.setVisibility(8);
        this.cancel.setVisibility(0);
        this.cancel.setOnClickListener(new C06024());
    }

    public void setRecording() {
        this.stop.setVisibility(0);
        this.cancel.setVisibility(0);
    }

    public void startDraw() {
        this.myCanvas.m0a();
    }
}
