package chessaitiralab.chessai.tiralab.chess;

import static java.lang.Math.abs;

/**
 * This class tells us if something is allowed or if king is in check
 * 
 * @author hceetu
 */
public class ChessLogic {
    
    /**
     * Checks if the move is valid and returns true if it is.
     * It can also tell you have checkmate 
     * 
     * @param move the coordinates from where to where
     * @param board the chess board
     * @param player which player is making the move
     * @return boolean
     */
    public boolean checkMove(Move move, ChessBoard board, int player) {
        int piece = board.getBoard()[move.getYa()][move.getXa()];
        
        if ((piece < 10 && player != 1) || piece == 0 ) {
            return false;
        }
        
        if (move.getXa() == move.getXl() && move.getYa() == move.getYl()) {
            return false;
        }
        
        if (checkYourCheck(move, board)) {
            return false;
        }
        
        if ((board.getBoard()[move.getYl()][move.getXl()] < 10 && board.getBoard()[move.getYl()][move.getXl()] != 0 && piece < 10)
                || board.getBoard()[move.getYl()][move.getXl()] > 10 && piece > 10) {
            return false;
        }
        
        if (piece == 1) {
            return this.checkPawn(move, board);
        }
        
        if (piece == 2) {
            return this.checkKnight(move, board);
        }
        
        if (piece == 3) {
            return this.checkBishop(move, board);
        }
        
        if (piece == 4) {
            return this.checkRook(move, board);
        }
        
        if (piece == 5) {
            return this.checkQueen(move, board);
        }
        
        if (piece == 6) {
            return this.checkKing(move, board);
        }
        
        return false;
    }
    
