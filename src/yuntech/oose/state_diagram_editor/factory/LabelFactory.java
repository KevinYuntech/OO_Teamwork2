package yuntech.oose.state_diagram_editor.factory;

import yuntech.oose.state_diagram_editor.components.Element;
import yuntech.oose.state_diagram_editor.components.Label;

public class LabelFactory implements ElementFactory {
    private Label label;

    public LabelFactory() {
        label = new Label();
    }

    @Override
    public Element createElement() {
        return label;
    }
}