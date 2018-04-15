package yuntech.oose.state_diagram_editor.components;

import yuntech.oose.state_diagram_editor.Draggable;
import yuntech.oose.state_diagram_editor.Handle;
import yuntech.oose.state_diagram_editor.Resizable;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// NOTE: Gatter always return new object so outer won't have the ability to modify data of a class
public abstract class Element implements Draggable, Resizable{

    /* status types */

    public static final int NORMAL = 0;
    public static final int FOCUSEd = 1;

    /* Fields */

    // Subclass can use initializer block to set the default values
    protected int x;
    protected int y;
    protected int dx;
    protected int dy;
    protected int width;    // FIXME: Subclass should have default value for it
    protected int height;   // FIXME: Subclass should have default value for it
    protected Handle[] handles;
    protected Label label;
    protected Color color;  // FIXME: Subclass should have default value for it
    protected int status = NORMAL;     // 0: normal, 1:focused

    /* Constructors */

    Element() {
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
        color = element.getColor();
        handles = new Handle[handles.length];
        for (int i = 0; i < element.handles.length; i++) {
            handles[i] = new Handle(element.handles[i]);
        }
        this.status = element.status;
    }

    /* Public methods */

    // Overriding this method should call super.draw() lastly
    public void draw(Graphics g){
        // Draw the label of this element
        g.setColor(label.color);
        label.draw(g);

        // Update label location


/*        if (status == FOCUSEd) {
            drawHandles(g);
        }*/


    }


    // TODO: Make it abstract
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

    public void setFont(Font font){
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
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;

        // Update its label also (to center of this)
        label.x = x + width / 2 - label.width / 2;
        label.y = y + height / 2 + label.height / 2;
        System.out.println(label.getSize());
    }

    @Override
    public void setLocation(Point point){
        setLocation(point.x, point.y);
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

    public void setLabelColor(Color color) {
        label.color = color;
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
        return new Color(color.getRGB());
    }

    public Color getLabelColor() {
        return new Color(label.color.getRGB());
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
