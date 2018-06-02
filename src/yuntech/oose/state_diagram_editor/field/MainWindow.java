package yuntech.oose.state_diagram_editor.field;

import yuntech.oose.state_diagram_editor.Builder.LifeChooseExampleBuilder;
import yuntech.oose.state_diagram_editor.Builder.OOExampleBuilder;
import yuntech.oose.state_diagram_editor.Builder.SAExampleBuilder;
import yuntech.oose.state_diagram_editor.chain_help.Helpable;
import yuntech.oose.state_diagram_editor.chain_help.Helper;
import yuntech.oose.state_diagram_editor.chain_help.MainWindowHelper;
import yuntech.oose.state_diagram_editor.controller.CTRL_ToolTrayToCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame implements Loadable, Helpable {

    // Determine default MainWindow size here
    private final int width = 800;
    private final int height = 650;
    // Helper
    MainWindowHelper helper = new MainWindowHelper(this,
            "Hi,I am MainWindow Helper, appreciate to help you. \n" +
                    "I provide you to edit the state diagram, and something smart way," +
                    " function that other company don’t provide. GoodLuck! ",
            null);
    JMenuBar menuBar = new JMenuBar();
    JMenuItem mnFile = new JMenu("File");
    JMenuItem mnNew = new JMenu("New");
    JMenuItem mnNewDiagram = new JMenuItem("New Diagram");
    JMenuItem mntmSave = new JMenuItem("Save");
    JMenuItem mntmOpen = new JMenuItem("Open");
    JMenuItem mntmClose = new JMenuItem("Close");
    JMenuItem mnEdit = new JMenu("Edit");
    JMenuItem mnHelp = new JMenu("Help");
    JMenuItem mnUndo = new JMenuItem("Undo");
    JMenuItem mntmHelp = new JMenuItem("Help");
    JMenuItem mntmExample1 = new JMenuItem("SAPassExample");
    JMenuItem mntmExample2 = new JMenuItem("OOPassExample");
    JMenuItem mntmExample3 = new JMenuItem(" LifeChooseExample");
    JMenu mnExample = new JMenu("Example");
    Action action;
    private Canvas canvas = new Canvas(600, 600);
    ItemFactory mntmImportFile = new ImportFactory(canvas, this, mnFile);
    ItemFactory mntmExportFile = new ExportFactory(canvas, mnFile);
    private ToolTray toolTray = new ToolTray(new CTRL_ToolTrayToCanvas(canvas), 600, 800, this);

    public MainWindow() {

    }

    private void setupFrame() {
        // Helper
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem menuItem = new JMenuItem("Help");
        popupMenu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                helper.help();
            }
        });
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
        mnFile.add(mnNew);
        mnFile.add(mntmSave);
        mnFile.add(mntmOpen);
        mnNew.add(mnNewDiagram);
        menuBar.add(mnEdit);
        menuBar.add(mnExample);
        menuBar.add(mnHelp);
        mnHelp.add(mntmHelp);

        mntmHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(MainWindow.this, "Kevin: 0939814988");
            }
        });


        mnNewDiagram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                canvas.clean();
            }
        });

        action = mntmImportFile.addAction();
        action.setAction();

        action = mntmExportFile.addAction();
        action.setAction();


        mntmClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MainWindow.this.dispose();
            }
        });

        KeyStroke ctrlZ = KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());

        mnUndo.setAccelerator(ctrlZ);

        mnUndo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.undo();
            }
        });

        mnEdit.add(mnUndo);


        // Examples
        mnExample.add(mntmExample1);
        mntmExample1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                canvas.paintExample(canvas.getGraphics(), new SAExampleBuilder());
            }
        });

        mnExample.add(mntmExample2);
        mntmExample2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                canvas.paintExample(canvas.getGraphics(), new OOExampleBuilder());
            }
        });

        mnExample.add(mntmExample3);
        mntmExample3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                canvas.paintExample(canvas.getGraphics(), new LifeChooseExampleBuilder());
            }
        });

        mnFile.add(mntmClose);

        // Arrange GUI
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
    public Helper getHelper() {
        return helper;
    }
}

