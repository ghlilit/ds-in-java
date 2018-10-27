package com.company;

public class Node<E> {
    private E element;
    private Node<E> next;
    public Node(E element, Node<E> next){
        this.element = element;
        this.next = next;
    }
    public E getElement(){
        return element;
    }
    public Node<E> getNext(){
        if (next != null)
        return next;
        else
            return null;
    }
    public void setNext(Node<E> next){
        this.next = next;
    }
}
