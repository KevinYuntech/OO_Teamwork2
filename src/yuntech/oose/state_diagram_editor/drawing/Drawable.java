package yuntech.oose.state_diagram_editor.drawing;

import yuntech.oose.state_diagram_editor.components.Element;

import java.awt.*;

public abstract class Drawable {

    public abstract Drawable getNewInstance();


    public void drawLabel(Element element, Graphics g) {
        element.drawLabel(g);
    }

    public abstract void draw(Element element, Graphics g);
}
