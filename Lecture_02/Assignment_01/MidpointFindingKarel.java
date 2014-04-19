/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * The MidpointFindingKarel class instructs Karel to place a single beeper at
 * the center of 1st Street.
 * If the width is even, the beeper will be placed in either of the center
 * squares.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {
    public void run() {
        putBeepersOnCorners();
        moveBeepersTowardsCenter();
    }
    
    /**
     * Places beepers on the leftmost and rightmost squares of the row.
     * Pre-condition:  The row is empty.
     * Post-condition: The row has a beeper on the leftmost square and a beeper
     *                 on the rightmost square.
     */
    private void putBeepersOnCorners() {
        putBeeper();
        moveToWall();
        putBeeper();
    }
    
    /**
     * Moves each of the beepers towards the center of the row one square at a
     * time.
     * Pre-condition:  The row has a beeper on the leftmost square and a beeper
     *                 on the rightmost square.
     * Post-condition: A single beeper remains at the midpoint of the row. If
     *                 the width of the row is even, the beeper will remain in
     *                 either of the center squares.
     */
    private void moveBeepersTowardsCenter() {
        
        // Move the beeper on the same square as Karel one square towards the
        // center.
        pickBeeper();
        if (noBeepersPresent()) {
            turnAround();
            move();
            putBeeper();
            
            // Move to the other beeper.
            pickBeeper();
            if (noBeepersPresent()) {
                putBeeper();
                move();
                while (noBeepersPresent()) {
                    move();
                }
                
                // Repeat..
                moveBeepersTowardsCenter();
            }
        }
    }
    
    /**
     * Moves Karel forward until it is blocked by a wall.
     * Pre-condition:  Karel is anywhere in the world.
     * Post-condition: Karel is in a square immediately in front of, and facing
     *                 a wall.
     */
    private void moveToWall() {
        while (frontIsClear()) {
            move();
        }
    }
}