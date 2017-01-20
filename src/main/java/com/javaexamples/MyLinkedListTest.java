package com.javaexamples;

public class MyLinkedListTest {

    public static MyLinkedList myLinkedList;

    public static void main(String[] args) {

        // Default constructor - let's put "0" into head element.
        myLinkedList = new MyLinkedList();

        // add more elements to LinkedList
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");
        myLinkedList.add("4");
        myLinkedList.add("5");

		/*
         * Please note that primitive values can not be added into LinkedList directly. They must be converted to their
		 * corresponding wrapper class.
		 */

        System.out.println("Print: myLinkedList: \t\t" + myLinkedList);
        System.out.println(".size(): \t\t\t\t" + myLinkedList.size());
        System.out.println(".get(3): \t\t\t\t" + myLinkedList.get(3) + " (get element at index:3 - list starts from 0)");
        System.out.println(".remove(2): \t\t\t\t" + myLinkedList.remove(2) + " (element removed)");
        System.out.println(".get(3): \t\t\t\t" + myLinkedList.get(3) + " (get element at index:3 - list starts from 0)");
        System.out.println(".size(): \t\t\t\t" + myLinkedList.size());
        System.out.println("Print again: myLinkedList: \t" + myLinkedList);
    }

}

class MyLinkedList {

    private static int counter;

    private Node head;

    // Default constructor
    public MyLinkedList() {

    }

    // appends the specified element to the end of this list.
    public void add(Object data) {

        // Initialize Node only incase of 1st element
        if (head == null) {
            head = new Node(data);
        }

        Node myLinkedTemp = new Node(data);
        Node myLinkedListCurrent = head;

        // Let's check for NPE before iterate over myLinkedListCurrent
        if (myLinkedListCurrent != null) {

            // starting at the head node, crawl to the end of the list and then add element after last node
            while (myLinkedListCurrent.getNext() != null) {
                myLinkedListCurrent = myLinkedListCurrent.getNext();
            }

            // the last node's "next" reference set to our new node
            myLinkedListCurrent.setNext(myLinkedTemp);
        }

        // increment the number of elements variable
        incrementCounter();
    }

    private static int getCounter() {
        return counter;
    }

    private static void incrementCounter() {
        counter++;
    }

    private void decrementCounter() {
        counter--;
    }

    // inserts the specified element at the specified position in this list
    public void add(Object data, int index) {
        Node myLinkedTemp = new Node(data);
        Node myLinkedListCurrent = head;

        // Let's check for NPE before iterate over myLinkedListCurrent
        if (myLinkedListCurrent != null) {
            // crawl to the requested index or the last element in the list, whichever comes first
            for (int i = 0; i < index && myLinkedListCurrent.getNext() != null; i++) {
                myLinkedListCurrent = myLinkedListCurrent.getNext();
            }
        }

        // set the new node's next-node reference to this node's next-node reference
        myLinkedTemp.setNext(myLinkedListCurrent.getNext());

        // now set this node's next-node reference to the new node
        myLinkedListCurrent.setNext(myLinkedTemp);

        // increment the number of elements variable
        incrementCounter();
    }

    public Object get(int index)
    // returns the element at the specified position in this list.
    {
        // index must be 1 or higher
        if (index < 0)
            return null;
        Node myLinkedListCurrent = null;
        if (head != null) {
            myLinkedListCurrent = head.getNext();
            for (int i = 0; i < index; i++) {
                if (myLinkedListCurrent.getNext() == null)
                    return null;

                myLinkedListCurrent = myLinkedListCurrent.getNext();
            }
            return myLinkedListCurrent.getData();
        }
        return myLinkedListCurrent;

    }

    // removes the element at the specified position in this list.
    public boolean remove(int index) {

        // if the index is out of range, exit
        if (index < 1 || index > size())
            return false;

        Node myLinkedListCurrent = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (myLinkedListCurrent.getNext() == null)
                    return false;

                myLinkedListCurrent = myLinkedListCurrent.getNext();
            }
            myLinkedListCurrent.setNext(myLinkedListCurrent.getNext().getNext());

            // decrement the number of elements variable
            decrementCounter();
            return true;

        }
        return false;
    }

    // returns the number of elements in this list.
    public int size() {
        return getCounter();
    }

    public String toString() {
        String output = "";

        if (head != null) {
            Node myLinkedListCurrent = head.getNext();
            while (myLinkedListCurrent != null) {
                output += "[" + myLinkedListCurrent.getData().toString() + "]";
                myLinkedListCurrent = myLinkedListCurrent.getNext();
            }

        }
        return output;
    }

    private class Node {

        // reference to the next node in the chain, or null if there isn't one.
        Node next;

        // data carried by this node. could be of any type you need.
        Object data;

        // Node constructor
        public Node(Object dataValue) {
            next = null;
            data = dataValue;
        }

        // another Node constructor if we want to specify the node to point to.
        @SuppressWarnings("unused")
        public Node(Object dataValue, Node nextValue) {
            next = nextValue;
            data = dataValue;
        }

        // these methods should be self-explanatory
        public Object getData() {
            return data;
        }

        @SuppressWarnings("unused")
        public void setData(Object dataValue) {
            data = dataValue;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextValue) {
            next = nextValue;
        }

    }
}
