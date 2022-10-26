package base.game.objects.aims;

import base.game.logic.Geometry;
import base.game.objects.GameObject;

import java.awt.*;
import java.util.ArrayList;

public class AimLine extends GameObject {

    private Point start, cursor;
    private double launchAngle;
    private final Color color = new Color(0, 255, 150);
    private int deep;
    private Dimension sceneSize;

    public AimLine(Dimension sceneSize, Point start, Point cursor) {
        super(0, 0);
        this.sceneSize = sceneSize;
        this.start = start;
        this.cursor = cursor;
        this.launchAngle = 0;
        deep = 3;
        active = false;
    }

    @Override
    public void draw(Graphics g) {
        if (!active) return;
        ArrayList<Point> points = findAimPoints();
        int size = points.size();
        for (int i = 1; i < size; i++){
            g.setColor(new Color(
                    color.getRed(),
                    color.getGreen(),
                    color.getBlue(),
                    (int) ((255d / size) * (size - i))
            ));
            g.drawLine(points.get(i - 1).x, points.get(i - 1).y, points.get(i).x, points.get(i).y);
        }
    }

    private void findLaunchAngle(){
        double startAngle = Math.toDegrees(Math.atan((cursor.y - start().y + 0d)/(cursor.x - start().x)));
        if(startAngle >= 0) startAngle += 180;
        launchAngle = startAngle;
    }
    private ArrayList<Point> findAimPoints(){
        ArrayList<Point> points = new ArrayList<>();
        points.add(start);
        double trackX = start.x;
        double trackY = start.y;
        double trackAngle = launchAngle;

        int contacts = 0;
        while (contacts < deep){
            trackX += Math.cos(Math.toRadians(trackAngle));
            trackY += Math.sin(Math.toRadians(trackAngle));

            if ((trackX <= 0 || trackX >= sceneSize.width - 1)){
                trackAngle = Geometry.mirroring(trackAngle, 90);
                contacts++;
                points.add(new Point((int)trackX, (int)trackY));
            }
            else if(trackY <= 0 || trackY >= sceneSize.height - 1){
                trackAngle = Geometry.mirroring(trackAngle, 0);
                contacts++;
                points.add(new Point((int)trackX, (int)trackY));
            }
        }
        return points;
    }

    public Point start() {return start;}
    public Point cursor() {return cursor;}
    public double launchAngle() {return launchAngle;}
    public void setStart(Point start) {
        this.start = start;
        findLaunchAngle();
    }
    public void setCursor(Point cursor) {
        if (!active) return;
        this.cursor = cursor;
        findLaunchAngle();
    }
    public void setLaunchAngle(double launchAngle) {this.launchAngle = launchAngle;}
}