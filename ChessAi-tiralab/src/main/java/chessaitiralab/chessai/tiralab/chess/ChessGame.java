/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessaitiralab.chessai.tiralab.chess;

import chessaitiralab.chessai.tiralab.ai.ChessAi;
import chessaitiralab.chessai.tiralab.dataStructure.BetterList;
import chessaitiralab.chessai.tiralab.dataStructure.BetterTree;

/**
 * Controls the things happening in game
 * 
 * @author hceetu
 */
public class ChessGame {
    private ChessBoard board;
    private ChessLogic logic;
    private ChessAi bot0;
    private ChessAi bot1;

    public ChessGame(ChessBoard board) {
        this.board = board;
        this.logic = new ChessLogic();
        this.bot0 = new ChessAi(new BetterTree(board, null, null), board, logic, 0);
        this.bot1 = new ChessAi(new BetterTree(board, null, null), board, logic, 1);
    }
    
    /**
     * Gives the possible moves from the given coordinate.
     * It knows the player based on the turn
     * 
     * @param cood
     * @param turn
     * @return 
     */
    public BetterList askMoves(Coordinate cood, int turn) {
        logic.pawnQueens(board);
        int player = turn % 2;
        BetterList moves = logic.checkMove(cood, board, player);
        
        return moves;
    }
    
    /**
     * Method for a bot's turn.
     * It knows the player based on turn and the ai makes a move
     * for the player in question.
     * 
     * @param turn
     * @return -1 normally and player's number of the winner if won.
     */
    public int makeTurn(int turn) {
        logic.pawnQueens(board);
        int player = turn % 2;
        Move move = null;
        if (player == 0) {
            move = bot0.nextMove();
            board.movePiece(move);
        } else {
            move = bot1.nextMove();
            board.movePiece(move);
        }
        System.out.println(move.getCoodB() + " to " + move.getCoodE());
        
        if (logic.checkMate(board, Math.abs(player - 1))) {
            return player;
        }
        
        return -1;
    }
    
    /**
     * Makes based on the give move
     * 
     * @param turn
     * @param move
     * @return -1 normally and player's number of the winner if won.
     */
    public int makeTurn(int turn, Move move) {
        logic.pawnQueens(board);
        int player = turn % 2;
        
        board.movePiece(move);
        
        if (logic.checkMate(board, Math.abs(player - 1))) {
            return player;
        }
        
        return -1;
    }
}
