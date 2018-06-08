package com.example.demoaapp;

import java.util.List;

import android.accessibilityservice.AccessibilityService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import android.widget.Toast;

public class MyService extends AccessibilityService {
	public MyService() {
	}

	/*
	 * @Override public int onStartCommand(Intent intent, int flags, int
	 * startId) { while(true) { Toast.makeText(getApplicationContext(),
	 * "Service Started", Toast.LENGTH_SHORT).show(); try { Thread.sleep(4000);
	 * } catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } Toast.makeText(getApplicationContext(),
	 * "Service Started", Toast.LENGTH_SHORT).show(); return
	 * super.onStartCommand(intent, flags, startId); }
	 */

	@Override
	public void onCreate() {
		Toast.makeText(getApplicationContext(), "Service Created", Toast.LENGTH_SHORT).show();
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		Toast.makeText(getApplicationContext(), "Service Destroy", Toast.LENGTH_SHORT).show();
		super.onDestroy();
	}

	@Override
	public void onAccessibilityEvent(AccessibilityEvent event) {
		AccessibilityNodeInfo node = event.getSource();
		if (node != null && node.getPackageName() != null && event.getEventType() == 32) {
			int childSize = node.getChildCount();
			AccessibilityWindowInfo window = node.getWindow();
			if (window != null && window.getTitle() != null) {

				String str = "hello : " + node.getPackageName() + ", " + event.describeContents() + ","
						+ event.getAction() + "," + event.getEventType();
				
				if (window != null) {
					str = str + " , window info : " + window.getTitle() + ", "+window.getType();
				}
				str = str + ", child info : ";
				StringBuffer strb = new StringBuffer();
				nodeInfo(node, strb);

				/*
				 * for(int i = 0; i<childSize ; i++) { if(node.getChild(i) !=
				 * null) { str = str + node.getChild(i).getClassName()+", "; } }
				 */
				str = str + strb.toString();

				System.out.println(str);
				// Toast.makeText(getApplicationContext(), str,
				// Toast.LENGTH_SHORT).show();
			}
		}
	}

	private void nodeInfo(AccessibilityNodeInfo node, StringBuffer str) {
		if (node != null) {
			str.append("," + node.getClassName());
			if (node.getChildCount() > 0) {
				for (int i = 0; i < node.getChildCount(); i++) {
					nodeInfo(node.getChild(i), str);
				}
			}
		}

	}

	@Override
	public void onInterrupt() {
		Toast.makeText(getApplicationContext(), "Destroy", Toast.LENGTH_SHORT).show();

	}

	@Override
	protected void onServiceConnected() {
		Toast.makeText(getApplicationContext(), "connected", Toast.LENGTH_SHORT).show();
		super.onServiceConnected();
	}

	@Override
	public List<AccessibilityWindowInfo> getWindows() {
		Toast.makeText(getApplicationContext(), "get window", Toast.LENGTH_SHORT).show();
		return super.getWindows();
	}

	@Override
	public AccessibilityNodeInfo findFocus(int focus) {
		Toast.makeText(getApplicationContext(), "get focused " + focus, Toast.LENGTH_SHORT).show();
		return super.findFocus(focus);
	}

	@Override
	public Object getSystemService(String name) {
		Toast.makeText(getApplicationContext(), "system service : " + name, Toast.LENGTH_SHORT).show();
		return super.getSystemService(name);
	}

}
