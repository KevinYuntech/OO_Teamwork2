package yuntech.oose.state_diagram_editor.drawing;

import yuntech.oose.state_diagram_editor.components.Element;

import java.awt.*;

public class CircleInCircleDrawable extends Drawable {

    public CircleInCircleDrawable() {

    }

    @Override
    public Drawable getNewInstance() {
        return new CircleInCircleDrawable();
    }

    @Override
    public void draw(Element element, Graphics g) {
        g.setColor(element.getColor());
        g.drawArc(element.getX(), element.getY(), element.getWidth(), element.getHeight(), 0, 360);
        g.fillArc(element.getX() + 5, element.getY() + 5, element.getWidth() - 10, element.getHeight() - 10, 0, 360);
    }
}
