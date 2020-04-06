package com.project.snakeysnake;

import android.content.Context;
import android.graphics.Point;

import java.io.IOException;


public class GameObject extends TowerGame {

    Point point;
    Context context;
    int blockSize;
    Turret turret;
    Enemy enemy;
    int status;
    Point size;
    private int NUM_BLOCKS_WIDE;




    public GameObject(Context context, Point size) throws IOException {
        super(context, size);


    }


    /*Turret createBadApple(){
        Turret newBadTurret = new Turret.TurretBuilder(
                context, point, blockSize)
                .mBitmapApple() //TODO change to bad apple bitmap
                .build();

        return newBadTurret;
    } */

    /*Turret createApple() {
        Turret newTurret = new Turret.TurretBuilder(
                context, point, blockSize)
                .mBitmapApple()
                .build();

        return newTurret;
    } */

    public int statusSetter(){
        //generate a random status number
        return 1;
    }






    Enemy createSnake() {
        Enemy newEnemy = new Enemy(context, point, blockSize);
        //move call from SnakeGame class to here


        return newEnemy;

    }

}
