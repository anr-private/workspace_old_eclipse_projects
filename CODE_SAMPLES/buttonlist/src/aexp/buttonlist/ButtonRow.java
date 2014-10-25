package aexp.buttonlist;

public class ButtonRow {
    public int initValue;
    public String buttonText = null;

    public ButtonRow( int initValue, String buttonText ) {
        this.initValue = initValue;
        this.buttonText = buttonText;
    }

    public int getValue() {
        return initValue;
    }

    public int increaseValue() {
        int retVal = ++initValue;
        return retVal;
    }

    public String getButtonText() {
        return buttonText;
    }
}
