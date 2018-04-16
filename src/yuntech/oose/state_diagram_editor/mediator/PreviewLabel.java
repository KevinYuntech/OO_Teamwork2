package yuntech.oose.state_diagram_editor.mediator;

import javax.swing.*;
import java.awt.*;

public class PreviewLabel extends JLabel {

    private static final long serialVersionUID = 1L;
    private String defaultFont;
    private int defaultStyle;
    private int defaultSize;
    private Color defaultColor;

    PreviewLabel(String _titel, int _horizontalAlignment, String _defaultFont, int _defaultStyle, int _defaultSize, Color _defaultColor) {
        super(_titel, _horizontalAlignment);
        defaultFont = _defaultFont;
        defaultStyle = _defaultStyle;
        defaultSize = _defaultSize;
        defaultColor = _defaultColor;

        initialize();

    }

    public void initialize() {
        this.setBounds(30, 115, 400, 100);
        this.setFont(new Font(defaultFont, defaultStyle, defaultSize));
        this.setForeground(defaultColor);
        //this.setFont(font);


    }
}
