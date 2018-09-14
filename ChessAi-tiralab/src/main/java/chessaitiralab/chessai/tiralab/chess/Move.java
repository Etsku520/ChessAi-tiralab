/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessaitiralab.chessai.tiralab.chess;

/**
 * This is a class for a move, it just holds the coordinates
 * 
 * @author hceetu
 */
public class Move {
    private int ya;
    private int xa;
    private int yl;
    private int xl;

    public Move(int ya, int xa, int yl, int xl) {
        this.ya = ya;
        this.xa = xa;
        this.yl = yl;
        this.xl = xl;
    }

    public int getYa() {
        return ya;
    }

    public int getXa() {
        return xa;
    }

    public int getYl() {
        return yl;
    }

    public int getXl() {
        return xl;
    }
    
    
}
