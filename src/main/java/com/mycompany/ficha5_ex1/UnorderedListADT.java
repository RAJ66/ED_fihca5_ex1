/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ficha5_ex1;

/**
 *
 * @author vitor
 */
public interface UnorderedListADT<T> extends ListADT<Object>{
    public void addToFront(T element);
        public void addToRear(T element);
            public void addAfter(T element,T atual);


    
}
