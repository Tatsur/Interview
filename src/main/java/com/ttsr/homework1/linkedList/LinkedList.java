package com.ttsr.homework1.linkedList;

public interface LinkedList<E> extends Iterable<E>{

    void insertFirst(E value);
    void insertLast(E value);
    E removeFirst();
    E removeLast();
    boolean remove(E value);
    boolean contains(E value);
    int size();
    boolean isEmpty();
    void display();
    E getFirst();
    E getLast();
    E get(int index);

    class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next) {
            this(item, next, null);
        }

        public Node(E item, Node<E> next, Node<E> previous) {
            this.item = item;
            this.next = next;
            this.prev = previous;
        }
    }
}
