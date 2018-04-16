package yuntech.oose.state_diagram_editor.mediator;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SizeList extends JList<String> {

    private static final long serialVersionUID = 1L;
    private FontChooserDialog fontChooserDialog;

    SizeList(String[] _size, FontChooserDialog _fontChooserDialog) {
        super(_size);

        fontChooserDialog = _fontChooserDialog;

        monitorEvent();
    }

    public void monitorEvent() {

        this.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                fontChooserDialog.setPreviewLabelSize(Integer.valueOf(SizeList.this.getSelectedValue()));

            }
        });
    }
}
