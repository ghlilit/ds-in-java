package com.company;

public class Main {

    //removes the repeated elements in a linked list
    //checks if the element is equal to its next one and if true sets its next one the next next one
    //takes the head of a Singly linked list

    public static void Exercise1(Node<Integer> head) {
        Node<Integer> current = head;
        while (current.getNext() != null) {
            if (current.getElement() == current.getNext().getElement())
                current.setNext(current.getNext().getNext());
            else
                current = current.getNext();
        }
    }

    //calculates the average of the Circularly linked list
    /*first the size is 1 and the sum is the tail number, as we loop over we add other elements incrementing the size until we get to the tail
    takes the tail of the circularly linked list, returns a double which is the sum*/
    public static double Exercise2(Node<Integer> tail) {
        double sum = tail.getElement();
        int size = 1;
        Node<Integer> current = tail.getNext();
        while (current != tail) {
            sum += current.getElement();
            current = current.getNext();
            size++;
        }
        return sum / size;
    }

    /*inserts a list into another one , uses a function called insert, which inserts a node in a sigly linked list, keeping it in place
    keeps two pointers, one to see where we are in the first list and one to keep the next node of the element that is going to be inserted
    As you can't change Object values in Java , I am printing the head node of the second list
    */
    public static void Exercise3(Node head1, Node head2) {

        if (head1 == null || head2 == null) {
            System.out.println("Add elements to the list");
        }
        Node current = head1;
        Node next2 = head2.getNext();
        while (current != null && head2 != null) {
            insert(current, head2);
            current = current.getNext().getNext();
            head2 = next2;
            if (next2 != null)
                next2 = next2.getNext();
        }
        //checks if there are elements left in the second list
        if (head2 != null)
            System.out.println(head2.getElement() + " is the new head of the second list. You can't change the node reference inside functions in Java.");
        else
            System.out.println("The second list is empty.");
    }

    public static void insert(Node nd, Node toInsert) {
        Node ptr = nd.getNext();
        nd.setNext(toInsert);
        toInsert.setNext(ptr);
    }

    /* reverses an array, takes a node, returns a node ,keeps three arrays , one to set its next one the one which
    was its previous before and one to not lose the other elements of the array. All pointers move with each change step.
    takes the head and returns the head node of the reversed singly linked list, as you can not change it inside the function
    */
    public static Node Exercise4(Node head) {
        Node prev = head;
        Node current = head.getNext();
        Node next = current.getNext();
        prev.setNext(null);
        while (next != null) {
            current.setNext(prev);
            prev = current;
            current = next;
            next = current.getNext();
        }
        current.setNext(prev);
        return current;
    }

    /*Takes the head of the linked list, saves its next node twice , one for merging the list below the head and
    the list below the next one together and one to keep the rest of the array
    The merge function is the insertion , it takes two nodes which have lists below them ,
     merges them and returns the head of the new one . You keep going until the saved next one is empty.
    At the end I get a vertical list with all nodes sorted and the function returns its head.
     I could reverse it to make it horizontal , but you get the idea anyways))*/
    public static void Exercise5(FancyNode hd) {
        FancyNode next = hd.getNext();
        FancyNode saved = hd.getNext();
        while(next!=null) {
            insertion(hd, next);
            next = saved;
            if (saved!=null)
            saved = saved.getNext();
        }
    }
    /* The merge function first checks if the first one is empty, if true , inserts all the other elements from the second one below it
    nNd is for not losing the elements of the second array when inserting.
    Then it checks if the element on which we are in the second array( we keep the pointer nd2) is bigger than the element which comes after the pointer of the first one
    if true , it inserts before it (after nd1) , if no it just keep moving along the two arrays
    You keep doing this until the second array is empty.
     */
    public static void insertion(FancyNode nd1, FancyNode nd2) {
        FancyNode nNd2 = null;
        if(nd1.getDown() == null ){
            nNd2 = nd2.getDown();
            insertFancy(nd1, nd2);
            nd1 = nd1.getDown();
            nd2 = nNd2;
        }
        else if (nd1.getDown().getElement() > nd2.getElement()) {
            nNd2 = nd2.getDown();
            insertFancy(nd1, nd2);
            nd1 = nd1.getDown();
            nd2 = nNd2;
        } else
            nd1 = nd1.getDown();

        if(nd2!=null){
            insertion(nd1, nd2);
        }
    }

    //Does the same thing as the Insert function , but with fancy nodes
    public static void insertFancy(FancyNode nd, FancyNode toInsert) {
        FancyNode ptr = nd.getDown();
        nd.setDown(toInsert);
        toInsert.setDown(ptr);
    }

