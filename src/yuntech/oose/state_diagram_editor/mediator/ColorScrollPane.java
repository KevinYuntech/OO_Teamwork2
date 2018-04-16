package yuntech.oose.state_diagram_editor.mediator;

import javax.swing.*;
import java.awt.*;

public class ColorScrollPane extends JScrollPane {

    private static final long serialVersionUID = 1L;

    ColorScrollPane(Component _colorList) {
        super(_colorList);

        initialize();
    }

    public void initialize() {
        this.setBorder(BorderFactory.createTitledBorder("選擇顏色"));

        this.setBounds(490, 10, 100, 100);
    }
}
