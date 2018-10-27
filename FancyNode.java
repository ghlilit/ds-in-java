package com.company;

public class FancyNode<Integer> {
    private FancyNode<Integer> next;
    private FancyNode<Integer> down;
    private int element;

    public FancyNode(int element, FancyNode<Integer> next, FancyNode <Integer> down){
        this.element = element;
        this.next = next;
        this.down = down;
    }
    public int getElement(){
        return element;
    }
    public FancyNode<Integer> getNext(){
        if (next != null)
            return next;
        else
            return null;
    }
    public FancyNode<Integer> getDown(){
        if (down != null)
            return down;
        else
            return null;
    }
    public void setNext(FancyNode<Integer> next){
        this.next = next;
    }
    public void setDown(FancyNode<Integer> down){
        this.down = down;
    }
}
