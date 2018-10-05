package chessaitiralab.chessai.tiralab.chess;
/**
 * This is the chess board. It can be reset as well as move the pieces
 * 
 * @author hceetu
 */
public class ChessBoard {
   private int[][] board;

    public ChessBoard() {
        this.board = new int[9][9];
        
        this.reset();
        
    }
    
    /**
     * The new board created will be a copy of the other one.
     * 
     * @param bo board you want to copy
     */
    public ChessBoard(ChessBoard bo) {
        this.board = new int[9][9];
        
        for (int i = 8; i > 0; i--) {
            for (int j = 1; j < 9; j++) {
                board[i][j] = bo.getBoard()[i][j];
            }
        }
    }
    
    /**
     * resets the board to the starting position
     */
    public void reset() {
        int[] pieces = {4, 2, 3, 5, 6, 3, 2, 4};
        this.board = new int[9][9];
        
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
        int eaten = this.board[move.getYe()][move.getXe()];
        this.board[move.getYe()][move.getXe()] = this.board[move.getYb()][move.getXb()];
        this.board[move.getYb()][move.getXb()] = 0;
        return eaten;
    }

    public int[][] getBoard() {
        return board;
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }
        
        ChessBoard board2 = (ChessBoard) obj;
        
        for (int i = 8; i > 0; i--) {
            for (int j = 1; j < 9; j++) {
                if (board[i][j] != board2.getBoard()[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
   
   
}
