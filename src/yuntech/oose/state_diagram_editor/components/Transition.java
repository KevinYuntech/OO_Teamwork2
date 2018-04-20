package yuntech.oose.state_diagram_editor.components;

import yuntech.oose.state_diagram_editor.Handle;
import yuntech.oose.state_diagram_editor.drawing.ArrowDrawable;

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

    /* Fields */

    // Number of created instances
    static private int num;
    private Point start;
    private Point end;
    private int wingLength = 10;
    private int wingDegree = 30;
    private Handle[] handles = new Handle[2];

    /* Constructor */
    public Transition() {

    }

    private Transition(Transition transition) {
        super(transition);
        start = transition.start;
        end = transition.end;
        wingLength = transition.wingLength;
        wingDegree = transition.wingDegree;
    }

    /* Public methods */

    public Transition(Point start) {
        this.start = start;

        // If not specify end immediately
        this.end = start;
    }

    public int getWingLength() {
        return wingLength;
    }

    /* Override methods */

    public void setWingLength(int wingLength) {
        this.wingLength = wingLength;
    }

    public int getWingDegree() {
        return wingDegree;
    }

    public void setWingDegree(int wingDegree) {
        this.wingDegree = wingDegree;
    }

    @Override
    protected void initWidthHeight() {
        // Transition has no size in this particular program
    }

    @Override
    protected void initColor() {
        setColor(0);
    }

    @Override
    protected void initLabel() {
        label = new Label(this.getClass().getSimpleName() + num);
        num++;
    }

    @Override
    protected void initDrawable() {
        drawable = new ArrowDrawable();
    }

    @Override
    public void draw(Graphics g) {
        drawable.draw(this, g);
        drawable.drawLabel(this, g);
    }

    @Override
    public Element getInstanceCopy() {
        return new Transition(this);
    }

    /* Getter, Setters */

    // TODO
    @Override
    public void setLocation(int x, int y) {
    }

    // TODO
    @Override
    public void setLocation(Point point) {
    }

    @Override
    public boolean isIntersect(Point point) {
        return label.isIntersect(point);
    }

    public void setStart(int x, int y) {
        setStart(new Point(x, y));
        if (end != null) {
            label.setLocation(start.x + (end.x - start.x) / 2, start.y + (end.y - start.y) / 2);
        }
    }

    public void setEnd(int x, int y) {
        setEnd(new Point(x, y));
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
        if (start != null) {
            label.setLocation(start.x + (end.x - start.x) / 2, start.y + (end.y - start.y) / 2);
        }
    }

    /* Private methods */
    // TODO
    private void drawHandles(Graphics g) {

    }

}
