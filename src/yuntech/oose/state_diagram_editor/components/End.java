package yuntech.oose.state_diagram_editor.components;

// TODO

import yuntech.oose.state_diagram_editor.drawing.CircleInCircleDrawable;

import java.awt.*;

public class End extends Element {

    /* Fields */

    // Number of created instances
    static private int num;

    /* Constructors */

    public End(){

    }

    private End(End end) {
        super(end);
    }

    /* Override methods */

    @Override
    protected void initWidthHeight() {
        width = 35;
        height = 35;
    }

    @Override
    protected void initColor() {
        setColor(0x48AEBC);
    }

    @Override
    protected void initLabel() {
        label = new Label(this.getClass().getSimpleName() + num);
        num++;
    }

    @Override
    protected void initDrawable() {
        drawable = new CircleInCircleDrawable();
    }


    @Override
    public void draw(Graphics g) {
        drawable.draw(this, g);
    }

    @Override
    public Element getInstanceCopy() {
        return new End(this);
    }
}
