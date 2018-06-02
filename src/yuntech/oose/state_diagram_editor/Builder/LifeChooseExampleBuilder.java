/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuntech.oose.state_diagram_editor.Builder;

/**
 * @author Kevin 0527
 */
public class LifeChooseExampleBuilder extends DiagramExampleBuilder {
    //Call the example to and input the parameter to set the position of start 
    @Override
    public void buildStart() {
        this.example.setStart(300, 50, 35, 35);
    }

    //Call the example to and input the parameter to set the name, position of state
    @Override
    public void buildState() {
        this.example.setState(250, 175, 150, 75, "Init");
        this.example.setState(400, 300, 150, 75, "Success");
        this.example.setState(100, 300, 150, 75, "Fail");
    }

    //Call the example to and input the parameter to set the position of end
    @Override
    public void buildEnd() {
        this.example.setEnd(150, 480, 35, 35);
        this.example.setEnd(450, 480, 35, 35);
    }

    //Call the example to and input the parameter to set the name, position of transition
    @Override
    public void buildTransition() {
        this.example.setTransition(320, 80, 320, 180, "start to state");
        this.example.setTransition(320, 240, 200, 310, "choose x");
        this.example.setTransition(320, 240, 450, 310, "choose y");
        this.example.setTransition(170, 370, 170, 490, "x to End");
        this.example.setTransition(470, 370, 470, 490, "y to End");
    }
}
