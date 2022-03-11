package logic;

import java.awt.Font;
import java.util.ArrayList;

import btn.CustomButton;
import graphics.Graphics;

public class LogicProcessing {
    Graphics graphics;
    ArrayList<Integer> enemy_coordinates = new ArrayList<Integer>();
    CustomButton enemy_btn[] = new CustomButton[101];
    int id = 1;

    public void enemyBoardGenerate() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                CustomButton btn = new CustomButton();
                btn.setID(id);
                btn.setText(String.valueOf(btn.getId()));
                btn.setFont(new Font("Arial", Font.BOLD, 11));
                Graphics.enemy_board.add(btn);
                enemy_btn[btn.getId()] = btn;
                id++;

            }

        }
    }
}
