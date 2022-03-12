package player;

import java.util.ArrayList;

public class Player {
    // If true turn of Player to make a move.
    boolean move = true;
    // Coordinates of the ships.
    public ArrayList<Integer> patrolBoat = new ArrayList<Integer>(2);
    public ArrayList<Integer> submarine = new ArrayList<Integer>(3);
    public ArrayList<Integer> destroyer = new ArrayList<Integer>(3);
    public ArrayList<Integer> battleship = new ArrayList<Integer>(4);
    public ArrayList<Integer> airCraftCarrier = new ArrayList<Integer>(5);
    // Health points of ships.
    public int patrol_boat_health = 2;
    public int submarine_health = 3;
    public int destroyer_health = 3;
    public int battleship_health = 4;
    public int airCraftCarrier_health = 5;

    // Radar quantity.
    public int radar = 4;

    public void print() {
        System.out.println(airCraftCarrier + "Hi");
    }

}
