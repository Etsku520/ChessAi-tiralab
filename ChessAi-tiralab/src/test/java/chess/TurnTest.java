/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import chessaitiralab.chessai.tiralab.chess.ChessBoard;
import chessaitiralab.chessai.tiralab.chess.Coordinate;
import chessaitiralab.chessai.tiralab.chess.Move;
import chessaitiralab.chessai.tiralab.chess.Turn;
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
public class TurnTest {
    
    public TurnTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ConstructTest() {
        Coordinate cood1 = new Coordinate("e1");
        Coordinate cood2 = new Coordinate("b4");
        Move move = new Move(cood1, cood2);
        
        ChessBoard board = new ChessBoard();
        
        Turn turn = new Turn(board, 0, move);
        
        assertEquals(board, turn.getBoard());
        assertEquals(0, turn.getEaten());
        assertEquals(move, turn.getMove());
        assertEquals(null, turn.getValue());
    }
    
    @Test
    public void SetTest() {
        Coordinate cood1 = new Coordinate("e1");
        Coordinate cood2 = new Coordinate("b4");
        Move move = new Move(cood1, cood2);
        
        ChessBoard board = new ChessBoard();
        
        Turn turn = new Turn(null, 0, null);
        turn.setBoard(board);
        turn.setEaten(2);
        turn.setMove(move);
        turn.setValue(200);
        
        assertEquals(board, turn.getBoard());
        assertEquals(2, turn.getEaten());
        assertEquals(move, turn.getMove());
        assertEquals((Integer) 200, turn.getValue());
    }
}
