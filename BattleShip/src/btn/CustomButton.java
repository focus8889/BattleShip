package btn;

import javax.swing.JButton;

public class CustomButton extends JButton {
    private boolean busy;
    private int id = 0;
    private boolean used;
    public int row;

    public boolean getBusy() {
        return this.busy;
    }

    public boolean getUsed() {
        return this.used;
    }

    public boolean setUsed() {
        return this.used = true;
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
