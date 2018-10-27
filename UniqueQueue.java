package com.company;

/**
 * Unique Queue class for Exercise 4
 * @param <E>
 */
public class UniqueQueue<E> {

    SinglyLinkedList<E> ls;

    /**
     * Uses Singly Linked list implementation
     */
    public UniqueQueue(){
        ls = new SinglyLinkedList<>();
    }
    public int getSize(){
        return ls.getSize();
    }
    public boolean isEmpty(){
        return ls.isEmpty();
    }

    /**
     * For dequeue-ing the first element is used
     * @return  the first element of the linked list
     */
    public E dequeue(){
        return ls.removeFirst();
    }

    /**
     * For enqueue-ing the last element is used
     * Loops over the linked list to check if the element is not repeated,
     * If the list is empty, unique is true, so the element is added
     * @param element   the element to be added
     */
    public void enqueue(E element) {
        boolean unique = true;
        if (!ls.isEmpty()){
            Node nd = ls.getHead();
        for (int i = 0; i < ls.getSize(); i++) {
            if (nd.getElement() == element) {
                unique = false;
            }
            nd = nd.getNext();
        }
    }
        if(unique){
            ls.addLast(element);
        }
    }
}
