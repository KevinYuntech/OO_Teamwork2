package yuntech.oose.state_diagram_editor.mediator;

import javax.swing.*;
import java.awt.*;

public class SizeScrollPane extends JScrollPane {

    private static final long serialVersionUID = 1L;

    SizeScrollPane(Component _sizeList) {
        super(_sizeList);

        initialize();
    }

    public void initialize() {
        this.setBorder(BorderFactory.createTitledBorder("選擇大小"));

        this.setBounds(390, 10, 90, 100);
    }
}
