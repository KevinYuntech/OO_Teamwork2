import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/*
 * An arrow is composed with a line and two wings.
 * A line is defined by a start point and an end point.
 * While wings have lines to be "Direct".
 * A wing is defined by a start point, while attach on the end point of a line, and an end point.
 * The end point of a wing is determined by wingLength and wingDegree respect to the start point.
 * wingLength is the length of wing; wingDegree is the angle respect to the line it attached.
 */
public class Arrow extends  Element{
    private Point start;

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    private Point end;
    private int wingLength = 10;
    private int wingDegree = 30;

    private Handle[] handles = new Handle[2];

    /* Constructor */
    Arrow(Point start) {
        this.start = start;

        // If not specify end immediately
        this.end = start;
    }

    /* Public methods */
    public void draw(Graphics g) {
        /* Draw line */
        g.setColor(color);
        g.drawLine(start.x, start.y, end.x, end.y);

        /* Draw wings */

        // Math.atan2(double y,double x) takes a vector and return the angle respect to horizontal, range in [-Math.PI, Math.PI]
        // atan --> arc tangent
        double angle = Math.atan2(end.y - start.y, end.x - start.x);

        // wing1
        g.drawLine(end.x, end.y, (int) (end.x - wingLength * Math.cos(angle - Math.toRadians(wingDegree))), (int) (end.y - wingLength * Math.sin(angle - Math.toRadians(wingDegree))));
        // wing2
        g.drawLine(end.x, end.y, (int) (end.x - wingLength * Math.cos(angle + Math.toRadians(wingDegree))), (int) (end.y - wingLength * Math.sin(angle + Math.toRadians(wingDegree))));

        // TODO: Get focused
        if (getStatus() == FOCUSEd) {

        }
    }


    /* Setters */
    public void setStart(Point start) {
        this.start = start;
    }

    public void setStart(int x, int y) {
        this.start.x = x;
        this.start.y = y;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public void setEnd(int x, int y) {
        this.end.x = x;
        this.end.y = y;
    }

    public void setWingLength(int wingLength) {
        this.wingLength = wingLength;
    }

    public void setWingDegree(int wingDegree) {
        this.wingDegree = wingDegree;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /* Private methods */
    private void drawHandles(Graphics g) {

    }

}
