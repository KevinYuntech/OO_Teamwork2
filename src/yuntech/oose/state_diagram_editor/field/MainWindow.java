package yuntech.oose.state_diagram_editor.field;

import yuntech.oose.state_diagram_editor.controller.CTRL_ToolTrayToCanvas;
import yuntech.oose.state_diagram_editor.drawing.Drawable;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

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

        mntmOpenFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser openFile = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Image(JPG/GIF/PNG)","JPG","JPEG","GIF","PNG");
                openFile.setFileFilter(filter);
                int i = openFile.showOpenDialog(getContentPane());
                if(i == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = openFile.getSelectedFile();
                    ImageIcon icon = new ImageIcon(selectedFile.getPath());

                    JLabel picture = new JLabel();
                    picture.setSize(200,200);
                    picture.setLocation(30,30);

                    Image img = icon.getImage();
                    Image new_img = img.getScaledInstance(picture.getWidth(), picture.getHeight(), Image.SCALE_SMOOTH);

                    ImageIcon new_icon = new ImageIcon(new_img);

                    picture.setIcon(new_icon);

                    canvas.add(picture);

                    canvas.repaint();
                    picture.setVisible(true);
                }
            }
        });

        JMenuItem mntmSaveFile = new JMenuItem("Save file");
        mnFile.add(mntmSaveFile);

        mntmSaveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JMenuItem mntmExportFile = new JMenuItem("Export file");
        mnFile.add(mntmExportFile);

        mntmExportFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage image = new BufferedImage(canvas.getWidth(),
                        canvas.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = image.createGraphics();
                canvas.paint(g);
                g.dispose();

                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter pngFilter = new FileNameExtensionFilter(
                        "Image(JPG/GIF/PNG)","JPG","JPEG","GIF","PNG");
                fileChooser.addChoosableFileFilter(pngFilter);
                fileChooser.setFileFilter(pngFilter);

                int status = fileChooser.showSaveDialog(MainWindow.this);

                if (status == JFileChooser.APPROVE_OPTION) {
                    try {
                        ImageIO.write(image, "png",
                                fileChooser.getSelectedFile());
                        JOptionPane.showMessageDialog(null, "Image saved to "
                                + fileChooser.getSelectedFile().getName());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });

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
