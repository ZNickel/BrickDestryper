package base.game.logic;

import java.awt.*;

public class Geometry {

    public static Point getCenter(Dimension out, Dimension in){
        return new Point((out.width - in.width) / 2, (out.height - in.height) / 2);
    }

    public static double mirroring(double ballAngle, double wallAngle){
        double angle = ballAngle + 2 * (wallAngle - ballAngle) + 360 * 5;
        angle %= 360;
        return angle > 180 ? angle - 360 : angle;
    }

}
