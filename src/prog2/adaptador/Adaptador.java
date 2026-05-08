package prog2.adaptador;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import prog2.model.Dades;
import prog2.model.Exemplar;
import prog2.model.Prestec;
import prog2.model.Usuari;
import prog2.vista.BiblioException;

public class Adaptador {
    private Dades dades;

    public Adaptador(){
        this.dades = new Dades();
    }

    public void guardaDades(String camiDesti) throws BiblioException{
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(camiDesti))) {
            oos.writeObject(this.dades);
        } catch (IOException e) {
            throw new BiblioException("Error al guardar les dades: " + e.getMessage());
        }
    }

    public void carregaDades(String camiOrigen) throws BiblioException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(camiOrigen))) {
            this.dades = (Dades) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new BiblioException("Error al carregar les dades: " + e.getMessage());
        }
    }

    public ArrayList<String> recuperaExemplars(){
        ArrayList<String> llistaStrings = new ArrayList<>();
        ArrayList<Exemplar> exemplars = dades.recuperaExemplars();
        Iterator<Exemplar> itr = exemplars.iterator();
        while (itr.hasNext()){
            llistaStrings.add(itr.next().toString());
        }
        return llistaStrings;
    }

    public ArrayList<String> recuperaUsuaris(){
        ArrayList<String> llistaStrings = new ArrayList<>();
        ArrayList<Usuari> usuaris = dades.recuperaUsuaris();
        Iterator<Usuari> itr = usuaris.iterator();
        while (itr.hasNext()){
            llistaStrings.add(itr.next().toString());
        }
        return llistaStrings;
    }

    public ArrayList<String> recuperaPrestecs(){
        ArrayList<String> llistaStrings = new ArrayList<>();
        ArrayList<Prestec> prestecs = dades.recuperaPrestecs();
        Iterator<Prestec> itr = prestecs.iterator();
        while (itr.hasNext()){
            llistaStrings.add(itr.next().toString());
        }
        return llistaStrings;
    }

    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        dades.afegirExemplar(id, titol, autor, admetPrestecLlarg);
    }

    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
        dades.afegirUsuari(email, nom, adreca, esEstudiant);
    }

    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {
        dades.afegirPrestec(exemplarPos, usuariPos, esLlarg);
    }

    public void retornarPrestec(int position) throws BiblioException {
        dades.retornarPrestec(position);
    }
}
