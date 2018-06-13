package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.bi.C0378j;
import com.nuance.nmdp.speechkit.bi.C0404a;
import com.nuance.nmdp.speechkit.bi.C0405b;
import com.nuance.nmdp.speechkit.bi.C0407d;
import com.nuance.nmdp.speechkit.bi.C0408e;
import com.nuance.nmdp.speechkit.bi.C0409f;
import com.nuance.nmdp.speechkit.bi.C0410g;
import com.nuance.nmdp.speechkit.bi.C0411h;
import com.nuance.nmdp.speechkit.bi.C0412i;
import com.nuance.nmdp.speechkit.bi.C0414l;
import com.nuance.nmdp.speechkit.bi.C0415m;
import com.nuance.nmdp.speechkit.bk.C0416a;
import com.nuance.nmdp.speechkit.bk.C0417b;
import com.nuance.nmdp.speechkit.cb.C0445a;
import com.nuance.nmsp.client.sdk.oem.AudioSystemOEM;
import com.nuance.nmsp.client.sdk.oem.AudioSystemOEM.C0509c;
import java.util.Enumeration;
import java.util.Vector;

public class cg implements C0404a, C0407d, C0408e, C0409f, C0410g, C0378j, C0414l, C0415m, C0417b, bx {
    private static final bj f2587a = C0478j.m2563a(cg.class);
    private bh f2588b;
    private bi f2589c;
    private bw f2590d;
    private bk f2591e = null;
    private bz f2592f;
    private int f2593g;
    private bn f2594h;
    private boolean f2595i = false;
    private boolean f2596j = false;
    private boolean f2597k = false;
    private C0411h f2598l;
    private Vector f2599m;
    private int f2600n = -1;

    final class C0446a implements bn {
        private /* synthetic */ cg f2586a;

        C0446a(cg cgVar) {
            this.f2586a = cgVar;
        }

        public final void run() {
            this.f2586a.f2594h = null;
            if (this.f2586a.f2596j) {
                this.f2586a.m2260a(true);
            } else {
                this.f2586a.m2250b(true);
            }
        }
    }

    public cg(bw bwVar, ch chVar, Vector vector, bf bfVar) {
        m2248a(vector);
        this.f2590d = bwVar;
        this.f2588b = ((cn) chVar).m2232e();
        this.f2594h = null;
        this.f2591e = ((cn) chVar).m2226a();
        this.f2599m = vector;
        this.f2595i = m2249a(vector, "ep.enable");
        this.f2596j = m2249a(vector, "NMSP_DEFINES_RECORDER_CONTINUES_ON_ENDPOINTER_AND_TIMER_STOPPING");
        this.f2597k = m2249a(vector, "NMSP_DEFINES_CAPTURING_CONTINUES_ON_ENDPOINTER");
        this.f2589c = new AudioSystemOEM(this.f2591e, this.f2588b, vector);
        if (bfVar.equals(bf.f2448c)) {
            this.f2598l = C0411h.f2468c;
        } else if (bfVar.equals(bf.f2446a)) {
            this.f2598l = C0411h.f2466a;
        } else if (bfVar.equals(bf.f2447b)) {
            this.f2598l = C0411h.f2467b;
        } else if (bfVar.equals(bf.f2449d)) {
            this.f2598l = C0411h.f2469d;
        }
        this.f2600n = 0;
    }

    private void m2246a(bz bzVar, int i) {
        if (f2587a.mo317b()) {
            f2587a.mo316b("RecorderImpl.handleStartRecording(" + bzVar + ") _state:" + this.f2600n);
        }
        if (new C0509c(this.f2599m).m2665a()) {
            this.f2588b = bu.m2187c(this.f2588b);
        }
        this.f2593g = i;
        if (this.f2600n == 0) {
            this.f2592f = bzVar;
            bi biVar = this.f2589c;
            C0411h c0411h = this.f2598l;
            boolean z = this.f2595i && bzVar != null;
            if (biVar.mo308a(c0411h, z, this, this, this, this, this, this, this)) {
                if (this.f2595i) {
                    if (bzVar == null) {
                        this.f2600n = 1;
                    } else {
                        this.f2600n = 2;
                    }
                } else if (bzVar == null) {
                    this.f2600n = 1;
                } else {
                    m2253h();
                    this.f2600n = 4;
                }
                m2247a("STARTED", null);
                return;
            }
            if (f2587a.mo323e()) {
                f2587a.mo322e("RecorderImpl.handleStartRecording() startRecording() failed!!!");
            }
            this.f2600n = 8;
            m2247a("RECORD_ERROR", null);
        }
    }

    private void m2247a(String str, Object obj) {
        if (this.f2590d != null) {
            try {
                this.f2590d.mo220a(this, str, obj);
            } catch (Throwable th) {
                if (f2587a.mo323e()) {
                    f2587a.mo322e("Got an exp while calling NMSPAudioRecordListener.recorderUpdate(" + str + ", " + obj + ")[" + th.getClass().getName() + "] msg [" + th.getMessage() + "]");
                }
            }
        }
    }

