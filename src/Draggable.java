import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Draggable extends Resizable {
    private Point lastDraggingStartPoint;

    public Draggable() {
        super();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // NEEDED: Handling resizing
        super.mousePressed(e);
        if (mousePressedCursorType == Cursor.DEFAULT_CURSOR) {
            mousePressedCursorType = Cursor.MOVE_CURSOR;
            setCursor(new Cursor(Cursor.MOVE_CURSOR));
        }

        lastDraggingStartPoint = e.getPoint();
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        // NEEDED: Handling resizing
        super.mouseDragged(e);

        if (mousePressedCursorType == Cursor.MOVE_CURSOR) {
//            int distX = (int) (e.getX() - lastDraggingStartPoint.getX());
//            int distY = (int) (e.getY() - lastDraggingStartPoint.getY());
            int distX = e.getX() - lastDraggingStartPoint.x;
            int distY = e.getY() - lastDraggingStartPoint.y;
            setLocation(getX() + distX, getY() + distY);
        }

//        getParent().revalidate();
//        getParent().repaint();
//        lastDraggingStartPoint = e.getPoint();

        // IMPORTANT: Update lastDraggingStartPoint after dragged
//        lastDraggingStartPoint = e.getPoint();
    }
}
