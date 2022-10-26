package base.game.objects.balls;

import base.game.objects.GameObject;

public abstract class Ball extends GameObject {

    protected double radius;
    public Ball(int x, int y) {
        super(x, y);
    }

    public double radius() {return radius;}
    public void setRadius(double radius) {this.radius = radius;}
}
