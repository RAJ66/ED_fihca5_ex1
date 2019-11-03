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

        int teste = 2;

        switch (teste) {
            case 0: //teste de ordenar alguns elementos
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

            case 1: //teste de ordenar com todos os elemtos do array ocupados
                lista1.add("D");
                lista1.add("B");
                lista1.add("A");
                lista1.add("C");
                lista1.add("E");

                Iterator it2 = lista1.iterator();

                while (it2.hasNext()) {
                    String obj = (String) it2.next();
                    System.out.println(obj);
                }
                break;

            case 2: //teste de ordenar com todos os elemtos do array ocupados mais um para fazer expandCapacity do array
                lista1.add("D");
                lista1.add("B");
                lista1.add("A");
                lista1.add("C");
                lista1.add("E");
                lista1.add("G");
                lista1.add("F");

                Iterator it3 = lista1.iterator();

                while (it3.hasNext()) {
                    String obj = (String) it3.next();
                    System.out.println(obj);
                }
                break;
        }
    }
}
