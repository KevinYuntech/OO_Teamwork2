package yuntech.oose.state_diagram_editor.memento;


import java.util.EmptyStackException;
import java.util.Stack;


public class MementoCaretaker {

    private Stack<Memento> saves = new Stack<Memento>();


    public void addMemento(Memento memento) {
        saves.push(memento);
    }

    public Memento getMemento() throws EmptyStackException {
        return saves.pop();
    }


}
