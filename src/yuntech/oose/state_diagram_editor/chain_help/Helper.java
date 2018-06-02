package yuntech.oose.state_diagram_editor.chain_help;

import javax.swing.*;
import java.awt.*;

public class Helper {
    protected Component owner;  // The Component for the JOptionPane showing help info
    protected Helper nextHelp;  // Next handler for a help request thrown by a user
    protected String info;      // Help message

    public Helper(Component owner, String info, Helper nextHelp) {
        this.owner = owner;
        this.info = info;
        this.nextHelp = nextHelp;
    }

    // Default behavior for subclasses that provide no help,
    // so that the subclass will forward help while the help is called
    public void help() {
        // If the help message is not wanted (reject) by a user then show next help message
        if (JOptionPane.NO_OPTION == JOptionPane.showOptionDialog(

                owner,
                info,
                "Help",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]{"Accept", "Reject"},
                1)) {
            nextHelp.help();
        }
    }
}
