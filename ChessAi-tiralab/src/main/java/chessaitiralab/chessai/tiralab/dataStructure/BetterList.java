package chessaitiralab.chessai.tiralab.dataStructure;

/**
 * This is a  list for the times I need a list.
 * It is perfect in every way.
 * 
 * @author hceetu
 */
public class BetterList {
    private Object[] objects;
    private int size;

    public BetterList() {
        objects = new Object[10];
        size = 0;
    }
    /**
     * Adds an object to the list
     * 
     * @param o The object you want to add
     */
    public void add(Object o) {
        if (size == objects.length) {
            resize();
        }
        
        objects[size] = o;
        size++;
    }
    
    /**
     * Returns the object at the given index
     * 
     * @param i index in list
     * @return the object
     */
    public Object get(int i) {
        if(i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.size);
        }
        
        if(i < 0) {
            throw new IndexOutOfBoundsException("Index can't be negative");
        }
        
        return objects[i];
    }
    
    /**
     * Removes the object at the given index
     * 
     * @param index
     * @return the removed object
     */
    public Object remove(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
        
        if(index < 0) {
            throw new IndexOutOfBoundsException("Index can't be negative");
        }
        
        Object removed = objects[index];
        
        for (int i = index; i < size-1; i++) {
            objects[i] = objects[i+1];
        }
        
        size--;
        
        return removed;
    }
    
    /**
     * Returns the number of objects in the list
     * 
     * @return size
     */
    public int size() {
        return this.size;
    }
    
    /**
     * Resizes the list by doubling the maximum length.
     * It does so by making a new list of bigger size and copying the old data
     * to the new list
     */
    public void resize() {
        Object[] nObjects = new Object[objects.length*2];
        
        for (int i = 0; i < size; i++) {
            nObjects[i] = objects[i];
        }
        
        objects = nObjects;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        
        String list = "[";
        
        for (int i = 0; i < size - 1; i++) {
            list += objects[i].toString() + ", ";
        }
        
        list += objects[size-1].toString() + "]";
        
        return list;
    }
    
}
