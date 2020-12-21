package com.example.androidservices;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class DownloadHandler extends Handler
{

    @Override
    public void handleMessage(@NonNull Message msg)
    {
        super.handleMessage(msg);

            downloadSong(msg.obj.toString());


    }

    public static final String TAG = "1111";



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



}
