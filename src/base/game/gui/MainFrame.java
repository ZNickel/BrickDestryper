package base.game.gui;

import base.game.logic.GameRun;
import base.game.logic.Geometry;
import base.game.objects.Scene;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(String title) throws HeadlessException {
        super(title);

        Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension FRAME_SIZE = new Dimension(620, 620);
        Dimension SCENE_SIZE = new Dimension(600, 600);

        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_SIZE);
        setLocation(Geometry.getCenter(SCREEN_SIZE, FRAME_SIZE));
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(40, 40, 40));
        setVisible(true);

        JLabel label = new JLabel();
        label.setSize(SCENE_SIZE);
        label.setLocation(Geometry.getCenter(FRAME_SIZE, SCENE_SIZE));
        getContentPane().add(label);

        Scene scene = new Scene(SCENE_SIZE, label);

        GameRun gameRun = new GameRun(scene);
        label.addMouseMotionListener(gameRun);
        label.addMouseListener(gameRun);
        gameRun.run();
    }
}