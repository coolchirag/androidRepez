package com.example.speechreconisationproject;

import java.lang.ref.WeakReference;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.widget.Toast;

public class MySpeechRecognisationService extends Service {

	protected static AudioManager mAudioManager;
	protected SpeechRecognizer mSpeechRecognizer;
	protected Intent mSpeechRecognizerIntent;
	protected final Messenger mServerMessenger = new Messenger(new IncomingHandler(this));

	protected boolean mIsListening;
	protected volatile boolean mIsCountDownOn;
	private static boolean mIsStreamSolo;

	static final int MSG_RECOGNIZER_START_LISTENING = 1;
	static final int MSG_RECOGNIZER_CANCEL = 2;

	public MySpeechRecognisationService() {
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO: Return the communication channel to the service.
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
		mSpeechRecognizer.setRecognitionListener(new SpeechRecognitionListener());
		mSpeechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
				RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, this.getPackageName());
		mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, "en");
	}

	protected static class IncomingHandler extends Handler {
		private WeakReference<MySpeechRecognisationService> mtarget;

		IncomingHandler(MySpeechRecognisationService target) {
			mtarget = new WeakReference<MySpeechRecognisationService>(target);
		}

		@Override
		public void handleMessage(Message msg) {
			final MySpeechRecognisationService target = mtarget.get();

			switch (msg.what) {
			case MSG_RECOGNIZER_START_LISTENING:

				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
					// turn off beep sound
					if (!mIsStreamSolo) {
						mAudioManager.setStreamSolo(AudioManager.STREAM_VOICE_CALL, true);
						mIsStreamSolo = true;
					}
				}
				if (!target.mIsListening) {
					target.mSpeechRecognizer.startListening(target.mSpeechRecognizerIntent);
					target.mIsListening = true;
					// Log.d(TAG, "message start listening"); //$NON-NLS-1$
				}
				break;

			case MSG_RECOGNIZER_CANCEL:
				if (mIsStreamSolo) {
					mAudioManager.setStreamSolo(AudioManager.STREAM_VOICE_CALL, false);
					mIsStreamSolo = false;
				}
				target.mSpeechRecognizer.cancel();
				target.mIsListening = false;
				// Log.d(TAG, "message canceled recognizer"); //$NON-NLS-1$
				break;
			}
		}
	}

	// Count down timer for Jelly Bean work around
	protected CountDownTimer mNoSpeechCountDown = new CountDownTimer(50000, 50000) {

		@Override
		public void onTick(long millisUntilFinished) {
			Toast.makeText(getApplicationContext(), "on tick", Toast.LENGTH_SHORT).show();

		}

		@Override
		public void onFinish() {
			/*mIsCountDownOn = false;
			Message message = Message.obtain(null, MSG_RECOGNIZER_CANCEL);
			try {
				mServerMessenger.send(message);
				message = Message.obtain(null, MSG_RECOGNIZER_START_LISTENING);
				mServerMessenger.send(message);
			} catch (RemoteException e) {

			}*/
			mSpeechRecognizer.stopListening();
		}
	};

	@Override
	public void onDestroy() {
		super.onDestroy();

		if (mIsCountDownOn) {
			mNoSpeechCountDown.cancel();
		}
		if (mSpeechRecognizer != null) {
			mSpeechRecognizer.destroy();
		}
	}

	protected class SpeechRecognitionListener implements RecognitionListener {

		@Override
		public void onBeginningOfSpeech() {
			// speech input will be processed, so there is no need for count
			// down anymore
			if (mIsCountDownOn) {
				mIsCountDownOn = false;
				mNoSpeechCountDown.cancel();
			}
			// Log.d(TAG, "onBeginingOfSpeech"); //$NON-NLS-1$
		}

		@Override
		public void onBufferReceived(byte[] buffer) {

		}

		@Override
		public void onEndOfSpeech() {
			// Log.d(TAG, "onEndOfSpeech"); //$NON-NLS-1$
		}

		@Override
		public void onError(int error) {
			if (mIsCountDownOn) {
				mIsCountDownOn = false;
				mNoSpeechCountDown.cancel();
			}
			mIsListening = false;
			Message message = Message.obtain(null, MSG_RECOGNIZER_START_LISTENING);
			try {
				mServerMessenger.send(message);
			} catch (RemoteException e) {

			}
			// Log.d(TAG, "error = " + error); //$NON-NLS-1$
		}

		@Override
		public void onEvent(int eventType, Bundle params) {

		}

		@Override
		public void onPartialResults(Bundle partialResults) {

		}

		@Override
		public void onReadyForSpeech(Bundle params) {
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
				mIsCountDownOn = true;
				mNoSpeechCountDown.start();

			}
			// Log.d("onReadyForSpeech"); //$NON-NLS-1$
		}

		@Override
		public void onResults(Bundle results) {
			Toast.makeText(getApplicationContext(), "result : "+results.getStringArrayList("results_recognition"),Toast.LENGTH_SHORT).show();

		}

		@Override
		public void onRmsChanged(float rmsdB) {

		}

	}

	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		mSpeechRecognizer.startListening(mSpeechRecognizerIntent);
		mNoSpeechCountDown.start();
		return super.onStartCommand(intent, flags, startId);
	}
	
	
}
