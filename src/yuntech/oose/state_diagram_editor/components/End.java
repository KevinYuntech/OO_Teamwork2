package yuntech.oose.state_diagram_editor.components;

// TODO

import yuntech.oose.state_diagram_editor.drawing.CircleInCircleDrawable;

import java.awt.*;

public class End extends Element {

    /* Fields */

    static private int num;

    /* Constructors */

    {
        width = 35;
        height = 35;
        setColor(0x48AEBC);
    }

    /* Override methods */

    @Override
    void initLabel() {
        label = new Label(this.getClass().getSimpleName() + num);
        num++;
    }

    @Override
    void initDrawable() {
        drawable = new CircleInCircleDrawable();
    }


    @Override
    public void draw(Graphics g) {
        drawable.draw(this, g);
    }
}
