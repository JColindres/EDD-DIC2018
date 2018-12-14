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
        //md.tamanioX(5);
        //md.tamanioY(8);
        md.insertar(7, 1);
        md.insertar(4, 1);
        md.insertar(6, 1);
        md.mostrarFyC();
    }
    
}
