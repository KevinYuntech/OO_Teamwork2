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

public class Transition extends Element {

    static private int num;
    private Point start;
    private Point end;
    private int wingLength = 10;
    private int wingDegree = 30;
    private Handle[] handles = new Handle[2];

    /* Constructor */
    public Transition() {

    }

    @Override
    protected void initWidthHeight() {
        // Transition has no size in this particular program
    }

    @Override
    protected void initColor() {
        setColor(0);
    }

    public Transition(Point start) {
        this.start = start;

        // If not specify end immediately
        this.end = start;
    }

    @Override
    protected void initLabel() {
        label = new Label(this.getClass().getSimpleName() + num);
        num++;
    }

    @Override
    protected void initDrawable() {
        // No need for Drawable
    }

    /* Public methods */

    @Override
    public void draw(Graphics g) {
        /* Draw line */
        g.setColor(getColor());
        g.drawLine(start.x, start.y, end.x, end.y);

        /* Draw wings */
        // Math.atan2(double y,double x) takes a vector and return the angle respect to horizontal,
        // range in [-Math.PI, Math.PI]
        // atan --> arc tangent

        double angle = Math.atan2(end.y - start.y, end.x - start.x);

        // wing1
        g.drawLine(end.x, end.y, (int) (end.x - wingLength * Math.cos(angle - Math.toRadians(wingDegree))),
                (int) (end.y - wingLength * Math.sin(angle - Math.toRadians(wingDegree))));
        // wing2
        g.drawLine(end.x, end.y, (int) (end.x - wingLength * Math.cos(angle + Math.toRadians(wingDegree))),
                (int) (end.y - wingLength * Math.sin(angle + Math.toRadians(wingDegree))));

        /* Draw it's label */
        g.setColor(label.getColor());
        label.draw(g);

        // TODO: Get focused
        if (getStatus() == FOCUSEd) {

        }
    }

    // TODO
    @Override
    public void setLocation(int x, int y) {
    }

    // TODO
    @Override
    public void setLocation(Point point) {
    }

    /* Setters */

    public void setStart(int x, int y) {
        setStart(new Point(x, y));
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

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public void setEnd(Point end) {
        this.end = end;
        if (start != null) {
            label.setLocation(start.x + (end.x - start.x) / 2, start.y + (end.y - start.y) / 2);
        }
    }


    /* Private methods */

    private void drawHandles(Graphics g) {

    }

}
