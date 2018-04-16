package yuntech.oose.state_diagram_editor.mediator;

import javax.swing.*;
import java.awt.*;

public class StyleScrollPane extends JScrollPane {

    private static final long serialVersionUID = 1L;

    StyleScrollPane(Component _styletList) {
        super(_styletList);

        initialize();
    }

    public void initialize() {
        this.setBorder(BorderFactory.createTitledBorder("Style"));

        this.setBounds(260, 10, 120, 100);
    }
}