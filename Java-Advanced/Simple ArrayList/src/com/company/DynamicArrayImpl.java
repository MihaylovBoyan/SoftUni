package com.company;

public class DynamicArrayImpl<E> implements DynamicArray<E> {

    Object[] elements = new Object[1];

    int size = 0;


    public boolean add(E element) {

        elements[size] = element;
        size++;

        if (size >= elements.length) {

            Object[] newElements = new Object[size * 2];

            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }

            elements = newElements;
        }

        return true;
    }

    @Override
    public E get(int index) {

        checkIndex(index);
        return (E) elements[index];

    }


    @Override
    public E set(int index, E element) {

        checkIndex(index);
        elements[index] = element;
        return (E) element;
    }

    @Override
    public E remove(int index) {

        E removedElement = (E) elements[index];
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;

        return removedElement;
    }

    @Override
    public int size() {
        return this.size;
    }

    private void checkIndex(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}