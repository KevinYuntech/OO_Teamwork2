/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuntech.oose.state_diagram_editor.Builder;

/**
 * @author Kevin 0527
 */
public class DiagramExampleDirector {
    private DiagramExampleBuilder builder;//Has a diagramExampleBuilder set by the constructor

    public void setBulider(DiagramExampleBuilder builder) {
        this.builder = builder;//set the diagramExampleBuilder
    }

    //Call the diagramExampleBuilder and use a series of steps to create the diagramExample
    public void create() {
        builder.createNewDiagramExample();
        builder.buildStart();
        builder.buildState();
        builder.buildEnd();
        builder.buildTransition();
    }

    //Call diagramExampleBuilder to get diagramExample
    public DiagramExample getDiagramExample() {
        return builder.getDiagramExample();
    }
}
