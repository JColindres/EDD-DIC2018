/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author pablo
 */
class NodoMDX {
    int columna;
    int capa;/*
    int posx;
    int posy;
    String tipo;
    int id;
    String tipo_tropa;*/
    NodoMDX siguiente;
    NodoMDX abajo;
    
    NodoMDX (int columna, int capa){
        this.columna = columna;
        this.capa = capa;
        NodoMDX siguiente = null;
        NodoMDX abajo = null;
        
    }
}

class NodoMDY {
    int fila;
    NodoMDY siguiente;
    NodoMDY derecha;
    
    NodoMDY (int fila){
        this.fila = fila;
        NodoMDY siguiente = null;
        NodoMDY derecha = null;
        
    }
}

public class MatrizDispersa {
    NodoMDX columnas;
    NodoMDY filas;
    
    public void tamanioX(int x){
        int cont = 1;
        NodoMDX aux = columnas;
        NodoMDX temp = null;
        
        while(cont < x + 1 ){
            if(temp == null && columnas == null){
                NodoMDX nuevo = new NodoMDX(cont, 0);
                columnas = nuevo;
                aux = columnas;
            }
            else if(aux == null){
                NodoMDX nuevo = new NodoMDX(cont, 0);
                aux = nuevo;
                temp.siguiente = aux;
            }
            temp = aux;
            aux = aux.siguiente;
            cont++;
        } 
    }
    
    public void tamanioY(int y){
        int cont = 1;
        NodoMDY aux = filas;
        NodoMDY temp = null;
        
        while(cont < y + 1){
            if(temp == null && filas == null){
                NodoMDY nuevo = new NodoMDY(cont);
                filas = nuevo;
                aux = filas;
            }
            else if(aux == null){
                NodoMDY nuevo = new NodoMDY(cont);
                aux = nuevo;
                temp.siguiente = aux;
            }
            temp = aux;
            aux = aux.siguiente;
            cont++;
        } 
    }
    
    public void mostrarFyC(){
        NodoMDX auxx = columnas;
        NodoMDY auxy = filas;
        
        System.out.print("   ");
        while(auxx != null){
            System.out.print("["+auxx.columna+"]");
            auxx = auxx.siguiente;
        }
        System.out.println("");
        
        while(auxy != null){
            System.out.println("["+auxy.fila+"]");
            auxy = auxy.siguiente;
        }
    }
    
    public void insertar(){
        
    }
}
