package chessaitiralab.chessai.tiralab.chess.userInterface;

import chessaitiralab.chessai.tiralab.ai.ChessAi;
import chessaitiralab.chessai.tiralab.benchmark.TreeAndMinMaxBenchmark;
import chessaitiralab.chessai.tiralab.dataStructure.BetterList;
import chessaitiralab.chessai.tiralab.chess.ChessBoard;
import chessaitiralab.chessai.tiralab.chess.ChessGame;
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
                    + "s - for starting the game\n"
                    + "ai - to see 2 bots fighting (they will probably get stuck at somepoint)\n"
                    + "tft - to test the time for making tree\n"
                    + "e - for exit\n");

            command = reader.nextLine().trim().toLowerCase();

            if (command.equals("s")) {
                gamePlayerVsAi();
            }

            else if (command.equals("e")) {
                System.out.println("\nGonna exit");
            }
            
            else if (command.equals("ai")) {
                startAiVsAi();
            }

            else if (command.equals("tft")) {
                timeForTree();
            }
            
            else {
                System.out.println("\nTry again");
            }
        }
        
    }
    
    /**
     * starts the game of chess itself (player vs Ai)
     */
    public void gamePlayerVsAi() {
        board.reset();
        int turn = 1;
        int winner = -1;
        ChessGame game = new ChessGame(board);
        
        System.out.println("Let the chess begin (btw king is now monarch because 'k' was taken by knight)");
        drawBoard();
        
        while (winner == -1) {
            
            
            if(turn % 2 == 1) {
                while (true) {
                    System.out.println("What do you want to move? (for example 'a2')\n'stop' stops the game");
                    String coordinate = reader.nextLine();
                    String test1 = "abcdefgh";
                    String test2 = "12345678";

                    if(coordinate.trim().toLowerCase().equals("stop")) {
                        winner = -2;
                        break;
                    }

                    if (coordinate.length() == 2 && test1.contains(coordinate.substring(0, 1)) 
                            && test2.contains(coordinate.substring(1, 2))) {
                        Coordinate cood = new Coordinate(coordinate);
                        BetterList moveList = game.askMoves(cood, turn);
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
                            winner = game.makeTurn(turn, move);
                            break;
                        } else {
                            System.out.println("index out of bounds");
                        }

                    } else {
                        System.out.println("Not a valid coordinate\n");
                    }
                }
            } else {
                winner = game.makeTurn(turn);
            }
            
            turn++;
            drawBoard();
        }
        
        if (winner != -2) {
            System.out.println("player " + winner + " won");
        } else {
            System.out.println("game was stopped");
        }
    }
    
    /**
     * Starts the game of 2 bots playing against each other
     */
    public void startAiVsAi() {
        board.reset();
        int turn = 1;
        int winner = -1;
        ChessGame game = new ChessGame(board);
        
        System.out.println("It's Ai showdown");
        
        while (winner == -1) {
            drawBoard();
            winner = game.makeTurn(turn);
            
            turn++;
        }
        
        System.out.println("player " + winner + " won");
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
    
    public void timeForTree() {
        TreeAndMinMaxBenchmark bench = new TreeAndMinMaxBenchmark();
        while (true) {
            int depth;
            System.out.println("How many layers or stop (I recommend starting with 3)?");
            String command = reader.nextLine();
            if (command.trim().toLowerCase().equals("stop")) break;
            
            try {
                depth = Integer.parseInt(command);
            }catch (Exception e) {
                System.out.println("invalid input");
                continue;
            }
            
            bench.timing(depth);
        }
    }
    
}
