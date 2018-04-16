package yuntech.oose.state_diagram_editor.field;

import yuntech.oose.state_diagram_editor.controller.CTRL_CanvasToMementoCaretake;
import yuntech.oose.state_diagram_editor.controller.CTRL_ToolTrayToCanvas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame{
    // Determine default MainWindow size here
    private final int width = 800;
    private final int height = 600;

    private Canvas canvas = new Canvas(600, 600);
    private ToolTray toolTray = new ToolTray(new CTRL_ToolTrayToCanvas(canvas), 200, 600, this);

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }

    public MainWindow(){
        setupFrame();
        setVisible(true);
    }

    private void setupFrame() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenu mnNew = new JMenu("New");
        mnFile.add(mnNew);

        JMenu mnNewDiagram = new JMenu("New Diagram");
        mnNew.add(mnNewDiagram);

        JMenuItem mntmOpenFile = new JMenuItem("Open file");
        mnFile.add(mntmOpenFile);

        JMenuItem mntmClose = new JMenuItem("Close");
        mnFile.add(mntmClose);

        JMenu mnEdit = new JMenu("Edit");
        menuBar.add(mnEdit);

        JMenuItem mnRedo = new JMenuItem("Redo");
        mnEdit.add(mnRedo);

        JMenuItem mnUndo = new JMenuItem("Undo");
        mnEdit.add(mnUndo);
        mnUndo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.undo();
            }
        });

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

    public void repaintCanvas(){
        canvas.repaint();
    }

}
