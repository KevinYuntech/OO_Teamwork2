package yuntech.oose.state_diagram_editor.factory;

import yuntech.oose.state_diagram_editor.components.Element;
import yuntech.oose.state_diagram_editor.components.Transition;

public class TransitionFactory implements ElementFactory {
    private Transition transition;

    public TransitionFactory() {
        transition = new Transition();
    }

    @Override
    public Element createElement() {
        return transition;
    }
}
