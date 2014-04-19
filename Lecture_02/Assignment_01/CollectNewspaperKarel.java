/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * The CollectNewspaperKarel class instructs Karel to walk to the door of its
 * house, pick up the newspaper (represented by a beeper), and then return to
 * its original position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {
    public void run() {
        moveToNewspaper();
        pickUpNewspaper();
        returnToStartingPoint();
    }
    
    /**
     * Moves Karel to the newspaper (beeper).
     * Pre-condition:  Karel is in the same square and facing the same direction
     *                 as shown in the Problem 1 image.
     * Post-condition: Karel is in the same square as the newspaper (beeper),
     *                 facing east.
     */
    private void moveToNewspaper() {
        moveToWall();
        turnRight();
        move();
        turnLeft();
        move();
    }
    
    /**
     * Picks up the newspaper (beeper).
     * Pre-condition:  Karel is in the same square as the newspaper (beeper).
     * Post-condition: Karel has picked up the newspaper (beeper).
     */
    private void pickUpNewspaper() {
        if (beepersPresent()) {
            pickBeeper();
        }
    }
    
    /**
     * Returns Karel to the square he started on, facing the same direction.
     * Pre-condition:  Karel is in the same square as the newspaper (beeper) was
     *                 before it picked it up.
     * Post-condition: Karel is in the same square and facing the same direction
     *                 as when the program began execution.
     */
    private void returnToStartingPoint() {
        turnAround();
        move();
        turnRight();
        move();
        turnLeft();
        moveToWall();
        turnAround();
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