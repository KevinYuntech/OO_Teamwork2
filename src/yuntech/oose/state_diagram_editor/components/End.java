package yuntech.oose.state_diagram_editor.components;

// TODO

import java.awt.Color;
import java.awt.Graphics;

public class End extends Element {
    static private int num;
    
    {
        width = 50;
        height = 50;
        color = new Color(0x48AEBC);
    }
    @Override
    void initLabel() {
        label = new Label(this.getClass().getSimpleName() + num);
        num++;
    }
    
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);//unknown
        //g.fillOval(x, y, width, height);
        g.drawArc(x, y, width, height, 0, 360);
        g.fillArc(x, y, width-5, height-5, 0, 360);
        super.draw(g);
    }
}
