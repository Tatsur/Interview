package com.ttsr.homework1.linkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListImpl<E> implements LinkedList<E> {

    protected int size;
    protected Node<E> firstElement;
    protected Node<E> lastElement;

    @Override
    public void insertFirst(E value) {
        firstElement = new Node<>(value, firstElement);
        size++;
        if (size == 1) {
            lastElement = firstElement;
        }
        if (firstElement.next != null) {
            firstElement.next.prev = firstElement;
        }
    }

    @Override
    public void insertLast(E value) {
        Node<E> newNode = new Node<>(value, null, lastElement);
        if (isEmpty())
            firstElement = newNode;
        else
            lastElement.next = newNode;
        lastElement = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;

        Node<E> removedNode = firstElement;
        firstElement = removedNode.next;
        removedNode.next = null;

        if (firstElement != null) firstElement.prev = null;

        size--;
        return removedNode.item;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) return null;

        Node<E> removedNode = lastElement;

        if (firstElement == lastElement) firstElement = null;

        lastElement = lastElement.prev;

        if (removedNode.prev != null) {
            removedNode.prev.next = null;
            removedNode.prev = null;
        }

        size--;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == firstElement) {
            removeFirst();
            return true;
        } else if (current == lastElement) {
            lastElement = previous;
            previous.next = null;
        } else {
            previous.next = current.next;
            current.next.prev = previous;
        }
        current.next = null;
        current.prev = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value))
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        System.out.println(this);
        System.out.println("----------");
    }

    @Override
    public E getFirst() {
        return getValue(firstElement);
    }

    @Override
    public E getLast() {
        return getValue(lastElement);
    }

    @Override
    public E get(int index) {
        Node<E> current = firstElement;
        int currentIndex = 0;
        while (currentIndex < index){
            current = current.next;
            if(current == null)
                return null;
            currentIndex++;
        }
        return current.item;
    }

    private E getValue(Node<E> node){
        return node != null ? node.item : null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = firstElement;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }

            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E>{

        private final LinkedListImpl<E> list;

        private Node<E> current;
        private Node<E> previous;

        public LinkedListIterator() {
            this.list = LinkedListImpl.this;
            reset();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if(!hasNext())
                throw new NoSuchElementException();
            E nextValue = current.item;
            previous = current;
            current = current.next;
            return nextValue;
        }

        public void reset(){
            current = list.firstElement;
            previous = null;
        }
    }
}
