package base.game.logic;

import base.game.objects.Scene;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameRun implements Runnable, MouseListener, MouseMotionListener {

    private long Tick = 0;
    private boolean gameStop = false;
    private final Scene scene;

    public GameRun(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void run() {
        while (!gameStop){
            nextTick();
        }
    }

    private void nextTick(){
        try {
            Thread.sleep(10);
            scene.update();
            Tick++;
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Can't sleep");
        }
    }

    public void gameStop(){
        gameStop = true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mouseMoved(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseDragged(MouseEvent e) {}
}
