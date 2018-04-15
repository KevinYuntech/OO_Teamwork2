package yuntech.oose.state_diagram_editor.components;

import yuntech.oose.state_diagram_editor.drawing.RoundRectangleDrawable;
import yuntech.oose.state_diagram_editor.singleton.WordSingleton;

import java.awt.*;
import java.util.LinkedList;

// TODO
public class Composite extends Element {
    /* Fields */

    static private int num;
    LinkedList<Element> elementList = new LinkedList<>();

    /* Constructors */

    {
        width = 200;
        height = 350;
        setColor(888954);
        label.x = x;
        label.y = y;
    }

    /* Override methods */

    @Override
    void initLabel() {
        label = new Label(this.getClass().getSimpleName() + num);
        num++;
    }

    @Override
    void initDrawable() {
        drawable = new RoundRectangleDrawable();
    }

    @Override
    public void draw(Graphics g) {
        drawable.draw(this, g);
        drawable.drawLabel(this, g);
        for (Element element : elementList) {
            element.setFont(new Font(WordSingleton.getInstance().getFontName(), WordSingleton.getInstance().getFontStyle(), WordSingleton.getInstance().getFontSize()));
            element.draw(g);
        }

    }

    @Override
    public void setLocation(int x, int y) {
        setLocation(new Point(x, y));
    }

    @Override
    public void setLocation(Point point) {
        for (Element element : elementList) {
            element.setLocation(point.x + element.dx, point.y + element.dy);
        }

        x = point.x;
        y = point.y;
        label.x = x;
        label.y = y;
    }

    @Override
    public void add(Element element) {
        elementList.add(element);
        element.dx = element.x - x;
        element.dy = element.y - y;
    }
}

