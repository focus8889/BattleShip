package logic;

import java.awt.Font;
import java.util.ArrayList;

import btn.CustomButton;
import graphics.Graphics;
import player.Player;

public class LogicProcessing {
    Graphics graphics;
    ArrayList<Integer> enemy_coordinates = new ArrayList<Integer>();
    CustomButton enemy_btn[] = new CustomButton[101];
    public CustomButton my_btn[] = new CustomButton[101];

    // Buttons id.
    int id;
    //
    Player player = new Player();

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

    public ArrayList<Integer> towardsBottom(int initial_point, int length, boolean flag) {
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        int last_available_cell = (100 - (length * 10) + 10);
        while (true) {
            if (initial_point < last_available_cell) {
                while (flag) {
                    int pos = initial_point + 10;
                    coordinates.add(initial_point);
                    for (int i = 0; i < length - 1; i++) {
                        if (my_btn[pos].getBusy() == false) {
                            coordinates.add(pos);
                            my_btn[initial_point].setBusy();
                            my_btn[pos].setBusy();
                            pos += 10;
                            flag = false;
                        } else {
                            initial_point = initialPoint();
                            coordinates.clear();
                            break;
                        }
                    }

                }
                break;
            } else {
                initial_point = initialPoint();
                coordinates.clear();
            }

        }

        System.out.println(coordinates);
        return coordinates;
    }

    public ArrayList<Integer> towardsTop(int initial_point, int length, boolean flag) {
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        int last_available_cell = (100 - (100 - (length * 10)) - 9);
        while (true) {
            if (initial_point >= last_available_cell) {
                while (flag) {
                    int pos = initial_point - 10;
                    coordinates.add(initial_point);
                    for (int i = 0; i < length - 1; i++) {
                        if (my_btn[pos].getBusy() == false) {
                            coordinates.add(pos);
                            my_btn[initial_point].setBusy();
                            my_btn[pos].setBusy();
                            pos -= 10;
                            flag = false;
                        } else {
                            initial_point = initialPoint();
                            coordinates.clear();
                            break;
                        }
                    }

                }
                break;
            } else {
                initial_point = initialPoint();
                coordinates.clear();
            }
        }
        if (length == 5) {
            player.airCraftCarrier = coordinates;
        }

        System.out.println(coordinates);
        return coordinates;
    }

    public ArrayList<Integer> towardsRight(int initial_point, int length, boolean flag) {
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        String p = String.valueOf(initial_point);
        while (true) {
            if (p.length() == 2) {
                for (int i = 0; i < length - 1; i++) {
                    int pos = Integer.parseInt(p);
                    coordinates.add(pos);
                    pos++;
                    char c = String.valueOf(pos).charAt(1);
                    p = String.valueOf(pos);
                    if ((p.length() == 2) & (c != '1')) {
                        coordinates.add(Integer.parseInt(p));
                        continue;
                    }
                    if ((p.length() == 1) & (p.charAt(0) != 1)) {
                        coordinates.add(Integer.parseInt(p));
                        continue;
                    } else {
                        while (flag) {
                            i = 0;
                            p = String.valueOf(initialPoint());
                            coordinates.clear();
                            if (p.length() == 2) {

                            }
                            break;
                        }

                    }

                }
                break;
            } else {
                while (flag) {
                    p = String.valueOf(initialPoint());
                    coordinates.clear();
                    if (p.length() == 2) {

                    }
                    break;
                }
            }
        }
        System.out.println(coordinates);
        return coordinates;

    }

    public ArrayList<Integer> towardsLeft(int initial_point, int length, boolean flag) {
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        String p = String.valueOf(initial_point);
        while (true) {
            if (p.length() == 2) {
                for (int i = 0; i < length - 1; i++) {
                    int pos = Integer.parseInt(p);
                    pos--;
                    char c = String.valueOf(pos).charAt(0);
                    p = String.valueOf(pos);
                    if ((p.length() == 2) & (p.charAt(0) == c)) {
                        coordinates.add(Integer.parseInt(p));
                    } else {
                        while (flag) {
                            i = 0;
                            p = String.valueOf(initialPoint());
                            coordinates.clear();
                            if (p.length() == 2) {

                            }
                            break;
                        }
                    }
                }
                break;
            } else {
                while (flag) {
                    p = String.valueOf(initialPoint());
                    coordinates.clear();
                    if (p.length() == 2) {

                    }
                    break;
                }
            }
        }
        return coordinates;
    }

    public void placeShip(int initial_point, int length, int direction, boolean flag) {
        // 0 goes to top.
        if (direction == 0) {
            towardsTop(initial_point, length, flag);
        }
        if (direction == 1) {
            towardsBottom(initial_point, length, flag);
        }
        if (direction == 2) {
            towardsRight(initial_point, length, flag);
        } else {
            towardsLeft(initial_point, length, flag);
        }
    }
}