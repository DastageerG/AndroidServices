package com.example.androidservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

public class DownloadService extends Service
{
    DownloadThread downloadThread ;
    public static final String TAG ="1111";


    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
       downloadThread = new DownloadThread();
        downloadThread.start();
        while (downloadThread.downloadHandler ==null)
        {

        }
    } // onCreate closed

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.d(TAG, "onStartCommand: ");

        String song = intent.getStringExtra(MainActivity.MESSAGE);

        Message message = Message.obtain();
        message.obj = song;
        downloadThread.downloadHandler.sendMessage(message);


//        Thread thread = new Thread()
//        {
//            @Override
//            public void run()
//            {
//                super.run();
//                //downloadSong(song);
//            }
//        };
//        thread.start();

        return Service.START_REDELIVER_INTENT;
    }

    public DownloadService()
    {
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    } //




} // DownloadService closed
