package yuntech.oose.state_diagram_editor.observer;

import yuntech.oose.state_diagram_editor.field.ToolTray;
import yuntech.oose.state_diagram_editor.mediator.FontChooserDialog;
import yuntech.oose.state_diagram_editor.proxy.ProtectProxy;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseListener extends MouseAdapter {
    ToolTray toolTray;

    public MyMouseListener(ToolTray toolTray) {
        this.toolTray = toolTray;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            // fontChooserDialog.setVisible(false);
            ProtectProxy unPaidWindow = new ProtectProxy(toolTray.getMainWindow(), "Do you know the password?", true);
        }
        toolTray.requestFocus();
        toolTray.setFocusable(true);
    }
}
