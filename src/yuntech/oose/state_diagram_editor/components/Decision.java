package yuntech.oose.state_diagram_editor.components;

// TODO

import yuntech.oose.state_diagram_editor.drawing.DiamondDrawable;

import java.awt.Graphics;

public class Decision extends Element {

    /* Fields */

    static private int numOfInstances;

    /* Constructors */

    {
        width = 50;
        height = 50;
        setColor(0X9BC1BC);
    }

    /* Override methods */

    @Override
    void initLabel() {
        label = new Label(this.getClass().getSimpleName() + numOfInstances);
        numOfInstances++;
    }

    @Override
    void initDrawable() {
        drawable = new DiamondDrawable();
    }

    @Override
    public void draw(Graphics g) {
        drawable.draw(this, g);
        drawable.drawLabel(this, g);
    }
}
