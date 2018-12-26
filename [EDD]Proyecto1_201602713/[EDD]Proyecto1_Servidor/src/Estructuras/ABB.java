/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Interfaz.inter;
import edd.proyecto1_servidor.EDDProyecto1_Servidor;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    public String consola = "";
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
                if (id < reco.id) {
                    reco = reco.izquierda;
                } else {
                    reco = reco.derecha;
                }
            }
            if (id < ant.id) {
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
                if (id < reco.id) {
                    reco = reco.izquierda;
                } else {
                    reco = reco.derecha;
                }
            }
            if (id < ant.id) {
                ant.izquierda = nuevo;
            } else {
                ant.derecha = nuevo;
            }
        }
    }

    public void modificar() {
        try {
            EDDProyecto1_Servidor eee = new EDDProyecto1_Servidor();
            eee.actualizarPosJugadorI();
            eee.actualizarPosJugadorF();
            eee.actualizarPosJugadorID();
            Thread.sleep(500);
            String posI = eee.posI();
            String posF = eee.posF();
            String jugador = eee.jugador();

            String[] pos1 = posI.split(",");
            int posxI = Integer.parseInt(pos1[0]);
            int posyI = Integer.parseInt(pos1[1]);

            String[] pos2 = posF.split(",");
            int posxF = Integer.parseInt(pos2[0]);
            int posyF = Integer.parseInt(pos2[1]);

            if ("1".equals(jugador)) {
                cambiarPos(posxI, posyI, posxF, posyF, jugador1);
            } else {
                cambiarPos(posxI, posyI, posxF, posyF, jugador2);
            }

        } catch (Exception ex) {
            Logger.getLogger(ABB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cambiarPos(int posxI, int posyI, int posxF, int posyF, NodoABB j) {
        if (j != null) {
            if (j.posx == posxI && j.posy == posyI) {
                if ((posxI == posxF && Math.abs(posyF - posyI) <= j.alca_mov) || (posyI == posyF && Math.abs(posxF - posxI) <= j.alca_mov)) {
                    j.posx = posxF;
                    j.posy = posyF;
                    consola = "Se movio " + j.tipo + " de la posicion " + posxI + "," + posyI + " a la posicion " + posxF + "," + posyF;
                } else {
                    JOptionPane.showMessageDialog(null, "Movimiento no permitido");
                }
            } else {
                cambiarPos(posxI, posyI, posxF, posyF, j.izquierda);
                cambiarPos(posxI, posyI, posxF, posyF, j.derecha);
            }
        }
    }

    public void atacar() {
        try {
            EDDProyecto1_Servidor eee = new EDDProyecto1_Servidor();
            eee.ataquePosJugadorI();
            eee.ataquePosJugadorF();
            eee.ataquePosJugadorID();
            eee.ataqueDano1();
            eee.ataqueDano2();
            Thread.sleep(500);
            String posI = eee.posI();
            String posF = eee.posF();
            String jugador = eee.jugador();
            double dano1 = Double.parseDouble(eee.dano1());
            double dano2 = Double.parseDouble(eee.dano2());

            String[] pos1 = posI.split(",");
            int posxI = Integer.parseInt(pos1[0]);
            int posyI = Integer.parseInt(pos1[1]);

            String[] pos2 = posF.split(",");
            int posxF = Integer.parseInt(pos2[0]);
            int posyF = Integer.parseInt(pos2[1]);

            if ("1".equals(jugador)) {
                consola = "";
                cambiarVida(posxI, posyI, posxF, posyF, dano1, jugador2, jugador);
                cambiarVida(posxF, posyF, posxI, posyI, dano2, jugador1, "2");
            } else {
                consola = "";
                cambiarVida(posxI, posyI, posxF, posyF, dano1, jugador1, jugador);
                cambiarVida(posxF, posyF, posxI, posyI, dano2, jugador2, "1");
            }

        } catch (Exception ex) {
            Logger.getLogger(ABB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cambiarVida(int posxI, int posyI, int posxF, int posyF, double dano, NodoABB j, String jugador) {
        if (j != null) {
            if (j.posx == posxF && j.posy == posyF && j.vida > 0) {
                if ((posxI == posxF && Math.abs(posyF - posyI) <= j.alca_ata) || (posyI == posyF && Math.abs(posxF - posxI) <= j.alca_ata)) {
                    j.vida = (int) (j.vida - (dano));
                    if (j.vida > 0) {
                        consola = consola + "El jugador de la posicion " + posxI + "," + posyI + " ataco a la tropa " + j.tipo + " de la posicion " + posxF + "," + posyF + " dejandolo a " + j.vida + " de vida\n";
                    } else {
                        if (jugador.equals("1")) {
                            jugadorEliminado(j.id, jugador2);
                            consola = consola + "El jugador de la posicion " + j.posx + "," + j.posy + " murio \n";
                        } else {
                            jugadorEliminado(j.id, jugador1);
                            consola = consola + "El jugador de la posicion " + j.posx + "," + j.posy + " murio \n";
                        }
                    }
                } else {
                    consola = consola + "El jugador no esta al alcance de contraataque \n";
                }
            } else if (j.posx == posxF && j.posy == posyF && j.vida <= 0) {
                consola = consola + "El jugador no puede contraatacar porque murio \n";
            } else {
                cambiarVida(posxI, posyI, posxF, posyF, dano, j.izquierda, jugador);
                cambiarVida(posxI, posyI, posxF, posyF, dano, j.derecha, jugador);
            }
        }
    }

    public boolean jugadorEliminado(int id, NodoABB j) {
        NodoABB aux = j;
        NodoABB padre = j;
        boolean esHijoIzq = true;
        while (aux.id != id) {
            padre = aux;
            if (id < aux.id) {
                esHijoIzq = true;
                aux = aux.izquierda;
            } else {
                esHijoIzq = false;
                aux = aux.derecha;
            }
            if (aux == null) {
                return false;
            }
        }
        if (aux.izquierda == null && aux.derecha == null) {
            if (aux == j) {
                j = null;
            } else if (esHijoIzq) {
                padre.izquierda = null;
            } else {
                padre.derecha = null;
            }
        } else if (aux.derecha == null) {
            if (aux == j) {
                j = aux.izquierda;
            } else if (esHijoIzq) {
                padre.izquierda = aux.izquierda;
            } else {
                padre.derecha = aux.izquierda;
            }
        } else if (aux.izquierda == null) {
            if (aux == j) {
                j = aux.derecha;
            } else if (esHijoIzq) {
                padre.izquierda = aux.derecha;
            } else {
                padre.derecha = aux.derecha;
            }
        } else {
            NodoABB reemplazo = obtenerR(aux);
            if (aux == j) {
                j = reemplazo;
            } else if (esHijoIzq) {
                padre.izquierda = reemplazo;
            } else {
                padre.derecha = reemplazo;
            }
            reemplazo.izquierda = aux.izquierda;
        }
        return true;
    }

    public NodoABB obtenerR(NodoABB nR) {
        NodoABB reemP = nR;
        NodoABB reemplazo = nR;
        NodoABB aux = nR.derecha;
        while (aux != null) {
            reemP = reemplazo;
            reemplazo = aux;
            aux = aux.izquierda;
        }
        if (reemplazo != nR.derecha) {
            reemP.izquierda = reemplazo.derecha;
            reemplazo.derecha = nR.derecha;
        }
        return reemplazo;
    }

    public void graficarJ1(String label) {
        if (jugador1 != null) {

            FileWriter fichero = null;
            PrintWriter pw = null;
            try {
                fichero = new FileWriter(label + ".txt");
                pw = new PrintWriter(fichero);

                resultado = ("digraph G{\n");
                resultado = resultado + "node[color = \"" + "orange" + "\";style = filled]\n";
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
                String command = "dot -Tjpg " + label + ".txt -o " + label + ".jpg";
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
                fichero = new FileWriter(label + ".txt");
                pw = new PrintWriter(fichero);

                resultado = ("digraph G{\n");
                resultado = resultado + "node[color = \"" + "orange" + "\";style = filled]\n";
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
                String command = "dot -Tjpg " + label + ".txt -o " + label + ".jpg";
                Process child = Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                System.out.println("ex: " + e.getMessage());
            }
        }
    }

    public void textoTropas(NodoABB r) {
        if (r != null) {
            tropas = tropas + r.posx + "," + r.posy + "," + r.tipo + "," + r.id + "," + r.alca_ata + "," + r.alca_mov + "," + r.ataque + "," + r.vida + "\n";
            textoTropas(r.izquierda);
            textoTropas(r.derecha);
        }
    }

    public void enviarJ1() {
        try {
            tropas = "";
            textoTropas(jugador1);
            asa.mensajeJ1(tropas);
            asa.enviartropa1();
        } catch (Exception ex) {
            Logger.getLogger(ABB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarJ2() {
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
