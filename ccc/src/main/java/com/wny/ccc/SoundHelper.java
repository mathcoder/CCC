package com.wny.ccc;

import android.app.Service;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;

/**
 * Created by mathcoder23 on 10/11/16.
 */
public class SoundHelper {
    static MediaPlayer music;
    Context context;
    private static SoundHelper soundHelper;
    public static SoundHelper getInstance(Context context)
    {
        if (soundHelper == null)
            soundHelper = new SoundHelper(context);
        return soundHelper;
    }
    private SoundHelper(Context context)
    {
        this.context = context;
        music = MediaPlayer.create(context,R.raw.chuida2);
        music.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

            }
        });
    }
    public  void chuida()
    {
        if (music.isPlaying())
        {
            Log.i("xixi","playing");
            music.seekTo(0);
        }
        else
        {
            music.start();
        }


    }
    public void cancelChuida()
    {
        music.stop();
    }

}
