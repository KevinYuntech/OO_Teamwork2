package yuntech.oose.state_diagram_editor.mediator;

import yuntech.oose.state_diagram_editor.chain_help.Helpable;
import yuntech.oose.state_diagram_editor.chain_help.Helper;
import yuntech.oose.state_diagram_editor.field.MainWindow;
import yuntech.oose.state_diagram_editor.field.ToolTray;
import yuntech.oose.state_diagram_editor.proxy.Protectable;
import yuntech.oose.state_diagram_editor.singleton.WordSingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FontChooserDialog extends JDialog implements Protectable, Helpable {

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

    private Helper helper;

    public FontChooserDialog(MainWindow _mainWindow, String _title, Boolean _flag) {
        super(_mainWindow, _title, _flag);

        mainWindow = _mainWindow;
        helper = new Helper(this, getClass().getSimpleName(), mainWindow.getHelper());

        setting();

        staticInitalize();

        buildComponents();

        monitorEvent();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
                    JPopupMenu popupMenu = new JPopupMenu();
                    JMenuItem menuItem = new JMenuItem("Helper");
                    popupMenu.add(menuItem).addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            helper.help();
                        }
                    });
                    popupMenu.show(FontChooserDialog.this, mouseEvent.getX(), mouseEvent.getY());
                }
            }
        });
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

    @Override
    public Helper getHelper() {
        return null;
    }
}

