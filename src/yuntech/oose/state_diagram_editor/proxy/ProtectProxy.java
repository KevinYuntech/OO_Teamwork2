package yuntech.oose.state_diagram_editor.proxy;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import yuntech.oose.state_diagram_editor.field.MainWindow;
import yuntech.oose.state_diagram_editor.mediator.FontChooserDialog;

public class ProtectProxy extends JDialog implements Protectable {

	private MainWindow mainWindow;
	private JLabel label;
	private JTextField textField;
	private JButton buttonhadpaid;
	private FontChooserDialog fontchooserdialog;

	public ProtectProxy(MainWindow _mainWindow, String _title, boolean _flag, FontChooserDialog _fontchooserdialog) {

		super(_mainWindow, _title, _flag);

		mainWindow = _mainWindow;
		
		fontchooserdialog = _fontchooserdialog;
		label = new JLabel();

		textField = new JTextField();

		buttonhadpaid = new JButton();

		monitorMouse();
		monitorEnter();
		displayView();

	}

	@Override
	public void displayView() {
		this.setSize(400, 300);

		this.setLocationRelativeTo(null);

		this.setResizable(false);

		label.setText("please enter the password");

		label.setBounds(20, 100, 240, 30);

		buttonhadpaid.setBounds(145, 150, 90, 30);

		buttonhadpaid.setText("OK");

		textField.setBounds(250, 100, 100, 30);

		this.add(label);

		this.add(textField);

		this.add(buttonhadpaid);
		this.setLayout(null);

		this.setVisible(true);

	}

	public void monitorMouse() {
		buttonhadpaid.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

				if (textField.getText().equals("5")) {
					ProtectProxy.this.setVisible(false);

					//FontChooserDialog fd = new FontChooserDialog(mainWindow, "Font Selector", true);
					//fd.setVisible(true);
					fontchooserdialog.setVisible(true);


				} else {
					label.setText("Let me pass OO then you will know");
				}
			}
		});
	}

	public void monitorEnter() {
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {

				if (ke.getKeyCode() == KeyEvent.VK_ENTER) {

					if (textField.getText().equals("5")) {
						ProtectProxy.this.setVisible(false);

						//FontChooserDialog fd = new FontChooserDialog(mainWindow, "Font Selector", true);
						//fd.setVisible(true);
						fontchooserdialog.setVisible(true);


					} else {
						label.setText("Let me pass OO then you will know");
					}

				}
			}
		});

	}

}
