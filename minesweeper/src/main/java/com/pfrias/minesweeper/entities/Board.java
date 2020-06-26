package com.pfrias.minesweeper.entities;

import com.google.common.base.Preconditions;

import java.util.Random;

public class Board {
    
    private int cols;
    private int rows;
    private int mines;

    private Cell [][] board;
    private Random random;

    public Board(final int rows, final int cols) {
        areValidRowCol(rows, cols);

        this.cols = cols;
        this.rows = rows;
        this.board = new Cell[rows][cols];
        this.random = new Random();
        generateBoardCells();
        fillAdjacents();
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    private void generateBoardCells() {
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                Cell cell = new Cell();
                cell.setHasMine(random.nextBoolean());
                cell.setHasQuestionMark(false);
                cell.setHasRedFlag(false);

                board[i][j] = cell;

                this.mines += cell.isHasMine()?1:0;
            }
        }
    }

    private void fillAdjacents() {
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                setAdjacents(i, j);
            }
        }
    }

    private void setAdjacents(final int row, final int col) {
        final Cell cell = board[row][col];

        cell.addAdjacent(((row-1)>=0    && (col-1)>=0)  ?board[row-1][col-1]:null);
        cell.addAdjacent(((row-1)>=0    && (col)>=0)    ?board[row-1][col]:null);
        cell.addAdjacent(((row-1)>=0    && (col+1)<cols)  ?board[row-1][col+1]:null);
        cell.addAdjacent(((col-1)>=0)  ?board[row][col-1]:null);
        cell.addAdjacent(((col+1)<cols)  ?board[row][col+1]:null);
        cell.addAdjacent(((row+1)<rows && (col-1)>=0)  ?board[row+1][col-1]:null);
        cell.addAdjacent(((row+1)<rows)    ?board[row+1][col]:null);
        cell.addAdjacent(((row+1)<rows && (col+1)<cols)  ?board[row+1][col+1]:null);

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String bombOrNum;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                bombOrNum = ((board[i][j]).isHasMine())?"*":String.valueOf((board[i][j]).getNeighborMines());
                str.append("|" + bombOrNum);
            }
            str.append("|\n");
        }

        return str.toString();
    }

    public boolean pushCell(int row, int col) {
        areValidRowCol(row, col);
        Cell c = getCell(row, col);
        if(!c.isHasMine()) {
            c.clearCellAndAdjacents();
            return true;
        } else {
            return false;
        }
    }

    public int getClearedCells() {
        Cell c;
        int clearedCells=0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                c = getCell(i,j);
                clearedCells += (c.isClear())?1:0;
            }
        }

        return clearedCells;
    }

    private void areValidRowCol(int row, int col) {
        Preconditions.checkArgument(row >= 0, "Rows should be positive integer");
        Preconditions.checkArgument(col >= 0, "Col should be positive integer");
    }
}