import java.util.ArrayList;

// Student Name Fernando Perez
// Date
// CSCI 3302 Section 001
// 
// Files: MyArrayList.java, MyArrayListException.java
// 
// Description: This program implements an ArrayList and several methods that allow the addition and removal of items in the arrayList.
// some methods used in this program are get(), size(), isEmpty(), remove(), add().

public class MyArrayList {

    private ArrayList<String> lstArray = new ArrayList<String>();
    private int size;

    /**
     * Constructor that initiates lstArray and size
     */
    public MyArrayList() {
        lstArray = new ArrayList<String>(2);
        size = 0;
    }

    /**
     * Method that returns a boolean checking if size of type int is empty or has a
     * value.
     * 
     * @return True or false depending whether size is equal to 0 or not
     */
    public boolean isEmpty() {
        return (size == 0);
    } // End isEmpty

    /**
     * This method is to check for the size of the elements
     * 
     * @return the value size of type integer
     */
    public int size() {

        return size;
    } // end Size

    /**
     * The method add, adds a item of type String to the ArrayList. If the ArrayList
     * is full it will double the ArrayList while
     * keeping its original content.
     * 
     * @param item it is a String type that is added to the array list
     */
    public void add(String item) {
        lstArray.add(item);
        size++;

        if (size == lstArray.size()) { // Checks if the array is full, if so it doubles the array
            ArrayList<String> copyArray = new ArrayList<String>(lstArray.size() * 2);
            copyArray.addAll(lstArray);
            lstArray = copyArray;
        }
    } // End add

    /**
     * This method removes a value at a specified index. It takes in
     * 
     * @param index and removes the index value at the specified index
     * @return Returns the itemRemoved at the specified index
     */
    public String remove(int index) {
        if (index < 0 || index >= lstArray.size())
            throw new MyArrayListException("Index of out range");

        String itemRemoved = lstArray.remove(index);
        size--;

        if (lstArray.size() > 2 && size <= lstArray.size() / 4) { // This checks if the lstArray is less than 25% full
                                                                  // and shrinks the array in half
            ArrayList<String> copyArray = new ArrayList<String>(lstArray.size() / 2);
            copyArray.addAll(lstArray);
            lstArray = copyArray;
        }

        return itemRemoved;
    }// End remove

    /**
     * This method removes an item of type String and at the first occurence and
     * only the first occurence.
     * 
     * @param item It is a type String that the method will check for a remove.
     */
    public void remove(String item) {
        lstArray.remove(item);
        size--;

        if (lstArray.size() > 2 && size <= lstArray.size() / 4) { // This checks if the lstArray is less than 25% full
                                                                  // and shrinks the array in half
            ArrayList<String> copyArray = new ArrayList<String>(lstArray.size() / 2);
            copyArray.addAll(lstArray);
            lstArray = copyArray;
        }
    }// End remove

    /**
     * Method that gets a value at a specified index, and throws and exception if
     * the index value
     * is not in the lstArray.
     * 
     * @param index Type int, where it returns the value at the specified index
     * @return Returns the value at the specified index.
     */
    public String get(int index) {
        if (index < 0 || index >= lstArray.size())
            throw new MyArrayListException("Index of out range");

        return lstArray.get(index);
    }// end get

    /**
     * This method resets the array, and also the size.
     */
    public void removeAll() {
        lstArray.clear();
        size = 0;
    }// end removeAll

} // end class