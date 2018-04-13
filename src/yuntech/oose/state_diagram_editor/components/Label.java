package yuntech.oose.state_diagram_editor.components;

import java.awt.*;

public class Label extends Element{

    /* Fields */

    static private int numOfInstances;
    private String text;

    /* Constructors */

    {
        // Has no default width, height, because those depend on Graphics
        color = new Color(0);
    }

    public Label(){
    }

    public Label(String string) {
        this.text = string;
    }

    public Label(Color color) {
        this.color = color;
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
        text = this.getClass().getSimpleName() + numOfInstances;

        // Only count labels that not depend on other(s).
//        if (text.equals(Label.class.getSimpleName()))
            numOfInstances++;
    }


    @Override
    public void draw(Graphics g){
        g.setColor(color);
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
}
