package graphics;

import java.awt.Color;
import java.awt.Font;
// import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

// import ActionControl.ActionController;`
import logic.LogicProcessing;

public class Graphics {
        public Graphics() {
                frameStart();
        }

        // Main Frame.
        public JFrame frame = new JFrame();
        LogicProcessing logic;

        // Panels of the game
        public JPanel enemy_board = new JPanel();
        public JPanel my_board = new JPanel();
        public JPanel winner = new JPanel();
        public JPanel game_panel = new JPanel();
        public JPanel main_panel = new JPanel();

        // Background Image.
        ImageIcon img = new ImageIcon("./img/batt.jpg");
        JLabel background = new JLabel(img, JLabel.CENTER);

        // Booleans
        boolean flag, turn;

        // Labels.
        public JLabel l_nickname = new JLabel();
        public JLabel l_title = new JLabel("The BattleShip");
        public JLabel l_score = new JLabel("Score");
        public JLabel l_ships = new JLabel("");
        public JLabel l_radars = new JLabel("4");
        public JLabel l_hit = new JLabel("H");
        public JLabel l_miss = new JLabel("M");
        public JLabel l_alive = new JLabel("Ships Status:");
        public JLabel l_air = new JLabel("AirCraft Carrier");
        public JLabel l_bat = new JLabel("BattleShip");
        public JLabel l_sub = new JLabel("Submarine");
        public JLabel l_des = new JLabel("Destroyer");
        public JLabel l_pat = new JLabel("Patrol Boat");
        public JLabel l_myBoard = new JLabel("My Board");
        public JLabel l_enemyBoard = new JLabel("Enemy Board");

        // Game buttons.
        public JButton b_about = new JButton("About");
        public JButton b_play = new JButton("Play");
        public JButton b_exit = new JButton("Exit");
        public JButton b_quit = new JButton("Quit");
        public JRadioButton b_radar = new JRadioButton("Scan");

        // String about.
        String about = "This game was created by AMIRJON SADILLOEV\nStudent of Brunel University in 2022";

        public void frameStart() {
                // Adding objects to the main panel.
                frame.setTitle("The BattleShip");
                main_panel.add(l_title);
                main_panel.add(b_about);
                main_panel.add(b_play);
                main_panel.add(b_exit);
                main_panel.add(background);
                frame.add(main_panel);

                // Setting positions, bounds of elements.
                frame.setSize(800, 800);
                main_panel.setBounds(0, 0, 800, 800);
                l_title.setBounds(280, 220, 300, 50);
                b_about.setBounds(600, 700, 200, 60);
                b_exit.setBounds(300, 400, 200, 80);
                b_play.setBounds(300, 290, 200, 80);
                background.setBounds(0, 0, 800, 800);

                // Fonts and colors.
                l_title.setFont(new Font("Arial", Font.BOLD, 35));
                b_play.setFont(new Font("Serif", Font.BOLD, 25));
                b_exit.setFont(new Font("Serif", Font.BOLD, 25));
                b_about.setFont(new Font("Arial", Font.BOLD, 35));
                b_about.setForeground(new Color(226, 237, 7));

                // Additional configurations for appereance of frame.
                frame.setLocationRelativeTo(null); // Initializes frame in the middle of the screen.
                frame.setResizable(false); // Frame is of fixed size.
                frame.setLayout(null);
                main_panel.setLayout(null);

                // Buttons configurations.
                b_about.setFocusPainted(false); // Does not show pressed button.
                b_about.setBorderPainted(false); // Removes JButton border.
                b_about.setContentAreaFilled(false); // Makes JButton background trasparent.
                b_exit.setFocusPainted(false);
                b_play.setFocusPainted(false);

                // Setting main frame and main panel to visible for the start of the game.
                frame.setVisible(true);
                main_panel.setVisible(true);
                actionPerformance();

        }

