package yuntech.oose.state_diagram_editor.mediator;

import yuntech.oose.state_diagram_editor.field.MainWindow;
import yuntech.oose.state_diagram_editor.proxy.protectable;
import yuntech.oose.state_diagram_editor.singleton.WordSingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FontChooserDialog extends JDialog implements protectable{

   // private static final long serialVersionUID = 1L;    
    private static WordSingleton wordSingleton; 
    private MainWindow mainWindow;
    private FontList fontList;
    private FontScrollPane fontScrollPane;
    private StyleList styleList;    
    private StyleScrollPane styleScrollPane;    
    private SizeList sizeList;    
    private SizeScrollPane sizeScrollPane;    
    private ColorList colorList;    
    private ColorScrollPane colorScrollPane;    
    private OkButton okButton;
    private CancelButton cancelButton;
    private PreviewLabel previewLabel;
    private Color[] colorName = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};

    public FontChooserDialog(MainWindow _mainWindow, String _title, Boolean _flag) {
        super(_mainWindow, _title, _flag);

        mainWindow = _mainWindow;

        setting();

        staticInitalize();

        buildComponents();

        monitorEvent();
    }

    private static void staticInitalize() {

        wordSingleton = WordSingleton.getInstance();
    }

    public void setting() {

        this.setLayout(null);

        this.setSize(600, 300);

        this.setLocationRelativeTo(null);

        this.setResizable(false);
    }

    public void buildComponents() {
        String[] fontString = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        fontList = new FontList(fontString, this);

        fontScrollPane = new FontScrollPane(fontList);

        this.add(fontScrollPane);


        String[] styleString = {"PLAIN", "BOLD", "ITALIC", "BOLD & ITALIC"};

        styleList = new StyleList(styleString, this);

        styleScrollPane = new StyleScrollPane(styleList);

        this.add(styleScrollPane);


        String[] sizeString = {"10", "12", "14", "16", "18", "20"};

        sizeList = new SizeList(sizeString, this);

        sizeScrollPane = new SizeScrollPane(sizeList);

        this.add(sizeScrollPane);


        String[] colorString = {"BLACK", "BLUE", "CYAN", "DARK_GRAY", "GRAY", "GREEN", "LIGHT_GRAY", "MAGENTA", "ORANGE", "PINK", "RED", "WHITE", "YELLOW"};

        colorList = new ColorList(colorString, this);

        colorScrollPane = new ColorScrollPane(colorList);

        this.add(colorScrollPane);

        okButton = new OkButton("OK", this);

        this.add(okButton);

        cancelButton = new CancelButton("CANCEL", this);

        this.add(cancelButton);

        previewLabel = new PreviewLabel("OO Can Not Stop My Step!", SwingConstants.CENTER, wordSingleton.getFontName(), wordSingleton.getFontStyle(), wordSingleton.getFontSize(), wordSingleton.getFontColor());

        this.add(previewLabel);
    }

    public void monitorEvent() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                FontChooserDialog.this.setVisible(false);
            }
        });
    }

    public void setPreviewLabelFont(String _font) {
        previewLabel.setFont(new Font(_font, wordSingleton.getFontStyle(), wordSingleton.getFontSize()));
    }

    public void setPreviewLabelStyle(int _style) {
        previewLabel.setFont(new Font(wordSingleton.getFontName(), _style, wordSingleton.getFontSize()));

    }

    public void setPreviewLabelSize(int _size) {
        previewLabel.setFont(new Font(wordSingleton.getFontName(), wordSingleton.getFontStyle(), _size));

    }

    public void setPreviewLabelColor(int _colorIndex) {

        previewLabel.setForeground(colorName[_colorIndex]);

    }

    public void okButtonClicked() {
    	

        this.setVisible(false);

        wordSingleton.setFontName(previewLabel.getFont().getFontName());
        wordSingleton.setFontStyle(previewLabel.getFont().getStyle());
        wordSingleton.setFontSize(previewLabel.getFont().getSize());
        wordSingleton.setFontColor(previewLabel.getForeground().getRGB());
        mainWindow.repaintCanvas();
        mainWindow.takeSnapshot();
    }

    public void cancelButtonClicked() {

        this.setVisible(false);

    }

	@Override
	public void displayView() {
		// TODO 自動產生的方法 Stub
		setVisible(true);
	}
}

