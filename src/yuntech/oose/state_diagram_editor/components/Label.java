package yuntech.oose.state_diagram_editor.components;

import yuntech.oose.state_diagram_editor.drawing.StringDrawable;
import yuntech.oose.state_diagram_editor.singleton.WordSingleton;

import java.awt.*;

public class Label extends Element {

    /* Fields */

    // Number of created instances
    private static int num;
    private String text;
    private WordSingleton wordSingleton = WordSingleton.getInstance();
    private Font font = new Font(
            wordSingleton.getFontName(), wordSingleton.getFontStyle(), wordSingleton.getFontSize());


    /* Constructors */

    // For a label who does not depend on an element
    public Label() {
        text = Label.class.getSimpleName() + num;
        num++;
    }

    // For creating a Label elements
    public Label(String string) {
        text = string;
    }

    private Label(Label label) {
        super(label);
        text = label.getText();
        wordSingleton = WordSingleton.getInstance();
        font = new Font(wordSingleton.getFontName(), wordSingleton.getFontStyle(), wordSingleton.getFontSize());
    }

    /* Public methods */

    public void setFont(Font font) {
        this.font = font;
    }

    /* Override methods */

    @Override
    protected void initWidthHeight() {
        // Has no default width, height, because those depend on Graphics
    }

    @Override
    protected void initColor() {
        setColor(0);
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    protected void initLabel() {
        text = this.getClass().getSimpleName();
    }

    @Override
    protected void initDrawable() {
        drawable = new StringDrawable();
    }

    @Override
    public void draw(Graphics g) {
        drawable.draw(this, g);

        // get width and height and let it has size to be focused
        width = g.getFontMetrics().stringWidth(getText());
        height = g.getFontMetrics().getHeight();
    }

    @Override
    public Element getInstanceCopy() {
        return new Label(this);
    }


    // A Label has no Label paired with it
    @Override
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // A Label has no Label paired with it
    @Override
    public void setLocation(Point point) {
        setLocation(point.x, point.y);
    }

    // A Label has no Label paired with it
    @Override
    public Color getLabelColor() {
        return new Color(getColor().getRGB());
    }

    // A Label has no Label paired with it
    @Override
    public void setLabelColor(int rgb) {
        setColor(rgb);
    }

    @Override
    public Font getFont() {
        return font;
    }

    // TODO
    @Override
    public boolean isIntersect(Point point) {
        // drawText() start from left bottom
        return point.x > x &&
                point.x < x + width &&
                point.y < y &&
                point.y > y - height;
    }

}
