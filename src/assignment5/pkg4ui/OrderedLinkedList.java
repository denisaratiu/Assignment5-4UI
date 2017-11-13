/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5.pkg4ui;

import assignment5.pkg4ui.IntNode;

/**
 *
 * @author denisaratiu
 */
public class OrderedLinkedList {

    private IntNode head;
    private IntNode curr;
    private int numItems;

    public OrderedLinkedList() {
        head = null;
        curr = null;

        numItems = 0;
    }

    public void add(int num) {
        // start at beginning of list
        // see if it is first item in the list
        // ...if no items exist 
        if (curr == null) {
            // add first item to list
            // create a node that stores the number
            IntNode temp = new IntNode(num);
            // make the head point to the number
            head = temp;
            // the current value is the number
            curr = temp;
        } else {
            // items exist in the list
            // make a counter 
            int i = -1;
            // store the size in an integer
            int n = size();
            // set the current value as the head
            curr = head;
            // loop through in order to add item in correct sequence
            while (n > i) {

                if (curr.getNum() <= num) {
                    // if the next node is null then the new number is the last number
                    if (curr.getNext() == null) {
                        // create a node that stores the number
                        IntNode temp = new IntNode(num);
                        // link the head to the new node
                        curr.setNext(temp);
                        // set the current value to the 
                        curr = temp;
                        // increase the counter
                        i = n;
                    } else {
                        if (curr.getNext().getNum() <= num) {
                            // continue through the list until the next node is larger than the new item
                            curr = curr.getNext();
                        } else {
                            // the next node is greater than the new item
                            // add the new item before the next node
                            IntNode temp = new IntNode(num);
                            temp.setNext(curr.getNext());
                            curr.setNext(temp);
                            i = n;
                        }
                    }
                } else {
                    // current node is larger than the new item
                    // set the new item as the head
                    //add it to the beginning of the list
                    IntNode temp = new IntNode(num);
                    head = temp;
                    temp.setNext(curr);
                    i = n;
                }
                // increase the counter
                i++;
            }
            // increase the size counter
            numItems++;
        }
    }

    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public int get(int position) {
        IntNode node = head;
        // move the number of times
        for (int i = 0; i < position; i++) {
            node = node.getNext();
        }
        return node.getNum();
    }

    public void remove(int num) {
        // start at beginning of list
        // see if it is first item in the list
        // ...if no items exist 
        if (curr != null) {
            // remove
            // items exist in the list
            // make a counter 
            int i = -1;
            // store the size in an integer
            int n = size();
            // set the current value as the head
            curr = head;
            // define previous node
            IntNode prev = new IntNode(curr.getNum());

            // loop through in order to add item in correct sequence
            while (n > i) {
                // make sure the current number is the number inputted
                if (curr.getNum() == num) {
                    // see if the number wanted to remove is in the head position
                    if (curr == head) {
                        // remove from the head by making the head link to the next item
                        head = curr.getNext();
                        curr = head;
                    } else {
                        // if the number is in the last position (that links to null)
                        if (curr.getNext() == null) {
                            // set previous number to null to remove the link btw the last number and null
                            prev.setNext(null);
                            curr = prev;
                        } else {
                            // set the previous number to the next number
                            prev.setNext(curr.getNext());
                            // get out of the loop by making i equal to n
                            i = n;
                            curr = prev.getNext();
                        }
                    }
                } else {
                    // set the link to the next number
                    prev = curr;
                    curr = curr.getNext();
                }
                // increase the size counter
                i++;
            }
        }
        // if there are no numbers in the link
        if (isEmpty()) {
            System.out.println("There are no more numbers in the list");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OrderedLinkedList list = new OrderedLinkedList();
        // test the add operation
        list.add(2);
        list.add(17);
        list.add(1);
        list.add(5);
        list.add(-5);
        // test the remove operation
        list.remove(17);

        System.out.println(list.get(0));
    }

}
