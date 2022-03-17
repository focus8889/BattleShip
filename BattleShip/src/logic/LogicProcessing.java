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
    public CustomButton enemy_btn[] = new CustomButton[101];
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
    public ArrayList<Integer> patrot;

    // Initial coordinate and direction.
    static int initial_point_range = (99 + 0) + 1;
    static int direction_range = (3 + 0) + 1;

    public LogicProcessing(Graphics parent) {
        this.graphics = parent;
    }

    // Generating Enemy Board.
    public void enemyBoardGenerate() {
        System.out.println("Created");
        id = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                CustomButton btn = new CustomButton();
                btn.setID(id);
                btn.row = i;
                btn.setText(String.valueOf(btn.getId()));
                btn.setVisible(true);
                btn.setFont(new Font("Arial", Font.BOLD, 11));
                btn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dropRadar(btn.getId());
                        System.out.println("This button's row is " + btn.row);
                        System.out.println("This button busy equal to " + btn.getBusy());
                    }
                });
                this.graphics.enemy_board.add(btn);
                this.enemy_btn[btn.getId()] = btn;
                id++;
            }

        }
        System.out.println("Done");
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
                this.graphics.my_board.add(btn);
                this.my_btn[btn.getId()] = btn;
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

    public ArrayList<Integer> down(int initial_point, int length, boolean flag) {
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        System.out.println(initial_point + " of DOWN.");
        int pos;
        while (true) {
            try {
                if (this.enemy_btn[initial_point].getBusy() == false) {
                    break;
                } else {
                    initial_point = initialPoint();
                }
            } catch (Exception e) {
                initial_point = initialPoint();
                continue;
            }

        }
        while (true) {
            try {
                pos = initial_point; // 50
                for (int i = 0; i < length - 1; i++) {
                    if (this.enemy_btn[pos].getBusy() == false) { // 1 -- false, 2 -- false,
                        coordinates.add(pos); // [50, 60]
                        pos += 10;// 60, 70
                        System.out.println(pos);
                    } else {

                        // It gets index of I to -1, which lets to restart for loop.
                        if (i == 0) {
                            i--;
                            coordinates.clear();
                            pos = initialPoint();
                        } else {
                            i -= i + 1;
                            coordinates.clear();
                            pos = initialPoint();
                        }
                    }
                }
                // I need to validate last iteration of for loop!
                if (this.enemy_btn[pos].getBusy() == false) {
                    System.out.println(pos + "sd");
                    break;
                }

                else {
                    initial_point = initialPoint();
                    coordinates.clear();

                }
            } catch (Exception e) {
                coordinates.clear();
                initial_point = initialPoint();
                continue;

            }
        }
        coordinates.add(pos);
        for (

                int index = 0; index < coordinates.size(); index++) {
            System.out.println(index);
            System.out.println(coordinates.get(index));
            this.enemy_btn[coordinates.get(index)].setBackground(new Color(255, 86, 74));

        }
        for (int i = 0; i < coordinates.size(); i++) {
            enemy_btn[coordinates.get(i)].setBusy();
        }

        System.out.println("Further DOWN" + coordinates);
        return coordinates;
    }

    public ArrayList<Integer> top(int initial_point, int length, boolean flag) {
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        System.out.println(initial_point + " of UP.");
        int pos;
        while (true) {
            try {
                if (this.enemy_btn[initial_point].getBusy() == false) {
                    break;
                } else {
                    initial_point = initialPoint();
                }
            } catch (Exception e) {
                initial_point = initialPoint();
                continue;
            }

        }

        while (true) {
            try {
                pos = initial_point;
                for (int i = 0; i < length - 1; i++) {
                    if (this.enemy_btn[pos].getBusy() == false) {
                        coordinates.add(pos);
                        pos -= 10;
                    } else {
                        // It gets index of I to -1, which lets to restart for loop.
                        if (i == 0) {
                            i--;
                            coordinates.clear();
                            pos = initialPoint();
                        } else {
                            i -= i + 1;
                            coordinates.clear();
                            pos = initialPoint();
                        }
                    }
                }
                if (this.enemy_btn[pos].getBusy() == false) {
                    break;
                }

                else {
                    initial_point = initialPoint();
                    coordinates.clear();
                }

                break;
            } catch (Exception e) {
                coordinates.clear();
                initial_point = initialPoint();
                continue;

            }
        }
        coordinates.add(pos);
        for (int i = 0; i < coordinates.size(); i++) {
            enemy_btn[coordinates.get(i)].setBusy();
        }
        for (int index = 0; index < coordinates.size(); index++) {
            this.enemy_btn[coordinates.get(index)].setBackground(new Color(250, 252, 96));
        }
        System.out.println("Further down " + coordinates);
        return coordinates;
    }

    public ArrayList<Integer> right(int initial_point, int length, boolean flag) {
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        int pos = initial_point;
        int row;
        while (true) {
            try {
                row = this.enemy_btn[pos].row;
                if (this.enemy_btn[pos].getBusy() == false) {
                    break;
                } else {
                    pos = initialPoint();
                }
            } catch (Exception e) {
                pos = initialPoint();
            }
        }
        while (true) {
            // Checking if initital point of cell is not to small.
            // In order to prevent errors.
            try {
                if ((pos > length) & (this.enemy_btn[initial_point].getBusy() == false)) {
                    coordinates.add(pos);
                    for (int i = 0; i < length - 1; i++) {
                        pos++;
                        if ((this.enemy_btn[pos].row == row) & (this.enemy_btn[pos].getBusy() == false)) {
                            coordinates.add(pos);
                            continue;
                        } else {
                            // It gets index of I to -1, which lets to restart for loop.
                            if (i == 0) {
                                i--;
                                coordinates.clear();
                                pos = initialPoint();
                                row = this.enemy_btn[pos].row;
                                coordinates.add(pos);
                            } else {
                                i -= i + 1;
                                coordinates.clear();
                                pos = initialPoint();
                                row = this.enemy_btn[pos].row;
                                coordinates.add(pos);
                            }
                        }
                    }
                    break;
                } else {
                    coordinates.clear();
                    initial_point = initialPoint();
                    pos = initial_point;
                    row = this.enemy_btn[pos].row;
                    continue;
                }
            } catch (Exception e) {
                coordinates.clear();
                pos = initialPoint();
                row = this.enemy_btn[pos].row;
                continue;
            }
        }
        // Setting cell to busy.
        for (int i = 0; i < coordinates.size(); i++) {
            enemy_btn[coordinates.get(i)].setBusy();

        }
        for (int index = 0; index < coordinates.size(); index++) {
            this.enemy_btn[coordinates.get(index)].setBackground(new Color(119, 247, 204));
        }
        System.out.println("This is right coordinates: " + coordinates);
        return coordinates;
    }

    public ArrayList<Integer> left(int initial_point, int length, boolean flag) {
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        int pos = initial_point;
        int row;
        while (true) {
            try {
                // Checking if the button is not of index boundries.
                row = this.enemy_btn[pos].row;
                break;
            } catch (Exception e) {
                pos = initialPoint();
            }
        }
        while (true) {
            // Checking if initital point of cell is not to small.
            // In order to prevent errors.
            try {
                if ((pos > length) & (this.enemy_btn[initial_point].getBusy() == false)) {
                    coordinates.add(pos);
                    for (int i = 0; i < length - 1; i++) {
                        pos--;
                        if ((this.enemy_btn[pos].row == row) & (this.enemy_btn[pos].getBusy() == false)) {
                            coordinates.add(pos);
                            continue;
                        } else {
                            if (i == 0) {
                                i--;
                                coordinates.clear();
                                pos = initialPoint();
                                row = this.enemy_btn[pos].row;
                                coordinates.add(pos);
                            } else {
                                i -= i + 1;
                                coordinates.clear();
                                pos = initialPoint();
                                row = this.enemy_btn[pos].row;
                                coordinates.add(pos);
                            }
                        }
                    }
                    break;
                } else {
                    ////
                    //// CHECK CHECK CHECK
                    //// IF ANY ERROR!

                    coordinates.clear();
                    initial_point = initialPoint();
                    pos = initial_point;
                    row = this.enemy_btn[pos].row;
                    continue;
                }
            } catch (Exception e) {
                coordinates.clear();
                pos = initialPoint();
                row = this.enemy_btn[pos].row;
                continue;
            }
        }
        for (int i = 0; i < coordinates.size(); i++) {
            enemy_btn[coordinates.get(i)].setBusy();
        }
        for (int index = 0; index < coordinates.size(); index++) {
            this.enemy_btn[coordinates.get(index)].setBackground(new Color(130, 143, 255));
        }
        System.out.println("This is right left: " + coordinates);
        return coordinates;

    }

    public void placeShip(int initial_point, int length, int direction, ArrayList<Integer> coordinates, boolean flag) {
        // 0 goes to top.
        if (direction == 0) {
            top(initial_point, length, flag);
        }
        if (direction == 1) {
            down(initial_point, length, flag);
        }
        if (direction == 2) {
            right(initial_point, length, flag);
        }
        if (direction == 3) {
            left(initial_point, length, flag);
        }
    }

    public void dropRadar(int clickedButton) {
        ArrayList<Integer> radarArea = new ArrayList<Integer>();
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        radarArea.add(11);
        radarArea.add(10);
        radarArea.add(9);
        radarArea.add(1);
        int per = clickedButton;
        while (true) {
            for (int i = 0; i < radarArea.size(); i++) {
                try {
                    clickedButton -= radarArea.get(i);
                    coordinates.add(clickedButton);
                    this.enemy_btn[clickedButton].setBackground(Color.RED);
                    clickedButton = per;
                } catch (Exception e) {
                    continue;
                }
            }
            for (int i = 0; i < radarArea.size(); i++) {
                try {
                    clickedButton += radarArea.get(i);
                    coordinates.add(clickedButton);
                    this.enemy_btn[clickedButton].setBackground(Color.RED);
                    clickedButton = per;
                } catch (Exception e) {
                    continue;
                }
            }
            break;
        }
    }

    private void shoot(int coordinate) {
        this.enemyOccupied.add(1);
        for (int i = 0; i < this.enemyOccupied.size(); i++) {
            if (coordinate == this.enemyOccupied.get(i)) {
                this.enemy_btn[this.enemyOccupied.get(i)].setText("H");
            }
        }
    }

    private void check(int cell) {
        if (graphics.b_radar.isSelected()) {
            dropRadar(cell);
        } else {
            shoot(cell);
        }
    }

    public void cpuMove(boolean flag) {
        if (flag == true) {
            while (true) {
                int shoot = initialPoint();
                if (!this.enemyOccupied.contains(shoot)) {
                    this.my_btn[shoot].setBackground(Color.red);
                    break;
                } else {
                    continue;
                }
            }
        }
    }
}
