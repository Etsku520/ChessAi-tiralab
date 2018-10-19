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
        this.bot0 = new ChessAi(new BetterTree(new Turn(board, 0, null)), board, logic, 0);
        this.bot1 = new ChessAi(new BetterTree(new Turn(board, 0, null)), board, logic, 1);
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
        Move move;
        int eaten;
        if (player == 0) {
            move = bot0.nextMove();
            eaten = board.movePiece(move);
            bot1.setChessTree(bot0.getChessTree());
        } else {
            move = bot1.nextMove();
            eaten = board.movePiece(move);
            bot0.setChessTree(bot1.getChessTree());
        }
        System.out.println(move.getCoodB() + " to " + move.getCoodE());
        
        if (eaten == 6 || eaten == 16) {
            return player;
        }
        
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
        
        int eaten = board.movePiece(move);
        
        if (eaten == 16) {
            return player;
        }
        
        for (int i = 0; i < bot0.getChessTree().getChildren().size(); i++) {
            BetterTree newTree = (BetterTree) bot0.getChessTree().getChildren().get(i);
            Turn turnValues = (Turn) newTree.getO();
            if (turnValues.getMove().equals(move)) {
                newTree.setParent(newTree);
                bot0.setChessTree(newTree);
                break;
            }
        }
        
        if (logic.checkMate(board, Math.abs(player - 1))) {
            return player;
        }
        
        return -1;
    }
}