    private static void m2248a(Vector vector) {
        if (vector != null) {
            Enumeration elements = vector.elements();
            while (elements.hasMoreElements()) {
                cb cbVar = (cb) elements.nextElement();
                if (cbVar.m2237d() != C0445a.f2559a) {
                    throw new IllegalArgumentException("Parameter type: " + cbVar.m2237d() + " not allowed. ");
                }
            }
        }
    }

    private static boolean m2249a(Vector vector, String str) {
        if (vector != null) {
            Enumeration elements = vector.elements();
            while (elements.hasMoreElements()) {
                cb cbVar = (cb) elements.nextElement();
                if (cbVar.m2237d() == C0445a.f2559a && cbVar.m2234a().equals(str)) {
                    return new String(cbVar.m2235b()).equals("TRUE");
                }
            }
        }
        return false;
    }

    private void m2250b(boolean z) {
        if (f2587a.mo317b()) {
            f2587a.mo316b("RecorderImpl.handleStopRecording() _state:" + this.f2600n);
        }
        if (this.f2600n == 2 || this.f2600n == 4 || this.f2600n == 5) {
            if (z) {
                m2247a("CAPTURE_TIMEOUT", null);
            }
            if (this.f2600n == 4) {
                m2254i();
            }
            this.f2589c.mo306a((C0415m) this);
            this.f2600n = 9;
        } else if (this.f2600n == 1 || this.f2600n == 3 || this.f2600n == 6) {
            this.f2589c.mo306a((C0415m) this);
            this.f2600n = 7;
        }
    }

    private void m2253h() {
        if (this.f2593g > 0) {
            this.f2594h = new C0446a(this);
            this.f2591e.mo326a(this.f2594h, (long) this.f2593g);
        }
    }

    private void m2254i() {
        if (this.f2594h != null) {
            this.f2591e.mo328a(this.f2594h);
            this.f2594h = null;
        }
    }

    private void m2255j() {
        try {
            this.f2592f.mo219a(null, 0, 0, true);
        } catch (ce e) {
            if (f2587a.mo321d()) {
                f2587a.mo322e("RecorderImpl.finishAudioSink() TransactionProcessingException:" + e);
            }
        }
        if (f2587a.mo317b()) {
            f2587a.mo316b((Object) "RecorderImpl::finishAudioSink send the last audio buffer from recorder");
        }
    }

    public final void mo230a() {
        if (f2587a.mo317b()) {
            f2587a.mo316b("RecorderImpl::endOfSpeechCallback() _state:" + this.f2600n);
        }
        if (this.f2600n == 4) {
            m2247a("END_OF_SPEECH", null);
            if (!this.f2597k) {
                m2260a(false);
            }
        }
    }

    public final void mo227a(C0405b c0405b) {
        if (f2587a.mo317b()) {
            f2587a.mo316b("RecorderImpl.stopCallback() _state:" + this.f2600n);
        }
        if (this.f2600n == 1 || this.f2600n == 3 || this.f2600n == 6 || this.f2600n == 7) {
            m2247a("STOPPED", null);
            this.f2600n = 8;
        } else if (this.f2600n == 2 || this.f2600n == 4 || this.f2600n == 5 || this.f2600n == 9) {
            if (this.f2600n == 4) {
                m2254i();
            }
            m2255j();
            m2247a("STOPPED", null);
            this.f2600n = 8;
        }
    }

    public final void mo231a(bz bzVar) {
        if (f2587a.mo317b()) {
            f2587a.mo316b("RecorderImpl.startCapturing(" + bzVar + ")");
        }
        if (bzVar == null) {
            throw new IllegalArgumentException("audioSink cannot be null.");
        }
        bk bkVar = this.f2591e;
        C0416a c0416a = new C0416a((byte) 4, new Object[]{bzVar, new Integer(60000)});
        Thread currentThread = Thread.currentThread();
        this.f2591e.mo329a();
        bkVar.mo327a(c0416a, this, currentThread);
    }

    public final void mo225a(Object obj, Object obj2) {
        C0416a c0416a = (C0416a) obj;
        Object[] objArr;
        switch (c0416a.f2477a) {
            case (byte) 1:
                m2246a(null, 0);
                return;
            case (byte) 2:
                objArr = (Object[]) c0416a.f2478b;
                m2246a((bz) objArr[0], ((Integer) objArr[1]).intValue());
                return;
            case (byte) 3:
                m2250b(false);
                return;
            case (byte) 4:
                objArr = (Object[]) c0416a.f2478b;
                bz bzVar = (bz) objArr[0];
                int intValue = ((Integer) objArr[1]).intValue();
                if (f2587a.mo317b()) {
                    f2587a.mo316b("RecorderImpl.handleStartCapturing(" + bzVar + ") _state:" + this.f2600n);
                }
                this.f2593g = intValue;
                this.f2592f = bzVar;
                if (this.f2600n == 1) {
                    if (this.f2595i) {
                        this.f2589c.mo304a((C0408e) this);
                        this.f2600n = 2;
                        return;
                    }
                    m2253h();
                    this.f2600n = 4;
                    return;
                } else if (this.f2600n == 3) {
                    this.f2600n = 2;
                    return;
                } else if (this.f2600n == 6) {
                    this.f2600n = 5;
                    return;
                } else {
                    return;
                }
            case (byte) 5:
                m2260a(false);
                return;
            default:
                return;
        }
    }

