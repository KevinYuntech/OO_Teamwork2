package yuntech.oose.state_diagram_editor.components;

import yuntech.oose.state_diagram_editor.drawing.RoundRectangleDrawable;
import yuntech.oose.state_diagram_editor.flyweight.FlyweightFactory;
import yuntech.oose.state_diagram_editor.singleton.WordSingleton;

import java.awt.*;
import java.util.LinkedList;

public class Composite extends Element {

    /* Fields */

    // Number of created instances
    static private int num;
    // Store Elements in this composite
    private LinkedList<Element> elementList = new LinkedList<>();

    /* Constructors */

    public Composite() {

    }

    private Composite(Composite composite) {
        super(composite);
        for (Element element : composite.elementList) {
            elementList.add(element.getInstanceCopy());
        }
    }

    /* Override methods */


    @Override
    protected void initWidthHeight() {
        width = 200;
        height = 350;
    }

    @Override
    protected void initColor() {
        setColor(888954);
    }

    @Override
    protected void initLabel() {
        label = new Label(this.getClass().getSimpleName() + num);
        num++;
        label.x = x;
        label.y = y;
    }

    @Override
    protected void initDrawable() {
        drawable = new RoundRectangleDrawable();
    }

    @Override
    public void draw(Graphics g) {
        // Draws this Composite
        drawable.draw(this, g);
        drawable.drawLabel(this, g);

        // Draws Elements inside this Composite
        for (Element element : elementList) {
            element.setFont(new Font(WordSingleton.getInstance().getFontName(),
                    WordSingleton.getInstance().getFontStyle(),
                    WordSingleton.getInstance().getFontSize()));
            element.setLabelColor(FlyweightFactory.getFlyweightFactory().
                    getColorFlyweight(WordSingleton.getInstance().getFontColor().getRGB()).getRGB());
            element.draw(g);
        }
    }

    @Override
    public Element getInstanceCopy() {
        return new Composite(this);
    }

    // Override it to prevent from being bug if one change this function in Element
    @Override
    public void setLocation(int x, int y) {
        setLocation(new Point(x, y));
    }


    // Set location of this Composite so does Elements in this Composite
    @Override
    public void setLocation(Point point) {
        // Set location of this Composite
        x = point.x;
        y = point.y;
        label.x = x;
        label.y = y;

        // Set location of Elements in this Composite
        for (Element element : elementList) {
            element.setLocation(point.x + element.dx, point.y + element.dy);
        }
    }

    // Add Element to this Composite
    @Override
    public void add(Element element) {
        elementList.add(element);

        // Determine relative location
        element.dx = element.x - x;
        element.dy = element.y - y;
    }
}

