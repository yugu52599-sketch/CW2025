package com.comp2042;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleBoardTest {

    @Test
    void newGame_initializesBoardAndResetsScore() {
        SimpleBoard board = new SimpleBoard(25, 10);
        // simulate some score
        board.getScore().add(100);
        board.newGame();
        assertEquals(0, board.getScore().scoreProperty().get());
        assertNotNull(board.getOffset());
        int[][] matrix = board.getBoardMatrix();
        assertEquals(25, matrix.length);
        assertEquals(10, matrix[0].length);
    }

    @Test
    void moveBrickDown_untilCollision_thenMergeLeavesBlocks() {
        SimpleBoard board = new SimpleBoard(25, 10);
        // create a brick at starting position
        assertDoesNotThrow(board::createNewBrick);

        int steps = 0;
        boolean canMove = true;
        while (canMove && steps < 200) {
            canMove = board.moveBrickDown();
            steps++;
        }
        // should eventually collide
        assertFalse(canMove, "Expected the falling brick to collide within reasonable steps");

        // merge to background and verify some cell is non-zero
        board.mergeBrickToBackground();
        int[][] matrix = board.getBoardMatrix();
        boolean hasBlock = false;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] != 0) {
                    hasBlock = true;
                    break;
                }
            }
            if (hasBlock)
                break;
        }
        assertTrue(hasBlock, "After merging a brick, the board should contain at least one filled cell");
    }

    @Test
    void moveLeftRightRotate_doNotThrow() {
        SimpleBoard board = new SimpleBoard(25, 10);
        board.createNewBrick();
        assertDoesNotThrow(board::moveBrickLeft);
        assertDoesNotThrow(board::moveBrickRight);
        assertDoesNotThrow(board::rotateLeftBrick);
    }
}
