package yuntech.oose.state_diagram_editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public interface Resizable {
    // TODO: Why fields inside interface should be initialized; Modifier for fields
    ResizableBorder resizableBorder = null;
    void setSize(int width, int height);
    void setSize(Dimension size);
    Dimension getSize();
}

