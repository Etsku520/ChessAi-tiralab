/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessaitiralab.chessai.tiralab.ai;

/**
 * creates evaluation matrixes
 * 
 * @author hceetu
 */
public class EvaMatrixCreator {
    /**
     * creates the evaluating matrix for pawns and returns it
     * 
     * @return 
     */
    public int[][] createPawnMatrix() {
        int[][] evaPawn = new int[9][9];
        
        evaPawn[2][1] = -5;
        evaPawn[2][2] = -10;
        evaPawn[2][3] = -10;
        evaPawn[2][4] = 20;
        evaPawn[2][5] = 20;
        evaPawn[2][6] = -10;
        evaPawn[2][7] = -10;
        evaPawn[2][8] = -5;
        evaPawn[3][1] = -5;
        evaPawn[3][2] = 5;
        evaPawn[3][3] = 10;
        evaPawn[3][6] = 10;
        evaPawn[3][7] = 5;
        evaPawn[3][8] = -5;
        evaPawn[4][4] = -20;
        evaPawn[4][5] = -20;
        evaPawn[5][1] = -5;
        evaPawn[5][2] = -5;
        evaPawn[5][3] = -10;
        evaPawn[5][4] = -25;
        evaPawn[5][5] = -25;
        evaPawn[5][6] = -10;
        evaPawn[5][7] = -5;
        evaPawn[5][8] = -5;
        evaPawn[6][1] = -10;
        evaPawn[6][2] = -10;
        evaPawn[6][3] = -20;
        evaPawn[6][4] = -30;
        evaPawn[6][5] = -30;
        evaPawn[6][6] = -20;
        evaPawn[6][7] = -10;
        evaPawn[6][8] = -10;
        evaPawn[7][1] = -50;
        evaPawn[7][2] = -50;
        evaPawn[7][3] = -50;
        evaPawn[7][4] = -50;
        evaPawn[7][5] = -50;
        evaPawn[7][6] = -50;
        evaPawn[7][7] = -50;
        evaPawn[7][8] = -50;
        evaPawn[8][1] = -50;
        evaPawn[8][2] = -50;
        evaPawn[8][3] = -50;
        evaPawn[8][4] = -50;
        evaPawn[8][5] = -50;
        evaPawn[8][6] = -50;
        evaPawn[8][7] = -50;
        evaPawn[8][8] = -50;
        
        return evaPawn;
    }
    
    /**
     * creates the evaluating matrix for knights and returns it
     * @return 
     */
    public int[][] createKnightMatrix() {
        int[][] evaKnight = new int[9][9];
        
        evaKnight[1][1] = 50;
        evaKnight[1][2] = 40;
        evaKnight[1][3] = 30;
        evaKnight[1][4] = 30;
        evaKnight[1][5] = 30;
        evaKnight[1][6] = 30;
        evaKnight[1][7] = 40;
        evaKnight[1][8] = 50;
        evaKnight[2][1] = 40;
        evaKnight[2][2] = 20;
        evaKnight[2][4] = -5;
        evaKnight[2][5] = -5;
        evaKnight[2][7] = 20;
        evaKnight[2][8] = 40;
        evaKnight[3][1] = 30;
        evaKnight[3][2] = -5;
        evaKnight[3][3] = -10;
        evaKnight[3][4] = -15;
        evaKnight[3][5] = -15;
        evaKnight[3][6] = -10;
        evaKnight[3][7] = -5;
        evaKnight[3][8] = 30;
        evaKnight[4][1] = 30;
        evaKnight[4][3] = -15;
        evaKnight[4][4] = -20;
        evaKnight[4][5] = -20;
        evaKnight[4][6] = -15;
        evaKnight[4][8] = 30;
        evaKnight[5][1] = 30;
        evaKnight[5][2] = -5;
        evaKnight[5][3] = -15;
        evaKnight[5][4] = -20;
        evaKnight[5][5] = -20;
        evaKnight[5][6] = -15;
        evaKnight[5][7] = -5;
        evaKnight[5][8] = 30;
        evaKnight[6][1] = 30;
        evaKnight[6][3] = -10;
        evaKnight[6][4] = -15;
        evaKnight[6][5] = -15;
        evaKnight[6][6] = -10;
        evaKnight[6][8] = 30;
        evaKnight[7][1] = 40;
        evaKnight[7][2] = 20;
        evaKnight[7][7] = 20;
        evaKnight[7][8] = 40;
        evaKnight[8][1] = 50;
        evaKnight[8][2] = 40;
        evaKnight[8][3] = 30;
        evaKnight[8][4] = 30;
        evaKnight[8][5] = 30;
        evaKnight[8][6] = 30;
        evaKnight[8][7] = 40;
        evaKnight[8][8] = 50; 
        
        return evaKnight;
    }
    
