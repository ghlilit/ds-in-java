package com.company;

public class Main {
    /**
     *Takes an unsorted stack to sort in descending order, the top element to be the biggest
     * First, it finds the smallest elements by going through all the elements
     * It pushes all the elements from the first stack to the second(except for the minimum)
     * Returns all the elements to the first stack
     * It then puts the smallest one in the second stack
     * It keeps the process until the first stack is empty
     * This works only for integers, so I am not going to put it in the class
     * @param st1       takes the unsorted stack
     * @return          returns the sorted stack
     */
    public static Stack Exercise1(Stack<Integer> st1) {
        Stack<Integer> st2 = new Stack();
        int min, size;
        while(st1.getSize()!=0){
            min = st1.pop();
            size = st1.getSize();
            while (st1.getSize() != 0) {
                if (st1.peek() < min) {
                    st2.push(min);
                    min = st1.pop();
                } else {
                    st2.push(st1.pop());
                }
            }
            for (int i = 0; i < size ; i++) {
                st1.push(st2.pop());
            }
            st2.push(min);
        }
        return st2;
    }
        public static void main (String[]args){
            Stack st = new Stack();
            st.push(4);
            st.push(864);
            st.push(77);
            st.push(864);
            st.push(47);
            st.push(64);
            st.push(407);
            st.push(854);
            st.push(4777);
            //Stack hg = Exercise1(st);
            //while(hg.getSize()!=0)
            //System.out.println(hg.pop());

            Palindrome pd = new Palindrome();
            System.out.println(pd.isPalindrome("BANANA"));
            System.out.println(pd.isPalindrome("BABANANA"));
            System.out.println(pd.isPalindrome("BANANAB"));

            UnlimitedStack un = new UnlimitedStack(2);
            un.push(25);
            un.push(26);
            un.push(222);
           while (un.getSize()!=0){
                System.out.println(un.pop());
            }

            UniqueQueue qu = new UniqueQueue();
            qu.enqueue(444444);
            qu.enqueue("aja");
            qu.enqueue("88");
            qu.enqueue("87");
            qu.enqueue("88");
            qu.enqueue("88");

            while (qu.getSize()!=0){
                System.out.println(qu.dequeue());
            }
        }

    }