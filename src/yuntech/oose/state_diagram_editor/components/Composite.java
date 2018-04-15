package yuntech.oose.state_diagram_editor.components;

import java.awt.*;
import java.util.LinkedList;

// TODO
public class Composite extends Element {
    static private int num;

    LinkedList<Element> elementList = new LinkedList<>();

    {
        width = 200;
        height = 350;
        setColor(888954);
        label.x = x;
        label.y = y;
    }

    @Override
    void initLabel() {
        label = new Label(this.getClass().getSimpleName() + num);
        num++;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawRoundRect(x, y, width, height, 25, 25);
        for (Element element : elementList) {
            element.draw(g);
        }
        super.draw(g);
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

