package com.comp2042;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixOperationsTest {

    @Test
    void intersect_noOverlap_returnsFalse() {
        int[][] matrix = new int[5][5];
        int[][] brick = new int[][] { { 1 } };
        assertFalse(MatrixOperations.intersect(matrix, brick, 2, 2));
    }

    @Test
    void intersect_overlapWithFilledCell_returnsTrue() {
        int[][] matrix = new int[5][5];
        matrix[3][3] = 1; // row 3 col 3
        int[][] brick = new int[][] { { 1 } };
        assertTrue(MatrixOperations.intersect(matrix, brick, 3, 3));
    }

    @Test
    void intersect_outOfBounds_returnsTrue() {
        int[][] matrix = new int[3][3];
        int[][] brick = new int[][] { { 1, 1 }, { 1, 1 } }; // 2x2
        // placing 2x2 at (2,2) would overflow
        assertTrue(MatrixOperations.intersect(matrix, brick, 2, 2));
    }

    @Test
    void merge_placesBrickCorrectly() {
        int[][] matrix = new int[4][4];
        int[][] brick = new int[][] { { 1, 2 }, { 3, 4 } };
        int[][] merged = MatrixOperations.merge(matrix, brick, 1, 1);
        assertEquals(1, merged[1][1]);
        assertEquals(2, merged[1][2]);
        assertEquals(3, merged[2][1]);
        assertEquals(4, merged[2][2]);
        // original must not be modified
        assertEquals(0, matrix[1][1]);
    }

    @Test
    void checkRemoving_clearsFullRows_andCalculatesBonus() {
        int rows = 4, cols = 4;
        int[][] matrix = new int[rows][cols];
        // fill row 2 completely
        for (int c = 0; c < cols; c++)
            matrix[2][c] = 1;
        // put a single block above
        matrix[1][1] = 2;
        ClearRow cr = MatrixOperations.checkRemoving(matrix);
        assertEquals(1, cr.getLinesRemoved());
        assertEquals(50, cr.getScoreBonus());
        // after removal, the non-cleared row should have moved down to row 2
        assertEquals(2, cr.getNewMatrix()[2][1]);
    }

    @Test
    void deepCopyList_returnsIndependentCopies() {
        int[][] a = new int[][] { { 1 } };
        List<int[][]> list = new ArrayList<>();
        list.add(a);
        List<int[][]> copy = MatrixOperations.deepCopyList(list);
        copy.get(0)[0][0] = 9;
        assertEquals(1, list.get(0)[0][0]);
        assertEquals(9, copy.get(0)[0][0]);
    }
}
