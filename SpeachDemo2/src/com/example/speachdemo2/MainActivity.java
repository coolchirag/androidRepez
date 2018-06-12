package com.example.speachdemo2;

import java.util.ArrayList;
import java.util.Set;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private SpeechRecognizer mDeliverySpeech;
	private Intent mSpeechIntent;
	private boolean mListening = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SetupSpeechRecognizer();

		mSpeechIntent = new Intent("android.speech.action.RECOGNIZE_SPEECH").putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form").putExtra("android.speech.extra.PARTIAL_RESULTS", true).putExtra("android.speech.extras.SPEECH_INPUT_MINIMUM_LENGTH_MILLIS", 30000);
	    //mSpeechIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

	    /*mSpeechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, "en");
	    mSpeechIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, this.getPackageName());
	    mSpeechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);*/
	    mSpeechIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3);
	   // checkPermission();
	    
	}

	public void startListen(View v) {
		checkPermission();
		ListenForNewMessage();
	}

	public void stopListen(View v) {
		//if (mDeliverySpeech.isRecognitionAvailable(this)) {

			mListening = false;

			mDeliverySpeech.stopListening();
		//}
	}

	private void SetupSpeechRecognizer() {
		mDeliverySpeech = SpeechRecognizer.createSpeechRecognizer(this);

		RecognitionListener newDeliveryRecognitionListener = new RecognitionListener() {
			@Override
			public void onReadyForSpeech(Bundle params) {
				Toast.makeText(getApplicationContext(), "ready for sepach", Toast.LENGTH_SHORT).show();
				//Log.d("SpeechListening", "onReadyForSpeech");
			}

			@Override
			public void onBeginningOfSpeech() {
				//Log.d("SpeechListening", "onBeginningOfSpeech");
				Toast.makeText(getApplicationContext(), "begging", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onRmsChanged(float rmsdB) {
				// do nothing
				//Toast.makeText(getApplicationContext(), "rmsChanged", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onBufferReceived(byte[] buffer) {
				// do nothing
				Toast.makeText(getApplicationContext(), "buffer received", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onEndOfSpeech() {
				//Log.d("SpeechListening", "onEndOfSpeech");
				Toast.makeText(getApplicationContext(), "end of speech", Toast.LENGTH_SHORT).show();
				mListening = false;
			}

			@Override
			public void onError(int error) {
				// do nothing
				Toast.makeText(getApplicationContext(), "Error : "+error, Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onResults(Bundle results) {
				ArrayList<String> userMessage;
				//userMessage = results.getStringArrayList(RecognitionListener.RESULTS_RECOGNITION);
				//PushNewDelivery(userMessage);
				String data = "result : ";
				for(String key : results.keySet())
				{
					data = data + ", "+key+":"+results.get(key);
				}
				Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();
				//mListening = false;
			}

			@Override
			public void onPartialResults(Bundle results) {
				String data = "partial : ";
				for(String key : results.keySet())
				{
					data = data + ", "+key+":"+results.get(key);
				}
				Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onEvent(int eventType, Bundle params) {
				// do nothing
				Toast.makeText(getApplicationContext(), "on event", Toast.LENGTH_SHORT).show();
			}
		};

		mDeliverySpeech.setRecognitionListener(newDeliveryRecognitionListener);
	}

	private void ListenForNewMessage() {
		if (mDeliverySpeech.isRecognitionAvailable(this) && !mListening) {

			mListening = true;

			mDeliverySpeech.startListening(mSpeechIntent);

			
			 /** new CountDownTimer(5000, 5000) { public void onTick(long
			 * millisUntilFinished) {}
			 * 
			 * public void onFinish() { mDeliverySpeech.stopListening();
			 * mListening = false; } }.start();*/
			 
		}
	}
	
	private boolean checkPermission()
	{
		if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED)
		{
			ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 1);
		}
		return true;
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		Toast.makeText(getApplicationContext(), "permission granted", Toast.LENGTH_SHORT).show();
	}
}
