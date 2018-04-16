package yuntech.oose.state_diagram_editor.singleton;

import yuntech.oose.state_diagram_editor.flyweight.FlyweightFactory;

import java.awt.*;

public class WordSingleton {
    private static WordSingleton wordSingleton = null;

    private String fontName;
    private int fontStyle;
    private int fontSize;
    private Color fontColor;
    private FlyweightFactory factory = FlyweightFactory.getFlyweightFactory();

    private WordSingleton() {

        fontName = Font.DIALOG;
        fontStyle = 0;
        fontSize = 13;
        fontColor = Color.BLACK;

    }


    public static WordSingleton getInstance() {

        if (wordSingleton == null) {

            wordSingleton = new WordSingleton();

        }
        return wordSingleton;
    }

    public String getFontName() {

        return fontName;

    }

    public void setFontName(String _fontName) {

        fontName = _fontName;
    }

    public int getFontStyle() {

        return fontStyle;

    }

    public void setFontStyle(int _fontStyle) {

        fontStyle = _fontStyle;

    }

    public int getFontSize() {

        return fontSize;

    }

    public void setFontSize(int _fontSize) {

        fontSize = _fontSize;
    }

    public Color getFontColor() {

        return fontColor;

    }

    public void setFontColor(int rgb) {

        fontColor = factory.getColorFlyweight(rgb);

    }
}
	