    /**
     * creates the evaluating matrix for bishops and returns it
     * 
     * @return 
     */
    public int[][] createBishopMatrix() {
        int[][] evaBishop = new int[9][9];
        
        evaBishop[1][1] = 20;
        evaBishop[1][2] = 10;
        evaBishop[1][3] = 10;
        evaBishop[1][4] = 10;
        evaBishop[1][5] = 10;
        evaBishop[1][6] = 10;
        evaBishop[1][7] = 10;
        evaBishop[1][8] = 20;
        evaBishop[2][1] = 10;
        evaBishop[2][2] = -5;
        evaBishop[2][7] = -5;
        evaBishop[2][8] = -10;
        evaBishop[3][1] = 10;
        evaBishop[3][2] = -10;
        evaBishop[3][3] = -10;
        evaBishop[3][4] = -10;
        evaBishop[3][5] = -10;
        evaBishop[3][6] = -10;
        evaBishop[3][7] = -10;
        evaBishop[3][8] = 10;
        evaBishop[4][1] = 10;
        evaBishop[4][3] = -10;
        evaBishop[4][4] = -10;
        evaBishop[4][5] = -10;
        evaBishop[4][6] = -10;
        evaBishop[4][8] = 10;
        evaBishop[5][1] = 10;
        evaBishop[5][2] = -5;
        evaBishop[5][3] = -5;
        evaBishop[5][4] = -10;
        evaBishop[5][5] = -10;
        evaBishop[5][6] = -5;
        evaBishop[5][7] = -5;
        evaBishop[5][8] = 10;
        evaBishop[6][1] = 10;
        evaBishop[6][3] = -5;
        evaBishop[6][4] = -10;
        evaBishop[6][5] = -10;
        evaBishop[6][6] = -5;
        evaBishop[6][8] = 10;
        evaBishop[7][1] = 10;
        evaBishop[7][8] = 10;
        evaBishop[8][1] = 20;
        evaBishop[8][2] = 10;
        evaBishop[8][3] = 10;
        evaBishop[8][4] = 10;
        evaBishop[8][5] = 10;
        evaBishop[8][6] = 10;
        evaBishop[8][7] = 10;
        evaBishop[8][8] = 20; 
        
        return evaBishop;
    }
    
    /**
     * creates the evaluating matrix for rooks and returns it
     * @return 
     */
    public int[][] createRookMatrix() {
        int[][] evaRook = new int[9][9];
        
        evaRook[1][4] = -5;
        evaRook[1][5] = -5;
        evaRook[2][1] = 5;
        evaRook[2][8] = 5;
        evaRook[3][1] = 5;
        evaRook[3][8] = 5;
        evaRook[4][1] = 5;
        evaRook[4][8] = 5;
        evaRook[5][1] = 5;
        evaRook[5][8] = 5;
        evaRook[6][1] = 5;
        evaRook[6][8] = 5;
        evaRook[7][1] = -5;
        evaRook[7][2] = -10;
        evaRook[7][3] = -10;
        evaRook[7][4] = -10;
        evaRook[7][5] = -10;
        evaRook[7][6] = -10;
        evaRook[7][7] = -10;
        evaRook[7][8] = -5;
        
        return evaRook;
    }
    
