package base.game.logic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GameRun implements Runnable, MouseListener, MouseMotionListener {

    private long Tick = 0;
    private boolean gameStop = false;
    private final Scene scene;
    private boolean launching = false;

    public GameRun(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void run() {
        while (!gameStop){
            nextTick();

            if(launching && Tick % 3 == 0) launching = scene.launch();
            scene.moveBalls();

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
        scene.aimOff();
        if(scene.readyToLaunch()) launching = true;
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        scene.aimUpdate(e.getPoint());
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if (scene.readyToLaunch()) scene.aimOn();
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if (scene.readyToLaunch()) scene.aimOff();
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseDragged(MouseEvent e) {}
}
