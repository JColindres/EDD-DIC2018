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
import edd.proyecto1_servidor.EDDProyecto1_Servidor;
import java.io.*;

class Matriz {

    NodoMDX cabeceraC;
    NodoMDY cabeceraF;
    int capa;

    public Matriz(NodoMDX cabeceraC, NodoMDY cabecaraF) {
        this.cabeceraC = cabeceraC;
        this.cabeceraF = cabecaraF;
    }
}

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

    int posx;
    int posy;
    String tipo;
    Celda arriba;
    Celda abajo;
    Celda derecha;
    Celda izquierda;

    Celda(int posx, int posy, String tipo) {
        this.posx = posx;
        this.posy = posy;
        this.tipo = tipo;
        arriba = null;
        abajo = null;
        derecha = null;
        izquierda = null;
    }
}

class ListaCapas {

    ListaCapas siguiente;
    ListaCapas anterior;
    int capa;
    Matriz matriz;

    ListaCapas(int capa, Matriz matriz) {
        this.siguiente = null;
        this.anterior = null;
        this.capa = capa;
        this.matriz = matriz;
    }

}

public class MatrizDispersa {

    NodoMDX columnas;
    NodoMDX ultimox;
    NodoMDY filas;
    NodoMDY ultimoy;
    Matriz m;
    ListaCapas inicio;
    //public String tablero;

    EDDProyecto1_Servidor asa = new EDDProyecto1_Servidor();

