package yuntech.oose.state_diagram_editor.field;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ExportAction implements Action{
	private JPanel canvas;
	private JMenuItem mntmExportFile;
	
	public ExportAction(JPanel canvas, JMenuItem mntmExportFile) {
		this.canvas = canvas;
		this.mntmExportFile = mntmExportFile;
		
	}
	

	@Override
	public void setAction() {
		mntmExportFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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

		        int status = fileChooser.showSaveDialog(null);

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
	}
}
