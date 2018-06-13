package android.support.v4.app;

import android.os.Handler;
import android.os.Message;

final class C0034g extends Handler {
    final /* synthetic */ FragmentActivity f125a;

    C0034g(FragmentActivity fragmentActivity) {
        this.f125a = fragmentActivity;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.f125a.f39e) {
                    this.f125a.m49a(false);
                    return;
                }
                return;
            case 2:
                this.f125a.f36b.m125i();
                this.f125a.f36b.m115b();
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
