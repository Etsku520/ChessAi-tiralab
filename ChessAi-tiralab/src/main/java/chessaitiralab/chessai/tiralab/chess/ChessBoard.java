package chessaitiralab.chessai.tiralab.chess;
/**
 * This is the chess board. It can be reset as well as move the pieces
 * 
 * @author hceetu
 */
public class ChessBoard {
   private int[][] board;

    public ChessBoard() {
        this.board = new int[12][12];
        
        this.reset();
        
    }
    
    /**
     * resets the board to the starting position
     */
    public void reset() {
        int[] pieces = {4, 2, 3, 5, 6, 3, 2, 4};
        
         for(int i = 1; i < 9; i++) {
            this.board[1][i] = pieces[i-1];
            this.board[2][i] = 1;
            
            this.board[8][i] = pieces[i-1] + 10;
            this.board[7][i] = 11;
        }
    }
    
    /**
     * moves a piece on board and returns the eaten piece (can be empty = 0)
     * 
     * @param move Tells what moves where
     * 
     * @return eaten piece
     */
    public int movePiece(Move move) {
        int eaten = this.board[move.getYl()][move.getXl()];
        this.board[move.getYl()][move.getXl()] = this.board[move.getYa()][move.getXa()];
        this.board[move.getYa()][move.getXa()] = 0;
        return eaten;
    }

    public int[][] getBoard() {
        return board;
    }
   
   
}