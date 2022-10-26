package base.game.objects.balls;

import base.game.logic.Geometry;
import base.game.objects.GameObject;

import java.awt.*;

public class Ball extends GameObject {

    protected double radius, angle = 0;

    public Ball(int x, int y, double radius) {
        super(x, y);
        this.radius = radius;
    }
    public Ball(Point p, double radius) {
        super(p.x, p.y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        if (!active) return;
        g.setColor(new Color(0, 200, 250));
        g.fillOval((int)(x - radius), (int)(y - radius), (int)(radius * 2), (int)(radius * 2));
        g.setColor(new Color(0, 150, 250));
        g.drawOval((int)(x - radius), (int)(y - radius), (int)(radius * 2), (int)(radius * 2));
    }

    public void move(double speed){
        x += speed * Math.cos(Math.toRadians(angle));
        y += speed * Math.sin(Math.toRadians(angle));
    }
    public boolean mirroring(Dimension dimension){
        if(y + radius >= dimension.height - 1){
            return true;
        }
        else{
            if ((x - radius <= 0 || x + radius >= dimension.width - 1))
                angle = Geometry.mirroring(angle, 90);
            else if(y - radius <= 0)
                angle = Geometry.mirroring(angle, 0);
            return false;
        }
    }

    public double radius() {return radius;}
    public void setRadius(double radius) {this.radius = radius;}

    public double angle() {return angle;}
    public void setAngle(double angle) {this.angle = angle;}
}
