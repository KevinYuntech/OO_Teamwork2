package yuntech.oose.state_diagram_editor.chain_help;

public interface Helpable {
    void help();

    void setNextHelpable(Helpable helpable);
}
