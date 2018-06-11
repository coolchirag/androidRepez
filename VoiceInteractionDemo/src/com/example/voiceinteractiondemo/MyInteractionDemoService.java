package com.example.voiceinteractiondemo;

import android.content.Intent;
import android.os.IBinder;
import android.service.voice.VoiceInteractionService;

public class MyInteractionDemoService extends VoiceInteractionService 
{
	public MyInteractionDemoService() {
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO: Return the communication channel to the service.
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void onLaunchVoiceAssistFromKeyguard() {
		// TODO Auto-generated method stub
		super.onLaunchVoiceAssistFromKeyguard();
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}
	
	
}
