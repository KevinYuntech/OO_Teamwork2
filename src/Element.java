import java.awt.*;

abstract class Element {

    Element(){

    }

    // Copy constructor
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

    /* status types */
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Label label;

    protected Color color = new Color(0);

    protected Handle[] handles;
    protected int status = NORMAL;     // 0: normal, 1:focused

    public Color getColor() {
        return color;
    }

    /* status types */
    protected static final int NORMAL = 0;
    protected static final int FOCUSEd = 0;


    void moveTo(Point point){
        x = point.x;
        y = point.y;
    }
    void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Overriding this method should call super.draw()
    public void draw(Graphics g){
        g.setColor(color);
        if (status == FOCUSEd) {
            drawHandles(g);
        }
    }

    /* Setters & Getters*/
    public void setColor(Color color) {
        this.color = color;
    }

    public void setText(String text) {
        label.setText(text);
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    /* Private methods */
    private void drawHandles(Graphics g) {
        for (Handle handle:handles) {
            handle.draw(g);
        }
    }

    protected String getText(){
        return label.getText();
    }
}
