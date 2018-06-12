package com.example.speechreconisationproject;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends Activity 
{

	private SpeechRecognizer mDeliverySpeech;
	private Intent mSpeechIntent;
	private boolean mListening = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity2);
		SetupSpeechRecognizer();

	    mSpeechIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

	    mSpeechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, "en");
	    mSpeechIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, this.getPackageName());
	    mSpeechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
	    mSpeechIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3);
	}

	public void startListen(View v) {
		startService(new Intent(getApplicationContext(), MySpeechRecognisationService.class));
	}

	public void stopListen(View v) {
		if (mDeliverySpeech.isRecognitionAvailable(this) && !mListening) {

			mListening = true;

			mDeliverySpeech.stopListening();
		}
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
				Toast.makeText(getApplicationContext(), "rmsChanged", Toast.LENGTH_SHORT).show();
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
			}

			@Override
			public void onError(int error) {
				// do nothing
				Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onResults(Bundle results) {
				ArrayList<String> userMessage;
				//userMessage = results.getStringArrayList(RecognitionListener.RESULTS_RECOGNITION);
				//PushNewDelivery(userMessage);
				Toast.makeText(getApplicationContext(), "result received", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onPartialResults(Bundle partialResults) {
				// do nothing
				Toast.makeText(getApplicationContext(), "patial result", Toast.LENGTH_SHORT).show();
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

}