    //Everything else is Exercise 6
    //returns the number of integers of a linked list
    public static int readN(Node <Integer> head){
        int num = 0;
        while (head!=null){
            num++;
            head = head.getNext();
        }
        return num;
    }

    //returns the content of the number list
    public static String read(Node <Integer> head){
        String str = " ";
        while (head!=null){
            str += head.getElement();
            head = head.getNext();
        }
            return str;
    }

    /*adds two linked list numbers, first it reverses them , then adds  node by node adding a carry as well and creating
    a new node with the result. At the end it returns the head node, if one of the numbers is over, it keeps adding to its digits the
    carry and creating new nodes */
    public static Node<Integer> addition(Node<Integer> head, Node<Integer> head2){
        boolean equal;
        //these are for keeping a copy of the tails to reverse them back
        Node hd = null;
        Node hd2 = null;
        equal = (head==head2);
        //in case the numbers are equal you don't reverse them twice
        if (equal){
            head = Exercise4(head);
            head2 = head;
             hd = head;
        }
        else{
            head = Exercise4(head);
             hd = head;
            head2 = Exercise4(head2);
             hd2 = head2;
        }
        Node <Integer> nnd = null;
        Node <Integer> copy = null;
        int sum;
        int carry = 0;
        while (head!=null & head2!=null){
            sum = carry + head.getElement() + head2.getElement();
            head = head.getNext();
            head2 = head2.getNext();
            nnd = new Node<Integer>(sum%10, copy);
            copy = nnd;
            if (sum >9){
                carry = 1;
            }
            else{
                carry =0;
            }
        }
        //if one of the elements not over
        while(head!=null){
            sum = carry +head.getElement();
            head = head.getNext();
            nnd = new Node<Integer>(sum%10, copy);
            copy = nnd;
            if (sum >9){
                carry = 1;
            }
            else{
                carry =0;
            }
        }
        while(head2!=null){
            sum = carry +head2.getElement();
            head2 = head2.getNext();
            nnd = new Node<Integer>(sum%10, copy);
            copy = nnd;
            if (sum >9){
                carry = 1;
            }
            else{
                carry =0;
            }
        }
        //in case the numbers are over but you still have the carry , adds a new node
        if (carry == 1){
            nnd = new Node<Integer>(1, copy);
        }
        //reversing the array, again checking for the equality case first
        if (equal){
            head = Exercise4(hd);
        }
        else{
            head = Exercise4(hd);
            head2 = Exercise4(hd2);
        }
        return nnd;
    }

    /*Subtracts two linked list numbers, first it reverses them, subtracts int by int keeping a borrow and creating a
    new node with every result. At the end when there are digits left it will keep creating new nodes subtracting the borrow
    It assumes the result will not be negative*/
    public static Node<Integer> subtraction(Node<Integer> head, Node<Integer> head2){
        head = Exercise4(head);
        Node hd = head;
        head2 = Exercise4(head2);
        Node hd2 = head2;
        Node <Integer> nnd = null;
        Node <Integer> copy = null;
        int sub;
        int borrow = 0;
        while (head!=null & head2!=null){
            sub = head.getElement() - head2.getElement() - borrow;
            head = head.getNext();
            head2 = head2.getNext();
            nnd = new Node<Integer>((sub + 10) % 10, copy);
            copy = nnd;
            if (sub < 0){
                borrow = 1;
            }
            else{
                borrow =0;
            }
        }
        while(head!=null){
            sub = head.getElement()-borrow;
            head = head.getNext();
            nnd = new Node<Integer>((sub+10)%10, copy);
            copy = nnd;
            if (sub <0){
                borrow = 1;
            }
            else{
                borrow =0;
            }
        }
        head = Exercise4(hd);
        head2 = Exercise4(hd2);
        return nnd;
    }
//Here are functions to print linked lists, Fancy Lists(linked list with down arrays), and Circular Lists
    //this is the same function Ex6 wants anyways, which is for printing the number
    public static void printList(Node head){
        while (head!=null){
            System.out.print(head.getElement()+ " ");
            head=head.getNext();
        }
    }

    public static void printCircList(Node tail){
        Node head = tail.getNext();
        while (head!= tail ){
            System.out.print(head.getElement()+ " ");
            head=head.getNext();
        }
        System.out.print(tail.getElement()+ " ");
    }

