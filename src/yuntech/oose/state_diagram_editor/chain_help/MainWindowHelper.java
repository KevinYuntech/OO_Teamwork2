package yuntech.oose.state_diagram_editor.chain_help;

import javax.swing.*;
import java.awt.*;

// The last Helper of chain
public class MainWindowHelper extends Helper {
    public MainWindowHelper(Component owner, String info, Helper nextHelp) {
        super(owner, info, nextHelp);
    }

    @Override
    public void help() {
        JOptionPane.showMessageDialog(owner, info);
    }
}
