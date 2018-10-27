package com.company;

/**
 * Uses Doubly Linked List to remove the bottom element in constant time
 * @param <E>
 */
public class UnlimitedStack<E> {
    int cap;
    DoublyLinkedList<E> ls;
    static final int defaultSize = 16;
    //The default constructor with capacity of 16
    public UnlimitedStack(){
        ls = new DoublyLinkedList();
        this.cap = defaultSize;
    }
    //Takes an int to set the capacity
    public UnlimitedStack(int cap){
        ls = new DoublyLinkedList();
        this.cap = cap;
    }
    public int getSize(){
        return ls.getSize();
    }
    public boolean isEmpty(){
        return ls.isEmpty();
    }
    public E peek(){
        return ls.first();
    }
    public E pop(){
        return ls.removeFirst();
    }

    /**
     * Checks to see if the capacity is full
     * Removes the bottom element if yes
     * Adds the element as the first element of the list
     * @param element
     */
    public void push(E element){
        if (ls.getSize()==cap){
            ls.removeLast();
        }
            ls.addFirst(element);
    }
}
