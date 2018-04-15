package yuntech.oose.state_diagram_editor.components;

import java.awt.*;

public class Label extends Element{

    /* Fields */

    static private int num;
    private String text;


    private Font font ;

    /* Constructors */

    {
        // Has no default width, height, because those depend on Graphics
        color = new Color(0);

    }

    public Label(){
        text = Label.class.getSimpleName() + num;
        num++;
    }

    // For elements
    public Label(String string) {
        this.text = string;
    }

    public Label(Label label) {
        this.text = label.getText();
    }


    /* Override methods */

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    void initLabel() {
        text = this.getClass().getSimpleName();

        // Only count labels that not depend on other(s).
//        if (text.equals(Label.class.getSimpleName()))
    }


    @Override
    public boolean isIntersect(Point point) {
        // drawText() start from left bottom
        return point.x > x &&
                point.x < x + width &&
                point.y < y &&
                point.y > y - height;
    }

    @Override
    public void draw(Graphics g){
        g.setColor(color);

        if (font == null) {
            // TODO: Reference to sigleton font
            font = new Font(g.getFont().getAttributes());
        }

        // Take a global font
        g.setFont(font);

        width = g.getFontMetrics().stringWidth(getText());
        height = g.getFontMetrics().getHeight();

        g.drawString(text, x , y);
//        g.getFontMetrics().stringWidth(getText());
    }

    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setLocation(Point point) {
        setLocation(point.x, point.y);
    }

    /* Getter, Setter */

    public void setFont(Font font) {
        this.font = font;
    }
}
