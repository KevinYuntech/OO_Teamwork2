package yuntech.oose.state_diagram_editor;

import java.awt.*;

public interface Resizable {
    // TODO: Why fields inside interface should be initialized; Modifier for fields
    ResizableBorder resizableBorder = null;

    void setSize(int width, int height);

    Dimension getSize();

    void setSize(Dimension size);
}

