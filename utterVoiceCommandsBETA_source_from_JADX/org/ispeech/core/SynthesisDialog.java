package org.ispeech.core;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class SynthesisDialog extends Dialog {
    private static Bitmap[] animationFrames = null;
    private static final int animationMaxLevel = 4;
    private static SynthesisDialog instance = null;
    private static Bitmap logo;
    private ImageView animation;
    private AnimationDrawable animationDrawable;
    private Button cancel;
    Context context;
    private final float scale;
    Handler startAnimation = new C06031();
    private Button stop;
    private TextView text;
    private ImageView title;

    class C06031 extends Handler {
        C06031() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            ((AnimationDrawable) SynthesisDialog.this.animation.getBackground()).start();
        }
    }

    public SynthesisDialog(Context context) {
        int i = 0;
        super(context);
        requestWindowFeature(1);
        setCancelable(false);
        this.context = context;
        this.scale = context.getResources().getDisplayMetrics().density;
        if (logo == null) {
            logo = BitmapFactory.decodeStream(SynthesisDialog.class.getClassLoader().getResourceAsStream("org/ispeech/raw/logo.png"));
            logo = Bitmap.createScaledBitmap(logo, (int) dp2px(44.0f), (int) dp2px(18.0f), true);
        }
        this.animationDrawable = new AnimationDrawable();
        this.animationDrawable.setOneShot(false);
        if (animationFrames == null) {
            animationFrames = new Bitmap[5];
            while (i <= 4) {
                animationFrames[i] = BitmapFactory.decodeStream(SynthesisDialog.class.getClassLoader().getResourceAsStream("org/ispeech/raw/mic_" + i + ".png"));
                animationFrames[i] = Bitmap.createScaledBitmap(animationFrames[i], (int) dp2px(32.0f), (int) dp2px(64.0f), true);
                this.animationDrawable.addFrame(new BitmapDrawable(animationFrames[i]), 500);
                i++;
            }
        }
        initLayout();
    }

    private float dp2px(float f) {
        return (this.scale * f) + 0.5f;
    }

    public static SynthesisDialog getInstance() {
        return instance;
    }

    private void initLayout() {
        Drawable gradientDrawable = new GradientDrawable(Orientation.BOTTOM_TOP, new int[]{-14540254, -7829368});
        gradientDrawable.setCornerRadii(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        this.title = new ImageView(this.context);
        this.title.setImageBitmap(logo);
        this.title.setScaleType(ScaleType.CENTER_INSIDE);
        View linearLayout = new LinearLayout(this.context);
        linearLayout.setGravity(17);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.setPadding(0, (int) dp2px(2.0f), 0, (int) dp2px(2.0f));
        linearLayout.setBackgroundDrawable(gradientDrawable);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.addView(this.title);
        this.stop = new Button(this.context);
        this.stop.setText("Stop");
        this.cancel = new Button(this.context);
        this.cancel.setText("Cancel");
        this.animation = new ImageView(this.context);
        this.animation.setBackgroundDrawable(this.animationDrawable);
        this.animation.setScaleType(ScaleType.CENTER_INSIDE);
        View linearLayout2 = new LinearLayout(this.context);
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, (int) dp2px(10.0f), 0, (int) dp2px(10.0f));
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.addView(this.animation);
        this.text = new TextView(this.context);
        this.text.setTextColor(-1);
        this.text.setTextSize(25.0f);
        this.text.setGravity(1);
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins((int) dp2px(20.0f), 0, (int) dp2px(20.0f), (int) dp2px(20.0f));
        this.text.setLayoutParams(layoutParams);
        View linearLayout3 = new LinearLayout(this.context);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams((int) dp2px(200.0f), -1);
        layoutParams2.setMargins((int) dp2px(50.0f), (int) dp2px(10.0f), (int) dp2px(50.0f), (int) dp2px(10.0f));
        linearLayout3.setLayoutParams(layoutParams2);
        linearLayout3.setGravity(17);
        linearLayout3.setOrientation(1);
        linearLayout3.addView(linearLayout);
        linearLayout3.addView(linearLayout2);
        linearLayout3.addView(this.text);
        linearLayout2 = new LinearLayout(this.context);
        linearLayout2.setBackgroundColor(-7829368);
        linearLayout2.setGravity(17);
        linearLayout2.setLayoutParams(new TableLayout.LayoutParams(-1, -2));
        this.stop.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 0.5f));
        this.cancel.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 0.5f));
        linearLayout2.addView(this.stop);
        linearLayout2.addView(this.cancel);
        linearLayout3.addView(linearLayout2);
        setContentView(linearLayout3);
    }

    public static SynthesisDialog newInstance(Context context) {
        SynthesisDialog synthesisDialog = new SynthesisDialog(context);
        instance = synthesisDialog;
        return synthesisDialog;
    }

    public void dismiss() {
        if (getOwnerActivity() != null) {
            getOwnerActivity().finish();
        }
        super.dismiss();
    }

    public Button getCancel() {
        return this.cancel;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ((AnimationDrawable) this.animation.getBackground()).start();
    }

    public void setOnCancelClickListener(OnClickListener onClickListener) {
        this.cancel.setOnClickListener(onClickListener);
    }

    public void setOnStopClickListener(OnClickListener onClickListener) {
        this.stop.setOnClickListener(onClickListener);
    }
}
