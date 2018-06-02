/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuntech.oose.state_diagram_editor.Builder;

import yuntech.oose.state_diagram_editor.components.*;
import yuntech.oose.state_diagram_editor.field.Canvas;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Kevin 0527
 */
public class DiagramExample {
    /*use to store this element transitionStartList and transitionEndList of this example ,the usage is let the
    transition can attach on the element touched by the transition*/
    protected LinkedList<Transition> transitionStartList = new LinkedList<Transition>();
    protected LinkedList<Transition> transitionEndList = new LinkedList<Transition>();
    private ArrayList<Element> list = new ArrayList<>();/*use to store this element list of this example*/

    /*add each element in list to canvas, and then the canvas will repaint(in addElementByFactory())
    to display the example */
    public void paint(Canvas canvas) {
        for (Element e : list) {
            canvas.addElement(e);
            //canvas.repaint(e.getBounds());
        }
    }

    /*New a start element, and set its location,size according to the parameter, then add to the list */
    public void setStart(int x, int y, int width, int height) {
        Start start = new Start();
        start.setLocation(x, y);
        start.setSize(width, height);
        list.add(start);
    }

    /*New a state element, and set its location,size according to the parameter, then add to the list */
    public void setState(int x, int y, int width, int height, String name) {
        State state = new State();
        state.setLocation(x, y);
        state.setSize(width, height);
        state.setText(name);
        list.add(state);
    }

    /*New a transition element, and set its start location,end location according to the parameter,
    then add to the list */
    public void setTransition(int start_X, int start_y, int end_x, int end_y, String name) {
        Transition transition = new Transition();
        transition.setStart(start_X, start_y);
        transition.setEnd(end_x, end_y);
        transition.setText(name);
        list.add(transition);

        // Placing Transition onto an Element
        for (Element element : list) {
            if (element.isIntersect(transition.getStart())) {
                element.addTransitionStart((Transition) transition);
            }
        }


        for (Element element : list) {
            if (element.isIntersect(transition.getEnd())) {
                element.addTransitionEnd((Transition) transition);
            }
        }
    }

    /*New a end element, and set its location,size according to the parameter, then add to the list */
    public void setEnd(int x, int y, int width, int height) {
        End end = new End();
        end.setLocation(x, y);
        end.setSize(width, height);
        list.add(end);
    }
}
