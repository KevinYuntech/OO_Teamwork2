package yuntech.oose.state_diagram_editor.field;

import yuntech.oose.state_diagram_editor.Draggable;

import javax.swing.*;

public class MainWindow extends JFrame{
    // For convenience
    private final int width = 800;
    private final int height = 600;

    private Canvas canvas = new Canvas(600, 600);
    private ToolTray toolTray = new ToolTray(new CTRL_ToolTrayToCanvas(canvas), 200, 600);

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }

    public MainWindow(){
        setupFrame();
        setVisible(true);
    }

    private void setupFrame() {
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);

        setSize(width, height);

        // Arranging contents
        GroupLayout groupLayout = new GroupLayout(contentPane);
        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addComponent(toolTray, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                .addComponent(canvas, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup()
                .addComponent(toolTray, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                .addComponent(canvas, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE));
        contentPane.setLayout(groupLayout);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
