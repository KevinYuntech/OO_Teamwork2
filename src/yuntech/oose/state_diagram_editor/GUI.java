package yuntech.oose.state_diagram_editor;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class GUI extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI frame = new GUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 100, 649, 450);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenu mnNew = new JMenu("New");
        mnFile.add(mnNew);

        JMenu mnNewDiagram = new JMenu("New Diagram");
        mnNew.add(mnNewDiagram);

        JMenuItem mntmOpenFile = new JMenuItem("Open file");
        mnFile.add(mntmOpenFile);

        JMenuItem mntmClose = new JMenuItem("Close");
        mnFile.add(mntmClose);

        JMenu mnEdit = new JMenu("Edit");
        menuBar.add(mnEdit);

        JMenu mnHelp = new JMenu("Help");
        menuBar.add(mnHelp);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JButton btnNewButton = new JButton("Redo");

        JButton btnNewButton_1 = new JButton("Undo");

        JButton btnNewButton_2 = new JButton("Transtion");

        JButton btnNewButton_3 = new JButton("Desision");

        JButton btnNewButton_4 = new JButton("State");

        JButton btnNewButton_5 = new JButton("Start");

        JButton btnNewButton_6 = new JButton("Exit");

        JButton btnNewButton_7 = new JButton("Fort");

        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(249)
                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                                .addGap(71)
                                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(27)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(btnNewButton_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(2)
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(btnNewButton_7, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                                                        .addComponent(btnNewButton_6, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))))
                                                .addGap(51)
                                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(49, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(44)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewButton_1)
                                        .addComponent(btnNewButton))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(btnNewButton_2)
                                                .addGap(18)
                                                .addComponent(btnNewButton_3)
                                                .addGap(18)
                                                .addComponent(btnNewButton_4)
                                                .addGap(18)
                                                .addComponent(btnNewButton_5)
                                                .addGap(18)
                                                .addComponent(btnNewButton_6)
                                                .addGap(18)
                                                .addComponent(btnNewButton_7))
                                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(47, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);





    }

}
