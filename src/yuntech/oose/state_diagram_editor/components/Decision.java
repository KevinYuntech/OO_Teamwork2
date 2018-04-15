package yuntech.oose.state_diagram_editor.components;

// TODO

import yuntech.oose.state_diagram_editor.Drawing.DiamondDrawable;

import java.awt.Color;
import java.awt.Graphics;

public class Decision extends Element {
    static private int numOfInstances;
    {
        width = 50;
        height = 50;
        setColor(255);

        //setColor(new Color(0x48AEBC));
    }


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
//        g.setColor(getColor());
//        int tmpx[] = {x+width/2, x,  x+width/2,x+width};
//        int tmpy[] = {y, y+height/2,  y+height,y+height/2,};
//        g.drawPolygon(tmpx, tmpy, 4);
//        g.fillPolygon(tmpx, tmpy, 4);
//        super.draw(g);

        drawable.drawLabel(this, g);
        drawable.draw(this, g);
    }
}
