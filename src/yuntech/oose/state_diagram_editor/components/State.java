package yuntech.oose.state_diagram_editor.components;

import yuntech.oose.state_diagram_editor.drawing.FullRoundRectangleDrawable;

import java.awt.*;

public class State extends Element {

    /* Fields */

    static private int num;

    /* Override methods */

    @Override
    protected void initWidthHeight() {
        width = 150;
        height = 75;
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
        drawable = new FullRoundRectangleDrawable();
    }

    @Override
    public void draw(Graphics g) {
        drawable.draw(this, g);
        drawable.drawLabel(this, g);
    }
}
