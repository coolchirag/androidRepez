package winterwell.jtwitter;

import java.util.Date;

public final class RateLimit {
    private String limit;
    private String remaining;
    private String reset;

    public RateLimit(String str, String str2, String str3) {
        this.limit = str;
        this.remaining = str2;
        this.reset = str3;
    }

    public final int getLimit() {
        return Integer.valueOf(this.limit).intValue();
    }

    public final int getRemaining() {
        return Integer.valueOf(this.remaining).intValue();
    }

    public final Date getReset() {
        return InternalUtils.parseDate(this.reset);
    }

    public final boolean isOutOfDate() {
        return getReset().getTime() < System.currentTimeMillis();
    }

    public final String toString() {
        return this.remaining;
    }

    public final void waitForReset() {
        Long valueOf = Long.valueOf(this.reset);
        long longValue = valueOf.longValue() - System.currentTimeMillis();
        if (longValue >= 0) {
            try {
                Thread.sleep(longValue);
            } catch (Exception e) {
                throw new TwitterException(e);
            }
        }
    }
}
