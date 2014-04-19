/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * The CheckerboardKarel class draws a checkerboard using beepers.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
    public void run() {
        drawRow();
        while (frontIsClear()) {
            drawRow();
        }
    }
    
    /**
     * Draws patterned row of checkers (beepers).
     * Pre-condition:  Karel is either in the leftmost or rightmost square of
     *                 the row.
     * Post-condition: Karel is at the opposite end of the row to which he
     *                 started, having drawn the required pattern, facing north.
     */
    private void drawRow() {
        
        // Draw the start of the row, according to one of the two possible
        // patterns.
        startRow();
        while (frontIsClear()) {
            move();
            if (frontIsClear()) {
                move();
                putBeeper();
            }
        }
        faceNorth();
    }
    
    /**
     * Starts drawing the patterned row of checkers (beepers).
     * Pre-condition:  Karel is either in the leftmost or rightmost square of
     *                 the row.
     * Post-condition: The start of the row has been drawn, according to one of
     *                 the two possible patterns. 
     */
    private void startRow() {
        if (noBeepersPresent()) {
            
            // moveToAboveRow only fires once the first row has been drawn.
            moveToAboveRow();
            putBeeper();
        } else {
            
            // moveToAboveRow only fires once the first row has been drawn.
            moveToAboveRow();
            if (frontIsClear()) {
                move();
                putBeeper();
            }
        }
    }
    
    /**
     * Moves Karel to the row above.
     * Pre-condition:  Karel is facing north, either in the leftmost or
     *                 rightmost square of the row.
     * Post-condition: Karel is in the square one row above where he was, in the
     *                 same column, facing either east or west dependant on
     *                 which direction he was facing.
     */
    private void moveToAboveRow() {
        if (facingNorth()) {
            if (rightIsBlocked()) {
                move();
                turnLeft();
            } else if (leftIsBlocked()) {
                move();
                turnRight();
            }
        }
    }
    
    /**
     * Turns Karel to face north.
     * Pre-condition:  Karel is facing east or west.
     * Post-condition: Karel is facing north.
     */
    private void faceNorth() {
        if (facingEast()) {
            turnLeft();
        } else if (facingWest()) {
            turnRight();
        }
    }
}