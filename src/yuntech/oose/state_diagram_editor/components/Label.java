package yuntech.oose.state_diagram_editor.components;

import java.awt.*;

public class Label extends Element{

    /* Fields */

    static private int numOfInstances;
    private String text;

    /* Constructors */

    public Label(){
        color = new Color(0);
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
        numOfInstances++;
    }


    @Override
    public void draw(Graphics g){
        super.draw(g);
        g.drawString(text, x , y);

        // Set element size corresponding to it's label
//        g.getFontMetrics().stringWidth(getText());
    }
}
