package com.project.snakeysnake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;


import java.util.ArrayList;

public class SnakeBody {

    private Bitmap mBitmapBody;


    //Create and scale the body
    public SnakeBody(Context context, int ss) {
        mBitmapBody = BitmapFactory
                .decodeResource(context.getResources(),
                        R.drawable.body);

        mBitmapBody = Bitmap
                .createScaledBitmap(mBitmapBody,
                        ss, ss, false);
    }


    public void draw(ArrayList<Point> segmentLocations, int mSegmentSize, Paint paint, Canvas canvas) {
        for (int i = 1; i < segmentLocations.size(); i++) {
            canvas.drawBitmap(mBitmapBody,
                    segmentLocations.get(i).x
                            * mSegmentSize,
                    segmentLocations.get(i).y
                            * mSegmentSize, paint);
        }
    }
}