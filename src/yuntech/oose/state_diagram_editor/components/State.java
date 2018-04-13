package yuntech.oose.state_diagram_editor.components;

import java.awt.*;

public class State extends Element{

    /* Fields */

    static private int numOfInstances;

    /* Override methods */

    @Override
    void initLabel() {
        label = new Label(this.getClass().getSimpleName() + numOfInstances);
        numOfInstances++;

        System.out.println(getLocation());
        System.out.println(label.getLocation());
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
}
