package com.test.operationpenguinpanic;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Random;

//Controller for the projectiles on the asteroidGP
public class Asteroid extends GameObject{
    private int score;
    private int speed;
    private Random rand = new Random();
    private Animation animation = new Animation();
    private Bitmap spritesheet;
    //(image, x coord, y coord, width, height, getScore, frames for animation)
    public Asteroid(Bitmap res, int x, int y, int w, int h, int s, int numFrames)
    {
        super.x = x;
        super.y = y;
        width = w;
        height = h;
        score = s;

        speed = 7 + (int) (rand.nextDouble()*score/30);

        //cap projectile speed
        if(speed>40)speed = 40;

        Bitmap[] image = new Bitmap[numFrames];

        spritesheet = res;

        for(int i = 0; i<image.length;i++)
        {
            image[i] = Bitmap.createBitmap(spritesheet, 0, i*height, width, height);
        }

        animation.setFrames(image);
        animation.setDelay(100 - speed);

    }
    //Angles that the asteroids spawn
    public void south()
    {
        y+=speed;
        animation.update();
    }

    public void draw(Canvas canvas)
    {
        try{
            canvas.drawBitmap(animation.getImage(),x,y,null);
        }catch(Exception e){}
    }

    @Override
    public int getWidth()
    {
        return width;
    }
}
