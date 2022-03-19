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
    // ArrayList<Integer> enemy_coordinates = new ArrayList<Integer>();
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
    public ArrayList<Integer> playerOccupied = new ArrayList<Integer>();
    // Health points of ships.
    public int patrol_boat_health = 2;
    public int submarine_health = 3;
    public int destroyer_health = 3;
    public int battleship_health = 4;
    public int airCraftCarrier_health = 5;

    // Radar quantity.
    public int radar = 4;

    // Total quantity of ships.
    public int playerTotalShips = 5;
    public int cpuTotalShips = 5;

    // Player score.
    public int score = 0;
    String score_dis = "Score: " + this.score;

    // CPU.// Coordinates of the ships.
    public ArrayList<Integer> en_patrolBoat = new ArrayList<Integer>(2);
    public ArrayList<Integer> en_submarine = new ArrayList<Integer>(3);
    public ArrayList<Integer> en_destroyer = new ArrayList<Integer>(3);
    public ArrayList<Integer> en_battleship = new ArrayList<Integer>(4);
    public ArrayList<Integer> en_airCraftCarrier = new ArrayList<Integer>(5);

    // Attacked coordinates
    public ArrayList<Integer> en_attacked = new ArrayList<Integer>();
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
                btn.setFocusPainted(false);
                btn.setID(id);
                btn.row = i;
                btn.setText(String.valueOf(btn.getId()));
                btn.setFont(new Font("Arial", Font.BOLD, 11));
                btn.setBackground(new Color(0, 191, 255));
                btn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        shootController(btn.getId(), true);
                        btn.setEnabled(false);
                        checkGameStatus();
                        // dropRadar(btn.getId());
                        System.out.println("This button's row is " + btn.row);
                        System.out.println("This button busy equal to " + btn.getBusy());
                        System.out.println(score);

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
                btn.setFocusPainted(false);
                btn.setBackground(new Color(0, 191, 255));
                btn.setID(id);
                btn.row = i;
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

    public ArrayList<Integer> down(int initial_point, int length, boolean flag, CustomButton[] cust_btn) {
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        System.out.println(initial_point + " of DOWN.");
        int pos;
        while (true) {
            try {
                if (cust_btn[initial_point].getBusy() == false) {
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
                    if (cust_btn[pos].getBusy() == false) {
                        coordinates.add(pos);
                        pos += 10;
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
                if (cust_btn[pos].getBusy() == false) {
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
        for (int index = 0; index < coordinates.size(); index++) {
            System.out.println(index);
            System.out.println(coordinates.get(index));
            cust_btn[coordinates.get(index)].setBackground(new Color(255, 86, 74));

        }
        for (int i = 0; i < coordinates.size(); i++) {
            cust_btn[coordinates.get(i)].setBusy();
            System.out.println(cust_btn[coordinates.get(i)].getBusy());
        }

        System.out.println("Further DOWN" + coordinates);
        return coordinates;
    }

    public ArrayList<Integer> top(int initial_point, int length, boolean flag, CustomButton[] cust_btn) {
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        System.out.println(initial_point + " of UP.");
        int pos;
        while (true) {
            try {
                if (cust_btn[initial_point].getBusy() == false) {
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
                    if (cust_btn[pos].getBusy() == false) {
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
                if (cust_btn[pos].getBusy() == false) {
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
            cust_btn[coordinates.get(i)].setBusy();
        }
        for (int index = 0; index < coordinates.size(); index++) {
            cust_btn[coordinates.get(index)].setBackground(new Color(250, 252, 96));
        }
        System.out.println("Further down " + coordinates);
        return coordinates;
    }

    public ArrayList<Integer> right(int initial_point, int length, boolean flag, CustomButton[] cust_btn) {
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        int pos = initial_point;
        int row;
        while (true) {
            try {
                row = cust_btn[pos].row;
                if (cust_btn[pos].getBusy() == false) {
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
                if ((pos > length) & (cust_btn[initial_point].getBusy() == false)) {
                    coordinates.add(pos);
                    for (int i = 0; i < length - 1; i++) {
                        pos++;
                        if ((cust_btn[pos].row == row) & (cust_btn[pos].getBusy() == false)) {
                            coordinates.add(pos);
                            continue;
                        } else {
                            // It gets index of I to -1, which lets to restart for loop.
                            if (i == 0) {
                                i--;
                                coordinates.clear();
                                pos = initialPoint();
                                row = cust_btn[pos].row;
                                coordinates.add(pos);
                            } else {
                                i -= i + 1;
                                coordinates.clear();
                                pos = initialPoint();
                                row = cust_btn[pos].row;
                                coordinates.add(pos);
                            }
                        }
                    }
                    break;
                } else {
                    coordinates.clear();
                    initial_point = initialPoint();
                    pos = initial_point;
                    row = cust_btn[pos].row;
                    continue;
                }
            } catch (Exception e) {
                coordinates.clear();
                pos = initialPoint();
                row = cust_btn[pos].row;
                continue;
            }
        }
        // Setting cell to busy.
        for (int i = 0; i < coordinates.size(); i++) {
            cust_btn[coordinates.get(i)].setBusy();

        }
        for (int index = 0; index < coordinates.size(); index++) {
            cust_btn[coordinates.get(index)].setBackground(new Color(119, 247, 204));
        }
        System.out.println("This is right coordinates: " + coordinates);
        return coordinates;
    }

    public ArrayList<Integer> left(int initial_point, int length, boolean flag, CustomButton[] cust_btn) {
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        int pos = initial_point;
        int row;
        System.out.println(coordinates);
        while (true) {
            try {
                row = cust_btn[pos].row;
                System.out.println(cust_btn[pos].getBusy() + "ZZZZZZZZZZZZZZZ");
                if (cust_btn[pos].getBusy() == false) {
                    System.out.println(cust_btn[pos].getBusy());
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
                if ((pos > length) & (cust_btn[initial_point].getBusy() == false)) {
                    coordinates.add(pos);
                    for (int i = 0; i < length - 1; i++) {
                        pos--;
                        if ((cust_btn[pos].row == row) & (cust_btn[pos].getBusy() == false)) {
                            coordinates.add(pos);
                            continue;
                        } else {
                            if (i == 0) {
                                i--;
                                coordinates.clear();
                                pos = initialPoint();
                                row = cust_btn[pos].row;
                                coordinates.add(pos);
                            } else {
                                i -= i + 1;
                                coordinates.clear();
                                pos = initialPoint();
                                row = cust_btn[pos].row;
                                coordinates.add(pos);
                            }
                        }
                    }
                    break;
                } else {
                    coordinates.clear();
                    initial_point = initialPoint();
                    pos = initial_point;
                    row = cust_btn[pos].row;
                    continue;
                }
            } catch (Exception e) {
                coordinates.clear();
                pos = initialPoint();
                row = cust_btn[pos].row;
                continue;
            }
        }
        for (int i = 0; i < coordinates.size(); i++) {
            cust_btn[coordinates.get(i)].setBusy();
        }
        for (int index = 0; index < coordinates.size(); index++) {
            cust_btn[coordinates.get(index)].setBackground(new Color(130, 143, 255));
        }
        System.out.println("This is right left: " + coordinates);
        return coordinates;

    }

    public ArrayList<Integer> placeShip(int initial_point, int length, int direction,
            boolean flag,
            CustomButton[] cust_btn) {
        // 0 goes to top.
        if (direction == 0) {
            return top(initial_point, length, flag, cust_btn);
        }
        if (direction == 1) {
            return down(initial_point, length, flag, cust_btn);
        }
        if (direction == 2) {
            return right(initial_point, length, flag, cust_btn);
        }
        if (direction == 3) {
            return left(initial_point, length, flag, cust_btn);
        }
        return null;
    }

    public void dropRadar(int clickedButton) {
        ArrayList<Integer> radarArea = new ArrayList<Integer>();
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        radarArea.add(11);
        radarArea.add(10);
        radarArea.add(9);
        radarArea.add(1);
        String cont = String.valueOf(clickedButton);
        int per = clickedButton;
        if (clickedButton < 90) {
            try {
                if (this.radar > 0) {
                    if ((cont.length() == 2) & (cont.charAt(1) != '0') & (cont.charAt(1) != '1')) {
                        coordinates.add(clickedButton);
                        for (int i = 0; i < radarArea.size(); i++) {
                            try {
                                clickedButton += radarArea.get(i);
                                coordinates.add(clickedButton);
                                clickedButton = per;
                            } catch (Exception e) {
                            }
                        }
                        for (int i = 0; i < radarArea.size(); i++) {
                            try {
                                clickedButton -= radarArea.get(i);
                                coordinates.add(clickedButton);
                                clickedButton = per;
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            } catch (Exception e) {

            }
            for (int i = 0; i < coordinates.size(); i++) {
                if (this.enemyOccupied.contains(coordinates.get(i))) {
                    this.enemy_btn[coordinates.get(i)].setBackground(Color.red);
                } else {
                    this.enemy_btn[coordinates.get(i)].setBackground(Color.green);
                }
            }

            System.out.println(coordinates);
        }

    }

    public void shoot(int coordinate) {
        if (this.enemyOccupied.contains(coordinate)) {
            this.enemy_btn[coordinate].setText("H");
            checkEnemyArrays(coordinate);
        } else {
            this.enemy_btn[coordinate].setText("M");
            this.score--;

        }
        score_dis = "Score: " + this.score;
        this.graphics.l_score.setText(score_dis);
    }

    public void cpuMove() {
        while (true) {
            try {
                int shoot = initialPoint();
                if (!this.en_attacked.contains(shoot)) {
                    if (this.playerOccupied.contains(shoot)) {
                        this.my_btn[shoot].setText("H");
                        checkMyArrays(shoot);
                        this.en_attacked.add(shoot);
                        break;
                    } else {
                        this.my_btn[shoot].setText("M");
                        this.en_attacked.add(shoot);
                        break;
                    }
                }
            } catch (Exception e) {
                continue;
            }

        }
    }

    public void shootController(int cell, boolean flag) {
        if ((flag == true) & (this.graphics.b_radar.isSelected()) & (this.radar != 0)) {
            dropRadar(cell);
            this.radar--;
        }
        if (flag == true) {
            shoot(this.enemy_btn[cell].getId());
            flag = false;
        }
        if (flag == false) {
            cpuMove();
            flag = true;
        }
        System.out.println(this.graphics.b_radar.isSelected());
    }

    public void checkEnemyArrays(int coordinate) {

        if (this.en_airCraftCarrier.contains(coordinate)) {
            this.en_airCraftCarrier_health--;
            this.score++;
            System.out.println(this.en_airCraftCarrier_health + " current health!");
            if (this.en_airCraftCarrier_health == 0) {
                this.cpuTotalShips--;
                System.out.println("Total cpu ships " + this.cpuTotalShips);
                this.score += 10;
            }

        }
        if (this.en_battleship.contains(coordinate)) {
            this.en_battleship_health--;
            this.score++;
            System.out.println(this.en_battleship_health + " current health!");
            if (this.en_battleship_health == 0) {
                this.cpuTotalShips--;
                System.out.println("Total cpu ships " + this.cpuTotalShips);
                this.score += 8;
            }
        }
        if (this.en_destroyer.contains(coordinate)) {
            this.en_destroyer_health--;
            this.score++;
            System.out.println(this.en_destroyer_health + " current health!");
            if (this.en_destroyer_health == 0) {
                this.cpuTotalShips--;
                this.score += 6;
                System.out.println("Total cpu ships " + this.cpuTotalShips);
            }
        }
        if (this.en_submarine.contains(coordinate)) {
            this.en_submarine_health--;
            this.score++;
            System.out.println(this.en_patrol_boat_health + " current health!");
            if (this.en_submarine_health == 0) {
                this.cpuTotalShips--;
                this.score += 6;
                System.out.println("Total cpu ships " + this.cpuTotalShips);
            }
        }
        if (this.en_patrolBoat.contains(coordinate)) {
            this.en_patrol_boat_health--;
            this.score++;
            System.out.println(this.en_patrol_boat_health + " current health!");
            if (this.en_patrol_boat_health == 0) {
                this.cpuTotalShips--;
                this.score += 4;
                System.out.println("Total cpu ships " + this.cpuTotalShips);
            }
        }
        score_dis = "Score: " + this.score;
        this.graphics.l_score.setText(score_dis);
    }

    public void checkMyArrays(int coordinate) {
        if (this.airCraftCarrier.contains(coordinate)) {
            this.airCraftCarrier_health--;
            this.score--;
            System.out.println(this.airCraftCarrier_health + " current health!");
            if (this.airCraftCarrier_health == 0) {
                this.playerTotalShips--;
            }
        }
        if (this.battleship.contains(coordinate)) {
            this.battleship_health--;
            this.score--;
            System.out.println(this.battleship_health + " current health!");
            if (this.battleship_health == 0) {
                this.playerTotalShips--;
            }
        }
        if (this.destroyer.contains(coordinate)) {
            this.destroyer_health--;
            this.score--;
            System.out.println(this.destroyer_health + " current health!");
            if (this.destroyer_health == 0) {
                this.playerTotalShips--;
            }
        }
        if (this.submarine.contains(coordinate)) {
            this.submarine_health--;
            this.score--;
            System.out.println(this.submarine_health + " current health!");
            if (this.submarine_health == 0) {
                this.playerTotalShips--;
            }
        }
        if (this.patrolBoat.contains(coordinate)) {
            this.patrol_boat_health--;
            this.score--;
            System.out.println(this.patrol_boat_health + " current health!");
            if (this.patrol_boat_health == 0) {
                this.playerTotalShips--;
            }
        }
        score_dis = "Score: " + this.score;
        this.graphics.l_score.setText(score_dis);
    }

    public void iterate(ArrayList<Integer> array, ArrayList<Integer> coordinates) {
        for (int i = 0; i < array.size(); i++) {
            coordinates.add(array.get(i));
        }
    }

    public void checkGameStatus() {
        if (this.cpuTotalShips == 0) {
            this.graphics.winnerPanel();
            System.out.println("Player won!");
        }
        if (this.playerTotalShips == 0) {
            this.graphics.winnerPanel();
            System.out.println("CPU won!");
        }
    }
}
