package base.game.objects.bricks;

import base.game.objects.GameObject;

import java.awt.*;

public abstract class Brick extends GameObject {

    protected final Color color_high = new Color(0, 255, 0);
    protected final Color color_mid = new Color(255, 255, 0);
    protected final Color color_low = new Color(255, 0, 0);

    protected int health, maxHealth;

    public Brick(int x, int y, int health, int maxHealth) {
        super(x, y);
        this.health = health;
        this.maxHealth = maxHealth;
    }

    protected Color findBorderColor(Color color, boolean toDark, int maxDeep, int deep){
        int r = color.getRed(), g = color.getGreen(), b = color.getBlue();
        if (toDark){
            r -= (r / (maxDeep + 4)) * deep;
            g -= (g / (maxDeep + 4)) * deep;
            b -= (b / (maxDeep + 4)) * deep;
        }
        else{
            r += ((255 - r) / (maxDeep + 4)) * deep;
            g += ((255 - g) / (maxDeep + 4)) * deep;
            b += ((255 - b) / (maxDeep + 4)) * deep;
        }
        return new Color(r, g, b);
    }

    protected Color findMainColor(){
        Color c1 = health <= (maxHealth / 2) ? color_low : color_mid;
        Color c2 = health <= (maxHealth / 2) ? color_mid : color_high;
        double percent = (health <= maxHealth / 2 ? health : health - (maxHealth / 2d)) / (maxHealth / 2d);

        int r = (int) (c1.getRed() + ((c2.getRed() - c1.getRed()) * percent));
        int g = (int) (c1.getGreen() + ((c2.getGreen() - c1.getGreen()) * percent));
        int b = (int) (c1.getBlue() + ((c2.getBlue() - c1.getBlue()) * percent));

        return new Color(r, g, b);
    }

    public int maxHealth() {return maxHealth;}
    public int health() {return health;}
    public void setMaxHealth(int maxHealth) {this.maxHealth = maxHealth;}
    public void setHealth(int health) {this.health = health;}
}
