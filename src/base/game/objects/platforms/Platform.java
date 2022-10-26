package base.game.objects.platforms;

import base.game.objects.GameObject;

import java.awt.*;

public abstract class Platform extends GameObject {

    protected int w, h;

    public Platform(int x, int y, int w, int h) {
        super(x, y);
        this.w = w;
        this.h = h;
    }

    public Point getLaunchPoint(){
        return new Point(x - w/2, y - h);
    }
}