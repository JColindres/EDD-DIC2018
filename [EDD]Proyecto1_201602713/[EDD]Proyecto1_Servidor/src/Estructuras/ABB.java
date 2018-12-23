/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import edd.proyecto1_servidor.EDDProyecto1_Servidor;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
class NodoABB {

    int id;
    int posx;
    int posy;
    String tipo;
    int vida;
    int alca_mov;
    int ataque;
    int alca_ata;
    NodoABB izquierda;
    NodoABB derecha;
    NodoABB padre;

    NodoABB(int id, int posx, int posy, String tipo) {
        this.id = id;
        this.posx = posx;
        this.posy = posy;
        this.tipo = tipo;
        izquierda = null;
        derecha = null;
        padre = null;
    }
    
    public NodoABB getPadre() {
        return padre;
    }
 
    public void setPadre(NodoABB padre) {
        this.padre = padre;
    }

}

public class ABB {

    public NodoABB jugador1;
    public NodoABB jugador2;
    int cont = 0;
    String resultado;
    String tropas = "";
    EDDProyecto1_Servidor asa = new EDDProyecto1_Servidor();

    public void insertarJ1(int id, int x, int y, String tipo) {
        NodoABB nuevo = new NodoABB(id, x, y, tipo);
        switch (tipo) {
            case "infanteria":
                nuevo.vida = 50;
                nuevo.alca_mov = 3;
                nuevo.ataque = 30;
                nuevo.alca_ata = 1;
                break;
            case "infanteriam":
                nuevo.vida = 50;
                nuevo.alca_mov = 2;
                nuevo.ataque = 50;
                nuevo.alca_ata = 3;
                break;
            case "reconocimiento":
                nuevo.vida = 100;
                nuevo.alca_mov = 6;
                nuevo.ataque = 50;
                nuevo.alca_ata = 2;
                break;
            case "tanque":
                nuevo.vida = 150;
                nuevo.alca_mov = 4;
                nuevo.ataque = 80;
                nuevo.alca_ata = 2;
                break;
            case "mtanque":
                nuevo.vida = 200;
                nuevo.alca_mov = 3;
                nuevo.ataque = 100;
                nuevo.alca_ata = 2;
                break;
            case "artilleria":
                nuevo.vida = 50;
                nuevo.alca_mov = 3;
                nuevo.ataque = 150;
                nuevo.alca_ata = 6;
                break;
            default:
                break;
        }
        if (jugador1 == null) {
            jugador1 = nuevo;
        } else {
            NodoABB ant = null, reco;
            reco = jugador1;
            while (reco != null) {
                ant = reco;
                if (id <= reco.id) {
                    reco = reco.izquierda;
                } else {
                    reco = reco.derecha;
                }
            }
            if (id <= ant.id) {
                ant.izquierda = nuevo;
                nuevo.setPadre(ant);
            } else {
                ant.derecha = nuevo;
                nuevo.setPadre(ant);
            }
        }
    }
    
    public void insertarJ2(int id, int x, int y, String tipo) {
        NodoABB nuevo = new NodoABB(id, x, y, tipo);
        switch (tipo) {
            case "infanteria":
                nuevo.vida = 50;
                nuevo.alca_mov = 3;
                nuevo.ataque = 30;
                nuevo.alca_ata = 1;
                break;
            case "infanteriam":
                nuevo.vida = 50;
                nuevo.alca_mov = 2;
                nuevo.ataque = 50;
                nuevo.alca_ata = 3;
                break;
            case "reconocimiento":
                nuevo.vida = 100;
                nuevo.alca_mov = 6;
                nuevo.ataque = 50;
                nuevo.alca_ata = 2;
                break;
            case "tanque":
                nuevo.vida = 150;
                nuevo.alca_mov = 4;
                nuevo.ataque = 80;
                nuevo.alca_ata = 2;
                break;
            case "mtanque":
                nuevo.vida = 200;
                nuevo.alca_mov = 3;
                nuevo.ataque = 100;
                nuevo.alca_ata = 2;
                break;
            case "artilleria":
                nuevo.vida = 50;
                nuevo.alca_mov = 3;
                nuevo.ataque = 150;
                nuevo.alca_ata = 6;
                break;
            default:
                break;
        }
        if (jugador2 == null) {
            jugador2 = nuevo;
        } else {
            NodoABB ant = null, reco;
            reco = jugador2;
            while (reco != null) {
                ant = reco;
                if (id <= reco.id) {
                    reco = reco.izquierda;
                } else {
                    reco = reco.derecha;
                }
            }
            if (id <= ant.id) {
                ant.izquierda = nuevo;
            } else {
                ant.derecha = nuevo;
            }
        }
    }

