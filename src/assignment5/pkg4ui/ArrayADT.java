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
public class ArrayADT {

    // store all of the integers on the stack
    private int[] arrayList;
    // keep track of how many items
    private int numItems;

    public ArrayADT() {
        arrayList = new int[10];
        numItems = 0;
    }

    public void add(int index, int num) {
        // if there is room to insert the number
        if (numItems == arrayList.length) {

            // make more room
            int[] temp = new int[arrayList.length * 2];
            // copy items over
            for (int i = 0; i < numItems; i++) {
                temp[i] = arrayList[i];
            }
            // becomes new array
            arrayList = temp;
        }
        // shift positions by shuffling up
        for (int i = numItems - 1; i >= index; i--) {
            arrayList[i + 1] = arrayList[i];
        }
        // put the item in the array
        arrayList[index] = num;
        numItems++;
    }

    public int remove(int index) {
        // create a value that stores the index of the number inputted
        int oldValue = get(index);
        // shuffle down 
        if (index >= 0 && index <= numItems) {
            for (int i = index; i < numItems; i++) {
                arrayList[i] = arrayList[i + 1];
            }
            arrayList[numItems - 1] = arrayList.length - 1;
            // decrease the size counter
            numItems--;
        }
        return oldValue;
    }

    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        // the array is empty
        return numItems == 0;
    }

    public int get(int index) {
        return arrayList[index];
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // create an empty stack
        ArrayADT list = new ArrayADT();
        list.add(0, 19);
        list.add(1, 1);
        list.add(2, 4);
        list.add(3, 9);
        list.add(4, 1);
        list.add(4, 3);
        list.add(4, 5);
        list.add(5, 2);
        list.add(6, 3);
        list.add(7, 1);
        list.add(8, 9);
        list.add(9, 0);
        list.add(10, 2);
        list.add(11, 4);
        list.add(14, 2);
        list.add(14, 3);
        list.add(14, 5);
        list.add(11, 5);
        list.remove(4);

        System.out.println(list.get(16));
    }
}
