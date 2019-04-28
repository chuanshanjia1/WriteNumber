package com.yunteng.writenumber;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    static boolean isPlay=true;
    MediaPlayer mediaPlayer;
    Button music_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music_btn = findViewById(R.id.btn_music);

        PlayMusic();
    }
    //开启音乐
    private void PlayMusic() {
        mediaPlayer =MediaPlayer.create(this,R.raw.music1);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    public void onPlay(View view) {
        startActivity(new Intent(MainActivity.this,SelectActivity.class));
    }
        //播放暂停音乐
    public void onMusic(View view) {
        if(isPlay==true){
            if (mediaPlayer!=null){
                mediaPlayer.stop();
                music_btn.setBackgroundResource(R.drawable.an_2);
                isPlay=false;

            }
        }else {
            PlayMusic();
            music_btn.setBackgroundResource(R.drawable.an_1);
            isPlay=true;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer!=null){
            mediaPlayer.stop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (isPlay=true){
            PlayMusic();
        }
    }

    public void onAbout(View view) {
        startActivity(new Intent(MainActivity.this,aboutActivity.class));
    }
}
