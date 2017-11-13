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
        // if there are no items in the list
        if (numItems == 0 && index == 0) {
            // position 0 is the number
            arrayList[0] = num;
            // increase the size counter
            numItems++;
        }
        // if there is room to insert the number
        if (index < arrayList.length) {
            // put the item in the array
            arrayList[index] = num;
            numItems++;

        } else {
            // make more room
            int[] temp = new int[arrayList.length * 2];
            // copy items over
            for (int i = 0; i < arrayList.length; i++) {
                temp[i] = arrayList[i];
            }
            // becomes new array
            arrayList = temp;
            // add item
            arrayList[numItems] = num;
            numItems++;

            // shift positions
            for (int i = numItems - 2; i < index; i++) {
                arrayList[i] = arrayList[i + 1];
            }
            arrayList[index] = num;
        }
    }

    public void remove(int index) {
        // if there are no items in the list cannot remove anything
        if (numItems == 0) {
            System.out.println("There are no items in the list!");
            // if there is one item in the list can only remove that one and you are left with nothing
        } else if (numItems == 1) {
            // decrease the size counter
            numItems--;
            System.out.println("There are no more items in the list!");
            // make sure there are items in the list and the index is less than the num items
        } else if (numItems > 0 && index < numItems) {
            // remove the item 
            for (int i = index; i < numItems; i++) {
                arrayList[i] = arrayList[i + 1];
                // decrease the size counter
                numItems--;
            }
        }
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
        list.add(0, 1);
        list.add(1, 3);
        list.add(2, 4);
        list.add(3, 1);
        list.add(4, 1);
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
    //    list.remove(11);

        //   list.print();
        System.out.println(list.get(15));
        System.out.println();
    }
}
