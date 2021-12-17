package com.jailseed.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "appChanel2";
    private static final CharSequence CHANNEL_NAME = "App Chanel #2";
    public int notificationID;
    private BroadcastReceiver myReceiver;
    private IntentFilter filter;
    public NotificationManager notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide the Device Status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Hide the Activity Action Bar
        getSupportActionBar().hide();
        // set Activity(screen) Orientation to LANDSCAPE
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setupBroadcasts();
        setupNotification();


    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d("mylog", "###### onResume()");
    }

    private void setupBroadcasts()
    {
        myReceiver = new MyReceiver();
        filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        registerReceiver(myReceiver, filter);

        Log.d("mylog", "#### onStart() registerReceiver!");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        unregisterReceiver(myReceiver);

        Log.d("mylog", ">> onStop() unregisterReceiver!");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d("mylog", ">> onDestroy() ");
    }

    private void setupNotification()
    {
        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel = new NotificationChannel(
                    CHANNEL_ID, 	// Constant for Channel ID
                    CHANNEL_NAME, 	// Constant for Channel NAME
                    NotificationManager.IMPORTANCE_HIGH);

            notificationManager.createNotificationChannel(notificationChannel);
        }
        notificationID = 1;
    }


}


