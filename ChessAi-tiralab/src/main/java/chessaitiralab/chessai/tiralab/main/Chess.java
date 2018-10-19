/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessaitiralab.chessai.tiralab.main;

import chessaitiralab.chessai.tiralab.ai.ChessAi;
import chessaitiralab.chessai.tiralab.dataStructure.BetterList;
import chessaitiralab.chessai.tiralab.chess.ChessBoard;
import chessaitiralab.chessai.tiralab.chess.Coordinate;
import chessaitiralab.chessai.tiralab.chess.Move;
import chessaitiralab.chessai.tiralab.chess.userInterface.UserInt;
import java.util.Scanner;

/**
 *
 * @author hceetu
 */
public class Chess {
    
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        Scanner reader = new Scanner(System.in);
        UserInt inter = new UserInt(board, reader);
        
        inter.start();
    }
    
}
