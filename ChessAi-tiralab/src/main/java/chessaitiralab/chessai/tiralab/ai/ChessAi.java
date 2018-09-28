package chessaitiralab.chessai.tiralab.ai;

import chessaitiralab.chessai.tiralab.chess.ChessBoard;
import chessaitiralab.chessai.tiralab.chess.ChessLogic;
import chessaitiralab.chessai.tiralab.chess.Coordinate;
import chessaitiralab.chessai.tiralab.chess.Move;
import chessaitiralab.chessai.tiralab.dataStructure.BetterList;
import chessaitiralab.chessai.tiralab.dataStructure.BetterTree;

/**
 * This will be a glorious AI.
 * 
 * @author hceetu
 */
public class ChessAi {
    BetterTree chessTree;
    ChessBoard board;
    ChessLogic logic;
    int[][] evaKing;
    int[][] evaRook;
    int[][] evaQueen;
    int[][] evaKnight;
    int[][] evaBishop;
    int[][] evaPawn;
    int player;

    public ChessAi(BetterTree chessTree, ChessBoard board, ChessLogic logic, int player) {
        this.chessTree = chessTree;
        this.board = board;
        this.logic = logic;
        this.player = player;
        
         
        evaKing = new int[9][9];
        evaRook = new int[9][9];
        evaQueen = new int[9][9];
        evaKnight = new int[9][9];
        evaBishop= new int[9][9];
        evaPawn = new int[9][9];
        
        createEvaMatrixes();
    }
    /**
     * Finds the next move the bot makes
     * 
     * @return move
     */
    public Move nextMove() {
        makeTree(chessTree, 2);
        int best = -99999999;
        Move move = null;
        BetterTree newTree = null;
        
        for (int i = 0; i < chessTree.getChildren().size(); i++) {
            BetterTree tree = (BetterTree) chessTree.getChildren().get(i);
            int evaluation = evaluate(tree);
            if (evaluation > best) {
                best = evaluation;
                move = (Move) tree.getO3();
                newTree = tree;
            }
        }
        
        chessTree = newTree;
        
        return move;
    }
    
    /**
     * evaluates a turn
     * 
     * @param tree
     * @return points as int
     */
    public int evaluate(BetterTree tree) {
        int value = 0;
        int eaten = (int) tree.getO2();
        ChessBoard board = (ChessBoard) tree.getO1();
        

        switch (eaten) {
            case 1:
                value += 100;
                break;
            case 2:
                value += 300;
                break;
            case 3:
                value += 300;
                break;
            case 4:
                value += 500;
                break;
            case 5:
                value += 900;
                break;
            case 6:
                value += 9000;
                break;
            case 11:
                value -= 100;
                break;
            case 12:
                value -= 300;
                break;
            case 13:
                value -= 300;
                break;
            case 14:
                value -= 500;
                break;
            case 15:
                value -= 900;
                break;
            case 16:
                value -= 9000;
                break;
            default:
                break;
        }
        
        if (logic.checkMate(board, 2)) {
            value -= 900;
        }
        
        if (logic.checkMate(board, 1)) {
            value += 900;
        }
        
        
        for(int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                int piece = board.getBoard()[i][j];
                if (player == 1) {
                    if (piece == 1) {
                        value += evaPawn[i][j];
                    }
                    
                    if (piece == 2) {
                        value += evaKnight[i][j];
                    }
                    
                    if (piece == 3) {
                        value += evaBishop[i][j];
                    }
                    
                    if (piece == 4) {
                        value += evaRook[i][j];
                    }
                    
                    if (piece == 5) {
                        value += evaQueen[i][j];
                    }
                    
                    if (piece == 6) {
                        value += evaKing[i][j];
                    }
                }
                
                if (player == 0) {
                    if (piece == 11) {
                        value -= evaPawn[9-i][j];
                    }
                    
                    if (piece == 12) {
                        value -= evaKnight[9-i][j];
                    }
                    
                    if (piece == 13) {
                        value -= evaBishop[9-i][j];
                    }
                    
                    if (piece == 14) {
                        value -= evaRook[9-i][j];
                    }
                    
                    if (piece == 15) {
                        value -= evaQueen[9-i][j];
                    }
                    
                    if (piece == 16) {
                        value -= evaKing[9-i][j];
                    }
                }
            }
        }
        
