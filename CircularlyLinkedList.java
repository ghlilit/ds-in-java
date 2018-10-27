package com.company;

public class CircularlyLinkedList<E> {
    private Node<E> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {
    }
    public Node<E> getTail(){
        return tail;
    }
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void rotate() {
        if (tail != null)
            tail = tail.getNext();
    }

    public void addFirst(E element) {
        if (size == 0) {
            tail = new Node(element, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node(element, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(E element) {
        addFirst(element);
        rotate();
    }

    public E removeFirst() {
        if (isEmpty()){
            return null;
        }
        else{
            Node<E> head = tail.getNext();
            if(head==tail){
                tail=null;
            }
            else{
                tail.setNext(head.getNext());
                size--;
            }
            return head.getElement();
        }
    }
}
