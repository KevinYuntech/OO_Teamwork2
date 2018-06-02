package yuntech.oose.state_diagram_editor.factory;

import yuntech.oose.state_diagram_editor.components.Composite;
import yuntech.oose.state_diagram_editor.components.Element;

public class CompositeFactory implements ElementFactory {
    private Composite composite;

    public CompositeFactory() {
        composite = new Composite();
    }

    @Override
    public Element createElement() {
        return composite;
    }
}