    public final void m2260a(boolean z) {
        if (f2587a.mo317b()) {
            f2587a.mo316b("RecorderImpl.handleStopCapturing() _state:" + this.f2600n);
        }
        if (this.f2600n == 2) {
            m2255j();
            if (z) {
                m2247a("CAPTURE_TIMEOUT", null);
            }
            this.f2600n = 3;
        } else if (this.f2600n == 4) {
            m2255j();
            if (z) {
                m2247a("CAPTURE_TIMEOUT", null);
            }
            if (this.f2600n == 4) {
                m2254i();
            }
            if (this.f2595i) {
                this.f2589c.mo305a((C0409f) this);
                this.f2600n = 6;
                return;
            }
            this.f2600n = 1;
        } else if (this.f2600n == 5) {
            m2255j();
            this.f2600n = 6;
        }
    }

    public final void mo229a(byte[] bArr, Object obj, C0412i c0412i, C0412i c0412i2, Float f) {
        int i = 0;
        if (f2587a.mo317b()) {
            f2587a.mo316b("RecorderImpl.audioCallback() _state:" + this.f2600n);
        }
        if (this.f2600n == 4) {
            byte[] bArr2;
            bh bhVar = this.f2588b;
            bu.m2183a();
            if (bu.m2186b(this.f2588b)) {
                bArr2 = (byte[]) obj;
                i = c0412i2.f2470a;
            } else if (bu.m2184a(this.f2588b)) {
                i = c0412i.f2470a;
                bArr2 = bArr;
            } else {
                bArr2 = null;
            }
            if (f2587a.mo317b()) {
                f2587a.mo316b("========================= Recorder::audioCallback len[" + i + "] ======================");
            }
            try {
                this.f2592f.mo219a(bArr2, 0, i, false);
            } catch (ce e) {
                if (f2587a.mo321d()) {
                    f2587a.mo320d("RecorderImpl.audioCallback() TransactionProcessingException:" + e);
                }
            }
            m2247a("BUFFER_RECORDED", (Object) f);
        }
    }

    public final void mo232b() {
        if (f2587a.mo317b()) {
            f2587a.mo316b("RecorderImpl::endPointerStartedCallback() _state:" + this.f2600n);
        }
        if (this.f2600n == 2) {
            m2253h();
            this.f2600n = 4;
        } else if (this.f2600n == 3) {
            this.f2589c.mo305a((C0409f) this);
            this.f2600n = 6;
        }
    }

    public final void mo233c() {
        if (f2587a.mo317b()) {
            f2587a.mo316b("RecorderImpl::endPointerStoppedCallback() _state:" + this.f2600n);
        }
        if (this.f2600n == 5) {
            this.f2589c.mo304a((C0408e) this);
            this.f2600n = 2;
        } else if (this.f2600n == 6) {
            this.f2600n = 1;
        }
    }

    public final void mo234d() {
        if (f2587a.mo317b()) {
            f2587a.mo316b("RecorderImpl.errorCallback() _state:" + this.f2600n);
        }
        if (this.f2600n == 1 || this.f2600n == 2 || this.f2600n == 3 || this.f2600n == 4 || this.f2600n == 5 || this.f2600n == 6) {
            if (this.f2600n == 4) {
                m2254i();
            }
            m2247a("RECORD_ERROR", null);
            this.f2600n = 7;
        }
    }

    public final void mo235e() {
        if (f2587a.mo317b()) {
            f2587a.mo316b("RecorderImpl::startOfSpeechCallback() _state:" + this.f2600n);
        }
        if (this.f2600n == 4) {
            m2247a("START_OF_SPEECH", null);
        }
    }

    public final void mo236f() {
        if (f2587a.mo317b()) {
            f2587a.mo316b((Object) "RecorderImpl.startRecording()");
        }
        bk bkVar = this.f2591e;
        C0416a c0416a = new C0416a((byte) 1, null);
        Thread currentThread = Thread.currentThread();
        this.f2591e.mo329a();
        bkVar.mo327a(c0416a, this, currentThread);
    }

    public final void mo237g() {
        if (f2587a.mo317b()) {
            f2587a.mo316b((Object) "RecorderImpl.stop()");
        }
        bk bkVar = this.f2591e;
        C0416a c0416a = new C0416a((byte) 3, null);
        Thread currentThread = Thread.currentThread();
        this.f2591e.mo329a();
        bkVar.mo327a(c0416a, this, currentThread);
    }
}
