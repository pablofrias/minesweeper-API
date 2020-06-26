package com.pfrias.minesweeper.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    public void testClearCell() {
        Board b = new Board(4,4);
        cleanAllCells(b);
        b.pushCell(0,0);
        assertEquals(16, b.getClearedCells());
    }

    private void cleanAllCells(Board b) {
        Cell c;
        for(int i=0; i < b.getRows(); i++) {
            for(int j=0; j < b.getCols(); j++) {
                c = b.getCell(i, j);
                c.setHasMine(false);
                c.setHasQuestionMark(false);
                c.setHasRedFlag(false);
                c.setNeighborMines(0);
            }
        }
    }
}