    /**
     * creates the evaluating matrix for queens and returns it
     * @return 
     */
    public int[][] createQueenMartix() {
        int[][] evaQueen = new int[9][9];
        
        evaQueen[1][1] = 20;
        evaQueen[1][2] = 10;
        evaQueen[1][3] = 10;
        evaQueen[1][4] = 5;
        evaQueen[1][5] = 5;
        evaQueen[1][6] = 10;
        evaQueen[1][7] = 10;
        evaQueen[1][8] = 20;
        evaQueen[2][2] = -5;
        evaQueen[2][8] = 10;
        evaQueen[3][1] = 10;
        evaQueen[3][2] = -5;
        evaQueen[3][3] = -5;
        evaQueen[3][4] = -5;
        evaQueen[3][5] = -5;
        evaQueen[3][6] = -5;
        evaQueen[3][8] = 10;
        evaQueen[4][3] = -5;
        evaQueen[4][4] = -5;
        evaQueen[4][5] = -5;
        evaQueen[4][6] = -5;
        evaQueen[4][8] = -5;
        evaQueen[5][1] = 5;
        evaQueen[5][3] = -5;
        evaQueen[5][4] = -5;
        evaQueen[5][5] = -5;
        evaQueen[5][6] = -5;
        evaQueen[5][8] = 5;
        evaQueen[6][1] = 10;
        evaQueen[6][3] = -5;
        evaQueen[6][4] = -5;
        evaQueen[6][5] = -5;
        evaQueen[6][6] = -5;
        evaQueen[6][8] = 10;
        evaQueen[7][1] = 10;
        evaQueen[7][8] = 10;
        evaQueen[8][1] = 20;
        evaQueen[8][2] = 10;
        evaQueen[8][3] = 10;
        evaQueen[8][4] = 5;
        evaQueen[8][5] = 5;
        evaQueen[8][6] = 10;
        evaQueen[8][7] = 10;
        evaQueen[8][8] = 20;
        
        return evaQueen;
    }
    
    /**
     * creates the evaluating matrix for kings and returns it
     * @return 
     */
    public int[][] createKingMatrix() {
        int[][] evaKing = new int[9][9];
        
        evaKing[1][1] = -20;
        evaKing[1][2] = -30;
        evaKing[1][3] = -10;
        evaKing[1][6] = -10;
        evaKing[1][7] = -30;
        evaKing[1][8] = -20;
        evaKing[2][1] = -20;
        evaKing[2][2] = -20;
        evaKing[2][7] = -20;
        evaKing[3][8] = -20;
        evaKing[3][1] = 10;
        evaKing[3][2] = 20;
        evaKing[3][3] = 20;
        evaKing[3][4] = 20;
        evaKing[3][5] = 20;
        evaKing[3][6] = 20;
        evaKing[3][7] = 20;
        evaKing[3][8] = 10;
        evaKing[4][1] = 20;
        evaKing[4][2] = 30;
        evaKing[4][3] = 30;
        evaKing[4][4] = 40;
        evaKing[4][5] = 40;
        evaKing[4][6] = 30;
        evaKing[4][7] = 30;
        evaKing[4][8] = 20;
        evaKing[5][1] = 30;
        evaKing[5][2] = 40;
        evaKing[5][3] = 40;
        evaKing[5][4] = 50;
        evaKing[5][5] = 50;
        evaKing[5][6] = 40;
        evaKing[5][7] = 40;
        evaKing[5][8] = 30;
        evaKing[6][1] = 30;
        evaKing[6][2] = 40;
        evaKing[6][3] = 40;
        evaKing[6][4] = 50;
        evaKing[6][5] = 50;
        evaKing[6][6] = 40;
        evaKing[6][7] = 40;
        evaKing[6][8] = 30;
        evaKing[7][1] = 30;
        evaKing[7][2] = 40;
        evaKing[7][3] = 40;
        evaKing[7][4] = 50;
        evaKing[7][5] = 50;
        evaKing[7][6] = 40;
        evaKing[7][7] = 40;
        evaKing[7][8] = 30;
        evaKing[8][1] = 30;
        evaKing[8][2] = 40;
        evaKing[8][3] = 40;
        evaKing[8][4] = 50;
        evaKing[8][5] = 50;
        evaKing[8][6] = 40;
        evaKing[8][7] = 40;
        evaKing[8][8] = 30;
        
        return evaKing;
    }
}
