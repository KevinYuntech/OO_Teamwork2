package yuntech.oose.state_diagram_editor.components;

import yuntech.oose.state_diagram_editor.singleton.FontSingleton;
import yuntech.oose.state_diagram_editor.singleton.SizeSingleton;
import yuntech.oose.state_diagram_editor.singleton.StyleSingleton;

import java.awt.*;

public class Label extends Element{

    /* Fields */

    // TEST
    private FontSingleton fontSingleton = FontSingleton.getFontInstance();
    private StyleSingleton styleSingleton = StyleSingleton.getStyleInstance();
    private SizeSingleton sizeSingleton = SizeSingleton.getSizeInstance();
    private Font font = new Font(fontSingleton.getFont(), styleSingleton.getStyle(), sizeSingleton.getSize());

    static private int num;
    private String text;


    /* Constructors */

    {
        // Has no default width, height, because those depend on Graphics
        setColor(0);

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
    void initDrawable() {
        // No need for Drawable
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
        g.setColor(getColor());
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
