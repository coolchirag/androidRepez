package p000a.p001a.p004b;

public final class C0012a extends C0011b {
    private String f20a;

    public C0012a(Exception exception) {
        super("Communication with the service provider failed: " + exception.getLocalizedMessage(), exception);
    }

    public C0012a(String str, String str2) {
        super(str);
        this.f20a = str2;
    }
}
