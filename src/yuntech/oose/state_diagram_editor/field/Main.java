package yuntech.oose.state_diagram_editor.field;

public class Main {

	public static void main(String[] args) {
		
		MainWindow mainWindow = new MainWindow();
		
		Loadable mainWindowProxy = new MainWindowProxy();
		
		mainWindowProxy.load();

	}

}
