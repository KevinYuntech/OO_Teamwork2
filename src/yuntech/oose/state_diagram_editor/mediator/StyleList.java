package yuntech.oose.state_diagram_editor.mediator;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class StyleList extends JList<String> {

    private static final long serialVersionUID = 1L;

    private FontChooserDialog fontChooserDialog;

    StyleList(String[] _style, FontChooserDialog _fontChooserDialog) {
        super(_style);

        fontChooserDialog = _fontChooserDialog;


        monitorEvent();
    }

    public void monitorEvent() {

        this.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                fontChooserDialog.setPreviewLabelStyle(StyleList.this.getSelectedIndex());
            }
        });
    }
}
