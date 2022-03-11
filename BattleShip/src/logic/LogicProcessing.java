package logic;

import java.awt.Font;
import java.util.ArrayList;

import btn.CustomButton;
import graphics.Graphics;

public class LogicProcessing {
    Graphics graphics;
    ArrayList<Integer> enemy_coordinates = new ArrayList<Integer>();
    CustomButton enemy_btn[] = new CustomButton[101];
    public CustomButton my_btn[] = new CustomButton[101];

    // Buttons id.
    int id;

    // Initial coordinate and direction.
    static int initial_point_range = (100 + 0) + 1;
    static int direction_range = (3 + 0) + 1;

    // Generating Enemy Board.
    public void enemyBoardGenerate() {
        id = 1;
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

    // Generating Player board.
    public void myBoardGenerate() {
        id = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                CustomButton btn = new CustomButton();
                btn.setID(id);
                btn.setText(String.valueOf(btn.getId()));
                btn.setFont(new Font("Arial", Font.BOLD, 11));
                Graphics.my_board.add(btn);
                my_btn[btn.getId()] = btn;
                id++;

            }

        }
    }

    public int direction() {
        int direct = (int) (Math.random() * direction_range) + 0;
        System.out.println("Direction : " + direct);
        return direct;

    }

    public int initialPoint() {
        int initial_point = (int) (Math.random() * initial_point_range) + 1;
        System.out.println("Initial Point : " + initial_point);
        return initial_point;
    }

    public ArrayList<Integer> towardsTop(int initial_point, int length) {
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        int last_available_cell = (100 - (length * 10) + 10);
        while (true) {
            if (initial_point < last_available_cell) {
                while (true) {
                    int pos = initial_point + 10;
                    for (int i = 0; i < length - 1; i++) {
                        if (my_btn[pos].getBusy() == false) {
                            coordinates.add(pos);
                            my_btn[initial_point].setBusy();
                            my_btn[pos].setBusy();
                            pos += 10;
                            break;
                        }
                    }
                }
            } else {
                initial_point = initialPoint();
                coordinates.clear();
            }
            break;
        }
        System.out.println(coordinates);
        return coordinates;
    }
}
