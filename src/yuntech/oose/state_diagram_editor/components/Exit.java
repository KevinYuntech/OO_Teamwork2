package yuntech.oose.state_diagram_editor.components;

// TODO
public class Exit extends Element {
    static private int numOfInstances;
    @Override
    void initLabel() {
        label = new Label(this.getClass().getSimpleName() + numOfInstances);
        numOfInstances++;
    }
}
