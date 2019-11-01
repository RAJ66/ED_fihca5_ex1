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

    protected T[] list;
    protected int rear;
    protected static int DEFAULT_CAPACITY = 5;

    public ArrayList() {
        this.list = (T[]) (new Object[DEFAULT_CAPACITY]);
        this.rear = 0;
    }

    public ArrayList(int tamanho) {
        this.list = (T[]) (new Object[tamanho]);
        this.rear = 0;
    }

    //metodo so para testes
    public void add(T element) {
        list[this.rear] = element;
        this.rear++;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementoNaoExisteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T first() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T last() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(T target) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return this.rear==0;
    }

    @Override
    public int size() {
        return this.rear;
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
