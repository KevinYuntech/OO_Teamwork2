package yuntech.oose.state_diagram_editor.factory;

import yuntech.oose.state_diagram_editor.components.Element;
import yuntech.oose.state_diagram_editor.components.State;

public class StateFactory implements ElementFactory {
    private State state;

    public StateFactory() {
        state = new State();
    }

    @Override
    public Element createElement() {
        return state;
    }
}
