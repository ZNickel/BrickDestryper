package base.game.objects.bricks;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BrickSimple extends Brick{

    private int w, h;

    public BrickSimple(int x, int y, int health, int maxHealth, int w, int h) {
        super(x, y, health, maxHealth);
        this.w = w;
        this.h = h;
    }

    @Override
    public void draw(Graphics g) {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics sg = img.getGraphics();
        Color mainColor = findMainColor();
        sg.setColor(mainColor);
        sg.fillRect(0, 0, w - 1, h - 1);
        int gradientDeep = Math.min(w, h) / 8;
        for (int i = 0; i < gradientDeep; i++){
            sg.setColor(findBorderColor(mainColor, false, gradientDeep, gradientDeep - i));
            sg.drawLine(i, i, w - (i + 1), i);
            sg.drawLine(i, i, i, h - (i + 1));
            sg.setColor(findBorderColor(mainColor, true, gradientDeep, gradientDeep - i));
            sg.drawLine(w - (i + 1), h - (i + 1), i, h - (i + 1));
            sg.drawLine(w - (i + 1), h - (i + 1), w - (i + 1), i);
        }

        Font font = new Font("Arial", Font.BOLD, 16);
        sg.setFont(font);
        sg.setColor(Color.BLACK);

        String text = health + "";
        FontMetrics metrics = sg.getFontMetrics(font);
        sg.drawString(
                text,
                (w - metrics.stringWidth(text)) / 2,
                ((h - metrics.getHeight()) / 2) + metrics.getAscent()
        );

        g.drawImage(img, x, y, null);
    }

    public int w() {return w;}
    public int h() {return h;}
    public void setW(int w) {this.w = w;}
    public void setH(int h) {this.h = h;}
}