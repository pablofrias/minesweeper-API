package com.pfrias.minesweeper.entities;

import java.util.List;

public class Cell {
    
    private boolean hasMine;
    private boolean hasRedFlag;
    private boolean hasQuestionMark;

    private int neighborMines = 0;
    private List<Cell> adjacents;

    public Cell() {
        
    }

    
}