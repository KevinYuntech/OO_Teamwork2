package yuntech.oose.state_diagram_editor.components;

// TODO

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
    public void draw(Graphics g) {
        g.setColor(getColor());
       /*
        int tmpx[] = {x+width/2, x,  x+width/2,x+width};
        int tmpy[] = {y, y-height/2,  y-height,y-height/2,};
        */
        int tmpx[] = {x+width/2, x,  x+width/2,x+width};
        int tmpy[] = {y, y-height/2,  y-height,y-height/2,};
        /*
        int tmpx[] = {100, 120, 140, 120};
        int tmpy[] = {200, 230, 200, 170};
        */
       
        g.drawPolygon(tmpx, tmpy, 4);
        g.fillPolygon(tmpx, tmpy, 4);
        super.draw(g);
    }
}
