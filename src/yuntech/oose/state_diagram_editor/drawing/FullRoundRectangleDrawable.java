package yuntech.oose.state_diagram_editor.drawing;

import yuntech.oose.state_diagram_editor.components.Element;

import java.awt.*;

public class FullRoundRectangleDrawable extends Drawable {

    public FullRoundRectangleDrawable() {

    }

    @Override
    public Drawable getNewInstance() {
        return new FullRoundRectangleDrawable();
    }

    @Override
    public void draw(Element element, Graphics g) {
        g.setColor(element.getColor());
        g.fillRoundRect(element.getX(), element.getY(), element.getWidth(), element.getHeight(), 25, 25);
    }
}
