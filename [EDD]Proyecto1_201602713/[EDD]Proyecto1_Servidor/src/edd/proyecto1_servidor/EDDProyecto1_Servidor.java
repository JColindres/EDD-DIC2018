/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.proyecto1_servidor;
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
        md.insertar(1, 1);
        md.insertar(3, 1);
        md.insertar(2, 2);
        md.insertar(3, 2);
        md.insertar(3, 3);
        md.mostrarFyC();
        md.graficar();
    }
    
}
