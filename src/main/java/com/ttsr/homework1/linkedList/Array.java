package com.ttsr.homework1.linkedList;

import java.util.Arrays;

public class Array<E> {

    private E[] data;
    private int size;

    public Array(int initialCapacity) {
        this.data = (E[]) new Object[initialCapacity];
    }

    public void add(E value) {
        grow();
        data[size++] = value;
    }

    private void grow() {
        if (data.length == size) {
            data = Arrays.copyOf(data, newDataLength());
        }
    }

    private int newDataLength() {
        return size == 0 ? 1 : size * 2;
    }

    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            String errMsg = String.format("Incorrect 'index': %d; max value is %d", index, size - 1);
            throw new IndexOutOfBoundsException(errMsg);
        }
    }

    public boolean remove(E value) {
        int index = indexOf(value);
        return index != -1 && remove(index) != null;
    }

    private int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        checkIndex(index);
        E removedValue = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
        return removedValue;
    }

    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

