package base.game.objects.platforms;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlatformStatic extends Platform{
    public PlatformStatic(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    @Override
    public void draw(Graphics g) {
        int[] xs = {x - (w - 1) / 2, x - (w - 1) / 2, x, x + (w - 1) / 2, x + (w - 1) / 2};
        int[] ys = {y, y - (h - 1) / 2, y - (h - 1), y -(h - 1) / 2, y};
        g.setColor(new Color(0, 255, 0));
        g.fillPolygon(xs, ys, 5);
        g.setColor(new Color(150, 255, 0));
        g.drawPolygon(xs, ys, 5);
    }
}