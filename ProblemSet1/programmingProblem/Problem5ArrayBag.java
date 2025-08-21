/* 
 * ArrayBag.java
 * 
 * Computer Science E-22
 */

package ProblemSet1.programmingProblem;
import java.util.*;

/*
 * An simple implementation of a bag data structure that uses 
 * an array to store the items.
 */
public class Problem5ArrayBag {
    /* 
     * The array used to store the items in the bag.
     */
    private Object[] items;
    
    /* 
     * The number of items in the bag.
     */
    private int numItems;
    
    public static final int DEFAULT_MAX_SIZE = 50;
    
    /*
     * Constructor with no parameters - creates a new, empty ArrayBag with 
     * the default maximum size.
     */
    public Problem5ArrayBag() {
        this.items = new Object[DEFAULT_MAX_SIZE];
        this.numItems = 0;
    }
    
    /* 
     * A constructor that creates a new, empty ArrayBag with the specified
     * maximum size.
     */
    public Problem5ArrayBag(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize must be > 0");
        }
        this.items = new Object[maxSize];
        this.numItems = 0;
    }
    
    /*
     * numItems - accessor method that returns the number of items 
     * in this ArrayBag.
     */
    public int numItems() {
        return this.numItems;
    }
    
    /* 
     * add - adds the specified item to this ArrayBag. Returns true if there 
     * is room to add it, and false otherwise.
     * Throws an IllegalArgumentException if the item is null.
     */
    public boolean add(Object item) {
        if (item == null) {
            throw new IllegalArgumentException("item must be non-null");
        } else if (this.numItems == this.items.length) {
            return false;    // no more room!
        } else {
            this.items[this.numItems] = item;
            this.numItems++;
            return true;
        }
    }
    
    /* 
     * remove - removes one occurrence of the specified item (if any)
     * from this ArrayBag.  Returns true on success and false if the
     * specified item (i.e., an object equal to item) is not in this ArrayBag.
     */
    public boolean remove(Object item) {
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                // Shift the remaining items left by one.
                for (int j = i; j < this.numItems - 1; j++) {
                    this.items[j] = this.items[j + 1];
                }
                this.items[this.numItems - 1] = null;
                
                this.numItems--;
                return true;
            }
        }
        
        return false;  // item not found
    }
    
    /*
     * contains - returns true if the specified item is in the Bag, and
     * false otherwise.
     */
    public boolean contains(Object item) {
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                return true;
            }
        }
        
        return false;
    }
    
    /*
     * containsAll - does this ArrayBag contain all of the items in
     * otherBag?  Returns false if otherBag is null or empty. 
     */
    public boolean containsAll(Problem5ArrayBag otherBag) {
        if (otherBag == null || otherBag.numItems == 0) {
            return false;
        }
        
        for (int i = 0; i < otherBag.numItems; i++) {
            if (! this.contains(otherBag.items[i])) {
                return false;
            }
        }
        
        return true;
    }
    
    /*
     * grab - returns a reference to a randomly chosen item in this ArrayBag.
     */
    public Object grab() {
        if (this.numItems == 0) {
            throw new IllegalStateException("the bag is empty");
        }
        
        int whichOne = (int)(Math.random() * this.numItems);
        return this.items[whichOne];
    }
    
    /*
     * toArray - return an array containing the current contents of the bag
     */
    public Object[] toArray() {
        Object[] copy = new Object[this.numItems];
        
        for (int i = 0; i < this.numItems; i++) {
            copy[i] = this.items[i];
        }
        
        return copy;
    }

    // Problem 5, task 1 methods that finds out how many rooms e.g number of available array to be filled
    public int roomLeft(){
        return this.items.length - this.numItems;
    }

    // problem 5, task 2 method that finds out if the bag is empty
    public boolean isEmpty(){
        return this.numItems == 0;
    }

    // problem 5, task 3 method to increase the capacity of the bags
    public void increaseCapacity(int amount){
        try{
            if(amount < 0) throw new IllegalArgumentException("Error : Value cannot be negative");
            Problem5ArrayBag tmp = new Problem5ArrayBag(this.items.length);
            tmp.addItems(this);
            this.items = new Object[this.items.length + amount];
            this.numItems = 0;
            this.addItems(tmp);
            System.out.println("Capcity increased, current capacity : " + this.items.length + "\n");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    //problem 5, task 4
    public boolean addItems(Problem5ArrayBag other){
        if(other.numItems <= this.roomLeft()){
            for(int i = 0; i < other.numItems; i++){
                this.add(other.items[i]);
            }
            System.out.println("Succesfully added all the item in the second bag!!");
            return true;
        }else{
            System.out.println("Cannot add items : Not enough room capacity!!\n");
            return false;
        }
    }

    //problem 5 task 5 create an arraybag consisting all the element that is intersecting to the parameter
    public Problem5ArrayBag intersectionWith(Problem5ArrayBag other){
        Problem5ArrayBag result = new Problem5ArrayBag(this.items.length + other.items.length);
        for(int i = 0; i < other.numItems; i++){
            if(this.contains(other.items[i]) && !result.contains(other.items[i])){
                result.add(other.items[i]);
            }
        }
        return result;
    }


    /*
     * toString - converts this ArrayBag into a string that can be printed.
     * Overrides the version of this method inherited from the Object class.
     */
    public String toString() {
        String str = "{";
        
        for (int i = 0; i < this.numItems; i++) {
            str = str + this.items[i];
            if (i != this.numItems - 1) {
                str += ", ";
            }
        }
        
        str = str + "}";
        return str;
    }
    
    /* Test the ArrayBag implementation. */
    public static void main(String[] args) {
        // Create a Scanner object for user input.
        Scanner scan = new Scanner(System.in);
        
        // Create an ArrayBag named bag1.
        System.out.print("size of bag 1: ");
        int size = scan.nextInt();
        Problem5ArrayBag bag1 = new Problem5ArrayBag(size);
        scan.nextLine();    // consume the rest of the line
        
        // Read in strings, add them to bag1, and print out bag1.
        String itemStr;        
        for (int i = 0; i < size; i++) {
            System.out.print("item " + i + ": ");
            itemStr = scan.nextLine();
            bag1.add(itemStr);
        }
        System.out.println("bag 1 = " + bag1);
        System.out.println();
        
        // Select a random item and print it.
        Object item = bag1.grab();
        System.out.println("grabbed " + item);
        System.out.println();
        
        // Iterate over the objects in bag1, printing them one per
        // line.
        Object[] items = bag1.toArray();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
        System.out.println();
        
        // Get an item to remove from bag1, remove it, and reprint the bag.
        System.out.print("item to remove: ");
        itemStr = scan.nextLine();
        if (bag1.contains(itemStr)) {
            bag1.remove(itemStr);
        }
        System.out.println("bag 1 = " + bag1);
        System.out.println();


        // Get number of roomleft
        System.out.println("number of room left : " + bag1.roomLeft() + "\n");

        //check if its empty
        if(bag1.isEmpty()) System.out.println("The bag is empty!!\n");
        else System.out.println("The bag is empty!!\n");

        //increasing the capacity
        bag1.increaseCapacity(-1);
        bag1.increaseCapacity(10);
        System.out.println(bag1);
        System.out.println();
        bag1.add("40");
        bag1.add("50");
        bag1.add("60");


        Problem5ArrayBag bag2 = new Problem5ArrayBag(3);
        bag2.add("30");
        bag2.add("50");

        System.out.println("Intersection for bag1 and bag2 : " + bag1.intersectionWith(bag2));
        System.out.println();

        //adding bag 2 to bag 1
        System.out.println("Bag 1 before adding bag 2 : " + bag1);
        bag1.add(bag2);
        System.out.println("Bag1 after adding to bag 2 : " + bag1);
        scan.close();
    }
}
