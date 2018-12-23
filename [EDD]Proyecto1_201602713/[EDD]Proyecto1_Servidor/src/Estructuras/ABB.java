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

    NodoABB(int id, int posx, int posy, String tipo) {
        this.id = id;
        this.posx = posx;
        this.posy = posy;
        this.tipo = tipo;
        izquierda = null;
        derecha = null;
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
            } else {
                ant.derecha = nuevo;
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

    public void preOrder(NodoABB r) {
        if (r != null) {
            System.out.print(r.id + ", ");
            preOrder(r.izquierda);
            preOrder(r.derecha);
        }
    }

    public void inOrder(NodoABB r) {
        if (r != null) {
            inOrder(r.izquierda);
            System.out.print(r.id + ", ");
            inOrder(r.derecha);
        }
    }

    public void posOrder(NodoABB r) {
        if (r != null) {
            posOrder(r.izquierda);
            posOrder(r.derecha);
            System.out.print(r.id + ", ");

        }
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
            tropas = tropas + r.posx + "," + r.posy + "," + r.tipo + "\n";
            textoTropas(r.izquierda);
            textoTropas(r.derecha);
        }
    } 
    
    public void enviarJ1(){
        try {
            tropas = "";
            textoTropas(jugador1);
            asa.mensajeJ1(tropas);
            asa.enviartropa1();
        } catch (Exception ex) {
            Logger.getLogger(ABB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarJ2(){
        try {
            tropas = "";
            textoTropas(jugador2);
            asa.mensajeJ2(tropas);
            asa.enviartropa2();
        } catch (Exception ex) {
            Logger.getLogger(ABB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
