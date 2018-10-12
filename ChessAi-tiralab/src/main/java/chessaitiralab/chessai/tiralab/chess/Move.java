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
    private Coordinate coodB;
    private Coordinate coodE;

    public Move(Coordinate a, Coordinate l) {
        coodB = a;
        coodE = l;
    }

    public int getYb() {
        return coodB.getY();
    }

    public int getXb() {
        return coodB.getX();
    }

    public int getYe() {
        return coodE.getY();
    }

    public int getXe() {
        return coodE.getX();
    }

    public Coordinate getCoodB() {
        return coodB;
    }

    public Coordinate getCoodE() {
        return coodE;
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(this)) {
            return false;
        }
        
        Move compare = (Move) obj;
        
        return compare.coodB.toString().equals(this.coodB.toString()) 
                && compare.coodE.toString().equals(this.coodE.toString());
    }
    
    
}
