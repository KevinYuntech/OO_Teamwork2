import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;

public class ResizableBorder implements Border {
    // Border
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color = new Color(0);

    // Handle
    private Rectangle handle[] = new Rectangle[8];
    private int handleDimension = 8;
    private Color handleColor = new Color(0xAAAAAA);

    ResizableBorder(Rectangle bounds) {
        updateBounds(bounds);

        /* Positioning(init) handles */
        // NW
        handle[Location.NW] = new Rectangle(x, y, handleDimension, handleDimension);

        // N
        handle[Location.N] = new Rectangle(x + width / 2 - handleDimension / 2, y, handleDimension, handleDimension);

        // NE
        handle[Location.NE] = new Rectangle(x + width - handleDimension, y, handleDimension, handleDimension);

        // E
        handle[Location.E] = new Rectangle(x + width - handleDimension, y + height / 2 - handleDimension / 2, handleDimension, handleDimension);

        // SE
        handle[Location.SE] = new Rectangle(x + width - handleDimension, y + height - handleDimension, handleDimension, handleDimension);

        // S
        handle[Location.S] = new Rectangle(x + width / 2 - handleDimension / 2, y + height - handleDimension, handleDimension, handleDimension);

        // SW
        handle[Location.SW] = new Rectangle(x, y + height - handleDimension, handleDimension, handleDimension);

        // W
        handle[Location.W] = new Rectangle(x, y + height / 2 - handleDimension / 2, handleDimension, handleDimension);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if (c.isFocusOwner()) {
            // Update
            updateBounds(x, y, width, height);
            updateHandles();

            // Draw borders
            g.setColor(color);
            g.drawRect(x + handleDimension / 2, y + handleDimension / 2, width - handleDimension, height - handleDimension);

            // Draw handles
            for (int i = 0; i < handle.length; i++) {
                g.setColor(color);
                g.drawRect(handle[i].x, handle[i].y, handle[i].width, handle[i].height);
                g.setColor(handleColor);
                g.fillRect(handle[i].x, handle[i].y, handle[i].width, handle[i].height);
            }
        }
    }


    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(handleDimension, handleDimension, handleDimension, handleDimension);
    }

    @Override
    public boolean isBorderOpaque() {
        // Hard-coded: Must has border
        return false;
    }

    public void setHandleColor(Color color) {
        handleColor = color;
    }


    // Hard-coded
    public int getCursorType(MouseEvent e){
        int mX = e.getX();
        int mY = e.getY();
        // Cursor is on NW handle
        if (mX > handle[Location.NW].x &&
                mX < handle[Location.NW].x + handle[Location.NW].width &&
                mY > handle[Location.NW].y &&
                mY < handle[Location.NW].y + handle[Location.NW].height) {
            return Cursor.NW_RESIZE_CURSOR;
        }

        // Cursor is on N handle
        if (mX > handle[Location.N].x &&
                mX < handle[Location.N].x + handle[Location.N].width &&
                mY > handle[Location.N].y &&
                mY < handle[Location.N].y + handle[Location.N].height) {
            return Cursor.N_RESIZE_CURSOR;
        }

        // Cursor is on NE handle
        if (mX > handle[Location.NE].x &&
                mX < handle[Location.NE].x + handle[Location.NE].width &&
                mY > handle[Location.NE].y &&
                mY < handle[Location.NE].y + handle[Location.NE].height) {
            return Cursor.NE_RESIZE_CURSOR;
        }

        // Cursor is on E handle
        if (mX > handle[Location.E].x &&
                mX < handle[Location.E].x + handle[Location.E].width &&
                mY > handle[Location.E].y &&
                mY < handle[Location.E].y + handle[Location.E].height) {
            return Cursor.E_RESIZE_CURSOR;
        }

        // Cursor is on SE handle
        if (mX > handle[Location.SE].x &&
                mX < handle[Location.SE].x + handle[Location.SE].width &&
                mY > handle[Location.SE].y &&
                mY < handle[Location.SE].y + handle[Location.SE].height) {
            return Cursor.SE_RESIZE_CURSOR;
        }

        // Cursor is on S handle
        if (mX > handle[Location.S].x &&
                mX < handle[Location.S].x + handle[Location.S].width &&
                mY > handle[Location.S].y &&
                mY < handle[Location.S].y + handle[Location.S].height) {
            return Cursor.S_RESIZE_CURSOR;
        }

        // Cursor is on SW handle
        if (mX > handle[Location.SW].x &&
                mX < handle[Location.SW].x + handle[Location.SW].width &&
                mY > handle[Location.SW].y &&
                mY < handle[Location.SW].y + handle[Location.SW].height) {
            return Cursor.SW_RESIZE_CURSOR;
        }

        // Cursor is on W handle
        if (mX > handle[Location.W].x &&
                mX < handle[Location.W].x + handle[Location.W].width &&
                mY > handle[Location.W].y &&
                mY < handle[Location.W].y + handle[Location.W].height) {
            return Cursor.W_RESIZE_CURSOR;
        }

        // Cursor is not on any handle
        return Cursor.DEFAULT_CURSOR;
    }

    private void updateHandles() {
        // NW
        handle[Location.NW].x = x;
        handle[Location.NW].y =  y;
        handle[Location.NW].width =  handleDimension;
        handle[Location.NW].height =  handleDimension;

        // N
        handle[Location.N].x = x + width / 2 - handleDimension / 2;
        handle[Location.N].y =  y;
        handle[Location.N].width =  handleDimension;
        handle[Location.N].height =  handleDimension;

        // NE
        handle[Location.NE].x = x + width - handleDimension;
        handle[Location.NE].y =  y;
        handle[Location.NE].width =  handleDimension;
        handle[Location.NE].height =  handleDimension;

        // E
        handle[Location.E].x = x + width - handleDimension;
        handle[Location.E].y =  y + height / 2 - handleDimension / 2;
        handle[Location.E].width =  handleDimension;
        handle[Location.E].height =  handleDimension;

        // SE
        handle[Location.SE].x = x + width - handleDimension;
        handle[Location.SE].y =  y + height - handleDimension;
        handle[Location.SE].width =  handleDimension;
        handle[Location.SE].height =  handleDimension;

        // S
        handle[Location.S].x = x + width / 2 - handleDimension / 2;
        handle[Location.S].y =  y + height - handleDimension;
        handle[Location.S].width =  handleDimension;
        handle[Location.S].height =  handleDimension;

        // SW
        handle[Location.SW].x = x;
        handle[Location.SW].y =  y + height - handleDimension;
        handle[Location.SW].width =  handleDimension;
        handle[Location.SW].height =  handleDimension;

        // W
        handle[Location.W].x = x;
        handle[Location.W].y =  y + height / 2 - handleDimension / 2;
        handle[Location.W].width =  handleDimension;
        handle[Location.W].height =  handleDimension;


    }
    static private class Location{

        static int NW = 0;
        static int N = 1;
        static int NE = 2;
        static int E = 3;
        static int SE = 4;
        static int S = 5;
        static int SW = 6;
        static int W = 7;
    }

    private void updateBounds(Rectangle bounds){
        x=  bounds.x;
        y=  bounds.y;
        width =  bounds.width;
        height =  bounds.height;
    }

    private void updateBounds(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
