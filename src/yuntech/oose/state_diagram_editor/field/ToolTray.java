package yuntech.oose.state_diagram_editor.field;

import yuntech.oose.state_diagram_editor.components.*;
import yuntech.oose.state_diagram_editor.components.Composite;
import yuntech.oose.state_diagram_editor.components.Label;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ToolTray extends JPanel {
    CTRL_ToolTrayToCanvas ctrl_toolTrayToCanvas;
    private JButton btn_redo = new JButton("Redo");
    private JButton btn_undo = new JButton("Undo");
    private JButton btn_font = new JButton("Font");

    private JButton btn_transition = new JButton("Transition");
    private JButton btn_decision = new JButton("Decision");
    private JButton btn_state = new JButton("State");
    private JButton btn_start = new JButton("Start");
    private JButton btn_exit = new JButton("Exit");
    private JButton btn_composite = new JButton("Composite");
    private JButton btn_end = new JButton("End");
    private JButton btn_label = new JButton("Label");

    public ToolTray(CTRL_ToolTrayToCanvas ctrl_toolTrayToCanvas){
        this.ctrl_toolTrayToCanvas = ctrl_toolTrayToCanvas;
        setup();
        facilitate();
    }

    public ToolTray(CTRL_ToolTrayToCanvas ctrl_toolTrayToCanvas, int width, int height){
        this(ctrl_toolTrayToCanvas);
        setSize(new Dimension(width, height));
    }

    private void facilitate() {
        setBackground(new Color(0x81C889));
    }

    private void setup() {
        GroupLayout gl_contentPane = new GroupLayout(this);

        /* Why not implement MouseListener on ToolTray:
         * Prevent ToolTray from being "God class",
         * that is, ToolTray needs to know which btn is clicked,
         * then conducts the corresponding behavior.
         */
        // TODO: There are btns in original GUI not be implement
        btn_transition.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new Transition());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        btn_decision.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new Decision());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        btn_state.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new State());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        btn_start.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new Start());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        btn_exit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new Exit());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        btn_composite.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new Composite());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        btn_end.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new End());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        btn_label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new Label());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        /* Arranging components */
        gl_contentPane.setVerticalGroup(gl_contentPane.createSequentialGroup().addComponent(btn_state).
                addComponent(btn_transition).addComponent(btn_decision).addComponent(btn_start).addComponent(btn_exit).
                addComponent(btn_composite).addComponent(btn_end).addComponent(btn_label));
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup().addComponent(btn_state).
                addComponent(btn_transition).addComponent(btn_decision).addComponent(btn_start).addComponent(btn_exit).
                addComponent(btn_composite).addComponent(btn_end).addComponent(btn_label));

        setLayout(gl_contentPane);
        setVisible(true);
    }
}

