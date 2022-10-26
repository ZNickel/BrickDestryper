package base.game.objects;

import base.game.objects.aims.AimLine;
import base.game.objects.balls.Ball;
import base.game.objects.bricks.Brick;
import base.game.objects.platforms.Platform;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Scene {

    private AimLine aimLine;
    private Ball[] balls;
    private Brick[][] bricks;
    private Platform platform;
    private final Dimension size;
    private final BufferedImage sceneImage;
    private final JLabel label;

    public Scene(int w, int h, JLabel label) {
        this.size = new Dimension(w, h);
        this.label = label;
        sceneImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    }

    public void update(){
        Graphics graphics = sceneImage.getGraphics();
        graphics.setColor(Color.BLACK);// TODO: 26.10.2022 BG Image
    }

}