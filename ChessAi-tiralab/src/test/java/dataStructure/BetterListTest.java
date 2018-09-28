
package dataStructure;

import chessaitiralab.chessai.tiralab.dataStructure.BetterList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the list
 * 
 * @author hceetu
 */
public class BetterListTest {
    BetterList list;
    
    
    public BetterListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        list = new BetterList();
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
    public void addAndGetTest() {
        list.add(132);
        assertEquals(132, list.get(0));
    }
    
    @Test
    public void sizeTest() {
        list.add(12);
        list.add(67);
        list.add(34);
        
        assertEquals(3, list.size());
    }
    
    @Test
    public void resizeTest() {
        for (int i = 0; i < 150; i++) {
            list.add(i);
        }
        
        assertEquals(150, list.size());
    }
    
    @Test
    public void removeTest() {
        for (int i = 0; i < 150; i++) {
            list.add(i);
        }
        
        assertEquals(121, list.remove(121));
        assertEquals(149, list.size());
        
       boolean notFound = true;
        for (int i = 0; i < 149; i++) {
            if (list.get(i).equals(121)) {
                notFound = false;
            }
        }
        
        assertTrue(notFound);
    }
    
    @Test
    public void toStringTest() {
        list.add(12);
        list.add(67);
        list.add(34);
        
        assertEquals("[12, 67, 34]", list.toString());
    }
}
