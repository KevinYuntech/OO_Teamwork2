package yuntech.oose.state_diagram_editor.components;

import java.awt.*;

// TODO
public class State extends Element{
    static private int numOfInstances;
    @Override
    void initLabel() {
        label = new Label(this.getClass().getSimpleName() + numOfInstances);
        numOfInstances++;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillOval(x, y, width, height);
    }
}
