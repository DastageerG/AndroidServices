package com.example.androidservices;

import android.os.Looper;

public class DownloadThread extends Thread
{
    public static final String TAG = "1111";
    DownloadHandler downloadHandler;



    @Override
    public void run()
    {
        super.run();
        Looper.prepare();
        this.downloadHandler = new DownloadHandler();
        Looper.loop();
    } // run closed

}
