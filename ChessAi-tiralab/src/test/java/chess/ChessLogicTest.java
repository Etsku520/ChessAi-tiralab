/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import chessaitiralab.chessai.tiralab.chess.ChessBoard;
import chessaitiralab.chessai.tiralab.chess.ChessLogic;
import chessaitiralab.chessai.tiralab.chess.Coordinate;
import chessaitiralab.chessai.tiralab.chess.Move;
import chessaitiralab.chessai.tiralab.dataStructure.BetterList;
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
public class ChessLogicTest {
    private ChessBoard board;
    private ChessLogic logic;
    
    public ChessLogicTest() {
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
        logic = new ChessLogic();
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
    public void checkPawnTest() {
        Coordinate cood = new Coordinate("b2");
        
        BetterList moves = logic.checkMove(cood, board, 1);
        
        assertEquals("[1.(b3), 2.(b4)]", moves.toString());
    }
    
    @Test
    public void checkKnightTest() {
        Coordinate cood1 = new Coordinate("b1");
        Coordinate cood2 = new Coordinate("b5");
        Move move = new Move(cood1, cood2);
        board.movePiece(move);
        
        BetterList moves = logic.checkMove(cood2, board, 1);
        
        assertEquals("[1.(c7), 2.(d6), 3.(d4), 4.(c3), 5.(a7), 6.(a3)]", moves.toString());
    }
    
    @Test
    public void checkBishopTest() {
        Coordinate cood1 = new Coordinate("c1");
        Coordinate cood2 = new Coordinate("g6");
        Move move = new Move(cood1, cood2);
        board.movePiece(move);
        
        BetterList moves = logic.checkMove(cood2, board, 1);
        
        assertEquals("[1.(h7), 2.(f7), 3.(f5), 4.(e4), 5.(d3), 6.(h5)]", moves.toString());
    }
    
    @Test
    public void checkRookTest() {
        Coordinate cood1 = new Coordinate("a1");
        Coordinate cood2 = new Coordinate("b4");
        Move move = new Move(cood1, cood2);
        board.movePiece(move);
        
        BetterList moves = logic.checkMove(cood2, board, 1);
        
        assertEquals("[1.(b5), 2.(b6), 3.(b7), 4.(b3), 5.(c4), 6.(d4), 7.(e4), 8.(f4), 9.(g4), 10.(h4), 11.(a4)]", moves.toString());
    }
    
    @Test
    public void checkQueenTest() {
        Coordinate cood1 = new Coordinate("d1");
        Coordinate cood2 = new Coordinate("b4");
        Move move = new Move(cood1, cood2);
        board.movePiece(move);
        
        BetterList moves = logic.checkMove(cood2, board, 1);
        
        assertEquals("[1.(c5), 2.(d6), 3.(e7), 4.(a5), 5.(a3), 6.(c3), 7.(b5), 8.(b6), 9.(b7), 10.(b3), 11.(c4), 12.(d4), 13.(e4), 14.(f4), 15.(g4), 16.(h4), 17.(a4)]", moves.toString());
    }
    
    @Test
    public void chekcKingTest() {
        Coordinate cood1 = new Coordinate("e1");
        Coordinate cood2 = new Coordinate("b4");
        Move move = new Move(cood1, cood2);
        board.movePiece(move);
        
        BetterList moves = logic.checkMove(cood2, board, 1);
        
        assertEquals("[1.(c4), 2.(c5), 3.(a5), 4.(c3), 5.(a3), 6.(a4), 7.(b3), 8.(b5)]", moves.toString());
    }
    
    @Test
    public void startQueenTest() {
        BetterList moves = logic.checkMove(new Coordinate("d8"), board, 0);
        
        assertEquals("[]", moves.toString());
    }
}
