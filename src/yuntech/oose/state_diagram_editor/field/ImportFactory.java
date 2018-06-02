package yuntech.oose.state_diagram_editor.field;

import javax.swing.*;

public class ImportFactory implements ItemFactory {
    private JPanel canvas;
    private JFrame frame;
    private JMenuItem mnFile;

    public ImportFactory(JPanel canvas, JFrame frame, JMenuItem mnFile) {
        this.canvas = canvas;
        this.frame = frame;
        this.mnFile = mnFile;
    }

    @Override
    public Action addAction() {
        JMenuItem mntmImportFile = new JMenuItem("Import file");
        mnFile.add(mntmImportFile);
        return new ImportAction(canvas, frame, mntmImportFile);
    }

}
