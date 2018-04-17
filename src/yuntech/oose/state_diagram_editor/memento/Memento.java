package yuntech.oose.state_diagram_editor.memento;


public class Memento {

    private Object object;

    public Memento(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

}
