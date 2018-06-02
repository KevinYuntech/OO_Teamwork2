/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuntech.oose.state_diagram_editor.Adapter;

import yuntech.oose.state_diagram_editor.controller.CTRL_ToolTrayToCanvas;
import yuntech.oose.state_diagram_editor.factory.ElementFactory;
import yuntech.oose.state_diagram_editor.factory.StateFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Kevin 0528
 */

/**A adapter class which implements  ActionListener which is client interface
 * ,and aggreate a CTRL_ToolTrayToCanvas class which is a adaptee
 */
public class StateButtonActionListener implements ActionListener {
    private CTRL_ToolTrayToCanvas ctrl_toolTrayToCanvas;/*Has a  CTRL_ToolTrayToCanvas adaptee*/

    /*Set a CTRL_ToolTrayToCanvas when StateButtonActionListener be constructed*/
    public StateButtonActionListener(CTRL_ToolTrayToCanvas ctrl_toolTrayToCanvas) {
        this.ctrl_toolTrayToCanvas = ctrl_toolTrayToCanvas;
    }

    /**The implemntation for adapter function
     * When actionPerformed() be called,  call ctrl_toolTrayToCanvas to perform addElementByFactory() */
    @Override
    public void actionPerformed(ActionEvent e) {
        ElementFactory elementFactory = new StateFactory();
        ctrl_toolTrayToCanvas.addElementByFactory(elementFactory);
    }
}
