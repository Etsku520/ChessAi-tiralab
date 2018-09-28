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
        Coordinate cood = new Coordinate(62);
        
        BetterList list = new BetterList();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        list.add(1);
        list.add(4);
        list.add(6);
        list.add(7);
        list.add(2);
        list.remove(2);
        System.out.println(list.get(2));
        System.out.println("Size: " + list.size());
        System.out.println(list.toString());
        System.out.println(cood);
        
        
        inter.start();
    }
    
}
