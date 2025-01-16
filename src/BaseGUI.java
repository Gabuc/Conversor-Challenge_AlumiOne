// BaseGUI.java
public abstract class BaseGUI {
    protected abstract void createAndShowGUI();

    public void show() {
        createAndShowGUI();
    }
}
