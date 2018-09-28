package chessaitiralab.chessai.tiralab.chess.userInterface;

import chessaitiralab.chessai.tiralab.ai.ChessAi;
import chessaitiralab.chessai.tiralab.dataStructure.BetterList;
import chessaitiralab.chessai.tiralab.chess.ChessBoard;
import chessaitiralab.chessai.tiralab.chess.ChessLogic;
import chessaitiralab.chessai.tiralab.chess.Coordinate;
import chessaitiralab.chessai.tiralab.chess.Move;
import chessaitiralab.chessai.tiralab.dataStructure.BetterTree;
import java.util.Scanner;

/**
 * User interface used to play chess.
 * 
 * @author hceetu
 */
public class UserInt {
    private ChessBoard board;
    private Scanner reader;
    

    public UserInt(ChessBoard board, Scanner reader) {
        this.board = board;
        this.reader = reader;
    }
    /**
     * starts the interface (and the menu)
     */
    public void start() {
        System.out.println("Welcome to chess!");
        String command = "";
        
        while(!command.equals("e")) {
            System.out.println("You can give the following commands now:\n"
                    + "s - for starting the game (not actully playable)\n"
                    + "e - for exit\n");

            command = reader.nextLine().trim().toLowerCase();

            if (command.equals("s")) {
                game();
            }

            else if (command.equals("e")) {
                System.out.println("\nGonna exit");
            }

            else {
                System.out.println("\nTry again");
            }
        }
        
    }
    
    /**
     * starts the game of chess itself
     */
    public void game() {
        ChessLogic logic = new ChessLogic();
        ChessAi bot = new ChessAi(new BetterTree(board, 0, 0), board, logic, 0);
        
        board.reset();
        System.out.println("Let the chess begin (btw king is now monarch because 'k' was taken by knight)");
        Coordinate cood1 = new Coordinate("d8");
        Coordinate cood2 = new Coordinate("e3");
        Move move2 = new Move(cood1, cood2);
        board.movePiece(move2);
        drawBoard();
        
        while (true) {
            logic.pawnQueens(board);
            drawBoard();
            
            while (true) {
                System.out.println("What do you want to move? (for example 'a2')");
                String coordinate = reader.nextLine();
                String test1 = "abcdefgh";
                String test2 = "12345678";

                if(coordinate.trim().toLowerCase().equals("stop")) {
                    break;
                }
                
                if (coordinate.length() == 2 && test1.contains(coordinate.substring(0, 1)) 
                        && test2.contains(coordinate.substring(1, 2))) {
                    Coordinate cood = new Coordinate(coordinate);
                    BetterList moveList = logic.checkMove(cood, board, 1);
                    System.out.println(moveList);
                    System.out.println("Give the number of the place you want to move to, 0 cancels your choice");
                    int number = -1;

                    try {
                        number = Integer.parseInt(reader.nextLine());
                    } catch (Exception e) {
                        System.out.println("That is no number");
                    }
                    
                    if (number <= 0) {
                        continue;
                    }

                    if (number <= moveList.size()) {
                        Move move = new Move(cood, (Coordinate) moveList.get(number - 1));
                        board.movePiece(move);
                        break;
                    } else {
                        System.out.println("index out of bounds");
                    }

                } else {
                    System.out.println("Not a valid coordinate\n");
                }
            }
            
            Move move = bot.nextMove();
            
            System.out.println(move.getCoodA());
            System.out.println(move.getCoodL());
            
            board.movePiece(move);
            
        }
    }
    
    /**
     * This draws the board for the interface
     */
    public void drawBoard() {
        for (int i = 8; i > 0; i--) {
            System.out.print(i + " |");
            for (int j = 1; j < 9; j++) {
                if (board.getBoard()[i][j] == 1) {
                    System.out.print("p ");
                } else if (board.getBoard()[i][j] == 2) {
                    System.out.print("k ");
                } else if (board.getBoard()[i][j] == 3) {
                    System.out.print("b ");
                } else if (board.getBoard()[i][j] == 4) {
                    System.out.print("r ");
                } else if (board.getBoard()[i][j] == 5) {
                    System.out.print("q ");
                } else if (board.getBoard()[i][j] == 6) {
                    System.out.print("m ");
                } else if (board.getBoard()[i][j] == 11) {
                    System.out.print("P ");
                } else if (board.getBoard()[i][j] == 12) {
                    System.out.print("K ");
                } else if (board.getBoard()[i][j] == 13) {
                    System.out.print("B ");
                } else if (board.getBoard()[i][j] == 14) {
                    System.out.print("R ");
                } else if (board.getBoard()[i][j] == 15) {
                    System.out.print("Q ");
                } else if (board.getBoard()[i][j] == 16) {
                    System.out.print("M ");
                } else {
                    System.out.print("0 ");
                }
                
            }
            System.out.println("");
        }
        System.out.println("   ---------------\n"
                + "   a b c d e f g h");
    }
    
}
