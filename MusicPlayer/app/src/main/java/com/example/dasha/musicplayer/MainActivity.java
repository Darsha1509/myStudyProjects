package com.example.dasha.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnCompletionListener {

    Button playButton;
    Button pauseButton;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = (Button) findViewById(R.id.play_button);
        pauseButton = (Button) findViewById(R.id.pause_button);

        playButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);

        mediaPlayer = MediaPlayer.create(this, R.raw.nebesa);
        mediaPlayer.setOnCompletionListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play_button:
                mediaPlayer.start();

                break;
            case R.id.pause_button:
                mediaPlayer.pause();
                break;
            }
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        Toast.makeText(this, "I'm done!", Toast.LENGTH_SHORT).show();
    }
}
