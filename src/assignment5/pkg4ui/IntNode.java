/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5.pkg4ui;

/**
 *
 * @author ratid6445
 */
public class IntNode {
    
    private int item;
    private IntNode next;
    
    public IntNode(int num){
        item = num;
        next = null;
    }
    
    /**
     * Returns the number stored in the node
     * @return the stored number
     */
    public int getNum(){
        return item;
    }
    
    /**
     * Returns the node that comes after 
     * @return the next node
     */
    public IntNode getNext(){
        return next;
    }
    
    /** 
     * Sets the node that comes after
     * @param node the node to point to 
     */
    public void setNext(IntNode node){
        next = node;
    }
    
}