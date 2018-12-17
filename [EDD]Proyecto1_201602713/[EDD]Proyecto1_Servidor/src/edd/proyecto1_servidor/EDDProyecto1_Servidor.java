/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.proyecto1_servidor;

import Interfaz.inter;

/**
 *
 * @author pablo
 */
public class EDDProyecto1_Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Estructuras.MatrizDispersa md = new Estructuras.MatrizDispersa();
        Interfaz.inter i = new inter();
        
        /*
        md.insertar(1, 1, "blue");
        md.insertar(2, 1, "blue");
        md.insertar(3, 1, "blue");
        md.insertar(3, 2, "blue");
        md.insertar(3, 3, "blue");
        md.insertar(4, 3, "blue");
        md.insertar(5, 3, "blue");
        md.insertar(6, 3, "blue");
        md.insertar(7, 3, "blue");
        md.insertar(8, 3, "blue");
        md.insertar(8, 4, "blue");
        md.insertar(8, 5, "blue");
        md.insertar(8, 6, "blue");
        md.insertar(8, 7, "blue");
        md.insertar(8, 8, "blue");
        md.insertar(9, 3, "blue");
        md.insertar(10, 3, "blue");
        
        md.insertar(1, 2, "darkgreen");
        md.insertar(1, 3, "darkgreen");
        md.insertar(1, 7, "darkgreen");
        md.insertar(1, 8, "darkgreen");
        md.insertar(2, 7, "darkgreen");
        md.insertar(2, 8, "darkgreen");
        md.insertar(3, 7, "darkgreen");
        md.insertar(3, 8, "darkgreen");
        md.insertar(4, 7, "darkgreen");
        md.insertar(4, 8, "darkgreen");
        
        md.insertar(1, 4, "green");
        md.insertar(2, 2, "green");
        md.insertar(2, 3, "green");
        md.insertar(2, 4, "green");
        md.insertar(3, 4, "green");
        md.insertar(4, 1, "green");
        md.insertar(4, 2, "green");
        md.insertar(4, 4, "green");
        md.insertar(5, 2, "green");
        md.insertar(5, 4, "green");
        md.insertar(6, 2, "green");
        md.insertar(6, 4, "green");
        md.insertar(7, 2, "green");
        md.insertar(7, 4, "green");
        md.insertar(7, 5, "green");
        md.insertar(7, 6, "green");
        md.insertar(7, 7, "green");
        md.insertar(7, 8, "green");
        md.insertar(8, 2, "green");
        md.insertar(9, 2, "green");
        md.insertar(10, 2, "green");
        
        md.insertar(1, 5, "gray");
        md.insertar(1, 6, "gray");
        md.insertar(2, 5, "gray");
        md.insertar(2, 6, "gray");
        md.insertar(3, 5, "gray");
        md.insertar(3, 6, "gray");
        md.insertar(4, 5, "gray");
        md.insertar(4, 6, "gray");
        md.insertar(5, 5, "gray");
        md.insertar(5, 6, "gray");
        md.insertar(5, 7, "gray");
        md.insertar(5, 8, "gray");
        md.insertar(6, 5, "gray");
        md.insertar(6, 6, "gray");
        md.insertar(6, 7, "gray");
        md.insertar(6, 8, "gray");
        
        md.insertar(5, 1, "brown");
        md.insertar(6, 1, "brown");
        md.insertar(7, 1, "brown");
        md.insertar(8, 1, "brown");
        md.insertar(9, 1, "brown");
        md.insertar(9, 4, "brown");
        md.insertar(9, 5, "brown");
        md.insertar(9, 6, "brown");
        md.insertar(9, 7, "brown");
        md.insertar(9, 8, "brown");
        md.insertar(10, 1, "brown");
        md.insertar(10, 4, "brown");
        md.insertar(10, 5, "brown");
        md.insertar(10, 6, "brown");
        md.insertar(10, 7, "brown");
        md.insertar(10, 8, "brown");*/
        /*
        md.insertar(1, 3, "C1L3");
        md.insertar(3, 3, "C3L3");
        md.insertar(3, 2, "C3L2");
        md.insertar(1, 2, "C1L2");
        md.insertar(2, 2, "C2L2");
        md.insertar(2, 1, "C2L1");
        md.insertar(1, 1, "C1L1");
        md.insertar(2, 3, "C2L3");
        md.insertar(3, 1, "C3L1");
        
        md.insertar(1, 2, "C1L2");
        md.insertar(1, 1, "C1L1");
        md.insertar(1, 4, "C1L4");
        md.insertar(1, 3, "C1L3");*/
        
        md.mostrarFyC();
        md.graficar();
    }
    
}
