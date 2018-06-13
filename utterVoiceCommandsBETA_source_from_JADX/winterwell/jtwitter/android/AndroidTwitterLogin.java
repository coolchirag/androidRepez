package winterwell.jtwitter.android;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import winterwell.jtwitter.OAuthSignpostClient;
import winterwell.jtwitter.Twitter;

public abstract class AndroidTwitterLogin {
    private String callbackUrl = "http://someurl.com";
    OAuthSignpostClient client = new OAuthSignpostClient(this.consumerKey, this.consumerSecret, this.callbackUrl);
    private String consumerKey;
    private String consumerSecret;
    private Activity context;

    class C06292 implements OnTouchListener {
        C06292() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if ((motionEvent.getAction() == 0 || motionEvent.getAction() == 1) && !view.hasFocus()) {
                view.requestFocus();
            }
            return false;
        }
    }

    public AndroidTwitterLogin(Activity activity, String str, String str2, String str3) {
        this.context = activity;
        this.consumerKey = str;
        this.consumerSecret = str2;
    }

    protected void onFail(Exception exception) {
        Log.w("jtwitter", exception.toString());
    }

    protected abstract void onSuccess(Twitter twitter, String[] strArr);

    public final void run() {
        final View webView = new WebView(this.context);
        webView.setBackgroundColor(-16777216);
        webView.setVisibility(0);
        final Dialog dialog = new Dialog(this.context, 16973834);
        dialog.setContentView(webView);
        dialog.show();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView webView, String str) {
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (str.contains(AndroidTwitterLogin.this.callbackUrl)) {
                    String queryParameter = Uri.parse(str).getQueryParameter("oauth_verifier");
                    if (queryParameter == null) {
                        dialog.dismiss();
                        AndroidTwitterLogin.this.onFail(new Exception(str));
                        return;
                    }
                    AndroidTwitterLogin.this.client.setAuthorizationCode(queryParameter);
                    String[] accessToken = AndroidTwitterLogin.this.client.getAccessToken();
                    Twitter twitter = new Twitter(null, AndroidTwitterLogin.this.client);
                    dialog.dismiss();
                    AndroidTwitterLogin.this.onSuccess(twitter, accessToken);
                }
            }
        });
        webView.requestFocus(130);
        webView.setOnTouchListener(new C06292());
        new Handler().postDelayed(new Runnable() {
            public void run() {
                try {
                    webView.loadUrl(AndroidTwitterLogin.this.client.authorizeUrl().toString());
                } catch (Exception e) {
                    AndroidTwitterLogin.this.onFail(e);
                }
            }
        }, 10);
    }
}
