package yuntech.oose.state_diagram_editor.field;

import yuntech.oose.state_diagram_editor.chain_help.Helpable;
import yuntech.oose.state_diagram_editor.controller.CTRL_ToolTrayToCanvas;
import yuntech.oose.state_diagram_editor.drawing.Drawable;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainWindow extends JFrame implements Loadable, Helpable {

    // Help
    JPopupMenu popupMenu = new JPopupMenu();
    JMenuItem menuItem = new JMenuItem("Help");

    // Determine default MainWindow size here
    private final int width = 800;
    private final int height = 650;
    private static int a;

    private Canvas canvas = new Canvas(600, 600);
    private ToolTray toolTray = new ToolTray(new CTRL_ToolTrayToCanvas(canvas), 600, 800, this);

    public MainWindow() {

//    public void ass(String[] args) {
//    	
////    	Load load = new Proxy("aaa");
////    	load.display();
////    	load.display();
//    	
//    	Loadable load = new MainFrameProxy(_frame)
    }


    JMenuBar menuBar = new JMenuBar();
    JMenuItem mnFile = new JMenu("File");
    JMenuItem mnNew = new JMenu("New");
    JMenuItem mnNewDiagram = new JMenu("New Diagram");
    JMenuItem mntmOpenFile = new JMenuItem("Open file");
    JMenuItem mntmSaveFile = new JMenuItem("Save file");

    JMenuItem mntmClose = new JMenuItem("Close");
    JMenuItem mnEdit = new JMenu("Edit");
    JMenuItem mnHelp = new JMenu("Help");
    JMenuItem mnUndo = new JMenuItem("Undo");

    ItemFactory mntmImportFile = new ImportFactory(canvas, this, mnFile);
    ItemFactory mntmExportFile = new ExportFactory(canvas, mnFile);

    Action action;

    private void setupFrame() {
        // Help
        popupMenu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                help();
            }
        });
        toolTray.setNextHelpable(this);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
                    popupMenu.show(MainWindow.this, mouseEvent.getX(), mouseEvent.getY());
                }
            }
        });

        setJMenuBar(menuBar);

        menuBar.add(mnFile);
        menuBar.add(mnHelp);
        menuBar.add(mnEdit);

        mnFile.add(mnNew);

        mnNew.add(mnNewDiagram);

        action = mntmImportFile.addAction();
        action.setAction();

        action = mntmExportFile.addAction();
        action.setAction();

        mnFile.add(mntmOpenFile);

        mnFile.add(mntmSaveFile);

        mnFile.add(mntmClose);

        menuBar.add(mnEdit);


        KeyStroke ctrlZ = KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());

        mnUndo.setAccelerator(ctrlZ);

        mnUndo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.undo();
            }
        });

        mnEdit.add(mnUndo);

        JMenu mnHelp = new JMenu("Help");
        menuBar.add(mnHelp);


        JPanel contentPane = new JPanel();
        setContentPane(contentPane);

        setSize(width, height);

        // Arranging contents
        GroupLayout groupLayout = new GroupLayout(contentPane);
        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addComponent(toolTray, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                .addComponent(canvas, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup()
                .addComponent(toolTray, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                .addComponent(canvas, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE));
        contentPane.setLayout(groupLayout);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void repaintCanvas() {
        canvas.repaint();
    }

    public void changeShape(String whichElement, String whichDrawable) {
        canvas.changeShape(whichElement, whichDrawable);
    }

    public void takeSnapshot() {
        canvas.takeSnapshot();
    }

    @Override
    public void load() {
        setupFrame();
        setVisible(true);
    }

    @Override
    public void help() {
        JOptionPane.showMessageDialog(this, "Helper: " + getClass().getSimpleName());
    }

    @Override
    public void setNextHelpable(Helpable helpable) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Should not have a successor");
    }
}

