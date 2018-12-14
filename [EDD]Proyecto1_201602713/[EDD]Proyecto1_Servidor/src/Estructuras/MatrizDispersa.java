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
    NodoMDX siguiente;
    NodoMDX anterior;
    Celda abajo;

    NodoMDX(int columna) {
        this.columna = columna;
        siguiente = null;
        anterior = null;
        abajo = null;
    }
}

class NodoMDY {

    int fila;
    NodoMDY siguiente;
    NodoMDY anterior;
    Celda derecha;

    NodoMDY(int fila) {
        this.fila = fila;
        siguiente = null;
        anterior = null;
        derecha = null;
    }
}

class Celda {

    int capa;
    int posx;
    int posy;
    String tipo;
    int id;
    String tipo_tropa;
    Celda arriba;
    Celda abajo;
    Celda derecha;
    Celda izquierda;

    Celda(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
        arriba = null;
        abajo = null;
        derecha = null;
        izquierda = null;
    }
}

public class MatrizDispersa {

    NodoMDX columnas;
    NodoMDX ultimox;
    NodoMDY filas;
    NodoMDY ultimoy;

    public void insertar(int x, int y) {
        Celda celda = new Celda(x, y);
        NodoMDX nuevox = new NodoMDX(x);
        NodoMDX auxx = columnas;
        NodoMDX tempx = null;

        if (columnas == null) {
            columnas = nuevox;
            ultimox = columnas;
        } else if (columnas.siguiente == null) {
            if (nuevox.columna < columnas.columna) {
                nuevox.siguiente = columnas;
                nuevox.anterior = null;
                columnas.anterior = nuevox;
                columnas = nuevox;
            } else if (nuevox.columna > columnas.columna) {
                ultimox.siguiente = nuevox;
                nuevox.anterior = ultimox;
                ultimox = nuevox;
            }
        } else {
            while (auxx != null) {
                if (nuevox.columna < columnas.columna) {
                    nuevox.siguiente = columnas;
                    columnas = nuevox;
                    break;
                }
                if (nuevox.columna > auxx.columna && auxx.siguiente == null) {
                    ultimox.siguiente = nuevox;
                    nuevox.anterior = ultimox;
                    ultimox = nuevox;
                    break;
                } else if (nuevox.columna > auxx.columna && nuevox.columna < auxx.siguiente.columna) {
                    nuevox.siguiente = auxx.siguiente;
                    nuevox.anterior = auxx;
                    auxx.siguiente = nuevox;
                    break;
                } else {
                    auxx = auxx.siguiente;
                }
            }
        }

    }

    /*
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
     */
    public void mostrarFyC() {
        NodoMDX auxx = columnas;
        NodoMDY auxy = filas;

        System.out.print("   ");
        while (auxx != null) {
            System.out.print("[" + auxx.columna + "]");
            auxx = auxx.siguiente;
        }
        System.out.println("");

        while (auxy != null) {
            System.out.println("[" + auxy.fila + "]");
            auxy = auxy.siguiente;
        }
    }

}
