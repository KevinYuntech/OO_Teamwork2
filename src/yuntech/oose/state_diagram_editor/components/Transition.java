package yuntech.oose.state_diagram_editor.components;

import yuntech.oose.state_diagram_editor.Handle;

import java.awt.*;

/*
 * An transition is composed with a line and two wings.
 * A line is defined by a start point and an end point.
 * While wings have lines to be "Direct".
 * A wing is defined by a start point, while attach on the end point of a line, and an end point.
 * The end point of a wing is determined by wingLength and wingDegree respect to the start point.
 * wingLength is the length of wing; wingDegree is the angle respect to the line it attached.
 */

public class Transition extends Element{

    {
    }


    static private int num;
    @Override
    void initLabel() {
        label = new Label(this.getClass().getSimpleName() + num);
        num++;
    }

    private Point start;
    private Point end;
    private int wingLength = 10;
    private int wingDegree = 30;

    private Handle[] handles = new Handle[2];

    /* Constructor */
    public Transition(){

    }


    public Transition(Point start) {
        this.start = start;

        // If not specify end immediately
        this.end = start;
    }

    /* Public methods */

    @Override
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
        super.draw(g);
    }

    @Override
    public void setLocation(int x, int y) {
    }

    @Override
    public void setLocation(Point point) {
    }

    /* Setters */

    public void setStart(Point start) {
        this.start = start;
    }
    public void setStart(int x, int y) {
        setStart(new Point(x, y));
    }

    public void setEnd(Point end) {
        this.end = end;
        if (start != null) {
            label.setLocation(start);
        }
    }

    public void setEnd(int x, int y) {
        setEnd(new Point(x, y));
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

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }


    /* Private methods */

    private void drawHandles(Graphics g) {

    }

}
