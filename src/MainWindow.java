import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainWindow extends JFrame{
    private ToolTray toolTray = new ToolTray(200, 600);
    private Canvas canvas = new Canvas(600, 600);

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

        setSize(800, 600);
        GroupLayout groupLayout = new GroupLayout(contentPane);
        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addComponent(toolTray).addComponent(canvas));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup()
                .addComponent(toolTray).addComponent(canvas));

        contentPane.setLayout(groupLayout);

        canvas.setLayout(null);
        Draggable handler = new Draggable();
        canvas.add(handler);
        handler.setBounds(0, 0, 200, 200);

        Grag handler2 = new Grag();
        toolTray.setLayout(null);
        toolTray.add(handler2);
        handler2.setBounds(20, 20,200, 200);


        JButton btn = new JButton("Arrow");
        btn.setBounds(30, 100, 20, 50);
        btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        toolTray.add(btn);



        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
