package base.game.logic;

import base.game.objects.aims.AimLine;
import base.game.objects.balls.Ball;
import base.game.objects.bricks.Brick;
import base.game.objects.platforms.Platform;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Scene {

    private final int BRICK_W = 50, BRICK_H = 30;
    private final int maxLaunchingAmount = 10;

    private int launchedAmount = 0;
    private double gameSpeed = 5;

    private final AimLine aimLine;
    private final ArrayList<Ball> balls = new ArrayList<>();
    private final ArrayList<Brick> bricks = new ArrayList<>();
    private final Platform platform;
    private final Dimension size;
    private final BufferedImage sceneImage;
    private final JLabel label;

    public Scene(Dimension size, JLabel label) {
        this.size = size;
        this.label = label;
        sceneImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);

        platform = new Platform(size.width / 2, size.height - 1, 40, 16);
        aimLine = new AimLine(size, platform.getLaunchPoint(), platform.getLaunchPoint());

        for(int x = 1; x <= 5; x += 2)
            for(int y = 1; y <= 5; y += 2)
                bricks.add(new Brick(x * BRICK_W, y * BRICK_H, BRICK_W, BRICK_H, 100));
        for(int i = 0; i < maxLaunchingAmount; i++){
            Ball ball = new Ball(platform.getLaunchPoint(), 5d);
            ball.setActive(false);
            balls.add(ball);
        }
    }

    public void update(){
        Graphics graphics = sceneImage.getGraphics();
        graphics.setColor(new Color(60, 60, 60));// TODO: 26.10.2022 BG Image
        graphics.fillRect(0, 0, size.width, size.height);

        platform.draw(graphics);
        aimLine.draw(graphics);
        for (Ball ball : balls) ball.draw(graphics);
        for (Brick brick : bricks) brick.draw(graphics);

        label.setIcon(new ImageIcon(sceneImage));
    }

    public boolean launch(){
        balls.get(launchedAmount).setActive(true);
        launchedAmount++;
        return launchedAmount < maxLaunchingAmount;
    }
    public boolean readyToLaunch(){
        boolean result = true;
        for(Ball ball : balls) if (ball.active()) result = false;
        if (result) for(Ball ball : balls){
            ball.setXY(platform.getLaunchPoint());
            ball.setAngle(aimLine.launchAngle());
        }
        return result;
    }

    public void moveBalls(){
        for (Ball ball : balls)
            if (ball.active()){
                ball.move(gameSpeed);
                if (ball.mirroring(size)){
                    ball.setActive(false);
                    launchedAmount--;
                    if (launchedAmount == 0)
                        aimOn();// TODO: 26.10.2022 Fix aim activate when cursor out of scene bounds 
                    else if (launchedAmount == 9){
                        int halfPW = platform.w() / 2;
                        platform.setX((int) Math.min(Math.max(halfPW, ball.x()), size.width - 1 - halfPW));
                        aimLine.setStart(platform.getLaunchPoint());
                    }
                }
            }
    }

    public void aimUpdate(Point point){
        aimLine.setCursor(point);
    }
    public void aimOff(){
        aimLine.setActive(false);
    }
    public void aimOn(){
        aimLine.setActive(true);
    }
}