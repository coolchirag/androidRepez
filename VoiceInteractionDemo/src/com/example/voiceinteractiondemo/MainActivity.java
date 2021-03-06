package com.example.voiceinteractiondemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		findViewById(R.id.start).setOnClickListener(mStartListener);
		//findViewById(R.id.secure).setOnClickListener(mSecureListener);
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public Uri onProvideReferrer() {
		return Uri.parse("http://www.example.com/VoiceInteractionMain");
	}

	View.OnClickListener mStartListener = new View.OnClickListener() {
		public void onClick(View v) {
			//showAssist(null);
			startService(new Intent(getApplicationContext(), MyInteractionDemoService.class));
		}
	};

	/*View.OnClickListener mSecureListener = new View.OnClickListener() {
		public void onClick(View v) {
			if (((CheckBox) v).isChecked()) {
				getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
			} else {
				getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
			}
		}
	};*/
}
