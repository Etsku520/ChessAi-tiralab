package chessaitiralab.chessai.tiralab.chess;

import static java.lang.Math.abs;
import chessaitiralab.chessai.tiralab.dataStructure.BetterList;

/**
 * This class tells us if something is allowed or if king is in check
 *
 * @author hceetu
 */
public class ChessLogic {

    /**
     * Checks if the move is valid and returns true if it is. It can also tell
     * you have checkmate
     *
     * @param cood the coordinates of the piece you want to move
     * @param board the chess board
     * @param player which player is making the move
     * @return boolean
     */
    public BetterList checkMove(Coordinate cood, ChessBoard board, int player) {
        int piece = board.getBoard()[cood.getY()][cood.getX()];
        BetterList moveList = new BetterList();

        if (piece == 1 && player == 1) {
            return this.checkPawn(cood, board);
        }

        if (piece == 2 && player == 1) {
            return this.checkKnight(cood, board);
        }

        if (piece == 3 && player == 1) {
            return this.checkBishop(cood, board);
        }

        if (piece == 4 && player == 1) {
            return this.checkRook(cood, board);
        }

        if (piece == 5 && player == 1) {
            return this.checkQueen(cood, board);
        }

        if (piece == 6 && player == 1) {
            return this.checkKing(cood, board);
        }

        if (piece == 11 && player == 0) {
            return this.checkPawn(cood, board);
        }

        if (piece == 12 && player == 0) {
            return this.checkKnight(cood, board);
        }

        if (piece == 13 && player == 0) {
            return this.checkBishop(cood, board);
        }

        if (piece == 14 && player == 0) {
            return this.checkRook(cood, board);
        }

        if (piece == 15 && player == 0) {
            return this.checkQueen(cood, board);
        }

        if (piece == 16 && player == 0) {
            return this.checkKing(cood, board);
        }

        return moveList;
    }

