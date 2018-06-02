/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuntech.oose.state_diagram_editor.Builder;

/**
 * @author Kevin 0527
 */
public class SAExampleBuilder extends DiagramExampleBuilder {
    //Call the example to and input the parameter to set the position of start 
    @Override
    public void buildStart() {
        this.example.setStart(100, 100, 35, 35);
    }

    //Call the example to and input the parameter to set the name, position of state
    @Override
    public void buildState() {
        this.example.setState(200, 100, 150, 75, "Studying_SA");
    }

    //Call the example to and input the parameter to set the position of end
    @Override
    public void buildEnd() {
        this.example.setEnd(550, 100, 35, 35);
    }

    //Call the example to and input the parameter to set the name, position of transition
    @Override
    public void buildTransition() {
        this.example.setTransition(120, 115, 250, 115, "Start to Studying_SA");
        this.example.setTransition(270, 120, 570, 120, "Studying_SA to End");
    }
}
