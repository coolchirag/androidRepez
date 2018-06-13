package com.att.android.speech;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ATTSpeechActivity extends Activity {
    private static /* synthetic */ int[] f367c;
    private C0122i f368a;
    private JSONObject f369b;

    static /* synthetic */ void m337a(ATTSpeechActivity aTTSpeechActivity, C0121g c0121g) {
        Intent intent = new Intent("com.att.android.speech");
        Collection d = c0121g.m406d();
        if (d != null) {
            intent.putStringArrayListExtra("android.speech.extra.RESULTS", new ArrayList(d));
        }
        byte[] a = c0121g.m403a();
        if (a != null) {
            intent.putExtra("att.speech.extra.RESULTS_RAW_DATA", a);
        }
        intent.putExtra("att.speech.extra.HTTP_STATUS_CODE", c0121g.m404b());
        Map c = c0121g.m405c();
        int size = c.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        c.keySet().toArray(strArr);
        for (int i = 0; i < size; i++) {
            strArr2[i] = (String) c.get(strArr[i]);
        }
        intent.putExtra("att.speech.extra.RESULT_HTTP_HEADER_NAMES", strArr);
        intent.putExtra("att.speech.extra.RESULT_HTTP_HEADER_VALUES", strArr2);
        if (aTTSpeechActivity.f369b != null) {
            try {
                intent.putExtra("att.speech.extra.REQUEST_PROPERTIES_JSON", aTTSpeechActivity.f369b.toString(4));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            aTTSpeechActivity.f369b = null;
        }
        aTTSpeechActivity.setResult(-1, intent);
        aTTSpeechActivity.finish();
    }

    private void m338a(C0119d c0119d) {
        int i = 4;
        Intent intent = new Intent("com.att.android.speech");
        if (c0119d.m400b() != null) {
            intent.putExtra("att.speech.extra.ERROR_MESSAGE", c0119d.m400b());
        }
        C0121g c = c0119d.m401c();
        if (c != null) {
            intent.putExtra("att.speech.extra.RESULTS_RAW_DATA", c.m403a());
            intent.putExtra("att.speech.extra.HTTP_STATUS_CODE", c.m404b());
        }
        switch (m340a()[c0119d.m399a().ordinal()]) {
            case 1:
                i = 0;
                break;
            case 2:
                i = 1001;
                break;
            case 3:
                i = 5;
                break;
            case 4:
                i = 1002;
                break;
            case 5:
                i = 1003;
                break;
            case 6:
                break;
            case 7:
                i = 1004;
                break;
            case 8:
                i = 3;
                break;
            case 9:
                i = 2;
                break;
            default:
                i = 2;
                break;
        }
        if (this.f369b != null) {
            try {
                intent.putExtra("att.speech.extra.REQUEST_PROPERTIES_JSON", this.f369b.toString(4));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.f369b = null;
        }
        setResult(i, intent);
        finish();
    }

    private boolean m339a(android.content.Intent r9) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x00cd in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = 0;
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = new java.net.URI;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = "att.speech.extra.REQUEST_URL";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = r9.getStringExtra(r3);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m428a(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = "att.speech.extra.SPEECH_CONTEXT";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r9.hasExtra(r1);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        if (r1 == 0) goto L_0x0024;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x0019:
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = "att.speech.extra.SPEECH_CONTEXT";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = r9.getStringExtra(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m427a(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x0024:
        r1 = "att.speech.extra.BEARER_AUTH_TOKEN";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r9.hasExtra(r1);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        if (r1 == 0) goto L_0x0037;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x002c:
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = "att.speech.extra.BEARER_AUTH_TOKEN";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = r9.getStringExtra(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m433b(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x0037:
        r1 = "att.speech.extra.BASIC_AUTH_USER";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r9.hasExtra(r1);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        if (r1 == 0) goto L_0x004a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x003f:
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = "att.speech.extra.BASIC_AUTH_USER";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = r9.getStringExtra(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m437c(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x004a:
        r1 = "att.speech.extra.BASIC_AUTH_PASSWORD";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r9.hasExtra(r1);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        if (r1 == 0) goto L_0x005d;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x0052:
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = "att.speech.extra.BASIC_AUTH_PASSWORD";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = r9.getStringExtra(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m440d(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x005d:
        r1 = "att.speech.extra.AUDIO_FILE_PATH";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r9.hasExtra(r1);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        if (r1 == 0) goto L_0x0070;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x0065:
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = "att.speech.extra.AUDIO_FILE_PATH";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = r9.getStringExtra(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m443e(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x0070:
        r1 = "att.speech.extra.CONTENT_TYPE";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r9.hasExtra(r1);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        if (r1 == 0) goto L_0x0083;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x0078:
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = "att.speech.extra.CONTENT_TYPE";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = r9.getStringExtra(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m445f(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x0083:
        r1 = "att.speech.extra.HTTP_HEADER_NAMES";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r9.hasExtra(r1);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        if (r1 == 0) goto L_0x00dd;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x008b:
        r1 = "att.speech.extra.HTTP_HEADER_NAMES";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = r9.getStringArrayExtra(r1);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = "att.speech.extra.HTTP_HEADER_VALUES";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = r9.getStringArrayExtra(r1);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        if (r2 == 0) goto L_0x009f;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x0099:
        if (r3 == 0) goto L_0x009f;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x009b:
        r1 = r2.length;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r4 = r3.length;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        if (r1 == r4) goto L_0x00ce;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x009f:
        r1 = new java.lang.IllegalArgumentException;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = "att.speech.extra.HTTP_HEADER_NAMES requires matching att.speech.extra.HTTP_HEADER_VALUES array";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        throw r1;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x00a7:
        r1 = move-exception;
        r2 = "ATTSpeechActivity";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = "Unable to configure speech interaction";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        com.att.android.speech.ac.m345a(r2, r3);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = new com.att.android.speech.d;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = com.att.android.speech.C0120e.PARAMETER_ERROR;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r4 = r1.getMessage();	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2.<init>(r3, r4, r1);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r8.m338a(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = "att.speech.extra.RETURN_REQUEST_PROPERTIES";
        r1 = r9.getBooleanExtra(r1, r0);
        if (r1 == 0) goto L_0x00cd;
    L_0x00c5:
        r1 = r8.f368a;
        r1 = r1.m453j();
        r8.f369b = r1;
    L_0x00cd:
        return r0;
    L_0x00ce:
        r4 = new java.util.HashMap;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r2.length;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r4.<init>(r1);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r5 = r2.length;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r0;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x00d6:
        if (r1 < r5) goto L_0x01e6;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x00d8:
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m429a(r4);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x00dd:
        r1 = "att.speech.extra.SHOW_DIALOG";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r9.hasExtra(r1);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        if (r1 == 0) goto L_0x00f6;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x00e5:
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = "att.speech.extra.SHOW_DIALOG";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = r3.m446f();	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = r9.getBooleanExtra(r2, r3);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m430a(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x00f6:
        r1 = "android.speech.extra.PROMPT";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r9.hasExtra(r1);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        if (r1 == 0) goto L_0x0109;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x00fe:
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = "android.speech.extra.PROMPT";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = r9.getStringExtra(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m448g(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x0109:
        r1 = "att.speech.extra.RECORDING_STOP_BUTTON";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r9.hasExtra(r1);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        if (r1 == 0) goto L_0x011c;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x0111:
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = "att.speech.extra.RECORDING_STOP_BUTTON";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = r9.getStringExtra(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m450h(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x011c:
        r1 = "att.speech.extra.WAIT_PROMPT";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r9.hasExtra(r1);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        if (r1 == 0) goto L_0x012f;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x0124:
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = "att.speech.extra.WAIT_PROMPT";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = r9.getStringExtra(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m451i(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x012f:
        r1 = "att.speech.extra.PROCESSING_CANCEL_BUTTON";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r9.hasExtra(r1);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        if (r1 == 0) goto L_0x0142;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x0137:
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = "att.speech.extra.PROCESSING_CANCEL_BUTTON";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = r9.getStringExtra(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m454j(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x0142:
        r1 = "att.speech.extra.CANCEL_WHEN_SILENT";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r9.hasExtra(r1);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        if (r1 == 0) goto L_0x015b;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x014a:
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = "att.speech.extra.CANCEL_WHEN_SILENT";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = r3.m452i();	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = r9.getBooleanExtra(r2, r3);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m434b(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
    L_0x015b:
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = "android.speech.extras.SPEECH_INPUT_MINIMUM_LENGTH_MILLIS";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = "android.speech.extras.SPEECH_INPUT_MINIMUM_LENGTH_MILLIS";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r4 = 1500; // 0x5dc float:2.102E-42 double:7.41E-321;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = r9.getLongExtra(r3, r4);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = (int) r3;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = r9.getIntExtra(r2, r3);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m424a(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = "android.speech.extras.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = "att.speech.extra.SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r4 = 850; // 0x352 float:1.191E-42 double:4.2E-321;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = r9.getLongExtra(r3, r4);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = (int) r3;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = r9.getIntExtra(r2, r3);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m432b(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = "att.speech.extra.SPEECH_INPUT_MINIMUM_LENGTH_MILLIS";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = "att.speech.extra.SPEECH_INPUT_MINIMUM_LENGTH_MILLIS";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r4 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = r9.getLongExtra(r3, r4);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = (int) r3;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = r9.getIntExtra(r2, r3);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m436c(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = "att.speech.extra.RECORD_TIMEOUT";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = "att.speech.extra.RECORD_TIMEOUT";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r4 = 25000; // 0x61a8 float:3.5032E-41 double:1.23516E-319;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = r9.getLongExtra(r3, r4);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = (int) r3;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = r9.getIntExtra(r2, r3);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m439d(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = "att.speech.extra.CONNECTION_TIMEOUT";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = "att.speech.extra.CONNECTION_TIMEOUT";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r4 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = r9.getLongExtra(r3, r4);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = (int) r3;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = r9.getIntExtra(r2, r3);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m442e(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r8.f368a;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = "att.speech.extra.RESPONSE_TIMEOUT";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = "att.speech.extra.RESPONSE_TIMEOUT";	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r4 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = r9.getLongExtra(r3, r4);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r3 = (int) r3;	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r2 = r9.getIntExtra(r2, r3);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1.m444f(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = "att.speech.extra.RETURN_REQUEST_PROPERTIES";
        r0 = r9.getBooleanExtra(r1, r0);
        if (r0 == 0) goto L_0x01e3;
    L_0x01db:
        r0 = r8.f368a;
        r0 = r0.m453j();
        r8.f369b = r0;
    L_0x01e3:
        r0 = 1;
        goto L_0x00cd;
    L_0x01e6:
        r6 = r2[r1];	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r7 = r3[r1];	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r4.put(r6, r7);	 Catch:{ Exception -> 0x00a7, all -> 0x01f1 }
        r1 = r1 + 1;
        goto L_0x00d6;
    L_0x01f1:
        r1 = move-exception;
        r2 = "att.speech.extra.RETURN_REQUEST_PROPERTIES";
        r0 = r9.getBooleanExtra(r2, r0);
        if (r0 == 0) goto L_0x0202;
    L_0x01fa:
        r0 = r8.f368a;
        r0 = r0.m453j();
        r8.f369b = r0;
    L_0x0202:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.att.android.speech.ATTSpeechActivity.a(android.content.Intent):boolean");
    }

    private static /* synthetic */ int[] m340a() {
        int[] iArr = f367c;
        if (iArr == null) {
            iArr = new int[C0120e.values().length];
            try {
                iArr[C0120e.BELOW_MINIMUM_LENGTH.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C0120e.CAPTURE_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[C0120e.CONNECTION_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[C0120e.INAUDIBLE.ordinal()] = 5;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[C0120e.OTHER_ERROR.ordinal()] = 9;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[C0120e.PARAMETER_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[C0120e.RESPONSE_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[C0120e.SERVER_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[C0120e.USER_CANCELED.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            f367c = iArr;
        }
        return iArr;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f368a = C0122i.m408a((Activity) this);
        this.f368a.m426a(new C0114a(this));
        this.f368a.m425a(new C0117b(this));
        if (!m339a(getIntent())) {
            this.f368a = null;
        }
    }

    protected final void onPause() {
        if (this.f368a != null) {
            this.f368a.m438d();
            this.f368a = null;
            m338a(new C0119d(C0120e.USER_CANCELED, "Canceled interaction when activity was paused"));
        }
        super.onPause();
    }

    protected final void onStart() {
        super.onStart();
        if (this.f368a != null) {
            this.f368a.m423a();
        }
    }

    protected final void onStop() {
        if (this.f368a != null) {
            this.f368a.m438d();
            this.f368a = null;
            m338a(new C0119d(C0120e.USER_CANCELED, "Canceled interaction when activity was stopped"));
        }
        super.onStop();
    }
}
