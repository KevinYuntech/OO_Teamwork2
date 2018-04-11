import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Grag extends JButton implements MouseListener, MouseMotionListener {
    private Point draggingStratPoint;

    public Grag() {
        addMouseListener(this);
        addMouseMotionListener(this);
        setBorder(BorderFactory.createLineBorder(new Color(255, 0,0)));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        draggingStratPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // NEEDED: Handling resizing
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX() - draggingStratPoint.x;
        int y = e.getY() - draggingStratPoint.y;
        setBounds(getX() + x, getY() + y, getWidth(), getHeight());

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
