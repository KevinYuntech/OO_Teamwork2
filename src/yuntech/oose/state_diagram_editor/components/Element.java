package yuntech.oose.state_diagram_editor.components;

import yuntech.oose.state_diagram_editor.Draggable;
import yuntech.oose.state_diagram_editor.Handle;
import yuntech.oose.state_diagram_editor.Resizable;
import yuntech.oose.state_diagram_editor.drawing.Drawable;
import yuntech.oose.state_diagram_editor.flyweight.FlyweightFactory;

import java.awt.*;

// NOTE: Gatter always return new object so outer won't have the ability to modify data of a class
public abstract class Element implements Draggable, Resizable {
    /* status types */

    public static final int NORMAL = 0;
    public static final int FOCUSEd = 1;

    /* Fields */

    // Subclass can use initializer block to set the default values
    protected int x;
    protected int y;
    protected int dx;
    protected int dy;
    protected int width;
    protected int height;
    protected Handle[] handles;
    protected Label label;
    protected int status = NORMAL;     // 0: normal, 1:focused
    protected Drawable drawable;
    private Color color;
    private FlyweightFactory factory = FlyweightFactory.getFlyweightFactory();


    /* Constructors */

    // Called by call subclass while it was creating
    Element() {
        initWidthHeight();
        initColor();
        initLabel();
        initDrawable();
    }

    protected abstract void initWidthHeight();  // Initialize fields width and height
    protected abstract void initColor();        // Initialize field color
    protected abstract void initLabel();        // Initialize field label
    protected abstract void initDrawable();     // Initialize field drawable

    /*
    public Element(Element element) {
        x = element.x;
        y = element.y;
        dx = element.dx;
        dy = element.dy;
        width = element.width;
        height = element.height;
        handles = new Handle[handles.length];
        for (int i = 0; i < element.handles.length; i++) {
            handles[i] = new Handle(element.handles[i]);
        }
        status = element.status;
        drawable = this.drawable.getNewInstance();
        label = new Label(element.getText());
        color = element.getColor();
    }
    */


    /* Public methods */

    abstract public void draw(Graphics g);

    public Element getNewInstance(Element element){
        x = element.x;
        y = element.y;
        dx = element.dx;
        dy = element.dy;
        width = element.width;
        height = element.height;
        handles = new Handle[handles.length];
        for (int i = 0; i < element.handles.length; i++) {
            handles[i] = new Handle(element.handles[i]);
        }
        status = element.status;
        drawable = this.drawable.getNewInstance();
        label = new Label(element.getText());
        color = element.getColor();

        return element;
    }

    // TODO: Make it abstract
    public boolean isIntersect(Point point) {
        return point.x > x &&
                point.x < x + width &&
                point.y > y &&
                point.y < y + height;
    }

    public String getText() {
        return label.getText();
    }

    public void setText(String text) {
        label.setText(text);
    }

    public void setFont(Font font) {
        label.setFont(font);
    }

    public void add(Element element) {

    }

    public void remove(Element element) {

    }

    /* Override methods */

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Point getLocation() {
        return new Point(x, y);
    }

    @Override
    public void setLocation(Point point) {
        setLocation(point.x, point.y);
    }

    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;

        // Update its label also (to center of this)
        label.x = x + width / 2 - label.width / 2;
        label.y = y + height / 2 + label.height / 2;
        System.out.println(label.getSize());
    }

    @Override
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Dimension getSize() {
        return new Dimension(width, height);
    }

    @Override
    public void setSize(Dimension size) {
        width = size.width;
        height = size.height;
    }


    /* Getter, Setter */

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public Color getColor() {
        return new Color(color.getRGB());
    }

    public void setColor(int rgb) {
        color = factory.getColorFlyweight(rgb);
    }

    public Color getLabelColor() {
        return new Color(label.getColor().getRGB());
    }

    public void setLabelColor(int rgb) {
        label.setColor(rgb);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void drawLabel(Graphics g) {
        label.draw(g);
    }


    /* Private methods */

    private void drawHandles(Graphics g) {
        for (Handle handle : handles) {
            handle.draw(g);
        }
    }

}
