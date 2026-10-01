package structures;

import java.util.NoSuchElementException;

public class ListaSimple<T> implements OperacionesEstructura<T> {
    private Nodo<T> head;
    private int tamano;
 
    public ListaSimple() {
        this.head = null;
        this.tamano = 0;
    }
 
    public boolean estaVacia() {
        return head == null;
    }
 
    public int getTamano() {
        return tamano;
    }
 
    public Nodo<T> getHead() {
        return head;
    }
 
    public void insertarInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(head);
        head = nuevo;
        tamano++;
    }
 
    public void insertarFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (estaVacia()) {
            head = nuevo;
        } else {
            Nodo<T> actual = head;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        tamano++;
    }
 
    public void insertarEnPosicion(int indice, T dato) {
        if (indice < 0 || indice > tamano) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + indice);
        }
        if (indice == 0) {
            insertarInicio(dato);
            return;
        }
        if (indice == tamano) {
            insertarFinal(dato);
            return;
        }
 
        Nodo<T> anterior = head;
        for (int i = 0; i < indice - 1; i++) {
            anterior = anterior.getSiguiente();
        }
 
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(anterior.getSiguiente());
        anterior.setSiguiente(nuevo);
        tamano++;
    }
 
    @Override
    public void crear(int indice, T dato) {
        insertarEnPosicion(indice, dato);
    }
 
    @Override
    public T buscarPorIndice(int indice) {
        if (indice < 0 || indice >= tamano) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + indice);
        }
        Nodo<T> actual = head;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }
 
    @Override
    public T buscarPorValor(T dato) {
        Nodo<T> actual = head;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Dato no encontrado");
        return null;
    }
 
    public void eliminarInicio() {
        if (estaVacia()) {
            throw new NoSuchElementException("No hay elementos para eliminar");
        }
        head = head.getSiguiente();
        tamano--;
    }
 
    public void eliminarFinal() {
        if (estaVacia()) {
            throw new NoSuchElementException("No hay elementos para eliminar");
        }
        if (head.getSiguiente() == null) {
            head = null;
            tamano--;
            return;
        }
        Nodo<T> actual = head;
        while (actual.getSiguiente().getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(null);
        tamano--;
    }
 
    @Override
    public void actualizar(int indice, T dato) {
        if (indice < 0 || indice >= tamano) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + indice);
        }
        Nodo<T> datoActual = this.head;
        for (int i = 0; i < indice; i++) {
            datoActual = datoActual.getSiguiente();
        }
        datoActual.setDato(dato);
    }
 
    public boolean eliminarPorValor(T dato) {
        if (estaVacia()) {
            System.out.println("No hay elementos para eliminar");
            return false;
        }
        if (head.getDato().equals(dato)) {
            head = head.getSiguiente();
            tamano--;
            return true;
        }
        Nodo<T> anterior = head;
        Nodo<T> actual = head.getSiguiente();
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                anterior.setSiguiente(actual.getSiguiente());
                tamano--;
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return false;
    }
 
    @Override
    public boolean eliminar(T dato) {
        return eliminarPorValor(dato);
    }
}
 
