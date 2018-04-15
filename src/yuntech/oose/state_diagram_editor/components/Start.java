package yuntech.oose.state_diagram_editor.components;

// TODO

import java.awt.Color;
import java.awt.Graphics;

public class Start extends Element {
    static private int num;
    
    {
        width = 50;
        height = 50;
        setColor(0x48AEBC);
    }
    
    @Override
    void initLabel() {
        label = new Label(this.getClass().getSimpleName() + num);
        num++;
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.black);//unknown
        g.fillOval(x, y, width, height);
        super.draw(g);
    }
}
