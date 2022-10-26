package base.game.objects.platforms;

import base.game.objects.GameObject;

import java.awt.*;

public class Platform extends GameObject {

    protected int w, h;

    public Platform(int x, int y, int w, int h) {
        super(x, y);
        this.w = w;
        this.h = h;
    }
    
    @Override
    public void draw(Graphics g) {
        if (!active) return;
        int[] xs = {
                (int)(x - (w - 1) / 2),
                (int)(x - (w - 1) / 2),
                (int)x,
                (int)(x + (w - 1) / 2),
                (int)(x + (w - 1) / 2)
        };
        int[] ys = {
                (int)y,
                (int)(y - (h - 1) / 2),
                (int)(y - (h - 1)),
                (int)(y - (h - 1) / 2),
                (int)y
        };
        g.setColor(new Color(0, 255, 0));
        g.fillPolygon(xs, ys, 5);
        g.setColor(new Color(150, 255, 0));
        g.drawPolygon(xs, ys, 5);
    }

    public Point getLaunchPoint(){
        return new Point((int) x, (int)(y - h));
    }

    public int w() {return w;}
}