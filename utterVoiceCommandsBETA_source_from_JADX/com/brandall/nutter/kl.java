package com.brandall.nutter;

import android.content.Context;
import winterwell.jtwitter.OAuthSignpostClient;
import winterwell.jtwitter.Twitter;
import winterwell.jtwitter.TwitterException;

public final class kl {
    static Twitter f1614a;

    public static boolean m1304a(Context context, String str) {
        String P = lx.m1377P(context);
        String string = context.getSharedPreferences("utterPref", 0).getString("tw_token_secret", "");
        if (P == null || string == null) {
            ls.m1347d("ExecuteTwitter tokens invalid");
            return false;
        }
        Twitter twitter = new Twitter(null, new OAuthSignpostClient("03pZjJaVqOO74I3oBaag", "vUKejSsvTadh4YsrY37EWPBgPjVlFnYyLUsXRhuYzBM", P, string));
        f1614a = twitter;
        if (twitter.isValidLogin()) {
            ls.m1346c("ExecuteTwitter isValidLogin: True");
            try {
                f1614a.setStatus(str.replaceAll("hash tags ", "\\#").replaceAll("hash tag ", "\\#").replaceAll("hashtags ", "\\#").replaceAll("hashtag ", "\\#"));
                return true;
            } catch (TwitterException e) {
                e.printStackTrace();
                return false;
            }
        }
        ls.m1347d("ExecuteTwitter isValidLogin: False");
        return false;
    }
}
