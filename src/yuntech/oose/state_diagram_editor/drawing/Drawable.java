package yuntech.oose.state_diagram_editor.drawing;

import yuntech.oose.state_diagram_editor.components.Element;

import java.awt.*;
import java.io.Serializable;

public abstract class Drawable implements Serializable {

    public Drawable() {

    }

    public abstract Drawable getNewInstance();

    public void drawLabel(Element element, Graphics g) {
        g.setFont(element.getFont());
        element.drawLabel(g);
    }

    abstract public void draw(Element element, Graphics g);
}
