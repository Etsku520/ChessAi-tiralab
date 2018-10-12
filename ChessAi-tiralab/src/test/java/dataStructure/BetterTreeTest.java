/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataStructure;

import chessaitiralab.chessai.tiralab.chess.Turn;
import chessaitiralab.chessai.tiralab.dataStructure.BetterTree;
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
public class BetterTreeTest {
    
    public BetterTreeTest() {
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
    public void constructTest() {
        Turn turn = new Turn(null, 2, null);
        BetterTree tree = new BetterTree(turn);
        
        assertEquals(turn, tree.getO());
        assertEquals(tree, tree.getParent());
        assertEquals(0, tree.getChildren().size());
    }
    
    @Test
    public void addChildrenTest() {
        BetterTree tree = new BetterTree(null);
        BetterTree tree2 = new BetterTree(null);
        BetterTree tree3 = new BetterTree(null);
        
        tree.addChild(tree2);
        tree.addChild(tree3);
        
        assertEquals(tree2, tree.getChildren().get(0));
        assertEquals(tree3, tree.getChildren().get(1));
    }
    
    @Test
    public void addChildrenParentTest() {
        BetterTree tree = new BetterTree(null);
        BetterTree tree2 = new BetterTree(null);
        BetterTree tree3 = new BetterTree(null);
        
        tree.addChild(tree2);
        tree.addChild(tree3);
        
        BetterTree child1 = (BetterTree) tree.getChildren().get(0);
        BetterTree child2 = (BetterTree) tree.getChildren().get(1);
        
        assertEquals(tree, child1.getParent());
        assertEquals(tree, child2.getParent());
    }
    
    @Test
    public void setOTest() {
        BetterTree tree = new BetterTree(null);
        Turn turn = new Turn(null, 2, null);
        tree.setO(turn);
        
        assertEquals(turn, tree.getO());
    }
}
