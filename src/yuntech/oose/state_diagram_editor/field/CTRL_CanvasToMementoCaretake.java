package yuntech.oose.state_diagram_editor.field;

import yuntech.oose.state_diagram_editor.memento.Memento;
import yuntech.oose.state_diagram_editor.memento.MementoCaretaker;

import java.util.EmptyStackException;

public class CTRL_CanvasToMementoCaretake {
    private MementoCaretaker mementoCaretaker = new MementoCaretaker();

    public void snapshot(Memento memento){
        mementoCaretaker.addMemento(memento);
    }

    public Memento getSnapshot() throws EmptyStackException {
        return mementoCaretaker.getMemento();
    }

}
