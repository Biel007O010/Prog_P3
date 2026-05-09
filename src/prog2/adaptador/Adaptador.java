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

    /**
     * Constructor
     */
    public Adaptador(){
        this.dades = new Dades();
    }

    /**
     * Metode per guardar les dades
     * @param camiDesti
     * @throws BiblioException
     */
    public void guardaDades(String camiDesti) throws BiblioException{
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(camiDesti))) {
            oos.writeObject(this.dades);
        } catch (IOException e) {
            throw new BiblioException("Error al guardar les dades: " + e.getMessage());
        }
    }

    /**
     * Metode per carregar les dades
     * @param camiOrigen
     * @throws BiblioException
     */
    public void carregaDades(String camiOrigen) throws BiblioException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(camiOrigen))) {
            this.dades = (Dades) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new BiblioException("Error al carregar les dades: " + e.getMessage());
        }
    }

    /**
     * Metode adaptat per recuperar els exemplars en una llista de Strings
     * @return
     */
    public ArrayList<String> recuperaExemplars(){
        ArrayList<String> llistaStrings = new ArrayList<>();
        ArrayList<Exemplar> exemplars = dades.recuperaExemplars();
        Iterator<Exemplar> itr = exemplars.iterator();
        while (itr.hasNext()){
            llistaStrings.add(itr.next().toString());
        }
        return llistaStrings;
    }

    /**
     * Metode adaptat per recuperar els usuaris en una llista de Strings
     * @return
     */
    public ArrayList<String> recuperaUsuaris(){
        ArrayList<String> llistaStrings = new ArrayList<>();
        ArrayList<Usuari> usuaris = dades.recuperaUsuaris();
        Iterator<Usuari> itr = usuaris.iterator();
        while (itr.hasNext()){
            llistaStrings.add(itr.next().toString());
        }
        return llistaStrings;
    }

    /**
     * Metode adaptat per recuperar els prestecs en una llista de Strings
     * @return
     */
    public ArrayList<String> recuperaPrestecs(){
        ArrayList<String> llistaStrings = new ArrayList<>();
        ArrayList<Prestec> prestecs = dades.recuperaPrestecs();
        Iterator<Prestec> itr = prestecs.iterator();
        while (itr.hasNext()){
            llistaStrings.add(itr.next().toString());
        }
        return llistaStrings;
    }

    /**
     * Metode adaptat per recuperar els prestecs no retornats en una llista de Strings
     * @return
     */
    public ArrayList<String> recuperaPrestecsNoRetornats(){
        ArrayList<String> llistaStrings = new ArrayList<>();
        ArrayList<Prestec> prestecsNoRetornats = dades.recuperaPrestecsNoRetornats();
        Iterator<Prestec> itr = prestecsNoRetornats.iterator();
        while (itr.hasNext()){
            llistaStrings.add(itr.next().toString());
        }
        return llistaStrings;
    }

    /**
     * Metode adaptat per afegir un exemplar
     * @param id
     * @param titol
     * @param autor
     * @param admetPrestecLlarg
     * @throws BiblioException
     */
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        dades.afegirExemplar(id, titol, autor, admetPrestecLlarg);
    }

    /**
     * Metode adaptat per afegir un usuari
     * @param email
     * @param nom
     * @param adreca
     * @param esEstudiant
     * @throws BiblioException
     */
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
        dades.afegirUsuari(email, nom, adreca, esEstudiant);
    }

    /**
     * Metode adaptat per afegir un prestec
     * @param exemplarPos
     * @param usuariPos
     * @param esLlarg
     * @throws BiblioException
     */
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {
        dades.afegirPrestec(exemplarPos, usuariPos, esLlarg);
    }

    /**
     * Metode adaptat per retornar un prestec
     * @param position
     * @throws BiblioException
     */
    public void retornarPrestec(int position) throws BiblioException {
        dades.retornarPrestec(position);
    }
}
