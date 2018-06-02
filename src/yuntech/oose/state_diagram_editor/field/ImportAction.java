package yuntech.oose.state_diagram_editor.field;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;

public class ImportAction extends MouseInputAdapter implements Action {
    private JPanel canvas;
    private JMenuItem mntmImportFile;
    private JFrame frame;

    public ImportAction(JPanel canvas, JFrame frame, JMenuItem mntmImportFile) {
        this.canvas = canvas;
        this.frame = frame;
        this.mntmImportFile = mntmImportFile;
    }


    @Override
    public void setAction() {
        mntmImportFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser openFile = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Image(JPG/GIF/PNG)", "JPG", "JPEG", "GIF", "PNG");
                openFile.setFileFilter(filter);
                int i = openFile.showOpenDialog(frame.getContentPane());
                if (i == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = openFile.getSelectedFile();
                    ImageIcon icon = new ImageIcon(selectedFile.getPath());

                    JLabel picture = new JLabel();
                    picture.setSize(200, 200);
                    picture.setLocation(30, 30);

                    Image img = icon.getImage();
                    Image new_img = img.getScaledInstance(picture.getWidth(), picture.getHeight(), Image.SCALE_SMOOTH);

                    ImageIcon new_icon = new ImageIcon(new_img);

                    picture.setIcon(new_icon);

                    picture.addMouseMotionListener(new MouseMotionAdapter() {
                        @Override
                        public void mouseMoved(MouseEvent e) {

                        }

                        @Override
                        public void mouseDragged(MouseEvent e) {
                            Point p = e.getPoint();
                            p = SwingUtilities.convertPoint(e.getComponent(), p, e.getComponent().getParent());

                            int x = p.x + canvas.getX();
                            int y = p.y + canvas.getY();
                            picture.setLocation(x - 200, y - 200);
                            canvas.repaint();
                        }
                    });
                    canvas.add(picture);

                    canvas.repaint();
                    picture.setVisible(true);

                }
            }
        });
    }
}
