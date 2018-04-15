package yuntech.oose.state_diagram_editor.Drawing;

import yuntech.oose.state_diagram_editor.components.Element;

import java.awt.*;

public class RoundRectangleDrawable extends Drawable {

    @Override
    public void draw(Element element, Graphics g) {
        g.setColor(element.getColor());
        g.drawRoundRect(element.getX(), element.getY(), element.getWidth(), element.getHeight(), 25, 25);
    }
}
