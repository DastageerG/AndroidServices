package com.example.androidservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity
{

    private Context context = MainActivity.this;
    public static final String MESSAGE = "message";
    public static final String TAG = "1111";
    private ImageView imageViewPlayPause;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewPlayPause = findViewById(R.id.imageViewPlayPause);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        imageViewPlayPause.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                progressBar.setVisibility(View.VISIBLE);
                for(String song : Playlist.songs)
                {
                    Intent intent = new Intent(context,DownloadService.class);
                    intent.putExtra(MESSAGE,song);
                    startService(intent);
                } // for closed
            } // onClick closed
        }); //

    } // onCreate closed

    public void closeIt(View view)
    {
        
        Intent intent = new Intent(context,DownloadService.class);
        stopService(intent);

    } // closeIt closed
}