    public void insertar(int x, int y, String tipo) {
        Celda celda = new Celda(x, y, tipo);
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
                    columnas.anterior = nuevox;
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
                    auxx.siguiente.anterior = nuevox;
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
                    filas.anterior = nuevoy;
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
                    auxy.siguiente.anterior = nuevoy;
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
                        while (auxCelday != null) {
                            if (celda.posx < auxCelday.posx) {
                                celda.derecha = auxCelday;
                                celda.izquierda = auxy.derecha;
                                auxCelday.izquierda = celda;
                                celda.arriba = auxx.abajo;
                                auxy.derecha = celda;
                                break;
                            } else if (celda.posx > auxCelday.posx && auxCelday.derecha == null) {
                                auxCelday.derecha = celda;
                                auxx.abajo = celda;
                                celda.arriba = auxx.abajo;
                                celda.izquierda = auxCelday;
                                break;
                            } else if (celda.posx > auxCelday.posx && celda.posx < auxCelday.derecha.posx) {
                                celda.izquierda = auxCelday;
                                celda.derecha = auxCelday.derecha;
                                auxCelday.derecha.izquierda = celda;
                                auxCelday.derecha = celda;
                                celda.arriba = auxx.abajo;
                                auxx.abajo = celda;
                                break;
                            } else if (celda.posx == auxCelday.posx && celda.posy == auxCelday.posy) {
                                auxCelday.tipo = celda.tipo;
                                break;
                            } else {
                                auxCelday = auxCelday.derecha;
                            }
                        }
                    } else if (auxx.abajo != null && auxy.derecha == null) {
                        while (auxCeldax != null) {
                            if (celda.posy < auxCeldax.posy) {
                                celda.abajo = auxCeldax;
                                auxx.abajo = celda;
                                auxCeldax.arriba = celda;
                                celda.arriba = auxx.abajo;
                                auxy.derecha = celda;
                                celda.izquierda = auxy.derecha;
                                break;
                            } else if (celda.posy > auxCeldax.posy && auxCeldax.abajo == null) {
                                auxCeldax.abajo = celda;
                                auxy.derecha = celda;
                                celda.izquierda = auxy.derecha;
                                celda.arriba = auxCeldax;
                                break;
                            } else if (celda.posy > auxCeldax.posy && celda.posy < auxCeldax.abajo.posy) {
                                celda.arriba = auxCeldax;
                                celda.abajo = auxCeldax.abajo;
                                auxCeldax.abajo.arriba = celda;
                                auxCeldax.abajo = celda;
                                celda.izquierda = auxy.derecha;
                                auxy.derecha = celda;
                                break;
                            } else if (celda.posx == auxCeldax.posx && celda.posy == auxCeldax.posy) {
                                auxCeldax.tipo = celda.tipo;
                                break;
                            } else {
                                auxCeldax = auxCeldax.abajo;
                            }
                        }
                    } else {
                        while (auxCelday != null) {
                            if (celda.posx < auxCelday.posx) {
                                celda.derecha = auxCelday;
                                celda.izquierda = auxy.derecha;
                                auxCelday.izquierda = celda;
                                auxy.derecha = celda;
                                break;
                            } else if (celda.posx > auxCelday.posx && auxCelday.derecha == null) {
                                auxCelday.derecha = celda;
                                celda.izquierda = auxCelday;
                                break;
                            } else if (celda.posx > auxCelday.posx && celda.posx < auxCelday.derecha.posx) {
                                celda.izquierda = auxCelday;
                                celda.derecha = auxCelday.derecha;
                                auxCelday.derecha.izquierda = celda;
                                auxCelday.derecha = celda;
                                break;
                            } else if (celda.posx == auxCelday.posx && celda.posy == auxCelday.posy) {
                                auxCelday.tipo = celda.tipo;
                                break;
                            } else {
                                auxCelday = auxCelday.derecha;
                            }
                        }
                        while (auxCeldax != null) {
                            if (celda.posy < auxCeldax.posy) {
                                celda.abajo = auxCeldax;
                                auxx.abajo = celda;
                                auxCeldax.arriba = celda;
                                celda.arriba = auxx.abajo;
                                break;
                            } else if (celda.posy > auxCeldax.posy && auxCeldax.abajo == null) {
                                auxCeldax.abajo = celda;
                                celda.arriba = auxCeldax;
                                break;
                            } else if (celda.posy > auxCeldax.posy && celda.posy < auxCeldax.abajo.posy) {
                                celda.arriba = auxCeldax;
                                celda.abajo = auxCeldax.abajo;
                                auxCeldax.abajo.arriba = celda;
                                auxCeldax.abajo = celda;
                                break;
                            } else if (celda.posx == auxCeldax.posx && celda.posy == auxCeldax.posy) {
                                auxCeldax.tipo = celda.tipo;
                                break;
                            } else {
                                auxCeldax = auxCeldax.abajo;
                            }
                        }
                    }
                }
                auxx = auxx.siguiente;
            }
            auxy = auxy.siguiente;
        }

    }

    public void agregarCapa(MatrizDispersa matriz, String capa) {
        int c = Integer.parseInt(capa);
        ListaCapas nuevo = new ListaCapas(c, matriz.m);
        if (inicio == null) {
            inicio = nuevo;
            inicio.siguiente = inicio;
            inicio.anterior = inicio;
        } else {
            ListaCapas aux = inicio;
            while ((aux.siguiente != inicio) && (aux.capa < c)) {
                aux = aux.siguiente;
            }
            if ((aux.siguiente == inicio) && (aux.capa < c)) {
                aux.siguiente = nuevo;
                nuevo.anterior = aux;
                nuevo.siguiente = inicio;
                inicio.anterior = nuevo;
            } else {
                ListaCapas ant = aux.anterior;
                nuevo.anterior = ant;
                ant.siguiente = nuevo;
                nuevo.siguiente = aux;
                aux.anterior = nuevo;
                if ((aux == inicio) && (inicio.capa > c)) {
                    inicio = nuevo;
                }
            }
        }
    }

    public void eliminarCapa(String capa) {
        if (inicio != null) {
            ListaCapas aux = inicio;
            ListaCapas ant = null;
            do{
                if (aux.capa == Integer.parseInt(capa)) {
                    if (ant == null) {
                        if (aux.siguiente == inicio) {
                            inicio = null;
                        } else {
                            ant = aux.anterior;
                            ant.siguiente = aux.siguiente;
                            aux = aux.siguiente;
                            aux.anterior = ant;
                            inicio = aux;
                            ant = null;
                        }
                    } else {
                        aux.anterior = null;
                        ant.siguiente = aux.siguiente;
                        aux = aux.siguiente;
                        aux.anterior = ant;
                    }
                } else {
                    ant = aux;
                    aux = aux.siguiente;
                }
            }while(aux != inicio);
        }
    }
    
    public void graficar(String capa) {
        m = new Matriz(columnas, filas);
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("MD" + capa + ".txt");
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
                    pw.println("y" + auxy.anterior.fila + "->" + "y" + auxy.fila + "[dir=back];");
                }
                auxy = auxy.siguiente;
            }
            auxy = filas;
            while (auxy != null) {
                Celda auxCelday = auxy.derecha;
                rank = "";

                while (auxCelday != null) {
                    pw.println("C" + auxCelday.posx + "L" + auxCelday.posy + "[shape=square; label = \"" + "\"; color=" + auxCelday.tipo + "; style = filled; group =" + auxCelday.posx + "];");
                    rank = rank + ";" + "C" + auxCelday.posx + "L" + auxCelday.posy;

                    if (auxCelday == auxy.derecha) {
                        pw.println("y" + auxCelday.posy + "->" + "C" + auxCelday.posx + "L" + auxCelday.posy + ";");
                        pw.println("y" + auxCelday.posy + "->" + "C" + auxCelday.posx + "L" + auxCelday.posy + "[dir=back];");

                    } else if (auxCelday.izquierda.posx != auxCelday.posx) {
                        pw.println("C" + auxCelday.izquierda.posx + "L" + auxCelday.izquierda.posy + "->" + "C" + auxCelday.posx + "L" + auxCelday.posy + ";");
                        pw.println("C" + auxCelday.izquierda.posx + "L" + auxCelday.izquierda.posy + "->" + "C" + auxCelday.posx + "L" + auxCelday.posy + "[dir=back];");

                    }
                    auxx = columnas;
                    while (auxx != null) {
                        Celda auxCeldax = auxx.abajo;
                        while (auxCeldax != null) {
                            if (auxCelday == auxx.abajo) {
                                pw.println("x" + auxCelday.posx + "->" + "C" + auxCelday.posx + "L" + auxCelday.posy + ";");
                                pw.println("x" + auxCelday.posx + "->" + "C" + auxCelday.posx + "L" + auxCelday.posy + "[dir=back];");
                                break;
                            } else if (auxCelday == auxCeldax) {
                                pw.println("C" + auxCeldax.arriba.posx + "L" + auxCeldax.arriba.posy + "->" + "C" + auxCeldax.posx + "L" + auxCeldax.posy + ";");
                                pw.println("C" + auxCeldax.arriba.posx + "L" + auxCeldax.arriba.posy + "->" + "C" + auxCeldax.posx + "L" + auxCeldax.posy + "[dir=back];");
                                break;
                            }
                            auxCeldax = auxCeldax.abajo;
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
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        try {
            String command = "dot -Tjpg MD" + capa + ".txt -o MD" + capa + ".jpg";
            Process child = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            System.out.println("ex: " + e.getMessage());
        }

        fichero = null;
        pw = null;
        try {
            fichero = new FileWriter("MDF" + capa + ".txt");
            pw = new PrintWriter(fichero);

            NodoMDY auxy = filas;
            pw.println("digraph G {\n node[shape=square, style=filled, height=1, width=1];");

            while (auxy != null) {
                Celda auxCelda = auxy.derecha;
                while (auxCelda != null) {
                    pw.println("C" + auxCelda.posx + "L" + auxCelda.posy + "[label=" + '"' + '"' + ", pos=" + '"' + auxCelda.posy * 70 + "," + auxCelda.posx * 70 + '"' + ", " + "fillcolor=" + auxCelda.tipo + "]");
                    auxCelda = auxCelda.derecha;
                }
                auxy = auxy.siguiente;
            }
            pw.println("}");

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
            String command = "neato -n -Tjpg MDF" + capa + ".txt -o MDF" + capa + ".jpg";
            Process child = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            System.out.println("ex: " + e.getMessage());
        }
    }

    public void prueba() {
        try {
            ListaCapas lc = inicio;
            MatrizDispersa matrizDefinitiva = new MatrizDispersa();
            do {
                NodoMDY auxy = lc.matriz.cabeceraF;
                while (auxy != null) {
                    Celda auxCelda = auxy.derecha;
                    while (auxCelda != null) {
                        matrizDefinitiva.insertar(auxCelda.posx, auxCelda.posy, auxCelda.tipo);
                        auxCelda = auxCelda.derecha;
                    }
                    System.out.println("");
                    auxy = auxy.siguiente;
                }
                lc = lc.siguiente;
            } while (lc != inicio);
            graficarDefinitiva(matrizDefinitiva);
            asa.mensajemapaC(columnasCliente(matrizDefinitiva));
            asa.mensajemapaF(filasCliente(matrizDefinitiva));
            asa.mensajemapa(mapaCliente(matrizDefinitiva));
            asa.enviarmapa();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void graficarDefinitiva(MatrizDispersa mdd) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("MD.txt");
            pw = new PrintWriter(fichero);

            NodoMDX auxx = mdd.columnas;
            NodoMDY auxy = mdd.filas;
            String rank = "";
            pw.println("digraph G {\n m[shape=square;label=\"Matriz\";group = 0];");
            while (auxx != null) {

                pw.println("x" + auxx.columna + "[shape=square;label=\"" + auxx.columna + "\";group=" + auxx.columna + "];");
                rank = rank + ";x" + auxx.columna;
                if (auxx == mdd.columnas) {
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
                if (auxy == mdd.filas) {
                    pw.println("m->y" + auxy.fila + ";");
                } else {
                    pw.println("y" + auxy.anterior.fila + "->" + "y" + auxy.fila + ";");
                    pw.println("y" + auxy.anterior.fila + "->" + "y" + auxy.fila + "[dir=back];");
                }
                auxy = auxy.siguiente;
            }
            auxy = mdd.filas;
            while (auxy != null) {
                Celda auxCelday = auxy.derecha;
                rank = "";

                while (auxCelday != null) {
                    pw.println("C" + auxCelday.posx + "L" + auxCelday.posy + "[shape=square; label = \"" + "\"; color=" + auxCelday.tipo + "; style = filled; group =" + auxCelday.posx + "];");
                    rank = rank + ";" + "C" + auxCelday.posx + "L" + auxCelday.posy;

                    if (auxCelday == auxy.derecha) {
                        pw.println("y" + auxCelday.posy + "->" + "C" + auxCelday.posx + "L" + auxCelday.posy + ";");
                        pw.println("y" + auxCelday.posy + "->" + "C" + auxCelday.posx + "L" + auxCelday.posy + "[dir=back];");

                    } else if (auxCelday.izquierda.posx != auxCelday.posx) {
                        pw.println("C" + auxCelday.izquierda.posx + "L" + auxCelday.izquierda.posy + "->" + "C" + auxCelday.posx + "L" + auxCelday.posy + ";");
                        pw.println("C" + auxCelday.izquierda.posx + "L" + auxCelday.izquierda.posy + "->" + "C" + auxCelday.posx + "L" + auxCelday.posy + "[dir=back];");

                    }
                    auxx = mdd.columnas;
                    while (auxx != null) {
                        Celda auxCeldax = auxx.abajo;
                        while (auxCeldax != null) {
                            if (auxCelday == auxx.abajo) {
                                pw.println("x" + auxCelday.posx + "->" + "C" + auxCelday.posx + "L" + auxCelday.posy + ";");
                                pw.println("x" + auxCelday.posx + "->" + "C" + auxCelday.posx + "L" + auxCelday.posy + "[dir=back];");
                                break;
                            } else if (auxCelday == auxCeldax) {
                                pw.println("C" + auxCeldax.arriba.posx + "L" + auxCeldax.arriba.posy + "->" + "C" + auxCeldax.posx + "L" + auxCeldax.posy + ";");
                                pw.println("C" + auxCeldax.arriba.posx + "L" + auxCeldax.arriba.posy + "->" + "C" + auxCeldax.posx + "L" + auxCeldax.posy + "[dir=back];");
                                break;
                            }
                            auxCeldax = auxCeldax.abajo;
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
        } catch (IOException e) {
            System.out.println("ex: " + e.getMessage());
        }
        fichero = null;
        pw = null;
        try {
            fichero = new FileWriter("MDF.txt");
            pw = new PrintWriter(fichero);

            NodoMDY auxy = mdd.filas;
            pw.println("digraph G {\n node[shape=square, style=filled, height=1, width=1];");

            while (auxy != null) {
                Celda auxCelda = auxy.derecha;
                while (auxCelda != null) {
                    pw.println("C" + auxCelda.posx + "L" + auxCelda.posy + "[label=" + '"' + '"' + ", pos=" + '"' + auxCelda.posy * 70 + "," + auxCelda.posx * 70 + '"' + ", " + "fillcolor=" + auxCelda.tipo + "]");
                    auxCelda = auxCelda.derecha;
                }
                auxy = auxy.siguiente;
            }
            pw.println("}");

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
            String command = "neato -n -Tjpg MDF.txt -o MDF.jpg";
            Process child = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            System.out.println("ex: " + e.getMessage());
        }
    }

    public String mapaCliente(MatrizDispersa mdd) {
        NodoMDY auxy = mdd.filas;
        String mapa = "";
        while (auxy != null) {
            Celda auxCelda = auxy.derecha;
            while (auxCelda != null) {
                mapa = mapa + auxCelda.posx + "," + auxCelda.posy + "," + auxCelda.tipo + "\n";
                auxCelda = auxCelda.derecha;
            }
            auxy = auxy.siguiente;
        }
        return mapa;
    }

    public int columnasCliente(MatrizDispersa mdd) {
        NodoMDX auxx = mdd.columnas;
        int numeroC = 0;
        while (auxx != null) {
            numeroC = auxx.columna;
            auxx = auxx.siguiente;
        }
        return numeroC;
    }

    public int filasCliente(MatrizDispersa mdd) {
        NodoMDY auxy = mdd.filas;
        int numeroF = 0;
        while (auxy != null) {
            numeroF = auxy.fila;
            auxy = auxy.siguiente;
        }
        return numeroF;
    }
}
