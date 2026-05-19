package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Dades implements InDades, Serializable {

    private LlistaExemplars LlistaExemplars;
    private LlistaUsuaris LlistaUsuaris;
    private LlistaPrestecs LlistaPrestecs;

    public Dades(){
        LlistaExemplars = new LlistaExemplars();
        LlistaUsuaris = new LlistaUsuaris();
        LlistaPrestecs = new LlistaPrestecs();
    }

    @Override
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {

        LlistaExemplars.afegir(new Exemplar(id, titol, autor, admetPrestecLlarg));
    }

    @Override
    public ArrayList<Exemplar> recuperaExemplars() {
        return LlistaExemplars.getArrayList();
    }

    @Override
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {

        if(esEstudiant) {
            LlistaUsuaris.afegir(new Estudiant(email, nom, adreca));
        }else{
            LlistaUsuaris.afegir(new Professor(email, nom, adreca));
        }
    }

    @Override
    public ArrayList<Usuari> recuperaUsuaris() {
        return LlistaUsuaris.getArrayList();
    }

    @Override
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {

        if(exemplarPos < 0 || exemplarPos >= LlistaExemplars.getSize() || usuariPos < 0 || usuariPos >= LlistaUsuaris.getSize()){
            throw new BiblioException("Una o dues de les posicions no són vàlides");
        }

        Exemplar exemplar = LlistaExemplars.getAt(exemplarPos);
        Usuari user = LlistaUsuaris.getAt(usuariPos);

        if(!exemplar.isDisponible()){
            throw new BiblioException("Aquest exemplar no està disponible.");
        }

        if(!exemplar.getAdmetPrestecLlarg() && esLlarg){
            throw new BiblioException("No es pot demanar aquest tipus de préstec");
        }

        Date ara = new Date();
        Iterator<Prestec> itr = LlistaPrestecs.getArrayList().iterator();
        while(itr.hasNext()){
            Prestec p = itr.next();
            if(p.getUsuari().equals(user) && !p.getRetornat() && p.prestecEndarrerit()){
                throw new BiblioException("L'usuari té préstecs endarrerits y no puede pedir más.");
            }
        }

        if(esLlarg){
            if(user.getNumPrestecsLlargs() >= user.getMaxPrestecsLlargs()){
                throw new BiblioException("Aquest usuari no pot demanar altre préstec llarg");
            }
            LlistaPrestecs.afegir(new PrestecLlarg(exemplar, user, new Date()));
            user.setNumPrestecsLlargs(user.getNumPrestecsLlargs() + 1);
        }else{
            if(user.getNumPrestecsNormals() >= user.getMaxPrestecsNormals()){
                throw new BiblioException("Aquest usuari no pot demanar altre préstec normal");
                }
            LlistaPrestecs.afegir(new PrestecNormal(exemplar, user, new Date()));
            user.setNumPrestecsNormals(user.getNumPrestecsNormals() + 1);
            }

        exemplar.setDisponible(false);
    }

    @Override
    public void retornarPrestec(int position) throws BiblioException {

        if(position < 0 || position >= LlistaPrestecs.getSize()){
            throw new BiblioException("Aquesta posició no és vàlida");
        }

        Prestec prestec = LlistaPrestecs.getAt(position);

        if(prestec.getRetornat()){
            throw new BiblioException("Aquest préstec ja ha sigut retornat");
        }

        prestec.setRetornat(true);
        prestec.getExemplar().setDisponible(true);

        Usuari user = prestec.getUsuari();

        if(prestec instanceof PrestecLlarg){
            user.setNumPrestecsLlargs(user.getNumPrestecsLlargs() - 1);
        }else{
            user.setNumPrestecsNormals(user.getMaxPrestecsNormals() - 1);
        }
    }

    @Override
    public ArrayList<Prestec> recuperaPrestecs() {
        return LlistaPrestecs.getArrayList();
    }

    @Override
    public ArrayList<Prestec> recuperaPrestecsNoRetornats() {

        Iterator<Prestec> itr = LlistaPrestecs.getArrayList().iterator();
        ArrayList<Prestec> noRetornats = new ArrayList<>();

        while(itr.hasNext()){
            Prestec p = itr.next();
            if(!p.getRetornat()){
                noRetornats.add(p);
            }
        }
        return noRetornats;
    }
}