    /**
     * Checks the move of a pawn.
     * 
     * @param move the coordinates from where to where
     * @param board the chess board
     * @return 
     */
    public boolean checkPawn(Move move, ChessBoard board) {
        int piece = board.getBoard()[move.getYa()][move.getXa()];
        
        if (abs(move.getXa() - move.getXl()) > 1) {
                return false;
        }
        
        if (piece == 1) {
            if (abs(move.getXa() - move.getXl()) == 1) {
                if (move.getYl() - move.getYa() != 1) {
                    return false;
                }
                
                return board.getBoard()[move.getYl()][move.getXl()] > 10;
            }
            
            if (move.getXa() != move.getXl()) {
                return false;
            }
            
            if (move.getYl() - move.getYa() != 1 && move.getYa() != 2) {
                return false;
            }
            
            if (abs(move.getYl() - move.getYa()) > 2) {
                return false;
            }
        }
        else {
            if (abs(move.getXa() - move.getXl()) == 1) {
                if (move.getYa() - move.getYl() != 1) {
                    return false;
                }
                
                return board.getBoard()[move.getYl()][move.getXl()] < 10 && board.getBoard()[move.getYl()][move.getXl()] != 0;
            }
            
            if (move.getXa() != move.getXl()) {
                return false;
            }
            
            if (move.getYa() - move.getYl() != 1 && move.getYa() != 7) {
                return false;
            }
            
            if (move.getYa() - move.getYl() > 2) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Checks the move of a rook.
     * 
     * @param move the coordinates from where to where
     * @param board the chess board
     * @return 
     */
    public boolean checkRook(Move move, ChessBoard board) {
        int piece = board.getBoard()[move.getYa()][move.getXa()];
        
        if (move.getXa() != move.getXl() && move.getYa() != move.getYl()) {
            return false;
        }
        
        if ((board.getBoard()[move.getYl()][move.getXl()] < 10 && board.getBoard()[move.getYl()][move.getXl()] != 0 && piece < 10) 
                || board.getBoard()[move.getYl()][move.getXl()] > 10 && piece > 10) {
            return false;
        }
        
        if (move.getXa() == move.getXl()) {
            if (move.getYa() < move.getYl()) {
                for (int i = move.getYa()+1; i < move.getYl(); i++) {
                    if (board.getBoard()[i][move.getXa()] != 0) {
                        return false;
                    }
                }           
            } 
            else {
                for (int i = move.getYa()-1; i < move.getYl(); i--) {
                    if (board.getBoard()[i][move.getXa()] != 0) {
                        return false;
                    }
                }
            }
        }
        else {
            if (move.getXa() < move.getXl()) {
                for (int i = move.getXa()+1; i < move.getXl(); i++) {
                    if (board.getBoard()[move.getYa()][i] != 0) {
                        return false;
                    }
                }           
            } 
            else {
                for (int i = move.getXa()-1; i < move.getXl(); i--) {
                    if (board.getBoard()[move.getYa()][i] != 0) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    /**
     * Checks the move of a knight.
     * 
     * @param move the coordinates from where to where
     * @param board the chess board
     * @return 
     */
    public boolean checkKnight(Move move, ChessBoard board) {
        int piece = board.getBoard()[move.getYa()][move.getXa()];
        
        if(!(abs(move.getYl() - move.getYa()) == 2 && abs(move.getXl() - move.getYa()) == 1)
                && !(abs(move.getYl() - move.getYa()) == 1 && abs(move.getXl() - move.getYa()) == 2)) {
            return false;
        }
        
        if ((board.getBoard()[move.getYl()][move.getXl()] < 10 && board.getBoard()[move.getYl()][move.getXl()] != 0 && piece < 10)
                || board.getBoard()[move.getYl()][move.getXl()] > 10 && piece > 10) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Checks the move of a bishop.
     * 
     * @param move the coordinates from where to where
     * @param board the chess board
     * @return 
     */
    public boolean checkBishop(Move move, ChessBoard board) {
        if (abs(move.getXa()-move.getXl()) != abs(move.getYa()-move.getYl())) {
            return false;
        }
        
        if (move.getYa() < move.getYl() && move.getXa() < move.getXl()) {
            for (int i = 1; i < move.getYl()-move.getYa() && i < move.getXl()-move.getXa(); i++) {
                if (board.getBoard()[move.getYa()+i][move.getXa()+i] != 0) {
                    return false;
                }
            }
        }
        
        if (move.getYa() > move.getYl() && move.getXa() < move.getXl()) {
            for (int i = 1; i < move.getYa()-move.getYl() && i < move.getXl()-move.getXa(); i++) {
                if (board.getBoard()[move.getYa()-i][move.getXa()+i] != 0) {
                    return false;
                }
            }
        }
        
        if (move.getYa() < move.getYl() && move.getXa() > move.getXl()) {
            for (int i = 1; i < move.getYl()-move.getYa() && i < move.getXa()-move.getXl(); i++) {
                if (board.getBoard()[move.getYa()+i][move.getXa()-i] != 0) {
                    return false;
                }
            }
        }
        
        if (move.getYa() > move.getYl() && move.getXa() > move.getXl()) {
            for (int i = 1; i < move.getYa()-move.getYl() && i < move.getXa()-move.getXl(); i++) {
                if (board.getBoard()[move.getYa()-i][move.getXa()-i] != 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * Checks the move of a king.
     * 
     * @param move the coordinates from where to where
     * @param board the chess board
     * @return 
     */
    public boolean checkKing(Move move, ChessBoard board) {
        if (abs(move.getXa()-move.getXl()) != 1 || abs(move.getYa()-move.getYl()) != 1) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Checks the move of a queen.
     * 
     * @param move the coordinates from where to where
     * @param board the chess board
     * @return 
     */
    public boolean checkQueen(Move move, ChessBoard board) {
        if ((abs(move.getXa()-move.getXl()) != abs(move.getYa()-move.getYl())) 
                && (move.getXa() != move.getXl() && move.getYa() != move.getYl())) {
            return false;
        }
        
        if (move.getYa() < move.getYl() && move.getXa() < move.getXl()) {
            for (int i = 1; i < move.getYl()-move.getYa() && i < move.getXl()-move.getXa(); i++) {
                if (board.getBoard()[move.getYa()+i][move.getXa()+i] != 0) {
                    return false;
                }
            }
        }
        
        if (move.getYa() > move.getYl() && move.getXa() < move.getXl()) {
            for (int i = 1; i < move.getYa()-move.getYl() && i < move.getXl()-move.getXa(); i++) {
                if (board.getBoard()[move.getYa()-i][move.getXa()+i] != 0) {
                    return false;
                }
            }
        }
        
        if (move.getYa() < move.getYl() && move.getXa() > move.getXl()) {
            for (int i = 1; i < move.getYl()-move.getYa() && i < move.getXa()-move.getXl(); i++) {
                if (board.getBoard()[move.getYa()+i][move.getXa()-i] != 0) {
                    return false;
                }
            }
        }
        
        if (move.getYa() > move.getYl() && move.getXa() > move.getXl()) {
            for (int i = 1; i < move.getYa()-move.getYl() && i < move.getXa()-move.getXl(); i++) {
                if (board.getBoard()[move.getYa()-i][move.getXa()-i] != 0) {
                    return false;
                }
            }
        }
        
        if (move.getXa() == move.getXl()) {
            if (move.getYa() < move.getYl()) {
                for (int i = move.getYa()+1; i < move.getYl(); i++) {
                    if (board.getBoard()[i][move.getXa()] != 0) {
                        return false;
                    }
                }           
            } 
            else {
                for (int i = move.getYa()-1; i < move.getYl(); i--) {
                    if (board.getBoard()[i][move.getXa()] != 0) {
                        return false;
                    }
                }
            }
        }
        else {
            if (move.getXa() < move.getXl()) {
                for (int i = move.getXa()+1; i < move.getXl(); i++) {
                    if (board.getBoard()[move.getYa()][i] != 0) {
                        return false;
                    }
                }           
            } 
            else {
                for (int i = move.getXa()-1; i < move.getXl(); i--) {
                    if (board.getBoard()[move.getYa()][i] != 0) {
                        return false;
                    }
                }
            }
        }
        
        return false;
    }
    
    /**
     * This checks if your king is in check.
     * It returns true if it is in check.
     * 
     * @param move the coordinates from where to where
     * @param board the chess board
     * @return boolean
     */
    public boolean checkYourCheck(Move move, ChessBoard board) {
        int piece = board.getBoard()[move.getYa()][move.getXa()];
        int king = 6;
        
        if (piece > 10) {
            king = 16;
        }
        
        int y = 0;
        int x = 0;
        if (piece == 6 || piece == 16) {
            y = move.getYa();
            x = move.getXa();
        } 
        else {
            for (int i = 1; i < 9; i++) {
                for (int j = 1; j < 9; i++) {
                    if(board.getBoard()[i][j] == king) {
                        y = j;
                        x = i;
                    }
                }
            }
        }
        
        if (king == 6) {
            if (board.getBoard()[y][x+1] == 16 || board.getBoard()[y][x-1] == 16 
                    || board.getBoard()[y+1][x] == 16 || board.getBoard()[y-1][x] == 16
                    || board.getBoard()[y+1][x-1] == 16 || board.getBoard()[y-1][x+1] == 16
                    || board.getBoard()[y+1][x+1] == 16 || board.getBoard()[y-1][x-1] == 16) {
                return true;
            }
            
//            if (board.getBoard()[y+1][x] == 16 || board.getBoard()[y-1][x] == 16) {
//                return true;
//            }
//            
//            if (board.getBoard()[y+1][x-1] == 16 || board.getBoard()[y-1][x+1] == 16) {
//                return true;
//            }
//            
//            if (board.getBoard()[y+1][x+1] == 16 || board.getBoard()[y-1][x-1] == 16) {
//                return true;
//            }
            
            if (board.getBoard()[y+1][x+1] == 10 || board.getBoard()[y+1][x-1] == 10){
                 return true;
            }
            
            if (board.getBoard()[y+2][x+1] == 12 || board.getBoard()[y+2][x-1] == 12
                    || board.getBoard()[y-2][x+1] == 12 || board.getBoard()[y-2][x-1] == 12
                    || board.getBoard()[y+1][x+2] == 12 || board.getBoard()[y+1][x+2] == 12
                    || board.getBoard()[y+1][x-2] == 12 || board.getBoard()[y-1][x-2] == 12) {
                return true;
            }
            
            for (int i = x+1; i < 9; i++) {
                
                if (board.getBoard()[y][i] != 0) {
                    
                     if (board.getBoard()[y][i] == 14 || board.getBoard()[y][i] == 15 ) {
                         return true;
                     } 
                     else {
                         break;
                     }
                }
            }
            
            for (int i = x-1; i > 0; i--) {
                
                if (board.getBoard()[y][i] != 0) {
                    
                     if (board.getBoard()[y][i] == 14 || board.getBoard()[y][i] == 15 ) {
                         return true;
                     } 
                     else {
                         break;
                     }
                }
            }
            
            for (int i = 1; i < 9-x && i < 9-y; i++) {
                
                if (board.getBoard()[y+i][x+i] != 0) {
                    
                     if (board.getBoard()[y+1][x+i] == 13 || board.getBoard()[y+i][x+i] == 15 ) {
                         return true;
                     } 
                     else {
                         break;
                     }
                }
            }
            
            for (int i = 1; i < x && i < y; i++) {
                
                if (board.getBoard()[y-i][x-i] != 0) {
                    
                     if (board.getBoard()[y-i][x-i] == 13 || board.getBoard()[y-i][x-i] == 15 ) {
                         return true;
                     } 
                     else {
                         break;
                     }
                }
            }
            
            for (int i = 1; i < x && i < 9-y; i++) {
                
                if (board.getBoard()[y+i][x-i] != 0) {
                    
                     if (board.getBoard()[y+1][x-i] == 13 || board.getBoard()[y+i][x-i] == 15 ) {
                         return true;
                     } 
                     else {
                         break;
                     }
                }
            }
            
            for (int i = 1; i < 9-x && i < y; i++) {
                
                if (board.getBoard()[y-i][x+i] != 0) {
                    
                     if (board.getBoard()[y-1][x+i] == 13 || board.getBoard()[y-i][x+i] == 15 ) {
                         return true;
                     } 
                     else {
                         break;
                     }
                }
            }
            
            for (int i = y+1; i < 9; i++) {
                
                if (board.getBoard()[i][x] != 0) {
                    
                     if (board.getBoard()[i][x] == 14 || board.getBoard()[i][x] == 15 ) {
                         return true;
                     } 
                     else {
                         break;
                     }
                }
            }
            
            for (int i = y-1; i > 0; i--) {
                
                if (board.getBoard()[i][x] != 0) {
                    
                     if (board.getBoard()[i][x] == 14 || board.getBoard()[i][x] == 15 ) {
                         return true;
                     } 
                     else {
                         break;
                     }
                }
            }
            
        } else {
            if (board.getBoard()[y][x+1] == 6 || board.getBoard()[y][x-1] == 6 
                    || board.getBoard()[y+1][x] == 6 || board.getBoard()[y-1][x] == 6
                    || board.getBoard()[y+1][x-1] == 6 || board.getBoard()[y-1][x+1] == 6
                    || board.getBoard()[y+1][x+1] == 6 || board.getBoard()[y-1][x-1] == 6) {
                return true;
            }
            
//            if (board.getBoard()[y+1][x] == 6 || board.getBoard()[y-1][x] == 6) {
//                return true;
//            }
//            
//            if (board.getBoard()[y+1][x-1] == 6 || board.getBoard()[y-1][x+1] == 6) {
//                return true;
//            }
//            
//            if (board.getBoard()[y+1][x+1] == 6 || board.getBoard()[y-1][x-1] == 6) {
//                return true;
//            }
            
            if (board.getBoard()[y-1][x+1] == 1 || board.getBoard()[y-1][x-1] == 1){
                 return true;
            }
            
            if (board.getBoard()[y+2][x+1] == 2 || board.getBoard()[y+2][x-1] == 2
                    || board.getBoard()[y-2][x+1] == 2 || board.getBoard()[y-2][x-1] == 2
                    || board.getBoard()[y+1][x+2] == 2 || board.getBoard()[y+1][x+2] == 2
                    || board.getBoard()[y+1][x-2] == 2 || board.getBoard()[y-1][x-2] == 2) {
                return true;
            }
            
            for (int i = x+1; i < 9; i++) {
                
                if (board.getBoard()[y][i] != 0) {
                    
                     if (board.getBoard()[y][i] == 4 || board.getBoard()[y][i] == 5 ) {
                         return true;
                     } 
                     else {
                         break;
                     }
                }
            }
            
            for (int i = x-1; i > 0; i--) {
                
                if (board.getBoard()[y][i] != 0) {
                    
                     if (board.getBoard()[y][i] == 4 || board.getBoard()[y][i] == 5 ) {
                         return true;
                     } 
                     else {
                         break;
                     }
                }
            }
            
            for (int i = 1; i < 9-x && i < 9-y; i++) {
                
                if (board.getBoard()[y+i][x+i] != 0) {
                    
                     if (board.getBoard()[y+1][x+i] == 3 || board.getBoard()[y+i][x+i] == 5 ) {
                         return true;
                     } 
                     else {
                         break;
                     }
                }
            }
            
            for (int i = 1; i < x && i < y; i++) {
                
                if (board.getBoard()[y-i][x-i] != 0) {
                    
                     if (board.getBoard()[y-i][x-i] == 3 || board.getBoard()[y-i][x-i] == 5 ) {
                         return true;
                     } 
                     else {
                         break;
                     }
                }
            }
            
            for (int i = 1; i < x && i < 9-y; i++) {
                
                if (board.getBoard()[y+i][x-i] != 0) {
                    
                     if (board.getBoard()[y+1][x-i] == 3 || board.getBoard()[y+i][x-i] == 5 ) {
                         return true;
                     } 
                     else {
                         break;
                     }
                }
            }
            
            for (int i = 1; i < 9-x && i < y; i++) {
                
                if (board.getBoard()[y-i][x+i] != 0) {
                    
                     if (board.getBoard()[y-1][x+i] == 3 || board.getBoard()[y-i][x+i] == 5 ) {
                         return true;
                     } 
                     else {
                         break;
                     }
                }
            }
            
            for (int i = y+1; i < 9; i++) {
                
                if (board.getBoard()[i][x] != 0) {
                    
                     if (board.getBoard()[i][x] == 4 || board.getBoard()[i][x] == 5 ) {
                         return true;
                     } 
                     else {
                         break;
                     }
                }
            }
            
            for (int i = y-1; i > 0; i--) {
                
                if (board.getBoard()[i][x] != 0) {
                    
                     if (board.getBoard()[i][x] == 4 || board.getBoard()[i][x] == 5 ) {
                         return true;
                     } 
                     else {
                         break;
                     }
                }
            }
        }
        
        return false;
    }
}
