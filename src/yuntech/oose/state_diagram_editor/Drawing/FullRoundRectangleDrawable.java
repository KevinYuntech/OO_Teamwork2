package yuntech.oose.state_diagram_editor.Drawing;

import yuntech.oose.state_diagram_editor.components.Element;

import java.awt.*;

public class FullRoundRectangleDrawable extends Drawable{
    @Override
    public void draw(Element element, Graphics g) {
        g.setColor(element.getColor());
        g.fillRoundRect(element.getX(), element.getY(), element.getWidth(), element.getHeight(), 25, 25);
    }
}
