/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ficha5_ex1;

import java.util.Iterator;

/**
 *
 * @author vitor
 */
public class ArrayList<T> implements ListADT<T> {

     /**
     *
     * array of generic elements to represent the ArrayList
     */
    protected T[] list;
    /**
     * int that represents the next available position in the ArrayList
     */
    protected int rear;
    /**
     * constant to represent the default capacity of the ArrayList
     */
    protected static int DEFAULT_CAPACITY = 5;

    /**
     * Creates an empty list using the default capacity.
     */
    public ArrayList() {
        this.list = (T[]) (new Object[DEFAULT_CAPACITY]);
        this.rear = 0;
    }

    /**
     * Creates an empty list using the specified capacity.
     *
     * @param tamanho represents the specified capacity
     */
    public ArrayList(int tamanho) {
        this.list = (T[]) (new Object[tamanho]);
        this.rear = 0;
    }

    /**
     * Used only for testing. Adds one element to the rear of this list.
     *
     * @param element the element to be added to the rear of this list
     */
    public void add(T element) {
        if (this.rear == this.list.length) {
            this.expandCapacity();
            list[this.rear] = element;
            this.rear++;
        } else {
            list[this.rear] = element;
            this.rear++;
        }
    }

    /**
     * Used only for testing. Expands the capacity of this queue
     */
    public void expandCapacity() {
        T[] newList = (T[]) (new Object[DEFAULT_CAPACITY * 2]);

        for (int i = 0; i < this.rear; i++) {
            newList[i] = this.list[i];
        }

        this.list = newList;
    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia!");
        } else {
            T removido = this.first();
            for (int i = 0; i < this.rear - 1; i++) {
                this.list[i] = this.list[i + 1];
            }
            this.list[this.rear - 1] = null;
            this.rear--;
            return removido;
        }
    }

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws ficha5edex1.EmptyCollectionException
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia!");
        } else {
            T removido = this.last();
            this.list[this.rear - 1] = null;
            this.rear--;
            return removido;
        }
    }

    /**
     * Removes and returns the specified element from this list.
     *
     * @param element the element to be removed from the list
     * @return the removed element
     * @throws ficha5edex1.EmptyCollectionException
     * @throws ficha5edex1.ElementoNaoExisteException
     */
    @Override
    public T remove(T element) throws EmptyCollectionException, ElementoNaoExisteException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia!");
        }

        int elementPosition = this.find(element);

        if (elementPosition == -1) {
            throw new ElementoNaoExisteException("Elemento não existe!");
        }
        T removido = this.list[elementPosition];
        for (int i = elementPosition; i < this.rear - 1; i++) {
            this.list[i] = this.list[i + 1];
        }
        this.list[this.rear - 1] = null;
        this.rear--;
        return removido;
    }

    /**
     * Returns a reference to the first element in this list.
     *
     * @return a reference to the first element in this list
     * @throws ficha5edex1.EmptyCollectionException
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia!");
        }
        return this.list[0];

    }

    /**
     * Returns a reference to the last element in this list.
     *
     * @return a reference to the last element in this list
     * @throws ficha5edex1.EmptyCollectionException
     */
    @Override
    public T last() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia!");
        }
        return this.list[this.rear - 1];
    }

    /**
     * Método que retorna a posição de um elemento
     *
     * @param element - elemento que procura
     * @return posicao desse elemento
     */
    public int find(T element) {
        for (int i = 0; i < this.rear; i++) {
            if (this.list[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns true if this list contains the specified target element.
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    @Override
    public boolean contains(T target) {
        if (this.find(target) != -1) {
            return true;
        }
        return false;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        //se o rear for a primeira posição
        return this.rear == 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the integer representation of number of elements in this list
     */
    @Override
    public int size() {
        return this.rear;
    }

    /**
     * Returns an iterator for the elements in this list.
     *
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator iterator() {
        return new MyItr();
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (!this.isEmpty()) {
            str.append("Primeiro elemento: ");
            str.append(this.list[0]);
            str.append("\n");
            str.append("Ultimo elemento: ");
            str.append(this.list[this.rear - 1]);
            str.append("\n");
        }
        str.append("Nº elementos: ");
        str.append(this.rear);
        str.append("\n");
        str.append("Tamanho da lista: ");
        str.append(this.list.length);
        str.append("\n");

        for (int i = 0; i < this.size(); i++) {
            str.append(this.list[i]);
            str.append("\n");
        }
        return str.toString();
    }

    /**
     * Class that represents a Iterator
     */
    private class MyItr implements Iterator<T> {

        /**
         * int that represents the position of the iterator
         */
        int cursor = 0;

        /**
         * Creates an Iterator.
         *
         */
        MyItr() {
        }

        /**
         * Verifies if there is a element next to the current
         *
         * @return true if the element exists
         */
        @Override
        public boolean hasNext() {
            return cursor != size();
        }

        /**
         * Moves the iterator to the next position.
         *
         * @return the previous position the cursor was
         */
        @Override
        public T next() {
            int i = cursor;
            if (i >= size()) {
                System.out.println("Nao existe");
            }
            cursor++;
            return list[i];
        }

    }
}
