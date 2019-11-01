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
public class MainListADT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException {
        // TODO code application logic here

        ArrayList lista1 = new ArrayList();
        
        int teste = 3;
        
        switch (teste) {
            case 0: //teste removeFirst com array vazio

                System.out.println(lista1.removeFirst());
                System.out.println(lista1.toString());
                
                break;
            
            case 1: //teste removeFirst com array com 1 elemento
                lista1.add(1);
                System.out.println(lista1.toString());
                System.out.println(lista1.removeFirst());
                System.out.println(lista1.toString());
                
                break;
                
                case 2: //teste removeFirst com array com alguns
                lista1.add(1);
                lista1.add(2);

                System.out.println(lista1.toString());
                System.out.println(lista1.removeFirst());
                System.out.println(lista1.toString());
                
                break;
                
                case 3: //teste removeFirst com array cheio
                lista1.add(1);
                lista1.add(2);
                lista1.add(3);

                System.out.println(lista1.toString());
                System.out.println(lista1.removeFirst());
                System.out.println(lista1.toString());
                
                break;
        }
    }
    
}
