package yuntech.oose.state_diagram_editor;

import java.awt.*;

public interface Draggable {
    void setLocation(int x, int y);

    Point getLocation();

    void setLocation(Point point);

    int getX();

    int getY();
}
