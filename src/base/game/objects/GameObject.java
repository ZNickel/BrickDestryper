package base.game.objects;

import java.awt.*;

public abstract class GameObject {

    private int x, y;
    public abstract void draw(Graphics g);

    public int x() {return x;}
    public int y() {return y;}
    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
}