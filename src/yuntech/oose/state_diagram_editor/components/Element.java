package yuntech.oose.state_diagram_editor.components;

import yuntech.oose.state_diagram_editor.Draggable;
import yuntech.oose.state_diagram_editor.Handle;
import yuntech.oose.state_diagram_editor.Resizable;

import java.awt.*;

public abstract class Element implements Draggable, Resizable {

    /* status types */

    protected static final int NORMAL = 0;
    protected static final int FOCUSEd = 1;

    /* Fields */

    protected int x;
    protected int y;
    protected int width = 50;
    protected int height = 50;
    protected Handle[] handles;
    protected Label label;
    protected Color color;
    protected int status = NORMAL;     // 0: normal, 1:focused

    /* Constructors */

    Element(){
        // Set default text of label for an Element
        initLabel();
//        initResizableBorder();
    }


    //    abstract void initResizableBorder();
    abstract void initLabel();

    public Element(Element element) {
        x = element.x;
        y = element.y;
        width = element.width;
        height = element.height;
        label = new Label(element.getText());
        color = new Color(element.getColor().getRGB());
        handles = new Handle[handles.length];
        for (int i = 0; i < element.handles.length; i++) {
            handles[i] = new Handle(element.handles[i]);
        }
        this.status = element.status;
    }

    /* Public methods */

    // Overriding this method should call super.draw()
    public void draw(Graphics g){
        // Draw the label of this element
        if (!(this instanceof Label)) {
            g.setColor(label.getColor());
            g.drawString(label.getText(), label.getX(), label.getX());
//            System.out.println("labelX: " + label.getX() + "labelY: " + label.getY());
//            System.out.println("Draw label: " + label.getText());
//            System.out.println("Label color: " + label.getColor().toString());
        }

        if (status == FOCUSEd) {
            drawHandles(g);
        }
    }

    public boolean isIntersect(Point point){
        return point.x > x &&
                point.x < x + width &&
                point.y > y &&
                point.y < y + height;
    }

    public String getText(){
        return label.getText();
    }

    public void setText(String text) {
        label.setText(text);
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
    public void setLocation(Point point){
        setLocation(point.x, point.y);
    }

    @Override
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
        label.x = x + width / 2 + label.x / 2;
        label.y = y + height / 2 + label.y / 2;
    }
    @Override
    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public void setSize(Dimension size) {
        width = size.width;
        height = size.height;
    }

    @Override
    public Dimension getSize(){
        return new Dimension(width, height);
    }


    /* Getter, Setter */


    public void setColor(Color color) {
        this.color = color;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public Color getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    /* Private methods */

    private void drawHandles(Graphics g) {
        for (Handle handle:handles) {
            handle.draw(g);
        }
    }

}
