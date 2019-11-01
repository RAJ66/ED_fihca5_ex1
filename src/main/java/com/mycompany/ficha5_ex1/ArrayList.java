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
    protected static int DEFAULT_CAPACITY = 3;

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
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia!");
        }

        //guarda item a ser removido
        T removido = this.first();

        for (int i = 0; i < this.size() - 1; i++) {
            this.list[i] = this.list[i + 1];
        }

        //coloca o ultimo elemento a null
        this.list[this.rear - 1] = null;

        //decrementa rear
        this.rear--;

        //retorna item removido
        return removido;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        //se a lista estiver vazia
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia!");
        }
        //guarda item a ser removido
        T removido = this.last();

        //coloca posicao desse item a null
        this.list[this.rear - 1] = null;
        //decrementa rear
        this.rear--;
        return removido;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementoNaoExisteException {
        //se a lista estiver vazia
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia!");
        }
        
        int elementPosition = this.find(element);
        
        if (elementPosition == -1) {
             throw new ElementoNaoExisteException("Elemento não existe!");
        }
        
        //guarda o item a ser removido
        T removido = this.list[elementPosition];
        
        
         for (int i = elementPosition; i < this.rear - 1; i++) {
                this.list[i] = this.list[i + 1];
            }
         
         //coloca posição desse item a null
        this.list[this.rear - 1] = null;
        
        //decrementa rear
        this.rear--;
        
         return removido;

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

    @Override
    public T first() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia!");
        }
        return this.list[0];
    }

    @Override
    public T last() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia!");
        }
        return this.list[this.rear - 1];
    }

    @Override
    public boolean contains(T target) {
        if (this.find(target) != -1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.rear == 0;
    }

    @Override
    public int size() {
        return this.rear;
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        str.append(this.size());
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

}
