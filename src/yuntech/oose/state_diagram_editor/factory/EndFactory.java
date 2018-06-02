package yuntech.oose.state_diagram_editor.factory;

import yuntech.oose.state_diagram_editor.components.Element;
import yuntech.oose.state_diagram_editor.components.End;

public class EndFactory implements ElementFactory {
    private End end;

    public EndFactory() {
        end = new End();
    }

    @Override
    public Element createElement() {
        return end;
    }
}
