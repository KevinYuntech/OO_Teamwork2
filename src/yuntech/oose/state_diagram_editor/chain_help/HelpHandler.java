package yuntech.oose.state_diagram_editor.chain_help;

public abstract class HelpHandler {

    protected HelpHandler nextHelpHandler;
    protected String info;

    public HelpHandler(HelpHandler nextHelpHandler, String info) {
        this.nextHelpHandler = nextHelpHandler;
        this.info = info;
    }


    protected abstract void showHelp();

    public void help() {
        if (hasHelp()) {
            showHelp();
        } else {
            nextHelpHandler.help();
        }
    }

    public boolean hasHelp() {
        return info == null;
    }


    public void setNext(HelpHandler helpHandler) {
        nextHelpHandler = helpHandler;
    }
}
