/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel class instructs Karel to repair a set of arches where
 * some of the stones (represented by beepers) are missing from the columns
 * supporting the arches.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
    public void run() {
        repairColumn();
        while (frontIsClear()) {
            moveFourColumns();
            repairColumn();
        }
    }
    
    /**
     * Repairs the column, by replacing any stones (beepers) that are missing.
     * Pre-condition:  Karel is either at the bottom, or top of a column, facing
     *                 north, east or south.
     * Post-condition: Any missing stones (beepers) have been replaced, and 
     *                 Karel is at the opposite end of the column to which he 
     *                 started, facing either north, east or south.
     */
    private void repairColumn() {
        rotate();
        replaceStones();
        rotate();
    }
    
    /**
     * Moves Karel four columns.
     * Pre-condition:  Karel is in a column.
     * Post-condition: Karel is four columns over from where he started.
     */
    private void moveFourColumns() {
        for (int i = 0; i < 4; i++) {
            move();
        }
    }
    
    /**
     * Rotates Karel to face the direction required of him, in order to either
     * proceed to the replaceStones or moveFourColumns functions.
     * Pre-condition:  Karel is facing north, east or south.
     * Post-condition: Karel is facing in a new direction, as commented in more
     *                 detail in the function body.
     */
    private void rotate() {
        
        // Rotate to face east.
        if (facingNorth()) {
            turnRight();
        } else if (facingEast()) {
            
            // Rotate to face south.
            if (leftIsBlocked()) {
                turnRight();
                
            // Rotate to face north.
            } else if (rightIsBlocked()) {
                turnLeft();
            }
            
        // Rotate to face east.
        } else if (facingSouth()) {
            turnLeft();
        }
    }
    
    /**
     * Moves Karel along the column, replacing any missing stones (beepers).
     * Pre-condition:  Karel is either at the bottom, or top of a column, facing
     *                 the required direction.
     * Post-condition: Karel is at the opposite end of the column to which he
     *                 started, having replaced any missing stones (beepers).
     */
    private void replaceStones() {
        if (noBeepersPresent()) {
            putBeeper();
        }
        while (frontIsClear()) {
            move();
            if (noBeepersPresent()) {
                putBeeper();
            }
        }
    }
}