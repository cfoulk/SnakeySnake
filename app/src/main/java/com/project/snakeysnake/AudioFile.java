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
    private int mEat_ID = -1;
    private int mCrashID = -1;
    private SoundPool mSP;
    AssetManager assetManager;
    //Constructor for Audio File Object
    AudioFile(Context context, AssetManager assetManager){
        this.assetManager = assetManager;
        this.context = context;

    }



    void AddAudioFile(){}

    void RemoveAudioFile(){}

    void AppleEatenSound() throws IOException {

        try{
            AssetFileDescriptor descriptor;

            // Prepare the sounds in memory
            descriptor = assetManager.openFd("get_apple.ogg");
            this.mEat_ID = this.mSP.load(descriptor, 0);

           /* descriptor = assetManager.openFd("snake_death.ogg");
            this.mCrashID = this.mSP.load(descriptor, 0);8= */
        } catch (IOException e) {
            System.out.println("couldn't find apple sound");
        }



    }



}
