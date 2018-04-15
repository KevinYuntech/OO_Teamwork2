package yuntech.oose.state_diagram_editor.Drawing;

import yuntech.oose.state_diagram_editor.components.Element;

import java.awt.*;

public abstract class Drawable {

    public void drawLabel(Element element, Graphics g){
//        element.setLabelColor(element.getLabelColor().getRGB());
        element.drawLabel(g);
    }

    public abstract void draw(Element element, Graphics g);
}
