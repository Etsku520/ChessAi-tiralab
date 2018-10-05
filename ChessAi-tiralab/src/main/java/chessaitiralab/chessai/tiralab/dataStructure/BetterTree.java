package chessaitiralab.chessai.tiralab.dataStructure;

import chessaitiralab.chessai.tiralab.chess.ChessBoard;

/**
 * This s what I use when I need trees.
 * 
 * @author hceetu
 */
public class BetterTree {
    private BetterTree parent;
    private Object o1;
    private Object o2;
    private Object o3;
    private BetterList children;

    public BetterTree(Object o1, Object o2, Object o3) {
        this.parent = this;
        this.o1 = o1;
        this.o2 = o2;
        this.o3 = o3;
        children = new BetterList();
    }
    
    public void addChild(BetterTree child) {
        child.setParent(this);
        children.add(child);
    }

    public void setParent(BetterTree parent) {
        this.parent = parent;
    }

    public void setO1(Object o1) {
        this.o1 = o1;
    }

    public BetterTree getParent() {
        return parent;
    }

    public BetterList getChildren() {
        return children;
    }

    public Object getO1() {
        return o1;
    }

    public Object getO2() {
        return o2;
    }

    public void setO2(Object o2) {
        this.o2 = o2;
    }

    public Object getO3() {
        return o3;
    }

    public void setO3(Object o3) {
        this.o3 = o3;
    }
    
    
   
}
