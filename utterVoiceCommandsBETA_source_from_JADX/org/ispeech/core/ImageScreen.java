package org.ispeech.core;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.Toast;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ImageScreen extends Dialog {
    private static final String TAG = "ImageScreen";
    private Button btnDismiss;
    private String curl;
    private Thread downloadThread = new C05984();
    private Handler f3120h;
    private int imageHeight;
    private int imageWidth;
    private ImageView imgBanner;
    private ProgressDialog pd;
    private String url;

    class C05951 implements OnClickListener {
        C05951() {
        }

        public void onClick(View view) {
            ImageScreen.this.dismiss();
        }
    }

    class C05962 implements OnClickListener {
        C05962() {
        }

        public void onClick(View view) {
            ImageScreen.this.dismiss();
            ImageScreen.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(ImageScreen.this.curl)));
        }
    }

    class C05984 extends Thread {
        C05984() {
        }

        public void run() {
            ImageScreen.this.downloadImage();
        }
    }

    public ImageScreen(final Context context, String str, String str2, int i, int i2) {
        super(context, 16973830);
        this.btnDismiss = new Button(context);
        this.imgBanner = new ImageView(context);
        this.url = str;
        this.imageHeight = i2;
        this.imageWidth = i;
        this.curl = str2;
        this.f3120h = new Handler(context.getMainLooper()) {
            public void handleMessage(Message message) {
                if (message.what == 0) {
                    ImageScreen.this.pd.dismiss();
                    ImageScreen.this.btnDismiss.setText(InternalResources.stringDismiss);
                    ImageScreen.this.imgBanner.setScaleType(ScaleType.FIT_CENTER);
                    Display defaultDisplay = ((WindowManager) ImageScreen.this.getContext().getSystemService("window")).getDefaultDisplay();
                    ImageScreen.this.imgBanner.setLayoutParams(new LayoutParams(Math.min(ImageScreen.this.imageWidth, defaultDisplay.getWidth()), Math.min(ImageScreen.this.imageHeight, defaultDisplay.getHeight() - 100)));
                    ImageScreen.this.create(context);
                    ImageScreen.this.show();
                } else if (message.what == -1) {
                    ImageScreen.this.pd = ProgressDialog.show(context, null, InternalResources.stringPleaseWait);
                    ImageScreen.this.pd.setCancelable(false);
                } else {
                    ImageScreen.this.pd.dismiss();
                    Toast.makeText(ImageScreen.this.getContext(), "Could not download image", 1).show();
                    ImageScreen.this.dismiss();
                }
            }
        };
        this.f3120h.sendEmptyMessage(-1);
        this.downloadThread.start();
    }

    private void create(Context context) {
        View linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LayoutParams(-1, -1));
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(10, 10, 10, 10);
        View scrollView = new ScrollView(context);
        scrollView.setLayoutParams(new LayoutParams(-1, -1));
        linearLayout.addView(this.imgBanner);
        linearLayout.addView(this.btnDismiss);
        setTitle("Cali");
        scrollView.addView(linearLayout);
        setContentView(scrollView);
        this.btnDismiss.setOnClickListener(new C05951());
        this.imgBanner.setOnClickListener(new C05962());
    }

    private void downloadImage() {
        try {
            this.imgBanner.setImageDrawable(Drawable.createFromStream(new DefaultHttpClient().execute(new HttpGet(this.url)).getEntity().getContent(), this.url));
            if (this.imgBanner.getDrawable() != null) {
                this.f3120h.sendEmptyMessage(0);
                return;
            }
        } catch (Throwable e) {
            Log.e(TAG, "Not enough memory for image download.", e);
        } catch (Throwable e2) {
            Log.e(TAG, "Not enough memory for image download.", e2);
        }
        this.f3120h.sendEmptyMessage(1);
    }

    public void dismiss() {
        if (getOwnerActivity() != null) {
            getOwnerActivity().finish();
        }
        super.dismiss();
    }
}
