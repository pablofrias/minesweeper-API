package com.pfrias.minesweeper.entities;

public class Game {

    private Board board;
    private User user;
    private int state;

    private static int STATE_STARTED=1;
    private static int STATE_FINISHED=2;

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
    }

    public void pushCell(int row, int col) {

    }

    public void flagCell(int row, int col){

    }

    public void questionCell(int row, int col) {

    }
}