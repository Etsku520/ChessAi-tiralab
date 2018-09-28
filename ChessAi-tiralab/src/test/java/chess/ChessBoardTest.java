/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import chessaitiralab.chessai.tiralab.chess.ChessBoard;
import chessaitiralab.chessai.tiralab.chess.Coordinate;
import chessaitiralab.chessai.tiralab.chess.Move;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hceetu
 */
public class ChessBoardTest {
    ChessBoard board;
    
    public ChessBoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        board = new ChessBoard();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void movement1Test() {
        board.movePiece(new Move(new Coordinate(12), new Coordinate(54)));
        assertTrue((board.getBoard()[4][5] == 1));
    }
    
    @Test
    public void movedPieceDoesntStayTest() {
        board.movePiece(new Move(new Coordinate(12), new Coordinate(54)));
        assertTrue(board.getBoard()[2][1] == 0);
    }
    
    @Test
    public void resetMaybeTest() {
        board.movePiece(new Move(new Coordinate(12), new Coordinate(54)));
        board.reset();
        
        assertTrue(board.getBoard()[4][5] == 0);
        assertTrue(board.getBoard()[2][1] == 1);
    }
    
    @Test
    public void copyBoardTest() {
        ChessBoard boardCopy = new ChessBoard(board);
        
        assertEquals(board, boardCopy);
    }
}
