package com.project.snakeysnake;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

import java.io.IOException;


//should delete whats unused later ^


public class AudioPlayer implements IAudioPlayer {

    private SoundPool mSP;
    private int mEat_ID = -1;
    private int mCrashID = -1;
    private Context context;

    public AudioPlayer(Context context, SoundPool mSP){
        this.context = context;
        findStrategy(mSP);


    }


    public void findStrategy(SoundPool mSP) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            mSP = new SoundPool.Builder()
                    .setMaxStreams(5)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            mSP = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }
        //AudioFile audioFile = new AudioFile(context);

        try {
            AssetManager assetManager = context.getAssets();
            AssetFileDescriptor descriptor;

            // Prepare the sounds in memory
            descriptor = assetManager.openFd("get_apple.ogg");
            mEat_ID = mSP.load(descriptor, 0);

            descriptor = assetManager.openFd("snake_death.ogg");
            mCrashID = mSP.load(descriptor, 0);

        } catch (IOException e) {
            // Error
        }



    }

    //@Override
    public void playAppleEatingSound(){
        this.mSP.play(mEat_ID, 1, 1, 0, 0, 1);
    }




}
