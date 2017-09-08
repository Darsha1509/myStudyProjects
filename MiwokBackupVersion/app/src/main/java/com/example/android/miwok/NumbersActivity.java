package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    WordAdapter mAdapter;
    MediaPlayer mMediaPlayer;
    AudioManager mAudioManager;


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {

            switch (focusChange) {
                case AudioManager.AUDIOFOCUS_GAIN:
                    mMediaPlayer.start();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    releaseMediaPlayer();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                    mMediaPlayer.pause();
                    mMediaPlayer.seekTo(0);
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    mMediaPlayer.pause();
                    mMediaPlayer.seekTo(0);
                    break;

            }
        }

    };

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setTitle(R.string.category_numbers);
            setContentView(R.layout.word_list);

            ArrayList<Word> words = new ArrayList<Word>();
            words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
            words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
            words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
            words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
            words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
            words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
            words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
            words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
            words.add(new Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
            words.add(new Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));

            mAdapter = new WordAdapter(this, words, R.color.category_numbers);

            ListView listView = (ListView) findViewById(R.id.list);

            listView.setAdapter(mAdapter);


            mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    releaseMediaPlayer();
                    Word currentWord = mAdapter.getItem(position);


                    int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                            AudioManager.STREAM_MUSIC,
                            AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                    if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                        mMediaPlayer = MediaPlayer.create(getBaseContext(), currentWord.getAudioResourceId());
                        mMediaPlayer.start();
                    }


                    mMediaPlayer.setOnCompletionListener(mCompletionListener);

                }

            });
        }

            @Override
            protected void onStop () {
                super.onStop();
                releaseMediaPlayer();
            }

        private void releaseMediaPlayer() {
            if (mMediaPlayer != null) {
                mMediaPlayer.release();
                mMediaPlayer = null;
                mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
            }

        }

}



