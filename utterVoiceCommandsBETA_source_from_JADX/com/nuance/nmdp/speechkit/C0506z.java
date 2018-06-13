package com.nuance.nmdp.speechkit;

public final class C0506z extends C0376r {
    public C0506z(C0387s c0387s) {
        super(c0387s);
    }

    private void m2655c(String str) {
        C0478j.m2564a(this, str);
        m2656g();
    }

    private void m2656g() {
        this.a.m1977a(new C0503w(this.a));
    }

    public final void mo189a() {
        try {
            this.a.m1984d();
            this.a.m1978a("PING");
            this.a.m1986f();
        } catch (Throwable th) {
            C0478j.m2565a(this, "Error starting PingingState", th);
            m2656g();
        }
    }

    protected final void mo178a(int i, String str, String str2) {
        m2655c(str);
    }

    public final void mo203a(dp dpVar) {
        m2656g();
    }

    public final void mo185a(String str) {
        m2655c("Query error");
    }

    public final void mo186b(String str) {
        m2655c("Query retry");
    }

    public final void mo192d() {
        m2656g();
    }

    public final void mo187e() {
        m2655c("Create command failed");
    }

    public final void mo188f() {
        m2655c("Command event");
    }
}
