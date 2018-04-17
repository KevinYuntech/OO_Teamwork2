package yuntech.oose.state_diagram_editor.drawing;

import yuntech.oose.state_diagram_editor.components.Element;

import java.awt.*;

public class DiamondDrawable extends Drawable {

    public DiamondDrawable(){}

    @Override
    public Drawable getNewInstance() {
        return new DiamondDrawable();
    }

    @Override
    public void draw(Element element, Graphics g) {
        g.setColor(element.getColor());
        int tmpx[] = {element.getX() + element.getWidth() / 2, element.getX(), element.getX() + element.getWidth() / 2, element.getX() + element.getWidth()};
        int tmpy[] = {element.getY(), element.getY() + element.getHeight() / 2, element.getY() + element.getHeight(), element.getY() + element.getHeight() / 2,};
        g.drawPolygon(tmpx, tmpy, 4);
        g.fillPolygon(tmpx, tmpy, 4);
    }
}
