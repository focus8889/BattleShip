package logic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import btn.CustomButton;
import graphics.Graphics;

public class LogicProcessing {
    Graphics graphics;
    ArrayList<Integer> enemy_coordinates = new ArrayList<Integer>();
    public static CustomButton enemy_btn[] = new CustomButton[101];
    public CustomButton my_btn[] = new CustomButton[101];

    // Buttons id.
    int id;

    /// Player and CPU fields.
    // Coordinates of the ships.
    public ArrayList<Integer> patrolBoat = new ArrayList<Integer>(2);
    public ArrayList<Integer> submarine = new ArrayList<Integer>(3);
    public ArrayList<Integer> destroyer = new ArrayList<Integer>(3);
    public ArrayList<Integer> battleship = new ArrayList<Integer>(4);
    public ArrayList<Integer> airCraftCarrier = new ArrayList<Integer>(5);

    // Enemy occupied coordinates.
    public ArrayList<Integer> enemyOccupied = new ArrayList<Integer>();
    // Health points of ships.
    public int patrol_boat_health = 2;
    public int submarine_health = 3;
    public int destroyer_health = 3;
    public int battleship_health = 4;
    public int airCraftCarrier_health = 5;

    // Radar quantity.
    public int radar = 4;

    // CPU.// Coordinates of the ships.
    ArrayList<Integer> en_patrolBoat = new ArrayList<Integer>(2);
    ArrayList<Integer> en_submarine = new ArrayList<Integer>(3);
    ArrayList<Integer> en_destroyer = new ArrayList<Integer>(3);
    ArrayList<Integer> en_battleship = new ArrayList<Integer>(4);
    ArrayList<Integer> en_airCraftCarrier = new ArrayList<Integer>(5);
    // Health points of ships.
    int en_patrol_boat_health = 2;
    int en_submarine_health = 3;
    int en_destroyer_health = 3;
    int en_battleship_health = 4;
    int en_airCraftCarrier_health = 5;

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
                btn.row = i;
                btn.setText(String.valueOf(btn.getId()));
                btn.setFont(new Font("Arial", Font.BOLD, 11));
                btn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        check(btn.getId());
                        dropRadar(btn.getId());
                        System.out.println("This button's row is " + btn.row);
                    }
                });
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

    public ArrayList<Integer> right(int initial_point, int length, boolean flag) {
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        int row = enemy_btn[initial_point].row;
        int pos = initial_point;
        coordinates.add(pos);
        while (true) {
            for (int i = 0; i < length - 1; i++) {
                pos++;
                coordinates.add(pos);
                if (enemy_btn[pos].row == row) {
                    continue;

                } else {
                    coordinates.clear();
                    pos = initialPoint();
                    row = enemy_btn[pos].row;
                    i = 0;
                    coordinates.add(pos);
                }

            }
            break;
        }
        System.out.println("This is right coordinates: " + coordinates);
        return coordinates;
    }

    public ArrayList<Integer> left(int initial_point, int length, boolean flag) {
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        int row = enemy_btn[initial_point].row;
        int pos = initial_point;
        coordinates.add(pos);
        // Ask How to fix if button does not exist??
        // How to connect Player and CPU ships inorder to interact with the??
        while (true) {
            // Checking if initital point of cell is not to small.
            // In order to prevent errors.
            if (pos > length) {
                for (int i = 0; i < length - 1; i++) {
                    pos--;
                    coordinates.add(pos);
                    if ((enemy_btn[pos].row == row) & (pos >= length)) {
                        continue;

                    } else {
                        coordinates.clear();
                        pos = initialPoint();
                        row = enemy_btn[pos].row;
                        i = 0;
                        coordinates.add(pos);
                    }
                }
                break;
            } else {
                coordinates.clear();
                pos = initialPoint();
                row = enemy_btn[pos].row;
            }

        }
        System.out.println("This is left coordinates: " + coordinates);
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

    public void dropRadar(int clickedButton) {
        try {
            ArrayList<Integer> radarArea = new ArrayList<Integer>();
            radarArea.add(11);
            radarArea.add(10);
            radarArea.add(9);
            radarArea.add(1);

            int per = clickedButton;
            String button = String.valueOf(clickedButton);
            if ((button.length() == 2) & (Graphics.b_radar.isSelected() == true) & radar != 0) {
                String secondChar = String.valueOf(button.charAt(1));
                if (Integer.parseInt(secondChar) >= 2) {
                    for (int i = 0; i < radarArea.size(); i++) {
                        clickedButton -= radarArea.get(i);
                        enemy_btn[clickedButton].setBackground(Color.red);
                        clickedButton = per;
                    }
                }
            }
            if (Graphics.b_radar.isSelected()) {
                System.out.println(clickedButton + "++");
            }
            for (int i = radarArea.size() - 1; i >= 0; i--) {
                System.out.println(i);
                clickedButton += radarArea.get(i);
                enemy_btn[clickedButton].setBackground(Color.red);
                clickedButton = per;
            }

            for (int i = 0; i < radarArea.size(); i++) {
                clickedButton -= radarArea.get(i);
                enemy_btn[clickedButton].setBackground(Color.red);
                clickedButton = per;
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    private void shoot(int coordinate) {
        enemyOccupied.add(1);
        for (int i = 0; i < enemyOccupied.size(); i++) {
            if (coordinate == enemyOccupied.get(i)) {
                enemy_btn[enemyOccupied.get(i)].setText("H");
            }
        }
    }

    private void check(int cell) {
        if (Graphics.b_radar.isSelected()) {
            dropRadar(cell);
        } else {
            shoot(cell);
        }
    }
}
