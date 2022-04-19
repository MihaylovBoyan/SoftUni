package com.company;

public interface DynamicArray<E> {

     boolean add(E element);

    E get(int index);

    E set(int index, E element);

    E remove(int index);

    int size();


}
