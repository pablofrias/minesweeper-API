package com.pfrias.minesweeper.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    private Cell cell;

    @BeforeEach
    void setUp() {
        cell = new Cell();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isHasMine() {
        assertFalse(cell.isHasMine());
        cell.setHasMine(true);
        assertTrue(cell.isHasMine());
    }

    @Test
    void isHasRedFlag() {
        assertFalse(cell.isHasRedFlag());
        cell.setHasRedFlag(true);
        assertTrue(cell.isHasRedFlag());
    }

    @Test
    void isHasQuestionMark() {
        assertFalse(cell.isHasQuestionMark());
        cell.setHasQuestionMark(true);
        assertTrue(cell.isHasQuestionMark());
    }

    @Test
    void getNeighborMines() {
        assertEquals(0, cell.getNeighborMines());

        Cell c1 = new Cell();
        c1.setHasMine(true);
        cell.addAdjacent(c1);
        assertEquals(1, cell.getNeighborMines());

        Cell c2 = new Cell();
        c1.setHasMine(true);
        cell.addAdjacent(c1);
        assertEquals(2, cell.getNeighborMines());

        Cell c3 = new Cell();
        c1.setHasMine(true);
        cell.addAdjacent(c1);
        assertEquals(3, cell.getNeighborMines());

    }

}