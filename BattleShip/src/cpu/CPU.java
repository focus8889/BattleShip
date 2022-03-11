package cpu;

import java.util.ArrayList;

public class CPU {
    // If true turn of CPU to make a move.
    boolean move = true;
    // Coordinates of the ships.
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
}
