package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Iterator;

public class LlistaExemplars extends Llista<Exemplar> implements Serializable {

    public LlistaExemplars() {super();}

    /**
     * Metode para afegir un exemplar a la llista correspondent
     * @param exemplar
     * @throws BiblioException
     */

    @Override
    public void afegir(Exemplar exemplar) throws BiblioException {

        if(exemplar == null){
            throw new BiblioException("L'exemplar no pot ser nul");
        }else{
            Iterator<Exemplar> itr = this.llista.iterator();
            while(itr.hasNext()){
                Exemplar temp = itr.next();
                if(temp.getId().equals(exemplar.getId())){
                    throw new BiblioException("No es pot afegir dos exemplars amb el mateix Id");
                }
            }
            llista.add(exemplar);
        }
    }

    /**
     * Metode per verificar si un llibre amb la mateixa ID ja existeix a la llista.
     * @param id_
     * @return
     */

    public boolean contains(String id_){

        Iterator<Exemplar> itr = this.llista.iterator();
        while(itr.hasNext()){
            Exemplar tmp = itr.next();
            if(tmp.getId().equals(id_)){
                return true;
            }
        }
        return false;
    }
}
