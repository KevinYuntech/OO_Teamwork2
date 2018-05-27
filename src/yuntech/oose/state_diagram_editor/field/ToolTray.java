package yuntech.oose.state_diagram_editor.field;

import yuntech.oose.state_diagram_editor.chain_help.Helpable;
import yuntech.oose.state_diagram_editor.chain_help.Helper;
import yuntech.oose.state_diagram_editor.components.Composite;
import yuntech.oose.state_diagram_editor.components.*;
import yuntech.oose.state_diagram_editor.components.Label;
import yuntech.oose.state_diagram_editor.controller.CTRL_ToolTrayToCanvas;
import yuntech.oose.state_diagram_editor.mediator.FontChooserDialog;
import yuntech.oose.state_diagram_editor.observer.MyKeyListener;
import yuntech.oose.state_diagram_editor.observer.MyMouseListener;
import yuntech.oose.state_diagram_editor.proxy.ProtectProxy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToolTray extends JPanel implements Helpable {
    // Helper
    private Helper helper;

    CTRL_ToolTrayToCanvas ctrl_toolTrayToCanvas;

    private MainWindow mainWindow;
    private JButton btn_transition = new JButton("Transition(T)");
    private JButton btn_decision = new JButton("Decision(D)");
    private JButton btn_state = new JButton("State(S)");
    private JButton btn_start = new JButton("Start(A)");
    private JButton btn_composite = new JButton("Composite(C)");
    private JButton btn_end = new JButton("End(E)");
    private JButton btn_label = new JButton("Label(L)");
    private JButton btn_font = new JButton("Font(F)");
    private JButton btn_changeShape = new JButton("Change Shape(Q)");

    // TEST
    public ToolTray(CTRL_ToolTrayToCanvas ctrl_toolTrayToCanvas, int width, int height, MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.ctrl_toolTrayToCanvas = ctrl_toolTrayToCanvas;
        setup();
        facilitate();
        setSize(new Dimension(width, height));
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    private void facilitate() {
        setBackground(new Color(117, 171, 188));
    }

    void setup() {
        // Helper
        helper = new Helper(this, getClass().getSimpleName(), mainWindow.getHelper());
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
                    JPopupMenu popupMenu = new JPopupMenu();
                    JMenuItem menuItem = new JMenuItem("Helper");
                    popupMenu.add(menuItem).addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            helper.help();
                        }
                    });
                    popupMenu.show(ToolTray.this, mouseEvent.getX(), mouseEvent.getY());
                }
            }
        });

        MyMouseListener myMouseListener = new MyMouseListener(this);
        MyKeyListener myKeyListener = new MyKeyListener(this);
        this.addMouseListener(myMouseListener);
        this.addKeyListener(myKeyListener);

    	/*
        InputMap im_panel = this.getInputMap(WHEN_IN_FOCUSED_WINDOW);

        im_panel.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "pressed");
        im_panel.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "released");
	*/

        InputMap im_transition = btn_transition.getInputMap(WHEN_IN_FOCUSED_WINDOW);

        im_transition.put(KeyStroke.getKeyStroke(KeyEvent.VK_T, 0, false), "pressed");
        im_transition.put(KeyStroke.getKeyStroke(KeyEvent.VK_T, 0, true), "released");

        btn_transition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new Transition());
            }
        });

        InputMap im_decision = btn_decision.getInputMap(WHEN_IN_FOCUSED_WINDOW);

        im_decision.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "pressed");
        im_decision.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "released");

        btn_decision.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new Decision());
            }
        });

        InputMap im_state = btn_state.getInputMap(WHEN_IN_FOCUSED_WINDOW);

        im_state.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "pressed");
        im_state.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "released");

        btn_state.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new State());
            }
        });

        InputMap im_start = btn_start.getInputMap(WHEN_IN_FOCUSED_WINDOW);

        im_start.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "pressed");
        im_start.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "released");

        btn_start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new Start());
            }
        });

        InputMap im_composite = btn_composite.getInputMap(WHEN_IN_FOCUSED_WINDOW);

        im_composite.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0, false), "pressed");
        im_composite.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0, true), "released");

        btn_composite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new Composite());
            }
        });

        InputMap im_end = btn_end.getInputMap(WHEN_IN_FOCUSED_WINDOW);

        im_end.put(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0, false), "pressed");
        im_end.put(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0, true), "released");

        btn_end.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new End());
            }
        });

        InputMap im_label = btn_label.getInputMap(WHEN_IN_FOCUSED_WINDOW);

        im_label.put(KeyStroke.getKeyStroke(KeyEvent.VK_L, 0, false), "pressed");
        im_label.put(KeyStroke.getKeyStroke(KeyEvent.VK_L, 0, true), "released");

        btn_label.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToolTray.this.ctrl_toolTrayToCanvas.addElement(new Label());
            }
        });

        InputMap im_changeShape = btn_changeShape.getInputMap(WHEN_IN_FOCUSED_WINDOW);

        im_changeShape.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0, false), "pressed");
        im_changeShape.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0, true), "released");

        btn_changeShape.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ChangeShapeDialog(mainWindow);
            }
        });

        InputMap im_font = btn_font.getInputMap(WHEN_IN_FOCUSED_WINDOW);

        im_font.put(KeyStroke.getKeyStroke(KeyEvent.VK_F, 0, false), "pressed");
        im_font.put(KeyStroke.getKeyStroke(KeyEvent.VK_F, 0, true), "released");

        btn_font.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FontChooserDialog fontChooserDialog = new FontChooserDialog(mainWindow, "Font Selector", true);
                // fontChooserDialog.setVisible(false);
                ProtectProxy unPaidWindow = new ProtectProxy(mainWindow, "Do you know the password?", true, fontChooserDialog);
                // unPaidWindow.setVisible(true);
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(this);


        gl_contentPane.setAutoCreateContainerGaps(true);
        gl_contentPane.setHonorsVisibility(true);


        gl_contentPane.setVerticalGroup(gl_contentPane.createSequentialGroup().addGap(20).addComponent(btn_state).addGap(20).
                addComponent(btn_transition).addGap(20).addComponent(btn_decision).addGap(20).addComponent(btn_start).addGap(20).
                addComponent(btn_composite).addGap(20).addComponent(btn_end).addGap(20).addComponent(btn_label).addGap(135).addComponent(btn_changeShape).
                addGap(20).addComponent(btn_font).addGap(20));


        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(btn_state, GroupLayout.PREFERRED_SIZE,
                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).
                addComponent(btn_transition, GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btn_decision, GroupLayout.PREFERRED_SIZE,
                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btn_start, GroupLayout.PREFERRED_SIZE,
                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).
                addComponent(btn_composite, GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btn_end, GroupLayout.PREFERRED_SIZE,
                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btn_label, GroupLayout.PREFERRED_SIZE,
                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btn_changeShape, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).
                addComponent(btn_font, GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        setLayout(gl_contentPane);
        setVisible(true);

    }

    @Override
    public Helper getHelper() {
        return helper;
    }
}
