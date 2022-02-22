import java.applet.Applet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Graphics extends JFrame {
    // Main Frame.
    JFrame frame = new JFrame();

    // Panels of the game
    JPanel enemy_board = new JPanel();
    JPanel my_board = new JPanel();
    JPanel winner = new JPanel();
    JPanel game_panel = new JPanel();
    JPanel main_panel = new JPanel();

    // Booleans
    boolean flag, turn;

    // Labels.
    JLabel l_nickname = new JLabel();
    JLabel l_title = new JLabel();
    JLabel l_score = new JLabel();
    JLabel l_ships = new JLabel();
    JLabel l_radars = new JLabel();
    JLabel l_hit = new JLabel();
    JLabel l_miss = new JLabel();
    JLabel l_sunk = new JLabel();

    // Game buttons.
    JButton b_about = new JButton();
    JButton b_play = new JButton();
    JButton b_exit = new JButton();
    JButton b_quit = new JButton();

    // String about.
    String about = "This game was created by AMIRJON SADILLOEV\nStudent of Brunel University in 2022";
}
