package graphics;

import player.*;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import ActionControl.ActionController;
import logic.LogicProcessing;

public class Graphics {
    // Main Frame.
    public static JFrame frame = new JFrame();

    // Panels of the game
    public static JPanel enemy_board = new JPanel();
    public static JPanel my_board = new JPanel();
    public JPanel winner = new JPanel();
    public static JPanel game_panel = new JPanel();
    public static JPanel main_panel = new JPanel();

    // Booleans
    boolean flag, turn;

    static LogicProcessing logic = new LogicProcessing();
    static Player player = new Player();

    // Labels.
    public JLabel l_nickname = new JLabel();
    public JLabel l_title = new JLabel("The BattleShip");
    public JLabel l_score = new JLabel("Score");
    public JLabel l_ships = new JLabel("");
    public JLabel l_radars = new JLabel("4");
    public JLabel l_hit = new JLabel("H");
    public JLabel l_miss = new JLabel("M");
    public JLabel l_sunk = new JLabel("S");

    // Game buttons.
    public static JButton b_about = new JButton("About");
    public static JButton b_play = new JButton("Play");
    public static JButton b_exit = new JButton("Exit");
    public static JButton b_quit = new JButton("Quit");
    public static JRadioButton b_radar = new JRadioButton("Scan");

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

    public void start() {
        frameStart();

    }

    public void actionPerformance() {
        b_exit.addActionListener(new ActionController());
        b_play.addActionListener(new ActionController());
    }

    public static void gameStart() {

        // Removing main panel.
        main_panel.setVisible(false);
        frame.remove(main_panel);

        // Initializing game panel components.
        frame.add(game_panel);
        game_panel.add(enemy_board);
        game_panel.add(my_board);
        game_panel.add(b_radar);

        // Setting bounds of game panel elements.
        game_panel.setBounds(0, 0, 800, 800);
        enemy_board.setBounds(50, 400, 520, 300);
        my_board.setBounds(50, 50, 520, 300);
        b_radar.setBounds(580, 50, 100, 30);

        // Additional configuration for panels.
        my_board.setLayout(new GridLayout(10, 10));
        enemy_board.setLayout(new GridLayout(10, 10));
        logic.enemyBoardGenerate();
        logic.myBoardGenerate();
        game_panel.setLayout(null);
        logic.left(logic.initialPoint(), 3, true);

        logic.placeShip(logic.initialPoint(), 5, 0, true);
        for (int i = 0; i < player.airCraftCarrier.size(); i++) {
            int id = player.airCraftCarrier.get(i);
            logic.my_btn[id].setBackground(Color.RED);
            player.print();
        }
    }
}
