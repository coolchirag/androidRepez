package javax.mail;

public interface QuotaAwareStore {
    Quota[] getQuota(String str);

    void setQuota(Quota quota);
}
