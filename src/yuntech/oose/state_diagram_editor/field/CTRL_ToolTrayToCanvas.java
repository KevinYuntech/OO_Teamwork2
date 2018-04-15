package yuntech.oose.state_diagram_editor.field;

import yuntech.oose.state_diagram_editor.components.Element;

import java.awt.*;

// TODO: Evaluate if this class is a facade controller
// TODO: Refactor as Bridge pattern, narrow down the accessible to Canvas
public class CTRL_ToolTrayToCanvas {

    private Canvas canvas;

    public CTRL_ToolTrayToCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public void addElement(Element element) {
        canvas.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        canvas.setElementGannaDraw(element);
    }

    public void refreshCanvas(){
        canvas.repaint();
    }
}
