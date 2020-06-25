package com.pfrias.minesweeper.entities;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    
    private boolean hasMine;
    private boolean hasRedFlag;
    private boolean hasQuestionMark;

    private int neighborMines = 0;
    private List<Cell> adjacents;

    public Cell() {
        adjacents = new ArrayList<Cell>();
    }

    public boolean isHasMine() {
        return hasMine;
    }

    public void setHasMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    public boolean isHasRedFlag() {
        return hasRedFlag;
    }

    public void setHasRedFlag(boolean hasRedFlag) {
        this.hasRedFlag = hasRedFlag;
    }

    public boolean isHasQuestionMark() {
        return hasQuestionMark;
    }

    public void setHasQuestionMark(boolean hasQuestionMark) {
        this.hasQuestionMark = hasQuestionMark;
    }

    public int getNeighborMines() {
        return neighborMines;
    }

    public void addAdjacent(final Cell cell) {
        if(cell != null) {
            this.adjacents.add(cell);
            if (cell.isHasMine()) {
                this.neighborMines++;
            }
        }
    }
}