    /**
     * Checks the moves of a pawn. And return all the legal moves
     *
     * @param cood the coordinates of the piece you want to move
     * @param board the chess board
     * @return list of legal moves
     */
    public BetterList checkPawn(Coordinate cood, ChessBoard board) {
        int piece = board.getBoard()[cood.getY()][cood.getX()];
        BetterList moveList = new BetterList();

        if (piece == 1) {
            if (cood.getY() < 8) {
                if (board.getBoard()[cood.getY() + 1][cood.getX()] == 0) {
                    if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() + 1 + (cood.getX()) * 10)), board)) {
                        moveList.add(new Coordinate((cood.getY() + 1) + cood.getX() * 10));
                    }
                    if (cood.getY() == 2 && board.getBoard()[cood.getY() + 2][cood.getX()] == 0) {
                        if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() + 2 + (cood.getX()) * 10)), board)) {
                            moveList.add(new Coordinate((cood.getY() + 2) + cood.getX() * 10));
                        }
                    }

                }

                if (cood.getX() > 1) {
                    if (board.getBoard()[cood.getY() + 1][cood.getX() - 1] > 10) {
                        if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() + 1 + (cood.getX() - 1) * 10)), board)) {
                            moveList.add(new Coordinate((cood.getY() + 1) + (cood.getX() - 1) * 10));
                        }
                    }
                }

                if (cood.getX() < 8) {
                    if (board.getBoard()[cood.getY() + 1][cood.getX() + 1] > 10) {
                        if (!checkYourCheck(new Move(cood, new Coordinate((cood.getY() + 1) + (cood.getX() + 1) * 10)), board)) {
                            moveList.add(new Coordinate((cood.getY() + 1) + (cood.getX() + 1) * 10));
                        }
                    }
                }
            }
            

        } else {
            if (cood.getY() > 1) {
                if (board.getBoard()[cood.getY() - 1][cood.getX()] == 0) {
                    moveList.add(new Coordinate((cood.getY() - 1) + cood.getX() * 10));
                    if (cood.getY() == 7 && board.getBoard()[cood.getY() - 2][cood.getX()] == 0) {
                        if (!checkYourCheck(new Move(cood, new Coordinate((cood.getY() - 2) + (cood.getX()) * 10)), board)) {
                            moveList.add(new Coordinate((cood.getY() - 2) + cood.getX() * 10));
                        }
                    }

                }

                if (cood.getX() > 1) {
                    if (board.getBoard()[cood.getY() + 1][cood.getX() - 1] < 10 && board.getBoard()[cood.getY() + 1][cood.getX() - 1] != 0) {
                        if (!checkYourCheck(new Move(cood, new Coordinate((cood.getY() - 1) + (cood.getX() - 1) * 10)), board)) {
                            moveList.add(new Coordinate((cood.getY() - 1) + (cood.getX() - 1) * 10));
                        }
                    }
                }

                if (cood.getX() < 8) {
                    if (board.getBoard()[cood.getY() + 1][cood.getX() + 1] < 10 && board.getBoard()[cood.getY() + 1][cood.getX() + 1] != 0) {
                        if (!checkYourCheck(new Move(cood, new Coordinate((cood.getY() - 1) + (cood.getX() + 1) * 10)), board)) {
                            moveList.add(new Coordinate((cood.getY() - 1) + (cood.getX() + 1) * 10));
                        }
                    }
                }
            }
            
        }

        return moveList;
    }

    /**
     * Checks the moves of a rook. And return all the legal moves
     *
     * @param cood the coordinates of the piece you want to move
     * @param board the chess board
     * @return list of legal moves
     */
    public BetterList checkRook(Coordinate cood, ChessBoard board) {
        int piece = board.getBoard()[cood.getY()][cood.getX()];
        BetterList moveList = new BetterList();

        int found = 0;
        for (int i = cood.getY() + 1; i < 9 && found == 0; i++) {
            found = board.getBoard()[i][cood.getX()];

            if (board.getBoard()[i][cood.getX()] == 0 || (found > 10 && piece < 10)
                    || (found < 10 && piece > 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(i + cood.getX() * 10)), board)) {
                    moveList.add(new Coordinate(i + cood.getX() * 10));
                }
            }
        }

        found = 0;
        for (int i = cood.getY() - 1; i > 0 && found == 0; i--) {
            found = board.getBoard()[i][cood.getX()];

            if (board.getBoard()[i][cood.getX()] == 0 || (found > 10 && piece < 10)
                    || (found < 10 && piece > 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(i + (cood.getX()) * 10)), board)) {
                    moveList.add(new Coordinate(i + cood.getX() * 10));
                }
            }
        }

        found = 0;
        for (int i = cood.getX() + 1; i < 9 && found == 0; i++) {
            found = board.getBoard()[cood.getY()][i];

            if (board.getBoard()[cood.getY()][i] == 0 || (found > 10 && piece < 10)
                    || (found < 10 && piece > 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() + i * 10)), board)) {
                    moveList.add(new Coordinate(cood.getY() + i * 10));
                }
            }
        }

        found = 0;
        for (int i = cood.getX() - 1; i > 0 && found == 0; i--) {
            found = board.getBoard()[cood.getY()][i];

            if (board.getBoard()[cood.getY()][i] == 0 || (found > 10 && piece < 10)
                    || (found < 10 && piece > 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() + i * 10)), board)) {
                    moveList.add(new Coordinate(cood.getY() + i * 10));
                }
            }
        }

        return moveList;
    }

    /**
     * Checks the moves of a knight. And return all the legal moves
     *
     * @param cood the coordinates of the piece you want to move
     * @param board the chess board
     * @return list of legal moves
     */
    public BetterList checkKnight(Coordinate cood, ChessBoard board) {
        int piece = board.getBoard()[cood.getY()][cood.getX()];
        BetterList moveList = new BetterList();
        int going = 0;

        if (cood.getY() + 2 < 9 && cood.getX() + 1 < 9) {
            going = board.getBoard()[cood.getY() + 2][cood.getX() + 1];

            if (going == 0 || (going < 10 && piece > 10) || (going > 10 && piece < 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() + 2 + (cood.getX() + 1) * 10)), board)) {
                    moveList.add(new Coordinate((cood.getY() + 2) + (cood.getX() + 1) * 10));
                }
            }
        }

        if (cood.getY() + 1 < 9 && cood.getX() + 2 < 9) {
            going = board.getBoard()[cood.getY() + 1][cood.getX() + 2];

            if (going == 0 || (going < 10 && piece > 10) || (going > 10 && piece < 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() + 1 + (cood.getX() + 2) * 10)), board)) {
                    moveList.add(new Coordinate((cood.getY() + 1) + (cood.getX() + 2) * 10));
                }
            }
        }

        if (cood.getY() - 1 > 0 && cood.getX() + 2 < 9) {
            going = board.getBoard()[cood.getY() - 1][cood.getX() + 2];

            if (going == 0 || (going < 10 && piece > 10) || (going > 10 && piece < 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() - 1 + (cood.getX() + 2) * 10)), board)) {
                    moveList.add(new Coordinate((cood.getY() - 1) + (cood.getX() + 2) * 10));
                }
            }
        }

        if (cood.getY() + 1 < 9 && cood.getX() - 2 > 0) {
            going = board.getBoard()[cood.getY() + 1][cood.getX() - 2];

            if (going == 0 || (going < 10 && piece > 10) || (going > 10 && piece < 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() + 1 + (cood.getX() - 2) * 10)), board)) {
                    moveList.add(new Coordinate((cood.getY() + 1) + (cood.getX() - 2) * 10));
                }
            }
        }

        if (cood.getY() - 2 > 0 && cood.getX() + 1 < 9) {
            going = board.getBoard()[cood.getY() - 2][cood.getX() + 1];

            if (going == 0 || (going < 10 && piece > 10) || (going > 10 && piece < 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() - 2 + (cood.getX() + 1) * 10)), board)) {
                    moveList.add(new Coordinate((cood.getY() - 2) + (cood.getX() + 1) * 10));
                }
            }
        }

        if (cood.getY() + 2 < 9 && cood.getX() - 1 > 0) {
            going = board.getBoard()[cood.getY() + 2][cood.getX() - 1];

            if (going == 0 || (going < 10 && piece > 10) || (going > 10 && piece < 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() + 2 + (cood.getX() - 1) * 10)), board)) {
                    moveList.add(new Coordinate((cood.getY() + 2) + (cood.getX() - 1) * 10));
                }
            }
        }

        if (cood.getY() - 2 > 0 && cood.getX() - 1 > 0) {
            going = board.getBoard()[cood.getY() - 2][cood.getX() - 1];

            if (going == 0 || (going < 10 && piece > 10) || (going > 10 && piece < 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() - 2 + (cood.getX() - 1) * 10)), board)) {
                    moveList.add(new Coordinate((cood.getY() - 2) + (cood.getX() - 1) * 10));
                }
            }
        }

        if (cood.getY() - 1 > 0 && cood.getX() - 2 > 0) {
            going = board.getBoard()[cood.getY() - 1][cood.getX() - 2];

            if (going == 0 ||(going < 10 && piece > 10) || (going > 10 && piece < 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() - 1 + (cood.getX() - 2) * 10)), board)) {
                    moveList.add(new Coordinate((cood.getY() - 1) + (cood.getX() - 2) * 10));
                }
            }
        }

        return moveList;
    }

    /**
     * Checks the moves of a bishop. And return all the legal moves
     *
     * @param cood the coordinates of the piece you want to move
     * @param board the chess board
     * @return list of legal moves
     */
    public BetterList checkBishop(Coordinate cood, ChessBoard board) {
        int piece = board.getBoard()[cood.getY()][cood.getX()];
        BetterList moveList = new BetterList();

        int found = 0;
        for (int i = 1; i < 9 - cood.getY() && i < 9 - cood.getX() && found == 0; i++) {
            found = board.getBoard()[cood.getY() + i][cood.getX() + i];

            if (found == 0 || (piece < 10 && found > 10) || (piece > 10 && found < 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate((cood.getY() + i) + (cood.getX() + i) * 10)), board)) {
                    moveList.add(new Coordinate((cood.getY() + i) + (cood.getX() + i) * 10));
                }
            }
        }

        found = 0;
        for (int i = 1; i < 9 - cood.getY() && i < cood.getX() && found == 0; i++) {
            found = board.getBoard()[cood.getY() + i][cood.getX() - i];

            if (found == 0 || (piece < 10 && found > 10) || (piece > 10 && found < 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate((cood.getY() + i) + (cood.getX() - i) * 10)), board)) {
                    moveList.add(new Coordinate((cood.getY() + i) + (cood.getX() - i) * 10));
                }
            }
        }

        found = 0;
        for (int i = 1; i < cood.getY() && i < cood.getX() && found == 0; i++) {
            found = board.getBoard()[cood.getY() - i][cood.getX() - i];

            if (found == 0 || (piece < 10 && found > 10) || (piece > 10 && found < 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate((cood.getY() - i) + (cood.getX() - i) * 10)), board)) {
                    moveList.add(new Coordinate((cood.getY() - i) + (cood.getX() - i) * 10));
                }
            }
        }

        found = 0;
        for (int i = 1; i < cood.getY() && i < 9 - cood.getX() && found == 0; i++) {
            found = board.getBoard()[cood.getY() - i][cood.getX() + i];

            if (found == 0 || (piece < 10 && found > 10) || (piece > 10 && found < 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate((cood.getY() - i) + (cood.getX() + i) * 10)), board)) {
                    moveList.add(new Coordinate((cood.getY() - i) + (cood.getX() + i) * 10));
                }
            }
        }

        return moveList;
    }

    /**
     * Checks the move of a king. And return all the legal moves
     *
     * @param cood the coordinates of the piece you want to move
     * @param board the chess board
     * @return list of legal moves
     */
    public BetterList checkKing(Coordinate cood, ChessBoard board) {
        int piece = board.getBoard()[cood.getY()][cood.getX()];
        BetterList moveList = new BetterList();
        int going = 0;

        if (cood.getX() < 8) {
            going = board.getBoard()[cood.getY()][cood.getX() + 1];

            if (going == 0 || (going > 10 && piece < 10) || (going < 10 && piece > 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() + (cood.getX() + 1) * 10)), board)) {
                    moveList.add(new Coordinate(cood.getY() + (cood.getX() + 1) * 10));
                }
            }
        }

        if (cood.getX() < 8 && cood.getY() < 8) {
            going = board.getBoard()[cood.getY() + 1][cood.getX() + 1];

            if (going == 0 || (going > 10 && piece < 10) || (going < 10 && piece > 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() + 1 + (cood.getX() + 1) * 10)), board)) {
                    moveList.add(new Coordinate((cood.getY() + 1) + (cood.getX() + 1) * 10));
                }
            }
        }

        if (cood.getX() > 1 && cood.getY() < 8) {
            going = board.getBoard()[cood.getY() + 1][cood.getX() - 1];

            if (going == 0 || (going > 10 && piece < 10) || (going < 10 && piece > 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() + 1 + (cood.getX() - 1) * 10)), board)) {
                    moveList.add(new Coordinate((cood.getY() + 1) + (cood.getX() - 1) * 10));
                }
            }
        }

        if (cood.getX() < 8 && cood.getY() > 1) {
            going = board.getBoard()[cood.getY() - 1][cood.getX() + 1];

            if (going == 0 || (going > 10 && piece < 10) || (going < 10 && piece > 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() - 1 + (cood.getX() + 1) * 10)), board)) {
                    moveList.add(new Coordinate((cood.getY() - 1) + (cood.getX() + 1) * 10));
                }
            }
        }

        if (cood.getX() > 1 && cood.getY() > 1) {
            going = board.getBoard()[cood.getY() - 1][cood.getX() - 1];

            if (going == 0 || (going > 10 && piece < 10) || (going < 10 && piece > 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() - 1 + (cood.getX() - 1) * 10)), board)) {
                    moveList.add(new Coordinate((cood.getY() - 1) + (cood.getX() - 1) * 10));
                }
            }
        }

        if (cood.getX() > 1) {
            going = board.getBoard()[cood.getY()][cood.getX() - 1];

            if (going == 0 || (going > 10 && piece < 10) || (going < 10 && piece > 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() + (cood.getX() - 1) * 10)), board)) {
                    moveList.add(new Coordinate((cood.getY()) + (cood.getX() - 1) * 10));
                }
            }
        }

        if (cood.getY() > 1) {
            going = board.getBoard()[cood.getY() - 1][cood.getX()];

            if (going == 0 || (going > 10 && piece < 10) || (going < 10 && piece > 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() - 1 + cood.getX() * 10)), board)) {
                    moveList.add(new Coordinate((cood.getY() - 1) + cood.getX() * 10));
                }
            }
        }

        if (cood.getY() < 8) {
            going = board.getBoard()[cood.getY() + 1][cood.getX()];

            if (going == 0 || (going > 10 && piece < 10) || (going < 10 && piece > 10)) {
                if (!checkYourCheck(new Move(cood, new Coordinate(cood.getY() + 1 + (cood.getX()) * 10)), board)) {
                    moveList.add(new Coordinate((cood.getY() + 1) + cood.getX() * 10));
                }
            }
        }

        return moveList;
    }

    /**
     * Checks the move of a queen. And return all the legal moves
     *
     * @param cood the coordinates of the piece you want to move
     * @param board the chess board
     * @return list of legal moves
     */
    public BetterList checkQueen(Coordinate cood, ChessBoard board) {
        int piece = board.getBoard()[cood.getY()][cood.getX()];
        BetterList moveList = checkBishop(cood, board);
        BetterList rookList = checkRook(cood, board);

        for (int i = 0; i < rookList.size(); i++) {
            moveList.add((Coordinate) rookList.get(i));
        }

        return moveList;
    }

    /**
     * This checks if your king is in check. It returns true if it is in check.
     *
     * @param move the coordinates from where to where
     * @param board the chess board
     * @return boolean
     */
    public boolean checkYourCheck(Move move, ChessBoard board) {
        int piece = board.getBoard()[move.getYb()][move.getXb()];
        int eaten = board.getBoard()[move.getYe()][move.getXe()];

        board.movePiece(move);

        int king = 6;

        if (piece > 10) {
            king = 16;
        }

        int y = 0;
        int x = 0;
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (board.getBoard()[i][j] == king) {
                    y = i;
                    x = j;
                }
            }
        }

        if (king == 6) {

            // kings/pawns
            if (x + 1 < 9) {
                if (board.getBoard()[y][x + 1] == 16) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (x - 1 > 0) {
                if (board.getBoard()[y][x - 1] == 16) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (y + 1 < 9) {
                if (board.getBoard()[y + 1][x] == 16) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (y - 1 > 0) {
                if (board.getBoard()[y - 1][x] == 16) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (x + 1 < 9 && y + 1 < 9) {
                if (board.getBoard()[y + 1][x + 1] == 16 || board.getBoard()[y + 1][x + 1] == 11) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (x - 1 > 0 && y + 1 < 9) {
                if (board.getBoard()[y + 1][x - 1] == 16 || board.getBoard()[y + 1][x - 1] == 11) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (x - 1 > 0 && y - 1 > 0) {
                if (board.getBoard()[y - 1][x - 1] == 16) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (x + 1 < 9 && y - 1 > 0) {
                if (board.getBoard()[y - 1][x + 1] == 16) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            // knights
            if (y + 2 < 9 && x + 1 < 9) {
                if (board.getBoard()[y + 2][x + 1] == 12) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (y + 1 < 9 && x + 2 < 9) {
                if (board.getBoard()[y + 1][x + 2] == 12) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (y - 1 > 0 && x + 2 < 9) {
                if (board.getBoard()[y - 1][x + 2] == 12) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (y + 1 < 9 && x - 2 > 0) {
                if (board.getBoard()[y + 1][x - 2] == 12) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (y - 2 > 0 && x + 1 < 9) {
                if (board.getBoard()[y - 2][x + 1] == 12) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (y + 2 < 9 && x - 1 > 0) {
                if (board.getBoard()[y + 2][x - 1] == 12) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (y - 2 > 0 && x - 1 > 0) {
                if (board.getBoard()[y - 2][x - 1] == 12) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (y - 1 > 0 && x - 2 > 0) {
                if (board.getBoard()[y - 1][x - 2] == 12) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            // right (rook, queen)
            for (int i = x + 1; i < 9; i++) {

                if (board.getBoard()[y][i] != 0) {

                    if (board.getBoard()[y][i] == 14 || board.getBoard()[y][i] == 15) {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;

                        return true;
                    } else {
                        break;
                    }
                }
            }

            // left (rook, queen)
            for (int i = x - 1; i > 0; i--) {

                if (board.getBoard()[y][i] != 0) {

                    if (board.getBoard()[y][i] == 14 || board.getBoard()[y][i] == 15) {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;

                        return true;
                    } else {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;

                        break;
                    }
                }
            }

            // up right (bishop, queen)
            for (int i = 1; i < 9 - x && i < 9 - y; i++) {

                if (board.getBoard()[y + i][x + i] != 0) {

                    if (board.getBoard()[y + i][x + i] == 13 || board.getBoard()[y + i][x + i] == 15) {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;

                        return true;
                    } else {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;

                        break;
                    }
                }
            }

            // down left (bishop, queen)
            for (int i = 1; i < x && i < y; i++) {

                if (board.getBoard()[y - i][x - i] != 0) {

                    if (board.getBoard()[y - i][x - i] == 13 || board.getBoard()[y - i][x - i] == 15) {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;

                        return true;
                    } else {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;

                        break;
                    }
                }
            }

            // up left (bishop, queen)
            for (int i = 1; i < x && i < 9 - y; i++) {

                if (board.getBoard()[y + i][x - i] != 0) {

                    if (board.getBoard()[y + i][x - i] == 13 || board.getBoard()[y + i][x - i] == 15) {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;

                        return true;
                    } else {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;

                        break;
                    }
                }
            }

            // down right (bishop, queen)
            for (int i = 1; i < 9 - x && i < y; i++) {

                if (board.getBoard()[y - i][x + i] != 0) {

                    if (board.getBoard()[y - i][x + i] == 13 || board.getBoard()[y - i][x + i] == 15) {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;

                        return true;
                    } else {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;

                        break;
                    }
                }
            }

            // up (rook, queen)
            for (int i = y + 1; i < 9; i++) {

                if (board.getBoard()[i][x] != 0) {

                    if (board.getBoard()[i][x] == 14 || board.getBoard()[i][x] == 15) {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;

                        return true;
                    } else {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;

                        break;
                    }
                }
            }

            // down (rook, queen)
            for (int i = y - 1; i > 0; i--) {

                if (board.getBoard()[i][x] != 0) {

                    if (board.getBoard()[i][x] == 14 || board.getBoard()[i][x] == 15) {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;

                        return true;
                    } else {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;

                        break;
                    }
                }
            }

        } else {

            // kings/pawns
            if (x + 1 < 9) {
                if (board.getBoard()[y][x + 1] == 6) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;
                    
                    return true;
                }
            }

            if (x - 1 > 0) {
                if (board.getBoard()[y][x - 1] == 6) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;
                    
                    return true;
                }
            }

            if (y + 1 < 9) {
                if (board.getBoard()[y + 1][x] == 6) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;
                    
                    return true;
                }
            }

            if (y - 1 > 0) {
                if (board.getBoard()[y - 1][x] == 6) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;
                    
                    return true;
                }
            }

            if (x + 1 < 9 && y + 1 < 9) {
                if (board.getBoard()[y + 1][x + 1] == 6) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;
                    
                    return true;
                }
            }

            if (x - 1 > 0 && y + 1 < 9) {
                if (board.getBoard()[y + 1][x - 1] == 6) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;
                    
                    return true;
                }
            }

            if (x - 1 > 0 && y - 1 > 0) {
                if (board.getBoard()[y - 1][x - 1] == 6 || board.getBoard()[y - 1][x - 1] == 1) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;
                    
                    return true;
                }
            }

            if (x + 1 < 9 && y - 1 > 0) {
                if (board.getBoard()[y - 1][x + 1] == 6 || board.getBoard()[y - 1][x + 1] == 1) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;
                    
                    return true;
                }
            }

           // knights
            if (y + 2 < 9 && x + 1 < 9) {
                if (board.getBoard()[y + 2][x + 1] == 2) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (y + 1 < 9 && x + 2 < 9) {
                if (board.getBoard()[y + 1][x + 2] == 2) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (y - 1 > 0 && x + 2 < 9) {
                if (board.getBoard()[y - 1][x + 2] == 2) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (y + 1 < 9 && x - 2 > 0) {
                if (board.getBoard()[y + 1][x - 2] == 2) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (y - 2 > 0 && x + 1 < 9) {
                if (board.getBoard()[y - 2][x + 1] == 2) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (y + 2 < 9 && x - 1 > 0) {
                if (board.getBoard()[y + 2][x - 1] == 2) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (y - 2 > 0 && x - 1 > 0) {
                if (board.getBoard()[y - 2][x - 1] == 2) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            if (y - 1 > 0 && x - 2 > 0) {
                if (board.getBoard()[y - 1][x - 2] == 2) {
                    board.getBoard()[move.getYb()][move.getXb()] = piece;
                    board.getBoard()[move.getYe()][move.getXe()] = eaten;

                    return true;
                }
            }

            // right (rook, queen)
            for (int i = x + 1; i < 9; i++) {

                if (board.getBoard()[y][i] != 0) {

                    if (board.getBoard()[y][i] == 4 || board.getBoard()[y][i] == 5) {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;
                    
                        return true;
                    } else {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;
                        
                        break;
                    }
                }
            }

            // left (rook, queen)
            for (int i = x - 1; i > 0; i--) {

                if (board.getBoard()[y][i] != 0) {

                    if (board.getBoard()[y][i] == 4 || board.getBoard()[y][i] == 5) {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;
                        
                        return true;
                    } else {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;
                        
                        break;
                    }
                }
            }

            // up right (bishop, queen)
            for (int i = 1; i < 9 - x && i < 9 - y; i++) {

                if (board.getBoard()[y + i][x + i] != 0) {

                    if (board.getBoard()[y + i][x + i] == 3 || board.getBoard()[y + i][x + i] == 5) {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;
                        
                        return true;
                    } else {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;
                        
                        break;
                    }
                }
            }

            // down left (bishop, queen)
            for (int i = 1; i < x && i < y; i++) {

                if (board.getBoard()[y - i][x - i] != 0) {

                    if (board.getBoard()[y - i][x - i] == 3 || board.getBoard()[y - i][x - i] == 5) {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;
                        
                        return true;
                    } else {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;
                        
                        break;
                    }
                }
            }

            // up left (bishop, queen)
            for (int i = 1; i < x && i < 9 - y; i++) {

                if (board.getBoard()[y + i][x - i] != 0) {

                    if (board.getBoard()[y + i][x - i] == 3 || board.getBoard()[y + i][x - i] == 5) {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;
                        
                        return true;
                    } else {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;
                        
                        break;
                    }
                }
            }

            // down right (bishop, queen)
            for (int i = 1; i < 9 - x && i < y; i++) {

                if (board.getBoard()[y - i][x + i] != 0) {

                    if (board.getBoard()[y - i][x + i] == 3 || board.getBoard()[y - i][x + i] == 5) {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;
                        
                        return true;
                    } else {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;
                        
                        break;
                    }
                }
            }
            
            // up (rook, queen)
            for (int i = y + 1; i < 9; i++) {

                if (board.getBoard()[i][x] != 0) {

                    if (board.getBoard()[i][x] == 4 || board.getBoard()[i][x] == 5) {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;
                        
                        return true;
                    } else {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;
                        
                        break;
                    }
                }
            }
            
            // down (rook, queen)
            for (int i = y - 1; i > 0; i--) {

                if (board.getBoard()[i][x] != 0) {

                    if (board.getBoard()[i][x] == 4 || board.getBoard()[i][x] == 5) {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;
                        
                        return true;
                    } else {
                        board.getBoard()[move.getYb()][move.getXb()] = piece;
                        board.getBoard()[move.getYe()][move.getXe()] = eaten;
                        
                        break;
                    }
                }
            }
        }
        board.getBoard()[move.getYb()][move.getXb()] = piece;
        board.getBoard()[move.getYe()][move.getXe()] = eaten;

        return false;
    }

    /**
     * Checks if any pawn has made it to to end of the board. 
     * If so it will be transformed into a queen.
     * 
     * @param board 
     */
    public void pawnQueens(ChessBoard board) {
        for (int i = 1; i < 9; i++) {
            if (board.getBoard()[8][i] == 1) {
                board.getBoard()[8][i] = 5;
            }

            if (board.getBoard()[1][i] == 11) {
                board.getBoard()[1][i] = 15;
            }
        }
    }
    
    /**
     * Returns true if the player is in checkmate
     * 
     * @param board
     * @param player
     * @return true if in checkmate
     */
    public boolean checkMate(ChessBoard board, int player) {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                Coordinate cood = new Coordinate (j * 10 + i);
                BetterList endCoods = checkMove(cood, board, player);
                
                if (endCoods.size() != 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
