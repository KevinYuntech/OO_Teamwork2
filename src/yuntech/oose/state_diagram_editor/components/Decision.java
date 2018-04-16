package yuntech.oose.state_diagram_editor.components;

// TODO

import yuntech.oose.state_diagram_editor.drawing.DiamondDrawable;

import java.awt.*;

public class Decision extends Element {

    /* Fields */

    static private int numOfInstances;

    public Decision(Decision decision) {

    }

    /* Override methods */

    @Override
    protected void initWidthHeight() {
        width = 50;
        height = 50;
    }

    @Override
    protected void initColor() {
        setColor(0X9BC1BC);
    }

    @Override
    protected void initLabel() {
        label = new Label(this.getClass().getSimpleName() + numOfInstances);
        numOfInstances++;
    }

    @Override
    protected void initDrawable() {
        drawable = new DiamondDrawable();
    }

    @Override
    public void draw(Graphics g) {
        drawable.draw(this, g);
        drawable.drawLabel(this, g);
    }

    @Override
    public Element getNewInstance() {
        return new Decision(this);
    }
}
