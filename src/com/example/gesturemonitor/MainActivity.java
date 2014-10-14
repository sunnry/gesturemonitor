package com.example.gesturemonitor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	public static final String TAG = "MainActivity";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG,"demo MainActivity onCreate\n");
        
        Intent intent = new Intent("com.example.gesturemonitor.monitorService");
        this.startService(intent);
        
        setContentView(R.layout.activity_main);
    }
    
}
