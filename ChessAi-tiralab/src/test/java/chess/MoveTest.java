/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

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
public class MoveTest {
    
    public MoveTest() {
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
    public void ConstructorTest() {
        Coordinate cood1 = new Coordinate("e1");
        Coordinate cood2 = new Coordinate("b4");
        Move move = new Move(cood1, cood2);
        
        assertEquals(cood1, move.getCoodB());
        assertEquals(cood2, move.getCoodE());
        assertEquals(cood1.getX(), move.getXb());
        assertEquals(cood2.getX(), move.getXe());
        assertEquals(cood1.getY(), move.getYb());
        assertEquals(cood2.getY(), move.getYe());
    }
    
    @Test
    public void EqualsTest() {
        Coordinate cood1 = new Coordinate("e1");
        Coordinate cood2 = new Coordinate("b4");
        Move move1 = new Move(cood1, cood2);
        
        Coordinate cood3 = new Coordinate("e1");
        Coordinate cood4 = new Coordinate("b4");
        Move move2 = new Move(cood3, cood4);
        
        Coordinate cood5 = new Coordinate("e6");
        Coordinate cood6 = new Coordinate("b4");
        Move move3 = new Move(cood5, cood6);
        
        assertTrue(move1.equals(move2));
        assertFalse(move3.equals(move2));
    }
}
