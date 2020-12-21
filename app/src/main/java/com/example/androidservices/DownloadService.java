package com.example.androidservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class DownloadService extends Service
{

    public static final String TAG ="1111";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {

       String song = intent.getStringExtra(MainActivity.TAG);
        downloadSong(song);
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

    private void downloadSong(String  song)
    {
        Log.d(TAG, "downloadSong: downloading "+song);

        try
        {
            Thread.sleep(3000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        Log.d(TAG, "downloadSong: downloaded "+song);


    } // downloadSong closed


} // DownloadService closed
