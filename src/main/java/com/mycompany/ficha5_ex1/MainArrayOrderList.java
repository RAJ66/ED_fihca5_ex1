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
public class MainArrayOrderList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ArrayOrderedList<String> lista1 = new ArrayOrderedList();

        int teste = 0;

        switch (teste) {
            case 0: //teste removeFirst com elementos na lista
                lista1.add("D");
                lista1.add("B");
                lista1.add("A");
                lista1.add("C");

                Iterator it = lista1.iterator();

                while (it.hasNext()) {
                    String obj = (String) it.next();
                    System.out.println(obj);
                }
                break;
        }
    }
}
