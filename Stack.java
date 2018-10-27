package com.company;

/**
 * Uses a Singly Linked List for Stack implementation
 * @param <E>
 */
public class Stack <E>{
    private SinglyLinkedList<E> list;

    public Stack() {
        list = new SinglyLinkedList<>();
    }
    public int getSize(){
        return list.getSize();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public void push(E element){
        list.addFirst(element);
    }
    public E pop(){
       return list.removeFirst();
    }
    public E peek(){
        return list.first();
    }
}
