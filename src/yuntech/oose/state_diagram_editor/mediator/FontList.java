package yuntech.oose.state_diagram_editor.mediator;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FontList extends JList<String> {

    private static final long serialVersionUID = 1L;
    private FontChooserDialog fontChooserDialog;

    FontList(String[] _font, FontChooserDialog _fontChooserDialog) {
        super(_font);

        fontChooserDialog = _fontChooserDialog;

        monitorEvent();
    }

    public void monitorEvent() {

        this.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                fontChooserDialog.setPreviewLabelFont(FontList.this.getSelectedValue());
            }
        });
    }
}
