package yuntech.oose.state_diagram_editor.drawing;

import yuntech.oose.state_diagram_editor.components.Element;
import yuntech.oose.state_diagram_editor.components.Transition;

import java.awt.*;

public class ArrowDrawable extends Drawable{
    public ArrowDrawable(){

    }

    @Override
    public Drawable getNewInstance() {
        return new ArrowDrawable();
    }

    @Override
    public void draw(Element element, Graphics g) {
        Transition transition= (Transition)element;
        g.setColor(element.getColor());
        g.drawLine(transition.getStart().x, transition.getStart().y, transition.getEnd().x, transition.getEnd().y);

        /* Draw wings */
        // Math.atan2(double y,double x) takes a vector and return the angle respect to horizontal,
        // range in [-Math.PI, Math.PI]
        // atan --> arc tangent

        double angle = Math.atan2(transition.getEnd().y - transition.getStart().y, transition.getEnd().x - transition.getStart().x);

        // wing1
        g.drawLine(transition.getEnd().x, transition.getEnd().y,
                (int) (transition.getEnd().x - transition.getWingLength() * Math.cos(angle - Math.toRadians(transition.getWingDegree()))),
                (int) (transition.getEnd().y - transition.getWingLength() * Math.sin(angle - Math.toRadians(transition.getWingDegree()))));
        // wing2
        g.drawLine(transition.getEnd().x, transition.getEnd().y,
                (int) (transition.getEnd().x - transition.getWingLength() * Math.cos(angle + Math.toRadians(transition.getWingDegree()))),
                (int) (transition.getEnd().y - transition.getWingLength() * Math.sin(angle + Math.toRadians(transition.getWingDegree()))));

        /* Draw it's label */
        g.setColor(transition.getLabelColor());
    }
}
