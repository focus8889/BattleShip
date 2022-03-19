package graphics;

import java.awt.Color;
import java.awt.Font;
// import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        public JLabel l_sunk = new JLabel();
        public JLabel l_alive = new JLabel();

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
                main_panel.add(l_title);
                main_panel.add(b_about);
                main_panel.add(b_play);
                main_panel.add(b_exit);
                frame.add(main_panel);

                // Setting positions, bounds of elements.
                frame.setSize(800, 800);
                main_panel.setBounds(0, 0, 800, 800);
                l_title.setBounds(200, 80, 200, 50);
                b_about.setBounds(500, 500, 80, 60);
                b_exit.setBounds(200, 400, 200, 80);
                b_play.setBounds(200, 200, 200, 80);

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

        }

        public void gameStart() {
                logic = new LogicProcessing(this);
                // Removing main panel.
                main_panel.setVisible(false);
                frame.remove(main_panel);

                // Displaying player score.
                String score = "Score: " + this.logic.score;

                // // Initializing game panel components.
                frame.add(game_panel);
                game_panel.add(enemy_board);
                game_panel.add(my_board);
                game_panel.add(b_radar);
                game_panel.add(l_score);

                // // Setting bounds of game panel elements.
                game_panel.setBounds(0, 0, 800, 800);
                enemy_board.setBounds(50, 400, 520, 300);
                my_board.setBounds(50, 50, 520, 300);
                b_radar.setBounds(580, 50, 100, 30);
                l_score.setBounds(580, 100, 100, 50);
                l_score.setFont(new Font("Arial", Font.BOLD, 16));
                l_score.setText(score);

                // // Additional configuration for panels.
                my_board.setLayout(new GridLayout(10, 10));
                enemy_board.setLayout(new GridLayout(10, 10));
                game_panel.setBackground(Color.red);
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

                // Setting configuration of winner panel.

                winner.setBounds(0, 0, 800, 800);
                winner.setLayout(null);
                l_score.setBounds(300, 100, 200, 50);
                l_title.setBounds(250, 50, 300, 50);
                l_nickname.setBounds(250, 180, 300, 50);
                l_nickname.setText("Player");

                l_score.setFont(new Font("Arial", Font.BOLD, 32));
                l_title.setFont(new Font("Arial", Font.BOLD, 30));
                l_nickname.setFont(new Font("Arial", Font.BOLD, 30));

                l_score.setForeground(new Color(0, 191, 255));
                l_title.setForeground(new Color(82, 102, 255));

        }
}
