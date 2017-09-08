package com.example.dasha.musicapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnStart;
    Button btnPause;
    Button mBtnChangeVolume;
    Button mBtnMiddle;

    float volume = 0.0f;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Toast.makeText(MainActivity.this, "Song has benn finished", Toast.LENGTH_SHORT).show();
            }
        });

        btnStart = (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(this);

        btnPause = (Button) findViewById(R.id.btn_pause);
        btnPause.setOnClickListener(this);

        mBtnChangeVolume = (Button) findViewById(R.id.btn_change);
        mBtnChangeVolume.setOnClickListener(this);

        mBtnMiddle = (Button) findViewById(R.id.btn_middle);
        mBtnMiddle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_start:
                mediaPlayer.start();
                break;
            case R.id.btn_pause:
                mediaPlayer.pause();
                break;
            case R.id.btn_change:
                volume = volume + 0.1f;
                mediaPlayer.setVolume(volume,volume);
                break;
            case R.id.btn_middle:
                int middle = mediaPlayer.getDuration()/2;
                mediaPlayer.seekTo(middle);
                break;
        }
    }


}
