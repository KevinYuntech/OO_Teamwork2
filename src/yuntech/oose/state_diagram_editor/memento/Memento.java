package yuntech.oose.state_diagram_editor.memento;


import yuntech.oose.state_diagram_editor.components.Element;

import java.util.LinkedList;

public class Memento {

    private Object object;

    public Memento(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

}
