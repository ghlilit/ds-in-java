package com.company;

/**
 * Doubly Linked List is used for the Unlimited Stack
 * Has methods addBetween and Remove for adding and removing first and last elements easier
 * Has dummy nodes header and trailer for the same purpose
 * @param <E>
 */

public class DoublyLinkedList<E>{
    int size = 0;
    private DNode<E> header;
    private DNode<E> trailer;

    public DoublyLinkedList(){
        header = new DNode(null, null, null);
        trailer = new DNode(null, header, null);
        header.setNext(trailer);
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public E first(){
        if (isEmpty()){
            return null;
        }
        return header.getNext().getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return trailer.getPrev().getElement();
    }

    private void addBetween(E element, DNode<E> before, DNode<E> after){
        DNode<E> newest = new DNode<E>(element, before, after);
        before.setNext(newest);
        after.setPrev(newest);
        size++;
    }
    private E remove(DNode<E> nd){
        DNode prev = nd.getPrev();
        DNode next = nd.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        size--;
        return nd.getElement();
    }
    public void addFirst(E element) {
        addBetween(element, header, header.getNext());
    }
    public void addLast(E element){
        addBetween(element, trailer.getPrev(), trailer);
    }
    public E removeFirst(){
        if (isEmpty())
            return null;
        else
             return remove(header.getNext());
    }
    public E removeLast(){
        if (isEmpty())
            return null;
        else
            return remove(trailer.getPrev());
    }
}
