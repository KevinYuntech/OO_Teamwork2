package yuntech.oose.state_diagram_editor.field;

import yuntech.oose.state_diagram_editor.components.Composite;
import yuntech.oose.state_diagram_editor.components.Element;
import yuntech.oose.state_diagram_editor.components.Transition;
import yuntech.oose.state_diagram_editor.drawing.*;
import yuntech.oose.state_diagram_editor.flyweight.FlyweightFactory;
import yuntech.oose.state_diagram_editor.memento.CanvasToMementoCaretake;
import yuntech.oose.state_diagram_editor.memento.Memento;
import yuntech.oose.state_diagram_editor.singleton.WordSingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.EmptyStackException;
import java.util.LinkedList;

// CAUTION: call repaint() instead of repaint(bounds), because some Elements has no width and height
public class Canvas extends JPanel implements MouseListener, MouseMotionListener {

    /* Fields */

    // Store Elements in this Canvas
    private LinkedList<Element> elementList = new LinkedList<>();
    // Chosen Element (gonna draw on Canvas)
    private Element elementGonnaDraw;
    private Element lastPressedElement;
    private Point lastPressedPoint;
    private CanvasToMementoCaretake canvasToMementoCaretake = new CanvasToMementoCaretake();
    private Memento memento_currentState;    // Used to store current state

    /* Constructors */

    public Canvas(int width, int height) {
        setLayout(null);    // Don't Change This
        setSize(width, height);
        setPreferredSize(new Dimension(width, height));
        addMouseListener(this);
        addMouseMotionListener(this);

        // Default Canvas background color
        FlyweightFactory.getFlyweightFactory().getColorFlyweight(0xE7F0F3);
        takeSnapshot();
    }

    /* Public methods */

    public void addElement(Element element) {
        elementList.add(element);
        /*
         * Take a snapshot every time a new Element is added (more specifically. placed)
         * Transition is a special case:
         * Transition is added when it's start point is defined by a user.
         * (because Canvas needs to draw it until end point is not defined)
         * Snapshot of placing Transition is taken whenever end point is defined.
         */
        if (!(element instanceof Transition)) {
            takeSnapshot();
        }
        repaint();
    }

    // Called by CTRL_ToolTrayToCanvas
    public void setElementGonnaDraw(Element elementGonnaDraw) {
        this.elementGonnaDraw = elementGonnaDraw;
    }

    public void undo() {
        try {
            // Canvas knows it stored a DiagramState to memento_currentState
            DiagramState diagramState = (DiagramState) canvasToMementoCaretake.getSnapshot().getObject();

            // Set back Elements
            elementList = diagramState.list;

            // Set back Flyweight and Singleton
            WordSingleton wordSingleton = WordSingleton.getInstance();
            wordSingleton.setFontName(diagramState.fontName);
            wordSingleton.setFontStyle(diagramState.fontStyle);
            wordSingleton.setFontSize(diagramState.fontSize);
            wordSingleton.setFontColor(diagramState.color.getRGB());

            repaint();
            // After undo, current state should be update as previous state.
            // The state store in memento_currentState should not be pushed, so set it to null
            memento_currentState = null;
            takeSnapshot();
        } catch (EmptyStackException e) {
            // Indicating no snapshot was stored
        }
    }

