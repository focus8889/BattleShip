package graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ActionControl.ActionController;

public class Graphics extends JFrame {
    // Main Frame.
    public JFrame frame = new JFrame();

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
    public JLabel l_sunk = new JLabel("S");

    // Game buttons.
    public JButton b_about = new JButton("About");
    public JButton b_play = new JButton("Play");
    public JButton b_exit = new JButton("Exit");
    public JButton b_quit = new JButton("Quit");

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
        frame.setSize(600, 600);
        main_panel.setBounds(0, 0, 600, 600);
        l_title.setBounds(200, 80, 200, 50);

        // Additional configurations for appereance of frame.
        frame.setLocationRelativeTo(null); // Initializes frame in the middle of the screen.
        frame.setResizable(false);
        frame.setLayout(null);
        main_panel.setLayout(null);

        // Setting main frame and main panel to visible for the start of the game.
        frame.setVisible(true);
        main_panel.setVisible(true);
    }

    public void start() {
        frameStart();
    }
}
