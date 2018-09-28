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
    private Coordinate coodA;
    private Coordinate coodL;

    public Move(Coordinate a, Coordinate l) {
        coodA = a;
        coodL = l;
    }

    public int getYa() {
        return coodA.getY();
    }

    public int getXa() {
        return coodA.getX();
    }

    public int getYl() {
        return coodL.getY();
    }

    public int getXl() {
        return coodL.getX();
    }

    public Coordinate getCoodA() {
        return coodA;
    }

    public Coordinate getCoodL() {
        return coodL;
    }
    
    
}
