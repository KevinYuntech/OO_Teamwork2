package yuntech.oose.state_diagram_editor.factory;

import yuntech.oose.state_diagram_editor.components.Element;
import yuntech.oose.state_diagram_editor.components.Start;

public class StartFactory implements ElementFactory {
    private Start start;

    public StartFactory() {
        start = new Start();
    }

    @Override
    public Element createElement() {
        return start;
    }
}
