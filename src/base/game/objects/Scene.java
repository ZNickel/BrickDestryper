package base.game.objects;

import base.game.objects.aims.AimLine;
import base.game.objects.balls.Ball;
import base.game.objects.bricks.Brick;
import base.game.objects.platforms.Platform;
import base.game.objects.platforms.PlatformStatic;

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

    public Scene(Dimension size, JLabel label) {
        this.size = size;
        this.label = label;
        sceneImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);

        platform = new PlatformStatic(size.width / 2, size.height - 1, 40, 16);

    }

    public void update(){
        Graphics graphics = sceneImage.getGraphics();
        graphics.setColor(new Color(60, 60, 60));// TODO: 26.10.2022 BG Image
        graphics.fillRect(0, 0, size.width, size.height);
        platform.draw(graphics);

        label.setIcon(new ImageIcon(sceneImage));
    }

}