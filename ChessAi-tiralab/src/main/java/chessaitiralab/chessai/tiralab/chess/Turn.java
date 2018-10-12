/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessaitiralab.chessai.tiralab.chess;

/**
 * This class represents a turn.
 *
 * @author hceetu
 */
public class Turn {
    private ChessBoard board;
    private int eaten;
    private Integer value = null;
    private Move move;

    public Turn(ChessBoard board, int eaten, Move move) {
        this.board = board;
        this.eaten = eaten;
        this.move = move;
    }

    public ChessBoard getBoard() {
        return board;
    }

    public int getEaten() {
        return eaten;
    }

    public Move getMove() {
        return move;
    }

    public Integer getValue() {
        return value;
    }

    public void setBoard(ChessBoard board) {
        this.board = board;
    }

    public void setEaten(int eaten) {
        this.eaten = eaten;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    
    
}
