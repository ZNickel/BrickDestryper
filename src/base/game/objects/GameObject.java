package base.game.objects;

import java.awt.*;

public abstract class GameObject {

    protected double x, y;
    protected boolean active = true;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Graphics g);

    public double x() {return x;}
    public double y() {return y;}
    public boolean active() {return active;}
    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
    public void setXY(Point p){
        x = p.x;
        y = p.y;
    }
    public void setActive(boolean active) {this.active = active;}
}