/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuntech.oose.state_diagram_editor.Builder;

/**
 * @author Kevin 0527
 */
public class OOExampleBuilder extends DiagramExampleBuilder {
    //Call the example to and input the parameter to set the position of start 
    @Override
    public void buildStart() {
        this.example.setStart(300, 50, 35, 35);
    }

    //Call the example to and input the parameter to set the name, position of state
    @Override
    public void buildState() {
        this.example.setState(250, 175, 150, 75, "Studying_OO");

    }

    //Call the example to and input the parameter to set the position of end
    @Override
    public void buildEnd() {
        this.example.setEnd(300, 350, 35, 35);

    }

    //Call the example to and input the parameter to set the name, position of transition
    @Override
    public void buildTransition() {
        this.example.setTransition(320, 80, 320, 180, "Start to Studying_OO");
        this.example.setTransition(320, 230, 320, 360, "Studying_OO to End");

    }
}
