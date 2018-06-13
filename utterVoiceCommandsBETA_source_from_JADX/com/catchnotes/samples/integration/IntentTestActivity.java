package com.catchnotes.samples.integration;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.catchnotes.p020a.C0174a;
import java.util.ArrayList;

public class IntentTestActivity extends Activity {
    private final int IMAGE_PICKED = 0;
    private C0174a _notesIntent;

    class C01771 implements OnClickListener {
        C01771() {
        }

        public void onClick(View view) {
            IntentTestActivity.this._notesIntent.m1514a("My Simple Note\n\n#sample", null, -1, false, null);
        }
    }

    class C01782 implements OnClickListener {
        C01782() {
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            IntentTestActivity.this.startActivityForResult(Intent.createChooser(intent, "Choose from:"), 0);
        }
    }

    class C01793 implements OnClickListener {
        C01793() {
        }

        public void onClick(View view) {
            IntentTestActivity.this._notesIntent.m1514a("My Quick Note\n\n#sample", null, -1, true, null);
        }
    }

    class C01804 implements OnClickListener {
        C01804() {
        }

        public void onClick(View view) {
            Location location = new Location("network");
            location.setLatitude(30.267153d);
            location.setLongitude(-97.743061d);
            IntentTestActivity.this._notesIntent.m1514a("My Location Tagged Note\n\n#sample", location, -1, false, null);
        }
    }

    class C01815 implements OnClickListener {
        C01815() {
        }

        public void onClick(View view) {
            IntentTestActivity.this._notesIntent.m1515a(null, "sample", null);
        }
    }

    class C01826 implements OnClickListener {
        C01826() {
        }

        public void onClick(View view) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add("sample");
            IntentTestActivity.this._notesIntent.m1515a(null, null, arrayList);
        }
    }

    class C01837 implements OnClickListener {
        C01837() {
        }

        public void onClick(View view) {
            IntentTestActivity.this._notesIntent.m1515a("Sample", null, null);
        }
    }

    class C01848 implements OnClickListener {
        C01848() {
        }

        public void onClick(View view) {
            IntentTestActivity.this._notesIntent.m1514a("Cursor Positioning\n\nExample", null, 19, false, null);
        }
    }

    class C01859 implements OnClickListener {
        C01859() {
        }

        public void onClick(View view) {
            C0174a access$0 = IntentTestActivity.this._notesIntent;
            String str = "My Voice Note\n\n#sample";
            if (access$0.m1516a()) {
                Intent intent = new Intent();
                intent.setAction("com.catchnotes.intent.action.ADD_VOICE");
                intent.putExtra("android.intent.extra.TEXT", str);
                access$0.m1513a(intent);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 0:
                    this._notesIntent.m1514a("My Image Note\n\n#sample", null, -1, false, intent.getData());
                    break;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0186R.layout.main);
        this._notesIntent = new C0174a(this);
        ((Button) findViewById(C0186R.id.create_simple_note_button)).setOnClickListener(new C01771());
        ((Button) findViewById(C0186R.id.create_image_note_button)).setOnClickListener(new C01782());
        ((Button) findViewById(C0186R.id.create_quick_note_button)).setOnClickListener(new C01793());
        ((Button) findViewById(C0186R.id.create_location_note_button)).setOnClickListener(new C01804());
        ((Button) findViewById(C0186R.id.view_notes_button)).setOnClickListener(new C01815());
        ((Button) findViewById(C0186R.id.view_tagged_notes_button)).setOnClickListener(new C01826());
        ((Button) findViewById(C0186R.id.view_stream_button)).setOnClickListener(new C01837());
        ((Button) findViewById(C0186R.id.cursor_positioning_button)).setOnClickListener(new C01848());
        ((Button) findViewById(C0186R.id.voice_recording_button)).setOnClickListener(new C01859());
        ((Button) findViewById(C0186R.id.reminder_button)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C0174a access$0 = IntentTestActivity.this._notesIntent;
                String str = "My Reminder Note\n\n#sample";
                if (access$0.m1516a()) {
                    Intent intent = new Intent();
                    intent.setAction("com.catchnotes.intent.action.ADD_REMINDER");
                    intent.putExtra("android.intent.extra.TEXT", str);
                    access$0.m1513a(intent);
                }
            }
        });
    }
}
