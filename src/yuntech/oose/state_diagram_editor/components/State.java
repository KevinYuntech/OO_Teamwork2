package yuntech.oose.state_diagram_editor.components;

import java.awt.*;

public class State extends Element{

    /* Fields */

    static private int num;

    {
        width = 150;
        height = 75;
        setColor(0x48AEBC);
    }

    /* Override methods */

    @Override
    void initLabel() {
        label = new Label(this.getClass().getSimpleName() + num);
        num++;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRoundRect(x, y, width, height, 25, 25);
        super.draw(g);
    }

}
