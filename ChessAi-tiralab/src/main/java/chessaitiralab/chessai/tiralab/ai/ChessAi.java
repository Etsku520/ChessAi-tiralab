package chessaitiralab.chessai.tiralab.ai;

import chessaitiralab.chessai.tiralab.chess.ChessBoard;
import chessaitiralab.chessai.tiralab.chess.ChessLogic;
import chessaitiralab.chessai.tiralab.chess.Coordinate;
import chessaitiralab.chessai.tiralab.chess.Move;
import chessaitiralab.chessai.tiralab.chess.Turn;
import chessaitiralab.chessai.tiralab.dataStructure.BetterList;
import chessaitiralab.chessai.tiralab.dataStructure.BetterTree;

/**
 * This will be a glorious AI.
 * 
 * @author hceetuc
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
     * @param chessTree the current situation
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
        chessTree = new BetterTree(new Turn(board, 0, null));
        BetterTree bestTree = makeTreeAndMinMax(chessTree, 3, 0);
        
        chessTree = bestTree;
        chessTree.setParent(chessTree);
        Turn turn = (Turn) chessTree.getO();
        turn.setBoard(board);
        
        System.out.println("best: " + turn.getValue());
        
        
        return turn.getMove();
    }
    
    /**
     * evaluates the value of a turn
     * 
     * @param tree
     * @return points as int
     */
    public int evaluate(BetterTree tree) {
        int value = 0;
        Turn turn = (Turn) tree.getO();
        ChessBoard board = turn.getBoard();
        
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
     * Help class to find answer for min-max
     * 
     * @param tree
     * @param where
     * @param bottom
     * @return 
     */
    public BetterTree minMax(BetterTree tree, int where, boolean bottom) {
        BetterTree bestTree = tree;
        Turn turn = (Turn) tree.getO();
        
        int max = -99999999;
        int min = 99999999;

        if (bottom) {
            for (int j = 0; j < tree.getChildren().size(); j++) {
                BetterTree childTree = (BetterTree) tree.getChildren().get(j);
                Turn childTurn = (Turn) childTree.getO();
                int value = evaluate(childTree);
                childTurn.setValue(value);
                int knights = 0;
                System.out.println("layer: " + (where + 1) + " value: " + value);
                for (int i = 1; i < 9; i++) {
                    for (int k = 1; k < 9; k++) {
                        if (childTurn.getBoard().getBoard()[i][k] == 12) {
                            knights++;
                        } 
                    }
                }
                System.out.println(knights);

                if (where % 2 == 0 && value > max) {
                    max = value;
                    bestTree = childTree;
                    turn.setValue(value);
                } else if (where % 2 == 1 && value < min) {
                    min = value;
                    bestTree = childTree;
                    turn.setValue(value);
                }
            }
            return bestTree;
        }
        return bestTree;
    }
    
    /**
     * Gives tree the given depth . Filled with all the possible moves.
     * It also evaluates the moves, while it's making the tree. Returns the best turn
     * as a tree.
     * 
     * @param tree
     * @param depth the depth of the tree in making
     * @param where depth we are at now (starts form 0)
     * @return 
     */
    public BetterTree makeTreeAndMinMax(BetterTree tree, int depth, int where) {
        BetterTree bestTree = tree;
        Turn turn = (Turn) tree.getO();
        turn.setValue(null);
        
        if (tree.getChildren().size() == 0) {
            
            if (where % 2 == 0) {
                allMoves(tree, player);
            } else {
                allMoves(tree, Math.abs(player - 1));
            }
        }
        
        if (where == depth - 1) {
            return minMax(tree, where, true);
        }
        
        int max = -99999999;
        int min = 99999999;
        for (int j = 0; j < tree.getChildren().size(); j++) {
            BetterTree childTree = (BetterTree) tree.getChildren().get(j);
            makeTreeAndMinMax(childTree, depth ,where + 1);
            Turn childTurn = (Turn) childTree.getO();
            Integer childValue = childTurn.getValue();
            System.out.println("layer: " + (where + 1) + " value: " + childValue);
            int knights = 0;

            for (int i = 1; i < 9; i++) {
                for (int k = 1; k < 9; k++) {
                    if (childTurn.getBoard().getBoard()[i][k] == 12) {
                        knights++;
                    } 
                }
            }
            System.out.println(knights);
            
            if (childValue == null) {
                if (where % 2 == 0 && max == -99999999)  {
                    bestTree = childTree;
                    max = -90000;
                    turn.setValue(-90000);
                } else if (where % 2 == 1 && min == 99999999) {
                    turn.setValue(90000);
                    min = 90000;
                    bestTree = childTree;
                }
            } else {
                if (where % 2 == 0 && childValue > max) {
                    max = childValue;
                    bestTree = childTree;
                    turn.setValue(childValue);
                }
                
                if (where % 2 == 1 && childValue < min) {
                    min = childValue;
                    bestTree = childTree;
                    turn.setValue(childValue);
                }
            }
        }
        
        return bestTree;
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
                Turn turn = (Turn) tree.getO();
                Coordinate cood = new Coordinate (j * 10 + i);
                BetterList endCoods = logic.checkMove(cood, turn.getBoard(), whichPlayer);
                
                for (int k = 0; k < endCoods.size(); k++) {
                    
                    ChessBoard childBoard = new ChessBoard(turn.getBoard());
                    int eaten = childBoard.movePiece(new Move(cood, ((Coordinate) endCoods.get(k))));
                    
                    BetterTree child = new BetterTree(new Turn(childBoard, eaten, new Move(cood, ((Coordinate) endCoods.get(k)))));
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

    public void setChessTree(BetterTree chessTree) {
        Turn turn = (Turn) chessTree.getO();
        turn.setBoard(board);
        
        this.chessTree = chessTree;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public BetterTree getChessTree() {
        return chessTree;
    }
    
    
}
