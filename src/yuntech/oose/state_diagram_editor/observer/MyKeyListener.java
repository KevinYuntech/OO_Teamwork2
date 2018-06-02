/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuntech.oose.state_diagram_editor.observer;

import yuntech.oose.state_diagram_editor.field.ToolTray;
import yuntech.oose.state_diagram_editor.mediator.FontChooserDialog;
import yuntech.oose.state_diagram_editor.proxy.ProtectProxy;
import yuntech.oose.state_diagram_editor.proxy.Protectable;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author user
 */
public class MyKeyListener implements KeyListener {
    ToolTray toolTray;

    public MyKeyListener(ToolTray toolTray) {
        this.toolTray = toolTray;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 87) {
            // fontChooserDialog.setVisible(false);
            ProtectProxy unPaidWindow = new ProtectProxy(toolTray.getMainWindow(), "Do you know the password?", true);
            System.out.println("font");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
