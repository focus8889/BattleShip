package btn;

import javax.swing.JButton;

public class CustomButton extends JButton {
    private boolean busy;
    private int id = 0;

    public boolean getBusy() {
        return this.busy;
    }

    public int getId() {
        return this.id;
    }

    public void increamentID() {
        this.id++;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setBusy() {
        this.busy = true;
    }
}
