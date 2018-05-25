package yuntech.oose.state_diagram_editor.field;

import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImportAction implements Action{
	private JPanel canvas;
	private JMenuItem mntmImportFile;
	private JFrame frame;
	
	public ImportAction(JPanel canvas,JFrame frame,JMenuItem mntmImportFile) {
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
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image(JPG/GIF/PNG)","JPG","JPEG","GIF","PNG");
		        openFile.setFileFilter(filter);
		        int i = openFile.showOpenDialog(frame.getContentPane());
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
	}
}
