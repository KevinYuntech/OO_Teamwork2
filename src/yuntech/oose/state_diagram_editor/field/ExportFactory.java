package yuntech.oose.state_diagram_editor.field;

import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ExportFactory implements ItemFactory{
	private JPanel canvas;
	private JMenuItem mnFile;
	
	public ExportFactory(JPanel canvas, JMenuItem mnFile){
		this.canvas = canvas;
		this.mnFile = mnFile;
	}

	@Override
	public Action addAction() {
		JMenuItem mntmExportFile = new JMenuItem("Export file");
		mnFile.add(mntmExportFile);
		return new ExportAction(canvas,mntmExportFile);
	}

}
