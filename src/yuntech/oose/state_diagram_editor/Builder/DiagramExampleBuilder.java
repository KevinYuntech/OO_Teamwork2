/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuntech.oose.state_diagram_editor.Builder;

/**
 * @author Kevin 0527
 */
public abstract class DiagramExampleBuilder {
    protected DiagramExample example;//Has a diagramExample, initial it until the create method be called

    //create diagramexample
    public void createNewDiagramExample() {
        example = new DiagramExample();
    }

    //get diagramExample
    public DiagramExample getDiagramExample() {
        return example;
    }

    public abstract void buildStart();//define buildstart

    public abstract void buildState();//define buildstate

    public abstract void buildTransition();//define buildtransition

    public abstract void buildEnd();    //define buildend
}
