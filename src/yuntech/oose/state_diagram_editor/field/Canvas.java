package yuntech.oose.state_diagram_editor.field;

import yuntech.oose.state_diagram_editor.components.Element;
import yuntech.oose.state_diagram_editor.components.Transition;
import yuntech.oose.state_diagram_editor.controller.CTRL_CanvasToMementoCaretake;
import yuntech.oose.state_diagram_editor.flyweight.FlyweightFactory;
import yuntech.oose.state_diagram_editor.memento.Memento;
import yuntech.oose.state_diagram_editor.singleton.WordSingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.EmptyStackException;
import java.util.LinkedList;

public class Canvas extends JPanel implements MouseListener, MouseMotionListener {

    /* Fields */

    // Storing Elements information
    public LinkedList<Element> elementList = new LinkedList<>();
    private Element elementGannaDraw;
    private Element lastPressedElement;
    private Point lastPressedPoint;
    private CTRL_CanvasToMementoCaretake ctrl_canvasToMementoCaretake = new CTRL_CanvasToMementoCaretake();

    /* Constructors */

    public Canvas(int width, int height) {
        setSize(width, height);
        setPreferredSize(new Dimension(width, height));
        setLayout(null);
        addMouseListener(this);
        addMouseMotionListener(this);

        // Default Canvas background color
        setBackground(new Color(0xE7F0F3));
        FlyweightFactory.getFlyweightFactory().getColorFlyweight(0xE7F0F3);
    }

    /* Public methods */

    public void addElement(Element element) {
        elementList.add(element);
        repaint(element.getBounds());
    }

    public void setElementGannaDraw(Element elementGannaDraw) {
        this.elementGannaDraw = elementGannaDraw;
    }

    // TODO: Add controller to communicate
    public void undo() {
        try {
            elementList = (LinkedList<Element>) ctrl_canvasToMementoCaretake.getSnapshot().getLinkedList();
        } catch (EmptyStackException e) {
            // Indicating no snapshot was stored
        }


        repaint();
    }

    /* Override methods */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Element element : elementList) {
            element.setFont(new Font(WordSingleton.getInstance().getFontName(), WordSingleton.getInstance().getFontStyle(), WordSingleton.getInstance().getFontSize()));
            element.setLabelColor(FlyweightFactory.getFlyweightFactory().getColorFlyweight(WordSingleton.getInstance().getFontColor().getRGB()).getRGB());
            element.draw(g);
        }
    }


    // TODO: Restructure it
    @Override
    public void mouseClicked(MouseEvent e) {
        /*
         * Cursor in CROSSHAIR_CURSOR type indicates elementGannaDraw is not null,
         * but this may not be true in the future.
         * So still check if elementGannaDraw isn't null
         */
        takeSnapshot();

        if (getCursor().getType() == Cursor.CROSSHAIR_CURSOR &&
                elementGannaDraw != null &&
                !(elementGannaDraw instanceof Transition)) {

            elementGannaDraw.setLocation(e.getX() - elementGannaDraw.getWidth() / 2, e.getY() - elementGannaDraw.getHeight() / 2);
            repaint(elementGannaDraw.getBounds());
            if (!addToComposite(e.getPoint(), elementGannaDraw)) {
                addElement(elementGannaDraw);
            }
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            elementGannaDraw = null;


            return;
        }

        // Placing Transition start point
        if (getCursor().getType() == Cursor.CROSSHAIR_CURSOR &&
                elementGannaDraw instanceof Transition &&
                elementGannaDraw.getStatus() == Element.NORMAL) {

            elementGannaDraw.setStatus(Element.FOCUSEd);
            ((Transition) elementGannaDraw).setStart(e.getPoint());
            ((Transition) elementGannaDraw).setEnd(e.getPoint());
            addElement(elementGannaDraw);
            return;
        }

        // Placing Transition end point
        if (getCursor().getType() == Cursor.CROSSHAIR_CURSOR &&
                elementGannaDraw instanceof Transition &&
                elementGannaDraw.getStatus() == Element.FOCUSEd) {

            elementGannaDraw.setStatus(Element.NORMAL);
            ((Transition) elementGannaDraw).setEnd(e.getPoint());
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            elementGannaDraw = null;
            return;
        }

        // TODO: Unsure judging getClickCount() == 2 is good
        if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {

        }

        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        lastPressedPoint = e.getPoint();
        for (Element element :
                elementList) {
            if (element.isIntersect(e.getPoint())) {
                lastPressedElement = element;
                break;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int distX = e.getX() - lastPressedPoint.x;
        int distY = e.getY() - lastPressedPoint.y;

        if (lastPressedElement != null) {
            lastPressedElement.setLocation(lastPressedElement.getX() + distX, lastPressedElement.getY() + distY);
        }

        lastPressedPoint = e.getPoint();
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        lastPressedElement = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (elementGannaDraw instanceof Transition) {
            ((Transition) elementGannaDraw).setEnd(e.getPoint());
            repaint();
        }
    }

    /* Private methods */

    private boolean addToComposite(Point point, Element element) {
        for (Element e : elementList) {
            if (e.isIntersect(point)) {
                e.add(element);
                return true;
            }
        }
        return false;
    }


    // Store the state of Canvas.
    private void takeSnapshot() {
        /*
         * NOTICE (potential bug):
         * list takes the same Elements as in elementList, which held by Canvas.
         * That is, a particular Element in list and a particular Element in Canvas.elementList
         * is the same instance.
         * If one modify list (or the memento storing this list),
         * it cause Canvas.elementList be modify too.
         */
        LinkedList<Element> list = new LinkedList<>();
        list.addAll(elementList);

        Memento memento = new Memento(list);

        ctrl_canvasToMementoCaretake.snapshot(memento);
    }
}
