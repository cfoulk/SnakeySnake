package com.project.snakeysnake;

import java.io.IOException;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

import java.io.IOException;

//TODO delete unused imports


public class AudioFile{
    Context context;
    public int mEat_ID;
    public int mCrashID = -1;
    public SoundPool mSP;
    AssetManager assetManager;

    public AudioFile(AssetManager assetManager, int sound) throws IOException {
        this.assetManager = assetManager;
        if (sound == 0){
            AppleEatenSound(assetManager);
        }
    }


    //Constructor for Audio File Object
   // AudioFile(AssetManager assetManager){
      //  this.assetManager = assetManager;
   // }

    AssetFileDescriptor AppleEatenSound(AssetManager assetManager) throws IOException
    {
        //System.out.println("You got to this place"); //tester


        AssetFileDescriptor descriptor;
        // Prepare the sounds in memory
        descriptor = assetManager.openFd("get_apple.ogg");
        int playThis = mSP.load(descriptor, 0);
        return descriptor;






    }

    void playSnakeDeathSound() throws IOException {

        try{
            AssetFileDescriptor descriptor;
            descriptor = assetManager.openFd("snake_death.ogg");
            this.mCrashID = this.mSP.load(descriptor, 0);
        } catch (IOException e) {
        //    System.out.println("couldn't find death of snake sound");
        }



    }

}
