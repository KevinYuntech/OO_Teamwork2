package yuntech.oose.state_diagram_editor;

import java.awt.*;

public interface Draggable {
    void setLocation(Point point);
    void setLocation(int x, int y);
    Point getLocation();
    int getX();
    int getY();
}
