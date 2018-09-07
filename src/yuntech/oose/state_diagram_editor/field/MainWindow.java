package yuntech.oose.state_diagram_editor.field;

import yuntech.oose.state_diagram_editor.Builder.LifeChooseExampleBuilder;
import yuntech.oose.state_diagram_editor.Builder.OOExampleBuilder;
import yuntech.oose.state_diagram_editor.Builder.SAExampleBuilder;
import yuntech.oose.state_diagram_editor.chain_help.Helpable;
import yuntech.oose.state_diagram_editor.chain_help.Helper;
import yuntech.oose.state_diagram_editor.chain_help.MainWindowHelper;
import yuntech.oose.state_diagram_editor.components.Element;
import yuntech.oose.state_diagram_editor.controller.CTRL_ToolTrayToCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.LinkedList;

public class MainWindow extends JFrame implements Loadable, Helpable {

    // Determine default MainWindow size here
    private final int width = 800;
    private final int height = 650;
    // Helper
    private MainWindowHelper helper = new MainWindowHelper(this,
            "Hi,I am MainWindow Helper, appreciate to help you. \n" +
                    "I provide you to edit the state diagram, and something smart way," +
                    " function that other company don’t provide. GoodLuck! ",
            null);
    private JMenuBar menuBar = new JMenuBar();
    private JMenuItem mnFile = new JMenu("File");
    private JMenuItem mnNew = new JMenu("New");
    private JMenuItem mnNewDiagram = new JMenuItem("New Diagram");
    private JMenuItem mntmSave = new JMenuItem("Save");
    private JMenuItem mntmOpen = new JMenuItem("Open");
    private JMenuItem mntmClose = new JMenuItem("Close");
    private JMenuItem mnEdit = new JMenu("Edit");
    private JMenuItem mnHelp = new JMenu("Help");
    private JMenuItem mnUndo = new JMenuItem("Undo");
    private JMenuItem mntmHelp = new JMenuItem("Help");
    private JMenuItem mntmExample1 = new JMenuItem("SAPassExample");
    private JMenuItem mntmExample2 = new JMenuItem("OOPassExample");
    private JMenuItem mntmExample3 = new JMenuItem(" LifeChooseExample");
    private JMenu mnExample = new JMenu("Example");
    private Action action;
    private Canvas canvas = new Canvas(600, 600);
    private ItemFactory mntmImportFile = new ImportFactory(canvas, this, mnFile);
    private ItemFactory mntmExportFile = new ExportFactory(canvas, mnFile);
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

        // Open dialog
        mntmOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showOpenDialog(MainWindow.this) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        ObjectInputStream read = new ObjectInputStream(new FileInputStream(file));
                        LinkedList<Element> list = (LinkedList<Element>) read.readObject();
                        canvas.setElementList(list);
                    } catch (IOException | ClassNotFoundException eio) {
                        eio.printStackTrace();
                    }
                }
            }
        });

        // Save dialog
        mntmSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(MainWindow.this) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(file));
                        write.writeObject(canvas.getElementList());
                    } catch (NotSerializableException nse) {
                        //do something
                    } catch (IOException eio) {
                        //do something
                    }
                }
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

