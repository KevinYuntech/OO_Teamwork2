package yuntech.oose.state_diagram_editor.field;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindowProxy implements Loadable{
	private JFrame loadingFrame;
	private JLabel label;
	private MainWindow frame;
	
	public MainWindowProxy() {
		frame = new MainWindow();
	}

	public void load() {
		loadingFrame = new JFrame();
		
		loadingFrame.setUndecorated(true);
		
		loadingFrame.setSize(600, 450);
		
		loadingFrame.setLocationRelativeTo(null);
		
		loadingFrame.setResizable(false);
			
		label = new JLabel(new ImageIcon("loading.gif"));
			
		loadingFrame.add(label);
		
		loadingFrame.setVisible(true);
		
		try {
//			Thread.sleep(((long)Math.random()*10+5)*1000);
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		loadingFrame.dispose();
		
		frame.load();
		
	}
}
