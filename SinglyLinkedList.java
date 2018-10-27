package com.company;

public class SinglyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;
    public SinglyLinkedList() {}

    public Node<E> getHead(){
        return head;
    }
    public void setHead(Node head){
        this.head = head;
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
        return head.getElement();
    }
    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }
    public void addFirst(E element) {
        head = new Node(element, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }
    public void addLast(E element){
        Node<E> newTail = new Node(element, null);
        if (isEmpty()){
            head = newTail;
        }
        else{
            tail.setNext(newTail);
        }
        tail = newTail;
        size++;
    }
        public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size==0){
            tail = null;
        }
        return answer;
    }

}
