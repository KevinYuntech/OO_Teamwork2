package yuntech.oose.state_diagram_editor.drawing;

import yuntech.oose.state_diagram_editor.components.Element;

import java.awt.*;

public class CircleDrawable extends Drawable {

    @Override
    public Drawable getNewInstance() {
        return new CircleDrawable();
    }

    @Override
    public void draw(Element element, Graphics g) {
        g.setColor(element.getColor());
        g.fillOval(element.getX(), element.getY(), element.getWidth(), element.getHeight());
    }
}