    /* Override methods */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Element element : elementList) {
            // Update font of Label of Element.
            // WordSingleton maintain fontName, fontStyle, fontSize. but not a Font;
            element.setFont(new Font(WordSingleton.getInstance().getFontName(),
                    WordSingleton.getInstance().getFontStyle(),
                    WordSingleton.getInstance().getFontSize()));
            // Update color of Label of Element.
            // WordSingleton maintain fontName, fontStyle, fontSize. but not a Font;
            element.setLabelColor(FlyweightFactory.getFlyweightFactory().getColorFlyweight(
                    WordSingleton.getInstance().getFontColor().getRGB()).getRGB());
            // Draw the element on Canvas
            element.draw(g);
        }
    }


    // TODO: Restructure it
    @Override
    public void mouseClicked(MouseEvent e) {
        /*
         * Cursor in CROSSHAIR_CURSOR type indicates elementGonnaDraw is not null,
         * but this may not be true in the future.
         * So still check if elementGonnaDraw isn't null
         */

        // Change label text
        if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
            for (Element element : elementList) {
                if (element.isIntersect(e.getPoint())) {
                    String str = JOptionPane.showInputDialog(
                            this, "Change Text", "Enter", JOptionPane.QUESTION_MESSAGE);
                    if (str != null) {
                        element.setText(str);
                    }
                    repaint();
                }
            }
        }

        // Placing an Element
        if (getCursor().getType() == Cursor.CROSSHAIR_CURSOR &&
                elementGonnaDraw != null &&
                !(elementGonnaDraw instanceof Transition)) {

            elementGonnaDraw.setLocation(e.getX() - elementGonnaDraw.getWidth() / 2,
                    e.getY() - elementGonnaDraw.getHeight() / 2);
            repaint(elementGonnaDraw.getBounds());

            if (!addToComposite(e.getPoint(), elementGonnaDraw)) {
                addElement(elementGonnaDraw);
            }

            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            elementGonnaDraw = null;

            return;
        }

        // Placing Transition start point
        if (getCursor().getType() == Cursor.CROSSHAIR_CURSOR &&
                elementGonnaDraw instanceof Transition &&
                elementGonnaDraw.getStatus() == Element.NORMAL) {
            elementGonnaDraw.setStatus(Element.FOCUSEd);
            ((Transition) elementGonnaDraw).setStart(e.getPoint());
            ((Transition) elementGonnaDraw).setEnd(e.getPoint());
            addElement(elementGonnaDraw);

            // Placing Transition onto an Element
            for (Element element : elementList) {
                if (element.isIntersect(e.getPoint())) {
                    element.addTransitionStart((Transition) elementGonnaDraw);
                }
            }

            return;
        }

        // Placing Transition end point
        if (getCursor().getType() == Cursor.CROSSHAIR_CURSOR &&
                elementGonnaDraw instanceof Transition &&
                elementGonnaDraw.getStatus() == Element.FOCUSEd) {
            elementGonnaDraw.setStatus(Element.NORMAL);
            ((Transition) elementGonnaDraw).setEnd(e.getPoint());
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

            // Placing Transition onto an Element
            for (Element element : elementList) {
                if (element.isIntersect(e.getPoint())) {
                    element.addTransitionEnd((Transition) elementGonnaDraw);
                }
            }

            elementGonnaDraw = null;
            takeSnapshot();
            return;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        lastPressedPoint = e.getPoint();

        // Update lastPressedElement
        for (Element element : elementList) {
            if (element.isIntersect(e.getPoint())) {
                lastPressedElement = element;
                break;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // If an Element is pressed, it can be dragged
        if (lastPressedElement != null) {
            setCursor(new Cursor(Cursor.MOVE_CURSOR));
            int distX = e.getX() - lastPressedPoint.x;
            int distY = e.getY() - lastPressedPoint.y;
            lastPressedElement.setLocation(lastPressedElement.getX() + distX, lastPressedElement.getY() + distY);
            repaint();
        }
        lastPressedPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (getCursor().getType() == Cursor.MOVE_CURSOR) {
            // Prevent one drags an Element while placing end point of Transition causing bug
            if (elementGonnaDraw instanceof Transition) {
                setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
            } else {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            takeSnapshot();
        }

        // Left out pressed element, if not,
        // dragging will be buggy
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
        // Start point of Transition is defined, but defining its end point
        if (elementGonnaDraw instanceof Transition && elementGonnaDraw.getStatus() == Element.FOCUSEd) {
            ((Transition) elementGonnaDraw).setEnd(e.getPoint());
            repaint();
        }
    }

    /* Private methods */

    // If placed Element is in a Composite, add it into the Composite
    private boolean addToComposite(Point point, Element element) {
        for (Element e : elementList) {
            if (e.isIntersect(point)) {
                e.add(element);
                takeSnapshot();
                return true;
            }
        }
        return false;
    }


    // Store the state of Canvas.
    // Do take a snapshot after an action
    /*
     * Actions: (reference)
     * An element is placed to Canvas
     * An element is placed into Composite
     * End point of Transition is placed
     * An Element is dragged
     */
    public void takeSnapshot() {
        // Copy all Elements inside Canvas to list the store into memento_currentState
        LinkedList<Element> list = new LinkedList<>();
        for (Element element : elementList) {
            list.add(element.getInstanceCopy());
        }

        WordSingleton wordSingleton = WordSingleton.getInstance();
        DiagramState diagramState = new DiagramState(
                list,
                wordSingleton.getFontName(),
                wordSingleton.getFontStyle(),
                wordSingleton.getFontSize(),
                wordSingleton.getFontColor());

        // Order is important
        if (memento_currentState != null) {
            canvasToMementoCaretake.snapshot(memento_currentState);
        }

        // Order is important
        memento_currentState = new Memento(diagramState);
    }

    public void changeShape(String whichElement, String whichDrawable) {
        Drawable drawable = null;
        if (whichDrawable.equals("Circle")) {
            drawable = new CircleDrawable();
        } else if (whichDrawable.equals("Circle in circle")) {
            drawable = new CircleInCircleDrawable();
        } else if (whichDrawable.equals("Diamond")) {
            drawable = new DiamondDrawable();
        } else if (whichDrawable.equals("Full round rectangle")) {
            drawable = new FullRoundRectangleDrawable();
        } else if (whichDrawable.equals("Round rectangle")) {
            drawable = new RoundRectangleDrawable();
        }

        for (Element element : elementList) {
            if (element instanceof Composite) {
                ((Composite) element).changeShape(whichElement, whichDrawable);
            }
            if (element.getClass().getSimpleName().equals(whichElement)) {
                element.setDrawable(drawable);
            }
        }
        repaint();
    }

    class DiagramState {
        LinkedList<Element> list;
        String fontName;
        int fontStyle;
        int fontSize;
        Color color;

        DiagramState(LinkedList<Element> list, String fontName, int fontStyle, int fontSize, Color color) {
            this.list = list;
            this.fontName = fontName;
            this.fontStyle = fontStyle;
            this.fontSize = fontSize;
            this.color = color;
        }
    }
}