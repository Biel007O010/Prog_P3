package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.nio.file.attribute.UserPrincipal;
import java.util.Iterator;

public class LlistaUsuaris extends Llista<Usuari> implements Serializable {

    public LlistaUsuaris(){super();}

    public void afegir(Usuari user) throws BiblioException {

        if(user == null){
            throw new BiblioException("L'usuari no pot ser nul");
        }else{
            Iterator<Usuari> itr = this.llista.iterator();
            while(itr.hasNext()){
                Usuari temp = itr.next();
                if(temp.getEmail().equals(user.getEmail())){
                    throw new BiblioException("No es pot afegir dos exemplars amb el mateix Id");
                }
            }
            llista.add(user);
        }
    }

    public boolean contains(String email_){

        Iterator<Usuari> itr = this.llista.iterator();
        while(itr.hasNext()){
            Usuari tmp = itr.next();
            if(tmp.getEmail().equals(email_)){
                return true;
            }
        }
        return false;
    }
}
