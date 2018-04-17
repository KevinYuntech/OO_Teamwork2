package yuntech.oose.state_diagram_editor.components;

import yuntech.oose.state_diagram_editor.drawing.CircleDrawable;

import java.awt.*;

public class Start extends Element {
    static private int num;

    public Start(){

    }

    public Start(Start start) {
        super(start);
    }

    @Override
    protected void initWidthHeight() {
        width = 35;
        height = 35;
    }

    @Override
    protected void initColor() {
        setColor(0xFF70A6);
    }

    @Override
    protected void initLabel() {
        label = new Label(this.getClass().getSimpleName() + num);
        num++;
    }

    @Override
    protected void initDrawable() {
        drawable = new CircleDrawable();
    }

    @Override
    public void draw(Graphics g) {
        drawable.draw(this, g);
    }

    @Override
    public Element getNewInstance() {
        return new Start(this);
    }

}
