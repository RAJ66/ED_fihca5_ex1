/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ficha5_ex1;

/**
 *
 * @author vitor
 * @param <T>
 */
public class ArrayOrderedList<T extends Comparable> extends ArrayList<T> implements OrderedListADT<T> {

    public ArrayOrderedList() {
    }

    public ArrayOrderedList(int tamanho) {
        super(tamanho);
    }

    @Override
    public void add(T x) {
        
        //meter no inicio sem nada
        if (this.isEmpty()) {
            this.list[0] =  x;
            this.rear++;
            return;
        }
        //meter a meio de cenas
        if (!this.isEmpty()) {
            for (int i = 0; i < this.rear; i++) {
            if (x.compareTo(this.list[i])<0) {
                for (int j = this.rear-1; j >=i; j--) {
                    list[j+1] = list[j];
                }
                list[i] =  x;
                this.rear++;
                return;
            }
        }
        }
        
        //meter no fim
        list[this.rear] =  x;
        this.rear++;

    }

}
