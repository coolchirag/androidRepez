package com.brandall.nutter;

import android.content.Context;
import android.text.Html;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public final class ju {
    private static Session f1573a;
    private static Message f1574b;
    private static InternetAddress f1575c;
    private static InternetAddress f1576d;
    private static Properties f1577e;

    public static boolean m1219a(Context context, String str, String str2, String str3) {
        String Q = lx.m1378Q(context);
        String b = hm.m1124b(context.getSharedPreferences("utterPref", 0).getString("email_password", ""));
        if (b.matches("") || Q.matches("")) {
            return false;
        }
        try {
            f1577e = new Properties();
            if (Q.contains("@gmail")) {
                if (hc.f1269b) {
                    ls.m1345b("sendEmail: gmail");
                }
                f1577e.put("mail.smtp.host", "smtp.gmail.com");
                f1577e.put("mail.smtp.socketFactory.port", "465");
                f1577e.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                f1577e.put("mail.smtp.auth", "true");
                f1577e.put("mail.smtp.port", "465");
            } else if (Q.contains("@hotmail") || Q.contains("@live")) {
                if (hc.f1269b) {
                    ls.m1345b("sendEmail: hotmail/live");
                }
                f1577e.setProperty("mail.transport.protocol", "smtp");
                f1577e.setProperty("mail.host", "smtp.live.com");
                f1577e.put("mail.smtp.starttls.enable", "true");
                f1577e.put("mail.smtp.auth", "true");
                f1577e.put("mail.smtp.port", "587");
            } else if (Q.contains("@yahoo")) {
                if (hc.f1269b) {
                    ls.m1345b("sendEmail: yahoo");
                }
                f1577e.put("mail.smtp.host", "smtp.mail.yahoo.com");
                f1577e.put("mail.smtp.socketFactory.port", "465");
                f1577e.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                f1577e.put("mail.smtp.starttls.enable", "true");
                f1577e.put("mail.smtp.auth", "true");
                f1577e.put("mail.smtp.port", "465");
            }
            f1573a = Session.getDefaultInstance(f1577e, new jv(Q, b));
            f1574b = new MimeMessage(f1573a);
            f1575c = new InternetAddress(Q);
            f1576d = new InternetAddress(str);
            f1574b.setFrom(f1575c);
            f1574b.setRecipient(RecipientType.TO, f1576d);
            f1574b.setSubject(str2);
            f1574b.setContent(new StringBuilder(String.valueOf(str3)).append("\n\n").append(Html.fromHtml(lx.m1373L(context))).toString(), "text/plain");
            Transport.send(f1574b);
            if (hc.f1269b) {
                f1577e.put("mail.debug", "true");
                ls.m1345b("Mail debug: " + f1577e.toString());
            }
            return true;
        } catch (MessagingException e) {
            ls.m1348e("ExecuteGmail MessagingException");
            e.printStackTrace();
            return false;
        }
    }
}
