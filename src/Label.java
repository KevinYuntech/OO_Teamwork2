public class Label extends Element{
    public String text;

    public Label(String string) {
        super();
        this.text = string;
    }

    public Label(Label label) {
        super(label);
        this.text = label.getText();
    }


    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    protected String getText() {
        return this.text;
    }
}
