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


    public SoundPool mSP;
    private int mEat_ID = -1;
    private int mCrashID = -1;
    private Context context;
    private AssetManager assetManager;

    private IAudioPlayer player;




   public AudioPlayer(SoundPool mSP){
        this.mSP = build(mSP);
    }

    public SoundPool build(SoundPool mSP){
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

        return mSP;

    }

    @Override
    public void playAppleEatingSound(SoundPool mSP) throws IOException {


        assetManager = this.context.getAssets();
        // Creation of audioFile object for strategy pattern implemented
        // when multiple variations of the same task/operation is executed
        AudioFile audioFile = new AudioFile(assetManager);


        AssetFileDescriptor descriptor;
        descriptor = assetManager.openFd("get_apple.ogg");
        mEat_ID = mSP.load(descriptor, 0);
        mEat_ID = this.mSP.load(descriptor, 0);

        mSP.play(mEat_ID, 1, 1, 0, 0, 1);
    }

    @Override
    public void playSnakeDeathSound(SoundPool soundPool) throws IOException {
        AssetManager assetManager = context.getAssets();
        AssetFileDescriptor descriptor;
        descriptor = assetManager.openFd("snake_death.ogg");
        mCrashID = mSP.load(descriptor, 0);
    }


}
