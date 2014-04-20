/*
 * File: KarelDefendsDemocracy.java
 * --------------------------------
 * The KarelDefendsDemocracy class instructs Karel to move across the punch card
 * ballot and make sure that no stray bits of card remain in any of the ballot
 * spaces in which the user has attempted to cast a vote.
 */

import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel {
    public void run() {
        while (frontIsClear()) {
            move();
            if (noBeepersPresent()) {
                removeChad();
            }
            move();
        }
    }
    
    /**
     * Removes any chad from a ballot rectangle, which consists of beepers in
     * the squares to the right and left of Karel's current position.
     */
    private void removeChad() {
        turnLeft();
        checkPunchCorner();
        checkPunchCorner();
        turnRight();
    }
    
    /**
     * Removes any chad from the corner in front of Karel.
     * Pre-condition:  Karel is facing one of the corners that represents a
     *                 punch hole in a ballot.
     * Post-condition: Karel is in the same square but facing in the opposite
     *                 direction.
     */
    private void checkPunchCorner() {
        move();
        while (beepersPresent()) {
            pickBeeper();
        }
        turnAround();
        move();
    }
}