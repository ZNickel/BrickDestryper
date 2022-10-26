package base.game.objects;

import java.awt.*;

public abstract class GameObject {

    protected double x, y;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Graphics g);

    public double x() {return x;}
    public double y() {return y;}
    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
}