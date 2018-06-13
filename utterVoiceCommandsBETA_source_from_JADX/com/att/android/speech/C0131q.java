package com.att.android.speech;

import android.app.AlertDialog;
import android.view.View.OnClickListener;

final class C0131q implements C0130s {
    private static /* synthetic */ int[] f572d;
    final /* synthetic */ C0122i f573a;
    private final /* synthetic */ AlertDialog f574b;
    private final /* synthetic */ OnClickListener f575c;

    C0131q(C0122i c0122i, AlertDialog alertDialog, OnClickListener onClickListener) {
        this.f573a = c0122i;
        this.f574b = alertDialog;
        this.f575c = onClickListener;
    }

    private static /* synthetic */ int[] m461a() {
        int[] iArr = f572d;
        if (iArr == null) {
            iArr = new int[C0133t.values().length];
            try {
                iArr[C0133t.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C0133t.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C0133t.INITIALIZING.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[C0133t.PROCESSING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[C0133t.RECORDING.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            f572d = iArr;
        }
        return iArr;
    }

    public final void mo65a(C0133t c0133t) {
        ac.m345a("ATTSpeechService - dialog", "state changed to " + c0133t);
        switch (C0131q.m461a()[c0133t.ordinal()]) {
            case 1:
            case 5:
                try {
                    this.f574b.dismiss();
                    ac.m345a("ATTSpeechService", "Dialog should have been dismissed");
                    return;
                } catch (IllegalArgumentException e) {
                    ac.m345a("ATTSpeechService", "**************** WOULD HAVE LEAKED A WINDOW HERE ***************");
                    return;
                }
            case 2:
                this.f574b.setTitle("Initializing...");
                this.f574b.getButton(-1).setVisibility(8);
                this.f574b.getButton(-2).setVisibility(8);
                return;
            case 3:
                this.f574b.setTitle(this.f573a.m447g());
                this.f574b.getButton(-1).setVisibility(0);
                this.f574b.getButton(-2).setVisibility(8);
                this.f574b.getButton(-1).setOnClickListener(this.f575c);
                return;
            case 4:
                this.f574b.setTitle(this.f573a.m449h());
                this.f574b.getButton(-1).setVisibility(8);
                this.f574b.getButton(-2).setVisibility(0);
                return;
            default:
                return;
        }
    }
}
