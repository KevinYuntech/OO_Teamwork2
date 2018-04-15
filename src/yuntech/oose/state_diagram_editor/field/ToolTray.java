package yuntech.oose.state_diagram_editor.field;

import yuntech.oose.state_diagram_editor.components.*;
import yuntech.oose.state_diagram_editor.components.Composite;
import yuntech.oose.state_diagram_editor.components.Label;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToolTray extends JPanel implements ActionListener{
    CTRL_ToolTrayToCanvas ctrl_toolTrayToCanvas;

    private JButton btn_transition = new JButton("Transition");
    private JButton btn_decision = new JButton("Decision");
    private JButton btn_state = new JButton("State");
    private JButton btn_start = new JButton("Start");
    private JButton btn_composite = new JButton("Composite");
    private JButton btn_end = new JButton("End");
    private JButton btn_label = new JButton("Label");
    private JButton btn_font = new JButton("Font");

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

    void setup() {
        btn_transition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new Transition());
            }
        });


        btn_decision.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new Decision());
            }
        });


        btn_state.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new State());
            }
        });

        btn_start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new Start());
            }
        });

        btn_composite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new Composite());
            }
        });

        btn_end.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new End());
            }
        });

        btn_label.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new Label());
            }
        });

        btn_font.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new Font());
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(this);

        /* Arranging components */
        gl_contentPane.setVerticalGroup(gl_contentPane.createSequentialGroup().addComponent(btn_state).
                addComponent(btn_transition).addComponent(btn_decision).addComponent(btn_start).
                addComponent(btn_composite).addComponent(btn_end).addComponent(btn_label));
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup().addComponent(btn_state).
                addComponent(btn_transition).addComponent(btn_decision).addComponent(btn_start).
                addComponent(btn_composite).addComponent(btn_end).addComponent(btn_label));

        setLayout(gl_contentPane);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