        for (int i = 0; i < tree.getChildren().size(); i++) {
            if (player == 1) {
                value -= evaluate((BetterTree) tree.getChildren().get(i));
            } else {
                value += evaluate((BetterTree) tree.getChildren().get(i));
            }
        }
        
        
        if (player == 1) {
            return -1 * value;
        }
        
        return value;
    }
    
    /**
     * Gives the tree i + 1 layers. Filled with all the possible moves.
     * 
     * @param tree
     * @param i 
     */
    public void makeTree(BetterTree tree, int i) {
        if (i % 2 == 0) {
            allMoves(tree, player);
        } else {
            allMoves(tree, Math.abs(player - 1));
        }
        
        if (i == 0) {
            return;
        }
        
        for (int j = 0; j < tree.getChildren().size(); j++) {
            makeTree((BetterTree) tree.getChildren().get(j), i - 1);
        }
    }
    
    /**
     * Checks all the possible next moves of one side
     * and adds them as children to the tree.
     * 
     * @param tree the tree you want to use
     * @param whichPlayer the player whose moves are simulated
     */
    public void allMoves(BetterTree tree, int whichPlayer) {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                Coordinate cood = new Coordinate (j * 10 + i);
                BetterList endCoods = logic.checkMove(cood, board, whichPlayer);
                
                for (int k = 0; k < endCoods.size(); k++) {
                    ChessBoard childBoard = new ChessBoard(board);
                    int eaten = childBoard.movePiece(new Move(cood, ((Coordinate) endCoods.get(k))));
                    
                    BetterTree child = new BetterTree(childBoard, eaten, new Move(cood, ((Coordinate) endCoods.get(k))));
                    tree.addChild(child);
                }
            }
        }
    }
    
    /**
     * Create matrixes used in evaluating position of pieces.
     */
    public void createEvaMatrixes() {
        createPawnMatrix();
        createKnightMatrix();
        createBishopMatrix();
        createRookMatrix();
        createQueenMartix();
        createKingMatrix();
        
    }
    /**
     * create the evaluating matrix for pawns
     */
    public void createPawnMatrix() {
        evaPawn[1][1] = 0;
        evaPawn[1][2] = 0;
        evaPawn[1][3] = 0;
        evaPawn[1][4] = 0;
        evaPawn[1][5] = 0;
        evaPawn[1][6] = 0;
        evaPawn[1][7] = 0;
        evaPawn[1][8] = 0;
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
        evaPawn[3][4] = 0;
        evaPawn[3][5] = 0;
        evaPawn[3][6] = 10;
        evaPawn[3][7] = 5;
        evaPawn[3][8] = -5;
        evaPawn[4][1] = 0;
        evaPawn[4][2] = 0;
        evaPawn[4][3] = 0;
        evaPawn[4][4] = -20;
        evaPawn[4][5] = -20;
        evaPawn[4][6] = 0;
        evaPawn[4][7] = 0;
        evaPawn[4][8] = 0;
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
        
    }
    
    /**
     * create the evaluating matrix for knights
     */
    public void createKnightMatrix() {
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
        evaKnight[2][3] = 0;
        evaKnight[2][4] = -5;
        evaKnight[2][5] = -5;
        evaKnight[2][6] = 0;
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
        evaKnight[4][2] = 0;
        evaKnight[4][3] = -15;
        evaKnight[4][4] = -20;
        evaKnight[4][5] = -20;
        evaKnight[4][6] = -15;
        evaKnight[4][7] = 0;
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
        evaKnight[6][2] = 0;
        evaKnight[6][3] = -10;
        evaKnight[6][4] = -15;
        evaKnight[6][5] = -15;
        evaKnight[6][6] = -10;
        evaKnight[6][7] = 0;
        evaKnight[6][8] = 30;
        evaKnight[7][1] = 40;
        evaKnight[7][2] = 20;
        evaKnight[7][3] = 0;
        evaKnight[7][4] = 0;
        evaKnight[7][5] = 0;
        evaKnight[7][6] = 0;
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
    }
    
    /**
     * create the evaluating matrix for bishops
     */
    public void createBishopMatrix() {
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
        evaBishop[2][3] = 0;
        evaBishop[2][4] = 0;
        evaBishop[2][5] = 0;
        evaBishop[2][6] = 0;
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
        evaBishop[4][2] = 0;
        evaBishop[4][3] = -10;
        evaBishop[4][4] = -10;
        evaBishop[4][5] = -10;
        evaBishop[4][6] = -10;
        evaBishop[4][7] = 0;
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
        evaBishop[6][2] = 0;
        evaBishop[6][3] = -5;
        evaBishop[6][4] = -10;
        evaBishop[6][5] = -10;
        evaBishop[6][6] = -5;
        evaBishop[6][7] = 0;
        evaBishop[6][8] = 10;
        evaBishop[7][1] = 10;
        evaBishop[7][2] = 0;
        evaBishop[7][3] = 0;
        evaBishop[7][4] = 0;
        evaBishop[7][5] = 0;
        evaBishop[7][6] = 0;
        evaBishop[7][7] = 0;
        evaBishop[7][8] = 10;
        evaBishop[8][1] = 20;
        evaBishop[8][2] = 10;
        evaBishop[8][3] = 10;
        evaBishop[8][4] = 10;
        evaBishop[8][5] = 10;
        evaBishop[8][6] = 10;
        evaBishop[8][7] = 10;
        evaBishop[8][8] = 20; 
    }
    
    /**
     * create the evaluating matrix for rooks
     */
    public void createRookMatrix() {
        evaRook[1][1] = 0;
        evaRook[1][2] = 0;
        evaRook[1][3] = 0;
        evaRook[1][4] = -5;
        evaRook[1][5] = -5;
        evaRook[1][6] = 0;
        evaRook[1][7] = 0;
        evaRook[1][8] = 0;
        evaRook[2][1] = 5;
        evaRook[2][2] = 0;
        evaRook[2][3] = 0;
        evaRook[2][4] = 0;
        evaRook[2][5] = 0;
        evaRook[2][6] = 0;
        evaRook[2][7] = 0;
        evaRook[2][8] = 5;
        evaRook[3][1] = 5;
        evaRook[3][2] = 0;
        evaRook[3][3] = 0;
        evaRook[3][4] = 0;
        evaRook[3][5] = 0;
        evaRook[3][6] = 0;
        evaRook[3][7] = 0;
        evaRook[3][8] = 5;
        evaRook[4][1] = 5;
        evaRook[4][2] = 0;
        evaRook[4][3] = 0;
        evaRook[4][4] = 0;
        evaRook[4][5] = 0;
        evaRook[4][6] = 0;
        evaRook[4][7] = 0;
        evaRook[4][8] = 5;
        evaRook[5][1] = 5;
        evaRook[5][2] = 0;
        evaRook[5][3] = 0;
        evaRook[5][4] = 0;
        evaRook[5][5] = 0;
        evaRook[5][6] = 0;
        evaRook[5][7] = 0;
        evaRook[5][8] = 5;
        evaRook[6][1] = 5;
        evaRook[6][2] = 0;
        evaRook[6][3] = 0;
        evaRook[6][4] = 0;
        evaRook[6][5] = 0;
        evaRook[6][6] = 0;
        evaRook[6][7] = 0;
        evaRook[6][8] = 5;
        evaRook[7][1] = -5;
        evaRook[7][2] = -10;
        evaRook[7][3] = -10;
        evaRook[7][4] = -10;
        evaRook[7][5] = -10;
        evaRook[7][6] = -10;
        evaRook[7][7] = -10;
        evaRook[7][8] = -5;
        evaRook[8][1] = 0;
        evaRook[8][2] = 0;
        evaRook[8][3] = 0;
        evaRook[8][4] = 0;
        evaRook[8][5] = 0;
        evaRook[8][6] = 0;
        evaRook[8][7] = 0;
        evaRook[8][8] = 0;
    }
    
    /**
     * create the evaluating matrix for queens
     */
    public void createQueenMartix() {
        evaQueen[1][1] = 20;
        evaQueen[1][2] = 10;
        evaQueen[1][3] = 10;
        evaQueen[1][4] = 5;
        evaQueen[1][5] = 5;
        evaQueen[1][6] = 10;
        evaQueen[1][7] = 10;
        evaQueen[1][8] = 20;
        evaQueen[2][1] = 0;
        evaQueen[2][2] = -5;
        evaQueen[2][3] = 0;
        evaQueen[2][4] = 0;
        evaQueen[2][5] = 0;
        evaQueen[2][6] = 0;
        evaQueen[2][7] = 0;
        evaQueen[2][8] = 10;
        evaQueen[3][1] = 10;
        evaQueen[3][2] = -5;
        evaQueen[3][3] = -5;
        evaQueen[3][4] = -5;
        evaQueen[3][5] = -5;
        evaQueen[3][6] = -5;
        evaQueen[3][7] = 0;
        evaQueen[3][8] = 10;
        evaQueen[4][1] = 0;
        evaQueen[4][2] = 0;
        evaQueen[4][3] = -5;
        evaQueen[4][4] = -5;
        evaQueen[4][5] = -5;
        evaQueen[4][6] = -5;
        evaQueen[4][7] = 0;
        evaQueen[4][8] = -5;
        evaQueen[5][1] = 5;
        evaQueen[5][2] = 0;
        evaQueen[5][3] = -5;
        evaQueen[5][4] = -5;
        evaQueen[5][5] = -5;
        evaQueen[5][6] = -5;
        evaQueen[5][7] = 0;
        evaQueen[5][8] = 5;
        evaQueen[6][1] = 10;
        evaQueen[6][2] = 0;
        evaQueen[6][3] = -5;
        evaQueen[6][4] = -5;
        evaQueen[6][5] = -5;
        evaQueen[6][6] = -5;
        evaQueen[6][7] = 0;
        evaQueen[6][8] = 10;
        evaQueen[7][1] = 10;
        evaQueen[7][2] = 0;
        evaQueen[7][3] = 0;
        evaQueen[7][4] = 0;
        evaQueen[7][5] = 0;
        evaQueen[7][6] = 0;
        evaQueen[7][7] = 0;
        evaQueen[7][8] = 10;
        evaQueen[8][1] = 20;
        evaQueen[8][2] = 10;
        evaQueen[8][3] = 10;
        evaQueen[8][4] = 5;
        evaQueen[8][5] = 5;
        evaQueen[8][6] = 10;
        evaQueen[8][7] = 10;
        evaQueen[8][8] = 20;
    }
    
    /**
     * create the evaluating matrix for kings
     */
    public void createKingMatrix() {
        evaKing[1][1] = -20;
        evaKing[1][2] = -30;
        evaKing[1][3] = -10;
        evaKing[1][4] = 0;
        evaKing[1][5] = 0;
        evaKing[1][6] = -10;
        evaKing[1][7] = -30;
        evaKing[1][8] = -20;
        evaKing[2][1] = -20;
        evaKing[2][2] = -20;
        evaKing[2][3] = 0;
        evaKing[2][4] = 0;
        evaKing[2][5] = 0;
        evaKing[2][6] = 0;
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
    }
}
