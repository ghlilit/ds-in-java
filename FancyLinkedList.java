package com.company;

public class FancyLinkedList<E> {
    private FancyNode<E> head;
    private FancyNode<E> tail;
    private int size = 0;
    public FancyLinkedList() {}
    public boolean isEmpty(){
        return size==0;
    }
    public FancyNode<E> getHead(){
        return head;
    }
    public void setHead(FancyNode head){
        this.head = head;
    }
    public void addLast(int element){
        FancyNode<E> newTail = new FancyNode(element, null, null);
        if (isEmpty()){
            head = newTail;
        }
        else{
            tail.setNext(newTail);
        }
        tail = newTail;
        size++;
    }

}
