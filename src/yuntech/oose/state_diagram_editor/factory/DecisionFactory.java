package yuntech.oose.state_diagram_editor.factory;

import yuntech.oose.state_diagram_editor.components.Decision;
import yuntech.oose.state_diagram_editor.components.Element;

public class DecisionFactory implements ElementFactory {
    private Decision decision;

    public DecisionFactory() {
        decision = new Decision();
    }

    @Override
    public Element createElement() {
        return decision;
    }
}
