package yuntech.oose.state_diagram_editor.mediator;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OkButton extends JButton {

    private static final long serialVersionUID = 1L;

    private FontChooserDialog fontChooserDialog;

    public OkButton(String _title, FontChooserDialog _fontChooserDialog) {
        super(_title);

        fontChooserDialog = _fontChooserDialog;

        initialize();

        monitorEvent();
    }

    public void initialize() {
        this.setBounds(390, 220, 90, 30);
    }

    public void monitorEvent() {
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                fontChooserDialog.okButtonClicked();
            }
        });
    }
}
