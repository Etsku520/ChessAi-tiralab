/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessaitiralab.chessai.tiralab.benchmark;

import chessaitiralab.chessai.tiralab.ai.ChessAi;
import chessaitiralab.chessai.tiralab.chess.ChessBoard;
import chessaitiralab.chessai.tiralab.chess.ChessLogic;
import chessaitiralab.chessai.tiralab.chess.Turn;
import chessaitiralab.chessai.tiralab.dataStructure.BetterTree;

/**
 * Class that is used for seeing how long it takes to make a tree.
 * 
 * @author hceetu
 */
public class TreeAndMinMaxBenchmark {
    
    public void timing(int depth) {
        ChessBoard board = new ChessBoard();
        ChessLogic logic = new ChessLogic();
        BetterTree tree = new BetterTree(new Turn(board, 0, null));
        ChessAi bot = new ChessAi(tree, board, logic, 0);
        
        long start = System.nanoTime();
        bot.makeTreeAndMinMax(tree, depth, 0);
        long elapsedTime = System.nanoTime() - start;   
        
        System.out.println((elapsedTime/1000000l) + "ms");
    }
}
