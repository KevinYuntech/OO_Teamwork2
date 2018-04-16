package yuntech.oose.state_diagram_editor.mediator;

import javax.swing.*;
import java.awt.*;

public class FontScrollPane extends JScrollPane {

    private static final long serialVersionUID = 1L;

    FontScrollPane(Component _fontList) {
        super(_fontList);

        initialize();
    }

    public void initialize() {
        this.setBorder(BorderFactory.createTitledBorder("Font"));

        this.setBounds(10, 10, 240, 100);
    }
}
