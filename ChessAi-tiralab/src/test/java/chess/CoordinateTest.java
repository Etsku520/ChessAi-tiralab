/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import chessaitiralab.chessai.tiralab.chess.Coordinate;
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
public class CoordinateTest {
    
    public CoordinateTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void getXTest() {
        Coordinate cood = new Coordinate("b4");
        
        assertEquals(2, cood.getX());
    }
    
    @Test
    public void getYTest() {
        Coordinate cood = new Coordinate("b4");
        
        assertEquals(4, cood.getY());
    }
    
    @Test
    public void toStringTest() {
        Coordinate cood = new Coordinate("b4");
        
        assertEquals("b4", cood.toString());
    }
    
    @Test
    public void intConstructorTest() {
        Coordinate cood = new Coordinate(24);
        
        assertEquals("b4", cood.toString());
    }
    
}

