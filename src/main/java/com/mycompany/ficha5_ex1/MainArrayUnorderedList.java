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
public class MainArrayUnorderedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayUnorderedList<String> lista1 = new ArrayUnorderedList();

        int teste = 0;

        switch (teste) {
            case 0: //teste de ordenar alguns elementos
                lista1.addToRear("D");
                lista1.addToRear("B");
                lista1.addToRear("A");
                lista1.addToRear("C");

                Iterator it = lista1.iterator();

                while (it.hasNext()) {
                    String obj = (String) it.next();
                    System.out.println(obj);
                }
                break;
        
        
    }
    
}