    public void modificar(){
        try {
            asa.actualizarPosJugador();
        } catch (Exception ex) {
            Logger.getLogger(ABB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public boolean removeNodo(NodoABB nodo) {
 
        /* Creamos variables para saber si tiene hijos izquierdo y derecho */
        boolean tieneNodoDerecha = nodo.derecha != null ? true : false;
        boolean tieneNodoIzquierda = nodo.izquierda != null ? true : false;
 
        /* Verificamos los 3 casos diferentes y llamamos a la función correspondiente */
 
        /* Caso 1: No tiene hijos */
        if (!tieneNodoDerecha && !tieneNodoIzquierda) {
            return removeNodoCaso1( nodo );
        }
 
        /* Caso 2: Tiene un hijo y el otro no */
        if ( tieneNodoDerecha && !tieneNodoIzquierda ) {
            return removeNodoCaso2( nodo );
        }
 
        /* Caso 2: Tiene un hijo y el otro no */
        if ( !tieneNodoDerecha && tieneNodoIzquierda ) {
            return removeNodoCaso2( nodo );
        }
 
        /* Caso 3: Tiene ambos hijos */
        if ( tieneNodoDerecha && tieneNodoIzquierda ) {
            return removeNodoCaso3( nodo );
        }
 
        return false;
    }
 
    private boolean removeNodoCaso1( NodoABB nodo ) {
        /* lo único que hay que hacer es borrar el nodo y establecer el apuntador de su padre a nulo */
 
        /*
         * Guardemos los hijos del padre temporalmente para saber cuál de sus hijos hay que 
         * eliminar
         */
        NodoABB hijoIzquierdo = nodo.getPadre().izquierda;
        NodoABB hijoDerecho = nodo.getPadre().derecha;
 
        if ( hijoIzquierdo == nodo ) {
            nodo.getPadre().izquierda = ( null );
            return true;
        }
 
        if ( hijoDerecho == nodo) {
            nodo.getPadre().derecha = ( null );
            return true;
        }
 
        return false;
    }
 
    private boolean removeNodoCaso2( NodoABB nodo ) {
        /* Borrar el Nodo y el subárbol que tenía pasa a ocupar su lugar */
 
        /*
         * Guardemos los hijos del padre temporalmente para saber cuál de sus hijos hay que 
         * eliminar
         */
        NodoABB hijoIzquierdo = nodo.getPadre().izquierda;
        NodoABB hijoDerecho = nodo.getPadre().derecha;
 
        /*
         * Buscamos el hijo existente del nodo que queremos eliminar
         */
        NodoABB hijoActual = nodo.izquierda != null ? 
                nodo.izquierda : nodo.derecha;
 
        if ( hijoIzquierdo == nodo ) {
            nodo.getPadre().izquierda = ( hijoActual );
 
            /* Eliminando todas las referencias hacia el nodo */
            hijoActual.setPadre(nodo.getPadre());
            nodo.derecha = (null);
            nodo.izquierda = (null);
 
            return true;
        }
 
        if ( hijoDerecho == nodo) {
            nodo.getPadre().derecha = ( hijoActual );
 
            /* Eliminando todas las referencias hacia el nodo */
            hijoActual.setPadre(nodo.getPadre());
            nodo.derecha = (null);
            nodo.izquierda = (null);
 
            return true;
        } 
 
        return false;
    }
 
    private boolean removeNodoCaso3( NodoABB nodo ) {
        /* Tomar el hijo derecho del Nodo que queremos eliminar */
        NodoABB nodoMasALaIzquierda = recorrerIzquierda( nodo.derecha );
        if ( nodoMasALaIzquierda != null ) {
            /*
             * Reemplazamos el valor del nodo que queremos eliminar por el nodo que encontramos 
             */
            nodo = ( nodoMasALaIzquierda );
            /* 
             * Eliminar este nodo de las formas que conocemos ( caso 1, caso 2 ) 
             */
            removeNodo( nodoMasALaIzquierda  );
            return true;
        }
        return false;
    }
 
    /* Recorrer de forma recursiva hasta encontrar el nodo más a la izquierda */
    private NodoABB recorrerIzquierda(NodoABB nodo) {
        if (nodo.izquierda != null) {
            return recorrerIzquierda( nodo.izquierda );
        }
        return nodo;
    }

    public void graficarJ1(String label) {
        if (jugador1 != null) {

            FileWriter fichero = null;
            PrintWriter pw = null;
            try {
                fichero = new FileWriter(label+".txt");
                pw = new PrintWriter(fichero);

                resultado = ("digraph G{\n");
                resultado = resultado + "node[color = \""+"orange"+"\";style = filled]\n";
                resultado = resultado + ("C" + jugador1.posx + "L" + jugador1.posy + "[label=\"" + "Posicion x: " + jugador1.posx + "\n" + "Posicion y: " + jugador1.posy + "\n" + "Vida: " + jugador1.vida + "\n" + "Alcance Movimiento: " + jugador1.alca_mov + "\n" + "Ataque: " + jugador1.ataque + "\n" + "Alcance Ataque: " + jugador1.alca_ata + "\n" + "\"];\n");
                graficar1(jugador1);
                resultado = resultado + ("}\n");
                pw.print(resultado);
                //System.out.println(resultado);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != fichero) {
                        fichero.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            try {
                String command = "dot -Tjpg "+label+".txt -o "+label+".jpg";
                Process child = Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                System.out.println("ex: " + e.getMessage());
            }
        }
    }

    public void graficar1(NodoABB r) {
        if (r != null) {
            if (r.izquierda != null) {
                resultado = resultado + ("C" + r.izquierda.posx + "L" + r.izquierda.posy + "[label=\"" + "Posicion x: " + r.izquierda.posx + "\n" + "Posicion y: " + r.izquierda.posy + "\n" + "Vida: " + r.izquierda.vida + "\n" + "Alcance Movimiento: " + r.izquierda.alca_mov + "\n" + "Ataque: " + r.izquierda.ataque + "\n" + "Alcance Ataque: " + r.izquierda.alca_ata + "\n" + "\"];\n");
                resultado = resultado + ("C" + r.posx + "L" + r.posy + "->" + "C" + r.izquierda.posx + "L" + r.izquierda.posy + "\n");
            }
            if (r.derecha != null) {
                resultado = resultado + ("C" + r.derecha.posx + "L" + r.derecha.posy + "[label=\"" + "Posicion x: " + r.derecha.posx + "\n" + "Posicion y: " + r.derecha.posy + "\n" + "Vida: " + r.derecha.vida + "\n" + "Alcance Movimiento: " + r.derecha.alca_mov + "\n" + "Ataque: " + r.derecha.ataque + "\n" + "Alcance Ataque: " + r.derecha.alca_ata + "\n" + "\"];\n");
                resultado = resultado + ("C" + r.posx + "L" + r.posy + "->" + "C" + r.derecha.posx + "L" + r.derecha.posy + "\n");
            }
            graficar1(r.izquierda);
            graficar1(r.derecha);
        }

    }
    
    public void graficarJ2(String label) {
        if (jugador2 != null) {

            FileWriter fichero = null;
            PrintWriter pw = null;
            try {
                fichero = new FileWriter(label+".txt");
                pw = new PrintWriter(fichero);

                resultado = ("digraph G{\n");
                resultado = resultado + "node[color = \""+"orange"+"\";style = filled]\n";
                resultado = resultado + ("C" + jugador2.posx + "L" + jugador2.posy + "[label=\"" + "Posicion x: " + jugador2.posx + "\n" + "Posicion y: " + jugador2.posy + "\n" + "Vida: " + jugador2.vida + "\n" + "Alcance Movimiento: " + jugador2.alca_mov + "\n" + "Ataque: " + jugador2.ataque + "\n" + "Alcance Ataque: " + jugador2.alca_ata + "\n" + "\"];\n");
                graficar1(jugador2);
                resultado = resultado + ("}\n");
                pw.print(resultado);
                //System.out.println(resultado);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != fichero) {
                        fichero.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            try {
                String command = "dot -Tjpg "+label+".txt -o "+label+".jpg";
                Process child = Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                System.out.println("ex: " + e.getMessage());
            }
        }
    }


    public void textoTropas(NodoABB r){
        if (r != null) {
            tropas = tropas + r.posx + "," + r.posy + "," + r.tipo + "," + r.id + "\n";
            textoTropas(r.izquierda);
            textoTropas(r.derecha);
        }
    } 
    
    public void enviarJ12(){
        try {
            tropas = "";
            textoTropas(jugador1);
            asa.mensajeJ1(tropas);
            asa.enviartropa12();
            tropas = "";
            textoTropas(jugador2);
            asa.mensajeJ2(tropas);
            asa.enviartropa12();
        } catch (Exception ex) {
            Logger.getLogger(ABB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
