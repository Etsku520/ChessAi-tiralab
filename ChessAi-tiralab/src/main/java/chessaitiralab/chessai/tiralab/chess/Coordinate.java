/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessaitiralab.chessai.tiralab.chess;

/**
 * This is a coordinate of chess.
 * Please never put anything here that isn't in the same from as "b4".
 * so one letter and one number.
 * 
 * @author hceetu
 */
public class Coordinate {
    String coor;

    public Coordinate(String coor) {
        this.coor = coor.trim().toLowerCase();
    }
    
    /**
     * Gives option to give the coordinate as an int.
     * For example 24 is b4
     * 
     * @param coor 
     */
    public Coordinate(int coor) {
        String sCoor = "";
        
        if (coor/10 == 1) {
            sCoor += "a";
            sCoor += (coor - 10);
        }
        
        if (coor/10 == 2) {
            sCoor += "b";
            sCoor += (coor - 20);
        }
        
        if (coor/10 == 3) {
            sCoor += "c";
            sCoor += (coor - 30);
        }
        
        if (coor/10 == 4) {
            sCoor += "d";
            sCoor += (coor - 40);
        }
        
        if (coor/10 == 5) {
            sCoor += "e";
            sCoor += (coor - 50);
        }
        
        if (coor/10 == 6) {
            sCoor += "f";
            sCoor += (coor - 60);
        }
        
        if (coor/10 == 7) {
            sCoor += "g";
            sCoor += (coor - 70);
        }
        
        if (coor/10 == 8) {
            sCoor += "h";
            sCoor += (coor - 80);
        }
        
        this.coor = sCoor.trim().toLowerCase();
    }
    
    /**
     * Gives the x coordinate as an int
     * 
     * @return
     */
    public int getX() {
        if (coor.substring(0, 1).equals("a")) {
            return 1;
        }
        
        if (coor.substring(0, 1).equals("b")) {
            return 2;
        }
        
        if (coor.substring(0, 1).equals("c")) {
            return 3;
        }
        
        if (coor.substring(0, 1).equals("d")) {
            return 4;
        }
        
        if (coor.substring(0, 1).equals("e")) {
            return 5;
        }
        
        if (coor.substring(0, 1).equals("f")) {
            return 6;
        }
        
        if (coor.substring(0, 1).equals("g")) {
            return 7;
        }
        
        return 8;
    }
    
    /**
     * Gives the y coordinate as an int
     * 
     * @return 
     */
    public int getY() {
        return Integer.parseInt(coor.substring(1));
    }

    @Override
    public String toString() {
        return coor;
    }
    
    
}
