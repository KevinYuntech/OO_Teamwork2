import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ToolTray extends JPanel implements MouseListener {
    JButton btn = new JButton();

    public ToolTray(int width, int height){
        this.setMinimumSize(new Dimension(width, height));
        facilitate();
    }

    private void facilitate() {
        setBackground(new Color(0x81C889));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
