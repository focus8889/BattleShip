package ActionControl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import graphics.Graphics;

public class ActionController implements ActionListener {
    Graphics g = new Graphics();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == g.enemy_board) {

        }

    }

}
