/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafiskavltree;

import java.util.Collection;

/**
 * Interface for Tree
 * @author Mikael
 * @param <E>
 */
public interface Tree<E> extends Collection<E> { 
    
    /** Return true if the element is in the tree */ 
    public boolean search(E e);
    
    public boolean insert(E e);
    
    public boolean delete(E e);
    
    public int getSize(); 
    
    public default void inorder() { 
    }
    
    public default void postorder() {
    }
    
    public default void preorder() {
    }
    
    @Override /** Return true if the tree is empty */
    public default boolean isEmpty() { 
        return size() == 0;
    }
    
    @Override
    public default boolean contains(Object e) {
        return search((E)e);
    }
    @Override
    public default boolean add(E e) {
        return insert(e);
    }
    
    @Override
    public default boolean remove(Object e) {
        return delete((E)e);
    }
    
    @Override
    public default int size() {
        return getSize();
    }
    
    @Override
    public default boolean containsAll(Collection<?> c) {
        return false;
    }
    
    @Override
    public default boolean addAll(Collection<? extends E> c) {
        return false;
    }
    
    @Override
    public default boolean removeAll(Collection<?> c) {
        return false;
    }
    
    @Override
    public default boolean retainAll(Collection<?> c) {
        return false;
    }
    
    @Override
    public default Object[] toArray() {
        return null;
    }
    
    @Override
    public default <T> T[] toArray(T[] array) {
        return null;
    }
}
