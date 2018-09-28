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
        
        assertEquals("[b3, b4]", moves.toString());
    }
    
    @Test
    public void checkKnightTest() {
        Coordinate cood1 = new Coordinate("b1");
        Coordinate cood2 = new Coordinate("b5");
        Move move = new Move(cood1, cood2);
        board.movePiece(move);
        
        BetterList moves = logic.checkMove(cood2, board, 1);
        
        assertEquals("[c7, d6, d4, c3, a7, a3]", moves.toString());
    }
    
    @Test
    public void checkBishopTest() {
        Coordinate cood1 = new Coordinate("c1");
        Coordinate cood2 = new Coordinate("g6");
        Move move = new Move(cood1, cood2);
        board.movePiece(move);
        
        BetterList moves = logic.checkMove(cood2, board, 1);
        
        assertEquals("[h7, f7, f5, e4, d3, h5]", moves.toString());
    }
    
    @Test
    public void checkRookTest() {
        Coordinate cood1 = new Coordinate("a1");
        Coordinate cood2 = new Coordinate("b4");
        Move move = new Move(cood1, cood2);
        board.movePiece(move);
        
        BetterList moves = logic.checkMove(cood2, board, 1);
        
        assertEquals("[b5, b6, b7, b3, c4, d4, e4, f4, g4, h4, a4]", moves.toString());
    }
    
    @Test
    public void checkQueenTest() {
        Coordinate cood1 = new Coordinate("d1");
        Coordinate cood2 = new Coordinate("b4");
        Move move = new Move(cood1, cood2);
        board.movePiece(move);
        
        BetterList moves = logic.checkMove(cood2, board, 1);
        
        assertEquals("[c5, d6, e7, a5, a3, c3, b5, b6, b7, b3, c4, d4, e4, f4, g4, h4, a4]", moves.toString());
    }
    
    @Test
    public void chekcKing() {
        Coordinate cood1 = new Coordinate("e1");
        Coordinate cood2 = new Coordinate("b4");
        Move move = new Move(cood1, cood2);
        board.movePiece(move);
        
        BetterList moves = logic.checkMove(cood2, board, 1);
        
        assertEquals("[c4, c5, a5, c3, a3, a4, b3, b5]", moves.toString());
    }
    
}
