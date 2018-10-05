package chessaitiralab.chessai.tiralab.ai;

import chessaitiralab.chessai.tiralab.chess.ChessBoard;
import chessaitiralab.chessai.tiralab.chess.ChessLogic;
import chessaitiralab.chessai.tiralab.chess.Coordinate;
import chessaitiralab.chessai.tiralab.chess.Move;
import chessaitiralab.chessai.tiralab.dataStructure.BetterList;
import chessaitiralab.chessai.tiralab.dataStructure.BetterTree;
import java.util.Random;

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

    /**
     * Constructor for ChessAi
     * 
     * @param chessTree the current sitsuation
     * @param board the board
     * @param logic 
     * @param player 
     */
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
        Random rand = new Random();
        chessTree = new BetterTree(board, null, null);
        makeTree(chessTree, 2);
        int best = -99999999;
        Move move = null;
        BetterTree newTree = null;
        BetterList bestMoves = new BetterList();
        
        for (int i = 0; i < chessTree.getChildren().size(); i++) {
            BetterTree tree = (BetterTree) chessTree.getChildren().get(i);
            int value = minMaxDive(tree, 1);
            System.out.println(value);
            
            if (value > best) {
                best = value;
                bestMoves = new BetterList();
                newTree = tree;
                bestMoves.add((Move) tree.getO3());
            }
            
            if (value == best) {
                bestMoves.add((Move) tree.getO3());
            }
        }
        
        move = (Move) bestMoves.get(rand.nextInt(bestMoves.size()));
        
        chessTree = newTree;
        
        return move;
    }
    
    /**
     * It is basically a depth-first search that at the same time uses the
     * evaluation and min-max
     * 
     */
    public int minMaxDive(BetterTree tree, int depth) {
        if (tree.getChildren().size() == 0) {
            int vale = evaluate(tree);
            return vale;
        }
               
        if (depth % 2 == 0) {
            int max = -999999;
            for (int i = 0; i < tree.getChildren().size(); i++) {
                int value = minMaxDive((BetterTree) tree.getChildren().get(i), depth + 1);
                
                if (value > max) {
                    max = value;
                }
                
            }
            
            return max;
        }
        
        int min = 99999;
        for (int i = 0; i < tree.getChildren().size(); i++) {
            int value = minMaxDive((BetterTree) tree.getChildren().get(i), depth + 1);
             
            if (value < min) {
                min = value;
            }
        }
        
        return min;
    }
    
    /**
     * evaluates the value of a turn
     * 
     * @param tree
     * @return points as int
     */
    public int evaluate(BetterTree tree) {
        int value = 0;
        int eaten = (int) tree.getO2();
        ChessBoard board = (ChessBoard) tree.getO1();
        
        if (logic.checkMate(board, 0)) {
            value -= 9000;
        }
        
        if (logic.checkMate(board, 1)) {
            value += 9000;
        }
        
        
        for(int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                
                if (player == 1) {
                    int piece = board.getBoard()[i][j];
                    
                    switch (piece) {
                        case 1:
                            value -= 100;
                            value += evaPawn[i][j];
                            break;
                        case 2:
                            value -= 300;
                            value += evaKnight[i][j];
                            break;
                        case 3:
                            value -= 300;
                            value += evaBishop[i][j];
                            break;
                        case 4:
                            value -= 500;
                            value += evaRook[i][j];
                            break;
                        case 5:
                            value -= 900;
                            value += evaQueen[i][j];
                            break;
                        case 6:
                            value -= 9000;
                            value += evaKing[i][j];
                            break;
                        case 11:
                            value += 100;
                            break;
                        case 12:
                            value += 300;
                            break;
                        case 13:
                            value += 300;
                            break;
                        case 14:
                            value += 500;
                            break;
                        case 15:
                            value += 900;
                            break;
                        case 16:
                            value += 9000;
                            break;
                        default:
                            break;
                    }
                }
                
                if (player == 0) {
                    int piece = board.getBoard()[9-i][j];
                    
                    switch (piece) {
                        case 1:
                            value -= 100;
                            break;
                        case 2:
                            value -= 300;
                            break;
                        case 3:
                            value -= 300;
                            break;
                        case 4:
                            value -= 500;
                            break;
                        case 5:
                            value -= 900;
                            break;
                        case 6:
                            value -= 9000;
                            break;
                        case 11:
                            value += 100;
                            value -= evaPawn[9-i][j];
                            break;
                        case 12:
                            value += 300;
                            value -= evaKnight[9-i][j];
                            break;
                        case 13:
                            value += 300;
                            value -= evaBishop[9-i][j];
                            break;
                        case 14:
                            value += 500;
                            value -= evaRook[9-i][j];
                            break;
                        case 15:
                            value += 900;
                            value -= evaQueen[9-i][j];
                            break;
                        case 16:
                            value += 9000;
                            value -= evaKing[9-i][j];
                            break;
                        default:
                            break;
                    }
                }
            }
        }        
        
        if (player == 1) {
            return -1 * value;
        }
        
        return value;
    }
    
    /**
     * Gives the tree i + 1 layers. Filled with all the possible moves.
     * Also this only works properly if the i is even number.
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
                    ChessBoard childBoard = new ChessBoard((ChessBoard) tree.getO1());
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
        EvaMatrixCreator creator = new EvaMatrixCreator();
        evaPawn = creator.createPawnMatrix();
        evaKnight = creator.createKnightMatrix();
        evaBishop = creator.createBishopMatrix();
        evaRook = creator.createRookMatrix();
        evaQueen = creator.createQueenMartix();
        evaKing = creator.createKingMatrix();
        
    }
}
