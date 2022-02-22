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

    public void start() {
        b_about.addActionListener(new ActionController());
    }
}
