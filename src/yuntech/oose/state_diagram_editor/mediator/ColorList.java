package yuntech.oose.state_diagram_editor.mediator;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ColorList extends JList<String> {

    private static final long serialVersionUID = 1L;

    private FontChooserDialog fontChooserDialog;

    ColorList(String[] _color, FontChooserDialog _fontChooserDialog) {
        super(_color);

        fontChooserDialog = _fontChooserDialog;

        monitorEvent();
    }

    public void monitorEvent() {

        this.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                fontChooserDialog.setPreviewLabelColor(ColorList.this.getSelectedIndex());
            }
        });
    }
}
