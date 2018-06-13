package javax.mail.internet;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class MailDateFormat extends SimpleDateFormat {
    private static Calendar cal = new GregorianCalendar(tz);
    static boolean debug = false;
    private static final long serialVersionUID = -8148227605210628779L;
    private static TimeZone tz = TimeZone.getTimeZone("GMT");

    public MailDateFormat() {
        super("EEE, d MMM yyyy HH:mm:ss 'XXXXX' (z)", Locale.US);
    }

    private static synchronized Date ourUTC(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        Date time;
        synchronized (MailDateFormat.class) {
            cal.clear();
            cal.setLenient(z);
            cal.set(1, i);
            cal.set(2, i2);
            cal.set(5, i3);
            cal.set(11, i4);
            cal.set(12, i5 + i7);
            cal.set(13, i6);
            time = cal.getTime();
        }
        return time;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Date parseDate(char[] r11, java.text.ParsePosition r12, boolean r13) {
        /*
        r6 = 0;
        r7 = new javax.mail.internet.MailDateParser;	 Catch:{ Exception -> 0x008d }
        r7.<init>(r11);	 Catch:{ Exception -> 0x008d }
        r7.skipUntilNumber();	 Catch:{ Exception -> 0x008d }
        r2 = r7.parseNumber();	 Catch:{ Exception -> 0x008d }
        r0 = 45;
        r0 = r7.skipIfChar(r0);	 Catch:{ Exception -> 0x008d }
        if (r0 != 0) goto L_0x0018;
    L_0x0015:
        r7.skipWhiteSpace();	 Catch:{ Exception -> 0x008d }
    L_0x0018:
        r1 = r7.parseMonth();	 Catch:{ Exception -> 0x008d }
        r0 = 45;
        r0 = r7.skipIfChar(r0);	 Catch:{ Exception -> 0x008d }
        if (r0 != 0) goto L_0x0027;
    L_0x0024:
        r7.skipWhiteSpace();	 Catch:{ Exception -> 0x008d }
    L_0x0027:
        r0 = r7.parseNumber();	 Catch:{ Exception -> 0x008d }
        r3 = 50;
        if (r0 >= r3) goto L_0x0061;
    L_0x002f:
        r0 = r0 + 2000;
    L_0x0031:
        r7.skipWhiteSpace();	 Catch:{ Exception -> 0x008d }
        r3 = r7.parseNumber();	 Catch:{ Exception -> 0x008d }
        r4 = 58;
        r7.skipChar(r4);	 Catch:{ Exception -> 0x008d }
        r4 = r7.parseNumber();	 Catch:{ Exception -> 0x008d }
        r5 = 58;
        r5 = r7.skipIfChar(r5);	 Catch:{ Exception -> 0x008d }
        if (r5 == 0) goto L_0x00ba;
    L_0x0049:
        r5 = r7.parseNumber();	 Catch:{ Exception -> 0x008d }
    L_0x004d:
        r7.skipWhiteSpace();	 Catch:{ ParseException -> 0x0068 }
        r6 = r7.parseTimeZone();	 Catch:{ ParseException -> 0x0068 }
    L_0x0054:
        r7 = r7.getIndex();	 Catch:{ Exception -> 0x008d }
        r12.setIndex(r7);	 Catch:{ Exception -> 0x008d }
        r7 = r13;
        r0 = ourUTC(r0, r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x008d }
    L_0x0060:
        return r0;
    L_0x0061:
        r3 = 100;
        if (r0 >= r3) goto L_0x0031;
    L_0x0065:
        r0 = r0 + 1900;
        goto L_0x0031;
    L_0x0068:
        r8 = move-exception;
        r8 = debug;	 Catch:{ Exception -> 0x008d }
        if (r8 == 0) goto L_0x0054;
    L_0x006d:
        r8 = java.lang.System.out;	 Catch:{ Exception -> 0x008d }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x008d }
        r10 = "No timezone? : '";
        r9.<init>(r10);	 Catch:{ Exception -> 0x008d }
        r10 = new java.lang.String;	 Catch:{ Exception -> 0x008d }
        r10.<init>(r11);	 Catch:{ Exception -> 0x008d }
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x008d }
        r10 = "'";
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x008d }
        r9 = r9.toString();	 Catch:{ Exception -> 0x008d }
        r8.println(r9);	 Catch:{ Exception -> 0x008d }
        goto L_0x0054;
    L_0x008d:
        r0 = move-exception;
        r1 = debug;
        if (r1 == 0) goto L_0x00b4;
    L_0x0092:
        r1 = java.lang.System.out;
        r2 = new java.lang.StringBuilder;
        r3 = "Bad date: '";
        r2.<init>(r3);
        r3 = new java.lang.String;
        r3.<init>(r11);
        r2 = r2.append(r3);
        r3 = "'";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.println(r2);
        r0.printStackTrace();
    L_0x00b4:
        r0 = 1;
        r12.setIndex(r0);
        r0 = 0;
        goto L_0x0060;
    L_0x00ba:
        r5 = r6;
        goto L_0x004d;
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MailDateFormat.parseDate(char[], java.text.ParsePosition, boolean):java.util.Date");
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        int i;
        int length = stringBuffer.length();
        super.format(date, stringBuffer, fieldPosition);
        length += 25;
        while (stringBuffer.charAt(length) != 'X') {
            length++;
        }
        this.calendar.clear();
        this.calendar.setTime(date);
        int i2 = this.calendar.get(16) + this.calendar.get(15);
        if (i2 < 0) {
            i = length + 1;
            stringBuffer.setCharAt(length, '-');
            int i3 = i;
            i = -i2;
            length = i3;
        } else {
            i = length + 1;
            stringBuffer.setCharAt(length, '+');
            length = i;
            i = i2;
        }
        i = (i / 60) / 1000;
        i2 = i / 60;
        i %= 60;
        int i4 = length + 1;
        stringBuffer.setCharAt(length, Character.forDigit(i2 / 10, 10));
        length = i4 + 1;
        stringBuffer.setCharAt(i4, Character.forDigit(i2 % 10, 10));
        i2 = length + 1;
        stringBuffer.setCharAt(length, Character.forDigit(i / 10, 10));
        stringBuffer.setCharAt(i2, Character.forDigit(i % 10, 10));
        return stringBuffer;
    }

    public Date parse(String str, ParsePosition parsePosition) {
        return parseDate(str.toCharArray(), parsePosition, isLenient());
    }

    public void setCalendar(Calendar calendar) {
        throw new RuntimeException("Method setCalendar() shouldn't be called");
    }

    public void setNumberFormat(NumberFormat numberFormat) {
        throw new RuntimeException("Method setNumberFormat() shouldn't be called");
    }
}
