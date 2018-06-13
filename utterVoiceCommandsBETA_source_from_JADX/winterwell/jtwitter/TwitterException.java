package winterwell.jtwitter;

import java.io.IOException;
import java.text.ParseException;
import winterwell.json.JSONException;

public class TwitterException extends RuntimeException {
    static final /* synthetic */ boolean $assertionsDisabled = (!TwitterException.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final long serialVersionUID = 1;
    private String additionalInfo;

    public class E40X extends TwitterException {
        private static final long serialVersionUID = 1;

        public E40X(String str) {
            super(str);
        }
    }

    public class E401 extends E40X {
        private static final long serialVersionUID = 1;

        public E401(String str) {
            super(str);
        }
    }

    public class AccessLevel extends E401 {
        private static final long serialVersionUID = 1;

        public AccessLevel(String str) {
            super(str);
        }
    }

    public class E403 extends E40X {
        private static final long serialVersionUID = 1;

        public E403(String str) {
            super(str);
        }
    }

    public class BadParameter extends E403 {
        private static final long serialVersionUID = 1;

        public BadParameter(String str) {
            super(str);
        }
    }

    public class E404 extends E40X {
        private static final long serialVersionUID = 1;

        public E404(String str) {
            super(str);
        }
    }

    public class E406 extends E40X {
        private static final long serialVersionUID = 1;

        public E406(String str) {
            super(str);
        }
    }

    public class E413 extends E40X {
        private static final long serialVersionUID = 1;

        public E413(String str) {
            super(str);
        }
    }

    public class E416 extends E40X {
        private static final long serialVersionUID = 1;

        public E416(String str) {
            super(str);
        }
    }

    public class E50X extends TwitterException {
        private static final long serialVersionUID = 1;

        public E50X(String str) {
            super(msg(str));
        }

        static String msg(String str) {
            if (str == null) {
                return null;
            }
            String replaceAll = InternalUtils.TAG_REGEX.matcher(str).replaceAll("").replaceAll("\\s+", " ");
            return replaceAll.length() > 280 ? replaceAll.substring(0, 280) + "..." : replaceAll;
        }
    }

    public class FollowerLimit extends E403 {
        private static final long serialVersionUID = 1;

        public FollowerLimit(String str) {
            super(str);
        }
    }

    public class IO extends TwitterException {
        private static final long serialVersionUID = 1;

        public IO(IOException iOException) {
            super((Exception) iOException);
        }

        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    public class Parsing extends TwitterException {
        private static final long serialVersionUID = 1;

        public Parsing(String str, ParseException parseException) {
            super(str, (Exception) parseException);
        }

        public Parsing(String str, JSONException jSONException) {
            super(new StringBuilder(String.valueOf(str == null ? String.valueOf(jSONException) : clip(str, 280))).append(causeLine(jSONException)).toString(), (Exception) jSONException);
        }

        private static String causeLine(JSONException jSONException) {
            if (jSONException == null) {
                return "";
            }
            for (StackTraceElement stackTraceElement : jSONException.getStackTrace()) {
                if (!stackTraceElement.getClassName().contains("JSON")) {
                    return " caused by " + stackTraceElement;
                }
            }
            return "";
        }

        private static String clip(String str, int i) {
            return str == null ? null : str.length() > i ? str.substring(0, i) + "..." : str;
        }
    }

    public class RateLimit extends TwitterException {
        private static final long serialVersionUID = 1;

        public RateLimit(String str) {
            super(str);
        }
    }

    public class Repetition extends E403 {
        private static final long serialVersionUID = 1;

        public Repetition(String str) {
            super("Already tweeted! " + str);
        }
    }

    public class SuspendedUser extends E403 {
        private static final long serialVersionUID = 1;

        SuspendedUser(String str) {
            super(str);
        }
    }

    public class Timeout extends E50X {
        private static final long serialVersionUID = 1;

        public Timeout(String str) {
            super(str);
        }
    }

    public class TooManyLogins extends E40X {
        private static final long serialVersionUID = 1;

        public TooManyLogins(String str) {
            super(str);
        }
    }

    public class TooRecent extends E403 {
        private static final long serialVersionUID = 1;

        TooRecent(String str) {
            super(str);
        }
    }

    public class TwitLongerException extends TwitterException {
        private static final long serialVersionUID = 1;

        public TwitLongerException(String str, String str2) {
            super(str, str2);
        }
    }

    public class Unexplained extends TwitterException {
        private static final long serialVersionUID = 1;

        public Unexplained(String str) {
            super(str);
        }
    }

    public class UpdateToOAuth extends E401 {
        private static final long serialVersionUID = 1;

        public UpdateToOAuth() {
            super("You need to switch to OAuth. Twitter no longer support basic authentication.");
        }
    }

    TwitterException(Exception exception) {
        super(exception);
        this.additionalInfo = "";
        if (!$assertionsDisabled && (exception instanceof TwitterException)) {
            throw new AssertionError(exception);
        }
    }

    public TwitterException(String str) {
        super(str);
        this.additionalInfo = "";
    }

    TwitterException(String str, Exception exception) {
        super(str, exception);
        this.additionalInfo = "";
        if (!$assertionsDisabled && (exception instanceof TwitterException)) {
            throw new AssertionError(exception);
        }
    }

    public TwitterException(String str, String str2) {
        this(str);
        setAdditionalInfo(str2);
    }

    public String getAdditionalInfo() {
        return this.additionalInfo;
    }

    public void setAdditionalInfo(String str) {
        this.additionalInfo = str;
    }
}
