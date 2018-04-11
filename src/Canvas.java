import javax.swing.*;
import java.awt.*;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

public class Canvas extends JPanel implements MouseListener, MouseMotionListener {


    Arrow arrow = new Arrow(new Point(300, 300));
    private Point start;
    private Point end;
    private int wingLength = 6;
    private int wingDegree = 90;
    public LinkedList<Element> elementList = new LinkedList<>();



    public Canvas(int width, int height) {
        setSize(width, height);
        setPreferredSize(new Dimension(width, height));
        setLayout(null);
        addMouseListener(this);
        addMouseMotionListener(this);
        arrow.setEnd(new Point(200, 200));
        facilitate();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        arrow.draw(g);
    }

    private void facilitate() {
        setBackground(new Color(0xE7F0F3));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        arrow.setStart(e.getPoint());
        System.out.println("Start Point: (" + arrow.getStart().x + ", " + arrow.getStart().y + ")");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        arrow.setEnd(e.getPoint());
        System.out.println("End Point: (" + arrow.getEnd().x + ", " + arrow.getEnd().y + ")");
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        arrow.setEnd(e.getPoint());
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
