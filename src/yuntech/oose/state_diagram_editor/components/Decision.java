package yuntech.oose.state_diagram_editor.components;

// TODO
public class Decision extends Element {
    static private int num;
    @Override
    void initLabel() {
        label = new Label(this.getClass().getSimpleName() + num);
        num++;
    }
}
