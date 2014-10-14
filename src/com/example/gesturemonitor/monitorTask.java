package com.example.gesturemonitor;
import java.util.TimerTask;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class monitorTask extends TimerTask {
	public static final String TAG = "monitorTask";
	private Context m_context;
	private ActivityManager m_ActivityManager;
	
	String testPackageName = "com.android.calculator2"; 
	String testClassName = "com.android.calculator2.Calculator";
	
	public monitorTask(Context context){
		Log.v(TAG,"started");
		m_context = context;
		m_ActivityManager = (ActivityManager)m_context.getSystemService("activity"); 
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ComponentName topActivity = m_ActivityManager.getRunningTasks(1).get(0).topActivity;  
		String PackageName = topActivity.getPackageName();
		String ClassName = topActivity.getClassName(); 
		
		Log.v(TAG, "packageName:" + PackageName); 
		Log.v(TAG, "className:" + ClassName);
		
		if(testPackageName.equals(PackageName)&&testClassName.equals(ClassName)){
			Intent intent = new Intent();
			intent.setClassName("com.example.gesturemonitor", "com.example.gesturemonitor.MainActivity");
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			m_context.startActivity(intent);
		}

	}

}
