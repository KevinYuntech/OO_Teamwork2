package yuntech.oose.state_diagram_editor.field;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangeShapeDialog extends JDialog {


    public ChangeShapeDialog(MainWindow _mainWindow) {
        super(_mainWindow);
        setTitle("Change Shape");
        setModal(true);
        setLayout(null);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        final String[] selectedElement = new String[1];
        final String[] selectedDrawable = new String[1];

        String[] elements = {"Composite", "Decision", "End", "Start", "State"};
        final JList<String> elementList = new JList<String>(elements);
        elementList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedElement[0] = elementList.getSelectedValue();
            }
        });

        JScrollPane elementScrollPane = new JScrollPane(elementList);
        elementScrollPane.setBounds(30, 30, 250, 100);
        add(elementScrollPane);

        String[] shapes = {"Circle", "Circle in circle", "Diamond", "Full round rectangle", "Round rectangle"};
        final JList<String> shapeList = new JList<String>(shapes);
        shapeList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedDrawable[0] = shapeList.getSelectedValue();
            }
        });
        JScrollPane shapeScrollPane = new JScrollPane(shapeList);
        shapeScrollPane.setBounds(300, 30, 250, 100);
        add(shapeScrollPane);

        JButton btn_ok = new JButton("OK");
        btn_ok.setBounds(390, 220, 90, 30);
        btn_ok.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (selectedElement[0] != null && selectedDrawable[0] != null) {
                    _mainWindow.changeShape(selectedElement[0], selectedDrawable[0]);
                    ChangeShapeDialog.this.dispose();
                }
            }
        });
        add(btn_ok);

        JButton btn_cancel = new JButton("Cancel");
        btn_cancel.setBounds(490, 220, 90, 30);
        btn_cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ChangeShapeDialog.this.dispose();
            }
        });
        add(btn_cancel);

        setVisible(true);
    }
}