    public static void printFancyList(FancyNode head){
        while (head!=null){
            System.out.print(head.getElement()+ " ");
            head=head.getDown();
        }
    }

//Welcome to main. Here I pretend everything works flawlessly.
    public static void main(String[] args) {
        String[] unsorted = new String[5];
        SinglyLinkedList<Integer> trial = new SinglyLinkedList<Integer>();
        trial.addLast(15);
        trial.addLast(15);
        trial.addLast(6);
        trial.addLast(3);
        trial.addLast(3);
        SinglyLinkedList<Integer> trial2 = new SinglyLinkedList<Integer>();
        trial2.addLast(15);
        trial2.addLast(14);
        trial2.addLast(7);
        trial2.addLast(10);
        CircularlyLinkedList<Integer> trial3 = new CircularlyLinkedList<Integer>();
        trial3.addLast(15);
        trial3.addLast(15);
        trial3.addLast(6);
        trial3.addLast(3);
        trial3.addLast(3);

        //Exercise 1 check
        System.out.println("Exercise1: The list is");
        printList(trial.getHead());
        Exercise1(trial.getHead());
        System.out.println("\nThe new list is");
        printList(trial.getHead());

        //Exercise 2 check
        System.out.println("\nExercise2: The Circularly list is");
        printCircList(trial3.getTail());
        System.out.println("\n The sum is " + Exercise2(trial3.getTail()) + "\n");

        //Exercise 3 check
        System.out.println(" \nExercise3:  The first list is");
        printList(trial.getHead());
        System.out.println(" \nThe second list is");
        printList(trial2.getHead());
        System.out.println(" \nThe result:");
        Exercise3(trial.getHead(), trial2.getHead());
        System.out.println("The first list:");
        printList(trial.getHead());
        System.out.println();

        //Exercise 4 check
        System.out.println(" \nExercise4:  The initial list is");
        printList(trial.getHead());
        Node hd = Exercise4(trial.getHead());
        System.out.println(" \nThe new list is");
        printList(hd);
        System.out.println();

        //Exercise 5 check
        FancyLinkedList fnc = new FancyLinkedList();
        //manually creating the list
        FancyNode down42 = new FancyNode(22, null, null );
        FancyNode down41 = new FancyNode(21, null, down42 );
        FancyNode next4 = new FancyNode(20, null, down41 );
        FancyNode down31 = new FancyNode(23, null, null );
        FancyNode next3 = new FancyNode(15, next4, down31 );
        FancyNode down22 = new FancyNode(25, null, null );
        FancyNode down21 = new FancyNode(12, null, down22 );
        FancyNode next2 = new FancyNode(8, next3, down21 );
        FancyNode down14 = new FancyNode(11, null, null );
        FancyNode down13 = new FancyNode(7, null, down14 );
        FancyNode down12 = new FancyNode(6, null, down13 );
        FancyNode next1 = new FancyNode(3, next2, down12 );
        fnc.setHead(next1);
        //This did take forever

        System.out.println(" \nExercise5:  The lists are");
        printFancyList(next1);
        System.out.println();
        printFancyList(next2);
        System.out.println();
        printFancyList(next3);
        System.out.println();
        printFancyList(next4);
        System.out.println(" \nThe new list is");
        Exercise5(next1);
        printFancyList(next1);
        System.out.println();

        SinglyLinkedList<Integer> trial4 = new SinglyLinkedList<Integer>();
        trial4.addLast(8);
        trial4.addLast(1);
        trial4.addLast(1);
        trial4.addLast(1);
        SinglyLinkedList<Integer> trial5 = new SinglyLinkedList<Integer>();
        trial5.addLast(1);
        trial5.addLast(6);
        trial5.addLast(4);
        trial5.addLast(1);
        System.out.println( "\nExercise 6: The sizes are " + readN(trial4.getHead())+ " and " + readN(trial5.getHead()));
        System.out.println(read(trial4.getHead())+ " added " + read(trial5.getHead()) + " is");
        System.out.println(read(addition(trial4.getHead(), trial5.getHead())));

        SinglyLinkedList<Integer> i = new SinglyLinkedList<Integer>();
        i.addLast(8);
        i.addLast(1);
        i.addLast(9);
        i.addLast(1);
        SinglyLinkedList<Integer> j  = new SinglyLinkedList<Integer>();
        j.addLast(5);
        j.addLast(6);
        j.addLast(4);
        j.addLast(1);

        System.out.println(read(i.getHead())+ " is i and  " + read(j.getHead()) + " is j ");
        System.out.println( "i plus i ");
        System.out.println(read(addition(i.getHead(), i.getHead())));
        System.out.println( "i minus j ");
        System.out.println(read(subtraction(i.getHead(), j.getHead())));
        System.out.println( "i plus j ");
        System.out.println(read(addition(i.getHead(), j.getHead())));
        System.out.println( "i plus j plus i plus j");
        System.out.println(read(addition(addition(i.getHead(), j.getHead()),addition(i.getHead(), j.getHead()))));
    }
}
