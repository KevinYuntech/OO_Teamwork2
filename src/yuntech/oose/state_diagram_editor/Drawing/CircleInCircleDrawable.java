package yuntech.oose.state_diagram_editor.Drawing;

import yuntech.oose.state_diagram_editor.components.Element;

import java.awt.*;

public class CircleInCircleDrawable extends Drawable{
    @Override
    public void draw(Element element, Graphics g) {
        g.setColor(element.getColor());
        g.drawArc(element.getX(), element.getY(), element.getWidth(), element.getHeight(), 0, 360);
        g.fillArc(element.getX()+3, element.getY()+3, element.getWidth()-6, element.getHeight()-6, 0, 360);

    }
}
