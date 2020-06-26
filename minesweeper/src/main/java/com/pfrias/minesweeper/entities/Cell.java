package com.pfrias.minesweeper.entities;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    
    private boolean hasMine;
    private boolean hasRedFlag;
    private boolean hasQuestionMark;
    private boolean isClear;

    private int neighborMines = 0;
    private List<Cell> adjacents;

    public Cell() {
        adjacents = new ArrayList<Cell>();
        isClear = false;
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

    public void setNeighborMines(int neighborMines) {
        this.neighborMines = neighborMines;
    }

    public boolean isClear() {
        return isClear;
    }

    public void clearCellAndAdjacents() {
        isClear = true;
        clearAdjacents();
    }

    public List<Cell> getAdjacents() {
        return adjacents;
    }

    private void clearAdjacents() {
        for (Cell cell : adjacents) {
            if (!cell.isClear() && cell.neighborMines==0) {
                cell.clearCellAndAdjacents();
            }
        }
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