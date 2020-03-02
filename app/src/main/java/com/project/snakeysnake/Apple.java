package com.project.snakeysnake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import java.util.Random;

public class Apple{

    // The location of the apple on the grid
    // Not in pixels
    private Point location = new Point();

    // The range of values we can choose from
    // to spawn an apple
    private final Point mSpawnRange;
    private final int mSize;
    private final Context context;




    // An image to represent the apple
    //private final Bitmap mBitmapApple;
    private Bitmap mBitmapApple;



    /// Set up the apple in the constructor

    public Apple(AppleBuilder appleBuilder){
        this.mSpawnRange = appleBuilder.mSpawnRange;
        this.mSize = appleBuilder.mSize;
        this.context = appleBuilder.context;
        //this.mBitmapApple = appleBuilder.mBitmapApple;
        // Load the image to the bitmap
        this.mBitmapApple = BitmapFactory.decodeResource(context.getResources(), R.drawable.apple);

        // Resize the bitmap
        this.mBitmapApple = Bitmap.createScaledBitmap(mBitmapApple, this.mSize, this.mSize, false);

        // Make a note of the passed in spawn range
        //mSpawnRange = sr;
        // Make a note of the size of an apple
        //mSize = s;
        // Hide the apple off-screen until the game starts
        // location.x = -10;



    }



    //get methods only provide immutability

    // Draw the apple
    void draw(Canvas canvas, Paint paint){
        canvas.drawBitmap(mBitmapApple,
                location.x * mSize, location.y * mSize, paint);

    }




    public Context getContext(){
        return context;
    }

    public Point getmSpawnRange(){
        return mSpawnRange;
    }
    public int getmSize(){
        return mSize;
    }





    // This is called every time an apple is eaten
    void spawn(){
        // Choose two random values and place the apple
        Random random = new Random();
        location.x = random.nextInt(mSpawnRange.x) + 1;
        location.y = random.nextInt(mSpawnRange.y - 1) + 1;
    }



    // Let SnakeGame know where the apple is
    // SnakeGame can share this with the snake
    Point getLocation(){
        return location;
    }






    public static class AppleBuilder{

        private Point location = new Point();
        // The range of values we can choose from to spawn an apple

        private final Context context;
        private final Point mSpawnRange;
        private final int mSize;


        // An interchangeable image to represent the apple
        private Bitmap mBitmapApple;
        // Load the image to the bitmap
        //mBitmapApple = BitmapFactory.decodeResource(context.getResources(), R.drawable.apple);

        // Resize the bitmap
        //mBitmapApple = Bitmap.createScaledBitmap(mBitmapApple, this.mSize, this.mSize, false);

        /// Set up the apple in the constructor
        public AppleBuilder(Context context, Point mSpawnRange, int mSize){
            this.context = context;
            // Make a note of the passed in spawn range
            this.mSpawnRange = mSpawnRange;
            // Make a note of the size of an apple
            this.mSize = mSize;
            // Hide the apple off-screen until the game starts



        }





        public AppleBuilder mBitmapApple(Bitmap mBitmapApple){
            this.mBitmapApple = mBitmapApple;
            return this;
        }


/*
        public AppleBuilder mSpawnRange(Point mSpawnRange){
            this.mSpawnRange = mSpawnRange;
            return this;
        }
*/
        // Draw the apple
        public Apple build(){
            return new Apple(this);

        }

    }




}