        public void actionPerformance() {
                b_play.addActionListener(
                                new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                                if (e.getSource() == b_play) {
                                                        gameStart();
                                                }

                                        }
                                });
                b_exit.addActionListener(
                                new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                                if (e.getSource() == b_exit) {
                                                        System.exit(0);
                                                        System.out.println("Pressed!");
                                                }

                                        }
                                });
                b_about.addActionListener(
                                new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                                if (e.getSource() == b_about) {
                                                        JOptionPane.showMessageDialog(frame, about);
                                                }

                                        }
                                });

        }

        public void gameStart() {
                logic = new LogicProcessing(this);
                // Removing main panel.
                main_panel.setVisible(false);
                frame.remove(main_panel);
                // Displaying player score.
                String score = "Score: " + this.logic.score;
                String radar = "Radar: " + this.logic.radar;

                // // Initializing game panel components.
                frame.add(game_panel);
                game_panel.add(enemy_board);
                game_panel.add(b_exit);
                game_panel.add(my_board);
                game_panel.add(b_radar);
                game_panel.add(l_score);
                game_panel.add(l_alive);
                game_panel.add(l_air);
                game_panel.add(l_bat);
                game_panel.add(l_sub);
                game_panel.add(l_des);
                game_panel.add(l_pat);
                game_panel.add(l_myBoard);
                game_panel.add(l_enemyBoard);
                game_panel.add(l_radars);
                game_panel.add(background);

                // Labels of ships status.

                // // Setting bounds of game panel elements.
                game_panel.setBounds(0, 0, 800, 800);
                b_exit.setBounds(580, 600, 100, 100);
                enemy_board.setBounds(50, 400, 520, 300);
                my_board.setBounds(50, 50, 520, 300);
                b_radar.setBounds(580, 120, 100, 30);
                l_alive.setBounds(580, 200, 220, 30);
                l_enemyBoard.setBounds(250, 370, 200, 30);
                l_score.setBounds(580, 150, 100, 50);
                l_air.setBounds(580, 230, 220, 50);
                l_bat.setBounds(580, 260, 220, 50);
                l_sub.setBounds(580, 290, 220, 50);
                l_des.setBounds(580, 320, 220, 50);
                l_pat.setBounds(580, 350, 220, 50);
                l_radars.setBounds(690, 150, 220, 50);

                l_alive.setFont(new Font("Arial", Font.BOLD, 20));
                l_radars.setFont(new Font("Arial", Font.BOLD, 20));
                l_air.setFont(new Font("Arial", Font.BOLD, 16));
                l_bat.setFont(new Font("Arial", Font.BOLD, 16));
                l_sub.setFont(new Font("Arial", Font.BOLD, 16));
                l_des.setFont(new Font("Arial", Font.BOLD, 16));
                l_pat.setFont(new Font("Arial", Font.BOLD, 16));

                l_score.setFont(new Font("Arial", Font.BOLD, 20));
                l_enemyBoard.setFont(new Font("Serif", Font.BOLD, 24));
                l_enemyBoard.setForeground(new Color(0, 8, 255));
                b_radar.setFont(new Font("Arial", Font.BOLD, 24));
                l_score.setText(score);
                l_radars.setText(radar);

                // // Additional configuration for panels.
                b_radar.setFocusPainted(false); // Does not show pressed button.
                b_radar.setBorderPainted(false); // Removes JButton border.
                b_radar.setContentAreaFilled(false); // Makes JButton background trasparent.
                my_board.setLayout(new GridLayout(10, 10));
                enemy_board.setLayout(new GridLayout(10, 10));
                game_panel.setLayout(null);
                logic.enemyBoardGenerate();
                logic.myBoardGenerate();

                // Placing Ships.

                // CPU ships
                this.logic.en_airCraftCarrier = this.logic.placeShip(this.logic.initialPoint(), 5, this.logic
                                .direction(), true,
                                this.logic.enemy_btn);
                this.logic.en_battleship = this.logic.placeShip(this.logic.initialPoint(), 4, this.logic.direction(),
                                true,
                                this.logic.enemy_btn);
                this.logic.en_submarine = this.logic.placeShip(this.logic.initialPoint(), 3, this.logic.direction(),
                                true,
                                this.logic.enemy_btn);
                this.logic.en_destroyer = this.logic.placeShip(this.logic.initialPoint(), 3, this.logic.direction(),
                                true,
                                this.logic.enemy_btn);
                this.logic.en_patrolBoat = this.logic.placeShip(this.logic.initialPoint(), 2, this.logic.direction(),
                                true,
                                this.logic.enemy_btn);

                // Player ships.
                this.logic.airCraftCarrier = this.logic.placeShip(this.logic.initialPoint(), 5,
                                this.logic.direction(), true, this.logic.my_btn);
                this.logic.battleship = this.logic.placeShip(this.logic.initialPoint(), 4,
                                this.logic.direction(), true, this.logic.my_btn);
                this.logic.submarine = this.logic.placeShip(this.logic.initialPoint(), 3,
                                this.logic.direction(), true, this.logic.my_btn);
                this.logic.destroyer = this.logic.placeShip(this.logic.initialPoint(), 3,
                                this.logic.direction(), true, this.logic.my_btn);
                this.logic.patrolBoat = this.logic.placeShip(this.logic.initialPoint(), 2,
                                this.logic.direction(), true, this.logic.my_btn);

                // Adding all coordinates of enemy ships in one array for further interaction.
                this.logic.iterate(this.logic.airCraftCarrier, this.logic.playerOccupied);
                this.logic.iterate(this.logic.battleship, this.logic.playerOccupied);
                this.logic.iterate(this.logic.submarine, this.logic.playerOccupied);
                this.logic.iterate(this.logic.destroyer, this.logic.playerOccupied);
                this.logic.iterate(this.logic.patrolBoat, this.logic.playerOccupied);

                System.out.println(this.logic.playerOccupied + " Final arraylist");

                // Adding all coordinates of Player ships in one array for further interaction.
                this.logic.iterate(this.logic.en_airCraftCarrier, this.logic.enemyOccupied);
                this.logic.iterate(this.logic.en_battleship, this.logic.enemyOccupied);
                this.logic.iterate(this.logic.en_destroyer, this.logic.enemyOccupied);
                this.logic.iterate(this.logic.en_submarine, this.logic.enemyOccupied);
                this.logic.iterate(this.logic.en_patrolBoat, this.logic.enemyOccupied);

                System.out.println(this.logic.enemyOccupied + " Final arraylist of enemy!");
        }

        // Winner panel.
        public void winnerPanel() {
                frame.remove(game_panel);
                frame.add(winner);
                winner.add(l_title);
                winner.add(l_nickname);
                winner.add(l_score);
                winner.add(b_exit);
                winner.add(background);

                // Setting configuration of winner panel.

                winner.setBounds(0, 0, 800, 800);
                winner.setLayout(null);
                l_score.setBounds(310, 260, 200, 50);
                l_title.setBounds(280, 220, 300, 50);
                l_nickname.setBounds(320, 320, 300, 50);
                l_nickname.setText("Player");

                l_score.setFont(new Font("Arial", Font.BOLD, 32));
                l_title.setFont(new Font("Arial", Font.BOLD, 30));
                l_nickname.setFont(new Font("Arial", Font.BOLD, 30));

                l_score.setForeground(new Color(0, 191, 255));
                l_title.setForeground(new Color(82, 102, 255));

        }
}
