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
class NodoABB {
    int id;
    int posx;
    int posy;
    int vida;
    int alca_mov;
    int ataque;
    int alca_ata;
    NodoABB izquierda;
    NodoABB derecha;
    
    NodoABB (int id, int posx, int posy, int vida, int alca_mov, int ataque, int alca_ata){
        this.id = id;
        this.posx = posx;
        this.posy = posy;
        this.vida = vida;
        this.alca_mov = alca_mov;
        this.ataque = ataque;
        this.alca_ata = alca_ata;
        izquierda = null;
        derecha = null;
    }
    
}

public class ABB {
    
    NodoABB abb = null;
    
    
}
