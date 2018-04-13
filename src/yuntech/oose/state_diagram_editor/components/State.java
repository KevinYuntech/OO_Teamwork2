package yuntech.oose.state_diagram_editor.components;

import java.awt.*;

public class State extends Element{

    /* Fields */

    static private int numOfInstances;

    {
        width = 75;
        height = 75;
        setColor(new Color(0x48AEBC));
    }

    /* Override methods */

    @Override
    void initLabel() {
        label = new Label(this.getClass().getSimpleName() + numOfInstances);
        numOfInstances++;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
        super.draw(g);
    }

}
