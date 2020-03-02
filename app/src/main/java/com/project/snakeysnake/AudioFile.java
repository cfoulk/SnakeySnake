package com.project.snakeysnake;

import java.io.IOException;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.IOException;

//TODO delete unused imports


public class AudioFile {
    Context context;
    public int mEat_ID;
    public int mCrashID = -1;
    public SoundPool mSP;
    AssetManager assetManager;


    //Constructor for Audio File Object
    AudioFile(AssetManager assetManager){
        this.assetManager = assetManager;
    }

    void AppleEatenSound(AssetManager assetManager) throws IOException
    {
        System.out.println("You got to this place");
        AssetFileDescriptor descriptor;

        // Prepare the sounds in memory
        descriptor = assetManager.openFd("get_apple.ogg");

        this.mEat_ID = this.mSP.load(descriptor, 0);





    }

    void playSnakeDeathSound() throws IOException {

        try{
            AssetFileDescriptor descriptor;
            descriptor = assetManager.openFd("snake_death.ogg");
            this.mCrashID = this.mSP.load(descriptor, 0);
        } catch (IOException e) {
            System.out.println("couldn't find death of snake sound");
        }



    }

}
