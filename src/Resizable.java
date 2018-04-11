import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Resizable extends JButton implements MouseListener, MouseMotionListener, FocusListener {
    private ResizableBorder resizableBorder;
    private Point lastDraggingStartPoint;
    protected int mousePressedCursorType;

    int press = 0;
    int drag = 0;

    Resizable() {
        this.resizableBorder = new ResizableBorder(getBounds());
        setBorder(resizableBorder);
        addMouseListener(this);
        addMouseMotionListener(this);
        addFocusListener(this);
    }

    /* MouseListener methods */
    @Override
    public void mouseClicked(MouseEvent e) {
        requestFocusInWindow();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mousePressedCursorType = resizableBorder.getCursorType(e);
        setCursor(new Cursor(mousePressedCursorType));

        lastDraggingStartPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        setCursor(new Cursor(resizableBorder.getCursorType(e)));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    /* MouseMotionListener methods */
    @Override
    public void mouseDragged(MouseEvent e) {

        int distX = (int) (e.getX() - lastDraggingStartPoint.getX());
        int distY = (int) (e.getY() - lastDraggingStartPoint.getY());

        switch (mousePressedCursorType) {
            // NW
            case Cursor.NW_RESIZE_CURSOR:
                setBounds(getBounds().x + distX, getBounds().y + distY, getBounds().width - distX, getBounds().height - distY);
                break;

            // N
            case Cursor.N_RESIZE_CURSOR:
                setBounds(getBounds().x, getBounds().y + distY, getBounds().width, getBounds().height - distY);
                break;

            // NE
            case Cursor.NE_RESIZE_CURSOR:
                setBounds(getBounds().x, getBounds().y + distY, getBounds().width + distX, getBounds().height - distY);
                break;

            // E
            case Cursor.E_RESIZE_CURSOR:
                setBounds(getBounds().x, getBounds().y, getBounds().width + distX, getBounds().height);
                break;

            // SE
            case Cursor.SE_RESIZE_CURSOR:
                setBounds(getBounds().x, getBounds().y, getBounds().width + distX, getBounds().height + distY);
                break;

            // S
            case Cursor.S_RESIZE_CURSOR:
                setBounds(getBounds().x, getBounds().y, getBounds().width, getBounds().height + distY);
                break;

            // SW
            case Cursor.SW_RESIZE_CURSOR:
                setBounds(getBounds().x + distX, getBounds().y, getBounds().width - distX, getBounds().height + distY);
                break;

            // W
            case Cursor.W_RESIZE_CURSOR:
                setBounds(getBounds().x + distX, getBounds().y, getBounds().width - distX, getBounds().height);
                break;
        }
//        lastDraggingStartPoint = e.getPoint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        setCursor(new Cursor(resizableBorder.getCursorType(e)));
    }

    /* FocusListener methods */
    @Override
    public void focusLost(FocusEvent e) {
        setBorder(null);
    }

    @Override
    public void focusGained(FocusEvent e) {
        setBorder(resizableBorder);
    }

}

