package ActionControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import graphics.Graphics;
import logic.LogicProcessing;

public class ActionController implements ActionListener {
    Graphics g = new Graphics();
    LogicProcessing logic = new LogicProcessing();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Graphics.b_exit) {
            System.exit(0);
            System.out.println("Pressed!");
        }
        if (e.getSource() == Graphics.b_play) {
            Graphics.gameStart();
        }

    }

}
