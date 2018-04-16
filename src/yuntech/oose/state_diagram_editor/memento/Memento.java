package yuntech.oose.state_diagram_editor.memento;


import yuntech.oose.state_diagram_editor.components.Element;

import java.util.LinkedList;

public class Memento {

    private LinkedList<Element> linkedList;

    public Memento(LinkedList linkedList) {
        this.linkedList = linkedList;
    }

    public Object getLinkedList() {
        return linkedList;
    }

}
