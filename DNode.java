package com.company;

/**
 * A simple Node class for Doubly linked lists.
 * @param <E>
 */
public class DNode <E> {
    private E element;
    private DNode<E> prev;
    private DNode<E> next;

    /**
     * Constructs a Node for Doubly Linked Lists
     * @param element   the element to be stored
     * @param prev      the previous Node
     * @param next      the next Node
     */
    public DNode(E element,DNode prev, DNode next ){
        this.element=element;
        this.prev=prev;
        this.next=next;
    }
    //getters and setters for the three fields
    public E getElement() {
        return element;
    }

    public DNode<E> getPrev() {
        return prev;
    }

    public DNode<E> getNext() {
        return next;
    }

    public void setPrev(DNode<E> prev) {
        this.prev = prev;
    }

    public void setNext(DNode<E> next) {
        this.next = next;
    }

}
