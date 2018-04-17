package yuntech.oose.state_diagram_editor.drawing;

import yuntech.oose.state_diagram_editor.components.Element;

import java.awt.*;

public class StringDrawable extends Drawable {
    public StringDrawable(){

    }

    @Override
    public Drawable getNewInstance() {
        return new StringDrawable();
    }

    @Override
    public void draw(Element element, Graphics g) {
        g.setColor(element.getColor());
        g.drawString(element.getText(), element.getX(), element.getY());
    }
}
