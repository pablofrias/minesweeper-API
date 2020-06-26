package com.pfrias.minesweeper.entities;

public class Game {

    private Board board;
    private User user;
    private int state;
    private int flaggedMines;
    private int totalCells;

    private static int STATE_STARTED=1;
    private static int STATE_FINISHED_LOST=2;
    private static int STATE_FINISHED_WIN=3;

    public Game() {
    }

    public Board getBoard() {
        return board;
    }

    public User getUser() {
        return user;
    }

    public int getState() {
        return state;
    }

    public void startNewGame(User user, int rows, int cols) {
        this.board = new Board(rows, cols);
        this.user = user;
        this.state = this.STATE_STARTED;
        this.totalCells = rows*cols;
        this.flaggedMines = 0;
    }

    public void pushCell(int row, int col) {
        if(!board.pushCell(row, col)) {
            // bomb exploded!
            this.state = STATE_FINISHED_LOST;
        }
    }

    public void flagCell(int row, int col){

    }

    public void questionCell(int row, int col) {

    }
}