package yuntech.oose.state_diagram_editor.field;

import yuntech.oose.state_diagram_editor.controller.CTRL_ToolTrayToCanvas;
import yuntech.oose.state_diagram_editor.drawing.Drawable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainWindow extends JFrame implements Loadable{
    // Determine default MainWindow size here
    private final int width = 800;
    private final int height = 600;
    private static int a;

    private Canvas canvas = new Canvas(600, 600);
    private ToolTray toolTray = new ToolTray(new CTRL_ToolTrayToCanvas(canvas), 200, 600, this);

    public MainWindow() {
        
    }

//    public void ass(String[] args) {
//    	
////    	Load load = new Proxy("aaa");
////    	load.display();
////    	load.display();
//    	
//    	Loadable load = new MainFrameProxy(_frame)
//    	
//        
//    }

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

        JMenuItem mnUndo = new JMenuItem("Undo");

        KeyStroke ctrlZ = KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());

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

    public void changeShape(String whichElement, String whichDrawable){
        canvas.changeShape(whichElement, whichDrawable);
    }

    public void takeSnapshot(){
        canvas.takeSnapshot();
    }

	@Override
	public void load() {
		setupFrame();
        setVisible(true);
	}

}
