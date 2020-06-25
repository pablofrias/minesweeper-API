package com.pfrias.minesweeper.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testBoardCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Board(-1, 1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Board(1, -1);
        });

        Board b = new Board(8,8);
        assertEquals(8, b.getRows());
        assertEquals(8, b.getCols());
    }

    @Test
    public void testCellAdjacents() {
        Board b = new Board(2,2);
        Cell c00 = b.getCell(0,0);
        int c00Mine = c00.isHasMine()?1:0;

        Cell c01 = b.getCell(0,1);
        int c01Mine = c01.isHasMine()?1:0;

        Cell c10 = b.getCell(1,0);
        int c10Mine = c10.isHasMine()?1:0;

        Cell c11 = b.getCell(1,1);
        int c11Mine = c11.isHasMine()?1:0;

        assertEquals(c00.getNeighborMines(), (c01Mine+c10Mine+c11Mine));
        assertEquals(c01.getNeighborMines(), (c00Mine+c10Mine+c11Mine));
        assertEquals(c10.getNeighborMines(), (c00Mine+c01Mine+c11Mine));
        assertEquals(c11.getNeighborMines(), (c00Mine+c01Mine+c10Mine));
    }
}