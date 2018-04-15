package yuntech.oose.state_diagram_editor.components;

// TODO

import yuntech.oose.state_diagram_editor.drawing.CircleDrawable;

import java.awt.Graphics;

public class Start extends Element {
    static private int num;
    
    {
        width = 35;
        height = 35;
        setColor(0xFF70A6);
    }
    
    @Override
    void initLabel() {
        label = new Label(this.getClass().getSimpleName() + num);
        num++;
    }

    @Override
    void initDrawable() {
        drawable = new CircleDrawable();
    }

    @Override
    public void draw(Graphics g) {
//        g.setColor(getColor());
//        g.fillOval(x, y, width, height);
        drawable.draw(this, g);
    }
}
