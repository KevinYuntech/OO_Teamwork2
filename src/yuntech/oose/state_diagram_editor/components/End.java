package yuntech.oose.state_diagram_editor.components;

// TODO

import yuntech.oose.state_diagram_editor.Drawing.CircleInCircleDrawable;

import java.awt.Color;
import java.awt.Graphics;

public class End extends Element {
    static private int num;

    {
        width = 35;
        height = 35;
        setColor(0x48AEBC);
    }
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
//        g.setColor(getColor());
//        g.drawArc(x, y, width, height, 0, 360);
//        g.fillArc(x+3, y+3, width-6, height-6, 0, 360);
        drawable.draw(this, g);
    }
}
