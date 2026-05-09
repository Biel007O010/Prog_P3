/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import prog2.vista.BiblioException;

public class Llista<T> implements Serializable, InLlista<T> {
   protected ArrayList<T> llista;

   public Llista() {
       llista = new ArrayList<>();
    }

    /**
     * Retornar nombre d'elements continguts a la llista
     */
    public int getSize(){
          return llista.size();
    }

    /**
     * Afegir element a la llista. Afegeix l'element t a la llista
     */
    public void afegir(T t) throws BiblioException {

        if(t == null){
            throw new BiblioException("L'elemente no correspond a aquesta classe");
        }else{
            llista.add(t);
        }
    }

    /**
     * Esborrar element de la llista. Esborra l'element t a la llista
     */
    public void esborrar(T t) {

        Iterator<T> itr = this.llista.iterator();

        while(itr.hasNext()){
            T temp = itr.next();
            if(temp.equals(t)){
                itr.remove();
            }
        }
    }

    /**
     * Retornar element de la llista a la posició position
     */
    public T getAt(int position) {

        if(position >= 0 && position < llista.size()){
            return llista.get(position);
        }
        return null;
    }

    /**
     * Buidar tots el elements de la llista
     */
    public void clear() {
        llista.clear();
    }

    /**
     * Retornar true si la llista és buida
     */
    public boolean isEmpty() {
        return llista.isEmpty();
    }

    /**
     * Retornar l'ArrayList que es fa servir dins de la classe
     */
    public ArrayList<T> getArrayList() {
        ArrayList<T> arrlist = new ArrayList<>(llista);
        return arrlist;
    }
}
