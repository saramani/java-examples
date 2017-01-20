package com.javaexamples;

import java.util.NoSuchElementException;

public class MyCustomQueue<T> {

    private int total;

    private Node first, last;

    private class Node {

        private T ele;
        private Node next;
    }

    public MyCustomQueue<T> enqueue(T ele) {
        Node current = last;
        last = new Node();
        last.ele = ele;

        if (total++ == 0) {
            first = last;
        } else {
            current.next = last;
        }
        return this;
    }

    public T dequeue() {
        if (total == 0) {
            throw new NoSuchElementException();
        }
        T ele = first.ele;
        first = first.next;
        if (--total == 0) {
            last = null;
        }
        return ele;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        Node tmp = first;
        while (tmp != null) {
            sb.append(tmp.ele).append(", ");
            tmp = tmp.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyCustomQueue<String> greeting  = new MyCustomQueue<>();

        greeting.enqueue("Hello").enqueue(", ").enqueue("World!");

        System.out.println(greeting.dequeue() + greeting.dequeue() + greeting.dequeue());
    }

}