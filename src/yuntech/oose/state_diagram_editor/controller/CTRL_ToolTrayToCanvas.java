package yuntech.oose.state_diagram_editor.controller;

import yuntech.oose.state_diagram_editor.components.Element;
import yuntech.oose.state_diagram_editor.field.Canvas;

import java.awt.*;

// TODO: Evaluate if this class is a facade controller
/*
 * Redirect events happened on a ToolTray to a Canvas.
 * MainWindow create the ToolTray and the Canvas,
 * that is, MainWindows holds this two object (MainWidow has the information to create CTRL_ToolTrayToCanvas).
 * Then MainWindow create CTRL_ToolTrayToCanvas.
 */
public class CTRL_ToolTrayToCanvas {
    // Which canvas this controller is response for
    private Canvas canvas;

    // Called by MainWindow
    public CTRL_ToolTrayToCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    // Called by ToolTray
    public void addElement(Element element) {
        canvas.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        canvas.setElementGonnaDraw(element);
    }
}
