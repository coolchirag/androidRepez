package com.example.speechreconisationproject;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	

	
	
	public void startService(View v)
	{
		startService(new Intent(getApplicationContext(),MySpeechRecognisationService.class));
	}
	
	public void stopService(View v)
	{
		stopService(new Intent(getApplicationContext(),MySpeechRecognisationService.class));
	}
}
