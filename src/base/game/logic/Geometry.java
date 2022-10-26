package base.game.logic;

import java.awt.*;

public class Geometry {

    public static Point getCenter(Dimension out, Dimension in){
        return new Point((out.width - in.width) / 2, (out.height - in.height) / 2);
    }

}
