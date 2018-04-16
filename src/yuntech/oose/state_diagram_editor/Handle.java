package yuntech.oose.state_diagram_editor;

import java.awt.*;

public class Handle {

    private int x;
    private int y;
    private int diameter;
    private Color filledColor = new Color(0);
    private Color borderColor = new Color(0xD7D7D7);

    public Handle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Copy constructor
    public Handle(Handle handle) {
        x = handle.x;
        y = handle.y;
        diameter = handle.diameter;
        filledColor = new Color(handle.filledColor.getRGB());
        borderColor = new Color(handle.borderColor.getRGB());
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public void setFilledColor(Color filledColor) {
        this.filledColor = filledColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public void draw(Graphics g) {
        g.setColor(borderColor);
        g.drawOval(x, y, diameter, diameter);
        g.setColor(filledColor);
        g.fillOval(x, y, diameter, diameter);
    }

}
