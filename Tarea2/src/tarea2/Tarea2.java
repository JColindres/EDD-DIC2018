/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2;

/**
 *
 * @author pablo
 */
class Nodo {

    int valor;
    Nodo siguiente;
    /****Constructor de la ESTRUCTURA*****/
    Nodo(int valor) {
        this.valor = valor;
    }
}

public class Tarea2 {

    /**
     * @param args the command line arguments
     */
    Nodo pila;  //Hacemos instanica de la clase de la estructura 

    /****Metodo para insertar un valor a la pila****/
    public void push(int valor) {
        Nodo nuevo = new Nodo(valor);  //Creamos nuevo nodo con el valor a insertar
        if (pila == null) { //Verificamos si la pila esta vacia
            pila = nuevo;  //El tope de la pila es el nuevo elemento
            pila.siguiente = null; //Apuntamos el siguiente a nulo para indicar el fondo de la pila
        } else { //Si la pila ya tiene elementos:
            nuevo.siguiente = pila;  //Apuntamos el siguiente al TOPE de la pila
            pila = nuevo; //Ahora el nuevo elemento pasa a ser el TOPE de la pila
        }
    }
    /****Metodo para eliminar un elemento de la pila****/
    public void pop() {
        if (pila != null) { //verificamos que la pila no este vacia
            pila = pila.siguiente;  //El tope de la pila ahora es el siguiente elemento y el tope se libera del espacio en memoria
        }
    }
    /****Metodo para mostrar el primer elemento de la pila (retorna el valor)****/
    public int peek() {
        if (pila != null) { //verificamos que la pila no este vacia
            return pila.valor; //retormanos el valor que contiene el tope
        }
        return 0; //En caso de estar vacia retornamos 0
    }
    /****Metodo para mostrar todos los elementos de la pila****/
    public void mostrar() {
        Nodo aux = pila; //creamos un nodo auxiliar para recorrer la pila y no perder los elementos
        while (aux != null) { //recorremos la pila mientras esta contenga elementos
            System.out.println(aux.valor); //imprimos el valor que contenga en ese momento;
            aux = aux.siguiente; //pasamos al siguiente elemento de la pila
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Tarea2 p = new Tarea2();
        p.push(1); //insertamos un 1
        p.push(2); //insertamos un 2
        p.push(3); //insertamos un 3
        p.push(5); //insertamos un 4
        System.out.println("Los elementos de toda la pila son: ");
        p.mostrar(); //mostramos la lista completa
        System.out.println("El primer elemento de la pila es: " + p.peek());
        p.pop(); //eliminamos el ultimo valor en entrar a la pila
        System.out.println("Eliminamos el primer elemento de la pila");
        p.mostrar(); // mostramos la lista completa
        System.out.println("Ahora el primar elemento de la pila es: " + p.peek());
        
    }

}
