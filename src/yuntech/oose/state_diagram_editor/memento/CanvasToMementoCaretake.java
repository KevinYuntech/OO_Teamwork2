package yuntech.oose.state_diagram_editor.memento;

import java.util.EmptyStackException;

// Create by a Canvas who needs to store snapshots.
// In this special case (this particular program), there just one Canvas
public class CanvasToMementoCaretake {
    private MementoCaretaker mementoCaretaker = new MementoCaretaker();

    // Called by Canvas to store snapshot
    public void snapshot(Memento memento) {
        mementoCaretaker.addMemento(memento);
    }

    // Called by Canvas (This event is caused by undo button)
    public Memento getSnapshot() throws EmptyStackException {
        return mementoCaretaker.getMemento();
    }

}
