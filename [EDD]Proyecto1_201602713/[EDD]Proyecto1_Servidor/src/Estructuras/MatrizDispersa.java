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
import java.io.*;

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
        NodoMDY nuevoy = new NodoMDY(y);
        NodoMDY auxy = filas;

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
                else if (nuevox.columna > auxx.columna && auxx.siguiente == null) {
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

        if (filas == null) {
            filas = nuevoy;
            ultimoy = filas;
        } else if (filas.siguiente == null) {
            if (nuevoy.fila < filas.fila) {
                nuevoy.siguiente = filas;
                nuevoy.anterior = null;
                filas.anterior = nuevoy;
                filas = nuevoy;
            } else if (nuevoy.fila > filas.fila) {
                ultimoy.siguiente = nuevoy;
                nuevoy.anterior = ultimoy;
                ultimoy = nuevoy;
            }
        } else {
            while (auxy != null) {
                if (nuevoy.fila < filas.fila) {
                    nuevoy.siguiente = filas;
                    filas = nuevoy;
                    break;
                }
                if (nuevoy.fila > auxy.fila && auxy.siguiente == null) {
                    ultimoy.siguiente = nuevoy;
                    nuevoy.anterior = ultimoy;
                    ultimoy = nuevoy;
                    break;
                } else if (nuevoy.fila > auxy.fila && nuevoy.fila < auxy.siguiente.fila) {
                    nuevoy.siguiente = auxy.siguiente;
                    nuevoy.anterior = auxy;
                    auxy.siguiente = nuevoy;
                    break;
                } else {
                    auxy = auxy.siguiente;
                }
            }
        }

        auxy = filas;
        while (auxy != null) {
            auxx = columnas;
            while (auxx != null) {
                Celda auxCeldax = auxx.abajo;
                Celda auxCelday = auxy.derecha;

                if (auxx.columna == celda.posx && auxy.fila == celda.posy) {
                    if (auxx.abajo == null && auxy.derecha == null) {
                        auxx.abajo = celda;
                        auxy.derecha = celda;
                        celda.arriba = auxx.abajo;
                        celda.izquierda = auxy.derecha;
                    } else if (auxx.abajo == null && auxy.derecha != null) {
                        while (auxCelday.derecha != null) {
                            auxCelday = auxCelday.derecha;
                        }
                        auxCelday.derecha = celda;
                        auxx.abajo = celda;
                        celda.arriba = auxx.abajo;
                        celda.izquierda = auxCelday;
                    } else if (auxx.abajo != null && auxy.derecha == null) {
                        while (auxCeldax.abajo != null) {
                            auxCeldax = auxCeldax.abajo;
                        }
                        auxCeldax.abajo = celda;
                        auxy.derecha = celda;
                        celda.izquierda = auxy.derecha;
                        celda.arriba = auxCeldax;
                    } else {
                        while (auxCelday.derecha != null) {
                            auxCelday = auxCelday.derecha;
                        }
                        while (auxCeldax.abajo != null) {
                            auxCeldax = auxCeldax.abajo;
                        }
                        auxCelday.derecha = celda;
                        auxCeldax.abajo = celda;
                        celda.izquierda = auxCelday;
                        celda.arriba = auxCeldax;
                    }
                }
                auxx = auxx.siguiente;
            }
            auxy = auxy.siguiente;
        }
    }

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

        auxy = filas;
        while (auxy != null) {
            auxx = columnas;
            while (auxx != null) {
                System.out.print("(" + auxx.columna + "," + auxy.fila + ")");
                auxx = auxx.siguiente;
            }
            System.out.println("");
            auxy = auxy.siguiente;
        }
    }

    public void graficar() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("MD.txt");
            pw = new PrintWriter(fichero);

            NodoMDX auxx = columnas;
            NodoMDY auxy = filas;
            String rank = "";
            pw.println("digraph G {\n m[shape=square;label=\"Matriz\";group = 0];");
            while (auxx != null) {

                pw.println("x" + auxx.columna + "[shape=square;label=\"" + auxx.columna + "\";group=" + auxx.columna + "];");
                rank = rank + ";x" + auxx.columna;
                if (auxx == columnas) {
                    pw.println("m->x" + auxx.columna + ";");
                } else {
                    pw.println("x" + auxx.anterior.columna + "->" + "x" + auxx.columna + ";");
                    pw.println("x" + auxx.columna + "->" + "x" + auxx.anterior.columna + ";");
                }
                auxx = auxx.siguiente;
            }
            pw.println("{rank = same; m" + rank + "}");

            while (auxy != null) {

                pw.println("y" + auxy.fila + "[shape=square;label=\"" + auxy.fila + "\";group=" + 0 + "];");
                if (auxy == filas) {
                    pw.println("m->y" + auxy.fila + ";");
                } else {
                    pw.println("y" + auxy.anterior.fila + "->" + "y" + auxy.fila + ";");
                    pw.println("y" + auxy.fila + "->" + "y" + auxy.anterior.fila + ";");
                }
                auxy = auxy.siguiente;
            }
            auxy = filas;
            while (auxy != null) {
                Celda auxCelday = auxy.derecha;
                rank = "";
                
                while (auxCelday != null) {
                    pw.println(auxCelday.posx + "" + auxCelday.posy + "[shape=square; label = \"0\"; group =" + auxCelday.posx + "];");
                    rank = rank + ";" + auxCelday.posx + "" + auxCelday.posy;
                    
                    if (auxCelday == auxy.derecha) {
                        pw.println("y" + auxCelday.posy + "->" + auxCelday.posx + "" + auxCelday.posy + ";");
                        pw.println(auxCelday.posx + "" + auxCelday.posy + "->" + "y" + auxCelday.posy + ";");
                    
                    } else if (auxCelday.izquierda.posx != auxCelday.posx) {
                        pw.println(auxCelday.izquierda.posx + "" + auxCelday.izquierda.posy + "->" + auxCelday.posx + "" + auxCelday.posy + ";");
                        pw.println(auxCelday.posx + "" + auxCelday.posy + "->" + auxCelday.izquierda.posx + "" + auxCelday.izquierda.posy + ";");
                    
                    }
                    auxx = columnas;
                    while (auxx != null) {
                        if (auxCelday == auxx.abajo) {
                            pw.println("x" + auxCelday.posx + "->" + auxCelday.posx + "" + auxCelday.posy + ";");
                            pw.println(auxCelday.posx + "" + auxCelday.posy + "->" + "x" + auxCelday.posx + ";");
                            break;
                        } else if (auxCelday.arriba.posy != auxCelday.posy) {
                            pw.println(auxCelday.arriba.posx + "" + auxCelday.arriba.posy + "->" + auxCelday.posx + "" + auxCelday.posy + ";");
                            pw.println(auxCelday.posx + "" + auxCelday.posy + "->" + auxCelday.arriba.posx + "" + auxCelday.arriba.posy + ";");
                            break;
                        }
                        auxx = auxx.siguiente;
                    }
                    pw.println("{rank = same; y" + auxy.fila + rank + "}");
                    auxCelday = auxCelday.derecha;
                }
                auxy = auxy.siguiente;
            }
            pw.println("}");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        try {
            String command = "dot -Tjpg MD.txt -o MD.jpg";
            Process child = Runtime.getRuntime().exec(command);
            //command = "start MD.jpg";
            //child = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            System.out.println("ex: " + e.getMessage());
        }
    }
}
