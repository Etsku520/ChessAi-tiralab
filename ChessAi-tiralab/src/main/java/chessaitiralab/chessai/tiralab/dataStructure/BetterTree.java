package chessaitiralab.chessai.tiralab.dataStructure;

import chessaitiralab.chessai.tiralab.chess.ChessBoard;

/**
 * This s what I use when I need trees.
 * 
 * @author hceetu
 */
public class BetterTree {
    private BetterTree parent;
    private Object o;
    private BetterList children;

    public BetterTree(Object o) {
        this.parent = this;
        this.o = o;
        children = new BetterList();
    }
    
    public void addChild(BetterTree child) {
        child.setParent(this);
        children.add(child);
    }

    public void setParent(BetterTree parent) {
        this.parent = parent;
    }

    public void setO(Object o) {
        this.o = o;
    }

    public BetterTree getParent() {
        return parent;
    }

    public BetterList getChildren() {
        return children;
    }

    public Object getO() {
        return o;
    }

}
